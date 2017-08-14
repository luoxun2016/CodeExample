package com.ank.code.dsa.heap;

public class Heap {
	private Integer[] elementData;
	private int elementCount;
	
	public Heap(int initCapacity) {
		this.elementData = new Integer[initCapacity];
		this.elementCount = 0;
	}
	
	public void push(Integer val){
		if(elementCount < elementData.length){
			if(elementCount == 0){
				elementData[elementCount] = val;
			}else{
				int currIndex = elementCount;
				while(currIndex > 0){
					int pIndex = (currIndex - 1) / 2;
					if(val.compareTo(elementData[pIndex]) > 0){
						elementData[currIndex] = elementData[pIndex];
						currIndex = pIndex;
					}else{
						elementData[currIndex] = val;
						break;
					}
					
					if(currIndex == 0){
						elementData[currIndex] = val;
					}
				}
			}
			elementCount++;
		}
	}
	
	public Integer pop(){
		if(elementCount > 0){
			Integer val = elementData[0];
			elementData[0] = null;
			
			elementCount--;
			Integer last = elementData[elementCount];
			elementData[elementCount] = null;
			
			int currIndex = 0;
			while(true){
				int childLIndex = (currIndex * 2) + 1;
				int childRIndex = childLIndex + 1;
				
				int maxChildIndex = childLIndex;
				if(childRIndex < elementCount){
					int compareVal = elementData[childLIndex].compareTo(elementData[childRIndex]);
					maxChildIndex = compareVal > 0 ? childLIndex : childRIndex;
				}else{
					if(childLIndex >= elementCount){
						elementData[currIndex] = last;
						break;
					}
				}
				if(elementData[maxChildIndex] == null){
					System.out.println("test");
				}
				if(last.compareTo(elementData[maxChildIndex]) == -1){
					elementData[currIndex] = elementData[maxChildIndex];
					currIndex = maxChildIndex;
				}else{
					elementData[currIndex] = last;
					break;
				}
			}
			return val;
		}
		return -1;
	}
	
	public int size(){
		return elementCount;
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(20);
		for(int i = 0 ;i < 10 ;i++){
			int val = (int) Math.round(Math.random() * 100);
			heap.push(val);
		}
		
		for(int i = 0 ;i < 10 ;i++){
			System.out.println(heap.pop());
		}
	}
}
