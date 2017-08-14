package com.ank.code.dsa.sort;

import java.util.Arrays;

public class MergeSort {
	private int[] tempArray;
	
	public void sort(int[] arr) {
		tempArray = new int[arr.length];
		sort(arr, 0, arr.length-1);
	}
	
	private void sort(int[] arr, int start , int end){
		if(end - start >= 1){
			int mid = start + (end - start) / 2;
			
			sort(arr, start, mid);
			sort(arr, mid+1, end);
			
			int leftPos = start;
			int rightPos = mid + 1;
			int i = 0;
			
			while(leftPos <= mid && rightPos <= end){
				if(arr[leftPos] < arr[rightPos]){
					tempArray[i++] = arr[leftPos];
					leftPos++;
				}else{
					tempArray[i++] = arr[rightPos];
					rightPos++;
				}
			}
			
			while(leftPos <= mid){
				tempArray[i++] = arr[leftPos++];
			}
			
			while(rightPos <= end){
				tempArray[i++] = arr[rightPos++];
			}
			
			for(int n = 0; n <= end - start ; n++){
				arr[start+n] = tempArray[n];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,10,20,6,7,1,3,9};
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
