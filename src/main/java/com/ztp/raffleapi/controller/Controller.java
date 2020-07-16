package com.ztp.raffleapi.controller;

import com.ztp.raffleapi.security.AdminRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class Controller {

    @AdminRole
    @GetMapping("/admin")
    public String testAdmin(){
        return "OK";
    }
}
