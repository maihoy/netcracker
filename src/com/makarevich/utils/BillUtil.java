package com.makarevich.utils;

import com.makarevich.beans.Bill;
import com.makarevich.beans.Order;
import com.makarevich.enums.MenuItems;
import com.makarevich.tools.Operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BillUtil {

    private String fileName;
    private final Bill bill;

    public BillUtil(Bill bill) {
        this.bill = bill;
    }

    public Bill getBill() {
        return bill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillUtil)) return false;

        BillUtil billUtil = (BillUtil) o;

        return getBill() != null ? getBill().equals(billUtil.getBill()) : billUtil.getBill() == null;

    }

    @Override
    public int hashCode() {
        return getBill() != null ? getBill().hashCode() : 0;
    }

    @Override
    public String toString() {
        return bill.toString();
    }



    public void out() {
        try {
            OrderUtil orderToBill= new OrderUtil(bill.getOrder());
            bill.setBill(orderToBill.showOrderCost());
            System.out.println(bill.toString());

            fileName=bill.getOrder().getOrderNum()+"n";
            Operations.write(bill.toString(),fileName);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}