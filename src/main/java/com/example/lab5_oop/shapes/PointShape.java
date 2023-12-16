package com.example.lab5_oop.shapes;

import com.example.lab5_oop.MainApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class PointShape extends Shape {

    MainApplication mainApplication;
    private Line point;
    String shapeName = "Point";
    public PointShape(Scene scene, Pane root, MainApplication mainApplication) {
        super(scene, root, mainApplication);
        this.mainApplication = mainApplication;
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            point = new Line();
            point.setStartX(mouseEvent.getX());
            point.setStartY(mouseEvent.getY());
            point.setEndX(mouseEvent.getX());
            point.setEndY(mouseEvent.getY());
            point.setStroke(Color.BLACK);
            point.setStrokeWidth(2);
            root.getChildren().add(point);
        });

        root.setOnMouseReleased(mouseEvent -> {
            if (point != null) {

                setData(shapeName, point.getStartX(), point.getStartY(),
                        point.getEndX(),
                        point.getEndY(),
                        mainApplication);

                point = null;
            }
        });
    }

    @Override
    public void setData(String shapeName, double x1, double y1, double x2, double y2, MainApplication mainApplication) {
        mainApplication.getMyTableWindow().addRow(shapeName, (int)x1, (int)y1, (int)x2, (int)y2, mainApplication.getMyTableWindow().getTableView());
    }
}
