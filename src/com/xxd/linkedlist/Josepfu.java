/**
 * 
 *qq:357301570 单身美女专用
 * @author Xxd 
  *          佛祖保佑             永无BUG
 */
package com.xxd.linkedlist;

/**
 * @author 38636
 *
 */
public class Josepfu {
	public static void main(String[] args) {
		// 测试一把看看构建环形链表，和遍历是否ok
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);// 加入5个小孩节点
		// circleSingleLinkedList.showBoy();

		// 测试一把小孩出圈是否正确
		circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3
		// String str = "7*2*2-5+1-5+3-3";
	}
}

class CircleSingleLinkedList {
	private Boy first = null;

	// 根据用户的输入，计算出小孩出圈的顺序
	/**
	 * 
	 * @param startNo  表示从第几个小孩开始数数
	 * @param countNum 表示数几下
	 * @param nums     表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		if (first == null || startNo < 1 || startNo > nums || nums < 1) {
			System.out.println("参数输入有误， 请重新输入");
			return;
		}

		// 增加一个辅助指针 指向 first 的 后面一个 主要用来 删除节点
		Boy helper = first;

		// 把 helper 指针 移动到first 后面
		while (helper.getNext() != first) {
			helper = helper.getNext();
		}

		// 把 first 指针和 helper 指针 移动到 第startNo 个小孩
		for (int i = 1; i < startNo; i++) {
			first = first.getNext();
			helper = helper.getNext();
		}

		// 开始出圈
		// first 指针 指向 要删除的那个节点 即 要出圈的那个孩子
		while (helper != first) {
			for (int i = 0; i < countNum - 1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			// 开始出圈
			System.out.println("出圈的小孩为" + first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.println("最后留在圈中的小孩为" + first.getNo());
	}

	/**
	 * 批量添加小孩的数目
	 * 
	 * @param num
	 */
	public void addBoy(int num) {
		if (num < 1) {
			System.out.println("无法添加");
			return;
		}
		Boy curBoy = first; // 代表当前最后的一个小孩
		for (int i = 1; i <= num; i++) {
			Boy boy = new Boy(i);
			if (i == 1) {
				first = boy;
				curBoy = first;
				curBoy.setNext(first);
			} else {
				curBoy.setNext(boy);
				curBoy = boy;
				curBoy.setNext(first);
			}
		}
	}

	public void showBoy() {
		// 判断链表是否为空
		if (first == null) {
			System.out.println("没有任何小孩~~");
			return;
		}
		Boy curBoy = first;
		while (true) {
			System.out.printf("小孩的编号 %d \n", curBoy.getNo());
			if (curBoy.getNext() == first) {// 说明已经遍历完毕
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
}

class Boy {
	private int no;
	private Boy next;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

	public Boy(int no) {
		super();
		this.no = no;
	}

}