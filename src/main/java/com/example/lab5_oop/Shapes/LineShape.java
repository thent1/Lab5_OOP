package com.example.lab5_oop.Shapes;

import com.example.lab5_oop.Shapes.Shape;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineShape extends Shape {
    private Line line;

    public LineShape(Scene scene, Pane root) {
        super(scene, root);
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
                line = null;
            }

        });
    }

    @Override
    public void setData(String shapeName, int x1, int y1, int x2, int y2) {

    }
}
