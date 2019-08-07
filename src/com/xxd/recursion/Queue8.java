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

		for (int i = 0; i < max; i++) { // 给皇后放位置，遍历放，看那个满足，满足 就放下一行皇后
			array[n] = i;
			if (judge(n)) {
				check(n + 1);
			}
		}
	}

	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) { // 从第一行开始判断，跟当前的行数做判断，首先不能相等，其次不等在同一个斜线上
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
