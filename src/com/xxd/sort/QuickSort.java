package com.xxd.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 38636
 *
 */
public class QuickSort { 
	public static void main(String[] args) {
		//int[] arr = { -9, 78, 0, 23, -567, 70, -1, 900, 4561 };
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);
		
		quickSort(arr, 0, arr.length-1);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);
	}

	public static void quickSort(int[] arr, int low, int high) {
		// low,high 为每次处理数组时的首、尾元素索引

		// 当low==high是表示该序列只有一个元素，不必排序了
		if (low >= high) {
			return;
		}
		// 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
		int i = low, j = high, base = arr[low];
		while (i < j) {
			// 右边哨兵从后向前找
			while (arr[j] >= base && i < j) {
				j--;
			}
			// 左边哨兵从前向后找
			while (arr[i] <= base && i < j) {
				i++;
			}
			swap(arr, i, j); // 交换元素
		}
		swap(arr, low, j); // 基准元素与右哨兵交换

		// 递归调用，排序左子集合和右子集合
		quickSort(arr, low, j - 1);
		quickSort(arr, j + 1, high);

	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
