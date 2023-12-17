package com.example.lab5_oop.shapeTable;

import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;

public class MyTableWindow extends Stage {
    TableView<ShapeData> tableView;
    public MyTableWindow() {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 600, 600);
        setResizable(false);
        setTitle("Table");
        setScene(scene);


        tableView = new TableView<>();
        pane.getChildren().add(tableView);
        tableView.setPrefSize(600, 600);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        TableColumn<ShapeData, String> nameColumn = new TableColumn<>("Name");
        TableColumn<ShapeData, Integer> x1Column = new TableColumn<>("X1");
        TableColumn<ShapeData, Integer> y1Column = new TableColumn<>("Y1");
        TableColumn<ShapeData, Integer> x2Column = new TableColumn<>("X2");
        TableColumn<ShapeData, Integer> y2Column = new TableColumn<>("Y2");

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        x1Column.setCellValueFactory(cellData -> cellData.getValue().x1Property().asObject());
        y1Column.setCellValueFactory(cellData -> cellData.getValue().y1Property().asObject());
        x2Column.setCellValueFactory(cellData -> cellData.getValue().x2Property().asObject());
        y2Column.setCellValueFactory(cellData -> cellData.getValue().y2Property().asObject());

        tableView.getColumns().addAll(nameColumn, x1Column, y1Column, x2Column, y2Column);
        nameColumn.setPrefWidth(250);
    }

    public void addRow(String name, int x1, int y1, int x2, int y2, TableView tableView) {
        ShapeData shapeData = new ShapeData(name, x1, y1, x2, y2);
        tableView.getItems().add(shapeData);
    }

    public TableView getTableView() {
        return this.tableView;
    }

    public void deleteAllRows(TableView tableView) {
        tableView.getItems().clear();
    }

    public void writeToFile() throws IOException {
        File file = new File("testFile.txt");
        PrintWriter pw = new PrintWriter(file);
        for (ShapeData shapeData : tableView.getItems()) {
            try {
                file.createNewFile();
                pw.println(shapeData.getName() + "\t" + shapeData.getX1()+ "\t" + shapeData.getY1()+ "\t" + shapeData.getX2()+ "\t" + shapeData.getY2());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        pw.close();
    }
}