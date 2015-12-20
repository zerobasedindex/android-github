package com.zerobasedindex.github.model;

/**
 * Copyright 2015 Cody Henthorne
 */
public class Commit {

    private CommitPerson author;
    private CommitPerson committer;
    private String message;

    public Commit(String message) {
        this.message = message;
    }

    public CommitPerson getAuthor() {
        return author;
    }

    public CommitPerson getCommitter() {
        return committer;
    }

    public String getMessage() {
        return message;
    }
}
