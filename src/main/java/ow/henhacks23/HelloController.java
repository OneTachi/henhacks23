package ow.henhacks23;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class HelloController {
    @FXML
    public TextField searchBox;
    @FXML
    private Label welcomeText;
    @FXML
    private Label searchText;

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

}