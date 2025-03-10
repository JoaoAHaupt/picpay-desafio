package com.joaoahaupt.picpay.controller;

import com.joaoahaupt.picpay.dto.UserDetails;
import com.joaoahaupt.picpay.model.Company;
import com.joaoahaupt.picpay.model.User;
import com.joaoahaupt.picpay.model.Wallet;
import com.joaoahaupt.picpay.service.CnpjService;
import com.joaoahaupt.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final CnpjService cnpjService;

    @Autowired
    public AuthController(UserService userService, CnpjService cnpjService) {
        this.userService = userService;
        this.cnpjService = cnpjService;
    }

    @GetMapping
    public ResponseEntity<List<User>> users(){
        return  new ResponseEntity<>(userService.returnAllUsers(), HttpStatus.OK);
    }

    // COMPANY NÃO FICA ACHANDO QUE É USUARIO NORMAL AQUI (recado pra mim mesmo do futuro)
    @PostMapping("/singup/company")
    public ResponseEntity<String> singupCompanie(@RequestBody UserDetails userDetails)  {

        Wallet wallet =  Wallet.builder().balance(0.0).build();

        try {
            userService.saveUser(
                    Company.builder()
                            .username(userDetails.getUsername())
                            .email(userDetails.getEmail())
                            .password(userDetails.getPassword())
                            .cnpj(userDetails.getUniqueNumber())
                            .wallet(wallet)
                            .build()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body("User sing up.");

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: username, cnpj or email already exists.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor.");
        }
    }


    @PostMapping("/login")
    public void login(@RequestBody User user){

    }

}
