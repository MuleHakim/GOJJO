package com.Gojjo.house.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Last-Name can not be null!!")
    @NotEmpty(message = "Last-Name can not be empty!!")
    private String name;
    @NotNull(message = "Email can not be null!!")
    @NotEmpty(message = "Email can not be empty!!")
    @Email(message = "Wrong e-mail")
    private String email;
    @NotNull(message = "Please leave ur comment. This is useful for us")
    @NotEmpty(message = "Please leave ur comment. This is useful for us")
    private String comment;
}
