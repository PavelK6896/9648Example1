module client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens ex2 to javafx.fxml;

    exports ex1;
    exports ex2;
    exports ex3;
    exports ex4;
}