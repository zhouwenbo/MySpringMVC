package com.fheebiy.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Config {

    private static final String defaultFileName = "common";
    private static HashMap<String, Properties> propMap = new HashMap<String, Properties>();

    public static String getProperty(String key) {
        return getProperty(key, defaultFileName);
    }

    public static Properties loadProperties(String fileName) {
        InputStream in = Config.class.getClassLoader().getResourceAsStream("/conf/"+fileName + ".properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static void reload() {
        reload(defaultFileName);
    }

    public synchronized static void reload(String fileName) {
        Properties prop = loadProperties(fileName);
        propMap.put(fileName, prop);
    }

    public static String getProperty(String key, String fileName) {
        Properties prop = propMap.get(fileName);
        if (prop == null) {
            synchronized (Config.class) {
                if (prop == null) {
                    prop = loadProperties(fileName);
                }
                propMap.put(fileName, prop);
            }
        }
        String str = prop.getProperty(key);
        return str == null ? "" : str;
    }

}
