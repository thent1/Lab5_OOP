package com.example.lab5_oop.Shapes;

import com.example.lab5_oop.Shapes.Shape;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CubeShape extends Shape {
    private Rectangle frontRectangle;
    private Rectangle backRectangle;

    private Line topperLeftLine;
    private Line bottomLeftLine;
    private Line topperRightLine;
    private Line bottomRightLine;

    private boolean isKeyPressed;

    public CubeShape(Scene scene, Pane root) {
        super(scene, root);
    }

    @Override
    public void editShape() {
        root.setOnMousePressed(mouseEvent -> {
            frontRectangle = new Rectangle();
            backRectangle = new Rectangle();
            topperLeftLine = new Line();
            bottomLeftLine = new Line();
            topperRightLine = new Line();
            bottomRightLine = new Line();

            frontRectangle.setX(mouseEvent.getX());
            frontRectangle.setY(mouseEvent.getY());
            frontRectangle.setWidth(mouseEvent.getX()-frontRectangle.getX());
            frontRectangle.setHeight(mouseEvent.getY()-frontRectangle.getY());
            frontRectangle.setStroke(Color.RED);
            frontRectangle.getStrokeDashArray().addAll(25d, 10d);
            frontRectangle.setFill(null);

            backRectangle.getStrokeDashArray().addAll(25d, 10d);
            backRectangle.setStroke(Color.RED);
            backRectangle.setFill(null);

            topperLeftLine.setStroke(Color.RED);
            topperLeftLine.getStrokeDashArray().addAll(25d, 10d);

            bottomLeftLine.setStroke(Color.RED);
            bottomLeftLine.getStrokeDashArray().addAll(25d, 10d);

            topperRightLine.setStroke(Color.RED);
            topperRightLine.getStrokeDashArray().addAll(25d, 10d);

            bottomRightLine.setStroke(Color.RED);
            bottomRightLine.getStrokeDashArray().addAll(25d, 10d);

            root.getChildren().addAll(frontRectangle, backRectangle, topperLeftLine, bottomLeftLine, topperRightLine, bottomRightLine);
        });

        root.setOnMouseDragged(mouseEvent -> {
            if (frontRectangle != null) {
                if (isKeyPressed && (mouseEvent.getX() - frontRectangle.getX() > mouseEvent.getY() - frontRectangle.getY())) {
                    frontRectangle.setWidth(mouseEvent.getX() - frontRectangle.getX());
                    frontRectangle.setHeight(frontRectangle.getWidth());
                    setBackRectangle();
                    setLines();

                } else if (isKeyPressed && (mouseEvent.getY() - frontRectangle.getY() > mouseEvent.getX() - frontRectangle.getX())) {
                    frontRectangle.setHeight(mouseEvent.getY() - frontRectangle.getY());
                    frontRectangle.setWidth(frontRectangle.getHeight());
                    setBackRectangle();
                    setLines();

                } else {
                    frontRectangle.setWidth(mouseEvent.getX() - frontRectangle.getX());
                    frontRectangle.setHeight(mouseEvent.getY() - frontRectangle.getY());
                    setBackRectangle();
                    setLines();

                }
            }
        });

        root.setOnMouseReleased(mouseEvent -> {
            if (frontRectangle != null) {
                frontRectangle.setStroke(Color.BLACK);
                backRectangle.setStroke(Color.BLACK);
                topperLeftLine.setStroke(Color.BLACK);
                bottomLeftLine.setStroke(Color.BLACK);
                topperRightLine.setStroke(Color.BLACK);
                bottomRightLine.setStroke(Color.BLACK);

                frontRectangle.getStrokeDashArray().clear();
                backRectangle.getStrokeDashArray().clear();
                topperRightLine.getStrokeDashArray().clear();
                topperLeftLine.getStrokeDashArray().clear();
                bottomRightLine.getStrokeDashArray().clear();
                bottomLeftLine.getStrokeDashArray().clear();

                frontRectangle = null;
                backRectangle = null;


            }
        });

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SHIFT) {
                isKeyPressed = true;
            }
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.SHIFT) {
                isKeyPressed = false;
            }
        });
    }

    @Override
    public void setData(String shapeName, int x1, int y1, int x2, int y2) {
        // TODO document why this method is empty
    }

    private void setLines() {
        topperLeftLine.setStartX(backRectangle.getX());
        topperLeftLine.setStartY(backRectangle.getY());
        topperLeftLine.setEndX(frontRectangle.getX());
        topperLeftLine.setEndY(frontRectangle.getY());

        bottomLeftLine.setStartX(backRectangle.getX());
        bottomLeftLine.setStartY(backRectangle.getY() + backRectangle.getHeight());
        bottomLeftLine.setEndX(frontRectangle.getX());
        bottomLeftLine.setEndY(frontRectangle.getY() + frontRectangle.getHeight());

        topperRightLine.setStartX(backRectangle.getX() + backRectangle.getWidth());
        topperRightLine.setStartY(backRectangle.getY());
        topperRightLine.setEndX(frontRectangle.getX() + frontRectangle.getWidth());
        topperRightLine.setEndY(frontRectangle.getY());

        bottomRightLine.setStartX(backRectangle.getX() + backRectangle.getWidth());
        bottomRightLine.setStartY(backRectangle.getY() + backRectangle.getHeight());
        bottomRightLine.setEndX(frontRectangle.getX() + frontRectangle.getWidth());
        bottomRightLine.setEndY(frontRectangle.getY() + frontRectangle.getHeight());
    }

    private void setBackRectangle() {
        backRectangle.setWidth(frontRectangle.getWidth());
        backRectangle.setHeight(frontRectangle.getHeight());
        backRectangle.setX(frontRectangle.getX() + frontRectangle.getWidth() / 2);
        backRectangle.setY(frontRectangle.getY() - frontRectangle.getHeight() / 2);
    }

}
