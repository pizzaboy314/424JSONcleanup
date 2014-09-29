

public class Feature {
	public String name = "Name";
	public String slug = "name";
	public String type = "MultiPolygon";
	public String coordinates = "";
	
	
	public Feature(){
		
	}

	public String toString(){
		return name + "\n" + slug + "\n" + type + "\n" + coordinates;
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

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

}
