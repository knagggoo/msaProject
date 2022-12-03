package com.sm.smservice.service;

import com.sm.smservice.dto.currentServerInfo;

import java.util.List;

public interface currentNHServerInfoRepo
{
    List<currentServerInfo> findServerInfo();
    List<String> findServerIp();
}
