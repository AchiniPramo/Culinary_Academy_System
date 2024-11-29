package Controller;
import bo.BOFactory;
import bo.custom.SettingBO;
import dto.UserDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tdm.UserTm;
import util.PasswordStorage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



public class SettingFormController {

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableColumn<?, ?> colUserRole;

    @FXML
    private AnchorPane settingForm;

    @FXML
    private TableView<UserTm> tblUser;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    SettingBO settingBO = (SettingBO) BOFactory.getBO(BOFactory.BOType.SETTING);
    List<UserDTO> allUsers;
    public void initialize() {
        txtNewPassword.setVisible(false);
        txtConfirmPassword.setVisible(false);
        txtUserName.setText(LoginFormController.userDTO.getUserName());

        if (!LoginFormController.userDTO.getRole().equals("Admin")){
//            visiblePane.setVisible(false);
        }

        setCellValueFactory();
        loadAllUsers();
    }

    private void setCellValueFactory() {
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colUserRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("delete"));
    }

    private void loadAllUsers(){
        tblUser.getItems().clear();
        ObservableList<UserTm> userTms = tblUser.getItems();
        allUsers = settingBO.getAllUsers();

        for (UserDTO userDTO : allUsers) {
            userTms.add(new UserTm(userDTO.getUserName(), userDTO.getRole(), createButton()));
        }
        tblUser.setItems(userTms);
    }

    private Button createButton(){
        Button button = new Button("Delete");
        button.setStyle("-fx-background-color: red;-fx-text-fill: white;");

        button.setOnAction((e) -> {
            ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

            Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

            if(type.orElse(no) == yes) {
                int selectedIndex = tblUser.getSelectionModel().getSelectedIndex();
                try{
                    settingBO.deleteUser(allUsers.get(selectedIndex));
                    loadAllUsers();
                } catch (Exception exception){
                    new Alert(Alert.AlertType.INFORMATION,"Select Column And Remove !!").show();
                    return;
                }
                tblUser.refresh();
            }
        });

        return button;
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        if (isValied()){
            if (txtNewPassword.getText().trim().equals(txtConfirmPassword.getText().trim())){
                UserDTO userDTO = new UserDTO(LoginFormController.userDTO.getUserId(), txtUserName.getText().trim(), PasswordStorage.hashPassword(txtConfirmPassword.getText().trim()), LoginFormController.userDTO.getRole());
                settingBO.updateUser(userDTO);
                loadAllUsers();
                txtPassword.clear();
                txtConfirmPassword.clear();
                txtNewPassword.clear();
            } else {
                new Alert(Alert.AlertType.ERROR,"Incorrect Confirm Password !!").show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING,"Please Enter All Fields !!").show();
        }
    }

    @FXML
    void txtNewPasswordOnAction(ActionEvent event) {
        txtConfirmPassword.requestFocus();
    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        if (PasswordStorage.checkPassword(txtPassword.getText().trim(),LoginFormController.userDTO.getPassword())){
            txtNewPassword.requestFocus();
            txtNewPassword.setVisible(true);
            txtConfirmPassword.setVisible(true);

        } else {
            new Alert(Alert.AlertType.ERROR,"Incorrect Password !!").show();
        }
    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }
    public boolean isValied() {
        return !txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty() && !txtNewPassword.getText().isEmpty() && !txtConfirmPassword.getText().isEmpty();
    }
}
