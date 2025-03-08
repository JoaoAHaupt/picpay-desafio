package com.joaoahaupt.picpay.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
public class Companie extends User {

    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

    public Companie() {

    }
}
