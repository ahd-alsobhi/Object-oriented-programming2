package taskmanagmentapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportPageController implements Initializable {

    @FXML
    private JFXTextField firstNameTXF;
    @FXML
    private JFXTextField IDTXF;
    @FXML
    private JFXTextField EmailTXF;
    @FXML
    private JFXTextField TitleTXF;
    @FXML
    private JFXDatePicker DateTXF;
    @FXML
    private JFXTextArea TextTXF;
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton ReportButton;
    @FXML
    private JFXButton newsButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void newsButtonHandle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewsPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");

        }
    }

    private void ReportButtonHandle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReportPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    }

    private void homeButtonHandle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("taskBourdPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }

    }
}
