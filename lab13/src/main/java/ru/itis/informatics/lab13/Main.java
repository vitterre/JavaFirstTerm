package ru.itis.informatics.lab13;

// ----- Optimizations checks ----- //
// QueueArrays ->  3050708
// QueueNodes  -> 23981416


public class Main {
	public static void main(String[] args) {

		final QueueNodes<Integer> queue = new QueueNodes<>();

		final Long start = System.nanoTime();

		for (int i = 0; i < 5000; ++i) {
			queue.add(i);
		}

		for (int i = 0; i < 5000; ++i) {
			queue.remove();
		}

		final Long end = System.nanoTime();

		System.out.println("Working time: " + (end - start));


		// All elements before operations
		System.out.println("Elements in queue then: " + queue);
		// Remove the first element
		System.out.println("Remove: " + queue.remove());
		// View the head element
		System.out.println("Head: " + queue.peek());
		// View the size of queue
		System.out.println("Size: " + queue.size());
		// All elements after operations
		System.out.println("Elements in queue now: " + queue);
	}
}