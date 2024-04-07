package com.rheannagallego.view;

import com.rheannagallego.algorithms.BSTAnimation;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchBox extends HBox {
	TextField searchField = new TextField();
	Button searchButton = new Button("Search");
	BSTAnimation bsta = new BSTAnimation();
	
	public SearchBox() {
		searchField.getStyleClass().add("text-field");
		searchButton.getStyleClass().add("button");
		
		this.getChildren().addAll(searchField, searchButton);
		this.setSpacing(20);
		
		searchButton.setOnAction(actionEvent -> {
			searchValue();
        });
	}
	
	private void searchValue() {
		String valStr = searchField.getText();
		Alert a = new Alert(Alert.AlertType.ERROR);
		try {
			if (!valStr.equals("")) {
				int val = Integer.parseInt(valStr);
				if (MainWindow.circlePane.getTree().searchNode(val) != null) {
					MainWindow.circlePane.updateSearchResult(val);
					bsta.highlightNodesAndPaths(MainWindow.circlePane.getTree(), val);
				} else {
					a.setContentText("Data not found!");
					a.show();
				}
			} else {
				a.setContentText("Empty input!");
				a.show();
			}
		} catch (NumberFormatException e) {
			a.setContentText("Value must be an integer!");
			a.show();
		}
	}
}
