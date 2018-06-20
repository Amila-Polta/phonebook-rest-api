package com.amila.phonebook.dao;

import com.amila.phonebook.models.User;

/**
 * Created by amilanuwan on 6/20/18.
 */
public interface UserDao {

    User addUser(User userToAdd);

    User updateUser(User userToUpdate);

    User deleteUser(User userToDelete);

    User searchUser(long idToSearch);
}
