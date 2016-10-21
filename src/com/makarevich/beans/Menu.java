package com.makarevich.beans;


import com.makarevich.enums.MenuItems;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Menu {

    static List<MenuItems> positions= new ArrayList<MenuItems>(EnumSet.allOf(MenuItems.class));

    public static List<MenuItems> getPositions() {
        return positions;
    }

    public void setPositions(List<MenuItems> positions) {
        this.positions = positions;
    }



    public static void viewMenu(){
        int posCount = Menu.getPositions().size();
        posCount--;
        int i=0;
        while (i<= posCount) {
            System.out.println(i+". "+Menu.getPositions().get(i).getName()+" "+Menu.getPositions().get(i).getCost()+"$");
            i++;
        }
    }
}
