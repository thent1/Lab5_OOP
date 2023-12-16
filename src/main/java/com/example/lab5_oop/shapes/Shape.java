package com.example.lab5_oop.shapes;

import com.example.lab5_oop.MainApplication;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public abstract class Shape {
    MainApplication mainApplication;
    public Scene scene;
    public Pane root;

    private String shapeName;
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Shape(Scene scene, Pane root, MainApplication mainApplication) {
        this.scene = scene;
        this.root = root;
    }

    public abstract void editShape();

    public abstract void setData(String shapeName, double x1, double y1, double x2, double y2, MainApplication mainApplication);
}