package lk.developersstack.lms.dto;

import java.util.Date;

public class CustomRegistrationData {
    private Date date;
    private String student;
    private String title;

    public CustomRegistrationData() {
    }

    public CustomRegistrationData(Date date, String student, String title) {
        this.date = date;
        this.student = student;
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CustomRegistrationData{" +
                "date=" + date +
                ", student='" + student + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
