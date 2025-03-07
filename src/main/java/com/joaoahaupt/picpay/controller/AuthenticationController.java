package com.joaoahaupt.picpay.controller;

import com.joaoahaupt.picpay.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/singup")
    public void singup(@RequestBody User user){}

    @PostMapping("/login")
    public void login(@RequestBody User user){}

}
