package com.rheannagallego.datastructure;

import javafx.scene.shape.Circle;

//import java.util.ArrayList;

public class BinarySearchTree {
	
	private CircleNode rootNode;
	
	public BinarySearchTree() {
		rootNode = null;
	}
	
	public void insert(int newData) {
		rootNode = insert(rootNode, newData);
	}
	
	private CircleNode insert(CircleNode node, int data) {
		if (node == null) {
			node = new CircleNode(data);
		} else {
			if (data > node.data) {
				node.rightNode = insert(node.rightNode, data);
			} else {
				node.leftNode = insert(node.leftNode, data);
			}
		}
		return node;
	}
    
    public CircleNode searchNode(int val) {
    	return searchNode(rootNode, val);
    }
    
    private CircleNode searchNode(CircleNode node, int val) {
    	node.isTraced = true;
    	if (val == node.data) {
    		return node;
    	} else if (val > node.data) {
    		node = node.rightNode;
    	} else {
    		node = node.leftNode;
    	}
    	
    	if (node != null) {
    		return searchNode(node, val);
    	} else {
    		return null;
    	}
    }
    
    
    public void clearTrace() {
    	clearTrace(rootNode);
    }
    
    
    private void clearTrace(CircleNode node) {
    	node.isTraced = false;
    	
    	if (node.rightNode != null) {
    		clearTrace(node.rightNode);
    	}
    	
    	if (node.leftNode != null) {
    		clearTrace(node.leftNode);
    	}
    }
    
    
    public void updateNode(int targetVal, int newVal) {
    	rootNode = deleteNode(rootNode, targetVal);
    	rootNode = insert(rootNode, newVal);
    }
    
    private CircleNode deleteNode(CircleNode node, int val) {
    	if (node == null) {
    		return null;
    	}
    	if (val < node.data) {
    		node.leftNode = deleteNode(node.leftNode, val);
    	} else if (val > node.data) {
    		node.rightNode = deleteNode(node.rightNode, val);
    	} else {
    		if (node.leftNode == null) {
    			return node.rightNode;
    		} else if (node.rightNode == null) {
    			return node.leftNode;
    		}
    		node.data = minData(node.rightNode);
    		node.rightNode = deleteNode(node.rightNode, node.data);
    	}
    	return node;
    }
    
    private int minData(CircleNode node) {
    	int minData = node.data;
    	while (node.leftNode != null) {
    		minData = node.leftNode.data;
    		node = node.leftNode;
    	}
    	return minData;
    }
	 
	public CircleNode getRootNode() {
		return rootNode;
	}
	
	public class CircleNode {
		private int data;
		private CircleNode leftNode;
		private CircleNode rightNode;
		private boolean isTraced = false;
		private Circle circle;
		
		public CircleNode(int firstData) {
			data = firstData;
			leftNode = null;
			rightNode = null;	
			circle = new Circle();
		}
		
		public CircleNode getRightNode() {
			return rightNode;
		}
		
		public CircleNode getLeftNode() {
			return leftNode;
		}
		
		public int getData() {
			return data;
		}
		
		public String getStrData() {
			return String.format("%d", data);
		}
		
		public boolean getTraced() {
			return isTraced;
		}
		
		public Circle getCircle() {
			return circle;
		}
	}
}
