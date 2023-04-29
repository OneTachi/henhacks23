package ow.henhacks23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;

import java.io.IOException;

import java.util.Hashtable;
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        HashMap<String, Location> locations = new HashMap<String, Location>();


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Node smith = new Node("Smith", {"Gore", 1, })
        launch();
    }
}