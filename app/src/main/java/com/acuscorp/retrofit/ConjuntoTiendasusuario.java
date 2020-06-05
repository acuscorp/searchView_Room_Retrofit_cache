package com.acuscorp.retrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Noé Adrian Acuna Prado on 26/02/2020.
 * acuscorp@gmail.com
 */
public class Post implements Serializable {

    @SerializedName("Usuario")
    private Usuario usuario;
    @SerializedName("Proyecto")
    private Proyecto proyecto;


}
