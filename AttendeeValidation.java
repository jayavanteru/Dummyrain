package mobileattendee;

import apps.PageConfiguration;
import apps.admin.adminPageObjects.AdminLoginPage;
import apps.admin.adminPageObjects.OrgEventData;
import apps.admin.adminPageObjects.registration.AdminAttendeeOnsiteTab;
import logs.ReportingInfo;
import mobilePageObjects.Onside.Attendee.AttendeeMobileAppSettingsPageObjects;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AttendeeValidation {

    @BeforeClass
    public void setUp(){
        AdminLoginPage.getPage().login();
        OrgEventData.getPage().setOrgAndEvent();
    }
	
    
    @Test
    public void navigateToAttendeeMobileAppSettings() throws InterruptedException, IOException {
    	AttendeeMobileAppSettingsPageObjects page = AttendeeMobileAppSettingsPageObjects.getPage();
    	AttendeeMobileAppSettingsPageObjects.getPage().navigate();
    	page.selectBrandingProfile();
    	page.clickManageBrandingProfileAndVerifyverifyBrandingProfileBuilderTabArePresent();
    	page.verifyIOSIconDimensionsArePresent();
    	page.verifyAndroidIconDimensionsArePresent();
    	page.clickOnHomePageContentAndVerifyContentIsAdded();
    	page.selectSessionCatalogWidget();
    	page.selectSessionTitleImage("Test url is entered");
    	page.selectExhibitorSettings();
    	page.addCustomPage("Google","www.google.com");
    	page.verifySplashScreenBackGroudColorISDefault();
    	page.uploadJPGFileIsNotSupportedInSplashScreen();
    	page.uploadPNGFileInSplashScreen();
    	page.uploadJPGFileInHomePageSettings();
    	
    }
    
    
    
    @AfterClass
    public void afterClass() {
        PageConfiguration.getPage().quit();
    }
    
    
	
}
