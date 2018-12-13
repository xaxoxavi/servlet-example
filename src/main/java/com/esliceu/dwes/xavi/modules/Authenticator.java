package com.esliceu.dwes.xavi.modules;

import com.esliceu.dwes.xavi.model.User;



public interface Authenticator {

    boolean authenticate(User user);

}
