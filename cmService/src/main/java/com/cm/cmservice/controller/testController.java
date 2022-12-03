package com.cm.cmservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class testController
{
    @RequestMapping(value = "/rr", method = RequestMethod.GET)
    public String isRunning()
    {
        return "isRunning : " + new Date();
    }

    @GetMapping(value = "/test")
    public String test()
    {
        return "test : " + new Date();
    }
}
