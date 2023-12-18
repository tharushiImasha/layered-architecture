package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDaoImpl implements OrderDetailDao{

    @Override
    public boolean savaOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", dto.getOrderId(),dto.getItemCode(),dto.getUnitPrice(),dto.getQty());
    }
}
