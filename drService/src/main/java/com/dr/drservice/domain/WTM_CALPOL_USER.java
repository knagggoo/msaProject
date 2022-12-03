package com.dr.drservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="WTM_CALPOL_USER")
public class WTM_CALPOL_USER
{
    @Id
    @Column(name = "UID")
    private String uid;
    @Column(name = "TempletID")
    private int templetId;
    @Column(name = "UseRule")
    private int useRule;
    @Column(name = "POLTYPE")
    private int polType;
    @Column(name = "DelYN")
    private  int delYn;
    @Column(name = "UpdateTime")
    private  String updateTime;
}
