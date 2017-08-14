package com.ank.code.dsa.queue;

import com.ank.code.dsa.list.LinkedList;

public class LinkedQueue implements Queue{

	private LinkedList list;
	
	public LinkedQueue() {
		this.list = new LinkedList();
	}

	public void push(Object o) {
		list.add(o);
	}

	public Object peek() {
		return list.getFirst();
	}

	public Object pop() {
		return list.removeFirst();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return list.size();
	}
	
}
