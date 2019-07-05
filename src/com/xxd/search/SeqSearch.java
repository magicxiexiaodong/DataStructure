package com.xxd.search;

public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组

		int index = seqSearch(arr, -1);
		if (index == -1) {
			System.out.println("没有找到到");
		} else {
			System.out.println("找到，下标为=" + index);
		}
	}

	public static int seqSearch(int[] arr, int value) {
		if (arr == null) {
			return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
