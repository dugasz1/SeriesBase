package com.github.dugasz1.seriesbase.core.model;

import java.util.Date;

public class Actor {
    private int id;
    private String name;
    private Date birth;
    private Gender gender;

    public Actor(int id, String name, Date birth, Gender gender) {
        setId(id);
        setName(name);
        setBirth(birth);
        setGender(gender);
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
