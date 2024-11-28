package lk.ijse.exception;

import javafx.scene.control.Alert;

public class ExceptionHandler {

    public static void handleException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}
