package com.javarestassuredtemplate.jsonObjects.Issues;


import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.*;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.sql.SQLException;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddAttachment {

    private Files[] files;
    public void setDados() throws IOException, SQLException {
        Files file1 = new Files();
        file1.setName(GerarDados.filename());
        file1.setContent(GeneralUtils.encodeFileToBase64Binary("file.png"));
        files = new Files[]{file1};
    }
}


