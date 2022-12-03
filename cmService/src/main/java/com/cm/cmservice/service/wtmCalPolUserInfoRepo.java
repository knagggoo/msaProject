package com.cm.cmservice.service;



import com.cm.cmservice.dto.wtmCalPolUser;

import java.util.List;

public interface wtmCalPolUserInfoRepo
{
    List<wtmCalPolUser> findTempletUserInfo();
    List<wtmCalPolUser> findTempletNumber(String uid);
    void insertTempletInfo(wtmCalPolUser param);
    void updateTempletInfo(wtmCalPolUser param);
    void deleteTempletInfo(wtmCalPolUser param);
    void putUpdateTempletInfo(wtmCalPolUser param);
    String test();
}
