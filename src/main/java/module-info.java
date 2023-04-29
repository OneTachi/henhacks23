module ow.henhacks {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens ow.henhacks23 to javafx.fxml;
    exports ow.henhacks23;
}