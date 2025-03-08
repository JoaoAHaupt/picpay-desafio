package com.joaoahaupt.picpay.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wallets")
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "wallet")
    private User user;

    @Column
    private Double balance;

    public void increaseBalance(Double value){
        this.balance = balance+value;
    }

    public void decreaseBalance(Double value){
        this.balance = balance-value;
    }
}
