package lk.ijse.layeredarchitecture.bo.custom;

import lk.ijse.layeredarchitecture.bo.SuperBo;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.dto.ItemDTO;
import lk.ijse.layeredarchitecture.dto.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBo extends SuperBo {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    CustomerDTO findCustomer(String newValue) throws SQLException, ClassNotFoundException;

    ItemDTO findItem(String s)throws SQLException, ClassNotFoundException;

    boolean existItem(String code)throws SQLException, ClassNotFoundException;

    boolean existCustomer(String id)throws SQLException, ClassNotFoundException;

    String generateOrderId()throws SQLException, ClassNotFoundException;;

    ArrayList<CustomerDTO> getAllCustomer()throws SQLException, ClassNotFoundException;;

    ArrayList<ItemDTO> getAllItem()throws SQLException, ClassNotFoundException;;
}
