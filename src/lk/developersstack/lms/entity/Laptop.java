package lk.developersstack.lms.entity;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laptop_id")
    private long id;
    private String brand;

    //--------------mapping--------------
    @OneToOne
    @JoinColumn(
            name = "student_id",
            unique = true
    )
    private Student student;
    //--------------mapping--------------

    public Laptop() {
    }

    public Laptop(long id, String brand) {
        this.id = id;
        this.brand = brand;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
