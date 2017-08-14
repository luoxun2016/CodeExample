package com.ank.code.dsa.queue;

public interface Queue {

	void push(Object o);
	
	Object peek();
	
	Object pop();
	
	boolean isEmpty();
	
	boolean isFull();
	
	int size();
	
}
