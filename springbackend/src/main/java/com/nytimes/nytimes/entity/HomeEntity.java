package com.nytimes.nytimes.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "home")
public class HomeEntity {
    @Id
    @Column(name = "id")
    int id;

    @Column(name = "category")
    String category;

    @Column(name = "headline")
    String headline;

    @Column(name = "description")
    String description;

    @Column(name = "imageurl")
    String imageurl;

    @Column(name = "smalltitle")
    String smalltitle;


    public HomeEntity(String category, String headline, String description, String imageurl, String smalltitle) {
        this.category = category;
        this.headline = headline;
        this.description = description;
        this.imageurl = imageurl;
        this.smalltitle = smalltitle;
    }

    public HomeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getSmalltitle() {
        return smalltitle;
    }

    public void setSmalltitle(String smalltitle) {
        this.smalltitle = smalltitle;
    }

}
