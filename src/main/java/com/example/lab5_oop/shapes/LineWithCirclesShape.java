package com.example.lab5_oop.shapes;

import com.example.lab5_oop.MainApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class LineWithCirclesShape extends Shape {

    MainApplication mainApplication;
    private Ellipse firstEllipse;
    private Line line;
    private Ellipse secondEllipse;
    String shapeName = "LineOO";

    public LineWithCirclesShape(Scene scene, Pane root, MainApplication mainApplication) {
        super(scene, root, mainApplication);
        this.mainApplication = mainApplication;
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            line = new Line();
            firstEllipse = new Ellipse();
            secondEllipse = new Ellipse();

            line.setStartX(mouseEvent.getX());
            line.setStartY(mouseEvent.getY());
            line.setEndX(mouseEvent.getX());
            line.setEndY(mouseEvent.getY());
            line.setStroke(Color.RED);
            line.setStrokeWidth(2);
            line.getStrokeDashArray().addAll(25d, 10d);

            firstEllipse.setCenterX(line.getStartX());
            firstEllipse.setCenterY(line.getStartY());
            firstEllipse.setRadiusX(25);
            firstEllipse.setRadiusY(25);
            firstEllipse.setFill(null);
            firstEllipse.setStroke(Color.RED);
            firstEllipse.getStrokeDashArray().addAll(25d, 10d);

            secondEllipse.setFill(null);
            secondEllipse.setStroke(Color.RED);
            secondEllipse.getStrokeDashArray().addAll(25d, 10d);

            root.getChildren().addAll(line, firstEllipse, secondEllipse);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (line != null) {
                line.setEndX(mouseEvent.getX());
                line.setEndY(mouseEvent.getY());

                secondEllipse.setCenterX(line.getEndX());
                secondEllipse.setCenterY(line.getEndY());
                secondEllipse.setRadiusX(25);
                secondEllipse.setRadiusY(25);

            }

        });

        root.setOnMouseReleased(mouseEvent -> {
            if (line != null){
                line.setStroke(Color.BLACK);
                line.getStrokeDashArray().clear();
                firstEllipse.setFill(Color.WHITE);
                secondEllipse.setFill(Color.WHITE);
                firstEllipse.getStrokeDashArray().clear();
                firstEllipse.setStroke(Color.BLACK);
                secondEllipse.setStroke(Color.BLACK);
                secondEllipse.getStrokeDashArray().clear();

                setData(shapeName, line.getStartX(), line.getStartY(),
                        line.getEndX(),
                        line.getEndY(),
                        mainApplication);

                firstEllipse = null;
                secondEllipse = null;
                line = null;
            }

        });
    }

    @Override
    public void setData(String shapeName, double x1, double y1, double x2, double y2, MainApplication mainApplication) {
        mainApplication.getMyTableWindow().addRow(shapeName, (int)x1, (int)y1, (int)x2, (int)y2);
    }
}
