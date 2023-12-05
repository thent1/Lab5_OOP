package com.example.lab5_oop.Shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleShape extends Shape {

    private Rectangle rectangle;
    double centerX;
    double centerY;
    public RectangleShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            rectangle = new Rectangle();
            centerX = mouseEvent.getX();
            centerY = mouseEvent.getY();
            rectangle.setX(mouseEvent.getX()-2*(mouseEvent.getX()-centerX));
            rectangle.setY(mouseEvent.getY()-2*(mouseEvent.getY()-centerY));
            rectangle.setWidth(mouseEvent.getX() - rectangle.getX());
            rectangle.setHeight(mouseEvent.getY() - rectangle.getY());
            rectangle.setStroke(Color.RED);
            rectangle.setFill(null);
            rectangle.getStrokeDashArray().addAll(25d, 10d);
            root.getChildren().add(rectangle);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (rectangle != null) {
                rectangle.setWidth(mouseEvent.getX() - rectangle.getX());
                rectangle.setHeight(mouseEvent.getY() - rectangle.getY());
                rectangle.setX(mouseEvent.getX()-2*(mouseEvent.getX()-centerX));
                rectangle.setY(mouseEvent.getY()-2*(mouseEvent.getY()-centerY));
            }
        });

        root.setOnMouseReleased(mouseEvent -> {
            if (rectangle != null) {
                rectangle.setStroke(Color.BLACK);
                rectangle.setFill(null);
                rectangle.getStrokeDashArray().clear();
                rectangle = null;
            }
        });
    }

    @Override
    public void setData(String shapeName, int x1, int y1, int x2, int y2) {

    }
}
