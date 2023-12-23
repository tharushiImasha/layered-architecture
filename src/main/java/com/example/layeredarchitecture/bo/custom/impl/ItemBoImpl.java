package com.example.layeredarchitecture.bo.custom.impl;

import com.example.layeredarchitecture.bo.custom.ItemBo;
import com.example.layeredarchitecture.dao.DaoFactory;
import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDao.getAll();
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDao.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDao.save(itemDTO);
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDao.update(itemDTO);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDao.exist(code);
    }

    @Override
    public String generateItemId() throws SQLException, ClassNotFoundException, SQLException {
        return itemDao.generateId();
    }

    @Override
    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
        return itemDao.find(code);
    }
}
