package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.DashboardBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.tdm.StudyAllStudentTm;

import java.util.List;

public class DashboardController {

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane dashboardForm;

    @FXML
    private Label lblStudentCount;

    @FXML
    private Label lblTotalPrograms;

    @FXML
    private Label lblTotalStudent;

    @FXML
    private TableView<StudyAllStudentTm> tblStudyAll;

    DashboardBO dashboardBO = (DashboardBO) BOFactory.getBO(BOFactory.BOType.DASHBOARD);

    public void initialize() {
        setCellValueFactory();
        setTotals();
        loadTableData();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("registrationDate"));
    }

    private void setTotals(){
        lblTotalPrograms.setText(String.valueOf(dashboardBO.getCulinaryProgramCount()));
        lblTotalStudent.setText(String.valueOf(dashboardBO.getStudentCount()));
    }

    private void loadTableData(){
        tblStudyAll.getItems().clear();
        ObservableList<StudyAllStudentTm> studentTms = tblStudyAll.getItems();
        List<StudentDTO> allProgramStudents = dashboardBO.getAllProgramStudents();

        for (StudentDTO studentDTO : allProgramStudents) {
            studentTms.add(new StudyAllStudentTm(studentDTO.getStudentId(),studentDTO.getName(),studentDTO.getRegistrationDate()));
        }
        tblStudyAll.setItems(studentTms);
        lblStudentCount.setText(String.valueOf(studentTms.size()));
    }

}
