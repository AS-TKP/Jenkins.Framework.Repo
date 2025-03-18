package jenkins.Sample.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable {
	FileReader fileR = new FileReader("./src/test/resources/jsoncommondata.json");
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(fileR);
	JSONObject map = (JSONObject) obj;
	System.out.println(map.get("url"));
	String data = (String)map.get(key); 
	
	return data;
}
}
