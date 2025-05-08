package org.sunil_spring_demo.notes_web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notes")
public class Notes {
    //fields
    @Id
    private int id;

    private String date;

    private String mood;

    private String text;

    //constructors

    public Notes() {
    }

    public Notes(String date, String mood, String text) {
        this.date = date;
        this.mood = mood;
        this.text = text;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
