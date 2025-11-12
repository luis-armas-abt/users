package com.bcp.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/bcp/users")
public class UserController {

    @GetMapping
    public String getUser (){
        String names = "Pepito, Juanito";
        return names;
    }


}
