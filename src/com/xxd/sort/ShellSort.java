package com.xxd.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author 38636
 *
 */
public class ShellSort {

	public static void main(String[] args) {

		 //int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 }; //shellSort(arr);

		int arr[] = new int[8000000];

		for (int i = 0; i < 8000000; i++) {
			Random random = new Random();
			arr[i] = random.nextInt(8000000);
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(currentDate);
		System.out.println("当前时间:" + date);

		shellSort2(arr);
	//	System.out.println(Arrays.toString(arr));
		Date sortAfterDate = new Date();
		String date2 = sdf.format(sortAfterDate);
		System.out.println("排序后时间:" + date2);
	}
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	// 对交换式的希尔排序进行优化->移位法
	public static void shellSort2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for(int gap = arr.length / 2; gap > 0;gap = gap / 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0 && arr[j] > arr[j + gap]; j -= gap) {
					swap(arr, j, j + gap);
				}
			}
		}
		/*for (int i = 5; i < arr.length; i++) {
			for (int j = i - 5; j >= 0 && arr[j] > arr[j + 5]; j -= 5) {
				swap(arr, j, j + 5);
			}
		}
		
		for (int i = 2; i < arr.length; i++) {
			for (int j = i - 2; j >= 0 && arr[j] > arr[j + 2]; j -= 2) {
				swap(arr, j, j + 2);
			}
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j -= 1) {
				swap(arr, j, j + 1);
			}
		}*/
		
		/*for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			for(int i = gap ; i < arr.length ;i++) {
				for(int j =  i-gap ; j - gap >= 0 && arr[j] < arr[j-gap] ; j -= gap) {
					swap(arr, j-gap, j );
				}
			}
		}*/
		
	}

	public static void shellSort(int[] arr) {

		if (arr == null || arr.length < 2) {
			return;
		}
		int temp = 0;

		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			for (int i = gap; i < arr.length; i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}

	}

}
