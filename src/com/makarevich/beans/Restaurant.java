package com.makarevich.beans;

import com.makarevich.enums.Rating;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by j on 19.10.16.
 */
public class Restaurant {

    private String name;
    private Rating rating;
    private Menu menu;
    private Set waiters = new HashSet();

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void addWaiters(Waiter waiter) {
        waiters.add(waiter);
        waiter.setRestaurant(this);
    }

    public Set getWaiters() {
        return waiters;
    }

    public void removeWaiter(Waiter waiter){
        waiters.remove(waiter);
    }
}
