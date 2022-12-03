package com.dr.drservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class currentServerInfo
{
    private String serverIp;
    private int SSPPort;
    private int SSEPort;
    private int SSLPort;
    private int SSIPPort;
}
