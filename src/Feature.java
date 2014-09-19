import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class Feature {
	public String name = "Name";
	public String slug = "name";
	public String type = "MultiPolygon";
	public List<FloatPoint> coordinates; 
	
	
	public Feature(){
		coordinates = new ArrayList<FloatPoint>();
		
	}

	public String toString(){
		return name + "\n" + slug + "\n" + type + "\n" + coordinates;
	}
	
	public void addCoordinate(float x, float y){
		FloatPoint fp = new FloatPoint(x, y);
		coordinates.add(fp);
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSlug() {
		return slug;
	}


	public void setSlug(String slug) {
		this.slug = slug;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
