package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.dto.CulinaryProgramDTO;
import lk.ijse.tdm.ProgramTm;
import lk.ijse.util.Regex;

import java.util.ArrayList;
import java.util.List;

public class ProgramFormController {

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colFee;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colProgramName;

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

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearData();
    }

    private void clearData(){
        txtDuration.clear();
        txtFee.clear();
        txtId.clear();
        txtName.clear();
    }

    private CulinaryProgramDTO getObject(){
        return new CulinaryProgramDTO(txtId.getText(),txtName.getText(),Integer.parseInt(txtDuration.getText()),Double.parseDouble(txtFee.getText()),new ArrayList<>());
    }

    private int convertDurationToInt(String duration){
        int years = 0;
        int months = 0;

        // Split the input string by spaces to identify the number and unit
        String[] parts = duration.split(" ");

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equalsIgnoreCase("year") || parts[i].equalsIgnoreCase("years")) {
                years = Integer.parseInt(parts[i - 1]); // Get the value before "year" or "years"
            } else if (parts[i].equalsIgnoreCase("month") || parts[i].equalsIgnoreCase("months")) {
                months = Integer.parseInt(parts[i - 1]); // Get the value before "month" or "months"
            }
        }

        // Convert years to months and add to months
        return (years * 12) + months;
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        if (!LoginFormController.userDTO.getRole().equals("Admissions Coordinator")){
            if (isValied() && !txtId.getText().isEmpty()){
                programBO.deleteCulinaryProgram(programBO.getCulinaryProgram(txtId.getText().trim()));
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"You cannot access this !!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!LoginFormController.userDTO.getRole().equals("Admissions Coordinator")){
            if (isValied() && !txtId.getText().isEmpty()){
                programBO.saveCulinaryProgram(getObject());
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"You cannot access this !!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (!LoginFormController.userDTO.getRole().equals("Admissions Coordinator")){
            if (isValied() && !txtId.getText().isEmpty()){
                programBO.updateCulinaryProgram(getObject());
                loadAllPrograms();
                clearData();
            } else {
                new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"You cannot access this !!").show();
        }
    }

    @FXML
    void tblProgramOnClickAction(MouseEvent event) {
        ProgramTm programTm = tblProgram.getSelectionModel().getSelectedItem();
        if (programTm != null) {
            txtId.setText(programTm.getId());
            txtName.setText(programTm.getProgramName());
            txtDuration.setText(String.valueOf(convertDurationToInt(programTm.getDuration().trim())));
            txtFee.setText(String.valueOf(programTm.getFee()));
        }
    }

    @FXML
    void txtDurationOnAction(ActionEvent event) {
        txtFee.requestFocus();
    }

    @FXML
    void txtIdOnAction(ActionEvent event) {
        txtName.requestFocus();
    }

    @FXML
    void txtNameOnAction(ActionEvent event) {
        txtDuration.requestFocus();
    }

    public boolean isValied() {
        if (!Regex.setTextColor(lk.ijse.util.TextField.PROGRAMID, txtId)) return false;
        if (!Regex.setTextColor(lk.ijse.util.TextField.NAME, txtName)) return false;
        if (!Regex.setTextColor(lk.ijse.util.TextField.MONTH, txtDuration)) return false;
        if (!Regex.setTextColor(lk.ijse.util.TextField.PRICE, txtFee)) return false;
        return true;
    }

    @FXML
    void txtDurationKeyAction(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.MONTH, txtDuration);
    }

    @FXML
    void txtFeeKeyAction(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.PRICE, txtFee);
    }


    @FXML
    void txtNameKeyAction(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.NAME, txtName);
    }

    @FXML
    void txtIdKeyAction(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.PROGRAMID, txtId);
    }
}
