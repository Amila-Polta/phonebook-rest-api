package com.amila.phonebook.util;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.dao.impl.UserDaoImpl;
import com.amila.phonebook.services.UserService;
import com.amila.phonebook.services.impl.UserServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class OnStartupModule extends AbstractModule {


    @Override
    protected void configure() {

        //Bind dao
        bind(UserDao.class).annotatedWith(Names.named("userDao")).to(UserDaoImpl.class);

        //bind Service
        bind(UserService.class).to(UserServiceImpl.class);
    }
}
