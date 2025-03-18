package jenkins.Sample.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
public String getDatafromPropertiesFile(String Key) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
	Properties Pobj = new Properties();
	Pobj.load(fis);
	String data = Pobj.getProperty(Key);
	return data;
}

}
