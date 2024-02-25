package com.learning.springboot;

public class Course {
    private int id;
    private String subject;
    private String author;

    public Course(int id, String subject, String author) {
        this.id = id;
        this.subject = subject;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
