package com.xxd.hashtab;

import java.util.HashMap;

public class HashTabDemo {
	public static void main(String[] args) {

		// 创建哈希表
		HashTab hashTab = new HashTab(7);
		hashTab.add(new Emp(1, "xxd"));
		hashTab.add(new Emp(2, "wk"));
		hashTab.add(new Emp(3, "ys"));
		hashTab.add(new Emp(4, "zqq"));
		hashTab.add(new Emp(8, "xxd2"));
		hashTab.add(new Emp(15, "xxd3"));
		hashTab.list();
		System.out.println("------------------------");
		hashTab.del(3);
		hashTab.del(8);
		hashTab.list();
		
		hashTab.del(11);
		hashTab.list();
		
		/*Emp emp = hashTab.findById(3);
		if (emp == null) {
			System.out.println("在hash表中 并未有这个员工");
		} else {
			System.out.println(emp);
		}*/
	}
}

class HashTab {
	private int size;
	private EmpLinkedList[] empLinkedListArray;

	public HashTab(int size) {
		this.size = size;
		empLinkedListArray = new EmpLinkedList[size];
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}
	}

	public void add(Emp emp) {
		int empLinkedListNo = hashFun(emp.id);
		empLinkedListArray[empLinkedListNo].add(emp);
	}

	public Emp findById(int id) {
		int empLinkListNo = hashFun(id);
		return empLinkedListArray[empLinkListNo].findById(id);
	}

	public void del(int id) {
		Emp emp = findById(id);
		if (emp == null) {
			System.out.println("别删除了，没有这个玩意");
			return ;
		}
		int empLinkListNo = hashFun(id);
		empLinkedListArray[empLinkListNo].del(id);
	}

	public void list() {
		for (int i = 0; i < empLinkedListArray.length; i++) {
			empLinkedListArray[i].list(i);
		}
	}

	private int hashFun(int id) {
		return id % size;
	}

}

//创建EmpLinkedList ,表示链表
class EmpLinkedList {
	// 头指针 ，执行第一个 Emp
	private Emp head;

	public void del(int id) {
		if (head == null) {
			System.out.println("删除个锤子，哈希表示空的啊！！！");
			return;
		}
		Emp emp = findById(id);
		if (emp == null) {
			System.out.println("没有这个ID,删除个锤子");
			return;
		}

		// 待删除节点的前一个节点
		Emp cur = head;
		if(cur.id == id) {
			head = null;
			return ;
		}
		while (true) {
			if ( cur.next.id == id) {
				break;
			}
			cur = cur.next;
		}

		// 删除操作
		cur.next = cur.next.next;
	}

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}

		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				break;
			}
			curEmp = curEmp.next;
		}

		curEmp.next = emp;
	}

	// 遍历链表的雇员信息
	public void list(int no) {
		if (head == null) {
			System.out.println("第 " + (no + 1) + " 链表为空");
			return;
		}
		System.out.print("第 " + (no + 1) + " 链表的信息为");
		Emp curEmp = head;
		while (true) {
			System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
			if (curEmp.next == null) {// 说明curEmp已经是最后结点
				break;
			}
			curEmp = curEmp.next; // 后移，遍历
		}
		System.out.println();
	}

	public Emp findById(int id) {
		if (head == null) {
			System.out.println("找个锤子，哈希表是空的！！");
			return null;
		}
		Emp emp = head;
		while (true) {
			if (emp.id == id) {
				break;
			}
			if (emp.next == null) {
				emp = null;
				break;
			}
			emp = emp.next;
		}

		return emp;
	}

}

//表示一个雇员 
class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}

}
