package jenkins.Sample.POM.OR.utility;
/**
 * @author AS
 * contains Login Page elements & business lib to login
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jenkins.Sample.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(name="user_name")
private WebElement usernameEdit;

@FindBy(name="user_password")
private WebElement passwordEdit;

@FindBy(id ="submitButton")
private WebElement loginButton;

public WebElement getUsernameEdit() {
	return usernameEdit;
}

public WebElement getPasswordEdit() {
	return passwordEdit;
}

public WebElement getLoginButton() {
	return loginButton;
}
/**
 * login to application based on URL arguments, USERNAME & PASSWORD
 * @param URL
 * @param USERNAME
 * @param PASSWORD
 */
/* create business lib to login */
public void loginToApp(String URL, String USERNAME, String PASSWORD) {
	waitForPageToLoad(driver); 
	driver.manage().window().maximize();
    driver.get(URL);
	usernameEdit.sendKeys(USERNAME);
	passwordEdit.sendKeys(PASSWORD);
	loginButton.click();

	
}
}
