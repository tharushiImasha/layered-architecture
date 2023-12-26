package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SqlUtil;
import lk.ijse.layeredarchitecture.dao.custom.CustomerDao;
import lk.ijse.layeredarchitecture.entity.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SqlUtil.execute("SELECT * FROM Customer");
        ArrayList<Customer> allCustomer = new ArrayList<>();

        while (rst.next()) {
            Customer entity = new Customer(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(entity);
        }
        return allCustomer;

    }

    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {

              return SqlUtil.execute("INSERT INTO Customer (id,name,  address) VALUES (?,?,?)", entity.getId(), entity.getName(), entity.getAddress());
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {

          return SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",entity.getId(),entity.getName(),entity.getAddress());

    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        SqlUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SqlUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public Customer find(String newValue) throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        return new Customer(newValue + "", rst.getString("name"), rst.getString("address"));
    }

}
