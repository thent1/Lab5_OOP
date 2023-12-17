package com.example.lab5_oop.shapes;

import com.example.lab5_oop.MainApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseShape extends Shape {

    MainApplication mainApplication;
    private Ellipse ellipse;
    double x;
    double y;
    String shapeName = "Ellipse";

    public EllipseShape(Scene scene, Pane root, MainApplication mainApplication) {
        super(scene, root, mainApplication);
        this.mainApplication = mainApplication;
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getX();
            y = mouseEvent.getY();
            ellipse = new Ellipse();
            ellipse.setFill(null);
            ellipse.setStroke(Color.RED);
            ellipse.getStrokeDashArray().addAll(25d, 10d);
            root.getChildren().add(ellipse);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (ellipse != null) {
                ellipse.setCenterX(x + (mouseEvent.getX() - x) / 2);
                ellipse.setCenterY(y + (mouseEvent.getY() - y) / 2);

                ellipse.setRadiusX(mouseEvent.getX()-ellipse.getCenterX());
                ellipse.setRadiusY(mouseEvent.getY()-ellipse.getCenterY());
            }

        });

        root.setOnMouseReleased(mouseEvent -> {
            if (ellipse != null){
                ellipse.setFill(Color.YELLOW);
                ellipse.setStroke(Color.BLACK);
                ellipse.getStrokeDashArray().clear();

                setData(shapeName, x, y,
                        ellipse.getCenterX()+ellipse.getRadiusX(),
                        ellipse.getCenterY()+ellipse.getRadiusY(),
                        mainApplication);

                ellipse = null;
            }

        });
    }

    @Override
    public void setData(String shapeName, double x1, double y1, double x2, double y2, MainApplication mainApplication) {
        mainApplication.getMyTableWindow().addRow(shapeName, (int)x1, (int)y1, (int)x2, (int)y2);
    }
}
