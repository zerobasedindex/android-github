package com.zerobasedindex.github.model;

/**
 * Copyright 2015 Cody Henthorne
 */
public class FullCommit {

    private String sha;
    private Commit commit;

    public FullCommit(String sha, Commit commit) {
        this.sha = sha;
        this.commit = commit;
    }

    public String getSha() {
        return sha;
    }

    public Commit getCommit() {
        return commit;
    }
}
