package com.rheannagallego.view;

import com.rheannagallego.datastructure.Stack; // Xingxing Update

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



//Main window of the application
public class MainWindow extends BorderPane {
    //ChartPane contains the StackPanes that create the bar chart of values being sorted
    //making public and static so the algorithm classes can access the StackPanes within the chart
    //and create/run the animations
    public static ChartPane chartPane = new ChartPane();
 // Le Sun added
    public static CirclePane circlePane = new CirclePane();
    // Xingxing added


    public MainWindow(){
        //adding styling for the window from the css file
        this.getStyleClass().add("pane");
        FieldBox fieldBox = new FieldBox();

        //add the different boxes to the window,
        //top is the EnterFields for entering values, bottom has the buttons, left is the list of algorithms
        //and center is the bar chart containing values that are sorted through animation
        this.setTop(fieldBox);
        this.setCenter(chartPane);
        this.setBottom(new ButtonBox(fieldBox));
        this.setLeft(new AlgorithmBox(fieldBox));
        
        
        // Le Sun added,
        AlgorithmBox.getAlgorithmList().getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
	        if (newValue.equals("Binary Search Tree")) {
	            this.setCenter(circlePane); 
	            this.setBottom(new SearchBox());
	        } //  Xingxing added
	        else if (newValue.equals("Stack")){
	        	this.setBottom(new StackBox());
	        }
	        else {
	        	this.setCenter(chartPane);
	            this.setBottom(new ButtonBox(fieldBox));
	        }
        });
    }
}
