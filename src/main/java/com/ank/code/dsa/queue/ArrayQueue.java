package com.ank.code.dsa.queue;

public class ArrayQueue implements Queue{
	private Object[] elementData;
	private int elementCount;
	private int firstPos;
	private int lastPos;
	
	public ArrayQueue(int initCapacity) {
		this.elementData = new Object[initCapacity];
		this.elementCount = 0;
		this.firstPos = 0;
		this.lastPos = 0;
	}
	
	public void push(Object o){
		if(elementCount < elementData.length){
			elementData[lastPos++] = o;
			elementCount++;
			if(lastPos == elementData.length){
				lastPos = 0;
			}
		}
	}
	
	public Object peek(){
		return elementData[firstPos];
	}
	
	public Object pop(){
		if(elementCount > 0){
			Object o = elementData[firstPos];
			elementData[firstPos++] = null;
			elementCount--;
			if(firstPos == elementData.length){
				firstPos = 0;
			}
			return o;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return elementCount == 0;
	}
	
	public boolean isFull(){
		return elementCount == elementData.length;
	}
	
	public int size(){
		return elementCount;
	}
	
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(20);
		for(int i = 0 ; i < 20; i++){
			queue.push(i);
		}
		
		for(int i = 0 ;i < 20; i++){
			System.out.println(queue.pop());
		}
		
		for(int i = 0 ; i < 20; i++){
			queue.push(i);
		}
		
		for(int i = 0 ;i < 22; i++){
			System.out.println(queue.pop());
		}
	}
}
