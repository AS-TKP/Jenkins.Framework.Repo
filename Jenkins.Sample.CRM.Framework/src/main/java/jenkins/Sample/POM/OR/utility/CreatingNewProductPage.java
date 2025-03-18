package jenkins.Sample.POM.OR.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewProductPage {
WebDriver driver;
public CreatingNewProductPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name="productname")
private WebElement productNameEdit;

@FindBy(name="sales_start_date")
private WebElement salesStartDateEdit;

@FindBy(name="productcategory")
private WebElement productCategoryDD;

@FindBy(name="sales_end_date")
private WebElement salesEndDateEdit;

@FindBy(name="manufacturer")
private WebElement manufacturerDD;

@FindBy(name="start_date")
private WebElement supportStartdateEdit;

@FindBy(name="expiry_date")
private WebElement supportExpiryDateEdit;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton ;
public WebElement getProductNameEdit() {
	return productNameEdit;
}

public WebElement getSalesStartDateEdit() {
	return salesStartDateEdit;
}

public WebElement getProductCategoryDD() {
	return productCategoryDD;
}

public WebElement getSalesEndDateEdit() {
	return salesEndDateEdit;
}

public WebElement getManufacturerDD() {
	return manufacturerDD;
}

public WebElement getSupportStartdateEdit() {
	return supportStartdateEdit;
}

public WebElement getSupportExpiryDateEdit() {
	return supportExpiryDateEdit;
}

public WebElement getSaveButton() {
	return saveButton;
}

//create new product using productname, salesstartdate, productcategory salesenddate, manufacturer, supportStartdate, supportexpirydate
public void createProduct(String ProductName, String SalesStartDateEdit, String ProductCategory, 
		String SalesEndDateEdit, String Manufacturer, String SupportStartDateEdit, String SupportExpiryDateEdit) {
	
	productNameEdit.sendKeys(ProductName);
	
	Select sel = new Select(productCategoryDD);
	sel.selectByVisibleText(ProductCategory);
	
	Select sel1 = new Select(manufacturerDD);
	sel1.selectByVisibleText(Manufacturer);
	
	//salesStartDateEdit.clear();
	salesStartDateEdit.sendKeys(SalesStartDateEdit);
	//salesEndDateEdit.clear();
	salesEndDateEdit.sendKeys(SalesEndDateEdit);
	//supportStartdateEdit.clear();
	supportStartdateEdit.sendKeys(SupportStartDateEdit);
	//supportExpiryDateEdit.clear();
	supportExpiryDateEdit.sendKeys(SupportExpiryDateEdit);
	saveButton.click();
}



}





























