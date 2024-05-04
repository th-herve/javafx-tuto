package org.application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

// layout with flexible grid of row and column
// each child can span on several cell
public class GridPaneEx extends Application {

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void start(Stage stage) throws Exception {

        GridPane grid = new GridPane(); // 1st param = space between items

        Label lblFirstName = new Label("First Name");
        TextField txt1 = new TextField();
        Label lblLastName = new Label("Last Name");
        TextField txt2 = new TextField();

        setBtn();

        grid.add(lblFirstName, 0,0,1,1); // node, col, rox, colSpan, rowSpan
        grid.add(txt1, 1,0,1,1);
        grid.add(lblLastName, 0,1,1,1); // node, col, rox, colSpan, rowSpan
        grid.add(txt2, 1,1,1,1);
        grid.add(btn1, 0,2,1,1);
        grid.add(btn2, 1,2,1,1);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        grid.getColumnConstraints().add(column1);
        grid.getColumnConstraints().add(column2);
        column1.setPercentWidth(33);
        column2.setPercentWidth(66);

        // horizontal alignment
        GridPane.setHalignment(lblFirstName, HPos.RIGHT);
        GridPane.setHalignment(lblLastName, HPos.RIGHT);



        Scene scene = new Scene(grid, 400, 200);
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
