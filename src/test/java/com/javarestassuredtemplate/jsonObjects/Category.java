package com.javarestassuredtemplate.jsonObjects;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private long id;
    private String name;

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }


}
