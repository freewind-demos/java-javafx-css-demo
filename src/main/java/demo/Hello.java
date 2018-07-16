package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            getChildren().add(fromCssFile());
            getChildren().add(defineStyleDirectly());
            getChildren().add(defineCssClassesInString());
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private HBox fromCssFile() {
        return new HBox() {{
            setPadding(new Insets(10));
            this.getStylesheets().add("hello.css");
            this.getStyleClass().add("my-rect");
            getChildren().add(new Label("From Css File"));
        }};
    }

    private HBox defineStyleDirectly() {
        return new HBox() {{
            setPadding(new Insets(10));
            setStyle("-fx-background-color: GREEN");
            getChildren().add(new Label("Define style in code"));
        }};
    }

    private HBox defineCssClassesInString() {
        return new HBox() {{
            setPadding(new Insets(10));
            getChildren().add(new Label("Try define css classes just in Code, \nbut is not possible. \nThe css classes have to be defined in a real file. \nWe can use a temporary file if we need to generate some css classes dynamically"));
        }};
    }
}