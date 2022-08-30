package mobilePageObjects.Onside.Attendee;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import apps.admin.adminPageObjects.*;
//import interaction.DriverManager;
//import interaction.pageObjects.TestPagesList;
import interaction.pageObjects.WebPage;



public class AttendeeMobileAppSettingsPageObjects extends WebPage {

	 protected final By BrandingProfileDropdown = By.xpath("//div[@data-test='rf-dropdown-trigger-brandingProfile']/input");
	 protected final By BrandingProfileDropdownOption = By.xpath("//ul[@id='rf-select-results']//span[text()='RF Global Branding Profile']");
	 protected final By ManageBrandingProfileLink = By.xpath("//span[text()='Manage branding profile']");
	 protected final By InstructionsTab = By.xpath("//li[@id='instructions']");
	 protected final By ProfileDetailsTab = By.xpath("//li[@id='Profile Details']"); 
	 protected final By ProfileMetaDataTab = By.xpath("//li[@id='Profile Metadata']"); 
	 protected final By ProfileHeaderTab = By.xpath("//li[@id='Profile Header']"); 
	 protected final By ProfileFooterTab = By.xpath("//li[@id='Profile Footer']"); 
	 protected final By ProfileStylesTab = By.xpath("//li[@id='Profile Styles']"); 
	 protected final By AddContent = By.xpath("//span[text()='Add content']");
	 protected final By SelectContent = By.xpath("//input[@placeholder='Select content']");
	 protected final By ClickCatalogWidget = By.xpath("//input[@placeholder='Session catalog widget']");
	 protected final By SelectCatalogWidgetOption = By.xpath("//ul[@class='rf-select-results']//li[1]");
	 protected final By AddSessionImage = By.xpath("//span[text()='Add Image']");
	 protected final By ClickAttributeValueDropdown = By.xpath("//span[text()='Attribute Value']/parent::label/following-sibling::div[1]/div/input");
	 protected final By SelectAttributeValueDropdownOption = By.xpath("//ul[@id='rf-select-results']//li[@title='General Session']/span");
	 protected final By EnterValuesinImageUrl = By.xpath("//span[text()='Image Url']/parent::label/parent::div//input");
	 protected final By ClickExhibitorCatalogWidgetDropdown = By.xpath("//input[@placeholder='Exhibitor Catalog widget']");
	 protected final By SelectExhibitorCatalogWidgetOption = By.xpath("//ul[@id='rf-select-results']//li[2]");
	 protected final By ClickAddCustomPage = By.xpath("//span[text()='ADD CUSTOM PAGE']");
	 protected final By EnterDisplayName = By.xpath("//input[@placeholder='Display name in app navigation menu']");
	 protected final By EnterDisplayURL = By.xpath("//div[@id='key-customPageSettings-0']//div[2]/div[2]//input");
	 protected final By ClickUploadInSplashScreen = By.xpath("//span[text()='Logo (PNG only)']/parent::label/parent::div//following-sibling::div//span[text()='Upload']");
	 protected final By ClickUploadInHomePageSettings = By.xpath("//span[contains(text(),'Banner image')]/parent::label/following-sibling::div//div//span[text()='Upload']");
	 
	 
    //singleton constructor
    public static AttendeeMobileAppSettingsPageObjects getPage() {
        return initialize(AttendeeMobileAppSettingsPageObjects.class);
    }
    
    public void navigate() {
        navigateTo(getData("adminUrl") + "/rain.focus#mobileAppSettings.do");
    }

    
    public void selectBrandingProfile() {
    	click(BrandingProfileDropdown);
    	click(BrandingProfileDropdownOption);
    }
    
    public void clickManageBrandingProfileAndVerifyverifyBrandingProfileBuilderTabArePresent() throws InterruptedException {
    	click(ManageBrandingProfileLink);
    	String parent=getBrowser().getWindowHandle();
    	System.out.println("Parent Window ID: "+parent);
    	Set<String>s=getBrowser().getWindowHandles();
    	System.out.println(s.toString());
    	Iterator<String> I1= s.iterator();
    	while(I1.hasNext())
    	{
    	String child_window=I1.next();
    	if(!parent.equals(child_window))
    	{
    	getBrowser().switchTo().window(child_window);
    	Thread.sleep(7000);
    	System.out.println("Child Window Titele: "+getBrowser().switchTo().window(child_window).getTitle());
    	Thread.sleep(5000);
    	getBrowser().close();
    	}
    	}
    	//switch to the parent window
    	getBrowser().switchTo().window(parent);
    	}

    
    public void verifyIOSIconDimensionsArePresent() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement element = getBrowser().findElement(By.xpath("//h4[text()='iOS icon']/parent::div/div//table"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	 List<WebElement> FirstColumns = getBrowser().findElements(By.xpath("//h4[text()='iOS icon']/parent::div/div//following-sibling::div[@class='rf-table-container']/table//tr//td[1]"));
    	 //int count = FirstColumns.size();
    	 //System.out.println("Count: "+ count);
    	 ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("1024x1024 px","60x60 pt (180x180 px @3x)","60x60 pt (120x120 px @2x)","40x40 pt (120x120 px @3x)","40x40 pt (80x80 px @2x)","29x29 pt (87x87 px @3x)","29x29 pt (58x58 px @2x)","38x38 pt (114x114 px @3x)","38x38 pt (76x76 px @2x)"));
    	 ArrayList<String> list2 = new ArrayList<String>();
    	 for (WebElement s : FirstColumns) {
    		 list2.add(s.getText());
    		 //System.out.println(s.getText());
    	 }
    	 Assert.assertEquals(list1, list2);
    	 

    }
    
    public void verifyAndroidIconDimensionsArePresent() throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement element = getBrowser().findElement(By.xpath("//h4[text()='Android icon']/parent::div/div//table"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	 List<WebElement> FirstColumns = getBrowser().findElements(By.xpath("//h4[text()='Android icon']/parent::div/div//following-sibling::div[@class='rf-table-container']/table//tr//td[1]"));
    	 //int count = FirstColumns.size();
    	 //System.out.println("Count: "+ count);
    	 ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("512x512 px","192x192 px","144x144 px","96x96 px","72x72 px","48x48 px","36x36 px"));
    	 ArrayList<String> list2 = new ArrayList<String>();
    	 for (WebElement s : FirstColumns) {
    		 list2.add(s.getText());
    		 //System.out.println(s.getText());
    	 }
    	 Assert.assertEquals(list1, list2);
    }
    
    public void clickOnHomePageContentAndVerifyContentIsAdded() {
    	WebElement element = getBrowser().findElement(By.xpath("//span[text()='Add content']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(AddContent);
    	click(SelectContent);
    	List<WebElement> contentOptions = getBrowser().findElements(By.xpath("//ul[@class='rf-select-results']//li"));
    	for(int i = 0; i<=contentOptions.size()-1; i++) {
    		getBrowser().findElements(By.xpath("//ul[@class='rf-select-results']//li")).get(0).click();
    		click(AddContent);
        	click(SelectContent);
    	}
    	getBrowser().findElements(By.xpath("//span[@title='Cancel']")).get(0).click();
    }
    
    public void selectSessionCatalogWidget() {
    	WebElement element = getBrowser().findElement(By.xpath("//input[@placeholder='Session catalog widget']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickCatalogWidget);
    	click(SelectCatalogWidgetOption);
    }
    
    public void selectSessionTitleImage(String str) throws InterruptedException {
    	Thread.sleep(3000);
    	WebElement element = getBrowser().findElement(By.xpath("//span[text()='Add Image']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(AddSessionImage);
    	Thread.sleep(3000);
    	WebElement element1 = getBrowser().findElement(By.xpath("//span[text()='Attribute Value']/parent::label/following-sibling::div[1]/div/input"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element1);
    	click(ClickAttributeValueDropdown);
    	click(SelectAttributeValueDropdownOption);
    	sendKeys(EnterValuesinImageUrl, str);	
    }
    
    public void selectExhibitorSettings() {
    	WebElement element = getBrowser().findElement(By.xpath("//input[@placeholder='Exhibitor Catalog widget']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickExhibitorCatalogWidgetDropdown);
    	click(SelectExhibitorCatalogWidgetOption);
    }
    
    public void addCustomPage1(String str1, String str2) {
    	WebElement element = getBrowser().findElement(By.xpath("//input[@placeholder='Display name in app navigation menu']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	sendKeys(EnterDisplayName, str1);
    	sendKeys(EnterDisplayName, str2);
    }

	public void addCustomPage(String str1, String str2) {
		WebElement element = getBrowser().findElement(By.xpath("//span[text()='ADD CUSTOM PAGE']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickAddCustomPage);
    	sendKeys(EnterDisplayName, str1);
    	sendKeys(EnterDisplayURL, str2);	
	}
	
	public void verifySplashScreenBackGroudColorISDefault() {
		WebElement element = getBrowser().findElement(By.xpath("//input[@placeholder='Enter color']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
		String backGroundColorInUI = getBrowser().findElement(By.xpath("//input[@placeholder='Enter color']")).getAttribute("value");
		System.out.println("Default Color In UI is: "+backGroundColorInUI);
		String defaultColorInSplashScreen = "#000000";
		Assert.assertEquals(backGroundColorInUI, defaultColorInSplashScreen);
	}
	
	public void uploadJPGFileIsNotSupportedInSplashScreen() throws IOException {
		WebElement element = getBrowser().findElement(By.xpath("//span[text()='Logo (PNG only)']/parent::label/parent::div//following-sibling::div//span[text()='Upload']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickUploadInSplashScreen);
    	Runtime.getRuntime().exec("C:\\Users\\GobinathRathinam\\Documents\\AutoIT\\FileUploadJPG.exe"); 
		WebElement element1 = getBrowser().findElement(By.xpath("//span[text()='Logo (PNG only)']/parent::label/following-sibling::p"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element1);
    	String actualerrorMessageInUI = getBrowser().findElement(By.xpath("//span[text()='Logo (PNG only)']/parent::label/following-sibling::p")).getText();
    	String expectedErrorMessageInUI = "Invalid file type, valid extensions are: png";
    	Assert.assertEquals(actualerrorMessageInUI, expectedErrorMessageInUI);
	}
	
	public void uploadPNGFileInSplashScreen() throws IOException {
		WebElement element = getBrowser().findElement(By.xpath("//span[text()='Logo (PNG only)']/parent::label/parent::div//following-sibling::div//span[text()='Upload']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickUploadInSplashScreen);
    	Runtime.getRuntime().exec("C:\\Users\\GobinathRathinam\\Documents\\AutoIT\\FileUploadPNG.exe"); 	
	}
	
	public void uploadJPGFileInHomePageSettings() throws IOException {
		WebElement element = getBrowser().findElement(By.xpath("//span[contains(text(),'Banner image')]/parent::label/following-sibling::div//div//span[text()='Upload']"));
    	((JavascriptExecutor) getBrowser()).executeScript("arguments[0].scrollIntoView(true);", element);
    	click(ClickUploadInHomePageSettings);
    	Runtime.getRuntime().exec("C:\\Users\\GobinathRathinam\\Documents\\AutoIT\\FileUploadJPG.exe"); 	
	}

}
