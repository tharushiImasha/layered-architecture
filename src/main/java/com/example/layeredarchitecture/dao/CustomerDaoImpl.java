package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst =  SqlUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        while (rst.next()) {
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(customerDTO);
        }
        return allCustomer;

    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {

              return SqlUtil.execute("INSERT INTO Customer (id,name,  address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {

          return SqlUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getId(),dto.getName(),dto.getAddress());

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
    public CustomerDTO find(String newValue) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
//        pstm.setString(1, newValue + "");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//        CustomerDTO customerDTO = new CustomerDTO(
//                newValue + "",
//                rst.getString("name"),
//                rst.getString("address")
//        );
//        return customerDTO;

        ResultSet rst = SqlUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
        rst.next();
        return new CustomerDTO(newValue + "", rst.getString("name"), rst.getString("address"));
    }

}
