package com.joaoahaupt.picpay.controller;

import com.joaoahaupt.picpay.dto.UserDetails;
import com.joaoahaupt.picpay.model.Company;
import com.joaoahaupt.picpay.model.User;
import com.joaoahaupt.picpay.model.Wallet;
import com.joaoahaupt.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> users(){
        return  userService.returnAllUsers();
    }

    @PostMapping("/singup/company")
    public void singupCompanie(@RequestBody UserDetails userDetails) throws Exception {

        if(!userService.isCnpjValid(userDetails.getUniqueNumber())){
            throw new Exception("Invalid CNPJ");
        }
        Wallet wallet =  Wallet.builder().balance(0.0).build();

        userService.saveUser(
                Company.builder()
                        .username(userDetails.getUsername())
                        .email(userDetails.getEmail())
                        .password(userDetails.getPassword())
                        .cnpj(userDetails.getUniqueNumber())
                        .wallet(wallet)
                        .build()
        );
    }

    @PostMapping("/login")
    public void login(@RequestBody User user){

    }

}
