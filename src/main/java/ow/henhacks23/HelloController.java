package ow.henhacks23;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    @FXML
    public TextField searchBox;
    @FXML
    private Label welcomeText;
    @FXML
    private Label searchText;
    @FXML
    private ImageView imageView;
    @FXML
    private Line lerner_purnell;
    @FXML
    private Line purnell_bottomRoad;
    @FXML
    private Line purnell_smith;
    @FXML
    private Line purnell_centerArea;
    @FXML
    private Line bottomRoad_smith;
    @FXML
    private Line bottomRoad_rightRoad;
    @FXML
    private Line smith_gore;
    @FXML
    private Line smith_kirkbride;
    @FXML
    private Line smith_centerArea;
    @FXML
    private Line centerArea_ewing;
    @FXML
    private Line centerArea_kirkbride;
    @FXML
    private Line topRoad_rightRoad;
    @FXML
    private Line topRoad_trabantRoad;
    @FXML
    private Line topRoad_kirkbride;
    @FXML
    private Line rightRoad_gore;



    Location data = null;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onSearch()
    {
        Location location = HelloApplication.grabLocation(searchBox.getText());
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
                for(int i = drawPath.size(); i==1; i--) {
                    String text1 = drawPath.get(i).name + "_" + drawPath.get(i - 1).name;
                    String text2 = drawPath.get(i-1).name + "_" + drawPath.get(i).name;
                    if(Objects.equals(text1, "lerner_purnell") || Objects.equals(text2, "lerner_purnell")) {
                        lerner_purnell.setVisible(true);
                    }
                    else if(Objects.equals(text1, "purnell_bottomRoad") || Objects.equals(text2, "purnell_bottomRoad")) {
                        purnell_bottomRoad.setVisible(true);
                    }
                    else if(Objects.equals(text1, "purnell_smith") || Objects.equals(text2, "purnell_smith")) {
                        purnell_smith.setVisible(true);
                    }
                    else if(Objects.equals(text1, "purnell_centerArea") || Objects.equals(text2, "purnell_centerArea")) {
                        purnell_centerArea.setVisible(true);
                    }
                    else if(Objects.equals(text1, "bottomRoad_smith") || Objects.equals(text2, "bottomRoad_smith")) {
                        bottomRoad_smith.setVisible(true);
                    }
                    else if(Objects.equals(text1, "bottomRoad_rightRoad") || Objects.equals(text2, "bottomRoad_rightRoad")) {
                        bottomRoad_rightRoad.setVisible(true);
                    }
                    else if(Objects.equals(text1, "smith_gore") || Objects.equals(text2, "smith_gore")) {
                        smith_gore.setVisible(true);
                    }
                    else if(Objects.equals(text1, "smith_kirkbride") || Objects.equals(text2, "smith_kirkbride")) {
                        smith_kirkbride.setVisible(true);
                    }
                    else if(Objects.equals(text1, "centerArea_ewing") || Objects.equals(text2, "centerArea_ewing")) {
                        centerArea_ewing.setVisible(true);
                    }
                    else if(Objects.equals(text1, "centerArea_kirkbride") || Objects.equals(text2, "centerArea_kirkbride")) {
                        centerArea_kirkbride.setVisible(true);
                    }
                    else if(Objects.equals(text1, "topRoad_rightRoad") || Objects.equals(text2, "topRoad_rightRoad")) {
                        topRoad_rightRoad.setVisible(true);
                    }
                    else if(Objects.equals(text1, "topRoad_trabantRoad") || Objects.equals(text2, "topRoad_trabantRoad")) {
                        purnell_bottomRoad.setVisible(true);
                    }
                    else if(Objects.equals(text1, "topRoad_kirkbride") || Objects.equals(text2, "topRoad_kirkbride")) {
                        topRoad_kirkbride.setVisible(true);
                    }
                    else if(Objects.equals(text1, "smith_centerArea") || Objects.equals(text2, "smith_centerArea")) {
                        smith_centerArea.setVisible(true);
                    }
                    else if(Objects.equals(text1, "rightRoad_gore") || Objects.equals(text2, "rightRoad_gore")) {
                        rightRoad_gore.setVisible(true);
                    }
                }
                data = null;
                System.out.println("It worked");
            }
        }
    }

    @FXML
    protected Image getProto()
    {
        try
        {
            return new Image(new FileInputStream("map.png"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Not there");
        }
        return null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        File file = new File("src/main/java/ow/henhacks23/map.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitHeight(550);
        imageView.setFitWidth(700);
    }
}