package com.makarevich.managers;

import java.util.ResourceBundle;

/**
 * Performs path reading from property file
 */
public enum PathManager {
    INSTANCE;

    private static final String BUNDLE_NAME = "config";
   private final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME);


    public synchronized String getString(String key) {
        return bundle.getString(key);
    }
}
