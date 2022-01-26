package com.Gojjo.house.news;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message="title cannot be empty.")
    private String title;
    @NotEmpty(message="Please write news body.")
    private String messageBody;
    @NotEmpty(message="Date cannot be empty.")
    private String date;

    @Column(nullable = true, length = 64)
    private String imageFile;

    @Transient
    public String getPhotosImagePath() {
        if (imageFile == null || id == null) return null;
        return "/news-photos/" + id + "/" + imageFile;
    }
    
}