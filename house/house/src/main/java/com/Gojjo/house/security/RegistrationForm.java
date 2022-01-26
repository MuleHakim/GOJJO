package com.Gojjo.house.security;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
    @NotBlank(message = "User Name can not be empty!!")
    @Column(unique = true)
    private String username;
    @NotBlank(message = "Full-Name can not be empty!!")
    private String fullName;
    @ValidPassword
    private String password;
    @NotBlank(message = "Email can not be empty!!")
    @Email(message = "Wrong e-mail")
    private String email;
    private String role = "USER";

    User toUser(PasswordEncoder encoder){
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setEmail(this.email);
        user.setFullName(this.fullName);
        user.setRole(this.role);
        

        return user;
    }
}
