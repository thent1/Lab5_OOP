package com.example.lab5_oop.shapeTable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShapeData {
    private final String name;
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public ShapeData(String name, int x1, int y1, int x2, int y2) {
        this.name = name;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String getName() {
        return name;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    // Методи для отримання властивостей для використання в TableColumn.setCellValueFactory
    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public IntegerProperty x1Property() {
        return new SimpleIntegerProperty(x1);
    }

    public IntegerProperty y1Property() {
        return new SimpleIntegerProperty(y1);
    }

    public IntegerProperty x2Property() {
        return new SimpleIntegerProperty(x2);
    }

    public IntegerProperty y2Property() {
        return new SimpleIntegerProperty(y2);
    }
}