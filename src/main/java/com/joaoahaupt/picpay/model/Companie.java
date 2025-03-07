package com.joaoahaupt.picpay.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
public class Companie extends BaseUser {

    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

}
