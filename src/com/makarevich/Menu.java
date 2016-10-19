package com.makarevich;


import com.makarevich.enums.MenuItems;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Menu {

    List<MenuItems> positions= new ArrayList<MenuItems>(EnumSet.allOf(MenuItems.class));

    public List<MenuItems> getPositions() {
        return positions;
    }

    public void setPositions(List<MenuItems> positions) {
        this.positions = positions;
    }
}
