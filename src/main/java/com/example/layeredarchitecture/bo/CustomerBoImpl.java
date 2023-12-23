package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDao;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDaoImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao = new CustomerDaoImpl();
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDao.save(dto);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }

    @Override
    public void update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        customerDao.update(dto);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return customerDao.exist(id);
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        customerDao.delete(id);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return customerDao.generateId();
    }

    @Override
    public CustomerDTO find(String newValue) throws SQLException, ClassNotFoundException {
        return customerDao.find(newValue);
    }
}
