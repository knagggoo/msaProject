package com.tm.tmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class testClassRepoSupport implements testClassRepo
{
    public String findServerInfo(String uid)
    {
        return "a";
    }
}
