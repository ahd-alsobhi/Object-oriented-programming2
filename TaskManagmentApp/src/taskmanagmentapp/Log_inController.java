package taskmanagmentapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.Node;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Log_inController implements Initializable {

    @FXML
    private JFXPasswordField passWord;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXButton LogInButton;
    @FXML
    private JFXButton SignUpButtonPage;
    @FXML

    JFrame dialog = new JFrame();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;

    public Connection connectDB() {

        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "a12345");

            return connect;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void LogInButtonHandler(ActionEvent event) {

        connect = connectDB();

        try {

            String sql = "SELECT * FROM USERS WHERE ID_USERS = ? and Password_USERS = ?";
            statement = connect.prepareStatement(sql);

            statement.setString(1, userName.getText());
            statement.setString(2, passWord.getText());

            result = statement.executeQuery();

            if (result.next()) {

                LogInButton.getScene().getWindow().hide();

                Parent root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

            } else {
                JOptionPane.showMessageDialog(dialog, "الرقم الجامعي خاطئة/كلمة المرور");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    private void SignUpButtonPageHandle(ActionEvent event) {
       try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        } 
        
    }
     

}