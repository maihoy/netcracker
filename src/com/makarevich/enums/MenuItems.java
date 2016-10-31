package com.makarevich.enums;


public enum MenuItems {
    FISH(25),
    STEAK(30),
    CURRY(27),
    SOUP(15),
    COFFEE(15),
    TEA(13),
    JUICE(5),
    WATER(3);

    private int cost;

    MenuItems(int cost)
    {
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

    public String getName(){
        switch (this){
            case FISH:
                return "Fried fish fingers";
            case STEAK:
                return "Rare fried steak";
            case CURRY:
                return "Yellow carry";
            case SOUP:
                return "Chinese soup";
            case COFFEE:
                return "Espresso";
            case TEA:
                return "Milk oolung tea";
            case JUICE:
                return "Fruit juice";
            case WATER:
                return "Water from waterfall";
            default:
                return "no order";
        }

    }

    public static MenuItems menuItems(String name) {
        for (MenuItems items : values()) {
            if (items.getName().equals(name)) {
                return items;
            }
        }
        throw new IllegalArgumentException(String.valueOf(name));
    }
}
