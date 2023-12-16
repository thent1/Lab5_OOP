package com.example.lab5_oop.shapes;

import com.example.lab5_oop.MainApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape extends Shape {

    MainApplication mainApplication;
    private Line line;
    String shapeName = "Line";

    public LineShape(Scene scene, Pane root, MainApplication mainApplication) {
        super(scene, root, mainApplication);
        this.mainApplication = mainApplication;
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            line = new Line();
            line.setStartX(mouseEvent.getX());
            line.setStartY(mouseEvent.getY());
            line.setEndY(mouseEvent.getY());
            line.setEndX((mouseEvent.getX()));
            line.setStroke(Color.RED);
            line.setStrokeWidth(2);
            line.getStrokeDashArray().addAll(25d, 10d);
            root.getChildren().add(line);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (line != null) {
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());
            }

        });

        root.setOnMouseReleased(mouseEvent -> {
            if (line != null){
                line.setStroke(Color.BLACK);
                line.getStrokeDashArray().clear();

                setData(shapeName, line.getStartX(), line.getStartY(),
                        line.getEndX(),
                        line.getEndY(),
                        mainApplication);

                line = null;
            }

        });
    }

    @Override
    public void setData(String shapeName, double x1, double y1, double x2, double y2, MainApplication mainApplication) {
        mainApplication.getMyTableWindow().addRow(shapeName, (int)x1, (int)y1, (int)x2, (int)y2, mainApplication.getMyTableWindow().getTableView());
    }
}
