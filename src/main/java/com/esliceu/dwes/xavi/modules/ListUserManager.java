package com.esliceu.dwes.xavi.modules;

import com.esliceu.dwes.xavi.model.User;

import java.util.List;

public class ListUserManager implements EntityManager<User> {

    private List<User> users;

    @Override
    public User getItemById(User item) {
        return users.stream().filter(user -> item.getEmail().equalsIgnoreCase(user.getEmail())).findFirst().get();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void deleteById(User item) throws Exception {
       boolean isRemoved =  users.removeIf(user -> item.getEmail().equalsIgnoreCase(user.getEmail()));

       if (!isRemoved) throw new Exception("Not removed!");
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
