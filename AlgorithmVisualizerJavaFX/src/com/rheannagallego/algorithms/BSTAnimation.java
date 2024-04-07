package com.rheannagallego.algorithms;

import com.rheannagallego.datastructure.BinarySearchTree;
import com.rheannagallego.datastructure.BinarySearchTree.CircleNode;

import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BSTAnimation extends AlgorithmAnimation {

    public void highlightNodesAndPaths(BinarySearchTree tree, int val) {
        SequentialTransition animation = new SequentialTransition();

        CircleNode node = tree.getRootNode();
        while (node.getTraced()) {
    		Circle circle = node.getCircle();
    		if (val != node.getData()) {
	    		FillTransition fillTransition = new FillTransition(Duration.seconds(1), circle, Color.WHITE, Color.YELLOW);
	            animation.getChildren().add(fillTransition);
	            
	        	if (val > node.getData()) {
	        		node = node.getRightNode();
	        	} else if (val < node.getData()) {
	        		node = node.getLeftNode();
	        	}
    		} else {
    			FillTransition fillTransition = new FillTransition(Duration.seconds(1), circle, Color.WHITE, Color.RED);
	            animation.getChildren().add(fillTransition);
	            break;
    		}
        }
        animation.play();
    }

	@Override
	public void startSort(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playAnimation() {
		// TODO Auto-generated method stub
		
	}
}
