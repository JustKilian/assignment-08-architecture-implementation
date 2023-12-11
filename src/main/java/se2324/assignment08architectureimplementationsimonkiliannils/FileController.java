package se2324.assignment08architectureimplementationsimonkiliannils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileController {
    public Button upload;
    public Button browse;
    @FXML
    private TextField input;

    @FXML
    protected void onBrowseClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        input.setText(fileChooser.showOpenDialog(new Stage()).getAbsolutePath());
    }

    @FXML
    protected void onUploadClick() {
        try {
            if (!input.getText().isEmpty()) {
                String inputText = input.getText();
                java.io.File file = new java.io.File(inputText);
                if (file.exists() && !file.isDirectory()) {
                    PopUp popUp = new PopUp();
                    popUp.start(new Stage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
