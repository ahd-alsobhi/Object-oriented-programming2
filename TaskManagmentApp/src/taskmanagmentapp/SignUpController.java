/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagmentapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SignUpController implements Initializable {

    @FXML
    private JFXRadioButton Female;
    @FXML
    private JFXRadioButton Male;
    @FXML
    private JFXTextField firstNameTXF;
    @FXML
    private JFXTextField IDTXF1;
    @FXML
    private JFXButton SignupButton;
    @FXML
    private JFXTextField lastNameTXF;
    @FXML
    private JFXDatePicker BirthdayDate;
    @FXML
    private JFXTextField EmailTXF;
    @FXML
    private JFXPasswordField SignPasswordTXF;
    @FXML
    private JFXButton LoginpButtonPage;
    JFrame dialog = new JFrame();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    
    
    //database tools
    private Connection connect;
    private PreparedStatement statement;
    private ResultSet result;

    
    
    public Connection connectDB() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/task", "root", "a12345");
            return connect;

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void logInButtonHandle(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Log_in.fxml"));
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        
        } catch (IOException io) {
            System.out.println("FXML Loading Error");
        }
    
    }

    
    public void SignupButton(ActionEvent event) {
        String gen;
        inputValidation();
        
        
        if (Male.isSelected()) {
            gen = "Male";
        } else {
            gen = "Female";
        }
        
        connect = connectDB();

        try {
            String sql = "INSERT INTO volunteer VALUES(?,?,?,?,?)";

            statement = connect.prepareStatement(sql);

            statement.setString(1, IDTXF1.getText());
            statement.setString(2, firstNameTXF.getText());
            statement.setString(3, lastNameTXF.getText());
            statement.setString(4, SignPasswordTXF.getText());
            statement.setString(5, EmailTXF.getText());

            statement.execute();

            JOptionPane.showMessageDialog(dialog, "New account has been registered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void inputValidation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

