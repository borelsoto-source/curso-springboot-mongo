package com.juansoto.workshopmongo.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String text;
    private LocalDateTime date;
    private AuthorDTO author;

    public CommentDTO(){
    }

    public CommentDTO(String text, LocalDateTime date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
