package com.xxd.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @author 38636
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
	//	int arr[] = { -1, -2, 3, 3, 10, 5 };
		
		int arr[] = new int[80000];
		
		for(int i = 0 ;i<80000;i++) {
			Random random = new  Random();
			arr[i] = random.nextInt(80000);
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(currentDate);
		System.out.println("当前时间:"+date);
		
		
		
		bubbleSort(arr);
		Date sortAfterDate = new Date();
		String date2 = sdf.format(sortAfterDate);
		System.out.println("排序后时间:"+date2);
	//	print(arr);
		
		
	}

	public static void bubbleSort(int[] arr) {
		
		if (arr.length < 2 || arr == null) {
			return;
		}
		boolean isChanged = false ;
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
					isChanged = true;
				}
			}
			/*System.out.println("第" + (i+1 ) +"次排序"  );
			System.out.println(Arrays.toString(arr));*/
			if( !isChanged ) {
				break;
			}else {
				isChanged = false;
			}
		}

	}

	public static void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
