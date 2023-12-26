package lk.ijse.layeredarchitecture.dao.custom;

import lk.ijse.layeredarchitecture.dao.SuperDao;

import java.sql.SQLException;

public interface QueryDao extends SuperDao {
    void customerOrderDetails() throws SQLException, ClassNotFoundException;
}
