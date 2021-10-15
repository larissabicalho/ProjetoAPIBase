package com.javarestassuredtemplate.jsonObjects;

import lombok.*;

@Getter
@Setter
@NonNull
public class Tags {
    private long id;
    private String name;

    public Tags(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
