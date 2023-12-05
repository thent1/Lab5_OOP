package com.example.lab5_oop.Shapes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Shape {
    public Scene scene;
    public Pane root;

    private String shapeName;
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Shape(Scene scene, Pane root) {
        this.scene = scene;
        this.root = root;
    }

    public abstract void editShape();

    public abstract void setData(String shapeName, int x1, int y1, int x2, int y2);
}