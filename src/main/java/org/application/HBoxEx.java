package org.application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

// organize element in a horizontal layout
public class HBoxEx extends Application {

    Button btn1;
    Button btn2;
    Button btn3;
    @Override
    public void start(Stage stage) throws Exception {
        HBox hbox = new HBox(); // 1st param = space between items

        setBtn();


        HBox.setMargin(btn1, new Insets(10)); // set margin around one node
        HBox.setMargin(btn2, new Insets(10)); // set margin around one node
        HBox.setMargin(btn3, new Insets(10)); // set margin around one node

        // set how nodes grow on resize
        HBox.setHgrow(btn1, Priority.SOMETIMES);
        HBox.setHgrow(btn2, Priority.ALWAYS);
        HBox.setHgrow(btn3, Priority.ALWAYS);

        // adding an empty region between items can push an element to the side
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);

        hbox.getChildren().addAll(this.btn1, this.btn2, region, this.btn3);

        Scene scene = new Scene(hbox, 400, 200);
        stage.setScene(scene);
        stage.show();

    }

    public void setBtn()
    {
        this.btn1 = new Button("One");
        this.btn1.setMaxWidth(Integer.MAX_VALUE);
        this.btn2 = new Button("Two");
        this.btn2.setMaxWidth(400);
        this.btn3 = new Button("Three");
        this.btn3.setMaxWidth(400);

    }
}
