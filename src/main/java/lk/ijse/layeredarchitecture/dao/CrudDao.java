package lk.ijse.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDao<T> extends SuperDao{
    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(String id) throws SQLException, ClassNotFoundException;

    void delete(String id) throws SQLException, ClassNotFoundException;

    String generateId() throws SQLException, ClassNotFoundException;

    T find(String newValue) throws SQLException, ClassNotFoundException;
}
