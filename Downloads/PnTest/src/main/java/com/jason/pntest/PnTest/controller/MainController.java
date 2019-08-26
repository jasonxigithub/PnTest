package com.jason.pntest.PnTest.controller;

import com.jason.pntest.PnTest.fcm.FcmService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Value("${name}")
    private String name;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){

        try {
            FcmService.send();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "success";
    }
}
