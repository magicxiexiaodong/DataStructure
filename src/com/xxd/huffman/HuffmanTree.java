package com.xxd.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		preOrder(root);
	}

	public static Node createHuffmanTree(int[] arr) {
		List<Node> nodes = new ArrayList<Node>();

		for (int value : arr) {
			nodes.add(new Node(value));
		}
		
		while (nodes.size() > 1) {
			// sort all node
			Collections.sort(nodes);

			// 取出根节点权值最小的两颗二叉树
			Node leftNode = nodes.get(0);
			Node rigthNode = nodes.get(1);


			Node parent = new Node(leftNode.value + rigthNode.value);

			parent.left = leftNode;
			parent.right = rigthNode;
			
			nodes.remove(leftNode);
			nodes.remove(rigthNode);

			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		} else {
			System.out.println("为空！");
		}
	}
}

class Node implements Comparable<Node> {
	int value;
	Node left;
	Node right;

	// 前序遍历
	public void preOrder() {
		System.out.println(this);

		if (this.left != null) {
			this.left.preOrder();
		}

		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public Node(int value) {
		super();
		this.value = value;
	}

	public Node() {
		super();
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// 从小到大排
		return this.value - o.value;
	}
}