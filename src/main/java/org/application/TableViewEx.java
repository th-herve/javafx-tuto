package org.application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TableViewEx extends Application
{
    private TableColumn<Person, Integer> ageCol;
    private TableColumn<Person, String> firstNameCol;
    private TableColumn<Person, String> lastNameCol;

    // text field for adding entry
    private TextField firstName;
    private TextField lastName;
    private TextField age;

    private Button btnAdd;
    private Button btsDelete;

    @Override
    public void start(Stage stage) throws Exception
    {
        VBox root = new VBox();

        TableView<Person> table = new TableView<Person>();

        setColumns();

        table.getColumns().add(this.firstNameCol);
        table.getColumns().add(this.lastNameCol);
        table.getColumns().add(this.ageCol);


        table.getItems().add(new Person("Bug", "Aldrin", 89));
        table.getItems().add(new Person("Bob", "Seer", 19));

        table.setEditable(true);
        root.getChildren().add(table);


        root.getChildren().addAll(getAddForm(), getButtons(table));

        Scene scene = new Scene(root, 500, 300);

        // make the column take the remaining space
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        stage.setScene(scene);
        stage.show();
    }

    public void setColumns()
    {
        this.firstNameCol = new TableColumn<Person, String>("First name");
        this.firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        this.firstNameCol.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        this.firstNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event)
            {
                Person person = event.getRowValue();
                person.setFirstName(event.getNewValue());
            }
        });

        this.lastNameCol = new TableColumn<Person, String>("Last name");
        this.lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        this.lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        this.lastNameCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, String> event)
            {
                Person person = event.getRowValue();
                person.setLastName(event.getNewValue());
            }
        });

        this.ageCol = new TableColumn<Person, Integer>("Age");
        this.ageCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        // make it editable
        this.ageCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        this.ageCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Person, Integer>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Person, Integer> event)
            {
                // retrieve the modified person object's reference
                Person person = event.getRowValue();
                person.setAge(event.getNewValue());
            }
        });
    }

    public HBox getAddForm()
    {

        // add text field for adding new Person
        HBox fieldBox = new HBox();
        fieldBox.setSpacing(10);
        fieldBox.setPadding(new Insets(10,10,10,10));
        firstName = new TextField();
        lastName = new TextField();
        age = new TextField();
        fieldBox.getChildren().addAll(firstName, lastName, age);

        return fieldBox;
    }

    public HBox getButtons(TableView<Person> table)
    {

        // buttons add/delete
        btnAdd = new Button("Add");
        btsDelete = new Button("Delete");
        HBox btnBox = new HBox();
        btnBox.setSpacing(10);
        btnBox.setPadding(new Insets(0,10,10,10));
        btnBox.setAlignment(Pos.TOP_RIGHT);
        btnBox.getChildren().addAll(btnAdd, btsDelete);

        // add on click
        btnAdd.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Person person = new Person(firstName.getText(), lastName.getText(), Integer.parseInt(age.getText()));
                table.getItems().add(person);
                clearField();
                firstName.requestFocus();
            }
        });

        // delete on click
        btsDelete.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                int row = table.getSelectionModel().getFocusedIndex();
                if (row >= 0) {
                    table.getItems().remove(row);
                    table.getSelectionModel().clearSelection();
                }
            }
        });

        return btnBox;
    }

    private void clearField()
    {
        firstName.clear();
        lastName.clear();
        age.clear();
    }

}

