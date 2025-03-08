package com.joaoahaupt.picpay.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetails {
    private String username;
    private String email;
    private String password;
    private String uniqueNumber;

}
