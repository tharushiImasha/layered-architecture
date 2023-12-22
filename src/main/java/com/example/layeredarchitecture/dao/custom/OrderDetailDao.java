package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDao;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDao extends CrudDao<OrderDetailDTO> {
   // public boolean savaOrderDetail(OrderDetailDTO dto) throws SQLException, ClassNotFoundException;
}
