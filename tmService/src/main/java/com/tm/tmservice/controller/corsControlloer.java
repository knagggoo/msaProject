package com.tm.tmservice.controller;

import com.tm.tmservice.dto.currentServerInfo;
import com.tm.tmservice.dto.postTestDto;
import com.tm.tmservice.dto.wtmCalPolUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class corsControlloer
{
    @Autowired
    private com.tm.tmservice.service.currentNHServerInfoRepo currentNHServerInfoRepo;
    @Autowired
    private com.tm.tmservice.service.wtmCalPolUserInfoRepo wtmCalPolUserInfoRepo;
    @Autowired
    private RestTemplate restTemplate;

    private static final String cmServiceName = "CM-SERVICE";

//    @GetMapping("/hello1")
//    public List<currentServerInfo> ssView()
//    {
//        return currentNHServerInfoRepo.findServerInfo();
//    }

    @GetMapping("tm/hello1")
    public String ssView()
    {
        ResponseEntity<String> ackMessage;
        String apiPath = "/cm/hello3";

        ackMessage = restTemplate.getForEntity("http://" + cmServiceName + apiPath, String.class);

        return ackMessage.toString();

    }

    @GetMapping("/hello2")
    public List<String> ssView2()
    {
        return currentNHServerInfoRepo.findServerIp();
    }

    @GetMapping("tm/hello3")
    public List<wtmCalPolUser> ssView3()
    {
        return wtmCalPolUserInfoRepo.findTempletUserInfo();
    }

    @GetMapping("/tm/hello4{uid}")
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

    @PostMapping("dr/hello6")
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
