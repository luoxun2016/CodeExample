package com.ank.code.dsa.stack;

public class ArrayStack implements Stack{
	private Object[] elementData;
	private int elementCount;
	
	public ArrayStack(int initCapacity) {
		this.elementData = new Object[initCapacity];
		this.elementCount = 0;
	}
	
	
	public void push(Object o){
		if(elementCount < elementData.length){
			elementData[elementCount++] = o;
		}
	}
	
	public Object peek(){
		return elementData[elementCount-1];
	}
	
	public Object pop(){
		if(elementCount >= 0){
			elementCount--;
			Object o = elementData[elementCount];
			elementData[elementCount] = null;
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
		ArrayStack stack = new ArrayStack(100);
		for(int i = 0 ; i < 50 ; i++){
			stack.push(i);
		}
		for(int i = 0 ; i < 50 ; i++){
			System.out.println(stack.pop());
		}
	}
}
