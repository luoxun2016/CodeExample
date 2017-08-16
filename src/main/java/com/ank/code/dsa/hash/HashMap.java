package com.ank.code.dsa.hash;

public class HashMap {
	private class Entry{
		private String key;
		private Object value;
		private Entry next;
		
		public Entry(String key, Object value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private Entry[] entries;
	
	public HashMap(int initCapacity) {
		this.entries = new Entry[initCapacity];
	}
	
	public Object put(String key, Object value){
		Object oldValue = null;
		int hashcode = key.hashCode();
		int pos = hashcode % entries.length;
		Entry oldEntry = entries[pos];
		if(oldEntry == null){
			Entry entry = new Entry(key, value);
			entries[pos] = entry;
		}else{
			Entry curr = oldEntry;
			Entry parent = null;
			while(curr != null){
				if(curr.key.hashCode() == hashcode && curr.key.equals(key)){
					oldValue = curr.value;
					curr.value = value;
					break;
				}
				parent = curr;
				curr = curr.next;
			}
			if(curr == null){
				Entry entry = new Entry(key, value);
				parent.next = entry;
			}
		}
		return oldValue;
	}
	
	public Object get(String key){
		int hashcode = key.hashCode();
		int pos = hashcode % entries.length;
		Entry entry = entries[pos];
		if(entry == null){
			return null;
		}else{
			//TODO
			return null;
		}
	}
	
	public Object remove(String key){
		return null;
	}
	
	public static void main(String[] args) {
		HashMap hashMap = new HashMap(100);
		for(int i = 0 ; i < 50 ; i++){
			int value = (int) Math.round(Math.random() * 100);
			System.out.println("put " + value);
			Object oldValue = hashMap.put(String.valueOf(value), value);
			System.out.println("old value " + String.valueOf(oldValue));
		}
	}
}
