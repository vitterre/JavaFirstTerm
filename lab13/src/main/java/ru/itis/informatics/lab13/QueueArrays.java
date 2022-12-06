package ru.itis.informatics.lab13;

import java.util.ArrayList;
import java.util.List;

public final class QueueArrays<T> implements IQueue {

	/* ----- Fields ----- */

	final List<T> array = new ArrayList<>();


	/* ----- Overrides ----- */

	@Override
	public void add(final Object element) {
		this.array.add((T) element);
	}

	@Override
	public Object remove() {
		final T removable = this.array.get(0);
		this.array.remove(removable);
		return removable;
	}

	@Override
	public Object peek() {
		return this.array.get(0);
	}

	@Override
	public int size() {
		return this.array.size();
	}

	@Override
	public String toString() {
		return this.array.toString();
	}
}
