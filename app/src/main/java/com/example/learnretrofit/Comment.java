package com.example.learnretrofit;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private String postId, id, name, email;

    @SerializedName("body")
    private String comment;

    public Comment(String postId, String id, String name, String email, String comment) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.comment = comment;
    }

    public String getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }
}
