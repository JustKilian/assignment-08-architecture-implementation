module se2324.assignment08architectureimplementationsimonkiliannils {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens se2324.assignment08architectureimplementationsimonkiliannils to javafx.fxml;
    exports se2324.assignment08architectureimplementationsimonkiliannils;
}