package com.makarevich.constants;

/**
 * Created by j on 10.11.16.
 */
public class SqlRequests {
    public static final String GET_ALL_USERS = "SELECT USER.first_name, USER.last_name, USER.email, USER.password, USER.USER_ROLE_id , USER.USER_STATE_id FROM USER ";
    public static final String CHECK_AUTHORIZATION = "SELECT email, password FROM USER WHERE email = ? AND password = ?";
    public static final String GET_ROLE_BY_EMAIL = "SELECT type FROM USER LEFT JOIN USER_ROLE ON USER.USER_ROLE_id = USER_ROLE.id WHERE email=?";
    public static final String GET_STATE_BY_EMAIL = "SELECT user_state FROM USER LEFT JOIN USER_STATE ON USER.USER_STATE_id = USER_STATE.id WHERE email=?";
    public static final String GET_USER_BY_EMAIL="SELECT * FROM USER WHERE USER.email=?";
    public static final String CHECK_EMAIL = "SELECT email FROM USER WHERE email = ?";
    public static final String ADD_USER ="INSERT INTO restaurantDB.USER ( first_name, last_name, password, email, USER_ROLE_id, USER_STATE_id) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_USER ="UPDATE restaurantDB.USER SET first_name = ?, last_name = ?, password = ?, USER_ROLE_id = ?, USER_STATE_id =? WHERE id = ? AND email=?";
    public static final String DELETE_USER ="UPDATE restaurantDB.USER SET USER_STATE_id =2 WHERE id = ? AND email=?";

}
