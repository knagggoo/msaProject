package com.sm.smservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class wtmCalPolUser
{
    private int templetId;
    private String uid;
    private int useRule;
    private int polType;
    private int delYn;
    private String updateTime;
}
