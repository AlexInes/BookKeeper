package book.keeper.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {

    static ResourceBundle bundle = FxmlUtils.getResourceBundle();

    public static void dialogAboutApplication() {
        Alert aboutApp = new Alert(Alert.AlertType.INFORMATION);
        aboutApp.setTitle(bundle.getString("about.title"));
        aboutApp.setHeaderText(bundle.getString("about.header"));
        aboutApp.setContentText(bundle.getString("about.content"));
        aboutApp.showAndWait();
    }

    public static Optional<ButtonType> closeAppConfirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle(bundle.getString("exit.title"));
        confirmationDialog.setHeaderText(bundle.getString("exit.header"));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;
    }

    public static void errorDialog(String error) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.title"));
        errorAlert.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);

        errorAlert.showAndWait();

    }

    public static String editDialog(String value) {
        TextInputDialog dialog = new TextInputDialog(value);
        dialog.setTitle(bundle.getString("edit.title"));
        dialog.setHeaderText(bundle.getString("edit.header"));
        dialog.setContentText(bundle.getString("edit.content"));
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
