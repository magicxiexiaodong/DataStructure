package com.xxd.tree;

public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree binaryTree = new ArrBinaryTree(arr);
		binaryTree.preOrder(0);
	}
}
class ArrBinaryTree{
	private int[] arr;

	public ArrBinaryTree(int[] arr) {
		super();
		this.arr = arr;
	}
	public void preOrder(int index) {
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，遍历个锤子");
			return ;
		}
		
		System.out.println(arr[index]);
		
		if(2 * index + 1 < arr.length) {
			preOrder(2 * index + 1);
		}
		
		if(2 * index + 2 < arr.length) {
			preOrder(2 * index + 2);
		}
	}
}