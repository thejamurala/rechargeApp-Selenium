/**
 * 
 */
package test.functional.com.recharge.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author thejaswimurala
 *
 */
public class RechargeAppUtils {
	
	/**
	 * Hold the control until web elements are found with element name
	 * @param driver
	 * @param name
	 */
	public static void waitOnFieldByName(WebDriver driver, String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		By  nameBy = By.name(name);
		ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(nameBy);
		wait.until(condition);
	}
	
	/**
	 * Hold the control until web elements are found with element id
	 * @param driver
	 * @param name
	 */
	public static void waitOnFieldById(WebDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		By  idBy = By.id(id);
		ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(idBy);
		wait.until(condition);
	}
	
	/**
	 * Hold the control until web elements are found with xPath
	 * @param driver
	 * @param xPath
	 */
	public static void waitOnFieldForXPath(WebDriver driver, String xPath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		By  xPathBy = By.xpath(xPath);
		ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(xPathBy);
		wait.until(condition);
	}
	
	/**
	 * Hold the control until web elements are found with element id
	 * @param driver
	 * @param name
	 */
	public static void waitOnFieldByClassName(WebDriver driver, String className) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		By  classBy = By.id(className);
		ExpectedCondition<WebElement> condition = ExpectedConditions.presenceOfElementLocated(classBy);
		wait.until(condition);
	}
	
	/**
	 * Hold the thread for desired milliseconds
	 * @param millis
	 */
	public static void sleepFor(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Thread is interrupted with exception: "+e);
		}
	}

}
