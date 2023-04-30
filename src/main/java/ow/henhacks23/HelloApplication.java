package ow.henhacks23;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    static HashMap<String, Location> locations = new HashMap<String, Location>();
    static Node[] net;
    @Override
    public void start(Stage stage) throws IOException
    {
        //Is this ineffient? Yes. Do we have time and brainpower, no lol

        Location smith = new Location("Smith", 0,0);
        Location purnell = new Location("Purnell", 0,0);
        Location lerner = new Location("Lerner", 0,0);
        Location ewing = new Location("EWing", 0,0);
        Location kirkbride = new Location("Kirkbride", 0,0);
        Location gore = new Location("Gore", 0,0);
        Node rightRoad = new Node(new Connection[] {}, "rightRoad");
        Node topRoad = new Node(new Connection[] {}, "topRoad");
        Node trabantRoad = new Node(new Connection[] {}, "trabantRoad");
        net = new Node[]{smith.getNode(), purnell.getNode(), lerner.getNode(), ewing.getNode(), kirkbride.getNode(),
        gore.getNode(), rightRoad, topRoad, trabantRoad};
        locations.put("smith", smith);
        locations.put("purnell", purnell);
        locations.put("lerner", lerner);
        locations.put("ewing", ewing);
        locations.put("kirkbride", kirkbride);
        locations.put("gore", gore);

        Node centerArea = new Node(new Connection[]
                {
                        new Connection(ewing.getNode(), 1),
                        new Connection(purnell.getNode(), 1),
                        new Connection(smith.getNode(), 1),
                        new Connection(kirkbride.getNode(), 1),
                }, "centerArea");
        Node bottomRoad = new Node(new Connection[]
                {
                        new Connection(smith.getNode(), 1),
                        new Connection(purnell.getNode(), 1),
                        new Connection(rightRoad, 1),
                }, "bottomRoad");
        rightRoad.connections = new Connection[]
                {
                        new Connection(gore.getNode(), 1),
                        new Connection(bottomRoad, 1),
                        new Connection(topRoad, 2),
                };
        topRoad.connections = new Connection[]
                {
                        new Connection(kirkbride.getNode(), 1),
                        new Connection(trabantRoad, 2),
                        new Connection(rightRoad, 2),
                };
        trabantRoad.connections = new Connection[]
                {
                        new Connection(topRoad, 2),
                };
        smith.getNode().connections = new Connection[]
        {
                new Connection(gore.getNode(), 1),
                new Connection(bottomRoad, 1),
                new Connection(purnell.getNode(), 1),
                new Connection(centerArea, 1),
                new Connection(kirkbride.getNode(), 1),
        };
        kirkbride.getNode().connections = new Connection[]
                {
                        new Connection(smith.getNode(), 1),
                        new Connection(centerArea, 1),
                        new Connection(topRoad, 1),
                };
        ewing.getNode().connections = new Connection[]
                {
                        new Connection(centerArea, 1),
                };
        purnell.getNode().connections = new Connection[]
                {
                        new Connection(smith.getNode(), 1),
                        new Connection(lerner.getNode(), 1),
                        new Connection(centerArea, 1),
                        new Connection(bottomRoad, 1),
                };
        lerner.getNode().connections = new Connection[]
                {
                        new Connection(purnell.getNode(), 1),
                };
        gore.getNode().connections = new Connection[]
                {
                        new Connection(smith.getNode(), 1),
                        new Connection(rightRoad, 1),
                };
        gore.setName("gore");
        kirkbride.setName("kirkbride");
        lerner.setName("lerner");
        smith.setName("smith");
        ewing.setName("ewing");
        purnell.setName("purnell");
        //setupLocations();
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