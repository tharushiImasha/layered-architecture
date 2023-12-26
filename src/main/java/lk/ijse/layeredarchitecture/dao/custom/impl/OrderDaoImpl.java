package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SqlUtil;
import lk.ijse.layeredarchitecture.dao.custom.OrderDao;
import lk.ijse.layeredarchitecture.entity.Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {


    public boolean getOrderDetail(String orderId) throws SQLException, ClassNotFoundException {

        ResultSet rst =  SqlUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderId);
        return rst.next();

    }

    @Override
    public ArrayList<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", entity.getOrderId(), entity.getOrderDate(),entity.getCustomerId());
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
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

        ResultSet rst = SqlUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public Order find(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }
}
