package model;

public class Wind {
	private int power;
	private double x;
	private double y;
	
	public Wind(){
		setX(0);
		setY(0);
		setPower(0);
	}
	
	public Wind(double x, double y, int power){
		this.x = x;
		this.y = y;
		this.power = power;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
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
}
