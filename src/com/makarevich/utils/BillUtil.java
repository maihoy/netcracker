package com.makarevich.utils;

import com.makarevich.beans.Bill;

public class BillUtil {
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

    public void out() {
        try {
            System.out.println("Waiter: " + bill.getWaiter().getFirstName() + " " + bill.getWaiter().getLastName());
            System.out.println("Customer: " + bill.getOrder().getCustomer().getFirstName() + " " + bill.getOrder().getCustomer().getLastName());
            System.out.println("Order: " + bill.getOrder());
            System.out.println("Your order's cost is " + bill.getBill() + "$");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}