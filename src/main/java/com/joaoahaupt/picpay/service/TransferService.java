package com.joaoahaupt.picpay.service;

import com.joaoahaupt.picpay.model.User;
import com.joaoahaupt.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TransferService {

    private UserService userService;

    @Autowired
    public TransferService(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    public void pay(Long idPayee, Long idPayer, Double value) throws Exception {

        User payer = userService.findUserById(idPayer);
        User payee = userService.findUserById(idPayee);

        checkBalance(payer, value);

        transferMoney(payer, payee, value);

        userService.saveUser(payer);
        userService.saveUser(payee);

    }

    private void checkBalance(User user, Double value) throws  Exception{
        if(user.getWallet().getBalance() < value){
            throw new Exception("");
        }
    }

    private void transferMoney(User payer, User payee, Double value) throws  Exception{
        payer.getWallet().decreaseBalance(value);
        payee.getWallet().increaseBalance(value);
    }
}
