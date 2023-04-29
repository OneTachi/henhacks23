package ow.henhacks23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.io.IOException;
import java.util.List;

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
        String[] arr = {"Ewing", "Trabant", "Kirk", "Smith", "Purnell", "Lerner", "Sharp", "Gore", "Mitchell",
        "Hullihen", "Memorial", "Drake", "Evans", "Dupont", "Wolf"};
        List<String> strArr = new ArrayList<>(List.of(arr));
        Collections.sort(strArr); //For finding what is missed
        for (String x : strArr)
        {
            locations.put(x, new Location(x));
        }
    }
}