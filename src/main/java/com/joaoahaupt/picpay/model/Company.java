package com.joaoahaupt.picpay.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
@Data
public class Company extends User {

    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

    public Company() {
    }
}
