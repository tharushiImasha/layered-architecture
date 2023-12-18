package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

       ResultSet rst =  SqlUtil.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> allItems = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
        }
        return allItems;

    }

    @Override
    public void delete(String code) throws SQLException, ClassNotFoundException {

        SqlUtil.execute("DELETE FROM Item WHERE code=?", code);
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand(), itemDTO.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {

        return SqlUtil.execute("SELECT code FROM Item WHERE code=?", code);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException, SQLException {

        ResultSet rst = SqlUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, code+"");
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));

        return SqlUtil.execute("SELECT * FROM Item WHERE code=?", code);

    }

}
