package lk.ijse.layeredarchitecture.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDto {
    private String name;
    private LocalDate orderDate;
    private String orderId;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public CustomDto(String name, LocalDate orderDate, String orderId, String itemCode, int qty, BigDecimal unitPrice) {
        this.name = name;
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "CustomDto{" +
                "name='" + name + '\'' +
                ", orderDate=" + orderDate +
                ", orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
