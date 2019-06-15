package com.xxd.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 38636
 *
 */
public class PolandNotation {
	
	private final static int ADD = 1;
	private final static int SUB = 1;
	private final static int MUL = 2;
	private final static int DIV = 2;
	
	public static void main(String[] args) {

		// 把中缀表达式 转换为 后缀表达式
		String expression = "1+((2+3)*4)-5";
		
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("中缀表达式对应的List=" + infixExpressionList);

		List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
		System.out.println("后缀表达式对应的List" + suffixExpreesionList); // ArrayList [1,2,3,+,4,*,+,5,–]
		
		System.out.println(calculate(suffixExpreesionList));
	}

	/**
	 *
	 * @param infixExpressionList
	 * @return
	 */
	private static List<String> parseSuffixExpreesionList(List<String> ls) {
		List<String> s2 = new ArrayList<>();
		Stack<String> s1 = new Stack<String>();
		// 遍历ls
		for (String item : ls) {
			if (item.matches("\\d+")) {
				s2.add(item);
			}else if ("(".equals(item)) {
				s1.push(item);
			}else if (")".equals(item)) {
				while (!"(".equals(s1.peek())) {
					s2.add(s1.pop());
				}
				s1.pop();
			} else if (s1.empty()) {
				s1.push(item);
			} else if(getValue(s1.peek()) < getValue(item)) { // 优先级大于
				s1.push(item);
			} else {// 当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
				while (true) {
					if (s1.isEmpty() ||  getValue(s1.peek()) < getValue(item) ) {
						s1.push(item);
						break;
					}
					s2.add(s1.pop());
				}
			}
		}
		// 全部扫描完毕 将 s1 中剩余的运算符依次弹出并压入 s2
		while (!s1.isEmpty()) {
			s2.add(s1.pop());
		}

		return s2;
	}
	/**
	 * 把表达式 放入数组
	 * 
	 * @param expression
	 * @return
	 */
	private static List<String> toInfixExpressionList(String expression) {
		// String expression = "1+((2+3)*4)-5";
		String cr = "";
		List<String> ls = new ArrayList<>();
		int index = 0;
		String keepNum = "";
		while (true) {
			cr = expression.substring(index, index + 1);
			if (isOper(cr)) { // 如果是操作符则直接加入
				ls.add(cr);
			} else {// 数字 还要在看下后面是否还是数字 主要是多位数的问题

				keepNum += cr;
				if (index == expression.length() - 1) { // 如果是最后一位数了 就不要往后判断了
					ls.add(keepNum);
					return ls;
				}
				cr = expression.substring(index + 1, index + 2);

				if (isOper(cr)) {
					ls.add(keepNum);
					keepNum = "";
				}
			}
			index++;
			if (index >= expression.length()) {
				break;
			}
		}
		return ls;
	}

	/**
	 * 从左至右扫描表达式，遇到数字时， 将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），并将结果入栈；
	 * 重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
	 * 
	 * @param list
	 * @return
	 */
	private static int calculate(List<String> list) {

		Stack<Integer> stack = new Stack<Integer>();
		for (String item : list) {
			if (item.matches("\\d+")) { // 匹配到的数
				stack.push(Integer.parseInt(item));
			} else {
				Integer num1 = stack.pop();
				Integer num2 = stack.pop();
				int res = 0;
				if ("+".equals(item)) {
					res = num1 + num2;
				} else if ("-".equals(item)) {
					res = num2 - num1;
				} else if ("*".equals(item)) {
					res = num1 * num2;
				} else if ("/".equals(item)) {
					res = num2 / num1;
				} else {
					throw new RuntimeException("运算符有误");
				}
				// 把res 入栈
				stack.push(res);
			}
		}
		return stack.pop();
	}

	public static boolean isOper(String c) {
		return "*".equals(c) || "/".equals(c) || "+".equals(c) || "-".equals(c) || "(".equals(c) || ")".equals(c);
	}

	// 写一个方法，返回对应的优先级数字
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("不存在该运算符" + operation);
			break;
		}
		return result;
	}
}