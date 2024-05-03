package org.application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// set elements with anchor (top, right, left, bottom)
// and the distance from that anchor
public class AnchorPaneEx extends Application
{
    Button btn1;
    Button btn2;
    TextArea txt;

    @Override
    public void start(Stage stage) throws Exception
    {

        AnchorPane anchor = new AnchorPane();

        setBtn();

        anchor.getChildren().addAll(txt, btn1, btn2);

        // set txt 10px away from top,left, bot and 100px from right
        AnchorPane.setTopAnchor(txt, 10.0); // second arg = offset, distance in pc from the anchor
        AnchorPane.setLeftAnchor(txt, 10.0); // second arg = offset, distance in pc from the anchor
        AnchorPane.setRightAnchor(txt, 100.0); // second arg = offset, distance in pc from the anchor
        AnchorPane.setBottomAnchor(txt, 10.0); // second arg = offset, distance in pc from the anchor

        // set top right
        AnchorPane.setTopAnchor(btn1, 10.0);
        AnchorPane.setRightAnchor(btn1, 10.0);

        // set bottom right
        AnchorPane.setRightAnchor(btn2, 10.0);
        AnchorPane.setBottomAnchor(btn2, 10.0);

        Scene scene = new Scene(anchor, 500, 300);
        stage.setScene(scene);
        stage.show();


    }

    public void setBtn()
    {
        this.btn1 = new Button("One");
        btn1.setMaxHeight(900);
        this.btn2 = new Button("Two");

        this.txt = new TextArea();

    }
}

