package com.xxd.sparseArray;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class sparseArray {

	public static void main(String[] args) {

		int chessArray[][] = new int[11][10];

		chessArray[1][2] = 1;
		chessArray[2][3] = 2;
		chessArray[4][5] = 2;

		// 原来的二维数组
		System.out.println("原来的二维数组");
		printArr(chessArray);

		// 二维数组转稀疏数组
		int[][] sparseArr = genSparseArr(chessArray);

		// 打印稀疏数组
		System.out.println("生成的稀疏数组");
		System.out.println("=================");
		printArr(sparseArr);
		
		// 将稀疏数组 保存到文件中 map.data

		//genFile(sparseArr,"d:/map.data");

		// 读取文件 转化为 二维数组
		// int[][] sparseArray = readFile("d:/map.data");

		// printArr(sparseArray);

		// 将稀疏数组转为原来的二维数组
		int[][] chessArray2 = sparseArr2chessArr(sparseArr);

		// 打印转化后的稀疏数组
		System.out.println("========================");
		printArr(chessArray);
	}

	@SuppressWarnings("resource")
	private static int[][] readFile(String filePath) {
		int[][] parseArr = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
			Object object = ois.readObject();
			parseArr = (int[][]) object;
			return parseArr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parseArr;
	}

	private static void genFile(int[][] sparseArr, String filePath) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
			oos.writeObject(sparseArr);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int[][] sparseArr2chessArr(int[][] sparseArr) {
		// 生成原来的数组
		int chessArr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		return chessArr;
	}

	private static int[][] genSparseArr(int[][] chessArray) {
		// 1 找出有多少个非0的数字 sum
		int sum = 0;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[0].length; j++) {
				if (chessArray[i][j] != 0) {
					sum++;
				}
			}
		}

		// 2 生成 new[sum+1][3]
		int sparseArr[][] = new int[sum + 1][3];
		sparseArr[0][0] = chessArray.length; // 多少行
		sparseArr[0][1] = chessArray[0].length; // 多少列
		sparseArr[0][2] = sum;

		// 3 将非0 数字塞入
		int row = 1;
		for (int i = 0; i < chessArray.length; i++) {
			for (int j = 0; j < chessArray[0].length; j++) {
				if (chessArray[i][j] != 0) {
					sparseArr[row][0] = i;
					sparseArr[row][1] = j;
					sparseArr[row++][2] = chessArray[i][j];
				}
			}
		}

		return sparseArr;
	}

	public static void printArr(int arr[][]) {
		for (int[] row : arr) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}

}
