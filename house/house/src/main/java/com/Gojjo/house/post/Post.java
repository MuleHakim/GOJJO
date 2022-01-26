// package com.gojjo.gojjo_app;

// import java.beans.Transient;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// import javax.validation.constraints.Size;

// import com.gojjo.gojjo_app.security.User;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Data
// @NoArgsConstructor
// public class Post {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long id;

//     private String username;
//     private String city;
//     private String sub_city;
//     private String street;
//     private String phone_number;
//     private String price;

//     // @ManyToOne
//     private User user;

//     @Size(max = 25)
//     private String description;

//     @Column(nullable = true, length = 64)
//     private String imageFIle;

//     @Transient
//     public String getPhotosImagePath() {
//         if (imageFIle == null || id == null) return null;
         
//         return "/user-photos/" + id + "/" + imageFIle;
//     }
  
    

// }

package com.Gojjo.house.post;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
// import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "City can not be empty!!")
    private String city;
    @NotBlank(message = "Sub-city can not be empty!!")
    private String sub_city;
    @NotBlank(message = "Street can not be empty!!")
    private String street;
    @NotBlank(message = "Mobile number can not be empty!!")
    @Pattern(regexp = "^(09)([0-9]{8})$", message = "Mobile number is invalid for Ethiopia!! /09----")
    private String phone_number;
    @NotBlank(message = "Price can not be empty!!")
    private String price;
    @NotBlank(message = "User Name can not be empty!!")
    private String username;
    @NotEmpty(message = "Description can not be empty!!")
    private String description;

    // @NotEmpty(message = "Image can not be empty!!")
    @Column(nullable = true, length = 64)
    private String imageFIle;

    @Transient
    public String getPhotosImagePath() {
        if (imageFIle == null || id == null) return null;
         
        return "/user-photos/" + id + "/" + imageFIle;
    }

}
