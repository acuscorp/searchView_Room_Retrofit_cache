package com.acuscorp.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Noé Adrian Acuna Prado on 26/02/2020.
 * Sistema BEA
 * acuscorp@gmail.com
 */
public class Post {
    private int userId;
    private Integer id; //initialized to null so json ignore it
    private String title;
    @SerializedName("body")
    private String text;

    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }



}
