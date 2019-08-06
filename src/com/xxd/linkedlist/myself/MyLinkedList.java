package com.xxd.linkedlist.myself;

public class MyLinkedList {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.add(new HeroNode(1, "a", "aa"));
		list.add(new HeroNode(2, "b", "bb"));
		list.add(new HeroNode(3, "c", "cc"));
		list.add(new HeroNode(4, "d", "dd"));
		list.add(new HeroNode(5, "e", "ee"));
		
		list.list();
	}
	
}
class SingleLinkedList {
	private HeroNode first ;
	private HeroNode last ;
	

	public HeroNode getHead() {
		return first;
	}
	// 添加节点到单向链表
	// 思路，当不考虑编号顺序时
	// 1. 找到当前链表的最后节点
	// 2. 将最后这个节点的next 指向 新的节点
	public void add(HeroNode newNode) {
		final HeroNode l = last;
		last = newNode;
		
		if (l == null)
			first = newNode;
		else 
			l.next = newNode;
	}

	// 显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (first == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = first;

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