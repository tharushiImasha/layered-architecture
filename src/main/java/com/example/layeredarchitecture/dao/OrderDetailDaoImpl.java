package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{

    @Override
    public boolean savaOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

        stm.setString(1,dto.getOrderId());
        stm.setString(2,dto.getItemCode());
        stm.setBigDecimal(3,dto.getUnitPrice());
        stm.setInt(1,dto.getQty());

        return stm.executeUpdate() > 0;
    }
}
