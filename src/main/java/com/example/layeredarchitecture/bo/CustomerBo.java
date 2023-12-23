package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo {
    boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException;

    void update(CustomerDTO dto) throws SQLException, ClassNotFoundException;

     boolean exist(String id) throws SQLException, ClassNotFoundException;

     void delete(String id) throws SQLException, ClassNotFoundException;

     String generateId() throws SQLException, ClassNotFoundException;

     CustomerDTO find(String newValue) throws SQLException, ClassNotFoundException;
}
