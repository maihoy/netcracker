package com.makarevich.beans;

import com.makarevich.enums.MenuItems;
import com.makarevich.enums.Rating;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by j on 19.10.16.
 */
public class Restaurant {

    private String name;
    private Rating rating;
    private List<MenuItems> menu;
    private Set waiters = new HashSet();

    public Restaurant(String name, Rating rating,
                      List<MenuItems> menu) {

    }

    public List<MenuItems> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItems> menu) {
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

    public void setWaiters(Set waiters) {
        this.waiters = waiters;
    }

    public Set getWaiters() {
        return waiters;
    }

    public void removeWaiter(Waiter waiter){
        waiters.remove(waiter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;

        Restaurant that = (Restaurant) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getRating() != that.getRating()) return false;
        if (getMenu() != null ? !getMenu().equals(that.getMenu()) : that.getMenu() != null) return false;
        return getWaiters() != null ? getWaiters().equals(that.getWaiters()) : that.getWaiters() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getRating() != null ? getRating().hashCode() : 0);
        result = 31 * result + (getMenu() != null ? getMenu().hashCode() : 0);
        result = 31 * result + (getWaiters() != null ? getWaiters().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", menu=" + menu +
                ", waiters=" + waiters +
                '}';
    }
}
