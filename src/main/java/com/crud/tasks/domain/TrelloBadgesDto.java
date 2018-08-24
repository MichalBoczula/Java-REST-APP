package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TrelloBadgesDto {

    private int votes;
    private AttachmentByTypeDto attachmentByType;
}
