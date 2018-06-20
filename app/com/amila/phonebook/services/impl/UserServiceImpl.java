package com.amila.phonebook.services.impl;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.dao.impl.UserDaoImpl;
import com.amila.phonebook.models.User;
import com.amila.phonebook.services.UserService;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class UserServiceImpl implements UserService {


    /**
     * Validate and transfer data from the database user to req user and update
     * @param userToUpdate user object from the request
     * @return updated user in the database
     */
    @Override
    public User updateUser(User userToUpdate) {

        UserDao userDao = new UserDaoImpl();


//        userToUpdate != null

        //Get user from database
        User userInDb = userDao.searchUser(userToUpdate.getId());


        //Transfer data from request object..
        if (!userToUpdate.getFirstName().isEmpty())
            userInDb.setFirstName(userToUpdate.getFirstName());
        //Last name
        //Email
        //Password


        //update and return updated user
        return userDao.updateUser(userInDb);
    }
}
