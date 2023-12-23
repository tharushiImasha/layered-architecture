package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDao;
import com.example.layeredarchitecture.model.CustomDto;

import java.sql.SQLException;

public interface QueryDao extends SuperDao {
    void customerOrderDetails() throws SQLException, ClassNotFoundException;
}
