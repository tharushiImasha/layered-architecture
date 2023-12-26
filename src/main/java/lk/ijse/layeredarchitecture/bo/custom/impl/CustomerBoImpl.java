package lk.ijse.layeredarchitecture.bo.custom.impl;

import lk.ijse.layeredarchitecture.bo.custom.CustomerBo;
import lk.ijse.layeredarchitecture.dao.DaoFactory;
import lk.ijse.layeredarchitecture.dao.custom.CustomerDao;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.CUSTOMER);
    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDao.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        //return customerDao.getAll();
        ArrayList<Customer> customers=customerDao.getAll();
        ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer customer:customers) {
            customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        }
        return customerDTOS;
    }

    @Override
    public void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        //customerDao.update(dto);
        customerDao.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
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
        Customer customer=customerDao.find(newValue);
        CustomerDTO customerDTO=new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }
}
