package com.esliceu.dwes.xavi.modules;

import com.esliceu.dwes.xavi.model.User;

public class SimpleAuthenticator implements Authenticator {

    @Override
    public boolean authenticate(User user) {
        return "1234".equals(user.getPassword());
    }
}
