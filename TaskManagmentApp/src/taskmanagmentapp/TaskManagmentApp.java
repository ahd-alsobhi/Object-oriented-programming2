package taskmanagmentapp;

import com.sun.javaws.Main;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class TaskManagmentApp extends Application {
    @Override
    public void start(Stage primaryStage){
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
        primaryStage.setTitle("Task Manager App");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        } 
        catch(IOException e){
        } 
        
       
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}