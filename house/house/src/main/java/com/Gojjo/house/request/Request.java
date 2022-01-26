package com.Gojjo.house.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Request  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
   
    private String houseType;
    @NotBlank(message = "City name is required")
    private String city;
    @Min(value=1)
    private int bedroom;
    @NotBlank(message = "Subcity name is required")
    private String subcity;
    @NotBlank(message = "Some description is required.")
    private String description;
    private int price;
    private String district;
    @NotBlank(message = "Fullname is required ")
    private String fullName;
    @Email
    private String email;
    @Pattern(regexp = "^(09)([0-9]{8})$", message = "Mobile number is invalid for Ethiopia!!")
    private String phone;
}
