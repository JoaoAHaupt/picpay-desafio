package com.joaoahaupt.picpay.controller;

import com.joaoahaupt.picpay.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TrasnferController {
    private final TransferService transferService;

    @Autowired
    public TrasnferController(TransferService transferService) {
        this.transferService = transferService;
    }


    @PostMapping
    public void pay(@RequestBody Double value, Long idPayee) throws Exception {
        if(value<0){
            throw new IllegalArgumentException("Send a valid number");
        }
        transferService.pay(idPayee, 1L, value);
    }


}
