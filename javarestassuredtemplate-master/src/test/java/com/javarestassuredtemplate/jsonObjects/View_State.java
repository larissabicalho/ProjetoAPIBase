package com.javarestassuredtemplate.jsonObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Getter
    @Setter
    public class View_State {
        private long id;
        private String name;
        private String label;

        public View_State(long id, String name, String label) {
            this.id = id;
            this.name = name;
            this.label = label;
        }

        public View_State(String name) {
            this.name = name;
        }
}
