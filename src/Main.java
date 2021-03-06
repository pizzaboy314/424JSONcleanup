import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static List<Feature> list = new ArrayList<Feature>();

	public static void main(String[] args) {
		
		String test = "";
		
		try {
			test = readFile("everyblock-neighborhoods-chicago.json", StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String lines[] = test.split("\n");
		for(int i=0; i<lines.length; i++){
			if(lines[i].contains("name")){
				addFeature(lines[i].trim(), lines[i+1].trim(), lines[i+2].trim());
			}
		}
		
		writeFile("chimap.json", writeData());
	}
	
	public static String writeData(){
		StringBuilder s = new StringBuilder();
		int i = 0;
		
		s.append("{\"type\":\"FeatureCollection\",\"features\":[\n");
		for(Feature f : list){
			s.append("{\"type\":\"Feature\",\"id\":\"");
			i++;
			s.append(IDString(i));
			
			s.append("\",\"properties\":{\"name\":\"");
			s.append(f.getName());
			
			s.append("\"},\"geometry\":{\"type\":\"");
			s.append(f.getType());
			
			s.append("\",\"coordinates\":");
			
			s.append(f.getCoordinates() + "}}");
			if (i < list.size()) {
				s.append(",");
			}
			s.append("\n");
		}
		s.append("]}");
		
		return s.toString();
	}
	
	public static String IDString(int x){
		if(x < 10){
			return "0" + x;
		} else  {
			return "" + x;
		}
	}
	
	public static void addFeature(String name, String slug, String dims){
		Feature feat = new Feature();
		
		String fname = name.replaceAll("\"name\": \"|\",", "");
		String fslug = slug.replaceAll("\"slug\": \"|\",", "");
		
		String tmp[] = dims.split(":");

		String ftype = tmp[2].replaceAll("\",\"coordinates\"|\"", "");

		String coordinates = tmp[3].replace("}", "");

		feat.setName(fname);
		feat.setSlug(fslug);
		feat.setType(ftype);
		feat.setCoordinates(coordinates);
		list.add(feat);
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	public static void writeFile(String filename, String contents){
		File newjson = new File(filename);
		
		try {
			if(!newjson.exists()) {
			    newjson.createNewFile();
			} else {
				newjson.delete();
				newjson.createNewFile();
			}
			Files.write(Paths.get(filename), contents.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
