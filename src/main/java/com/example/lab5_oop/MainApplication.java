package com.example.lab5_oop;

import com.example.lab5_oop.ShapeTable.MyTableWindow;
import com.example.lab5_oop.Shapes.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) {

        String path = "D:\\JavaProjects\\Lab5_OOP\\src\\main\\resources\\com\\example\\";

        MyTableWindow myTableWindow = new MyTableWindow();
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 600);
        stage.setTitle("Lab4");
        borderPane.setCenter(root);
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("Файл");
        Menu shapes = new Menu("Фігури");
        Menu info = new Menu("Довідка");
        menuBar.getMenus().addAll(file, shapes, info);

        Image pointImage = new Image(path + "point.png");
        Image lineImage = new Image(path + "line.png");
        Image rectImage = new Image(path + "rectangle.png");
        Image ellipseImage = new Image(path + "ellipse.png");
        Image lineWithCirclesImage = new Image(path + "linewithcircles.png");
        Image cubeImage = new Image(path + "cube.png");

        MenuItem point = new MenuItem("Крапка");
        MenuItem line = new MenuItem("Лінія");
        MenuItem rectangle = new MenuItem("Прямокутник");
        MenuItem ellipse = new MenuItem("Еліпс");
        MenuItem lineWithCircles = new MenuItem("Лінія з кружечками");
        MenuItem cube = new MenuItem("Куб");

        MenuItem tableItem = new MenuItem("Таблиця");

        ToolBar toolBar = new ToolBar();
        ToolBarButton pointButton = new ToolBarButton(pointImage);
        ToolBarButton lineButton = new ToolBarButton(lineImage);
        ToolBarButton rectButton = new ToolBarButton(rectImage);
        ToolBarButton ellipseButton = new ToolBarButton(ellipseImage);
        ToolBarButton lineWithCirclesButton = new ToolBarButton(lineWithCirclesImage);
        ToolBarButton cubeButton = new ToolBarButton(cubeImage);

        pointButton.setTooltip(new Tooltip("Press this button to draw point"));
        lineButton.setTooltip(new Tooltip("Press this button to draw line"));
        rectButton.setTooltip(new Tooltip("Press this button to draw rectangle"));
        ellipseButton.setTooltip(new Tooltip("Press this button to draw ellipse"));
        lineWithCirclesButton.setTooltip(new Tooltip("Press this button to draw line with circles"));
        cubeButton.setTooltip(new Tooltip("Press this button to draw cube"));

        toolBar.getItems().addAll(pointButton, lineButton, rectButton, ellipseButton, lineWithCirclesButton, cubeButton);
        toolBar.setOrientation(Orientation.VERTICAL);

        file.getItems().add(tableItem);
        shapes.getItems().addAll(point, line, rectangle, ellipse, lineWithCircles, cube);
        borderPane.setTop(menuBar);
        borderPane.setLeft(toolBar);

        tableItem.setOnAction(event -> {
            myTableWindow.show();
            myTableWindow.addRow("aboba", 515, 51, 51,7, myTableWindow.getTableView());
        });

        EventHandler<ActionEvent> pointHandler = event -> {
            MyEditor.start(new PointShape(scene, root));
            stage.setTitle("Крапка");
        };

        point.setOnAction(pointHandler);
        pointButton.setOnAction(pointHandler);

        EventHandler<ActionEvent> lineHandler = event -> {
            MyEditor.start(new LineShape(scene, root));
            stage.setTitle("Лінія");
        };

        line.setOnAction(lineHandler);
        lineButton.setOnAction(lineHandler);

        EventHandler<ActionEvent> rectangleHandler = event -> {
            MyEditor.start(new RectangleShape(scene, root));
            stage.setTitle("Прямокутник");
        };

        rectangle.setOnAction(rectangleHandler);
        rectButton.setOnAction(rectangleHandler);

        EventHandler<ActionEvent> ellipseHandler = event -> {
            MyEditor.start(new EllipseShape(scene, root));
            stage.setTitle("Еліпс");
        };

        ellipse.setOnAction(ellipseHandler);
        ellipseButton.setOnAction(ellipseHandler);

        EventHandler<ActionEvent> lineOOHandler = event -> {
            MyEditor.start(new LineWithCirclesShape(scene, root));
            stage.setTitle("Лінія з кружечками");
        };

        lineWithCircles.setOnAction(lineOOHandler);
        lineWithCirclesButton.setOnAction(lineOOHandler);

        EventHandler<ActionEvent> cubeHandler = event -> {
            MyEditor.start(new CubeShape(scene, root));
            stage.setTitle("Куб");
        };

        cube.setOnAction(cubeHandler);
        cubeButton.setOnAction(cubeHandler);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

