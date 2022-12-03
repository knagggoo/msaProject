package com.tm.tmservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="CurrentNHServerInfo")
public class CurrentNHServerInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serverIp")
    private String serverIp;
    @Column(name = "sspPort")
    private int sspPort;
    @Column(name = "ssePort")
    private int ssePort;
    @Column(name = "sslPort")
    private int sslPort;
    @Column(name = "ssipPort")
    private  int ssipPort;
}
