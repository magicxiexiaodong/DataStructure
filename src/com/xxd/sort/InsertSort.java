package com.xxd.sort;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author 38636
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int arr [] = new int[80000];
		for(int i = 0 ;i<80000;i++) {
			Random random = new  Random();
			arr[i] = random.nextInt(80000);
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(currentDate);
		System.out.println("当前时间:"+date);
		
		
		
		insertSort(arr);
		Date sortAfterDate = new Date();
		String date2 = sdf.format(sortAfterDate);
		System.out.println("排序后时间:"+date2);
	}
	
	public static void insertSort(int[] arr) {
		
		if(arr==null || arr.length < 2) {
			return ;
		}
		int insertValue  = 0;
		int insertIndex = 0 ;
		for(int i = 1 ; i < arr.length ;i++) {
			 insertValue  = arr[i];
			 insertIndex = i -1 ;
			
			while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
				arr[insertIndex + 1]  = arr[insertIndex]; // 向后移
				insertIndex -- ;
			}
			//找到插入的位置了
			if(insertIndex + 1 != i ) {
				arr[insertIndex + 1] = insertValue; 
			}
		}
	
		
		
		
		/*int insertValue  = arr[1];
		int insertIndex = 1 -1 ;
		
		while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
			arr[insertIndex + 1]  = arr[insertIndex]; // 向后移
			insertIndex -- ;
		}
		//找到插入的位置了
		arr[insertIndex + 1] = insertValue; 
		System.out.println("第1轮插入");
		System.out.println(Arrays.toString(arr));
		
		
		 insertValue  = arr[2];
		 insertIndex = 2 -1 ;
		
		while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
			arr[insertIndex + 1]  = arr[insertIndex]; // 向后移
			insertIndex -- ;
		}
		//找到插入的位置了
		arr[insertIndex + 1] = insertValue; 
		System.out.println("第2轮插入");
		System.out.println(Arrays.toString(arr));
		
		
		insertValue  = arr[3];
		 insertIndex = 3 -1 ;
		
		while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
			arr[insertIndex + 1]  = arr[insertIndex]; // 向后移
			insertIndex -- ;
		}
		//找到插入的位置了
		arr[insertIndex + 1] = insertValue; 
		System.out.println("第3轮插入");
		System.out.println(Arrays.toString(arr));*/
	}
}
