package com.javarestassuredtemplate.jsonObjects.Issues;

import com.javarestassuredtemplate.jsonObjects.Tags;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentTag {
    private Tags[] tags;
}


