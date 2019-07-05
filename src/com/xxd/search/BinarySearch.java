package com.xxd.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = { 1, 8, 10, 89, 1000, 1000,1000, 1234 };
		List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
		for (Integer integer : list) {
			System.out.print(integer + "\t");
		}
	}

	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		if (left > right) {
			return -1;
		}
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

	/**
	 *  查找所有的值得索引 
	 * @param arr
	 * @param left
	 * @param right
	 * @param findVal
	 * @return
	 */
	public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
		// 当 left > right 时，说明递归整个数组，但是没有找到
		if (left > right) {
			return new ArrayList<Integer>();

		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // 向 右递归
			return binarySearch2(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch2(arr, left, mid - 1, findVal);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(mid);
			int temp = mid - 1;
			// 向左扫描
			while(true) {
				if(temp < left || arr[temp] != findVal ) {
					break;
				}
				list.add(temp--);
			}
			
			int temp2 = mid +1 ;
			// 向左扫描
			while(true) {
				if(temp2 > right || arr[temp2] != findVal ) {
					break;
				}
				list.add(temp2++);
			}
			return list ;
		}
	}
}
