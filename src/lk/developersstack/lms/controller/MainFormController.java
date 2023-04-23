package lk.developersstack.lms.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.developersstack.lms.bo.BoFactory;
import lk.developersstack.lms.bo.custom.StudentBo;
import lk.developersstack.lms.dto.StudentDto;

public class MainFormController {
    public TextField txtName;
    public TextField txtContact;

    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        StudentDto dto = new StudentDto();
        dto.setName(txtName.getText());
        dto.setContact(txtContact.getText());
        try {
            studentBo.saveStudent(dto);
            new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }
}
