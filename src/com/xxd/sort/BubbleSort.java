package com.xxd.sort;

import java.util.Arrays;

/**
 * @author 38636
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = { -1, -2, 3, 3, 10, 5 };
		bubbleSort(arr);
		print(arr);
	}

	public static void bubbleSort(int[] arr) {
		if (arr.length < 2 || arr == null) {
			return;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					/*
					 * int temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp;
					 */
					// 装逼写法，需要注意的一点是，下面这种写法 是在两个数字 不一样的情况下才能使用，倘若两个数字  一样会不起作用
					// 就是没有交换
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j + 1];
					arr[j] = arr[j] ^ arr[j + 1];
				}
			}
		}

	}

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
