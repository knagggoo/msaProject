package com.sm.smservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class postInsertDto
{
    private String templetId;
    private String uid;
    private String useRule;
    private String polType;
    private String delYn;
    private String updateTime;
}
