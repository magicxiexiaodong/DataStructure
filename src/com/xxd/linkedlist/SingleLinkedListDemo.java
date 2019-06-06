package com.xxd.linkedlist;

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
		HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
		HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

		SingleLinkedList linkedList = new SingleLinkedList();
		/*
		 * linkedList.add(heroNode1); linkedList.add(heroNode2);
		 * linkedList.add(heroNode3); linkedList.add(heroNode4);
		 */
		linkedList.addOrderBy(heroNode1);
		linkedList.addOrderBy(heroNode4);
		linkedList.addOrderBy(heroNode3);
		linkedList.addOrderBy(heroNode2);
		linkedList.list();
		System.out.println("==================");
		//HeroNode newHero = new HeroNode(2, "卢俊俊", "玉麒麟~~~");
		//linkedList.updateData(newHero);
		linkedList.delData(2);
		linkedList.delData(3);
		linkedList.delData(1);
		linkedList.delData(4);
		System.out.println("删除后的链表~~~~~~~~~~~~");
		linkedList.list();

	}
}

class SingleLinkedList {
	// 头结点什么也不放
	private HeroNode head = new HeroNode(0, "", "");
	
	
	
	public void delData(int no) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		if(temp.next == null) {
			System.out.println("没必要删除了，因为已经是空的了");
			return  ; 
		}
		
		boolean flag = false;
		while(true) {
			if(temp.next.no == no) {
				flag = true;
				//找到了
				break;
			}
			temp = temp.next;
		}
		if(flag) {
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
			if(temp.no == heroNode.no) {
				flag = true;
				break;
			}
			temp  = temp.next;
		}
		// 修改相应的数据
		if(flag) {
			temp.name = heroNode.name;
			temp.nickName = heroNode.nickName;
		}else {
			System.out.println("没有这个数据 无法修改");
		}
	}

	public void addOrderBy(HeroNode heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
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