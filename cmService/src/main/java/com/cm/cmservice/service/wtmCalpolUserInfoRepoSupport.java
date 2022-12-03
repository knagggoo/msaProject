package com.cm.cmservice.service;

import com.cm.cmservice.domain.QWTM_CALPOL_USER;
import com.cm.cmservice.domain.WTM_CALPOL_USER;
import com.cm.cmservice.dto.wtmCalPolUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class wtmCalpolUserInfoRepoSupport implements wtmCalPolUserInfoRepo
{
    private final JPAQueryFactory queryFactory;
    private final com.cm.cmservice.repository.wtmCalPolUserRepository wtmCalPolUserRepository;

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

    public String test()
    {
        try {
            InetSocketAddress isa = new InetSocketAddress("192.168.245.128", 80);
            Socket socket = new Socket();
            socket.setReuseAddress(true);
            socket.connect(isa);
            socket.setSoTimeout(10000); // 10초
            socket.setSoLinger(true, 0);

            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            String sid = "0123";
            String sabun = "123456";

            //ByteBuffer
            ByteBuffer sendByteBuffer = null;

            sendByteBuffer = ByteBuffer.allocate(14);
            sendByteBuffer.order(ByteOrder.LITTLE_ENDIAN);

            sendByteBuffer.put(sid.getBytes());
            sendByteBuffer.put(new byte[5 - sid.getBytes().length]);

            sendByteBuffer.put(sabun.getBytes());
            sendByteBuffer.put(new byte[9 - sabun.getBytes().length]);

            os.write(sendByteBuffer.array());
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }
}
