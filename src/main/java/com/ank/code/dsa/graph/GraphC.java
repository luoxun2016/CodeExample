package com.ank.code.dsa.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 有向带权图的最小生成树
 * @author Administrator
 *
 */
public class GraphC {
	private class Vertex{
		private char label;
		private boolean wasVisited;
		
		public Vertex(char label) {
			this.label = label;
			this.wasVisited = false;
		}
	}
	
	private class Edge{
		private int src;
		private int des;
		private int v;
		
		public Edge(int src, int des, int v) {
			this.src = src;
			this.des = des;
			this.v = v;
		}
	}
	
	private int[][] routes;
	private Vertex[] vertexList;
	private int vertexCount;
	private int currentVertex;
	private Queue<Edge> queue;
	
	public GraphC(int initCapacity) {
		this.routes = new int[initCapacity][initCapacity];
		this.vertexList = new Vertex[initCapacity];
		this.vertexCount = 0;
		this.queue = new PriorityQueue<Edge>();
	}
	
	private void add(char label) {
		vertexList[vertexCount++] = new Vertex(label);
	}
	
	private void addRoute(int x, int y, int v) {
		routes[x][y] = v;
	}
	
	private void mstw(){
		currentVertex = 0;
		int count = 1;
		while(count < vertexCount){
			for(int i = 1 ; i < vertexCount ; i++){
				if(vertexList[currentVertex] == vertexList[i])
					continue;
				if(vertexList[i].wasVisited)
					continue;
				if(routes[currentVertex][i] == 0)
					continue;
				
				putQ(i, routes[currentVertex][i]);
			}
			
			if(queue.isEmpty()){
				System.out.println("not connected");
				return;
			}
			
			Edge edge = queue.remove();
			System.out.println("from "+vertexList[edge.src]+" to " + vertexList[edge.des]);
			currentVertex = edge.des;
			count++;
		}
	}
	
	private void putQ(int des, int v) {
		Edge edge = new Edge(currentVertex, des, v);
		queue.add(edge);
	}

	public static void main(String[] args) {
		GraphC graphW = new GraphC(20);
		graphW.add('a');
		graphW.add('b');
		graphW.add('c');
		graphW.add('d');
		graphW.add('e');
		
		graphW.addRoute(0, 0, 0);
		
		graphW.mstw();
		
	}
	
}
