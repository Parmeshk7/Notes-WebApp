package com.nagarro.notesapp.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Note {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer noteId;
    private String title;
    @Column(length = 500)
    private String content;
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


    public Integer getNoteId() {

        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equals(noteId, note.noteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId);
    }
}
