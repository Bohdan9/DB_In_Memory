package com.example.demo.models;
import com.example.demo.models.Enums.Color;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private Color color;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    private User user;

    public Article() {
    }

    public Article(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                Objects.equals(text, article.text) &&
                color == article.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, color);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color=" + color +
                '}';
    }


}