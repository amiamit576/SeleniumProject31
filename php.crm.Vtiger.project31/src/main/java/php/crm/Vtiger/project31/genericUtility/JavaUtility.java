package php.crm.Vtiger.project31.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

;

public class JavaUtility {
	public int generateRandomNumber(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
	}
	
	public String generateSystemDatetime() {
		return new Date().toString();
	}
	
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/ProjectData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
