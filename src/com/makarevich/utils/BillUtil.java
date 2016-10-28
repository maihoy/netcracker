package com.makarevich.utils;

import com.makarevich.beans.Bill;
import com.makarevich.beans.Order;
import com.makarevich.enums.MenuItems;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BillUtil {
    private InputStream inputstream;

    // класс для записи в файл
    private OutputStream outputStream;

    // путь к файлу который будем читать и записывать
    private String path="/home/j/ntcrckr/src/com/makarevich/files/output/";
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
        return "BillUtil{" +
                "bill=" + bill +
                '}';
    }

    public void write(String st) throws IOException {
        outputStream = new FileOutputStream(path+fileName);
        outputStream.write(st.getBytes());
        outputStream.close();
    }

    public void out() {
        try {
            OrderUtil orderToBill= new OrderUtil(bill.getOrder());
            bill.setBill(orderToBill.showOrderCost());
            System.out.println("Waiter: " + bill.getWaiter().getFirstName() + " " + bill.getWaiter().getLastName());
            System.out.println("Customer: " + bill.getOrder().getCustomer().getFirstName() + " " + bill.getOrder().getCustomer().getLastName());
            System.out.println("Order: "  );
            orderToBill.showOrder();
            System.out.println("Total: "+bill.getBill()+"$");

            fileName=bill.getOrder().getOrderNum()+"n";
            write("Waiter: " +// bill.getWaiter().getFirstName().toString()+" "+bill.getWaiter().getFirstName().toString()+"\n"+
            "Customer: "+ bill.getOrder().getCustomer().getFirstName() +" "+bill.getOrder().getCustomer().getLastName()+"\n"+
            "Order: "+bill.getOrder().toString()+"\n"+
            "Total: "+bill.getBill());

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}