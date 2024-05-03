package org.application;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// can organize element vertically or horizontally
// When size get too small, elements wrap
public class FlowPaneEx extends Application
{
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void start(Stage stage) throws Exception
    {

        FlowPane flowpane = new FlowPane();

        setBtn();

        flowpane.getChildren().addAll(btn1,btn2,btn3);

//        flowpane.setOrientation(Orientation.VERTICAL);
        flowpane.setHgap(10);
        flowpane.setVgap(10);

        flowpane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(flowpane, 500, 300);

        stage.setScene(scene);
        stage.show();
    }

    public void setBtn()
    {
        this.btn1 = new Button("One");
        this.btn2 = new Button("Two");
        this.btn3 = new Button("Three");

    }
}

