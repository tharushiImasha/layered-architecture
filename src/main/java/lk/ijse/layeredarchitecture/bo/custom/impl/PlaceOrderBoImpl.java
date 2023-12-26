package lk.ijse.layeredarchitecture.bo.custom.impl;

import lk.ijse.layeredarchitecture.bo.custom.PlaceOrderBo;
import lk.ijse.layeredarchitecture.dao.DaoFactory;
import com.example.layeredarchitecture.dao.custom.*;
import lk.ijse.layeredarchitecture.db.DBConnection;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.entity.Item;
import lk.ijse.layeredarchitecture.entity.Order;
import lk.ijse.layeredarchitecture.entity.OrderDetails;
import lk.ijse.layeredarchitecture.dao.custom.*;

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

        boolean isSaved = orderDao.save(new Order(orderId, orderDate, customerId, null, null));


        if (!isSaved) {
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }


        for (OrderDetailDTO detail : orderDetails) {
            boolean isOrderDetailSave = orderDetailDao.save(new OrderDetails(detail.getOrderId(),detail.getItemCode(),detail.getQty(),detail.getUnitPrice()));

            if (!isOrderDetailSave) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

//                //Search & Update Item
            ItemDTO item = findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            boolean isItemUpdate = itemDao.update(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

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
        Customer customer=customerDao.find(newValue);
        CustomerDTO customerDTO=new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }

    public ItemDTO findItem(String code) {
        try {
            Item item = itemDao.find(code);
            return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(), item.getQtyOnHand());

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
        ArrayList<Customer> customers=customerDao.getAll();
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer customer:customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return customerDTOS;
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items=itemDao.getAll();
        ArrayList<ItemDTO> itemDTOS=new ArrayList<>();
        for (Item item:items) {
            itemDTOS.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return itemDTOS;
    }
}
