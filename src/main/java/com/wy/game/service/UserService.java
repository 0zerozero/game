package com.wy.game.service;

import com.wy.game.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public void test(){
        //userDao.save()
    }
}
