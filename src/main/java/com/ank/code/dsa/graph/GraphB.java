package com.ank.code.dsa.graph;

import java.util.Stack;

public class GraphB {
	private static final int INFINTIE = Integer.MAX_VALUE;
	
	class Vertex{
		private String label;
		private boolean inTree;

		public Vertex(String label) {
			super();
			this.label = label;
			this.inTree = false;
		}
	}
	
	class DisToPar{
		private int distance;
		private int parent;
		
		public DisToPar(int distance, int parent) {
			this.distance = distance;
			this.parent = parent;
		}
	}
	
	private Vertex[] vertexList;
	private int vertexCount;
	private int[][] vertexMatrix;
	private DisToPar[] sPath;
	private int nTree;
	
	public GraphB(int initCapacity) {
		this.vertexList = new Vertex[initCapacity];
		this.vertexCount = 0;
		this.vertexMatrix = new int[initCapacity][initCapacity];
		for(int x = 0 ; x < initCapacity; x++){
			for(int y = 0 ; y < initCapacity; y++){
				vertexMatrix[x][y] = INFINTIE;
			}
		}
	}
	
	public void add(String label){
		Vertex vertex = new Vertex(label);
		vertexList[vertexCount] = vertex;
		vertexCount++;
	}
	
	public void addValue(int x , int y, int value){
		vertexMatrix[x][y] = value;
	}
	
	public void minpath(){
		this.sPath = new DisToPar[vertexCount];
		
		vertexList[0].inTree = true;
		nTree = 1;
		System.out.println(vertexList[0].label + " inTree");
		
		for(int i = 0 ; i < vertexCount ; i++){
			int distance = vertexMatrix[0][i];
			sPath[i] = new DisToPar(distance, 0);
		}
		
		while(nTree < vertexCount){
			int minDistance = INFINTIE;
			int minVertex = 0;
			for(int i = 1 ; i < vertexCount ; i++){
				if(!vertexList[i].inTree && sPath[i].distance < minDistance){
					minDistance = sPath[i].distance;
					minVertex = i;
				}
			}
			
			if(minDistance == INFINTIE){
				System.out.println("not found min");
				break;
			}
			
			vertexList[minVertex].inTree = true;
			nTree++;
			System.out.println(vertexList[minVertex].label + " inTree");
			
			for(int i = 1 ; i < vertexCount ; i++){
				if(vertexList[i].inTree){
					continue;
				}
				int distance = vertexMatrix[minVertex][i];
				if(distance != INFINTIE){
					distance = minDistance + distance;
					if(distance < sPath[i].distance){
						sPath[i].distance = distance;
						sPath[i].parent = minVertex;
					}
				}
			}
		}
		
		for(int i = 1 ; i < sPath.length ; i++){
			DisToPar disToPar = sPath[i];
			System.out.println(vertexList[i].label + ": " + vertexList[disToPar.parent].label + " to " + vertexList[i].label + " dis " + disToPar.distance);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(sPath.length - 1);
		while(true){
			int curr = stack.peek();
			stack.push(sPath[curr].parent);
			if(sPath[curr].parent == 0){
				break;
			}
		}
		
		while(!stack.isEmpty()){
			System.out.println(vertexList[stack.pop()].label);
		}
	}
	
	public static void main(String[] args) {
		GraphB example = new GraphB(20);
		example.add("A");
		example.add("B");
		example.add("C");
		example.add("D");
		example.add("E");
		
		example.addValue(0, 1, 50);
		example.addValue(0, 3, 80);
		example.addValue(1, 3, 90);
		example.addValue(1, 2, 60);
		example.addValue(2, 4, 40);
		example.addValue(3, 2, 20);
		example.addValue(3, 4, 70);
		example.addValue(4, 1, 50);
		
		example.minpath();
	}

}
