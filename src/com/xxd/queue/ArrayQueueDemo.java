package com.xxd.queue;

import java.util.Scanner;

/**
  *    数组链表
 * @author 38636
 *
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);

			switch (key) {
			case 's':
				queue.showQueue();
				break;

			case 'e':
				scanner.close();
				loop = false;
				break;

			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;

			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			default:
				break;
			}
		}

	}
}

class ArrayQueue {
	private int rear; // 队列尾
	private int front; // 队列头
	private int[] arr;
	private int maxSize;

	public ArrayQueue(int maxSize) {
		this.arr = new int[maxSize];
		this.rear = -1;
		this.front = -1;
		this.maxSize = maxSize;
	}

	// 判断队列是否满
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		if (isFull()) {
			throw new RuntimeException("队列已经满了 不能在添加");
		} else {
			arr[++rear] = n;
		}
	}

	// 获取队列的数据, 出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		} else {
			return arr[++front];
		}

	}

	// 显示队列的所有数据
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("队列空的，没有数据~~");
			return;
		} else {
			
			for ( int i = 0;  i < arr.length; i++) {
				System.out.printf("arr[%d]=%d\n", i, arr[i]);
			}
		}
	}

	// 显示队列的头数据， 注意不是取出数据
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列空的，没有数据~~");
		}
		return arr[front+1];
	}

}