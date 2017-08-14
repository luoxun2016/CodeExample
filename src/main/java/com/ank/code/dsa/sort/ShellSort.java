package com.ank.code.dsa.sort;

import java.util.Arrays;

public class ShellSort {
	
	public void sort(int[] arr) {
		int h = 0;
		while(h < arr.length){
			h = h * 3 + 1;
		}
		
		while(h > 0){
			for(int i = 0 ; i < arr.length; i++){
				int pos = i + h;
				while(pos < arr.length){
					int inPos = pos;
					int inVal = arr[inPos];
					
					while(inPos > i){
						if(inVal < arr[inPos-h]){
							arr[inPos] = arr[inPos-h];
							inPos-=h;
							continue;
						}
						break;
					}
					arr[inPos] = inVal;
					
					pos+=h;
				}
			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,10,20,6,7,1,3,9};
		ShellSort shellSort = new ShellSort();
		shellSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}
