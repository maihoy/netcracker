package com.makarevich.managers;

import java.util.ResourceBundle;

public enum  ConfigurationManager{
  INSTANCE;

  private final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  public String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}