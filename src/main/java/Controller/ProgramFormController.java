package Controller;

import bo.BOFactory;
import bo.custom.ProgramBO;
import dto.CulinaryProgramDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import tdm.ProgramTm;
import util.Regex;

import java.util.ArrayList;
import java.util.List;

public class  ProgramFormController {
    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colProgramName;

    @FXML
    private AnchorPane programForm;

    @FXML
    private TableView<ProgramTm> tblProgram;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtFee;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    ProgramBO programBO = (ProgramBO) BOFactory.getBO(BOFactory.BOType.PROGRAM);

    public void initialize() {
        setCellValueFactory();
        loadAllPrograms();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
    }

    private String convertDurationToString(int duration){
        String durationString = "";

        if(duration > 11){
            int years = duration / 12;
            int months = duration % 12;

            if (months == 0){
                durationString = years + " years";
            } else {
                durationString = years + " years " + months + " months";
            }
        } else {
            durationString = duration + " months";
        }
        return durationString;
    }

    private void loadAllPrograms(){
        List<CulinaryProgramDTO> programs = programBO.getAllCulinaryProgram();
        tblProgram.getItems().clear();
        ObservableList<ProgramTm> programTms = tblProgram.getItems();
        for (CulinaryProgramDTO program : programs) {
            String duration = convertDurationToString(program.getDuration());
            programTms.add(new ProgramTm(program.getProgramId(),program.getProgramName(),duration,program.getFee()));
        }
        tblProgram.setItems(programTms);
    }

    private void clearData(){
        txtDuration.clear();
        txtFee.clear();
        txtId.clear();
        txtName.clear();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearData();
    }

    public boolean isValied() {
        if (!Regex.setTextColor(util.TextField.PROGRAMID, txtId)) return false;
        if (!Regex.setTextColor(util.TextField.NAME, txtName)) return false;
        if (!Regex.setTextColor(util.TextField.MONTH, txtDuration)) return false;
        if (!Regex.setTextColor(util.TextField.PRICE, txtFee)) return false;
        return true;
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
            if (isValied() && !txtId.getText().isEmpty()){
                programBO.deleteCulinaryProgram(programBO.getCulinaryProgram(txtId.getText().trim()));
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }

    }

    private CulinaryProgramDTO getObject(){
        return new CulinaryProgramDTO(txtId.getText(),txtName.getText(),Integer.parseInt(txtDuration.getText()),Double.parseDouble(txtFee.getText()),new ArrayList<>());
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {

            if (isValied() && !txtId.getText().isEmpty()){
                programBO.saveCulinaryProgram(getObject());
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

            if (isValied() && !txtId.getText().isEmpty()){
                programBO.updateCulinaryProgram(getObject());
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }

    }

    @FXML
    void txtDurationKeyAction(KeyEvent event) {
        Regex.setTextColor(util.TextField.MONTH, txtDuration);
    }

    @FXML
    void txtDurationOnAction(ActionEvent event) {
        txtFee.requestFocus();

    }

    @FXML
    void txtFeeKeyAction(KeyEvent event) {
        Regex.setTextColor(util.TextField.PRICE, txtFee);
    }

    @FXML
    void txtIdKeyAction(KeyEvent event) {
        Regex.setTextColor(util.TextField.PROGRAMID, txtId);
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtName.requestFocus();
    }

    @FXML
    void txtNameKeyAction(KeyEvent event) {
        Regex.setTextColor(util.TextField.NAME, txtName);
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtDuration.requestFocus();
    }
}
