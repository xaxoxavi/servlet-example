package com.esliceu.dwes.xavi;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    private static final String  SPRING_CONFIG_FILE = "SpringBeans.xml";

    private static ApplicationContext applicationContext;


    private SpringContext(){}

    private static synchronized void createInstace(){
        if (applicationContext == null) {
            applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILE);
        }
    }

    public static ApplicationContext getInstance(){
        if (applicationContext == null)  createInstace();
        return applicationContext;
    }

}
