package com.ank.code.dsa.sort;

import java.util.Arrays;

public class SimpleSort {
	
	// 冒泡排序
	public static void dubbSort(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = i + 1 ; j < arr.length ; j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		// OR
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr.length - i - 1; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	// 选择排序
	public static void choseSort(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			int min = arr[i];
			int minPos = i;
			for(int j = i + 1 ; j < arr.length ; j++){
				if(arr[j] < min){
					min = arr[j];
					minPos = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[minPos];
			arr[minPos] = temp;
		}
	}
	
	//插入排序
	public static void insertSort(int[] arr){
		for(int i = 1 ; i < arr.length ; i++){
			int inVal = arr[i];
			int pos = i;
			while(pos > 0){
				if(inVal < arr[pos-1]){
					arr[pos] = arr[pos-1];
					pos--;
					continue;
				}
				break;
			}
			arr[pos] = inVal;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,10,20,6,7,1,3,9};
		dubbSort(arr);
		choseSort(arr);
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
