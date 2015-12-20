package com.zerobasedindex.github.model;

public class Repo {

    private long id;
    private String name;
    private String description;
    private Owner owner;


    public Repo() {}

    public Repo(long id, String name, String description, Owner owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Owner getOwner() {
        return owner;
    }
}
