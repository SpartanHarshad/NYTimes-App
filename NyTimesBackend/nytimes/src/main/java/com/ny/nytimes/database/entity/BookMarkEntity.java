package com.ny.nytimes.database.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity()
@Table(name = "bookmarktable")
public class BookMarkEntity {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "email")
    String email;

    @Column(name = "subsection")
    String subsection;

    @Column(name = "title")
    String title;

    @Column(name = "url")
    String url;

    @Column(name = "uri")
    String uri;

    @Column(name = "byline")
    String byline;

    @Column(name = "item_type")
    String item_type;

    @Column(name = "updated_date")
    String updated_date;

    @Column(name = "created_date")
    String created_date;

    @Column(name = "published_date")
    String published_date;

    @Column(name = "image_low")
    String image_low;

    @Column(name = "image_high")
    String image_high;

    @Column(name = "abstract")
    String abstractt;

    @Column(name = "type")
    String type;


    public BookMarkEntity() {
    }

    public BookMarkEntity(String email, String subsection, String title, String url, String uri, String byline, String item_type, String updated_date, String created_date, String published_date, String image_low, String image_high, String abstractt, String type) {
        this.email = email;
        this.subsection = subsection;
        this.title = title;
        this.url = url;
        this.uri = uri;
        this.byline = byline;
        this.item_type = item_type;
        this.updated_date = updated_date;
        this.created_date = created_date;
        this.published_date = published_date;
        this.image_low = image_low;
        this.image_high = image_high;
        this.abstractt = abstractt;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getImage_low() {
        return image_low;
    }

    public void setImage_low(String image_low) {
        this.image_low = image_low;
    }

    public String getImage_high() {
        return image_high;
    }

    public void setImage_high(String image_high) {
        this.image_high = image_high;
    }

    public String getAbstractt() {
        return abstractt;
    }

    public void setAbstractt(String abstractt) {
        this.abstractt = abstractt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}