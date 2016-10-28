package com.makarevich.beans;


import com.makarevich.enums.MenuItems;
import com.makarevich.utils.MenuUtil;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by j on 19.10.16.
 */
public class Menu {

    static List<MenuItems> positions= new ArrayList<MenuItems>(EnumSet.allOf(MenuItems.class));
    private final MenuUtil menuUtil = new MenuUtil(this);

    public static List<MenuItems> getPositions() {
        return positions;
    }

    public void setPositions(List<MenuItems> positions) {
        this.positions = positions;
    }

    public Menu() {
    }

}
