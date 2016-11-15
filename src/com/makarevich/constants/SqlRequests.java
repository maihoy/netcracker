package com.makarevich.constants;

/**
 * Created by j on 10.11.16.
 */
public class SqlRequests {
    public static final String GET_ALL_USER_PROFILES = "SELECT USER.id, USER.first_name, USER.last_name, USER.email, USER.password , USER_ROLE.type\n" +
            "FROM USER_PROFILE\n" +
            "NATURAL LEFT OUTER JOIN USER_ROLE, USER ";
    public static final String CHECK_AUTHORIZATION = "SELECT email, password FROM users WHERE email = ? AND password = ?";
    public static final String CHECK_ACCESS_LEVEL = "SELECT   USER_ROLE.type\n" +
            "FROM USER_PROFILE\n" +
            "NATURAL LEFT OUTER JOIN USER_ROLE, USER WHERE USER.email=?" ;
    public static final String GET_USER_BY_EMAIL="SELECT   USER.id, USER.first_name, USER.last_name, USER.email, USER.password, USER_ROLE.id\n"+
            "FROM USER_PROFILE\n"+
            "NATURAL LEFT OUTER JOIN USER_ROLE, USER WHERE USER.email=?";

}
