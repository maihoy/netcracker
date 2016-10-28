package com.makarevich.utils;

import com.makarevich.beans.Menu;

public class MenuUtil {
    private final Menu menu;

    public MenuUtil(Menu menu) {
        this.menu = menu;
    }

    public void viewMenu() {
        int posCount = Menu.getPositions().size();
        posCount--;
        int i = 0;
        while (i <= posCount) {
            System.out.println(i + 1 + ". " + Menu.getPositions().get(i).getName() + " " + Menu.getPositions().get(i).getCost() + "$");
            i++;
        }
        System.out.println();
    }
}