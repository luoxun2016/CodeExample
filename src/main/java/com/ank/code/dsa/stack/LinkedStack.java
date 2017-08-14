package com.ank.code.dsa.stack;

import com.ank.code.dsa.list.LinkedList;

public class LinkedStack implements Stack{
	private LinkedList list;
	
	public LinkedStack() {
		this.list = new LinkedList();
	}

	public void push(Object o) {
		list.add(o);
	}

	public Object peek() {
		return list.getLast();
	}

	public Object pop() {
		return list.removeLast();
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
