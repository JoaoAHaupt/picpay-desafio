package com.joaoahaupt.picpay.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TrasnferController {

    @PostMapping
    public void pay(@RequestBody Double value, Long idPayee){

    }

}
