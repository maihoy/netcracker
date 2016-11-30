package com.makarevich.constants;

/**
 * Created by j on 10.11.16.
 */
public class SqlRequests {
    public static final String GET_ALL_USERS = "SELECT USER.first_name, USER.last_name, USER.email, USER.password, USER.USER_ROLE_id , USER.USER_STATE_id FROM USER ";
    public static final String CHECK_AUTHORIZATION = "SELECT email, password FROM USER WHERE email = ? AND password = ?";
    public static final String GET_ROLE_BY_EMAIL = "SELECT type FROM USER LEFT JOIN USER_ROLE ON USER.USER_ROLE_id = USER_ROLE.id WHERE email=?";
    public static final String GET_STATE_BY_EMAIL = "SELECT user_state FROM USER LEFT JOIN USER_STATE ON USER.USER_STATE_id = USER_STATE.id WHERE email=?";
    public static final String GET_USER_BY_EMAIL="SELECT id, first_name, last_name, password, email, USER_ROLE_id, USER_STATE_id FROM USER WHERE USER.email=?";
    public static final String CHECK_EMAIL = "SELECT email FROM USER WHERE email = ?";
    public static final String ADD_USER ="INSERT INTO restaurantDB.USER ( first_name, last_name, password, email, USER_ROLE_id, USER_STATE_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER ="UPDATE restaurantDB.USER SET first_name = ?, last_name = ?, password = ?, USER_ROLE_id = ?, USER_STATE_id =? WHERE id = ? AND email=?";
    public static final String DELETE_USER ="UPDATE restaurantDB.USER SET USER_STATE_id =2 WHERE id = ? AND email=?";
    public static final String GET_ALL_DISHES ="SELECT id, name, price FROM restaurantDB.DISH";

    public static final String GET_DISH_BY_ID = "SELECT id, name, price FROM restaurantDB.DISH WHERE id=?";
    public static final String GET_DISH_BY_NAME ="SELECT id, name, price FROM restaurantDB.DISH WHERE name=?" ;
    public static final String ADD_DISH = "INSERT INTO restaurantDB.DISH ( name, price) VALUES ( ?, ?)";
    public static final String DELETE_DISH_BY_ID = "DELETE FROM DISH WHERE id=?";
    public static final String UPDATE_DISH = "UPDATE restaurantDB.DISH SET name = ?, price = ? WHERE id = ?";
    
    public static final String GET_ALL_ORDERS_FOR_USER = "SELECT `ORDER`.id, `ORDER`.STATE_id, DISH.id, DISH.name, DISH.price, USER.id, USER.email\n" +
            "FROM `ORDER`\n" +
            "  LEFT JOIN USER ON `ORDER`.USER_id = USER.id\n" +
            "LEFT JOIN DISH ON `ORDER`.DISH_id = DISH.id\n" +
            "WHERE USER.email=?";
    public static final String ADD_TO_ORDER = "INSERT INTO restaurantDB.`ORDER` ( DISH_id, STATE_id, USER_id) VALUES ( ?, ?, ?);";
    public static final String DELETE_DISH_FROM_ORDER_BY_ID ="DELETE FROM `ORDER` WHERE id=?" ;
    public static final String GET_ALL_ORDERS = "SELECT `ORDER`.id, `ORDER`.STATE_id, DISH.id, DISH.name, DISH.price, USER.id, USER.email FROM `ORDER` LEFT JOIN USER ON `ORDER`.USER_id = USER.idLEFT JOIN DISH ON `ORDER`.DISH_id = DISH.id";
    public static final String GET_DISH_ID_BY_NAME = "SELECT DISH.id FROM DISH WHERE name=?";
    public static final String GET_USER_ID_BY_NAME ="SELECT USER.id FROM USER WHERE email=?" ;
}
