package com.joaoahaupt.picpay.controller;

import com.joaoahaupt.picpay.dto.UserDetails;
import com.joaoahaupt.picpay.model.Companie;
import com.joaoahaupt.picpay.model.ComumUser;
import com.joaoahaupt.picpay.model.User;
import com.joaoahaupt.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

        @PostMapping("/singup/companie")
    public void singupUser(@RequestBody UserDetails userDetails) throws Exception {

        /*if(!userService.isCnpjValid(userDetails.getUniqueNumber())){
                throw new Exception("Invalid CNPJ");
            }
*/
            userService.saveUser(
                    ComumUser.builder()
                            .username(userDetails.getUsername())
                            .email(userDetails.getEmail())
                            .password(userDetails.getPassword())
                            .cpf(userDetails.getUniqueNumber())
                            .build()
            );
    }

    @PostMapping("/singup/companie")
    public void singupCompanie(@RequestBody UserDetails userDetails) throws Exception {

        if(!userService.isCnpjValid(userDetails.getUniqueNumber())){
            throw new Exception("Invalid CNPJ");
        }

        userService.saveUser(
                Companie.builder()
                        .username(userDetails.getUsername())
                        .email(userDetails.getEmail())
                        .password(userDetails.getPassword())
                        .cnpj(userDetails.getUniqueNumber())
                        .build()
        );
    }

    @PostMapping("/login")
    public void login(@RequestBody User user){

    }

}
