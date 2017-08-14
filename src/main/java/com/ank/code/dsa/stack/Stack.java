package com.ank.code.dsa.stack;

public interface Stack {

	void push(Object o);
	
	Object peek();
	
	Object pop();
	
	boolean isEmpty();
	
	boolean isFull();
	
	int size();
	
}
