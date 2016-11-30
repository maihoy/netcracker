package com.makarevich.beans;

/**
 * Created by j on 25.11.16.
 */
public class Dish extends Entity {
    private String name;
    private Double price;
    private Long menuId;

    public Dish(Long id, String name, Double price, Long menuId) {
        super(id);
        this.name = name;
        this.price = price;
        this.menuId = menuId;
    }

    public Dish() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        if (!super.equals(o)) return false;

        Dish dish = (Dish) o;

        if (!getName().equals(dish.getName())) return false;
        if (!getPrice().equals(dish.getPrice())) return false;
        return getMenuId().equals(dish.getMenuId());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getMenuId().hashCode();
        return result;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", menuId=" + menuId +
                '}';
    }
}
