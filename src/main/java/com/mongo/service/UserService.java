package com.mongo.service;

import com.mongo.bean.User;
import com.mongo.dao.UserDao;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by PC on 2016/7/20.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 保存
     */
    public void save(User user) throws UnknownHostException {
        this.userDao.save(user);
    }



    /**
     * 更新
     */
    public void update(User user) throws UnknownHostException {
        this.userDao.update(user);
    }

    /**
     * 查询所有
     */
    public List<User> findAll() throws UnknownHostException{
        return this.userDao.findAll();
    }


    /**
     * 删除操作
     */
    public void remove(int id) throws UnknownHostException{
        this.userDao.remove(id);
    }

}
