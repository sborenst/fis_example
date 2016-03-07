package com.faisal.ose.model;

import java.io.Serializable;

/**
 * Created by faisalmasood on 5/03/2016.
 */
public class Developer implements Serializable {

    private final long id;
    private final String name;

    public Developer(long id, String name){
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
