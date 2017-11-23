package com.github.dugasz1.seriesbase.core.model;

public class Actor {
    private int id;
    private String name;
    private Gender gender;

    public Actor(int id, String name, Gender gender) {
        setId(id);
        setName(name);
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


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
