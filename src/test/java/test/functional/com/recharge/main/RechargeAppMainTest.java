package test.functional.com.recharge.main;

/**
 * Main class to start Selenium execution
 */
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;
import test.functional.com.recharge.PaymentDetailsPageTest;
import test.functional.com.recharge.RechargeConfirmationPageTest;
import test.functional.com.recharge.helper.Browser;
import test.functional.com.recharge.helper.BrowserImpl;
import test.functional.com.recharge.helper.CustomInputStreamReader;
import test.functional.com.recharge.helper.interfaces.IBrowser;
import test.functional.com.recharge.helper.interfaces.ICustomInputStreamReader;
import test.functional.com.recharge.LandingPageTest;
import test.functional.com.recharge.NotificationPopupWindowTest;
import test.functional.com.recharge.UserLoginPageTest;
import test.functional.com.recharge.utils.RechargeAPPConstants;
import test.functional.com.recharge.utils.RechargeAppUtils;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.function.Function;

public class RechargeAppMainTest {

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	@Test
	public void main() throws InterruptedException {

		//Stop the execution and read  user input to run the test in user specified browser
		ICustomInputStreamReader reader = new CustomInputStreamReader();
		IBrowser browser = new BrowserImpl();

		//Functional interface using reference 
		Function  <Void, String> fi =  reader::getUserInput;
		WebDriver driver = browser.getDriver(Browser.valueOf(fi.apply(null)));

		//Load application in the specified browser
		driver.get(RechargeAPPConstants.APP_URL);

		//Invoke RechargeDetailsPage to run tests
		LandingPageTest detailsPageTest = new LandingPageTest(driver);
		detailsPageTest.testRechargeDetailsPage();


		//Invoke AddNewCardDetails to run tests
		PaymentDetailsPageTest newCardTest = new PaymentDetailsPageTest(driver);
		newCardTest.testNewCardDetailsPage();

		//find pay button
		WebElement pay = driver.findElement(By.id("paylimit"));
		pay.click();

		//Invoke UserLoginPage to provide authentication details
		UserLoginPageTest loginPageTest = new UserLoginPageTest(driver);
		loginPageTest.testUserLoginPage();

		//Hit the login button, once credentials are provided
		WebElement button =  driver.findElement(By.name("loginbtn"));
		RechargeAppUtils.waitOnFieldByName(driver, "loginbtn");
		button.click();
	
		//Validate Recharge  confirmation page if exists (If the previous recharge has been made less than 5 minutes)
		RechargeConfirmationPageTest rechargeConfirmation = new RechargeConfirmationPageTest(driver);
		rechargeConfirmation.testRechargeConfirationPage();
		
		//Validate if POP exists then cancel
		NotificationPopupWindowTest popupWindow = new NotificationPopupWindowTest(driver);
		popupWindow.validatePopupExists();
		
		//Define an element to find successful response
		WebElement messageElement  =  driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/div[1]/div[1]/div[2]"));
		
		//Assertion to check the recharge is successful
		assertTrue("¡Recarga Exitosa!".equals(messageElement.getText()));

//		Close the driver after 5 seconds
		RechargeAppUtils.sleepFor(5000);
		driver.close();

	}


}
