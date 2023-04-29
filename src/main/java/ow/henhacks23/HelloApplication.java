package ow.henhacks23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.HashMap;

import java.io.IOException;

public class HelloApplication extends Application {
    static HashMap<String, Location> locations = new HashMap<String, Location>();
    @Override
    public void start(Stage stage) throws IOException
    {
        setupLocations();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Location grabLocation(String name) {return locations.get(name);}
    public void setupLocations()
    {
        locations.put("Smith", new Location("Nachos"));
    }
}