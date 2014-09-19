public class FloatPoint {

	private static final long serialVersionUID = 1L;
	
	public float x;
	public float y;
	
	public FloatPoint(float x, float y){
		x = this.x;
		y = this.y;
	}
	
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	
	public String toString(){
		return x + ", " + y;
	}

}
