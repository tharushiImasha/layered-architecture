package lk.ijse.layeredarchitecture.bo.custom.impl;

import lk.ijse.layeredarchitecture.bo.custom.ItemBo;
import lk.ijse.layeredarchitecture.dao.DaoFactory;
import lk.ijse.layeredarchitecture.dao.custom.ItemDao;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items=itemDao.getAll();
        ArrayList<ItemDTO> itemDTOS=new ArrayList<>();
        for (Item item:items) {
            itemDTOS.add(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return itemDTOS;
    }

    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDao.delete(code);
    }

    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
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
        Item item = itemDao.find(code);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(), item.getQtyOnHand());
    }
}
