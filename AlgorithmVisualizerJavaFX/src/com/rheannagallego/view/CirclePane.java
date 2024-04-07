package com.rheannagallego.view;

import com.rheannagallego.datastructure.BinarySearchTree;
import com.rheannagallego.datastructure.BinarySearchTree.CircleNode;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class CirclePane extends Pane {
	private BinarySearchTree tree = new BinarySearchTree();
	private int[] values = new int[15];
	private double radius = 13;
	private double padding = 50;
	
	public void updateCircle(int newData, int index) {	
		if (this.getChildren().size() < 2 + index * 3) {
			tree.insert(newData);		
		} else {
			tree.updateNode(values[index], newData);
		}
		this.getChildren().clear();
		values[index] = newData;
		drawCircle(tree.getRootNode(), 400, 100, this, 0, 0);
	}
	
	public void updateSearchResult(int val) {
		tree.clearTrace();
		CircleNode result = tree.searchNode(val);
		if (result == null) {
			System.out.println("no data found");
		} else {
			this.getChildren().clear();
			drawCircle(tree.getRootNode(), 400, 100, this, 0, 0);
		}
	}

	public void drawCircle(CircleNode node, double x, double y, Pane pane, int status, int level) {
		Color strokeColor = Color.BLACK;
		if (status == 1) {
			strokeColor = Color.BLUE;
		} else if (status == 2) {
			strokeColor = Color.GREEN;
		}
		
	    Circle circle = node.getCircle();
	    circle.setCenterX(x);
	    circle.setCenterY(y);
	    circle.setRadius(radius);
	    circle.setStroke(strokeColor);
		circle.setFill(Color.WHITE);
	    
	    Text text = new Text(node.getStrData());
	    text.setFont(Font.font("Arial", 12));
	    text.setX(x - 7);
	    text.setY(y + 5);
  
	    pane.getChildren().addAll(circle, text);

	    if (node.getRightNode() != null) {
	    	double rightX = x + 150 / (level + 1);
	    	Line line = new Line(x, y + radius, rightX, y + padding - radius);
			line.setStroke(Color.BLACK);
			pane.getChildren().add(line);
	    	drawCircle(node.getRightNode(), rightX, y + padding, pane, 1, level + 1);
	    }
	    
	    if (node.getLeftNode() != null) {
	    	double leftX = x - 150 / (level + 1);
			Line line = new Line(x, y + radius, leftX, y + padding - radius);
			line.setStroke(Color.BLACK);
			pane.getChildren().add(line);
	    	drawCircle(node.getLeftNode(), leftX, y + padding, pane, 2, level + 1);
	    }
	}
	
	public BinarySearchTree getTree() {
		return tree;
	}
}
