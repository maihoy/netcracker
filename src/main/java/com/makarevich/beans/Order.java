package com.makarevich.beans;

/**
 * Created by j on 25.11.16.
 */
public class Order extends Entity {
    private String dishName;
    private Float dishPrice;
    private Long stateId;
    private  String userEmail;

    public Order(Long id, String dishName, Float dishPrice, Long stateId, String userEmail) {
        super(id);
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.stateId = stateId;
        this.userEmail = userEmail;
    }

    public Order() {
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Float getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Float dishPrice) {
        this.dishPrice = dishPrice;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getState() {
        return stateId;
    }


    public void setState(Long state) {
        this.stateId = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (!getDishName().equals(order.getDishName())) return false;
        if (!getDishPrice().equals(order.getDishPrice())) return false;
        if (!getStateId().equals(order.getStateId())) return false;
        return getUserEmail().equals(order.getUserEmail());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDishName().hashCode();
        result = 31 * result + getDishPrice().hashCode();
        result = 31 * result + getStateId().hashCode();
        result = 31 * result + getUserEmail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dishName='" + dishName + '\'' +
                ", dishPrice=" + dishPrice +
                ", stateId=" + stateId +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
