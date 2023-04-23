package lk.developersstack.lms.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long id;
    private String title;

    //--------------mapping--------------
    @ManyToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
    //--------------mapping--------------

    public Book() {
    }

    public Book(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
