package lk.developersstack.lms.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private long id;
    private String title;
    private int credit;

    //--------------mapping--------------


    @OneToMany(mappedBy = "program")
    private List<Registration> registrations =
            new ArrayList<>();

    //--------------mapping--------------

    public Program() {
    }

    public Program(long id, String title, int credit) {
        this.id = id;
        this.title = title;
        this.credit = credit;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
