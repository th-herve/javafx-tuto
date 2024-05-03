package org.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// organize element in a vertical layout
public class VBoxEx extends Application
{
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void start(Stage stage) throws Exception
    {

        VBox vbox = new VBox();

        setBtn();

        vbox.getChildren().addAll(btn1,btn2,btn3);
        btn1.setPrefWidth(100);
        vbox.setAlignment(Pos.CENTER);

        VBox.setVgrow(btn1, Priority.ALWAYS);

        Scene scene = new Scene(vbox, 500, 300);
        stage.setScene(scene);
        stage.show();


    }

    public void setBtn()
    {
        this.btn1 = new Button("One");
        btn1.setMaxHeight(900);
        this.btn2 = new Button("Two");
        this.btn3 = new Button("Three");

    }
}

