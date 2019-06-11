package com.xxd.linkedlist;

public class DoubleLinkedListDemo {
	public static void main(String[] args) {
				// 测试
				System.out.println("双向链表的测试");
				// 先创建节点
				HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
				HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
				HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
				HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
				// 创建一个双向链表
				DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
				doubleLinkedList.add(hero1);
				doubleLinkedList.add(hero2);
				doubleLinkedList.add(hero3);
				doubleLinkedList.add(hero4);
				
				doubleLinkedList.list();
				
				// 修改
				HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
				doubleLinkedList.update(newHeroNode);
				System.out.println("修改后的链表情况");
				doubleLinkedList.list();
				
				// 删除
				doubleLinkedList.del(3);
				System.out.println("删除后的链表情况~~");
				doubleLinkedList.list();
				
	}
}

//创建一个双向链表的类
class DoubleLinkedList {
	// 先初始化一个头节点, 头节点不要动, 不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	// 遍历双向链表的方法
	// 显示链表[遍历]
	// 显示链表[遍历]
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;

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
	// 添加一个节点到双向链表的最后.
	public void add(HeroNode2 heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode2 temp = head;
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
		heroNode.pre = temp;
	}
	
	// 修改一个节点的内容, 可以看到双向链表的节点内容修改和单向链表一样
	// 只是 节点类型改成 HeroNode2
	public void update(HeroNode2 heroNode) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode2 temp = head.next;
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
	
	// 从双向链表中删除一个节点,
		// 说明
		// 1 对于双向链表，我们可以直接找到要删除的这个节点
		// 2 找到后，自我删除即可
	public void del(int no) {
		// 因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode2 temp = head;
		if (temp.next == null) {
			System.out.println("没必要删除了，因为已经是空的了");
			return;
		}

		boolean flag = false;
		while (true) {
			if (temp.no == no) {
				flag = true;
				// 找到了
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.next.pre = temp.pre;
			// 这里我们的代码有问题?
			// 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
			if(temp.next != null) {
				temp.pre.next = temp.next  ;
			}
		}else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}
}

//定义HeroNode2 ， 每个HeroNode 对象就是一个节点
class HeroNode2 {
	public int no;
	public String name;
	public String nickName;
	public HeroNode2 next; // 指向下一个节点, 默认为null
	public HeroNode2 pre; // 指向前一个节点, 默认为null
	// 构造器

	public HeroNode2(int no, String name, String nickName) {
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	// 为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}

}