package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.CustomerBo;
import com.example.layeredarchitecture.dao.DaoFactory;
import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDao.save(dto);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        customerDao.update(dto);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }

    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDao.delete(id);
    }

    @Override
    public String generateCustomerId() throws SQLException, ClassNotFoundException {
        return customerDao.generateId();
    }

    @Override
    public CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException {
        return customerDao.find(newValue);
    }
}
