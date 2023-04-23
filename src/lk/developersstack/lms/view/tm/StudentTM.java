package lk.developersstack.lms.view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private long id;
    private String name;
    private String contact;
    private Button deleteBtn;
    private Button seeMoreBtn;

    public StudentTM() {
    }

    public StudentTM(long id, String name, String contact, Button deleteBtn, Button seeMoreBtn) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.deleteBtn = deleteBtn;
        this.seeMoreBtn = seeMoreBtn;
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

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public Button getSeeMoreBtn() {
        return seeMoreBtn;
    }

    public void setSeeMoreBtn(Button seeMoreBtn) {
        this.seeMoreBtn = seeMoreBtn;
    }
}
