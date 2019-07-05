package com.xxd.recursion;

/**
 * @author 38636
 *
 */
public class Queue8 {
	int max = 8;
	int[] array = new int[max];
	static int count = 0;
	static int judgeCount = 0;

	public static void main(String[] args) {
		// 测试一把 ， 8皇后是否正确
		Queue8 queue8 = new Queue8();
		queue8.check(0);
		System.out.printf("一共有%d解法", count);
		System.out.printf("一共判断冲突的次数%d次", judgeCount); // 1.5w
	}

	private void check(int n) {
		if (n == max) {
			print();
			return;
		}

		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
