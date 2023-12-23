package com.example.layeredarchitecture.bo;


import com.example.layeredarchitecture.bo.custom.impl.CustomerBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.ItemBoImpl;
import com.example.layeredarchitecture.bo.custom.impl.PlaceOrderBoImpl;

public class BoFactory {
    private static BoFactory boFactory ;
    private BoFactory(){

    }

    public static BoFactory getBoFactory(){
        return (boFactory==null)? boFactory = new BoFactory():boFactory ;
    }

    public enum BoTypes{
        CUSTOMER, ITEM, PLACE_ORDER
    }

    public SuperBo getBoo(BoFactory.BoTypes boTypes){
        switch (boTypes){
            case ITEM:
                return new ItemBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case PLACE_ORDER:
                return new PlaceOrderBoImpl();
            default:
                return null;
        }

    }
}
