package com.sm.smservice.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sm.smservice.domain.QWTM_CALPOL_USER;
import com.sm.smservice.domain.WTM_CALPOL_USER;
import com.sm.smservice.dto.wtmCalPolUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class wtmCalpolUserInfoRepoSupport implements wtmCalPolUserInfoRepo
{
    private final JPAQueryFactory queryFactory;
    private final com.sm.smservice.repository.wtmCalPolUserRepository wtmCalPolUserRepository;

    public List<wtmCalPolUser> findTempletUserInfo()
    {
        List<wtmCalPolUser> result = new ArrayList<>();

        List<WTM_CALPOL_USER> findList = queryFactory
            .selectFrom(QWTM_CALPOL_USER.wTM_CALPOL_USER)
            .fetch();

        findList.forEach(x -> {
            wtmCalPolUser newInfo = new wtmCalPolUser();
            newInfo.setTempletId(x.getTempletId());
            newInfo.setUid(x.getUid());
            newInfo.setUseRule(x.getUseRule());
            newInfo.setPolType(x.getPolType());
            newInfo.setDelYn(x.getDelYn());
            newInfo.setUpdateTime(x.getUpdateTime());

            result.add(newInfo);
        });

        return result;
    }

    public List<wtmCalPolUser> findTempletNumber(String uid)
    {
        List<wtmCalPolUser> result = new ArrayList<>();

        List<WTM_CALPOL_USER> findList = queryFactory
            .selectFrom(QWTM_CALPOL_USER.wTM_CALPOL_USER)
            .where(QWTM_CALPOL_USER.wTM_CALPOL_USER.uid.eq(uid))
            .fetch();

        findList.forEach(x -> {
            wtmCalPolUser newInfo = new wtmCalPolUser();
            newInfo.setTempletId(x.getTempletId());
            newInfo.setUid(x.getUid());
            newInfo.setUseRule(x.getUseRule());
            newInfo.setPolType(x.getPolType());
            newInfo.setDelYn(x.getDelYn());
            newInfo.setUpdateTime(x.getUpdateTime());

            result.add(newInfo);
        });

        return result;
    }

    @Transactional
    public void insertTempletInfo(wtmCalPolUser param)
    {
        WTM_CALPOL_USER wtm_calpol_user = new WTM_CALPOL_USER();
        wtm_calpol_user.setUid(param.getUid());
        wtm_calpol_user.setTempletId(param.getTempletId());
        wtm_calpol_user.setUseRule(param.getUseRule());
        wtm_calpol_user.setDelYn(param.getDelYn());
        wtm_calpol_user.setUpdateTime(param.getUpdateTime());
        wtm_calpol_user.setPolType(param.getPolType());

        wtmCalPolUserRepository.save(wtm_calpol_user);
    }

    @Transactional
    public void updateTempletInfo(wtmCalPolUser param)
    {
        queryFactory
            .update(QWTM_CALPOL_USER.wTM_CALPOL_USER)
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.templetId, param.getTempletId())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.useRule, param.getUseRule())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.delYn, param.getDelYn())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.polType, param.getPolType())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.updateTime, param.getUpdateTime())
            .where(QWTM_CALPOL_USER.wTM_CALPOL_USER.uid.eq(param.getUid()))
            .execute();
    }

    @Transactional
    public void deleteTempletInfo(wtmCalPolUser param)
    {
        queryFactory
            .delete(QWTM_CALPOL_USER.wTM_CALPOL_USER)
            .where(QWTM_CALPOL_USER.wTM_CALPOL_USER.uid.eq(param.getUid()))
            .execute();
    }

    @Transactional
    public void putUpdateTempletInfo(wtmCalPolUser param)
    {
        queryFactory
            .update(QWTM_CALPOL_USER.wTM_CALPOL_USER)
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.templetId, param.getTempletId())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.useRule, param.getUseRule())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.delYn, param.getDelYn())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.polType, param.getPolType())
            .set(QWTM_CALPOL_USER.wTM_CALPOL_USER.updateTime, param.getUpdateTime())
            .where(QWTM_CALPOL_USER.wTM_CALPOL_USER.uid.eq(param.getUid()))
            .execute();
    }
}
