package org.application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TableViewEx extends Application
{
    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    public void start(Stage stage) throws Exception
    {
        BorderPane root = new BorderPane();

        TableView<Person> table = new TableView<Person>();

        TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event)
            {
                Person person = event.getRowValue();
                person.setFirstName(event.getNewValue());
            }
        });

        TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event)
            {
                Person person = event.getRowValue();
                person.setLastName(event.getNewValue());
            }
        });

        TableColumn<Person, Integer> ageCol = new TableColumn<Person, Integer>("Age");
        ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        // make it editable
        ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ageCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, Integer>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, Integer> event)
            {
                // retrieve the modified person object's reference
                Person person = event.getRowValue();
                person.setAge(event.getNewValue());
            }
        });

        setColValue(table, firstNameCol, lastNameCol, ageCol);

        // make the column take the remaining space
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getItems().add(new Person("Bug", "Aldrin", 89));
        table.getItems().add(new Person("Bob", "Seer", 19));

        table.setEditable(true);

        root.setCenter(table);

        Scene scene = new Scene(root, 500, 300);

        stage.setScene(scene);
        stage.show();
    }

    private static void setColValue(TableView<Person> table, TableColumn<Person, String> firstNameCol, TableColumn<Person, String> lastNameCol, TableColumn<Person, Integer> ageCol)
    {
        table.getColumns().add(firstNameCol);
        table.getColumns().add(lastNameCol);
        table.getColumns().add(ageCol);
    }

    public void setBtn()
    {
        this.btn1 = new Button("One");
        this.btn2 = new Button("Two");
        this.btn3 = new Button("Three");

    }

}

