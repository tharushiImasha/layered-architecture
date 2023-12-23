package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    void delete(String code) throws SQLException, ClassNotFoundException;

   boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

   boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

   boolean exist(String code) throws SQLException, ClassNotFoundException;

   String generateId() throws SQLException, ClassNotFoundException, SQLException;

   ItemDTO find(String code) throws SQLException, ClassNotFoundException;
}
