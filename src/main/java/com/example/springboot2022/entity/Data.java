package com.example.springboot2022.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter

@ToString

@TableName("han")
public class Data {
    public Data() {
    }

    public Data(int id, String name, String pk,String message) {
        this.id = id;
        this.name = name;
        this.pk = pk;
        this.message=message;
    }

    //@TableId(type = IdType.AUTO)
    public int id;
    public String name;
    public String pk;
    public String message;

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

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
