package lk.developersstack.lms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.developersstack.lms.bo.BoFactory;
import lk.developersstack.lms.bo.custom.StudentBo;
import lk.developersstack.lms.dto.StudentDto;
import lk.developersstack.lms.view.tm.StudentTM;

import java.sql.SQLException;
import java.util.Optional;

public class MainFormController {
    public TextField txtName;
    public TextField txtContact;

    private final StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BoType.STUDENT);
    public TableView<StudentTM> tblStudents;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colContactNumber;
    public TableColumn colSeeMore;
    public TableColumn colDelete;

    public void initialize() throws SQLException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colSeeMore.setCellValueFactory(new PropertyValueFactory<>("seeMoreBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));

        loadAllStudents();
    }



    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();

        for (StudentDto dto :studentBo.findAllStudents()
             ) {
            Button deleteButton = new Button("Delete");
            deleteButton.setStyle("-fx-background-color: #c0392b");
            Button seeMorButton = new Button("See More");
            seeMorButton.setStyle("-fx-background-color: #2980b9");

            StudentTM tm = new StudentTM(dto.getId(), dto.getName(), dto.getContact(),
                    deleteButton,seeMorButton);
            tmList.add(tm);

            deleteButton.setOnAction(e->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> selectedButtonData = alert.showAndWait();
                if (selectedButtonData.get().equals(ButtonType.YES)){
                    try{
                        studentBo.deleteStudentById(tm.getId());
                        new Alert(Alert.AlertType.INFORMATION, "Student Deleted").show();
                        loadAllStudents();
                    }catch (Exception exception){
                        new Alert(Alert.AlertType.ERROR, "Try Again").show();
                    }
                }
            });
        }
        tblStudents.setItems(tmList);
        tblStudents.refresh();
    }

    public void btnSaveStudentOnAction(ActionEvent actionEvent) {
        StudentDto dto = new StudentDto();
        dto.setName(txtName.getText());
        dto.setContact(txtContact.getText());
        try {
            studentBo.saveStudent(dto);
            new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
            loadAllStudents();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }
}
