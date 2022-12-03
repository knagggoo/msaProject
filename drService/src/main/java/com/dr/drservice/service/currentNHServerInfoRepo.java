package com.dr.drservice.service;


import com.dr.drservice.dto.currentServerInfo;

import java.util.List;

public interface currentNHServerInfoRepo
{
    List<currentServerInfo> findServerInfo();
    List<String> findServerIp();
}
