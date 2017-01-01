package application;

public class Coordinate
{
	private final double x;
	private final double y;
	
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Coordinate) {
        	Coordinate that = (Coordinate) other;
            result = (this.getX() == that.getX() && this.getY() == that.getY());
        }
        return result;
    }

    @Override
    public int hashCode() {
    	Double hashCode = new Double((41 * (41 + getX()) + (getY() * 3)));
        return  hashCode.intValue();
    }
}
