package stack;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		//StackArray stackArray = new StackArray();
		
		//stackArray.push(1);
		//stackArray.push(2);
		//stackArray.push(3);
		//stackArray.push(4);
		//stackArray.push(5);
		//stackArray.push(6);
		
		//while (!stackArray.isEmpty()) {
		//	System.out.println(stackArray.pop());
		//}
		
		//StackLinkedList stackLinkedList = new StackLinkedList(7);
		//stackLinkedList.push(8);
		//stackLinkedList.push(9);
		//stackLinkedList.push(10);
		//stackLinkedList.push(11);
		//stackLinkedList.push(12);

		//while (!stackLinkedList.isEmpty()) {
		//	System.out.println(stackLinkedList.pop());
		//}
		
		//Stack<Integer> stack = new Stack<>();
		//stack.push(1);
		//stack.push(2);
		//stack.push(3);
		//stack.push(4);
		//stack.push(5);
		
		//while (!stack.empty()) {
		//	System.out.println(stack.pop());
		//}
		
		Stackeable<Integer> stackebale = new StackArray<>();
		
		stackebale.push(11);
		stackebale.push(12);
		stackebale.push(13);
		stackebale.push(14);
		stackebale.push(15);
		stackebale.push(16);
		
		while (!stackebale.isEmpty()) {
			System.out.println(stackebale.pop());
		}
	}

}
