package com.tm.tmservice.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tm.tmservice.domain.CurrentNHServerInfo;
import com.tm.tmservice.domain.QCurrentNHServerInfo;
import com.tm.tmservice.dto.currentServerInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class currentNHServerInfoRepoSupport implements currentNHServerInfoRepo
{
    private final JPAQueryFactory queryFactory;
    List<currentServerInfo> result = new ArrayList<>();

    public List<currentServerInfo> findServerInfo()
    {
         List<CurrentNHServerInfo> findList = queryFactory
            .selectFrom(QCurrentNHServerInfo.currentNHServerInfo)
             .where(QCurrentNHServerInfo.currentNHServerInfo.serverIp.eq("192.168.100.163"))
            .fetch();

        findList.forEach(x -> {
            currentServerInfo newInfo = new currentServerInfo();
            newInfo.setServerIp(x.getServerIp());
            newInfo.setServerIp(x.getServerIp());
            newInfo.setSSPPort(x.getSspPort());
            newInfo.setSSEPort(x.getSspPort());
            newInfo.setSSLPort(x.getSslPort());
            newInfo.setSSIPPort(x.getSsipPort());

            result.add(newInfo);
        });

        return result;
    }

    public List<String> findServerIp()
    {
        List<String> findList = queryFactory
            .select(QCurrentNHServerInfo.currentNHServerInfo.serverIp)
            .from(QCurrentNHServerInfo.currentNHServerInfo)
            .where(QCurrentNHServerInfo.currentNHServerInfo.serverIp.eq("192.168.100.163"))
            .fetch();

        return findList;
    }
}
