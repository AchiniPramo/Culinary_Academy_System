package Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HeadMainFormController {

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnProgram;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private JFXButton btnStudent;

    @FXML
    private JFXButton btnView;

    @FXML
    private AnchorPane changeForm;

    @FXML
    private AnchorPane dashboardFrom;

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            changeForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/dashboardForm.fxml")));
//            defaultDesignButton();
//            changeDesignButton(btnDashboard);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnProgramOnAction(ActionEvent event) {
        try {
            changeForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/programForm.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {
        try {
            changeForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/settingForm.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        try {
            changeForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/studentForm.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnViewOnAction(ActionEvent event) {
        try {
            changeForm.getChildren().setAll((Node) FXMLLoader.load(this.getClass().getResource("/viewStudentDetailsForm.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void logOutAction(MouseEvent event) {
        try {
            Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource("/loginForm.fxml")));
            Stage stage = (Stage) dashboardFrom.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
