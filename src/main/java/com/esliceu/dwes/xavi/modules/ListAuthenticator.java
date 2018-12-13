package com.esliceu.dwes.xavi.modules;

import com.esliceu.dwes.xavi.SpringContext;
import com.esliceu.dwes.xavi.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class ListAuthenticator implements Authenticator {

    private EntityManager<User> entityManager;




    @Override
    public boolean authenticate(User user) {

        List<User> userList = entityManager.getAll();

        userList = userList.stream()
                .filter(userFiltered -> user.getEmail().equalsIgnoreCase(userFiltered.getEmail())
                        && user.getPassword().equals(userFiltered.getPassword()))
                .collect(Collectors.toList());

       return !userList.isEmpty();

    }

    public EntityManager<User> getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager<User> entityManager) {
        this.entityManager = entityManager;
    }
}
