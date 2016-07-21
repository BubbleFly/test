package com.mongo.dao;

import com.mongo.bean.User;
import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *操作数据库
 */
public class UserDao {
//sa
    //1、Mongo是与java.sql.Connection同等级别的概念
    //2、默认是链接到127.0.0.1:27017/test
    Mongo mongo = null;

    DB myMongo = null; //DB类用来表示一个数据库，如果数据库不存在则创建一个

    DBCollection userCollection = null; //DBCollection类用来存放对象，类似数据库表的概念

    /**
     * 保存
     */
    public void save(User user) throws UnknownHostException {
        mongo = new Mongo();
        myMongo = mongo.getDB("myMongo");
        userCollection = myMongo.getCollection("user");

        DBObject dbo = (DBObject) JSON.parse(user.toJson()); //把一个对象转变成字符串，然后使用json解析

        userCollection.insert(dbo);
    }

    /**
     * 更新
     */
    public void update(User user) throws UnknownHostException {
        mongo = new Mongo();
        myMongo = mongo.getDB("myMongo");
        userCollection = myMongo.getCollection("user");

        //DBObject接口和BasicDBObject对象：表示一个具体的记录，BasicDBObject实现了DBObject，是key-value的数据结构，用起来和HashMap是基本一致的。
        BasicDBObject baseDBO = new BasicDBObject();
        baseDBO.put("id", user.getId());

        DBObject newDBO = (DBObject) JSON.parse(user.toJson());

        userCollection.update(baseDBO, newDBO);
    }

    /**
     * 查询所有
     */
    public List<User> findAll() throws UnknownHostException{
        mongo = new Mongo();
        myMongo = mongo.getDB("myMongo");
        userCollection = myMongo.getCollection("user");
        DBCursor cursor=userCollection.find(); //DBCursor用来遍历取得的数据，实现了Iterable和Iterator

        List<User> userList = new ArrayList<User>();
        while(cursor.hasNext()){
            User user = new User();
            user.parse(cursor.next());
            userList.add(user);
        }
        return userList;
    }


    /**
     * 删除操作
     */
    public void remove(int id) throws UnknownHostException{
        mongo = new Mongo();
        myMongo = mongo.getDB("myMongo");
        userCollection = myMongo.getCollection("user");

        BasicDBObject baseDBO =new BasicDBObject();
        baseDBO.put("id", id);

        //删除某一条记录
        userCollection.remove(baseDBO);
    }


}