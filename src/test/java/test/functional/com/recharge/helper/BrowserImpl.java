/**
 * Class is responsible to set driver properties and corresponding browser based upon the user selection.
 * User can launch any available browser to run the applicaiton automation
 */
package test.functional.com.recharge.helper;

import test.functional.com.recharge.helper.interfaces.IBrowser;

import static test.functional.com.recharge.utils.RechargeAPPConstants.CHROME_KEY;
import static test.functional.com.recharge.utils.RechargeAPPConstants.CHROME_PATH;
import static test.functional.com.recharge.utils.RechargeAPPConstants.EDGE_KEY;
import static test.functional.com.recharge.utils.RechargeAPPConstants.EDGE_PATH;
import static test.functional.com.recharge.utils.RechargeAPPConstants.FIREFOX_KEY;
import static test.functional.com.recharge.utils.RechargeAPPConstants.FIREFOX_PATH;
import static test.functional.com.recharge.utils.RechargeAPPConstants.IE_KEY;
import static test.functional.com.recharge.utils.RechargeAPPConstants.IE_PATH;
import static test.functional.com.recharge.utils.RechargeAPPConstants.SAFARI_KEY;
import static test.functional.com.recharge.utils.RechargeAPPConstants.SAFARI_PATH;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import test.functional.com.recharge.helper.interfaces.IBrowser;



/**
 * @author thejaswimurala
 *
 */
public class BrowserImpl implements IBrowser {
	WebDriver driver;

	@Override
	public WebDriver getDriver(Browser browser) {
		switch(browser) {
		case CHROME:
			System.setProperty(CHROME_KEY, CHROME_PATH);
		    driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
		    driver = new FirefoxDriver();
			break;
		case IE:
			System.setProperty(IE_KEY, IE_PATH);
		    driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			//Make sure to enable Develop -> Allow remote automation in Safari browser in order to use
			System.setProperty(SAFARI_KEY, SAFARI_PATH);
		    driver = new SafariDriver();
			break;
		case EDGE:
			System.setProperty(EDGE_KEY, EDGE_PATH);
		    driver = new EdgeDriver();
			break;
		default:
			System.setProperty(CHROME_KEY, CHROME_PATH);
		    driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		return driver;
	}

}
