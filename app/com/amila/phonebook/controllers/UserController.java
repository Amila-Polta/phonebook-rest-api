package com.amila.phonebook.controllers;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.dao.impl.UserDaoImpl;
import com.amila.phonebook.models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class UserController extends Controller {




    /**
     * Save user to the database from the request (Use hard coded user)
     * @return user saved in the database
     */
    public Result addUser(){
        User userToSave =  new User();
        userToSave.setFirstName("Amila");
        userToSave.setLastName("Nuwan");
        userToSave.setEmail("asd@asd.com");
        userToSave.setPassword("123");

        UserDao  userDao = new UserDaoImpl();

        User addedUser = userDao.addUser(userToSave);

        return ok("User added Successfuly");
    }
}
