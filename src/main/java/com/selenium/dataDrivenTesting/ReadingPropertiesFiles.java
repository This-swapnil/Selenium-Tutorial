package com.selenium.dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFiles {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/TestData/config.properties");

        Properties propertiesobject = new Properties();
        propertiesobject.load(file);

        //Reading data from properties file
        String url = propertiesobject.getProperty("appurl");
        String email = propertiesobject.getProperty("email");
        String pwd = propertiesobject.getProperty("password");
        String orderid = propertiesobject.getProperty("orderid");
        String custid = propertiesobject.getProperty("customerid");

        System.out.println(url + " " + email + " " + pwd + " " + orderid + " " + custid);

        //Reading all the keys from the properties file
        /*
        Set<String> keys = propertiesobject.stringPropertyNames();
        System.out.println(keys);
         */

        Set<Object> keys = propertiesobject.keySet();
        System.out.println(keys);
    }
}
