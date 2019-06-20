package com.xxd.recursion;

/**
 * @author XXd
 *
 */
public class RecursionTest {
	public static void main(String[] args) {
		test(4);
		System.out.println("4!=" + mul(4));
	}
	
	// 打印问题
	public static void test(int n) {
		if(n > 2) {
			test ( n -1 );
		}
		System.out.println("n="+n);
	}
	// 阶乘问题
	public static int mul(int n ) {
		if(n == 0 || n == 1) {
			return 1 ;
		} else {
			return n * mul(n-1);
		}
		
	}

}