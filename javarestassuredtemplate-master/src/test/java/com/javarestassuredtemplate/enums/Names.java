package com.javarestassuredtemplate.enums;

public enum Names {
    all_projects("All Projects"),
    status("Status"),
    move_bugs("Move Issues"),
    status_enum_string  ("10:new,20:feedback,30:acknowledged,40:confirmed,50:assigned,80:resolved,90:closed"),
    does_not_exist("");

    private final String e;

    private Names(String valor) {
        e = valor;
    }

    public String getValor() {
        return e;
    }


}
