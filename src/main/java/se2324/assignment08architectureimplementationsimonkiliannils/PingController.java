package se2324.assignment08architectureimplementationsimonkiliannils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingController {
    public Button ping;
    @FXML
    private TextField input;

    @FXML
    private Label output;

    @FXML
    protected void onButtonClick() {
        String input = this.input.getText();
        if (input.isEmpty()) {
            try {
                ping("localhost");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                ping(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void ping(String input) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Check if input is an IP address
        try {
            InetAddress.getByName(input);
        } catch (UnknownHostException e) {
            this.output.setText("Invalid input!");
            return;
        }

        // Check which OS is being used
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            processBuilder.command("cmd.exe", "/c", "ping -n 1 " + input);
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            processBuilder.command("bash", "-c", "ping -c 1 " + input);
        } else {
            this.output.setText("Unsupported OS!");
            return;
        }

        Process process = processBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        int exitCode;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (exitCode == 0) {
            this.output.setText("Ping successful!\n" + output);
        } else {
            this.output.setText("Ping failed!\n" + output);
        }
    }
}
