package org.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application
{

    @Override
    public void start(Stage primaryStage) throws IOException
    {
//        Stage stage = new Stage();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("My title");

        BorderPane root = new BorderPane();
        root.setCenter(this.getButton());
        root.setCenter(this.getTextField());


        addEventHandlerFilter(root);

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();

        stage.setMaxHeight(500);
        stage.setMaxWidth(500);
    }

    // There is two phases in event:
    // first, the event is 'captured'
    // second, the event is 'bubbling'
    // The captured start at the Stage and descend to the scene, traverses the nodes and stop at the one interacted with(ex: a button). At each stage an eventFilter can interact with it
    // The bubbling start at the node (button) and stop at the Stage, an event handler can interact with it
    // The event can be 'consumed' at any stage and not "spread"
    private static void addEventHandlerFilter(BorderPane root) {
        // run before it arrives to the button
        root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Event Filter");
//                event.consume(); // the event will not reach the button with this line
            }
        });
        // run after the button
        root.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Event handler");
            }
        });
    }

    // == Type of node that a scene can hold ==
    // root node : has no parent, can have children
    // branch node : has a parent, can have children
    // leaf node : at the end of the branch, does not have children, has parent

    public static void main(String[] args) {
        launch();
    }



    // === Button ===
    public Button getButton()
    {
        Button button = new Button();

        button.setText("_Save"); // _ before add a mnemonic shortcut, hitting alt underline the button, alt+s click it

        // add img
        Image image = new Image(getClass().getResourceAsStream("/org/application/img.png")); // !! in ressource/, not java/
        ImageView iView = new ImageView(image);
        iView.setFitHeight(20);
        iView.setFitWidth(20);
        button.setGraphic(iView);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Clicked");
            }
        });

        button.setFont(new Font("Arial", 24));
        
        button.setRotate(10);

        // same button, with different construtor
        Button button2 = new Button("_Save", iView);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                button.setText("clicked");
                System.out.println("clicked");
            }
        });

        return button;
    }

    public TextField getTextField()
    {
        TextField textField = new TextField();

        textField.setPromptText("Enter some text");
        textField.setFocusTraversable(false);

        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("TextField sent");
                System.out.println(textField.getText());

                textField.setText("Text sent !");

            }
        });

        return textField;
    }

}