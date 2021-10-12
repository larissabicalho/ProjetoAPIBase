package com.javarestassuredtemplate.jsonObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private long id;
    private String name;
    private String label;

    public Status(long id, String name, String label) {
        this.id = id;
        this.name = name;
        this.label = label;
    }

    public Status(String name) {
        this.name = name;
    }
}
