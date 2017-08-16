package com.ank.code.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphA {
	
	private class Vertex{
		private char label;
		private boolean wasVisited;
		
		public Vertex(char label) {
			this.label = label;
			this.wasVisited = false;
		}
	}
	
	private Vertex[] vertexList;
	private int size;
	private int[][] routes;
	
	public GraphA(int initCapacity) {
		this.vertexList = new Vertex[initCapacity];
		this.routes = new int[initCapacity][initCapacity];
	}
	
	public void add(char label){
		vertexList[size++] = new Vertex(label);
	}
	
	public void addRoute(int x , int y){
		routes[x][y] = 1;
		routes[y][x] = 1;
	}
	
	public void dsf(){
		Stack<Integer> stack = new Stack<Integer>();
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		while(!stack.isEmpty()){
			int y = stack.peek();
			y = getNextVetex(y);
			if(y != -1){
				displayVertex(y);
				stack.push(y);
				vertexList[y].wasVisited = true;
			}else{
				stack.pop();
			}
		}
	}
	
	public void bsf(){
		Queue<Integer> queue = new LinkedList<Integer>(); 
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.add(0);
		while(!queue.isEmpty()){
			int y = queue.remove();
			while(true){
				int x = getNextVetex(y);
				if(x == -1){
					break;
				}else{
					displayVertex(x);
					queue.add(x);
					vertexList[x].wasVisited = true;
				}
			}
		}
	}
	
	private int getNextVetex(int y){
		for(int x = 0 ; x < this.routes[y].length ; x++){
			if(routes[y][x] == 1 && !vertexList[x].wasVisited){
				return x;
			}
		}
		return -1;
	}
	
	private void displayVertex(int i){
		System.out.println(vertexList[i].label);
	}
	
	public void warshell(){
		for(int y = 0 ;y < this.routes.length ;y++){
			for(int x = 0 ;x < this.routes.length ;x++){
				if(routes[y][x] == 1){
					for(int z = 0 ; z < this.routes.length ;z++){
						if(routes[z][y] == 1){
							routes[z][x] = 1;
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GraphA graph = new GraphA(5);
		graph.add('a');
		graph.add('b');
		graph.add('c');
		graph.add('d');
		graph.add('e');
		
		graph.addRoute(0, 1);
		graph.addRoute(1, 2);
		graph.addRoute(2, 4);
		graph.addRoute(0, 3);
		
		graph.dsf();
		graph.bsf();
	}
}
