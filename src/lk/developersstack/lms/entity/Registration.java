package lk.developersstack.lms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.util.Date;

@Entity
public class Registration {
    @EmbeddedId
    private RegistrationIds registrationIds=new RegistrationIds();/*we should initialize the object*/


    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("programId")
    private Program program;

    private Date regDate;

    public Registration() {
    }

    public Registration(RegistrationIds registrationIds, Student student, Program program, Date regDate) {
        this.registrationIds = registrationIds;
        this.student = student;
        this.program = program;
        this.regDate = regDate;
    }

    public RegistrationIds getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(RegistrationIds registrationIds) {
        this.registrationIds = registrationIds;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
