package lk.developersstack.lms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long id;
    private String name;
    private String contact;

    //--------------mapping--------------
    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "student",
            fetch = FetchType.EAGER)
    private Laptop laptop;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "student",
            fetch = FetchType.EAGER
    )
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations =
            new ArrayList<>();

    //--------------mapping--------------

    public Student() {
    }

    public Student(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
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
