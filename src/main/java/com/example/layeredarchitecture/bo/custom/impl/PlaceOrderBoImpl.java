package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.PlaceOrderBo;
import com.example.layeredarchitecture.dao.DaoFactory;
import com.example.layeredarchitecture.dao.custom.*;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBoImpl implements PlaceOrderBo {

    ItemDao itemDao =(ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);
    OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER);
    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ORDER_DETAIL);
    QueryDao queryDAO= (QueryDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.QUERY);

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        connection = DBConnection.getDbConnection().getConnection();
        boolean isOrderExist = orderDao.exist(orderId);
        /*if order id already exist*/
        if (isOrderExist) {

        }

        connection.setAutoCommit(false);

        boolean isSaved = orderDao.save(new OrderDTO(orderId, orderDate, customerId, null, null));

        if (!isSaved) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


        for (OrderDetailDTO detail : orderDetails) {
            boolean isOrderDetailSave = orderDetailDao.save(detail);

            if (!isOrderDetailSave) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

//                //Search & Update Item
            ItemDTO item = findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            boolean isItemUpdate = itemDao.update(item);

            if (!isItemUpdate) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }

        connection.commit();
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDao.find(newValue);
    }

    public ItemDTO findItem(String code) {
        try {
            return itemDao.find(code);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDao.exist(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }

    @Override
    public String generateOrderId() throws SQLException, ClassNotFoundException {
        return orderDao.generateId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDao.getAll();
    }
}
