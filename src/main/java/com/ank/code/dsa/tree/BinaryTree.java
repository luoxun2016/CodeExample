package com.ank.code.dsa.tree;

import java.util.Arrays;

import com.ank.code.dsa.stack.LinkedStack;
import com.ank.code.dsa.stack.Stack;

public class BinaryTree {

	private class Node{
		private Integer key;
		private Object data;
		private Node left;
		private Node right;
		
		public Node(Integer key, Object data) {
			this.key = key;
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	private Node top;
	private int size;
	
	public void add(Integer key, Object value){
		Node node = new Node(key, value);
		if(top == null){
			top = node;
		}else{
			Node curr = top;
			Node parent = top;
			boolean isleft = false;
			while(curr != null){
				parent = curr;
				if(key.compareTo(curr.key) < 0){
					curr = curr.left;
					isleft = true;
				}else{
					curr = curr.right;
					isleft = false;
				}
			}
			
			if(isleft){
				parent.left = node;
			}else{
				parent.right = node;
			}
		}
		size++;
	}
	
	public Object find(Integer key){
		Node curr = top;
		while(curr != null){
			int compareValue = key.compareTo(curr.key);
			if(compareValue == 0){
				return curr;
			}else if(compareValue < 0){
				curr = curr.left;
			}else{
				curr = curr.right;
			}
		}
		return null;
	}
	
	public Object remove(Integer key){
		Node curr = top;
		Node parent = top;
		boolean isleft = false;
		while(curr != null){
			int compareValue = key.compareTo(curr.key);
			if(compareValue == 0){
				remove(curr, parent, isleft);
				return curr;
			}else if(compareValue < 0){
				parent = curr;
				curr = curr.left;
				isleft = true;
			}else{
				parent = curr;
				curr = curr.right;
				isleft = false;
			}
		}
		return null;
	}
	
	private void remove(Node node, Node parent, boolean isleft) {
		if(node.left == null && node.right == null){
			if(isleft){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}else if(node.left != null && node.right == null){
			if(isleft){
				parent.left = node.left;
			}else{
				parent.right = node.left;
			}
		}else if(node.right != null && node.left == null){
			if(isleft){
				parent.left = node.right;
			}else{
				parent.right = node.right;
			}
		}else{
			Node successor = getSuccessor(node);//找中序后继节点替换删除节点
			if(isleft){
				parent.left = successor;
			}else{
				parent.right = successor;
			}
			successor.left = node.left;
		}
		size--;
	}
	
	private Node getSuccessor(Node node){
		Node successor = node.right;
		Node successorParent = node;
		while(successor.left != null){
			successorParent = successor;
			successor = successor.left;
		}
		
		if(successor != node.right){
			successorParent.left = successor.right;
			successor.right = node.right;
		}
		return successor;
	}

	public Object[] toArray(){
		Object[] objects = new Object[size];
		int index = 0;
		
		Stack stack = new LinkedStack();
		stack.push(new Object[]{top, 0});
		
		while(!stack.isEmpty()){
			Object[] objs = (Object[]) stack.peek();
			Node node = (Node) objs[0];
			int status = (Integer) objs[1];
			
			if(status == 0){
				//此处前序
				status = 1;
				objs[1] = status;
				if(node.left != null){
					stack.push(new Object[]{node.left,0});
					continue;
				}
			}
			
			if(status == 1){
				//此处中序
				objects[index++] = node.data;
				status = 2;
				objs[1] = status;
				if(node.right != null){
					stack.push(new Object[]{node.right,0});
					continue;
				}
			}
			
			//此处后序
			stack.pop();
		}
		
		return objects;
	}
	
	public void display(){
		display(top);
		System.out.println("");
	}
	
	public void display(Node node){
		if(node == null)
			return;
		
		if(node.left != null){
			display(node.left);
		}
		
		System.out.print(node.data + ",");
		
		if(node.right != null){
			display(node.right);
		}
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,1,3,9,8,5,4,1,8,7};
		
		BinaryTree tree = new BinaryTree();
		for(int i = 0 ; i < 10 ; i++){
			int key = arr[i];
			int value = arr[i];
			tree.add(key, value);
		}
		
		tree.display();
		
		tree.remove(4);
		System.out.println(Arrays.toString(tree.toArray()));
		
		tree.remove(3);
		System.out.println(Arrays.toString(tree.toArray()));
		
		tree.remove(8);
		System.out.println(Arrays.toString(tree.toArray()));
	}
}
