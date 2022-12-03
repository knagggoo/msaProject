package com.tm.tmservice.service;



import com.tm.tmservice.dto.currentServerInfo;

import java.util.List;

public interface currentNHServerInfoRepo
{
    List<currentServerInfo> findServerInfo();
    List<String> findServerIp();
}
