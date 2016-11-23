package com.makarevich.managers;

import java.util.ResourceBundle;

public enum  ConfigurationManager implements Manager{
  INSTANCE;

  private final ResourceBundle resourceBundle = ResourceBundle.getBundle("config");


  @Override
  public String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}