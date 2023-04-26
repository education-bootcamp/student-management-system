package lk.developersstack.lms.dto;

public class CreateLaptopDto {
    private long studentId;
    private String brand;

    public CreateLaptopDto() {
    }

    public CreateLaptopDto(long studentId, String brand) {
        this.studentId = studentId;
        this.brand = brand;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
