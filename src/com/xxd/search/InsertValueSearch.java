package com.xxd.search;

public class InsertValueSearch {
	private static int count = 0;
	private static int count1 = 0;

	public static void main(String[] args) {
		/*
		 * int[] arr = new int[100]; for (int i = 0; i < 50; i++) { arr[i] = i + 2; }
		 */
		int arr[] = { 1, 8, 89, 1000, 1000, 1000, 1234 };
		int index = insertValueSearch(arr, 0, 6, 1);
		int index1 = binarySearch(arr, 0, 6, 1);
		System.out.println(index);
		System.out.println("查找到的索引" + index + "值为" + arr[index]);
		System.out.println("查找的次数" + count);

		System.out.println("---------- 二分查找结果如下 ----------");

		System.out.println("查找到的索引" + index1 + "值为" + arr[index1]);
		System.out.println("查找的次数" + count1);

	}

	public static int insertValueSearch(int[] arr, int left, int right, int findVal) { 

		System.out.println("插值查找次数~~");
		
		//注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
		//否则我们得到的 mid 可能越界
		if (left > right || findVal < arr[left] || findVal > arr[right]) {
			return -1;
		}

		// 求出mid, 自适应
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if (findVal > midVal) { // 说明应该向右边递归
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 说明向左递归查找
			return insertValueSearch(arr, left, mid - 1, findVal);
		} else {
			return mid;
		}
	}
	
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return -1;
		}
		count1++;
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		// 中间值 大于要查找的值 从右边开始找
		if (midVal < findVal) {
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (midVal > findVal) {
			return binarySearch(arr, left, mid - 1, findVal);
		} else {
			return mid;
		}
	}
}
