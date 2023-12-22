package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomDto;

import java.sql.SQLException;

public interface QueryDao {
    void customerOrderDetails() throws SQLException, ClassNotFoundException;
}
