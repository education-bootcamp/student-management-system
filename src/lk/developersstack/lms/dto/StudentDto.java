package lk.developersstack.lms.dto;

import lk.developersstack.lms.entity.Book;
import lk.developersstack.lms.entity.Laptop;
import lk.developersstack.lms.entity.Program;

import java.util.ArrayList;
import java.util.List;

public class StudentDto {
    private long id;
    private String name;
    private String contact;

    private Laptop laptop;
    private List<Book> books = new ArrayList<>();
    private List<Program> programs = new ArrayList<>();

    public StudentDto(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
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
