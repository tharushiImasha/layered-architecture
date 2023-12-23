package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.ItemDao;
import com.example.layeredarchitecture.dao.custom.impl.ItemDaoImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo{

    ItemDao itemDao = new ItemDaoImpl();

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        return itemDao.getAll();
    }

    @Override
    public void delete(String code) throws SQLException, ClassNotFoundException {
        itemDao.delete(code);
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDao.save(itemDTO);
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return itemDao.update(itemDTO);
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        return itemDao.exist(code);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException, SQLException {
        return itemDao.generateId();
    }

    @Override
    public ItemDTO find(String code) throws SQLException, ClassNotFoundException {
        return itemDao.find(code);
    }
}
