package com.example.lab5_oop;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ToolBarButton extends Button {
    ToolBarButton(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        this.setGraphic(imageView);

        this.setMaxSize(30, 30);
    }
}
