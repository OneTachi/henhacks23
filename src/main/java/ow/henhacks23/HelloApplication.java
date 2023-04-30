package ow.henhacks23;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.*;

import java.io.IOException;

public class HelloApplication extends Application {
    static HashMap<String, Location> locations = new HashMap<String, Location>();
    static Node[] net;
    Location data = null;
    @Override
    public void start(Stage stage) throws IOException
    {
        //Is this ineffient? Yes. Do we have time and brainpower, no lol

        Location smith = new Location("Smith", 500,500);
        Location purnell = new Location("Purnell", 100,100);
        Location lerner = new Location("Lerner", 0,0);
        Location ewing = new Location("EWing", 0,0);
        Location kirkbride = new Location("Kirkbride", 30,0);
        Location gore = new Location("Gore", 0,0);
        Node rightRoad = new Node(new Connection[] {}, 30, 30);
        Node topRoad = new Node(new Connection[] {}, 46, 46);
        Node trabantRoad = new Node(new Connection[] {}, 95, 433);
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
                }, 100, 100);
        Node bottomRoad = new Node(new Connection[]
                {
                        new Connection(smith.getNode(), 1),
                        new Connection(purnell.getNode(), 1),
                        new Connection(rightRoad, 1),
                }, 200, 150);
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
        //setupLocations();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        StackPane main = new StackPane();


        VBox box = new VBox();
        box.setSpacing(20);
        TextField searchText = new TextField();
        searchText.setText("Search for Hall here!");

        StackPane paneBox = new StackPane(box);
        StackPane lines = new StackPane();
        searchText.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Location location = HelloApplication.grabLocation(searchText.getText());
                if (location == null)
                {
                    searchText.setText("Please retype the name of your hall!");
                    PauseTransition fade = new PauseTransition(Duration.seconds(5));
                    fade.setOnFinished(n -> { searchText.setText("");});
                    fade.play();
                }
                else
                {
                    if (data == null)
                    {
                        data = location;
                    }
                    else
                    {
                        Algorithm alg = new Algorithm(data.getNode(), HelloApplication.net);
                        ArrayList<Node> drawPath = alg.algorithm(location.getNode());
                        // Draw
                        for (int z = 0; z < drawPath.size() - 1; z++)
                        {
                            Line line = new Line(drawPath.get(z).x, drawPath.get(z).y, drawPath.get(z+1).x, drawPath.get(z+1).y);
                            System.out.println(line);
                            lines.getChildren().add(line);

                        }
                        lines.setVisible(true);
                        data = null;
                    }
                }
            }
        });

        File file = new File("src/main/java/ow/henhacks23/proto.png");
        Image image = new Image(file.toURI().toString());
        box.getChildren().add(new ImageView(image));
        box.getChildren().add(searchText);
        box.setAlignment(Pos.CENTER);
        lines.getChildren().add(new Line(0,0,-500,500));
        main.getChildren().addAll(paneBox, lines);
        Scene scene = new Scene(main, 500, 500);
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