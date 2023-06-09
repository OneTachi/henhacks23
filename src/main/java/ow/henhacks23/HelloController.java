package ow.henhacks23;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
//
// WILL BE DELETED - NOT NEEDED
//
// We used this class on previous updates to create our search box, images and text. However,
// we found out that creating lines using FXML would be very difficult, so we made it so the
// search box, text, images, and lines are located all in HelloApplication.
//
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
    private Line line;

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
                // Draw



                data = null;
            }
        }
    }



    @FXML
    protected Image getProto()
    {
        try
        {
            return new Image(new FileInputStream("proto.png"));
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
        File file = new File("src/main/java/ow/henhacks23/proto.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

    }

}