package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarRelationships {
    Issue issue;
    Type type;

    public void setDados(long id) {
        issue = new Issue();
        issue.setId(id);
        type = new Type();
        type.setName(GlobalStaticParameters.nameRelationships);
    }

}


