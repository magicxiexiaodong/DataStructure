package com.xxd.sort;

import java.util.Arrays;

/**
 * @author 38636
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}
		int mid = l + ((r - l) >> 1);
		mergeSort(arr, l, mid);
		mergeSort(arr, mid + 1, r);
		merge(arr, l, mid, r);

	}

	private static void merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r + 1 - l];
		int i = 0;
		int p1 = l;
		int p2 = mid + 1;

		// 两边做比较
		while (p1 <= mid && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 左边全部完了
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		// 右边全部完了
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}

		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
	}

}
