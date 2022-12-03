package com.sm.smservice.controller;

import com.sm.smservice.dto.currentServerInfo;
import com.sm.smservice.dto.postTestDto;
import com.sm.smservice.dto.wtmCalPolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class corsControlloer
{

    int i = 0;

    @Autowired
    private com.sm.smservice.service.currentNHServerInfoRepo currentNHServerInfoRepo;
    @Autowired
    private com.sm.smservice.service.wtmCalPolUserInfoRepo wtmCalPolUserInfoRepo;

    @GetMapping("/hello1")
    public List<currentServerInfo> ssView()
    {
        return currentNHServerInfoRepo.findServerInfo();
    }

    @GetMapping("/hello2")
    public List<String> ssView2()
    {
        return currentNHServerInfoRepo.findServerIp();
    }

    @GetMapping("sm/hello3")
    public List<wtmCalPolUser> ssView3()
    {
        return wtmCalPolUserInfoRepo.findTempletUserInfo();
    }

    @GetMapping("/hello4{uid}")
    public List<wtmCalPolUser> ssView4(@RequestParam(value = "uid")String uid)
    {
        return wtmCalPolUserInfoRepo.findTempletNumber(uid);
    }

    @PostMapping("/hello5{uid}")
    public List<wtmCalPolUser> ssView5(@RequestBody postTestDto postTestDto)
    {
        String uid = postTestDto.getUid();
        return wtmCalPolUserInfoRepo.findTempletNumber(uid);
    }

    @PostMapping("/hello6")
    public void ssView6(@RequestBody wtmCalPolUser postTestDto)
    {
        wtmCalPolUserInfoRepo.insertTempletInfo(postTestDto);
    }

    @PostMapping("/hello7")
    public void ssVIew7(@RequestBody wtmCalPolUser postTestDto)
    {
        wtmCalPolUserInfoRepo.updateTempletInfo(postTestDto);
    }

    @PostMapping("/hello8")
    public void ssVIew8(@RequestBody wtmCalPolUser postTestDto)
    {
        wtmCalPolUserInfoRepo.deleteTempletInfo(postTestDto);
    }

    @PutMapping("/hello9{uid}")
    public void ssVIew9(@RequestBody wtmCalPolUser postTestDto)
    {
        wtmCalPolUserInfoRepo.putUpdateTempletInfo(postTestDto);
    }

}
