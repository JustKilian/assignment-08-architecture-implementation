package se2324.assignment08architectureimplementationsimonkiliannils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PopUpController {
    public Label label;
    @FXML
    private Button ok;

    @FXML
    protected void onOkClick() {
        Stage stage = (Stage) ok.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
