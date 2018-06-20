package com.amila.phonebook.util;

import com.amila.phonebook.dao.UserDao;
import com.amila.phonebook.dao.impl.UserDaoImpl;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by amilanuwan on 6/20/18.
 */
public class OnStartupModule extends AbstractModule {


    @Override
    protected void configure() {
        bind(UserDao.class).annotatedWith(Names.named("userDao")).to(UserDaoImpl.class);
    }
}
