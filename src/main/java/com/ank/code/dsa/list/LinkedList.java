package com.ank.code.dsa.list;

import java.util.Iterator;

public class LinkedList implements Iterable<Object>{
	private class Node{
		private Object data;
		private Node pre;
		private Node next;
		
		public Node(Object data) {
			this.data = data;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public void add(Object o){
		Node node = new Node(o);
		if(first == null){
			first = node;
			last = node;
		}else{
			last.next = node;
			node.pre = last;
			last = node;
		}
		size++;
	}
	
	public Object getFirst(){
		return first.data;
	}
	
	public Object getLast(){
		return last.data;
	}
	
	public Object removeFirst(){
		if(size > 0){
			Object o = first.data;
			first = first.next;
			if(first != null){
				first.pre = null;
			}
			size--;
			return o;
		}
		return null;
	}
	
	public Object removeLast(){
		if(size > 0){
			Object o = last.data;
			last = last.pre;
			if(last != null){
				last.next = null;
			}
			size--;
			return o;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public Iterator<Object> iterator() {
		return new ListIterator(first);
	}
	
	class ListIterator implements Iterator<Object>{
		private Node tempPtr;
		
		public ListIterator(Node first) {
			this.tempPtr = first;
		}
		
		public boolean hasNext() {
			return tempPtr != null;
		}

		public Object next() {
			Object o = tempPtr.data;
			tempPtr = tempPtr.next;
			return o;
		}

		public void remove() {
			if(tempPtr.pre != null){
				tempPtr.pre.next = tempPtr.next;
			}
			if(tempPtr.next != null){
				tempPtr.next.pre = tempPtr.pre;
			}
			Node oldPtr = tempPtr;
			tempPtr = tempPtr.next;
			oldPtr.pre = null;
			oldPtr.next = null;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for(int i = 0 ; i < 50 ;i++){
			list.add(i);
		}
		
		for(int i = 0 ; i < 20 ;i++){
			System.out.println(list.removeFirst());
		}
		
		for(int i = 0 ; i < 20 ;i++){
			System.out.println(list.removeLast());
		}
		
		Iterator<Object> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
