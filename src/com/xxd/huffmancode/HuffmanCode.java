package com.xxd.huffmancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
	public static void main(String[] args) {
		String content = "i like like like java do you like a java";
		byte[] huffmanCodesBytes = huffmanZip(content);
		System.out.println("huffmanCodesBytes" + Arrays.toString(huffmanCodesBytes));
		
		/*
		byte[] contentBytes = content.getBytes();

		System.out.println(contentBytes.length); // 40
		System.out.println(Arrays.toString(contentBytes));

		List<Node> nodes = getNodes(contentBytes);
		System.out.println(nodes.size());

		Node node = createHuffmanTree(nodes);
		preOrder(node);

		getCodes(node);

		System.out.println(huffmanCodes);
		
		byte[] huffmanCodesBytes = zip(contentBytes,huffmanCodes);
		System.out.println("huffmanCodesBytes" + Arrays.toString(huffmanCodesBytes));*/
		
	}
	
	private static byte[] huffmanZip(String content){
		// 1 得到字符串的内容 字节码
		byte[] contentBytes = content.getBytes();
		
		// 2 将所有的字节码元素 转化为 一个个的 Node
		List<Node> nodes = getNodes(contentBytes);
		
		// 3 把这些节点 创建成一个hufffmanTree
		Node node = createHuffmanTree(nodes);
		
		// 4 node 节点 得到相应的huffman 编码  left = 0 right = 1
		Map<Byte, String> huffmanCodes = getCodes(node);
		
		// 5 把字符串 转化为 利用Huffman编码过的 字节码  并将其 压缩 为什么是 8 位数 因为这刚好是 2 ^ 8 = 128 刚好 是可以存入 byte
		//1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		byte[] huffmanCodesBytes = zip(contentBytes, huffmanCodes);
		
		return huffmanCodesBytes;
	}
	
	//编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码 压缩后的byte[]
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sb = new StringBuilder();
		
		for(byte b : bytes) {
			sb.append(huffmanCodes.get(b));
		}
		System.out.println(sb.toString());
		// 创建 存储压缩后的 byte 数组
		int len = (sb.toString().length() + 7) / 8 ;
		byte[] huffmanCodesBytes = new byte[len];
		String subString ;
		int index= 0 ;
		for(int i = 0; i < sb.length(); i += 8) {
			subString  = i + 8 > sb.length() ? sb.substring(i) : sb.substring(i, i+8);
			huffmanCodesBytes[index++] = (byte) Integer.parseInt(subString, 2);
		}
		return huffmanCodesBytes;
	}
	
	
	
	// 生成赫夫曼树对应的赫夫曼编码
	// 思路:
	// 1. 将赫夫曼编码表存放在 Map<Byte,String> 形式
	// 生成的赫夫曼编码表{32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101,
	// 121=11010, 106=0010, 107=1111, 108=000, 111=0011}
	public static Map<Byte, String> huffmanCodes = new HashMap<>();

	// 2. 在生成赫夫曼编码表示，需要去拼接路径, 定义一个StringBuilder 存储某个叶子结点的路径
	public static StringBuilder sb = new StringBuilder();

	// 为了调用方便，我们重载 getCodes
	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}
		// 处理root的左子树
		getCodes(root.left, "0", sb);
		// 处理root的右子树
		getCodes(root.right, "1", sb);
		return huffmanCodes;
	}
	
	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if (node != null) {
			if (node.data == null) {// 非叶子节点
				getCodes(node.left, "0", sb2);
				getCodes(node.right, "1", sb2);
			} else {
				huffmanCodes.put(node.data, sb2.toString());
			}
		}
	}

	public static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes = new ArrayList<>();
		Map<Byte, Integer> data2Count = new HashMap<>();

		for (byte data : bytes) {
			Integer count = data2Count.get(data);
			count = count == null ? 1 : count + 1;
			data2Count.put(data, count);
		}
		for (Map.Entry<Byte, Integer> entry : data2Count.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	// 可以通过List 创建对应的赫夫曼树
	public static Node createHuffmanTree(List<Node> nodes) {

		if (nodes == null || nodes.size() == 1) {
			return null;
		}
		while (nodes.size() > 1) {
			Collections.sort(nodes);

			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			nodes.remove(leftNode);
			nodes.remove(rightNode);

			Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
			parentNode.left = leftNode;
			parentNode.right = rightNode;

			nodes.add(parentNode);
		}
		return nodes.get(0);
	}

	public static void preOrder(Node root) {
		if (root == null) {
			System.out.println("霍夫曼树 为空");
		}
		root.preOrder();
	}
}

class Node implements Comparable<Node> {
	Byte data; // 存放数据
	int weight; // 权值
	Node left;
	Node right;

	public Node(Byte data, int weight) {

		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// 从小到大排序
		return this.weight - o.weight;
	}

	public String toString() {
		return "Node [data = " + data + " weight=" + weight + "]";
	}

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

}