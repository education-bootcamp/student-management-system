package lk.developersstack.lms.dto;

public class ProgramDto {
    private String title;
    private int credit;

    public ProgramDto() {
    }

    public ProgramDto(String title, int credit) {
        this.title = title;
        this.credit = credit;
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
