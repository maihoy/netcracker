package com.makarevich.enums;

/**
 * Created by j on 14.11.16.
 */
public enum Roles{
    USER(1),WAITER(2),ADMIN(3);
    private int cost;

    Roles(int cost)
    {
        this.cost = cost;
    }

    public int getCost()
    {
        return cost;
    }

}
