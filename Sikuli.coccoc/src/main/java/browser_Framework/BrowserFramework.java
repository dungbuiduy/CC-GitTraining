package browser_Framework;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class BrowserFramework  {
	/**
	 * This contructor is used to create a CommonController object ,which will
	 * make actions like a user on Website
	 * 
	 * @author loandtt
	 * @date 17-March-2015
	 * @Update: Huy: restructure
	 */
	public BrowserFramework() {

	}
	private static URL resource = null;
	private static String tr2 = null;
	private static String spath = null;
	public int timeoutOffer = 1;
	public static Screen s = new Screen();

	/*
	 * ________________________ SYSTEM SECTION_______________________________
	 */

	/**
	 * getResourceMAC: return image path
	 * 
	 * @author loandtt
	 * @param image image name
	 */
	public String getResourceMAC(String image) {
		resource = BrowserFramework.class.getProtectionDomain().getCodeSource().getLocation();
		tr2 = resource.toString().replace("file:", "").replace("target", "@");
		int l = tr2.indexOf("@");
		spath = tr2.substring(0, l).replace("@", "") + "src/main/resources/" + image;
		return spath;
		
		
	}
	
	/**
	 * getResource: Return absolute path to file (image, excel ... in resource folder
	 * @param resourceName  name of resource want to get absolute path
	 * 
	 * @author loandtt
	 * @updater: Huy.vu
	 * @date 21-Apr-2016
	 * 
	 */
	public String getResource(String resourceName) {
		resource = BrowserFramework.class.getProtectionDomain().getCodeSource().getLocation();

		tr2 = resource.toString().replace("file:/", "").replace("%20", " ").replace("/", "\\").replace("target", "@");
		int l = tr2.indexOf("@");
		spath = tr2.substring(0, l).replace("@", "") + "src\\main\\resources\\"+ resourceName;

		return spath;
	}

	/**
	 * executeFile: Execute the exe file
	 * 
	 * @author huy.vu
	 * @param path Path to exe file
	 */
	public void executeFile(String path) {
		TestLogger.info("-- Execute exe file: " + path);
		File file = new File(path);
		if (!file.exists()) {
			TestLogger.warn("The file " + path + " does not exist");
		} else {
			try {
				Runtime.getRuntime().exec(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * ________________________ SELENIUM SECTION_______________________________
	 */

	/**
	 * Open known link on Browser with know URL (TargetURL)
	 * 
	 * @author Huy.Vu
	 * @param driver which will open link on it .
	 * @param TargetURL link need to open
	 * @return a WebDriver object
	 */

	public WebDriver openWebWithLink(String TargetURL) {
		try {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			// --- Start with IE
			// System.setProperty("webdriver.ie.driver","C:\\ws\\IEDriverServer.exe");
			// WebDriver driver = new InternetExplorerDriver(capabilities);
			// --- Start with FireFox
			WebDriver driver = new FirefoxDriver();
			driver.get(TargetURL);

			TestLogger.info("Opened link: " + TargetURL);
			return driver;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Click on element is find by ID
	 * @author huy.vu
	 * @param driver FireFox driver
	 * @param ID of element
	 */
	public void clickElementByID(WebDriver driver, String controlID) {
		WebElement element;
		try {
			element = driver.findElement(By.id(controlID));
			element.click();
		} catch (Exception e) {
			TestLogger.info("Error: " + e);
			TestLogger.error("Cannot find control has ID: " + controlID + ". Please recheck");
		}
	}

	/**
	 * Click on element is find by Xpath
	 * 
	 * @author huy.vu
	 * @param driver FireFox driver
	 * @param xpath Expression
	 */
	public void clickElementByxPath(WebDriver driver, String XpathElement) {
		WebElement element;
		try {
			element = driver.findElement(By.xpath(XpathElement));
			element.click();
		} catch (Exception e) {
			TestLogger.info("Error: " + e);
			TestLogger.error("Cannot find control has Xpath: " + XpathElement + ". Please recheck");
		}
	}
	
	/**
	 * Wait for element by Xpath
	 * @param driver
	 * @param XpathElement
	 * @param timeoutInSecond
	 * @return true if element found
	 * @author Huy.Vu
	 */
	public Boolean waitForElementByxPath(WebDriver driver, String XpathElement, int timeoutInSecond) {
		boolean isElementExist = false;
		WebElement element;
		for (int i = 1; i < timeoutInSecond; i++) {
			try {
				element = driver.findElement(By.xpath(XpathElement));
				isElementExist = true;
				break;
			} catch (Exception e) {
				sleep(1);
			}
		}
		return isElementExist;
	}
	
	/*
	 * ________________________ SIKULI SECTION_______________________________
	 */

	/**
	 * clickOn: simulator click on Windows
	 * @author Huy
	 * @param image image name on resource
	 */
	public void clickOn(String image) {
		spath = getResource(image);
		try {
			s.click(spath);
			sleep(1);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * clickOnMac: simulator click on MAC OS
	 * 
	 * @author Huy
	 * @param image image name
	 */
	public void clickOnMac(String image) {
		spath = getResourceMAC(image);
		try {
			Match m = s.find(spath);
			s.click(m);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * waitForObjectPresent: wait time to execute command
	 * 
	 * @author Huy.vu
	 * @param image wait image, unit: second
	 */
public Boolean waitForObjectPresent(String image, int timeout) {
		
		TestLogger.info("Wait for control like " + image + " appears on about " + timeout );
		Boolean isControlExist = false;
		spath = getResource(image);
		File objectImage  = new File(spath);
		if(objectImage.exists()){
			try{
				for (int i = 1; i <= timeout * 2; i++) {
					try {
						s.wait(spath, 0.5);
						System.out.println(" Control appears! -> break wait for object");
						isControlExist = true;
						break;
					}
					catch (FindFailed e) {
						double time = timeout - (i*0.5);
						System.out.print( " . . "  + time );
						if (!e.toString().contains("can not find"))
							TestLogger.warn(e.toString());
					}
					finally{
						// sleep(0.5);
					}
				}
			}
			catch (Exception e) {
				TestLogger.warn(e.toString());
			}
			System.out.println(" Stop waiting control appears");
		}
		else
			TestLogger.warn("\n\nCannot find image at " + spath  + " on local machine, please check\n");
		return isControlExist;
	}
	
	/**
	 * Pause test script about time define by waiting time in second
	 * @param time in mili second
	 * @author Huy
	 * @update 03 Jun 2016
	 */
	public void waitForSystem(int time) {
		System.out.print("Sleeping about " + time + " miliseconds:");
		for(int i = 1; i<= time; i = i + 1000){
			sleep(1);
			System.out.print(".");
		}
		System.out.println("");
	}

	/**
	 * Wait for object disappears on screen
	 * @param image
	 * @param timeout
	 * @return true if object not found on screen
	 */
	public boolean waitforObjectNotexist(String image, int timeout) {
		TestLogger.info("Wait for control like " + image + " disappears");
		Boolean isControlExist = false;
		spath = getResource(image);
		TestLogger.info("Wait for control like " + image + " disappear on about " + timeout + " seconds: ");
		for (int i = 1; i <= timeout * 2; i++) {
			try {
				s.wait(spath, 1);
				double time = timeout - (i*0.5);
				System.out.print( " . . " + time);
				sleep(0.5);
			} catch (FindFailed e) {
				isControlExist = true;
				break;
			}
		}
		return isControlExist;
	}

	/**
	 * Wait for file download completed by FireFox
	 * 
	 * @author Huy
	 * @param fileName file want to wait
	 * @param timeout Time out
	 */
	public Boolean waitForDownloadFileCompleted(String fileName, int timeout){
		boolean localFlag = false;
		boolean flag = false;
		String fileNameInDownload = fileName + ".part";
		File fileWaitInDownload = new File(fileNameInDownload);
		File fileWait = new File(fileName);
		
		TestLogger.info("Wait for file " + fileName + " exist.....");
		//Sleep 5 seconds for make sure download start
		sleep(5);
		for (int i = 1; i <= timeout*2; i++){
			if(!fileWaitInDownload.exists()){
				// Algorithm: File download not exist -> download may done, but not sure file download -> solution: check file exist after download done 
				if(flag){
					localFlag = true;
					break;
				}
				else{
					TestLogger.info("The file download done, check file exist exist or not");
					flag = fileWait.exists();
					if(flag)
						TestLogger.info("\t -> file exist!");
					else{
						TestLogger.info("\t -> file not exist!, wait for more time...");
						sleep(1);
					}
				}
			}
			else{
				flag = false;
				System.out.print(".");
				sleep(0.5);
			}
		}
		System.out.println("");
		if(localFlag)
			TestLogger.info("  -> Download done");
		else
			TestLogger.info(" -> Cannot download CocCoc" );
			
		return flag;
	}

	/**
	 * Wait for object present on MAC with time out
	 * 
	 * @param image name of control's image
	 * @param timeout
	 * @return True if control found on screen
	 */
	public boolean waitForObjectPresentMAC(String image, int timeout) {
		boolean isControlExist = false;
		TestLogger.info("Wait for control :" + image);
		spath = getResourceMAC(image);
		for (int i = 1; i <= timeout * 2; i++) {
			try {
				s.wait(spath, 1);
				isControlExist = true;
				System.out.print(".");
				sleep(0.5);
				System.out.println("Control appears!!!!");
				break;
			} catch (FindFailed e) {
				System.out.print(".");
				sleep(0.5);
			}
		}
		System.out.println("");
		return isControlExist;
	}

	/**
	 * Double -click: use mouse to double click
	 * @author loandtt
	 * @param image image name
	 */
	public void doubleClick(String image) {
		spath = getResource(image);
		try {
			s.doubleClick(spath);
		} catch (FindFailed e) {
			TestLogger.error("The control " + image
					+ "Not exist, please check image");
		}
	}

	/**
	 * doubleClickMac: use mouse to double click
	 * 
	 * @author loandtt
	 * @param image image name
	 */
	public void doubleClickMac(String image) {
		spath = getResourceMAC(image);
		try {
			s.doubleClick(spath);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * rightlick: use mouse to right click
	 * 
	 * @author loandtt
	 * @param image image name
	 */
	public void rightClick(String image) {
		spath = getResource(image);
		try {
			s.rightClick(spath);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}

	/**
	 * rightClickMac: use mouse to right click
	 * 
	 * @author loandtt
	 * @param image
	 *            : image name
	 */
	public void rightClickMac(String image) {
		spath = getResourceMAC(image);
		try {
			s.rightClick(spath);
		} catch (FindFailed e) {
			TestLogger.warn("Cannot find control : " + image);
		}
	}
	
	/**
	 * Sleep
	 * @author Huy.Vu
	 * @param timeInSecond
	 */
	public void sleep(double timeInSecond) {
		try {
			Thread.sleep((long) (timeInSecond * 1000));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @author Huy.Vu
	 * @param image
	 * @param timeout
	 */
	public void waitforObjectDisappearMAC(String image, int timeout) {
		spath = getResourceMAC(image);
		TestLogger.info("Wait for control disappears: " + image);
		for (int i = 1; i <= timeout * 2; i++) {
			try {
				s.wait(spath);
				System.out.print(".");
				sleep(0.5);
			} catch (FindFailed e) {
				break;
			}
		}
	}

	/**
	 * hoverImage: hover mouse on media to view button Savior and download
	 * 
	 * @author loandtt
	 * @param image
	 *            : image name
	 */
	public void hoverImage(String image) {
		spath = getResource(image);
		try {
			s.hover(spath);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param height
	 * @author huy.vu
	 */
	public void resizePinWindows(int height) {
		try {
			waitForObjectPresent("pictures\\Browser_Savior_Text_MusicNameOnPIPwindow01.png", 5);
			Match sourceCoordinate;
			Match targetCoordinate = s.find(getResource("pictures\\Browser_Savior_Text_MusicNameOnPIPwindow01.png"));	
			sourceCoordinate = s.find(getResource("pictures\\Browser_Savior_Picture_PiPIconOnPinnedWindow.png"));
			sourceCoordinate.y = sourceCoordinate.y - 15;
			targetCoordinate.y = sourceCoordinate.y - height;
			
			TestLogger.debug(sourceCoordinate.x  + ", " + sourceCoordinate.y  + "// " + targetCoordinate.x +  ", " + targetCoordinate.y);
			sleep(1);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			double newHeightCoordinate = screenSize.getHeight();
			double newY = targetCoordinate.y;

			if (newHeightCoordinate >= newY){
				s.mouseMove(sourceCoordinate);
				TestLogger.debug("Prepare drag");
				sleep(1);
				TestLogger.debug("Drag");
				s.dragDrop(sourceCoordinate, targetCoordinate);
			}
			else
				TestLogger.warn("Cannot resize mouse to new size ");
		} catch (FindFailed e) {
			TestLogger.warn("ERROR: " + e.toString());
		}
	}
	
	/**
	 * close VLC player
	 * @author huy.vu
	 */
	
	public void closeVLCPlayer()
	{
		clickOn("pictures\\OSApp_VCL_Button_DownloadMedia.png");
		clickOn("pictures\\OSApp_VLC_Button_Quit.png");
	}


}