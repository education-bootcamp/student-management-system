package lk.developersstack.lms.entity;

import javax.persistence.Entity;

@Entity
public class Student {
    private long id;
    private String name;
    private String contact;

    public Student() {
    }

    public Student(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
