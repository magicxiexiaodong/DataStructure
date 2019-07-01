package com.xxd.sort;

import java.util.Arrays;

/**
 * @author 38636
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int arr[] = { 55, 34, 119, 101,44} ; 
		selectSort(arr);
		print(arr);
	}

	public static void selectSort(int arr[]) {
		
		for(int i = 0; i < arr.length -1 ;i++) {
			int minIndex = i;
			int min = arr[minIndex];
			
			for(int j = minIndex + 1 ;j < arr.length ;j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j ;
				}
			}
			
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
		
		/*int minIndex = 0;
		int min = arr[minIndex];
		for (int j = minIndex + 1; j < arr.length; j++) {
			if (min > arr[j]) {
				min = arr[j];
				minIndex = j;
			}
		}
		// 将最小值，放在arr[0], 即交换
		if (minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}

		System.out.println("第1轮后~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
	
		
		minIndex = 1;
		min = arr[minIndex];
		
		for (int j = minIndex + 1; j < arr.length; j++) {
			if (min > arr[j]) {
				min = arr[j];
				minIndex = j;
			}
		}
		// 将最小值，放在arr[0], 即交换
		if (minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("第2轮后~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
		
		minIndex = 2;
		min = arr[minIndex];
		
		for (int j = minIndex + 1; j < arr.length; j++) {
			if (min > arr[j]) {
				min = arr[j];
				minIndex = j;
			}
		}
		// 将最小值，放在arr[0], 即交换
		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}

		System.out.println("第3轮后~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
*/		
	}
	
	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
}
