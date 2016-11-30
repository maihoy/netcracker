package com.makarevich.constants;

/**
 * Created by j on 10.11.16.
 */
public class ConfigsConstants {
    public static final String DATABASE_SOURCE="java:/comp/env/jdbc/restaurantDB";
    public static final String CONFIGS_SOURCE = "config";
    public static final String MESSAGES_SOURCE = "messages";


    public static final String INDEX_PAGE_PATH = "path.page.index";
    public static final String REGISTRATION_PAGE_PATH = "path.page.registration";

    public static final String ERROR_PAGE_PATH = "path.page.error";

    public static final String CLIENT_PAGE_PATH = "path.page.client";

    public static final String WAITER_PAGE_PATH = "path.page.waiter";
    public static final String WAITER_SHOW_ALL_DISHES_PATH = "path.page.waiter.menu";
    public static final String DISH_UPDATE_PAGE_PATH = "path.page.waiter.update_dish";
    public static final String DISH_ADD_PAGE_PATH = "path.page.waiter.add_dish";

    public static final String ADMIN_PAGE_PATH = "path.page.admin";
    public static final String ADMIN_SHOW_ALL_USERS_PAGE = "path.page.admin.users";
    public static final String UPDATE_PAGE_PATH = "path.page.admin.update";


    public static final String USER_SHOW_ORDER_PATH = "path.page.client.order";
    public static final String USER_ADD_TO_ORDER = "path.page.client.addto_order";
}