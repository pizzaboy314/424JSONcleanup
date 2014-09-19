import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class fix {
	List<Feature> list = new ArrayList<Feature>();

	public static void main(String[] args) {
		
		String test = "";
		
		try {
			test = readFile("testmap.json", StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String lines[] = test.split("\n");
		for(int i=0; i<lines.length; i++){
			if(lines[i].contains("name")){
				addFeature(lines[i].trim(), lines[i+1].trim(), lines[i+2].trim());
			}
		}
		
		
//		System.out.println(lines);

	}
	
	public static void addFeature(String name, String slug, String dims){
		Feature feat = new Feature();
		
		String fname = name.replaceAll("\"name\": \"|\",", "");
		String fslug = slug.replaceAll("\"slug\": \"|\",", "");
		
		
	}

	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
