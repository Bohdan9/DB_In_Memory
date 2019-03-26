package com.example.demo.models;


import com.example.demo.models.enums.Color;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    private long id;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Color color;

    public Article() {
    }

    public Article(String text, User user, Color color) {
        this.text = text;
        this.user = user;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //Only for console testing
    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", color=" + color +
                '}';
    }
}
