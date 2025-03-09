package com.joaoahaupt.picpay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "wallets")
@Data
@Builder
@AllArgsConstructor
public class Wallet {
    public Wallet() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "wallet")
    @JsonIgnore
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
