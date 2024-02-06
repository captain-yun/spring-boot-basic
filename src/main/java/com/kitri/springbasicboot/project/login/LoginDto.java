package com.kitri.springbasicboot.project.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    String email;
    String password;
    String rememberEmail;
}
