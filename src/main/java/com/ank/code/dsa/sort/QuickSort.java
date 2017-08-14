package com.ank.code.dsa.sort;

import java.util.Arrays;

public class QuickSort {
	
	public void sort(int[] arr) {
		sort(arr, 0 , arr.length-1);
	}
	
	private void sort(int[] arr, int low, int high) {
		if(low > high){
			return;
		}else{
			int mid = partition(arr, low, high);
			sort(arr, low, mid-1);
			sort(arr, mid+1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int midVal = arr[low];
		
		int leftPos = low + 1;
		int rightPos = high;
		
		while(leftPos < rightPos){
			while(leftPos <= rightPos && arr[leftPos] < midVal){
				leftPos++;
			}
			
			while(leftPos <= rightPos && arr[rightPos] > midVal){
				rightPos--;
			}
			
			if(leftPos < rightPos){
				int temp = arr[leftPos];
				arr[leftPos] = arr[rightPos];
				arr[rightPos] = temp;
			}
		}
		
		arr[low] = arr[rightPos];
		arr[rightPos] = midVal;
		
		return rightPos;
	}

	public static void main(String[] args) {
		int[] arr = {2,10,20,6,7,1,3,9};
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
