package Controller;

import bo.BOFactory;
import bo.custom.AddProgramBO;
import dto.CulinaryProgramDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tdm.StudentTm;
import util.Regex;

import java.util.List;

public class AddProgramFormController {
    @FXML
    private AnchorPane addProgramForm;

    @FXML
    private ChoiceBox<String> selectProgramChoiceBox;

    @FXML
    private TextField txtInstallment;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    AddProgramBO addProgramBO = (AddProgramBO) BOFactory.getBO(BOFactory.BOType.ADDPROGRAM);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Stage stage = (Stage) addProgramForm.getScene().getWindow();
        stage.close();
    }
    public void initialize() {
        setChoiceBoxData();
    }

    public void setSelectedStudent(StudentTm selectedStudent) {
        txtStudentId.setText(selectedStudent.getStudentId());
        txtStudentName.setText(selectedStudent.getName());
    }


    private void setChoiceBoxData() {
        List<CulinaryProgramDTO> program = addProgramBO.getAllCulinaryProgram();
        ObservableList<String> programNames = FXCollections.observableArrayList();

        for (CulinaryProgramDTO programDTO : program){
            programNames.add(programDTO.getProgramName());
        }
        selectProgramChoiceBox.setItems(programNames);
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (isValied() && selectProgramChoiceBox.getValue() != null){
            addProgramBO.saveProgram(txtStudentId.getText().trim(),selectProgramChoiceBox.getValue().trim(), Double.parseDouble(txtInstallment.getText().trim()));
            new Alert(Alert.AlertType.CONFIRMATION,"Program Added Successfully").show();
            btnCancelOnAction(event);
        } else {
            new Alert(Alert.AlertType.WARNING,"Please Select a Program").show();
        }
    }

    public boolean isValied() {
        if (!Regex.setTextColor(util.TextField.PRICE, txtInstallment)) return false;
        return true;
    }
    @FXML
    void txtInstallmentKeyAction(KeyEvent event) {
        Regex.setTextColor(util.TextField.PRICE, txtInstallment);
    }
}
