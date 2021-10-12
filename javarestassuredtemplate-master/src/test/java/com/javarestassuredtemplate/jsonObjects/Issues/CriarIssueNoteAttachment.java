package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.defaultParameters.GlobalStaticParameters;
import com.javarestassuredtemplate.jsonObjects.Files;
import com.javarestassuredtemplate.jsonObjects.Time_Tracking;
import com.javarestassuredtemplate.jsonObjects.View_State;
import com.javarestassuredtemplate.utils.GeneralUtils;
import com.javarestassuredtemplate.utils.GerarDados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriarIssueNoteAttachment {
    private String text = GerarDados.descricaoNote();
    private View_State view_state;
    private Time_Tracking time_tracking;
    private Files[] files;

    public void setDados() {
        view_state = new View_State(GlobalStaticParameters.statusId, GlobalStaticParameters.viewStateName, GlobalStaticParameters.viewStateName);
        time_tracking = new Time_Tracking();
        time_tracking.setDuration(GlobalStaticParameters.time);
        Files file1 = new Files();
        file1.setName(GerarDados.filename());
        file1.setContent(GeneralUtils.encodeFileToBase64Binary("file.png"));
        files = new Files[]{file1};
    }
}

