package Controller;

import bo.BOFactory;
import bo.custom.LoginBO;
import dto.UserDTO;
import exeptions.ExceptionHandler;
import exeptions.InvalidCredentialsException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.PasswordStorage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField inputPassword;

    @FXML
    private TextField inputUserName;


    @FXML
    private AnchorPane logInForm;

    LoginBO loginBO = (LoginBO) BOFactory.getBO(BOFactory.BOType.LOGIN);
    public static UserDTO userDTO;

    @FXML
    void goToSignUpOnAction(MouseEvent event) {
        try {
            logInForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/signUpForm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void inputPasswordOnAction(ActionEvent event) {
        loginOnAction(event);
    }

    @FXML
    void inputUserNameOnAction(ActionEvent event) {
        inputPassword.requestFocus();
    }

    @FXML
    void loginOnAction(ActionEvent event) {

        if (!inputUserName.getText().isEmpty() && !inputPassword.getText().isEmpty()){
             try {
                 UserDTO loginUser = loginBO.getUser(inputUserName.getText().trim());
                 if (PasswordStorage.checkPassword(inputPassword.getText().trim(),loginUser.getPassword())){
                        OpenHeaderPage();
                        userDTO = loginUser ;
                 }else {
                     new Alert(Alert.AlertType.ERROR,"Invalid User Password Please Recheck The Password Please !!").show();
                 }

             }catch (InvalidCredentialsException e){
                 ExceptionHandler.handleException(e);
             }
        }else {
            new Alert(Alert.AlertType.WARNING,"Please Enter All Fields .  !!").show();

        }
    }

    private void OpenHeaderPage(){
        try {
            Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/headMainForm.fxml")));
            Stage stage = (Stage) logInForm.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
