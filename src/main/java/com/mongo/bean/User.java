package com.mongo.bean;

import com.mongo.utils.JsonUtils;
import com.mongodb.DBObject;

/**
 * 用户实体类
 */
public class User {
    private int id;
    private String name;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * java 对象转换为json 存入流中
     */
    public String toJson(){
        return JsonUtils.toJson(this);
    }

    /*
     *在查询所有的记录时使用，封装属性
     */
    public void parse(DBObject dbo){
        this.setId((Integer)dbo.get("id"));
        this.setName((String)dbo.get("name"));
        this.setAddress((String)dbo.get("address"));
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",address:"+address;
    }
}
