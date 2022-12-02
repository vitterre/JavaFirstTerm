package ru.itis.informatics.lab13;

public final class StackImpl implements IStack {

	/* ----- Fields ----- */

	private Object[] data;
	private int count;
	private int len = 10;


	/* ----- Constructors ----- */

	public StackImpl() {
		this.data = new Object[this.len];
	}

	/* ----- Overrides ----- */

	@Override
	public Object pop() {
		final Object tmp = this.data[this.count - 1];

		this.data[this.count - 1] = null;
		this.count--;

		return tmp;
	}

	@Override
	public void push(Object o) {
		if (this.count + 1 > this.len) {
			final Object[] tmp = new Object[this.len + (this.len / 2)];
			System.arraycopy(this.data, 0, tmp, 0, this.count);
			this.data = tmp;
		}

		this.data[this.count++] = o;
	}

}
