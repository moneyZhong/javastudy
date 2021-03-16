package com.study.javastudy.sms.test;

import java.io.InputStreamReader;
import java.util.Properties;

public class AppAttriuteUtils  {

  private static final String configName = "config.properties";

  private static Properties properties = new Properties();
  static {
    try {
      properties.load(new InputStreamReader(AppAttriuteUtils.class.getClassLoader().getResourceAsStream(configName), "UTF-8"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }




  public static String getString(String key){


    return  properties.getProperty(key);

  }


}