package com.cm.cmservice.service;


import com.cm.cmservice.dto.currentServerInfo;

import java.util.List;

public interface currentNHServerInfoRepo
{
    List<currentServerInfo> findServerInfo();
    List<String> findServerIp();
}
