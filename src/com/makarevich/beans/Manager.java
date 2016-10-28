package com.makarevich.beans;

import com.makarevich.utils.ManagerUtil;

import java.util.GregorianCalendar;

/**
 * Created by j on 21.10.16.
 */
public class Manager extends Person {

    public Manager(String firstName, String lastName,
                    GregorianCalendar birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Manager() {
    }

    @Override
    public String toString() {
        return "Manager{}";
    }


}
