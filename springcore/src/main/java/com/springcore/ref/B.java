package com.springcore.ref;

public class B {
	private int y;

	public B(int y) {
		super();
		this.y= y;
	}

	public B() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int gety() {
		return y;
	}

	public void sety(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "B [y=" + y + "]";
	}
		
}
