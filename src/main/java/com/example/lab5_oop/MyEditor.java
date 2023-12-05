package com.example.lab5_oop;

import com.example.lab5_oop.Shapes.Shape;

public class MyEditor {
    private static MyEditor instance;

    private MyEditor() {

    }

    public static MyEditor getInstance() {
        if (instance == null) {
            instance = new MyEditor();
        }
        return instance;
    }

    public static void start(Shape shape) {
        shape.editShape();
    }
}
