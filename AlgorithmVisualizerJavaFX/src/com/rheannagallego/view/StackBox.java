package com.rheannagallego.view;


import com.rheannagallego.datastructure.Stack;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class StackBox extends HBox{
	private int width = 1920;
    private int height = 1080;
	Button stackButton = new Button("Stack Data");
	
	public StackBox() {
		stackButton.getStyleClass().add("button");
		
		stackButton.setPrefWidth(100); 
	    stackButton.setPrefHeight(40); 
		
		this.getChildren().addAll(stackButton);
		this.setSpacing(30);
		
		stackButton.setOnMouseClicked(mouseEvent -> {
            Stack stack = new Stack(this.width, this.height);
            Stage stackStage = stack.getStackStage();
            stackStage.show();
        });
        stackButton.setOnMouseEntered(mouseEvent -> {
            stackButton.setStyle("-fx-background-color: #C0C0C0");
            
        });
        stackButton.setOnMouseExited(mouseEvent -> {
            stackButton.setStyle("-fx-background-color: #0CE672");
        });
	}
	
}
