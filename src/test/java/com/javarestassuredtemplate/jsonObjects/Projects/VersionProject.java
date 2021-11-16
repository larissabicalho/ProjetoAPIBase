package com.javarestassuredtemplate.jsonObjects.Projects;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionProject {

    private String name = GlobalStaticParameters.versionName;
    private String description = GlobalStaticParameters.descriptionVersion;
    private boolean released = GlobalStaticParameters.released;
    private boolean obsolete = GlobalStaticParameters.obsolete;
    private String timestamp = GlobalStaticParameters.timestamp;



}
