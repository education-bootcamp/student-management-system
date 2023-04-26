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
    public Button btnStudentSave;
    public TextField txtLapBrand;
    public TextField txtLapSearch;
    public TableView tblLaptops;
    public TableColumn colLapId;
    public TableColumn colBrand;
    public TableColumn colLapDelete;
    public ComboBox cmbStudent;

    public void initialize() throws SQLException, ClassNotFoundException {

        colStudentId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colSeeMore.setCellValueFactory(new PropertyValueFactory<>("seeMoreBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));

        loadAllStudents();
        loadAllStudentsForLaptopSection();
        //------------------------Listener---------------------
        tblStudents.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        selectedStudentTm = newValue;
                        txtName.setText(newValue.getName());
                        txtContact.setText(newValue.getContact());
                        btnStudentSave.setText("Update Student");
                    }
                });
        //------------------------Listener---------------------

    }

    private void loadAllStudentsForLaptopSection() throws SQLException, ClassNotFoundException {
       ObservableList<Long> obList = FXCollections.observableArrayList();
        for (StudentDto dto:studentBo.findAllStudents()
             ) {
            obList.add(dto.getId());
        }
        cmbStudent.setItems(obList);
    }


    private StudentTM selectedStudentTm = null;


    private void loadAllStudents() throws SQLException, ClassNotFoundException {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();

        for (StudentDto dto : studentBo.findAllStudents()
        ) {
            Button deleteButton = new Button("Delete");
            deleteButton.setStyle("-fx-background-color: #c0392b");
            Button seeMorButton = new Button("See More");
            seeMorButton.setStyle("-fx-background-color: #2980b9");

            StudentTM tm = new StudentTM(dto.getId(), dto.getName(), dto.getContact(),
                    deleteButton, seeMorButton);
            tmList.add(tm);

            deleteButton.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> selectedButtonData = alert.showAndWait();
                if (selectedButtonData.get().equals(ButtonType.YES)) {
                    try {
                        studentBo.deleteStudentById(tm.getId());
                        new Alert(Alert.AlertType.INFORMATION, "Student Deleted").show();
                        loadAllStudents();
                    } catch (Exception exception) {
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


        if (btnStudentSave.getText().equals("Update Student")) {

            if (selectedStudentTm == null) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
                return;
            }
            try {
                dto.setId(selectedStudentTm.getId());
                studentBo.updateStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Updated").show();
                selectedStudentTm = null;
                btnStudentSave.setText("Save Student");
                loadAllStudents();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        } else {
            try {
                studentBo.saveStudent(dto);
                new Alert(Alert.AlertType.INFORMATION, "Student Saved").show();
                loadAllStudents();
                loadAllStudentsForLaptopSection();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Try Again").show();
            }
        }


    }

    public void newStudentOnAction(ActionEvent actionEvent) {
        btnStudentSave.setText("Save Student");
        selectedStudentTm = null;
    }
}
