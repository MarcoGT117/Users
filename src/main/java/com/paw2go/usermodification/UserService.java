package com.paw2go.usermodification;

import java.util.Collection;

public interface UserService {
    public abstract void createUser(User user);
    public abstract void updateUser(int id, User user);
    public abstract void updateUser(int id);
    public abstract Collection<User> getUsers();
}
