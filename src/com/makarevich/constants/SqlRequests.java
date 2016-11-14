package com.makarevich.constants;

/**
 * Created by j on 10.11.16.
 */
public class SqlRequests {
    public static final String GET_ALL_USER_PROFILES = "SELECT id, first_name, last_name, email FROM USER_PROFILE NATURAL LEFT OUTER JOIN USER_ROLE";

}
