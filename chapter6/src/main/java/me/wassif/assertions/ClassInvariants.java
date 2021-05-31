package me.wassif.assertions;

class Rectangle {
	private int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getArea() {
		assert isValid() : "not a valid rectangle";
		return width * height;
	}

	private boolean isValid() {
		return width > 0 && height > 0;
	}
}

public class ClassInvariants {
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(-10, 120);
		rec.getArea();
	}
}
