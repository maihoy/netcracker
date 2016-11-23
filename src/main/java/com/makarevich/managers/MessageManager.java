package com.makarevich.managers;

import java.util.ResourceBundle;

public enum  MessageManager implements Manager{
    INSTANCE;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");


    @Override
    public  String getProperty(String key) {
      return resourceBundle.getString(key);
    }
}