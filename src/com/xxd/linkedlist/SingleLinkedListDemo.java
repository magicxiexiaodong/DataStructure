package com.xxd.linkedlist;

import java.util.Stack;

/**
 * 单向链表
 * 
 * QQ : 357301570 tel : 13755797798
 * 
 * @author Xxd
 *
 */
public class SingleLinkedListDemo {
	public static void main(String[] args) {
		HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
		HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
		HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");

		SingleLinkedList linkedList = new SingleLinkedList();
		linkedList.addOrderBy(heroNode1);
		linkedList.addOrderBy(heroNode4);
		linkedList.addOrderBy(heroNode3);
		linkedList.addOrderBy(heroNode2);
		System.out.println("原来的单链表");
		linkedList.list();
		linkedList.reversetList(linkedList.getHead());
		
		System.out.println("反转链表~~~~~~~~~~");
		linkedList.list();
		//linkedList.reversePrint(linkedList.getHead());
		
		//System.out.println("反转之后的单链表");
		//linkedList.list();
		/*
		 * linkedList.add(heroNode1); linkedList.add(heroNode2);
		 * linkedList.add(heroNode3); linkedList.add(heroNode4);
		 */
		/*
		HeroNode node = linkedList.getReciprocalK(linkedList.getHead(), 1);
		System.out.println(node);

		System.out.println("==================");

		// HeroNode newHero = new HeroNode(2, "卢俊俊", "玉麒麟~~~");
		// linkedList.updateData(newHero);
		linkedList.delData(2);
		linkedList.delData(3);
		linkedList.delData(1);
		linkedList.delData(4);

		System.out.println("删除后的链表~~~~~~~~~~~~");
		linkedList.list();
		*/

	}
}

class SingleLinkedList {
	// 头结点什么也不放
	private HeroNode head = new HeroNode(0, "", "");
	
	//反转打印 单链表
	public void reversePrint(HeroNode head) {
		if(head.next == null) {
			System.out.println("单链表为空~~~~~~~");
		}
		
		Stack<HeroNode> stack = new Stack<HeroNode>();
		
		HeroNode next = head.next;
		while(next != null) {
			//取出一个元素 放入stack中 
			stack.push(next);
			next = next.next;
		}
		
		//反向打印
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
	
	// 将单链表反转  tencent 面试题
	public void reversetList(HeroNode head) {
		if (head.next == null || head.next.next == null) {
			return;
		}

		// 定义一个辅助的指针(变量)，帮助我们遍历原来的链表
		HeroNode cur = head.next;

		HeroNode rev = new HeroNode(0, "", "");
		HeroNode next = null; 
		// 指向当前节点[cur]的下一个节点
		// 遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
		// 动脑筋
		while (cur != null) {
			next = cur.next;// 先暂时保存当前节点的下一个节点，因为后面需要使用
			// 遍历原来的每一个节点，并将其放入到reversetlist的最前端
			// 画个图 就明白为什么了
			cur.next = rev.next;
			rev.next =  cur; 
			cur = next; //head 后移
		}
		// 将head更换 reversetlist的head
		head.next = rev.next;
	}

	public HeroNode getHead() {
		return head;
	}

	/**
	 * 找到单链表倒数第K个节点的数据
	 * 
	 * @param head
	 * @return
	 */
	public HeroNode getReciprocalK(HeroNode head, int k) {
		int length = getLength(head);
		if (length == 0) {
			System.out.println("没有数据");
			return null;
		}
		int index = length + 1 - k;
		HeroNode temp = head; // 4 //1 ==> 3
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public int getLength(HeroNode head) {
		HeroNode temp = head;
		int length = 0;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
			length++;
		}

		return length;
	}

	public void delData(int no) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		if (temp.next == null) {
			System.out.println("没必要删除了，因为已经是空的了");
			return;
		}

		boolean flag = false;
		while (true) {
			if (temp.next.no == no) {
				flag = true;
				// 找到了
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next = temp.next.next;
		}
	}

	public void updateData(HeroNode heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head.next;
		boolean flag = false;
		if (temp == null) {
			System.out.println("链表是空的，无法完成修改");
			return;
		}
		// 遍历 找到对应的节点
		while (true) {
			if (temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 修改相应的数据
		if (flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		} else {
			System.out.println("没有这个数据 无法修改");
		}
	}

	public void addOrderBy(HeroNode heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp  代表 要插入节点的 前一个
		HeroNode temp = head;
		// 遍历
		boolean flag = true;

		while (true) {
			if (temp.next == null) {
				// 链表 没有数据
				break;
			}
			// 找到 插入的位置
			if (temp.next.no > heroNode.no) {
				// 就是这个位置
				break;
			}
			if (temp.next.no == heroNode.no) {
				// 已经有这个节点了
				System.out.println("已经有这个节点不能插入");
				flag = false;
				break;
			}
			// 没有找到 移动temp 在遍历
			temp = temp.next;
		}
		// 插入
		if (flag) {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}

	}

	// 添加节点到单向链表
	// 思路，当不考虑编号顺序时
	// 1. 找到当前链表的最后节点
	// 2. 将最后这个节点的next 指向 新的节点
	public void add(HeroNode heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		// 遍历链表
		while (true) {
			// 找到链表的最后
			if (temp.next == null) {
				break;
			}
			// 如果没有找到最后, 就将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 将最后这个节点的next 指向 新的节点
		temp.next = heroNode;
	}

	// 显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;

		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			}
			// 输出节点的信息
			System.out.println(temp);
			// 将temp后移， 一定小心
			temp = temp.next;
		}
	}

}

class HeroNode {
	public String name;
	public String nickName;
	public HeroNode next;
	public int no;

	public HeroNode(int no, String name, String nickName) {
		this.name = name;
		this.nickName = nickName;
		this.no = no;
	}

	@Override
	public String toString() {
		return "HeroNode [name=" + name + ", nickName=" + nickName + "]";
	}

	public HeroNode() {

	}

}