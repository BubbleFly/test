package com.mongo.action;

import com.mongo.bean.User;
import com.mongo.service.UserService;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by PC on 2016/7/20.
 */
public class UserAction {
    private UserService userService = new UserService();


    public void save() throws UnknownHostException {
        User user = new User();
        user.setId(4);
        user.setName("bay");
        user.setAddress("nanning");
        this.userService.save(user);
    }

    public void update()throws UnknownHostException{
        User user = new User();
        user.setId(1);
        user.setName("manman");
        user.setAddress("hebei");
        this.userService.update(user);
    }

    public List<User> findAll()throws UnknownHostException{
        return this.userService.findAll();
    }

    public void remove()throws UnknownHostException{
        this.userService.remove(1);
    }



    public static void main(String[] args)throws UnknownHostException {
        UserAction userAction = new UserAction();

        userAction.save();

  //    userAction.update();

    //     userAction.remove();

        List<User> list = userAction.findAll();
        for(User user : list){
            System.out.println(user);
        }
    }

}
