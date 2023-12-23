package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBo;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SuperBo {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    void deleteItem(String code) throws SQLException, ClassNotFoundException;

   boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

   boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

   boolean existItem(String code) throws SQLException, ClassNotFoundException;

   String generateItemId() throws SQLException, ClassNotFoundException, SQLException;

   ItemDTO findItem(String code) throws SQLException, ClassNotFoundException;
}
