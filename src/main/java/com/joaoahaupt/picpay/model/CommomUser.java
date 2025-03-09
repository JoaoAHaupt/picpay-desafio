package com.joaoahaupt.picpay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
public class CommomUser extends User {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public CommomUser() {

    }
}
