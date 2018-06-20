package com.amila.phonebook.controllers;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.dao.impl.UserDaoImpl;
import com.amila.phonebook.models.User;
import com.amila.phonebook.services.UserService;
import com.amila.phonebook.services.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.Logger;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class UserController extends Controller {



    @Inject
    private ObjectMapper objectMapper;

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


    /**
     * This is to update user in database
     * @return updated user in the database
     */
    @BodyParser.Of(BodyParser.Json.class)
    public Result updateUser(){
        JsonNode jsonNode = request().body().asJson();

        User userToUpdate = null;

        try {
            userToUpdate = objectMapper.treeToValue(jsonNode, User.class);


            UserService userService = new UserServiceImpl();

            User updatedUser = userService.updateUser(userToUpdate);

            return ok("user Updated");


        } catch (JsonProcessingException e) {
            Logger.error(e.getMessage());
            return badRequest("Not a json");
        }
    }
}
