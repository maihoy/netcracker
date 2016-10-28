package com.makarevich.beans;

import com.makarevich.utils.ManagerUtil;

import java.util.GregorianCalendar;

/**
 * Created by j on 21.10.16.
 */
public class Manager extends Person {

    private final ManagerUtil managerUtil = new ManagerUtil(this);


    public Manager(String firstName, String lastName,
                    GregorianCalendar birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Manager() {
    }

    public ManagerUtil getManagerUtil() {
        return managerUtil;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return managerUtil != null ? managerUtil.equals(manager.managerUtil) : manager.managerUtil == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (managerUtil != null ? managerUtil.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerUtil=" + managerUtil +
                '}';
    }

}
