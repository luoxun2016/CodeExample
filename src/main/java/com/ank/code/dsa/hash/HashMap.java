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
		Entry entry = new Entry(key, value);
		int hashcode = key.hashCode();
		int pos = hashcode % entries.length;
		Entry oldEntry = entries[pos];
		if(oldEntry == null){
			entries[pos] = entry;
		}else{
			Entry curr = oldEntry;
			Entry parent = oldEntry;
			while(curr != null){
				if(curr.key.hashCode() == hashcode && curr.key.equals(key)){
					
					break;
				}
				parent = curr;
				curr = curr.next;
			}
		}
		return null;
	}
	
	public Object get(String key){
		return null;
	}
	
	public Object remove(String key){
		return null;
	}
	
}
