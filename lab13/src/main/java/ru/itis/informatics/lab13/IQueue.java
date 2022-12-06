package ru.itis.informatics.lab13;

public interface IQueue<T> {
	void add(final T element);
	T remove();
	T peek();
	int size();
}
