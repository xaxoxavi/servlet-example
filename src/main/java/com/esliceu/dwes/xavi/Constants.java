package com.esliceu.dwes.xavi;

import com.esliceu.dwes.xavi.model.User;

public class Constants {

    public static final String HOME_URL = "home";
    public static final String USER_SESSION = "user";
    public static final String INDEX_URL = "index.jsp";
    public static final String HOME_VIEW_URL = "home.jsp";
    public static final String EDIT_VIEW_URL = "edit.jsp";


    public static User createUser(){
        return (User) SpringContext.getInstance().getBean("user");
    }
}
