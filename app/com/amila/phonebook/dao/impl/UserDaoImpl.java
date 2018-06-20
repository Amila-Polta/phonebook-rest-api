package com.amila.phonebook.dao.impl;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.models.User;
import com.avaje.ebean.Model;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class UserDaoImpl implements UserDao {

    public static final Model.Finder<Long, User> find = new Model.Finder<>(User.class);


    @Override
    public User addUser(User userToAdd) {
        userToAdd.save();
        return userToAdd;
    }

    @Override
    public User updateUser(User userToUpdate) {
        userToUpdate.update();
        return userToUpdate;
    }

    @Override
    public User deleteUser(User userToDelete) {
        userToDelete.delete();
        return userToDelete;
    }

    @Override
    public User searchUser(long idToSearch) {
        return find.byId(idToSearch);
    }
}
