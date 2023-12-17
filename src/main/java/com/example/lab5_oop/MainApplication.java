package com.example.lab5_oop;

import com.example.lab5_oop.shapeTable.MyTableWindow;
import com.example.lab5_oop.shapes.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    MyTableWindow myTableWindow;
    @Override
    public void start(Stage stage) {

        String path = "file:src/main/resources/com/example/";

        myTableWindow = new MyTableWindow();
        Pane root = new Pane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 600, 600);
        stage.setTitle("Lab5");
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

        MenuItem showTableItem = new MenuItem("Таблиця");
        MenuItem clearTableItem = new MenuItem("Очистити таблицю");
        MenuItem writeFileItem = new MenuItem("Записати в файл");

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

        file.getItems().addAll(showTableItem, clearTableItem, writeFileItem);
        shapes.getItems().addAll(point, line, rectangle, ellipse, lineWithCircles, cube);
        borderPane.setTop(menuBar);
        borderPane.setLeft(toolBar);

        showTableItem.setOnAction(event -> myTableWindow.show());
        clearTableItem.setOnAction(event -> myTableWindow.deleteAllRows());

        writeFileItem.setOnAction(event -> {
            try {
                myTableWindow.writeToFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        EventHandler<ActionEvent> pointHandler = event -> {
            MyEditor.start(new PointShape(scene, root, this));
            stage.setTitle("Крапка");
        };

        point.setOnAction(pointHandler);
        pointButton.setOnAction(pointHandler);

        EventHandler<ActionEvent> lineHandler = event -> {
            MyEditor.start(new LineShape(scene, root, this));
            stage.setTitle("Лінія");
        };

        line.setOnAction(lineHandler);
        lineButton.setOnAction(lineHandler);

        EventHandler<ActionEvent> rectangleHandler = event -> {
            MyEditor.start(new RectangleShape(scene, root, this));
            stage.setTitle("Прямокутник");
        };

        rectangle.setOnAction(rectangleHandler);
        rectButton.setOnAction(rectangleHandler);

        EventHandler<ActionEvent> ellipseHandler = event -> {
            MyEditor.start(new EllipseShape(scene, root, this));
            stage.setTitle("Еліпс");
        };

        ellipse.setOnAction(ellipseHandler);
        ellipseButton.setOnAction(ellipseHandler);

        EventHandler<ActionEvent> lineOOHandler = event -> {
            MyEditor.start(new LineWithCirclesShape(scene, root, this));
            stage.setTitle("Лінія з кружечками");
        };

        lineWithCircles.setOnAction(lineOOHandler);
        lineWithCirclesButton.setOnAction(lineOOHandler);

        EventHandler<ActionEvent> cubeHandler = event -> {
            MyEditor.start(new CubeShape(scene, root, this));
            stage.setTitle("Куб");
        };

        stage.setOnCloseRequest(event -> {
            myTableWindow.close();
            Platform.exit();
        });

        cube.setOnAction(cubeHandler);
        cubeButton.setOnAction(cubeHandler);

        stage.setScene(scene);
        stage.show();

    }

    public MyTableWindow getMyTableWindow() {
        return this.myTableWindow;
    }

    public static void main(String[] args) {
        launch();
    }
}
