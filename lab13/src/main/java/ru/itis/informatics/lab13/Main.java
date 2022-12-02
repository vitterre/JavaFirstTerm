package ru.itis.informatics.lab13;

// List (optimized)    -> 473042
// Default             -> 316875

public class Main {
	public static void main(String[] args) {
		IStack stack = new StackImplList();

		Long start = System.nanoTime();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		Long end = System.nanoTime();

		System.out.println(end - start);
	}
}