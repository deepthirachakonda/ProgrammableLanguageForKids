package turtle.common;

/**
 * A Point to represent Cartesian coordinates
 */
public class Point {
	private double x;
	private double y;

	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public String toString() {
		return "X: "+ x + " Y: "+y;
	}
}
