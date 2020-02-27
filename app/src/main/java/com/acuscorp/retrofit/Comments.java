package com.acuscorp.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Noé Adrian Acuna Prado on 26/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
public class Comments {
    private int postId;
    private int id;
    private String name;
    private String email;
    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getText() {
        return text;
    }
}
