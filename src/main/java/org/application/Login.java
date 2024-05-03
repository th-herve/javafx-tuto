package org.application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.VERTICAL);
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);

        Label title = new Label("App login");
        title.setFont(new Font("Arial", 25));
        title.setId("title");

        HBox hbUserName = new HBox();
        Label userLabel = new Label("User Name");
        userLabel.setMinWidth(80);
        TextField userField = new TextField();
        hbUserName.getChildren().addAll(userLabel, userField);

        HBox hbPass = new HBox();
        Label passLabel = new Label("PassWord");
        passLabel.setMinWidth(80);
        TextField passField = new TextField();
        hbPass.getChildren().addAll(passLabel, passField);

        HBox hbButton = new HBox();
        Button login = new Button("Login");
        login.getStyleClass().add("fancy-button");
        Button Cancel = new Button("Cancel");
        hbButton.getChildren().addAll(login, Cancel);
        hbButton.setAlignment(Pos.CENTER_RIGHT);
        hbButton.setSpacing(10);

        root.getChildren().addAll(title, hbUserName, hbPass, hbButton);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
