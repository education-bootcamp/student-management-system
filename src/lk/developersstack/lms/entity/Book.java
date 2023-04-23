package lk.developersstack.lms.entity;

import javax.persistence.Entity;

@Entity
public class Book {
    private long id;
    private String title;

    public Book() {
    }

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
