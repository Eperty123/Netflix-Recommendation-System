package dal.util;

import javafx.scene.control.Alert;

public class MessageBox {
    public static void Show(String message, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        //alert.setHeaderText(headerMessage);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
