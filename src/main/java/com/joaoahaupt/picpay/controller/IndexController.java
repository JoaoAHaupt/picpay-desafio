package com.joaoahaupt.picpay.controller;

import com.nimbusds.jose.shaded.gson.JsonObject;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("For docs go to /swagger-ui/index.html#/", HttpStatus.OK);
    }

}
