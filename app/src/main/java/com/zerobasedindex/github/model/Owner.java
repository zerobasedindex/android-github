package com.zerobasedindex.github.model;

/**
 * Copyright 2015 Cody Henthorne
 */
public class Owner {

    private String login;
    private String avatar_url;
    private String gravatar_id;

    public Owner(String login, String avatar_url) {
        this.login = login;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

}
