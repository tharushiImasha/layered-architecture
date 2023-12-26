package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SqlUtil;
import lk.ijse.layeredarchitecture.dao.custom.OrderDetailDao;
import lk.ijse.layeredarchitecture.entity.OrderDetails;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetails entity) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", entity.getOrderId(),entity.getItemCode(),entity.getUnitPrice(),entity.getQty());
    }

    @Override
    public boolean update(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetails find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}
