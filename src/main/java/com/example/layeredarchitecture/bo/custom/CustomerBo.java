package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBo;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBo extends SuperBo {
    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

    void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;

     String generateCustomerId() throws SQLException, ClassNotFoundException;

     CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException;
}
