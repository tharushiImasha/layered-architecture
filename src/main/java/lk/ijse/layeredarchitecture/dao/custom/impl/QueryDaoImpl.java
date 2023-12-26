package lk.ijse.layeredarchitecture.dao.custom.impl;

import lk.ijse.layeredarchitecture.dao.SqlUtil;
import lk.ijse.layeredarchitecture.dao.custom.QueryDao;
import lk.ijse.layeredarchitecture.dto.CustomDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDaoImpl implements QueryDao {

    @Override
    public void customerOrderDetails() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.execute("SELECT\n" +
                "\tc.name,\n" +
                "\to.date,\n" +
                "\tod.*\n" +
                "from Customer c\n" +
                "join Orders o\n" +
                "on c.id = o.customerID\n" +
                "join OrderDetails od\n" +
                "on o.oid = od.oid;");

        while (rst.next()){
            //CustomDto customDto1 = new CustomDto(customDto.getName(), customDto.getOrderDate(), customDto.getOrderId(), customDto.getItemCode(), customDto.getQty(), customDto.getUnitPrice());
            ArrayList<CustomDto> customDtos = new ArrayList<>();

            CustomDto customDto1 = new CustomDto(
                    rst.getString("name"),
                    rst.getDate("date").toLocalDate(),
                    rst.getString("oid"),
                    rst.getString("itemCode"),
                    rst.getInt("qty"),
                    rst.getBigDecimal("unitPrice")

            );
            customDtos.add(customDto1);
            System.out.println(customDtos);
        }

    }
}
