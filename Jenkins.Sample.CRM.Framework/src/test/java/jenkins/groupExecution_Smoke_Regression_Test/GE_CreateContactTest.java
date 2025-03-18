package jenkins.groupExecution_Smoke_Regression_Test;

import org.testng.annotations.Test;

public class GE_CreateContactTest {
	@Test(groups = "SmokeTest")
	public void CreateContactTest() {
		String URL = System.getProperty("url");
	    String BROWSER = System.getProperty("browser");
	    String USERNAME = System.getProperty("username");
	    String PASSWORD = System.getProperty("password");
	    
	    System.out.println(URL);
	    System.out.println(BROWSER);
	    System.out.println(USERNAME);
	    System.out.println(PASSWORD);
	    
		System.out.println("Executed CreateContactTest");
	}
	@Test(groups = "SmokeTest")
	public void CreateContactWithDateTest() {
		System.out.println("Executed CreateContactWithDateTest");
	}
}
