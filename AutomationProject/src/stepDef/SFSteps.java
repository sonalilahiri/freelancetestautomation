package stepDef;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import util.sharedData;
import util.general.tools;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SFSteps
{
	@Then("^the user extracts \"(.*?)\" from \"(.*?)\"\\.$")
	public void the_user_extracts_from(String fieldName, String browserInstance) throws Throwable 
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		String emailField = tools.getElement(fieldName, browser).getText();
		sharedData.tempVariable = emailField;
		System.out.println("emailField : " + emailField);
	}

	/* Start - Implemented by SL */
	@Then("^the user retrieves \"(.*?)\" in \"(.*?)\" from \"(.*?)\"\\.$")
	public void the_user_retrieves_in_from(String value, String fieldName, String browserInstance) throws Throwable 
	{
		WebDriver browser = null;
		String extract = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		String emailField = tools.getElement(fieldName, browser).getText();
		String subString = emailField.substring(emailField.indexOf("Verification Code: "), emailField.indexOf("If you didn't"));
		  if(subString != null && !subString.isEmpty()) {
			  String[] splittedText = subString.split(":");
			  if(splittedText.length > 1) {
				  extract = splittedText[1];
				  if(null != extract && !extract.isEmpty()) {
					  extract = extract.trim();
				  	}
			  }
		  }
		sharedData.tempVariable = extract;
		System.out.println("emailField : " + emailField);
		System.out.println("extract : " + extract);
				
	}
	/* End Implemented by SL */
	
	@Then("^the user clicks on \"(.*?)\" from \"(.*?)\" checkbox\\.$")
	public void the_user_clicks_on_from_checkbox(String fieldName, String browserInstance) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		tools.getElement(fieldName, browser).click();

	}
	
	
	@Then("^user enters \"(.*?)\" from \"(.*?)\" in \"(.*?)\"\\.$")
	public void user_enters_from_in(String key, String dataType,String browserInstance) throws Throwable {
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		System.out.println("sharedData.tempVariable : " + sharedData.tempVariable);
		if (dataType.length()>0) 
			tools.getElement( key, browser ).sendKeys(sharedData.tempVariable);	
	}
	
	@Then("^the user enters \"(.*?)\" in \"(.*?)\"\\.$")
	public void the_user_enters_in(String key, String browserInstance) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		util.general.tools.getElement(key,browser).clear();	
		util.general.tools.getElement(key,browser).sendKeys(util.general.ExcelUtility.getValue(sharedData.envConfigurationSheetInstance, key ,sharedData.autPosition));
	}
	
	
	@Then("^the user clicks on \"(.*?)\" Button in \"(.*?)\"\\.$")
	public void the_user_clicks_on_Button_in(String key, String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try
		{
		util.general.tools.getElement(key,browser).click();	
		}catch(Exception e){
			//e.printStackTrace();
		}
	}

/* Start - Implemented by SL */
	@Given("^the user only hovers on \"(.*?)\" to go to \"(.*?)\" in \"(.*?)\"\\.$")
	public void the_user_hovers_on_to_go_to_in_browser(String hoverItem, String linkName , String browserInstance) throws Throwable {
		
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;
		try {
			//new Actions( sharedData.appInstance ).moveToElement( util.general.tools.getElement(hoverItem, browser)).perform();
		
			//WebElement elem = browser.findElement(By.xpath("//img[contains(@src,'https://c.na78.content.force.com/profilephoto/005/T/1')]"));
			WebElement elem = util.general.tools.getElement(hoverItem, browser);
			((org.openqa.selenium.JavascriptExecutor) browser).executeScript("arguments[0].click();", elem);
			Thread.sleep(5000);

			Actions thisaction = new Actions(browser);
			WebElement lnk = browser.findElement(By.linkText(linkName));
			thisaction.moveToElement(lnk).click().build().perform();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}	
	}

	@Given("^the user does mouseover on \"(.*?)\" and switch frame  and click \"(.*?)\" in \"(.*?)\"\\.$")
	public void the_user_does_mouseover_on_to_go_to_in_browser(String hoverItem, String key ,String browserInstance) throws Throwable {
		
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;
		try {
			
			Actions thisaction = new Actions(browser);
			WebElement elem = util.general.tools.getElement(hoverItem, browser);
			// This does the mouse over
			thisaction.moveToElement(elem);
			
			// Now switch to the frame
			
			util.general.tools.switchFrame(browser);
			WebElement thiselem = util.general.tools.getElement(key, browser);
			((org.openqa.selenium.JavascriptExecutor) browser).executeScript("arguments[0].click();", thiselem);
			Thread.sleep(5000);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}	
	}

	
	@Then("^the user selects \"(.*?)\" value from \"(.*?)\" drop down in \"(.*?)\"\\.$")
	public void the_user_selects_value_from_drop_down_in(String dropDownValue, String dropDownKey, String browserInstance) throws Throwable {
		
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try{
			System.out.println("Trying to select  :" + dropDownValue);
			Select sl = new Select (util.general.tools.getElement(dropDownKey, browser));
			System.out.println("I have selected :" + sl.toString());
			
			sl.selectByVisibleText( dropDownValue );
		}catch (Exception e){
			//e.printStackTrace();
		}
	}
	
	@Then("^the user hovers on \"(.*?)\"\\.$")
	public void the_user_hovers_on_to_go_to(String hoverItem ) throws Throwable {
		
		try {
			new Actions( sharedData.appInstance ).moveToElement( util.general.tools.getElement(hoverItem)).perform();
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}
	
	
	@Then("^the user switches to frame and clicks on \"(.*?)\" Button in \"(.*?)\"\\.$")
	public void the_user_switches_and_clicks_on_Button_in(String key, String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try
		{
		util.general.tools.switchDynamicAndGetElement(key,browser).click();	
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	@Then("^the user does \"(.*?)\" frame switch and clicks on \"(.*?)\" Button in \"(.*?)\"\\.$")
	public void the_user_does_frame_switch_and_clicks_on_Button_in(String frameKey, String key, String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try
		{
		util.general.tools.switchDynamicAndGetElement(frameKey, key,browser).click();	
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	@Then("^the user switch to frame in \"(.*?)\"\\.$")
	public void the_user_to_frame_in(String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try
		{
		
		util.general.tools.switchFrame(browser);	
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	@Then("^the user close \"(.*?)\"\\.$")
	public void the_user_close(String browserInstance ) throws Throwable
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try
		{
		
		util.general.tools.close(browser);	
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
/* End - Implemented by SL */	
	@Then("^the user clicks on \"(.*?)\" link in \"(.*?)\"\\.$")
	public void the_user_clicks_on_link_in(String key, String browserInstance) throws Throwable 
	{
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		try {
			browser.findElement(By.linkText(key)).click();
		} catch (Exception e) {
			tools.getElement(key, browser).click();
		}
	}
	
	/* Start - Implemented by SL */
	@Then("^the user clicks on \"(.*?)\" link by searching \"(.*?)\"\\.$")
	public void the_user_clicks_on_link_by_searching(String linkName, String browserInstance) throws Throwable {
		List<WebElement> element = new ArrayList<WebElement>();
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		element = browser.findElements(By.className("td2"));
		for (int i = 0; i < element.size();i++)
		{
			System.out.println(i + " : " + element.get(i).getText());
			//			if (element.get(i).getText().toLowerCase().contains("Verify your account"))

			if (element.get(i).getText().toLowerCase().contains("noreply@salesforce.com"))
			{
				element.get(i).click();
			}
		}
	}
	
	
	/* End implemented by SL */
	
	
	/* Start Implemented by SL */

	 

	@Then("^the user clicks on \"(.*?)\" in alert in \"(.*?)\"\\.$")
	public void the_user_clicks_in_alert(String alertButton, String browserInstance) throws Throwable 

	            {

	                        WebDriver browser = null;

	                        if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 

	                                    browser = sharedData.appInstance2;

	                        if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 

	                                    browser = sharedData.appInstance1;

	                        if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
	 browser = sharedData.appInstance3;

	            

	                        if (alertButton.trim().equalsIgnoreCase("OK")) 

	                        {

	                           browser.switchTo().alert().accept();

	                        }

	                        

	                        if (alertButton.trim().equalsIgnoreCase("CANCEL")) 

	                        {

	                           browser.switchTo().alert().dismiss();

	                        }
	  }

	/* End Implemented by SL */   
	
	
	@Then("^the user clicks on \"(.*?)\" link by searching for \"(.*?)\"\\.$")
	public void the_user_clicks_on_link_by_searching_for(String linkName, String browserInstance) throws Throwable {
		List<WebElement> element = new ArrayList<WebElement>();
		WebDriver browser = null;
		if (browserInstance.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (browserInstance.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (browserInstance.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;

		element = browser.findElements(By.className("td2"));
		for (int i = 0; i < element.size();i++)
		{
			System.out.println(i + " : " + element.get(i).getText());
			//			if (element.get(i).getText().toLowerCase().contains("Verify your account"))

			if (element.get(i).getText().toLowerCase().contains("developer@salesforce.com"))
			{
				element.get(i).click();
			}
		}
	}
	
	@Then("^the user switches from \"(.*?)\" to \"(.*?)\"\\.$")
	public void the_user_switches_from_to(String firstBrowser, String secondBrowser) throws Throwable
	{
		WebDriver browser = null;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;
		
		Set handles = browser.getWindowHandles();		 
        System.out.println(handles);
         for (String handle1 : browser.getWindowHandles()) 
         {
        	System.out.println(handle1);
        	browser.switchTo().window(handle1);
        	if (browser.getTitle().contains("Change Your Password")) {
        		sharedData.appInstance3 = browser;
				break;
			}

         }
	
	}

	@Then("^the user switches with text \"(.*?)\" from \"(.*?)\" to \"(.*?)\"\\.$")
	public void the_user_switches_with_text_from_to( String windowTitle, String firstBrowser, String secondBrowser) throws Throwable
	{
		WebDriver browser = null;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 2")) 
			browser = sharedData.appInstance2;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 1")) 
			browser = sharedData.appInstance1;
		if (firstBrowser.trim().equalsIgnoreCase("Browser 3")) 
			browser = sharedData.appInstance3;
		
		Set handles = browser.getWindowHandles();		 
        System.out.println(handles);
         for (String handle1 : browser.getWindowHandles()) 
         {
        	System.out.println(handle1);
        	browser.switchTo().window(handle1);
        	if (browser.getTitle().contains(windowTitle)) {
        		sharedData.appInstance3 = browser;
				break;
			}

         }
	
	}
	
}
