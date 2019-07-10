package com.xxd.tree;

public class BinaryTreeDemo {
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		HeroNode root = new HeroNode(1, "及时雨宋江");
		HeroNode heroNode2 = new HeroNode(2, "智多星吴用");
		HeroNode heroNode3 = new HeroNode(3, "玉麒麟卢俊义");
		HeroNode heroNode4 = new HeroNode(4, "豹子头林冲");
		HeroNode heroNode5 = new HeroNode(5, "大刀关胜");
		root.setLeft(heroNode2);
		root.setRight(heroNode3);
		heroNode3.setRight(heroNode4);
		heroNode3.setLeft(heroNode5);
		binaryTree.setRoot(root);

		// System.out.println("前序遍历");
		// binaryTree.preOrder();

		// System.out.println("中序遍历");
		// binaryTree.infixOrder();

		// System.out.println("后序遍历");
		// binaryTree.postOrder();

		// 前序遍历
		System.out.println("前序遍历方式");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了, 信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到no = %d 的英雄", 5);
		}

		// 中序遍历
		System.out.println();
		System.out.println("中序遍历方式");
		resNode = binaryTree.infixOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了, 信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到no = %d 的英雄", 5);
		}

		// 后序遍历
		System.out.println();
		System.out.println("后序遍历方式");
		resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到了, 信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
		} else {
			System.out.printf("没有找到no = %d 的英雄", 5);
		}
	}
}

class BinaryTree {

	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	// 前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，遍历个锤子");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，遍历个锤子");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，遍历个锤子");
		}
	}

	// 前序遍历查找
	public HeroNode preOrderSearch(int no) {
		return root == null ? null : root.preOrderSearch(no);
	}

	// 中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		return root == null ? null : root.infixOrderSearch(no);
	}

	// 后序遍历查找
	public HeroNode postOrderSearch(int no) {
		return root == null ? null : root.postOrderSearch(no);
	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;

	// 编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);
		// 递归向左子树遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		// 递归向右子树遍历
		if (this.right != null) {
			this.right.preOrder();
		}

	}

	// 中序遍历
	public void infixOrder() {
		// 递归向左子树遍历
		if (this.left != null) {
			this.left.infixOrder();
		}

		// 输出父节点
		System.out.println(this);

		// 递归向右子树遍历
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后序遍历
	public void postOrder() {

		// 递归向左子树遍历
		if (this.left != null) {
			this.left.postOrder();
		}

		// 递归向右子树遍历
		if (this.right != null) {
			this.right.postOrder();
		}

		// 输出父节点
		System.out.println(this);

	}

	// 前序查找
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历");
		if (this.no == no) {
			return this;
		}

		// 递归查找左子树
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.preOrderSearch(no);
		}
		if (res != null) {
			return res;
		}

		// 递归查找右子树
		if (this.right != null) {
			res = this.right.preOrderSearch(no);
		}
		return res;
	}

	// 中序查找
	public HeroNode infixOrderSearch(int no) {
		// 递归查找左子树
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.infixOrderSearch(no);
		}
		if (res != null) {
			return res;
		}
		
		System.out.println("进入中序遍历");
		if (this.no == no) {
			return this;
		}

		// 递归查找右子树
		if (this.right != null) {
			res = this.right.infixOrderSearch(no);
		}
		return res;
	}

	// 后序查找
	public HeroNode postOrderSearch(int no) {
		// 递归查找左子树
		HeroNode res = null;
		if (this.left != null) {
			res = this.left.postOrderSearch(no);
			if (res != null) {
				return res;
			}
		}

		// 递归查找右子树
		if (this.right != null) {
			res = this.right.postOrderSearch(no);
			if (res != null) {
				return res;
			}
		}
		System.out.println("进入后序遍历");
		return this.no == no ? this : null;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

}