package ow.henhacks23;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
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
        else { searchBox.setText(location.getName());}
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
        //imageView.setFitHeight(300);
        //imageView.setFitWidth(300);
    }
}