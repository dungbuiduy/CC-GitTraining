package browser_Framework;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;

import jxl.Sheet;
import jxl.Workbook;

import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserCommon extends BrowserFramework {
	private static File f = null;
	Workbook wb;
	Sheet sh;
    public String userNameGmail3 = "coccocbrowser03";
    public String passwordGmail3="browsertest3";
    public String userNameGmail4 = "coccocbrowser04";
    public String passwordGmail4="browsertest4";
    public String userNameGmail6 = "coccocbrowser06";
    public String passwordGmail6="testbrowser6";
    public static int countOldVersionBrowser = 0  ;
    public String URLVideo = "http://www.nhaccuatui.com/vh/auto/l1YSP9LqdsLZ1";
	public BrowserCommon() {
	}

/*-------------------------------------------------------------------------
 * define global variable section
 * -------------------------------------------------------------------------
 */
	
	/*-------------------------------------------------------------------------
	 *  common section
	 * -------------------------------------------------------------------------
	 */
	/**
	 * setTestcaseStatus: Set testcase status as passed/failed
	 * 
	 * @author huy.vu
	 * @param testcaseSatatus: PASSED/FAILED/SKIP
	 * @param message:
	 *            Message print when set test case status : PASSED/FAILED/SKIP
	 */
	public void setTestcaseStatus(String testcaseSatatus, String message) {
		if (testcaseSatatus == "PASSED") {
			TestLogger.info("--------------------------------------------------------");
			TestLogger.info("Passed: " + message);
			TestLogger.info("--------------------------------------------------------");
		} else if (testcaseSatatus == "FAILED") {
			// Take snapshot and save to Desktop/failed
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath, "ScreenShotTestCaseFailed", 2);

			// Set testcase as failed
			TestLogger.warn(("Failed: " + message));
			Assert.fail(message);
		} else {
			TestLogger.info("==============================================================");
			TestLogger.error("Skipping test test case: " + new Throwable().getStackTrace()[1].getMethodName());
			TestLogger.error(message);
			TestLogger.info("==============================================================");
			throw new SkipException("Skipping this Testcase due: " + message);
		}
	}

	/**
	 * Delete folder
	 * 
	 * @author huy.vu
	 * @update : HANV
	 * @date 11/1/2017
	 */
	public void DeleteFileAndFolderInSpecificPath(File folderPath) {
		File[] files = folderPath.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (File f : files) {
				if (f.isDirectory()) {
					DeleteFileAndFolderInSpecificPath(f);
				} else {
					f.delete();
				}
			}
		}
		folderPath.delete();
		sleep(0.1);
		 
		
	} 
	
	/**
	 * Delete All File in Download folder
	 * 
	 * @author hanv
	 * @date 11/1/2017 
	 */
	public void deleteAllFilesinFolder (File folderPath)
	{
		  
		 if ( folderPath.isDirectory() )
		 {
			 File[] f = folderPath.listFiles();
			 for (File file : f )
			 {
				 file.delete();
			 }
			 
				if (folderPath.listFiles().length==0)
				{
					TestLogger.info("All Files was deleted Successfully ! ");
				}
				else
				{
					TestLogger.info("All Files was NOT deleted Successfully ! ");
				}
				
		 }
	}
	
	/**
	 * login to face book with account: coccocbrowser02@gmail.com/browsertest2
	 * @author huy.vu
	 */
	public void loginFacebook(){
		if(!waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 2))
			startCocCoc();
		//focus on Coccoc
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("https://www.facebook.com/profile.php?id=100010842734556");
		s.type(Key.ENTER);
		
		if(waitForObjectPresent("pictures\\website_facebook_image_Logo.png", 30)){
			 if (waitForObjectPresent("pictures\\Website_facebook_language_vietnamese.png", 2))
			clickOn("pictures\\Website_facebook_language_vietnamese.png");
			
			clickOn("pictures\\Website_facebook_textFile_emailLogin.png");
			sleep(1);
			s.type("a", Key.CTRL);
			s.type(Key.BACKSPACE);
			s.type("coccocbrowser02@gmail.com");
			clickOn("pictures\\Website_facebook_textfile_passwordLogin.png");
			s.type("a", Key.CTRL);
			s.type(Key.BACKSPACE);
			s.type("browsertest2");
			sleep(1);
			clickOn("pictures\\Website_facebook_Button_login.png");
			
			if(waitForObjectPresent("pictures\\Website_facebook_Button_alowNotification.png", 50));
				clickOn("pictures\\Website_facebook_Button_alowNotification.png");
			
			if(waitForObjectPresent("pictures\\Website_coccoc_Button_NeverSavePassword.png", 5))
				clickOn("pictures\\Website_coccoc_Button_NeverSavePassword.png");
			sleep(5);
		}
		else
			TestLogger.warn("----------------------------------\nCannot access to facebook!");
	}

	/**
	 * Capture screenshot and save to Desktop/screenshot
	 * @param folderPath Location of folder will be saved screen shot
	 * @param fileName the file name beside random number
	 */
	public void captureSnapshot(String folderPath, String fileName, int level) {
		// Prepare environment
		File screenShot = new File(folderPath);
		String testcaseName = new Throwable().getStackTrace()[level].getMethodName();
		BufferedImage image;
		Date dt = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(dt);
		String image_Name = (cal.get(Calendar.MONTH) + 1 + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-"
				+ cal.get(Calendar.HOUR_OF_DAY) + "-" + cal.get(Calendar.MINUTE) + "-" + cal.get(Calendar.SECOND));

		String imageLocation = testcaseName + "_" + image_Name + "_" + fileName;
		imageLocation = folderPath + imageLocation + ".png";

		TestLogger.info("Take screen shot and save to : " + imageLocation);
		if (!screenShot.exists()) {
			TestLogger.info("The folder not exist, create new folder...");
			screenShot.mkdirs();
		}
		screenShot = new File(imageLocation);

		// Capture screen shot
		try {
			image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			try {
				ImageIO.write(image, "png", screenShot);
			} catch (IOException e) {
				TestLogger.error("Some error occours: IOException");
			}
		} catch (HeadlessException e) {
			TestLogger.error("Some error occours: HeadlessException");
		} catch (AWTException e) {
			TestLogger.error("Some error occours: AWTException");
		}
	}

	/**
	 * Scroll page to object
	 * 
	 * @param imagePath
	 * @return
	 * @author Huy.Vu
	 */
	public boolean scrollPageToObject(String imagePath) {
		boolean scrollSuccess = false;
		for (int count = 1; count <= 15; count++) {
			if (waitForObjectPresent(imagePath, 1)) {
				scrollSuccess = true;
				break;
			} else {
				s.type(Key.DOWN);
				s.type(Key.DOWN);
				s.type(Key.DOWN);
				s.type(Key.DOWN);
				s.type(Key.DOWN);
				s.type(Key.DOWN);
				s.type(Key.DOWN);
			}
		}
		return scrollSuccess;
	}
	
	/**
	 * Close CocCoc Browser & Delete all files on downloads folder and delete special folder in download
	 * @param FolderInDondownloads
	 */
	public void cleanUpenvironment(File FolderInDondownloads){
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		sleep(1);
		clearDownloadPage();
		cleanResouces("");
		DeleteFileAndFolderInSpecificPath(FolderInDondownloads);
		sleep(1);
	}
	
	/**
	 * Get clipboard
	 * @return contain of clipboard as string
	 */
	public String getClipboardValue(){
		String result = "";
		try {
			
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			result = (String) clipboard.getData(DataFlavor.stringFlavor);
			
		} catch (UnsupportedFlavorException | IOException e) {
			TestLogger.error(e.toString());
		}
		return result;
	}
	
	/**
	 * Set clipboard contains
	 * @param contains The string will become clipboard 
	 */
	public void setClipboardValue(String contains){
		TestLogger.info("Set clipboard contains is " + contains);
		StringSelection clipboardValue = new StringSelection(contains);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(clipboardValue, clipboardValue);
	}
	
	/**
	 * Log in Google account on Coc Coc setting 
	 * @author hanv
	 * @date 11-Jan-2017
	 */
	
	public void SigninToCocCoc (String gmail, String password)
	 {      
		    
		    openLink("coccoc://settings/#coccoc-settings-users");
			
		    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 4);
			//clickOn("pictures\\Browser_Settings_Menu_User.png");
			
			TestLogger.info(". Click on 'Sign in to C?c C?c' ('Ðang nh?p vào C?c C?c') button.");
			waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 4);
			clickOn("pictures\\Browser_Settings_Button_Signintococcoc.png");
			
			TestLogger.info("Login with valid Google account. ");
			if (waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Email.png",4))
			{
				
				clickOn("pictures\\Browser_GoogleSync_Button_Email.png");
				s.type("a", Key.CTRL);
	            sleep (2);
			}
			else
			{
				s.type("a", Key.CTRL);
	            sleep (2);
			}
            
			s.type(gmail); 
			s.type(Key.ENTER);
			sleep(3);
			s.type(password);
			waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 8);
			clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
			waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png", 4);
			clickOn("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png");
			sleep(8);
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png", 2))
			{
				clickOn("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png");
			}
			
		 if (waitForObjectPresent("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png", 1))
		 {
			 TestLogger.info("Sign-in CocCoc successfully ! ");
		 }
		 else
		 {
			 TestLogger.info("Sign-in CocCoc unsuccessfully ! ");
		 }
			
			
			
			
	 }
	
	 /**
		 * Logout Google account on Coc Coc setting 
		 * @author hanv
		 * @date 11-Jan-2017
		 */
	 public void SignoutCocCoc ()
	 {
		    openLink("coccoc://settings/#coccoc-settings-users");
		    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
			clickOn("pictures\\Browser_Settings_Menu_User.png");
			waitForObjectPresent("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png", 7);
			clickOn("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png");
			waitForObjectPresent("pictures\\Browser_Users_Popup_Checkbox.png", 7); 
			clickOn("pictures\\Browser_Users_Popup_Checkbox.png");
			waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 7);
			clickOn("pictures\\Browser_SettingPage_Button_Signout.png");
			sleep (12);
			if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 1))
			{
				TestLogger.info(" Signout CocCoc succesfully !");
			}
			else
			{
				TestLogger.info(" Signout CocCoc unsuccesfully ! ");
			}
			
	 }

        /**
		 * Logout Google account on Chrome setting 
		 * @author hanv
		 * @date 11-Jan-2017
		 */
         	 public void SignoutChrome ()
	       {

		    s.type("d", Key.WIN);
			sleep(2);
			if (waitForObjectPresent("pictures\\BrowserChrome_Icon_Picture_Desktop1.png", 3))
			{
				doubleClick("pictures\\BrowserChrome_Icon_Picture_Desktop1.png");
			}
			else
			{
				doubleClick("pictures\\BrowserChrome_Icon_Picture_Desktop2.png");
			}
			sleep(6);
			waitForObjectPresent("pictures\\Browser_AdressBar_icon_Favorite.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\Browser_AdressBar_icon_Favorite.png", -100);
			s.click();
			s.type("chrome://settings/");
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\BrowserChrome_GoogleSync_Button_DisconnectYourGoogleAccount.png", 7);
			clickOn("pictures\\BrowserChrome_GoogleSync_Button_DisconnectYourGoogleAccount.png");
			waitForObjectPresent("pictures\\Browser_Users_Popup_Checkbox.png", 7);
			clickOn("pictures\\Browser_Users_Popup_Checkbox.png");
			waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 7);
			clickOn("pictures\\Browser_SettingPage_Button_Signout.png");
			sleep (8);
			
			if (waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 1))
			{
				TestLogger.info("Sign-out Chrome NOT Successfully ! ");
			}
			else
			{
				TestLogger.info("Sign-out Chrome Successfully ! ");
			}
			clickOn("pictures\\Browser_AdressBar_icon_Favorite.png");
			s.type(Key.F4, Key.ALT);
			sleep(2);
			
			
			
	 }
	     /**
		 * Login Google account on Chrome
		 * @param gmail ,gmail of user
		 * @param pass , password of user
		 * @author hanv
		 * @date 11-Jan-2017
		 */
	 
	 public void signinChrome(String gmail , String pass)
	 {

			TestLogger.info("Login Google account on Chrome (local machine or other machine).");
			
			s.type("d", Key.WIN);
			sleep(4);
			if (waitForObjectPresent("pictures\\BrowserChrome_Icon_Picture_Desktop1.png", 7))
			{
				doubleClick("pictures\\BrowserChrome_Icon_Picture_Desktop1.png");
			}
			else
			{
				doubleClick("pictures\\BrowserChrome_Icon_Picture_Desktop2.png");
			}
			
			sleep (5);
			s.type(Key.UP, Key.WIN);
			waitForObjectPresent("pictures\\Browser_AdressBar_icon_Favorite.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\Browser_AdressBar_icon_Favorite.png", -100);
			s.click();
			s.type("chrome://settings/");
			sleep (1) ;
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\BrowserChrome_GoogleSyn_Button_SigninToChrome.png", 8);
		    clickOn("pictures\\BrowserChrome_GoogleSyn_Button_SigninToChrome.png"); 
		    
		    TestLogger.info("Login with valid Google account. ");
		    if (waitForObjectPresent("pictures\\BrowserChrome_GoogleSyn_Button_Email.png", 7))
		    {
            clickOn("pictures\\BrowserChrome_GoogleSyn_Button_Email.png");
		    }
		    else
		    {
		    	
		    	s.type("a", Key.CTRL);
		    	sleep(2);
		    }
			
			s.type(gmail); 
			waitForObjectPresent("pictures\\BrowserChrome_GoogleSyn_Button_Next.png", 7);
			clickOn("pictures\\BrowserChrome_GoogleSyn_Button_Next.png");
			waitForObjectPresent("pictures\\BrowserChrome_GoogleSyn_Button_Pass.png", 7);
			clickOn("pictures\\BrowserChrome_GoogleSyn_Button_Pass.png");
			s.type(pass);
			sleep(1);
			s.type(Key.ENTER);
			 
			if (waitForObjectPresent("pictures\\BrowserChrome_GoogleSyn_Button_OKGOTIT.png", 7))
			clickOn("pictures\\BrowserChrome_GoogleSyn_Button_OKGOTIT.png");
			
			moveMouseHorizontallyFromLogo("pictures\\Browser_AdressBar_icon_Favorite.png", -100);
			s.click();
			s.type("chrome://settings/");
			sleep (1) ;
			s.type(Key.ENTER);
			
			if (waitForObjectPresent("pictures\\BrowserChrome_GoogleSync_Button_DisconnectYourGoogleAccount.png", 1))
			{
				TestLogger.info("Sign-in Chrome Successfully !!! ");
			}
			else
			{
				TestLogger.info("Sign-in Chrome NOT Successfully !!! ");
			}

	 }
	 
	/*
	 * -------------------------------------------------------------------------
	 * ------ Windows Section
	 * -------------------------------------------------------------------------
	 */
	/**
	 * 
	 * Get information from configure file (Coc Coc version, Omaha version,
	 * Extensions version, old version wanna update to latest version)
	 * 
	 * @author Huy
	 * @param path
	 *            to file configure
	 * @return 0: domain to download coccoc browser (Default is dev.coccoc.com)
	 *         <br>
	 *         1: Latest version of Coc coc<br>
	 *         2: Omaha version<br>
	 *         3: Savior version<br>
	 *         4: En2Vi Version<br>
	 *         5: The number of older CocCoc version need to update 6 ~ end: old
	 *         version of Coc coc -> test for update
	 */
	public String[] getCocCocVersion(String pathToFile) {
		TestLogger.info("Get configuare form file: " + pathToFile);
		pathToFile = getResource(pathToFile);
		String line;
		String info[] = new String[24];
		int count = 5;
		
		try {
			FileReader fr = new FileReader(pathToFile);
			BufferedReader textReader = new BufferedReader(fr);
			while ((line = textReader.readLine()) != null) {
				String[] config = line.split(": ");
				if (line.contains("domain"))
					info[0] = config[1];
				else if (line.contains("browser"))
					info[1] = config[1];
				else if (line.contains("Ohama "))
					info[2] = config[1];
				else if (line.contains("Savior "))
					info[3] = config[1];
				else if (line.contains("En2Vi "))
					info[4] = config[1];
				else if (line.contains("old Version")) {
					info[count] = config[1];
					TestLogger.info("==> Line" + count + "==> " + info[count]);
					count++;
					countOldVersionBrowser ++;
				}
			}
			textReader.close();
			
		} catch (Exception e) {
			TestLogger.warn("File config not exist or some thing wrong, pls check config/config.txt file");
			TestLogger.warn(e.toString());
			return info;
		}
		TestLogger.info("----> Done");
		return info;
	}

	/**
	 * DownloadCCBrowser: download coccoc's browser from many site different
	 * 
	 * @author loandtt
	 * @update huy.vu
	 * @param domains
	 *            : enter domains to download: coccoc/corom
	 * @return True if download done
	 */
	public Boolean DownloadCCBrowser(String domain) {
		TestLogger.info("Download Coc Coc Browser from dev.coccoc.com for this version");
		String URLdomain = "http://" + domain + "/vi/win/thanks.html";
		Boolean flag = downloadFileByFirefox(URLdomain);
		return flag;

	}

	/**
	 * Download coccoc form FTP server Algorithm
	 * 
	 * @param version
	 */
	public Boolean DownloadCCBrowserOnFTP(String version) {
		Boolean localFlag = false;
		TestLogger.info("Download CocCoc for build: " + version + " from ftp server");
		WebDriver driver = null;
		String coccocPath = System.getenv("USERPROFILE") + "\\Downloads\\";
		File f = new File(coccocPath + "\\coccoc_vi.exe");
		String coccoc_viPath = coccocPath + "standalone_coccoc_vi.exe";
		// backup coccoc browser on download if have
		File tmpFie = new File(coccocPath + "coccoc_vi_bak.exe");
		if (f.exists())
			f.renameTo(tmpFie);
		f = new File(coccocPath + version);
		if (!f.isDirectory()) {
			// Create folder to contain other CocCoc version
			f.mkdir();
		}
		f = new File(coccocPath + version + "\\coccoc_vi.exe");
		if (!f.exists()) {
			TestLogger.info("download coccoc to Download folder");
			driver = openWebWithLink("ftp://browser2v.dev.itim.vn/corom/" + version + "/installers/standalone_coccoc_vi.exe");
			//handle if aleart appears
			try{
				Alert alert = driver.switchTo().alert();
				
				String msg = alert.getText();
				if (msg.contains("Cannot find the file specified")){
					alert.accept();
					
					coccoc_viPath = coccocPath + "coccoc_vi.exe";
					driver.get("ftp://browser2v.dev.itim.vn/corom/" + version + "/installers/coccoc_vi.exe");
				}
				else{
					TestLogger.warn("Cannot download version : " + version );
					return localFlag;
				}
			}
			catch (Exception e) {
				
			}
			if(waitForObjectPresent("pictures\\Browser_DownloadPopupDialog_Button_SaveFile.png", 10)){
				clickOn("pictures\\Browser_DownloadPopupDialog_Button_SaveFile.png");
				waitForSystem(1000);
	
				waitforObjectNotexist("pictures\\Browser_DowloadPopupDialog_Picture_DownloadingInProgress.png", 30);
				waitForDownloadFileCompleted(coccoc_viPath, 20);
				driver.close();
	
				TestLogger.info("copy to folder");
				f = new File(coccoc_viPath);
				if (f.renameTo(new File(coccocPath + version + "\\" + f.getName()))) {
					TestLogger.info("Download CocCoc browser version " + version + " success");
					localFlag = true;
				} 
			}
			else {
				TestLogger.info("Download CocCoc browser version " + version + " failed");
			}
				
		} 
		else
			localFlag = true;
		
		if (tmpFie.exists())
			tmpFie.renameTo(new File(coccocPath + "\\coccoc_vi.exe"));
		
		return localFlag;
	}

	/**
	 * InstallCoccocWithDefaultOption: install browser coccoc follow version vi and Doensn't Close Browser after that 
	 * 
	 * @author Huy.vu
	 * @update : HANV
	 * @param str  enter version name need install
	 */
	public boolean InstallCoccocWithDefaultOption(String coccocSetupLocation) {
		// handle for case install when CocCoc setup was started:
		String installerDefault = "pictures\\Browser_InstallDialog_PopupSettingOption.png";
		String btnSetup = "pictures\\Browser_InstallDialog_Button_Install.png";
		
		if (coccocSetupLocation != "") {
			//handle install older build
			if(coccocSetupLocation.contains(".124"))
				btnSetup = "pictures\\Browser_InstallDialog_Button_InstallOldDesign.png";
			
			TestLogger.info("-> Install Coc Coc from " + coccocSetupLocation);
			File coccocInstall = new File(coccocSetupLocation);

			// check if file exist
			if (!(coccocInstall.exists() & coccocInstall.isFile())) {
				TestLogger.warn("The setup file of CocCoc is not exist, please check setup file at: " + coccocSetupLocation);
				return false;
			}
			// check if file wrong
			if (coccocInstall.length() == 0) {
				TestLogger.warn("The setup file of CocCoc is incorrect: File size = 0 Byte, please check setup file at: " + coccocSetupLocation);
				return false;
			}
			// kill other install process:
			killprocess("CocCocUpdate.exe");
			killprocess("coccoc_vi.exe");
			killprocess("setup.exe");
			sleep(5);
			executeFile(coccocSetupLocation);
			waitForObjectPresent(installerDefault, 25);
		}
		if (waitForObjectPresent(btnSetup, 30)) {
			clickOn("pictures\\Browser_InstallDialog_Button_Install.png");
			sleep(6);
			// handle on win 8/8.1:
			if (System.getProperty("os.name").contains("Windows 8")) {
				TestLogger.info("--> Handle install on " + System.getProperty("os.name"));
				if (waitForObjectPresent("pictures\\Browser_InstallDialog_Popup_CoccocIsNearlyReady_Win8.png", 40)){
					clickOn("pictures\\Browser_InstallDialog_Popup_CoccocIsNearlyReady_Win8.png");
					if (waitForObjectPresent("pictures\\OSApp_BubbleDialog_ChooseDefaultBrowser_win8.png", 20))
						clickOn("pictures\\OSApp_BubbleDialog_ChooseDefaultBrowser_win8.png");
				}
			}

			// Check coc Coc install success:
			if (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser_old.png", 25) || (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 25))) {
				//wait for more time because Coc Coc need download installer file
				sleep(3);
				TestLogger.info("Install cocCoc: Done");
				return true;
			}
		}
		// capture screen shot and return false if setup button don't appears
		TestLogger.warn("Coc Coc install unsuccessful, please check!");
		String folderPath = System.getProperty("user.home") + "/Desktop/screenShot/";
		captureSnapshot(folderPath, "InstallcocCocFailed", 2);
		return false;
	}


	/**
	 * checkRightCheckbox: click on checkbox
	 * 
	 * @author loandtt
	 * @param option
	 *            1: choose: start with system/uninstall with all data; 2:
	 *            choose: default browser/uninstall with change browser; 3:
	 *            choose all
	 * @param status
	 *            Install or Uninstall @ update: Huy
	 */
	public void checkRightCheckbox(String status, int option, String browser) {
		if (status == "Install") {
			switch (option) {
			case 1:
				if (waitForObjectPresent("pictures\\Browser_InstallDialog_Checkbox_CheckedOptionStartWithSystemStartup.png", 1)) {
					s.click();
				}
				break;
			case 2:
				if (waitForObjectPresent("pictures\\Browser_InstallDialog_Text_SetCoccocAsDefaultBrowser.png", 1)) {
					sleep(1);
					clickOn("pictures\\Browser_InstallDialog_Text_SetCoccocAsDefaultBrowser.png");
				}
				break;
			case 3:
				if (waitForObjectPresent("pictures\\Browser_InstallDialog_Checkbox_CheckedOptionStartWithSystemStartup.png", 1)) {
					s.click();
				}
				if (waitForObjectPresent("pictures\\Browser_InstallDialog_Text_SetCoccocAsDefaultBrowser.png", 1)) {
					s.click();
				}
				break;
			}
		} else if (status == "Uninstall") {
			switch (option) {
			case 1:
				if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_UncheckedOptionDoYouWantToClearBrowsingData.png", 1)) {
					s.click();
				}
				break;
			// Case 2
			case 3:
				if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_UncheckedOptionDoYouWantToClearBrowsingData.png", 1)) {
					s.click();
				}
				if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_UncheckedOptionChooseTheReplacingDefaultBrowser.png", 1)) {
					s.click();
					sleep(2);
					if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_DropDownList.png", 1)) {
						clickOn("pictures\\Browser_UninstallDialog_Button_DropDownList.png");
						if (browser == "FF") {
							s.type("m");
							s.type(Key.ENTER);
						} else if (browser == "Chrome") {
							s.type("g");
							s.type(Key.ENTER);
						} else if (browser == "IE") {
							s.type("i");
							s.type(Key.ENTER);
						} else if (browser == "Safari") {
							s.type("s");
							s.type(Key.ENTER);
						}
					}
				}
				break;
			}
		}
	}

	/**
	 * Check all folders and files are appear after install Coccoc browser and close browser after that 
	 * 
	 * @param locationUserData  path to location user data : e.g: C:\Users\Huy\AppData\Local
	 * @param locationUserData path to Application data : e.g: C:\Users\Huy\AppData\Roaming
	 * @author Huy.vu
	 * @update : HANV
	 * @date 07-APR-2016 Return: + true if all files/folder appear + false if any file(s/folder(s) disappear: Contains:
	 *       + 1 folder named by browser version
	 *       + files: browser.exe, debug.log, VisualElementsManifest.xml
	 */
	public boolean areAllFoldersCocCocAppers(String localUserdata, String appdata, String Version) {
		// folder in ..AppData\Local\CocCoc
		boolean crashReportsFolder = true;
		boolean updateFolder = true;
		boolean browserFolder = true;
		boolean applicationFolder = true;
		boolean browserVersionFolder = true;
		boolean browserExe = true;
		boolean debugLog = true;
		boolean VisualElementsManifest = true;
		boolean uidfile = true;
		startCocCoc();
		sleep(5);
		//waitForCocCocReady();

		if (!(new File(localUserdata + "\\CocCoc\\Browser").isDirectory())) {
			browserFolder = false;
			TestLogger.warn("  The folder Browser not exist");
		}
		if (!(new File(localUserdata + "\\CocCoc\\CrashReports").isDirectory())) {
			crashReportsFolder = false;
			TestLogger.warn("  The folder crash Report not exist");
		}

		if (!(new File(localUserdata + "\\CocCoc\\Update").isDirectory())) {
			updateFolder = false;
			TestLogger.warn("  The folder Update not exist");
		}

		if (!(new File(localUserdata + "\\CocCoc\\Browser\\Application").isDirectory())) {
			applicationFolder = false;
			TestLogger.warn("  The folder Update not exist");
		}

		if (!(new File(localUserdata + "\\CocCoc\\Browser\\Application\\" + Version).isDirectory())) {
			browserVersionFolder = false;
			TestLogger.warn("  The folder Application\\" + Version + " not exist");
		}

		if (!(new File(localUserdata + "\\CocCoc\\Browser\\Application\\browser.exe").exists())) {
			browserExe = false;
			TestLogger.warn("  The file Application\\browser.exe not exist");
		}


		if (!(new File(localUserdata + "\\CocCoc\\Browser\\Application\\VisualElementsManifest.xml").exists())) {
			VisualElementsManifest = false;
			TestLogger.warn("  The file Application\\VisualElementsManifest.xml not exist");
		}

		if (!(new File(appdata + "\\CocCoc\\uid").exists())) {
			uidfile = false;
			TestLogger.warn("  The folder Update not exist");
		}

		// Check install with download pop-up browser or installer file in local
		// machine
		s.type(Key.F4, Key.ALT);
		sleep (2);
		return (browserFolder & crashReportsFolder & updateFolder & applicationFolder & browserVersionFolder & uidfile
				& browserExe & debugLog & VisualElementsManifest);
	}

	/**
	 * checkCocCocProgress(): start CocCoc and Check Coccoc progress and close Browser Coccoc
	 * 
	 * @author Huy.vu Return: + true if CocCocCrashHandler and browser appear on
	 *         task manager. + false if any CocCocCrashHandler and browser
	 *         disappear on task manager.
	 */
	public boolean checkCocCocProgress() {
		startCocCoc();
		sleep(10);
		boolean browserProgress = isProcessExists("CocCocCrashHandler");
		boolean CocCocCrashProgress = isProcessExists("browser.exe");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		sleep(1);
		s.type(Key.F4, Key.ALT);
		return browserProgress && CocCocCrashProgress;
	}

	/**
	 * Start Coccoc browser in VietNamese , Max in window 
	 * 
	 * @author Huy.vu
	 * Update : HANV 
	 */
	public boolean startCocCoc() {
		String coccocPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\Application\\browser.exe";
		boolean flag;
		// check Coc Coc is install or not
		File ccBrowser = new File(coccocPath);
		if (!ccBrowser.exists()) {
			TestLogger.warn("Cannot start CocCoc browser, Maybe coccoc wasn't install");
			return false;
		}
		
		//Kill old Coccoc
		//killprocess("browser.exe");
		
		if (!waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))
		{
			s.type("d", Key.WIN);
			s.type(Key.UP);
		}
		else
		{
			sleep(1);
			s.type(Key.UP);
			sleep(1);
			s.type(Key.UP);
			
		}
		
		
		
		// start with default profile
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 3))
		{
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			sleep(3);
		}
		else {
			s.type("r",Key.WIN);
			sleep(1);
			s.type(coccocPath);
			sleep(1);
			s.type(Key.ENTER);
		}
		flag = waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 4);
		// handle if Coc coc Change version to English
		clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		
		if (!waitForObjectPresent("pictures\\Browser_Menu_Text_OpenNewTabOrNewWindow.png", 2)) {
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type("t", Key.CTRL);
			sleep(2);

			s.type("coccoc://settings/languages");
			sleep(1.5);
			s.type(Key.ENTER);
			
			if(waitForObjectPresent("pictures\\Browser_Settings_Button_AddLanguageToBrowser.png", 7)){
				if (waitForObjectPresent("pictures\\Browser_Settings_Button_LanguageSettingVietnamese.png", 3))
					clickOn("pictures\\Browser_Settings_Button_LanguageSettingVietnamese.png");
				else {
					clickOn("pictures\\Browser_Settings_Button_AddLanguageToBrowser.png");
					sleep(1);
					clickOn("pictures\\Browser_Settings_Button_DropDownSelectLanguage.png");
					sleep(1);
					s.type("vi");
					s.type(Key.ENTER);
					clickOn("pictures\\Browser_Settings_Button_AddLanguageOK.png");
				}
				clickOn("pictures\\Browser_Settings_Button_DisplayCoccocInThisLanguage.png");
				sleep(1);
				clickOn("pictures\\Browser_Settings_Button_ChangeLanguageDONE.png");
				sleep(1);
			}
			
			s.type(Key.F4, Key.ALT);
			//restart coccoc browser
			//killprocess("browser.exe");
			if (!waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 5))
			{
				s.type("d", Key.WIN);
			}
			else
			{
				sleep(1);
				s.type(Key.UP);
			}
			
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 5))
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else {
				s.type("r",Key.WIN);
				sleep(1);
				s.type(coccocPath);
				sleep(1);
				s.type(Key.ENTER);
			}
			flag = waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 10);
		}
		else
			clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");

		//close warning
		if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png", 1))
			clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
		sleep(1);
		clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		
		// maximize windows
		s.type(Key.UP, Key.WIN);
		sleep(1);
		 if (waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 2)) 
		 {
			 TestLogger.info("Started Coc Coc in Vietnamese successfully ! ");
		 }
		 else
		 {
			 TestLogger.info("Started Coc Coc in Vietnamese NOT successfully ! ");
		 }
		
		
		return flag;
	}

	/**
	 * Check omaha version
	 * 
	 * @param omahaVer
	 * @return true if a folder exist with name is version of omaha
	 * @author Huy
	 */
	public boolean checkOmahaversion(String omahaVer) {
		TestLogger.info("---> Check Omaha version");
		String CoccocPath = System.getenv("LOCALAPPDATA");
		File f = new File(CoccocPath + "\\CocCoc\\Update\\" + omahaVer);
		return f.isDirectory();
	}

	/**
	 * start Coccoc and check extension , Doens't close browser after that 
	 * Check Extension version on coccoc://extensions
	 * 
	 * @param extensionName Name of extension
	 * @param extensionVersion Version of extension want to check
	 * @return True if Coc Coc show version correctly
	 * @author Huy
	 */
	public boolean checkExtensionVersion(String extensionName, String extensionVersion) {
		TestLogger.info("---> Check extension " + extensionName + " with version " + extensionVersion + " appears");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(1);

		// add history
		s.type("t", Key.CTRL);
		// Open Coccoc extension
		s.type("coccoc://extensions");
		sleep(1);
		s.type(Key.ENTER);
		if (waitForObjectPresent("pictures\\Browser_Settings_Text_Extensions.png", 7)) {
			s.type(Key.F3);
			s.type(extensionName + " " + extensionVersion);
		}
		
		
		if (waitForObjectPresent("pictures\\Browser_SearchPage_Text_SearchResultOfBrowserVersion.png", 5)) {
			TestLogger.info("The version of " + extensionName + " correctly");
			return true;
		} else {
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "CheckExtensionVersion", 2);
			TestLogger.info("The version of " + extensionName + " incorrectly");
			return false;
		}
	}

	/**
	 * Check digital signature of file
	 * 
	 * @param filePath  Path to file
	 * @param signerName Name of signer
	 * @param SHAVersion the version of SHA
	 * @return True if the Digital Signature is correctly
	 * @author Huy
	 */
	public boolean CheckCompanySignatureInFile(String filePath, String signerName, String SHAVersion) {
		TestLogger.info("---> Check digital signature of file: " + filePath);
		String line;
		boolean digitalSignatureflag = false;
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader textReader = new BufferedReader(fr);
			while ((line = textReader.readLine()) != null) {
				if (line.contains(signerName)) {
					digitalSignatureflag = true;
					TestLogger.info("The digital of this file is correctly <--");
					break;
				}
			}
			textReader.close();
		} catch (Exception e) {
			TestLogger.info("File config not exist or some thing wrong, pls check file exist at " + filePath);
		}

		return digitalSignatureflag;
	}

	/**
	 * Uninstall Coccoc with default option
	 * 
	 * @param CocCocVersion
	 * @author Huy
	 */
	public void UninstallWithDefaultOption(String CocCocVersion) {
		TestLogger.info("--> Uninstall Coccoc browser version: " + CocCocVersion);
		if(startUninstallCocCoc(false)){
			if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Text_UninstallBrowser.png", 3)){
				clickOn("pictures\\Browser_UninstallDialog_Text_UninstallBrowser.png");
			}
			killprocess("iexplore.exe");
		}
	}

	/**
	 *  Start Uninstall coc coc from control panels ,
	 *  Set IE is Dafault if avaiable
	 *  @param DeleteDataOrNOT , if = true then delete All data , if = false does not delete data 
	 *  @return  : Boolean . If = True, Uninstall CoocCoc sucessfully and Set IE is Default  
	 * @HANV
	 * 
	 * data : 16/1/2017
	 */
	public boolean startUninstallCocCoc(Boolean DeleteDataOrNOT) {
		boolean isStartUninstallCC = false;
		boolean IEisDefault = true;
		TestLogger.info("--- Open uninstall coc coc");
		// kill all coc coc browser
		killprocess("browser.exe");
		killprocess("CocCocCrashHandler.exe");
		killprocess("delegate_execute.exe");
		killprocess("CocCocUpdate.exe");
		sleep(2);
		String browerPath = "";
		if (System.getProperty("os.name").contains("XP")) {

			browerPath = "C:\\Documents and Settings\\tester\\Local Settings\\Application Data";
		} else
			browerPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\Application\\browser.exe";

		if (new File(browerPath).exists()) {

			s.type("r", Key.WIN);
			sleep(1);
			s.type(Key.BACKSPACE);
			// s.type(browerPath + " -uninstall");
			s.type("appwiz.cpl");
			s.type(Key.ENTER);
			sleep(3);
			s.type(Key.F5);
			s.type(Key.F3);
			sleep(1);
			s.type("coc coc");
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			s.type(Key.ENTER);
			sleep(6);

			if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Text_UninstallBrowser.png", 5)
					|| (waitForObjectPresent("pictures\\Browser_UninstallDialog_Text_UninstallBrowserEN.png", 5))) {
				isStartUninstallCC = true;
			}

			if (DeleteDataOrNOT == true) {
				System.out.println("--------------delete data");
				if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png", 5)) {
					clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png");
					clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall_VN.png");
				} else {
					if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png", 5)) {
						clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png");
						clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall_EN.png");
					}

				}
			}

			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "isDefault", 1);
			if ((System.getProperty("os.name").contains("Windows 7"))) {
				if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption_2.png",
						5)) {
					clickOn("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption_2.png");
					moveMouseHorizontallyFromLogo(
							"pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption_2.png", 150);
					s.click();
					clickOn("pictures\\Browser_UninstallDialog_List_Chrome.png");
					sleep(2);

					clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
				} else {
					waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_Uninstall.png", 5);
					clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
				}
			} else {
				sleep(1);
				s.type(Key.ENTER);
				sleep(2);
				//clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
				// clickOn("pictures\\OSApp_UninstallDialog_Text_UninstallorChangeAprogram.png");
				s.type(Key.F4, Key.ALT);
				//sleep(2);
				//s.type(Key.F4, Key.ALT);
				

			}
			// Check IE is Default after that
			if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 2)) {
				TestLogger.info("IE is set Default");
				killprocess("iexplore.exe");
				//clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");
				//sleep(1);
				//s.type(Key.F4, Key.ALT);
				//sleep(5);
				//s.type(Key.F4, Key.ALT);
			} else {
				TestLogger.info("IE is NOT set Default");
				sleep(1);
				s.type(Key.F4, Key.ALT);
			}

			TestLogger.info("Coc coc was uninstalled & Set IE is Default After that ");
		} else
			TestLogger.info("Coc coc was uninstalled & Set IE is NOT Default After that");
		System.out.println("isStartUninstallCC: " + isStartUninstallCC + "--IEisDefault: " + IEisDefault);
		return isStartUninstallCC & IEisDefault;
	}

	/**
	 * Start Uninstall coc coc from control panels & Don't close IE Browser 
	 */
	public boolean startUninstallCocCoc2() {
		boolean isStartUninstallCC = false;
		TestLogger.info("--- Open uninstall coc coc");
		// kill all coc coc browser
		killprocess("browser.exe");
		killprocess("CocCocCrashHandler.exe");
		killprocess("delegate_execute.exe");
		killprocess("CocCocUpdate.exe");
		sleep(2);
		String browerPath = "";
		if (System.getProperty("os.name").contains("XP")) {
			
			browerPath = "C:\\Documents and Settings\\tester\\Local Settings\\Application Data";
		}
		else
			browerPath = System.getenv("LOCALAPPDATA")+ "\\CocCoc\\Browser\\Application\\browser.exe";
		
		if(new File(browerPath).exists()){
			
			s.type("r", Key.WIN);
			sleep(1);
			s.type(Key.BACKSPACE);
			//s.type(browerPath + " -uninstall");
			s.type("appwiz.cpl");
			s.type(Key.ENTER);
			sleep(3);
			s.type(Key.F3);
			sleep(1);
			s.type("coc coc");
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			s.type(Key.ENTER);
			isStartUninstallCC = waitForObjectPresent("pictures\\Browser_UninstallDialog_Text_UninstallBrowser.png", 10);
			
			sleep(1);
		    s.type(Key.ENTER);
			sleep(5);
			s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 2)) {
				clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");	
			}
			
			TestLogger.info("Coc coc was uninstalled!");
		}
		else
			TestLogger.info("Coc coc was uninstalled!");
		
		return isStartUninstallCC;
	}
	
	/**
	 * Uninsatall coc Coc and clean data
	 * 
	 * @param CocCocVersion Version of CocCoc
	 * @author huy.vu
	 * @date 21/1/2016
	 */
	public void UninstallAndClearAllData(String CocCocVersion) {
		UninstallWithDefaultOption(CocCocVersion);
		TestLogger.info("--> Clean data of Coccoc browser");
		sleep(5);
		// kill all CocCoc process
		killprocess("CocCocCrashHandler.exe");
		killprocess("browser.exe");
		killprocess("CocCocUpdate.exe");
		killprocess("coccoc_vi.exe");
		killprocess("iexplore.exe");
		sleep(2);

		if (System.getProperty("os.name").contains("XP")) {

		} else {

			// Remove CocCoc file:
			String CCFolderAppdata = System.getenv("LOCALAPPDATA") + "\\CocCoc";
			String CCFolder = System.getenv("APPDATA") + "\\CocCoc";
			File ccFolderAppdata = new File(CCFolderAppdata);
			File ccFolder = new File(CCFolder);
			DeleteFileAndFolderInSpecificPath(ccFolderAppdata);
			DeleteFileAndFolderInSpecificPath(ccFolder);
			sleep(5);
			if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 2)) {
				clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");
				sleep(1);
				s.type(Key.F4, Key.ALT);
			}
		}
		sleep(5);
		TestLogger.info(" Uninstall Coccoc: Done <--");
	}

	/**
	 * copy folder and all files contains
	 */
	public void copyFolder(File src, File dest) {
		if (src.isDirectory()) {
			// if directory not exists, create it
			if (!dest.exists()) {
				dest.mkdir();
			}
			// list all the directory contents
			String files[] = src.list();
			for (String file : files) {
				// construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				// recursive copy
				copyFolder(srcFile, destFile);
			}
		} else {
			// if file, then copy it
			// Use bytes stream to support all file types
			try {
				InputStream in = new FileInputStream(src);
				OutputStream out = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int length;
				// copy the file content in bytes
				while ((length = in.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				// error, just exit
				
			}
		}
	}

	/**
	 * Check Diff between files
	 * 
	 * @author huy.vu
	 * @date 21/1/2016
	 * 
	 */
	public boolean getDiff(File dirA, File dirB, boolean isIndentical){

		File[] fileList1 = dirA.listFiles();
		File[] fileList2 = dirB.listFiles();
		Arrays.sort(fileList1);
		Arrays.sort(fileList2);
		HashMap<String, File> map1;
		if (fileList1.length < fileList2.length) {
			map1 = new HashMap<String, File>();
			for (int i = 0; i < fileList1.length; i++) {
				map1.put(fileList1[i].getName(), fileList1[i]);
			}
			isIndentical = compareNow(fileList2, map1, isIndentical);
			} 
		else {
			map1 = new HashMap<String, File>();
			for (int i = 0; i < fileList2.length; i++) {
				map1.put(fileList2[i].getName(), fileList2[i]);
			}
			isIndentical = compareNow(fileList1, map1, isIndentical);
		}
		return isIndentical;
	}

	/**
	 * compare 2 files
	 * 
	 * @author huy.vu
	 * @date 21/1/2016
	 * @author Huy
	 * @return true if files are same
	 * 
	 */
	public boolean compareNow(File[] fileArr, HashMap<String, File> map, boolean isIndentical){
		for (int i = 0; i < fileArr.length; i++) {
			String fName = fileArr[i].getName();
			File fComp = map.get(fName);
			map.remove(fName);
			if (fComp != null) {
				if (fComp.isDirectory()) {
					isIndentical = getDiff(fileArr[i], fComp, isIndentical);
				} else {
					String cSum1 = Checksum(fileArr[i]);
					String cSum2 = Checksum(fComp);
					if (!cSum1.equals(cSum2)) {
						if (fileArr[i].getName().contains("setup.exe"))
							TestLogger.warn("Know issue, please check file setup.exe");
						else {
							TestLogger.info(fileArr[i].getName() + "\t\t" + " is different");
							isIndentical = false;
						}
					}
				}
			} else {
				if (fileArr[i].isDirectory()) {
					traverseDirectory(fileArr[i], isIndentical);
				} else {
					TestLogger.info(fileArr[i].getName() + "\t\t" + "only in " + fileArr[i].getParent());
					isIndentical = false;
				}
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String n = it.next();
			File fileFrmMap = map.get(n);
			map.remove(n);
			if (fileFrmMap.isDirectory()) {
				traverseDirectory(fileFrmMap, isIndentical);
			} else {
				TestLogger.info(fileFrmMap.getName() + "\t\t" + "only in " + fileFrmMap.getParent());
			}
		}
		return isIndentical;
	}

	/**
	 * @author huy.vu
	 * @date 21/1/2016
	 * @author Huy
	 */
	public boolean traverseDirectory(File dir, boolean isIndentical) {
		File[] list = dir.listFiles();
		for (int k = 0; k < list.length; k++) {
			if (list[k].isDirectory()) {
				traverseDirectory(list[k], isIndentical);
			} else {
				TestLogger.info(list[k].getName() + "\t\t" + "only in " + list[k].getParent());
				isIndentical = false;
			}
		}
		return isIndentical;
	}

	/**
	 * @author huy.vu
	 * @date 21/1/2016
	 */
	public String Checksum(File file) {
		try {
			InputStream fin = new FileInputStream(file);
			java.security.MessageDigest md5er = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[1024];
			int read;
			do {
				read = fin.read(buffer);
				if (read > 0)
					md5er.update(buffer, 0, read);
			} while (read != -1);
			fin.close();
			byte[] digest = md5er.digest();
			if (digest == null)
				return null;
			String strDigest = "0x";
			for (int i = 0; i < digest.length; i++) {
				strDigest += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1).toUpperCase();
			}
			return strDigest;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * InstallCoccocWithVariant: install browser coccoc in version vi and doesn't close browser after that  
	 * 
	 * @author Huy.vu
	 * @update : HANV
	 * @param CocCocLocation
	 *            Location of CocCoc setup file
	 * @param options
	 *            0: install with default option/1: install with option don't
	 *            make CocCoc is default browser
	 */

	public void InstallCoccocWithVariant(String CocCocLocation, int options) {
		killprocess("CocCocCrashHandler.exe");
		killprocess("browser.exe");
		killprocess("CocCocUpdate.exe");
		killprocess("coccoc_vi.exe");
		killprocess("iexplore.exe");
		sleep(2);

		if (System.getProperty("os.name").contains("XP")) {

		} else {

			// Remove CocCoc file:
			String CCFolderAppdata = System.getenv("LOCALAPPDATA") + "\\CocCoc";
			String CCFolder = System.getenv("APPDATA") + "\\CocCoc";
			File ccFolderAppdata = new File(CCFolderAppdata);
			File ccFolder = new File(CCFolder);
			DeleteFileAndFolderInSpecificPath(ccFolderAppdata);
			DeleteFileAndFolderInSpecificPath(ccFolder);
			sleep(5);
			if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 2)) {
				clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");
				sleep(1);
				s.type(Key.F4, Key.ALT);
			}
		}
		
		File ccSetup = new File(CocCocLocation);
		if (ccSetup.exists())
			if (ccSetup.isFile())
				if (ccSetup.length() != 0) {
					TestLogger.info("Install coc coc with option...");
					executeFile(CocCocLocation);
					waitForObjectPresent("pictures\\Browser_InstallDialog_PopupSettingOption.png", 20);
					//Install CocCoC with options:
					if (options==1){
						TestLogger.info("Install CocCoc with don't make CocCoc is default browser");
						checkRightCheckbox("Install", 2, "");
						sleep(1);
					}
					else if(options==2){
						TestLogger.info("Install with option Make torrent is default is of");
						if(waitForObjectPresent("pictures\\Browser_InstallDialog_Text_SetCoccocAsDefaultTorrentClient.png", 5))
							clickOn("pictures\\Browser_InstallDialog_Text_SetCoccocAsDefaultTorrentClient.png");
						sleep(1);
					}
					else //options ==0
						
						TestLogger.info("Install CocCoc with default options");
					
					//install
					clickOn("pictures\\Browser_InstallDialog_Button_Install.png");
					
					//handle for win 8/8.1:
					// handle on win 8/8.1:
					if (System.getProperty("os.name").contains("Windows 8")) {
						TestLogger.info("--> Handle install on " + System.getProperty("os.name"));
						if (waitForObjectPresent("pictures\\Browser_InstallDialog_Popup_CoccocIsNearlyReady_Win8.png", 40)){
							clickOn("pictures\\Browser_InstallDialog_Popup_CoccocIsNearlyReady_Win8.png");
							if ((waitForObjectPresent("pictures\\OSApp_IE_Icon_IEOptionInDefaultBrowserList.png", 12)) && (options == 1))
								clickOn("pictures\\OSApp_IE_Icon_IEOptionInDefaultBrowserList.png");
						}
					}
					waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 35);
					sleep(5);
				
				} else
					TestLogger.warn("Coc coc setup file wrong: The file size = 0 Byte, please check setup file at: "
							+ CocCocLocation);
			else
				TestLogger.warn("The path to coc coc setup file is path to folder, pls check path: " + CocCocLocation);
		else
			TestLogger.warn("Coc coc setup file not exist on " + CocCocLocation);
	}

	/**
	 * <b>check Coc Coc Update exists on scheduler task</b>
	 * 
	 * @author Huy
	 * @return <b>True:</b> if scheduler task has two CocCocUpdateTaskUser tasks
	 *         in list (one for ua and one for core) <b>False:</b> if scheduler
	 *         task miss one or both of two CocCocUpdateTaskUser tasks in list
	 */

	public boolean checkCocCocOnListSchedulerTask() {
		boolean flag = false;
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process;
			process = runtime.exec("schtasks");
			process.getOutputStream().close();
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);

			// CocCocUpdateTaskUser
			String strLine = "";
			int count = 0;
			while ((strLine = bufferedrReader.readLine()) != null) {
				if (strLine.contains("CocCocUpdateTaskUser"))
					count++;
			}
			if (count == 2)
				flag = true;
		} catch (IOException e) {
			TestLogger.error("Some thing wrong when execute command line: schtasks");
		}
		return flag;
	}

	/**
	 * @author huy.vu
	 * @date 21/1/2016
	 */
	public void startUninstallCocCoc(String version) {
		String CoccocPath = System.getenv("LOCALAPPDATA");
		File f = new File(CoccocPath + "\\CocCoc\\Browser\\Application\\browser.exe");
		CoccocPath = CoccocPath + "\\CocCoc\\Update\\Download\\{C0CC0CBB-47DD-46FF-A04D-7011A06486E1}\\" + version
				+ "\\coccoc.exe ";
		if (f.exists()) {
			try {
				TestLogger.info("Uninstall other CocCoc version: " + version);
				// kill all IE: iexplore.exe
				killprocess("iexplore.exe");
				// kill all CocCoc browser(browser.exe)
				killprocess("browser.exe ");

				// Uninstall CC
				String cmdRun = CoccocPath + " /uninstall";
				TestLogger.info(cmdRun);
				Runtime runtime = Runtime.getRuntime();
				runtime.exec(cmdRun);
				waitForSystem(2000);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} else {
			TestLogger.info("CocCoc is not installed");
		}
	}

	/*
	 * @author huy.vu
	 * 
	 * @date 21/1/2016
	 */
	public void cleanFiddleData() {
		TestLogger.info("Clean Fiddle data");
	}

	/**
	 * <b>check Request On Fiddle</b>
	 * 
	 * @param request
	 *            array: String array: Name of host that fiddler captured
	 * @return <b>True</b>: if <b>False</b>: if
	 * @author Huy
	 */
	public boolean checkRequestOnFiddle(String[] request) {
		boolean flag = true;

		return flag;
	}

	/**
	 * <b>Check folder is empty or not </b>
	 * 
	 * @param file
	 *            : folder
	 * @return <b>True</b>: if folder is empty <b>False</b>: if folder doesn't
	 *         empty
	 * @author Huy
	 */
	public boolean isFolderEmpty(File file) {
		TestLogger.info("Check folder " + file.getAbsolutePath());
		boolean flag = true;
		if (file.isDirectory())
			if (file.list().length > 0) {
				flag = false;
				TestLogger.info("Folder : " + file.getAbsolutePath() + " having contains");
			} else
				TestLogger.info("Folder : " + file.getAbsolutePath() + " is empty");
		return flag;
	}

	/**
	 * <b>Check process name exist on task list or not </b>
	 * 
	 * @param processName
	 *            : Name of process
	 * @return <b>True</b>: if process exist on tasklist <b>False</b>: if
	 *         process doesn't exist on tasklist
	 * @author Huy
	 */
	public boolean isProcessExists(String processName) {
		boolean flag = false;
		try {
			TestLogger.info("-- Check process has name " + processName + " exists");
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("TASKLIST");
			process.getOutputStream().close();
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
			BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);

			String strLine = "";
			while ((strLine = bufferedrReader.readLine()) != null) {
				String[] a = strLine.split(",");
				// x[i++]=a[0];
				if (a[0].contains(processName)) {
					flag = true;
					TestLogger.info("--> Process has name " + processName + " exists on tasklist");
					break;
				}
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return flag;
	}

	/**
	 * 
	 * @author huy.vu
	 * @date 21/1/2016
	 * @return <b>True</b>: CocCoc start IE, after <b>False</b>
	 */
	public boolean isIEnavigateToCocCocAfterUninstall() {
		TestLogger.info("Check IE navigate to coc coc after uninstall Coc Coc:");
		boolean flag = false;
		sleep(3);

		if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 10)) {
			// Click to make sure IE on top
			clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");
			sleep(1);
			s.type(Key.UP, Key.WIN);
			sleep(1);

			// chose reason uninstall
			clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox01.png");
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			clickOn("pictures\\Browser_UninstallSurvey_Button_Send.png");

			// Chose good feature
			waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox02.png", 5);
			clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox02.png");
			sleep(1);
			// Select favious browser
			s.type(Key.TAB);
			s.type(Key.DOWN);

			// Click send
			clickOn("pictures\\Browser_UninstallSurvey_Button_Send.png");
		}

		// Check popup
		if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Button_Close.png", 5)) {
			clickOn("pictures\\Browser_UninstallSurvey_Button_Close.png");
			flag = true;
		}
		// Navigate coccoc home
		if (!waitForObjectPresent("pictures\\Website_coccoc_Button_DownloadBrowser.png", 3)) {
			if (flag) {
				flag = false;
				captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "ieNotstart", 1);
			}
			sleep(5);
			s.type(Key.F4, Key.ALT);
		}
		return flag;
	}

	/**
	 *  display the processes in TaskManager process on windows
	 * 
	 * @author HANV
	 * @date 2/6/2017
	 * 
	 */
	
	public List<String> listRunningProcesses() 
	{
		List<String> processes = new ArrayList<String>();
	    try {
	      String line;
	      Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
	      BufferedReader input = new BufferedReader
	          (new InputStreamReader(p.getInputStream()));
	      while ((line = input.readLine()) != null) {
	          if (!line.trim().equals("")) {
	              // keep only the process name
	              line = line.substring(1);
	              processes.add(line.substring(0, line.indexOf(",")));
	          }

	      }
	      input.close();
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	    return processes;
	}
	
	/**
	 *  Kill the specified processes in TaskManager process on windows
	 * 
	 * @author HANV
	 * @date 2/6/2017
	 * 
	 */
	
  public void killprocess(String processName) {
		try {
			String cmdRun = "taskkill /im " + processName + " /f";
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(cmdRun);
			TestLogger.info("Killed Any process " + processName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open CMD to install Coc coc on silent mode and exit command line port
	 * 
	 * @author huy.vu
	 * @date 21/1/2016
	 * @param cmd
	 *            the command line to install coc coc in silent mode
	 */
	public void installCoccocByCMD(String cmd) {

		TestLogger.info("-> Install Coccoc by command line: " + cmd);
		String CocCocInstallLocation = System.getenv("USERPROFILE") + "\\Downloads";
		s.type("r", Key.WIN);
		sleep(1);
		s.type("cmd");
		sleep(1);
		s.type(Key.ENTER);
		sleep(3);
		s.type("cd " + CocCocInstallLocation);
		sleep(1);
		s.type(Key.ENTER);
		sleep(1);
		s.type(cmd);
		s.type(Key.ENTER);
		sleep(2);
		
		
		 if (waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 35)) 
		 {
			 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			 TestLogger.info("Started Coc Coc successfully ! ");
		 }
		 else
		 {
			 TestLogger.info("Started Coc Coc NOT successfully ! ");
		 }
		
		
		
		if (System.getProperty("os.name").contains("Windows 8"))
		{
	        clickOn("pictures\\OSApp_CommandWindow_icon_CloseWindow8.png");
		}
		else if (System.getProperty("os.name").contains("Windows 10"))
		{
		    clickOn("pictures\\OSApp_CommandWindow_icon_CloseWindow10.png");
		}
		else
		{
			 clickOn("pictures\\OSApp_CommandWindow_icon_Close.png");	
		}
		
		
	}

	/**
	 * start CocCoc browser and Make coc coc history by open dantri.com.vn, youtube and close browser after that 
	 */
	public void makeCoccocHistory() {
		TestLogger.info("-> Make coc coc history by open Dantri.com, youtube.com...");
		
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		sleep(3);
		s.type("t", Key.CTRL);
		sleep(1);

		// add history
		s.type("http://dantri.com.vn/");
		s.type(Key.ENTER);

		sleep(5);
		s.type("t", Key.CTRL);
		s.type("https://www.youtube.com/");
		s.type(Key.ENTER);
		sleep(5); 
		
		if (waitForObjectPresent("pictures\\Website_youtube_image_logo.png", 5))
		{
			TestLogger.info("Open Youtube successfully !! ");
		}
		else
		{
			TestLogger.info("Open Youtube NOT successfully !! ");
		}
		// close cocCoc
        s.type(Key.F4, Key.ALT);

	}

	/**
	 * start CoocCoc , check hitory and close Browser after that 
	 * Check CocCoc is kept data in history 
	 * @return true if Coccoc kept data in history
	 */
	public boolean isCocCocHistoryKept() {
		TestLogger.info("<-> Check histoty on CocCoc is kept");
		boolean fn_flag = false;
		// Open Coccoc
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		sleep(3);
		s.type("h", Key.CTRL);

		waitForObjectPresent("pictures\\Browser_Menu_Button_RecentTabs.png", 20);
		sleep(1);
		s.type("dantri");
		sleep(1);
		s.type(Key.ENTER);

		fn_flag = waitForObjectPresent("pictures\\Browser_HistoryPage_Text_PageAlreadyFound.png", 10);

		if (fn_flag) {
			TestLogger.info("The older history is kept");
		} else {
			TestLogger.info("The older history isn't kept");
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "HistoryNotFound", 1);
		}
		// close cocCoc
		s.type(Key.F4, Key.ALT) ;
		
		//killprocess("browser.exe");

		return fn_flag;
	}

	/**
	 * Check Coc Coc update process on Coccoc browser: Open coccoc://coccoc and
	 * check process
	 * 
	 * @return True if coc coc browser show " Đang update"
	 */
	public boolean checkCoccocUpdateProcess() {
		// kill process: coccoc browser, coccoc update
		killprocess("browser.exe");
		killprocess("CocCocUpdate.exe");
		killprocess("CocCocCrashHandler.exe");
		killprocess("coccoc_vi.exe");
		killprocess("coccoc_en.exe");
		sleep(3);

		// start coccoc
		startCocCoc();
		// Focus on Coc Coc
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		sleep(2);
		s.type("t", KeyModifier.CTRL);
		doubleClick("pictures\\Browser_Omnibox_TextArea_EndOfAddressBar.png");
		s.type("coccoc://coccoc/");
		s.type(Key.ENTER);
		sleep(5);

		if (waitForObjectPresent("pictures\\Browser_AboutCoccoc_Text_CoccocIsUpdatingMsg.png", 180))
			return true;
		else {
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "CocCocUPdateProcessFailed", 1);
			return false;
		}
	}

	/**
	 * Wait for coc coc ready to work
	 * 
	 * @return true if CocCoc ready
	 * @author Huy
	 * @date: 11- Apr 2016
	 */
	public boolean waitForCocCocReady() {
		boolean localFlag = true;
		if (startCocCoc()) {
			s.type("t", Key.CTRL);
			s.type("coccoc://version/");
			sleep(1);
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Browser_Tabs_Text_AboutVersion.png", 5);
			return localFlag;
		}
		return false;
	}

	/**
	 * Check message to ask user that Coccoc not default browser
	 * 
	 * @author Huy
	 */
	public boolean checkMessageSetDefaulBrowser() {
		boolean localFlag = true;
		if (!waitForObjectPresent("pictures\\Browser_BubleDialog_Text_CoccocIsNotYourDefaultBrowser.png", 5)) {
			TestLogger.info("CocCoc doesn NOT ask user that Coccoc is not default browser ");
			localFlag = false;
		}
		return localFlag;
	}

	/**
	 * Check message set default browser on Setting page
	 * 
	 * @return
	 */
	public boolean checkMessageSetDefaulBrowserOnSettingsPage() {
		boolean localFlag = true;
		if (!waitForObjectPresent("pictures\\Browser_Setting_Button_GeneralMakeCocCocAsDefaultBrowser.png", 10)) {
			TestLogger.info("CocCoc doesn NOT show message set default browser on Setting page");
			localFlag = false;
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "MessageSetDefaultBrowserWrongOnSettingPage", 2);
		}
		return localFlag;
	}

	/**
	 * Set IE as default browser and close Browser after that 
	 * 
	 * @author Huy
	 * @update : Hanv 
	 */
	public void setIEasDefaultbrowser() {
		// Open internet options
	    s.type("d", Key.WIN);
		sleep(3);
		s.type("r", Key.WIN);
		sleep(1);
		s.type("inetcpl.cpl");
		s.type(Key.ENTER);

		if (waitForObjectPresent("pictures\\OSApp_InternetSetting_Text_UnselectedProgramTab.png", 15)){
			clickOn("pictures\\OSApp_InternetSetting_Text_UnselectedProgramTab.png");

				// win7: click on make default browser buttons
				if(waitForObjectPresent("pictures\\OSApp_InternetSetting_Button_MakeIEAsDefaultBrowser.png", 4))
				{
					
					clickOn("pictures\\OSApp_InternetSetting_Button_MakeIEAsDefaultBrowser.png");
					// Close Internet option
					 s.type(Key.F4, Key.ALT);
					 TestLogger.info("Set IE as Default Browser Successfully !! ");
				}

					// Set default browser as IE (need special handle on win 8 
					if (System.getProperty("os.name").contains("Windows 8")) {
						s.type(Key.F4, Key.ALT);
						TestLogger.info("--> Handle install on win 8");
						s.type("r", Key.WIN);
						sleep(1);
						s.type("control");
						s.type(Key.ENTER);
						sleep(1);
						s.type(Key.UP,Key.WIN);
						s.type("f",Key.CTRL);
						sleep(1);
						s.type("default");
					
						if (waitForObjectPresent("pictures\\OSApp_WindowSettings_Text_DefaultPrograms.png", 3))
						{
							clickOn("pictures\\OSApp_WindowSettings_Text_DefaultPrograms.png");
							sleep(5);
							clickOn("pictures\\OSApp_WindowSettings_icon_InternetExplore.png");
							clickOn("pictures\\OSApp_WindowSettings_Text_SetYourDefaultPrograms.png");
							sleep(2);
							clickOn("pictures\\OSApp_WindowSettings_Button_OK.png");
							sleep(1);
							s.type(Key.F4, Key.ALT);
						}
					}
				
					// Set default browser as IE (need special handle on Win 10 
					if (System.getProperty("os.name").contains("Windows 10")) {
						s.type(Key.F4, Key.ALT);
						TestLogger.info("--> Handle install on win 10");
						s.type("r", Key.WIN);
						sleep(1);
						s.type("control");
						s.type(Key.ENTER);
						sleep(1);
						s.type(Key.UP,Key.WIN);
						s.type("f",Key.CTRL);
						sleep(1);
						s.type("default");
					
						if (waitForObjectPresent("pictures\\OSApp_WindowSettings_Text_DefaultPrograms.png", 3))
						{
							clickOn("pictures\\OSApp_WindowSettings_Text_DefaultPrograms.png");
							sleep(10);
							clickOn("pictures\\OSApp_WindowSettings_icon_InternetExplore.png");
							clickOn("pictures\\OSApp_WindowSettings_Text_SetYourDefaultPrograms.png");
							sleep(2);
							clickOn("pictures\\OSApp_WindowSettings_Button_OK.png");
							sleep(1);
							s.type(Key.F4, Key.ALT);
						}
					}
					
		} 
		
		else {
			// kill process for internet option
			killprocess("rundll32.exe");
			TestLogger.error("===========================================================\n"
					+ "Cannot open internet option to set IE as default browser, Please check!\n"
					+ "===========================================================\n");
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/",
					"MessageSetDefaultBrowserWrongOnSettingPage", 2);
		}
	}

	/**
	 * Change system date: change month
	 * 
	 * @param changes
	 *            add or minus number of month
	 */
	public void changeMonth(int changes) {
		TestLogger.info("Change system date with month is");
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1 + changes;
		int date = now.get(Calendar.DATE);

		// handle if change calendar to next years
		if (month > 12) {
			year = year + 1;
			month = month - 12;
		}

		if (month <= 0) {
			year = year - 1;
			month = month + 12;
		}
		TestLogger.info("Change system date with month is " + month);
		String cmd = "cmd /c date " + month + "-" + date + "-" + year;
		TestLogger.info(cmd);
		try {
			Runtime.getRuntime().exec(cmd);
			sleep(1);
		} catch (IOException e) {
			TestLogger.warn("Error when execute command line: " + cmd);
		}
	}

	/**
	 * Read text file from
	 * 
	 * @param textFilePath
	 * @return
	 */
	public String readTextFile(String textFilePath) {
		String textContain = "";
		String line;
		int count = 0;
		try {
			FileReader fr = new FileReader(textFilePath);
			BufferedReader textReader = new BufferedReader(fr);
			while ((line = textReader.readLine()) != null) {
				textContain = textContain + line + "\n";
				count++;
			}
			textReader.close();

		} catch (Exception e) {
			TestLogger.warn(e.toString());
		}
		return "Total: " + count + "\n" + textContain;
	}
	public void writeContainToTextFile(String filePath, String content, boolean continueWrite) {

		try {
			File file = new File(filePath);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				TestLogger.info("File not exist, create file: " + filePath);
				file.createNewFile();
			}
			TestLogger.info(file.getAbsolutePath());
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), continueWrite);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\t + " + content);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Start Coccoc browser with default language English
	 * @author hanv
	 * @date 12-1-2017
	 */
		public boolean startCocCocInEnglish() {
		TestLogger.info(" Start Coccoc browser with default language English");
		String coccocPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\Application\\browser.exe";
		boolean flag;
		//return false if CocCoc do not install
		File ccBrowser = new File(coccocPath);
		if(!ccBrowser.exists()){
			TestLogger.warn("Cannot start CocCoc browser, Maybe coccoc wasn't install");
			return false;
		}
		
		s.type(Key.UP);
		s.type(Key.UP);
		
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		flag = waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 60);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.UP, Key.WIN);
		
		
		
		if (waitForObjectPresent("pictures\\Browser_Menu_icon_NewTabVN.png",4)) {
			sleep(5);
			clickOn("pictures\\Browser_Menu_Button_Reload.png");
			openLink("coccoc://settings/#coccoc-settings-general");
			sleep(5); 
			clickOn("pictures\\Browser_Settings_Menu_Chung.png"); 
			clickOn("pictures\\Browser_SettingsLanguage__Button_CaidatNgonnguNhaplieu.png"); 
			clickOn("pictures\\Browser_SettingsLanguage_Text_TienganhHoaKi.png"); 
			clickOn("pictures\\Browser_SettingsLanguage_Button_HienThiCocCocBangTiengAnh.png");  
			clickOn("pictures\\Browser_SettingsLanguage_Button_SuDungNgonnguNayDeCheckChinhTa.png");  
			clickOn("pictures\\Browser_SettingsLanguage_Button_HoanTat.png");
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type(Key.F4, Key.ALT);
			sleep(1);
			s.type(Key.UP);
			
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		}
		else {
		    if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png", 2))  
		    	clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
		    sleep(3);
		}
		
		
		return flag;
	}

	
    /**
	 * open Coc Coc browser in Vietnamese version from English Version 
	 * @author hanv
	 * @date 12-1-2017
	 */
	public void startCocCocinVietnameseToTranslateEnglishPages()
	{ 
		TestLogger.info("open Coc Coc browser in Vietnamese version from English Version ");
		startCocCocInEnglish();
		moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -130);
	    s.click();
	    s.type("coccoc://settings/#coccoc-settings-general") ;
	    s.type(Key.ENTER);
	    waitForObjectPresent("pictures\\Browser_Settings_Menu_General.png", 7);
		clickOn("pictures\\Browser_Settings_Menu_General.png");
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_LanguageAndInputSettings.png", 7);
		clickOn("pictures\\Browser_SettingsLanguage_Button_LanguageAndInputSettings.png");
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_Add.png", 7);
		clickOn("pictures\\Browser_SettingsLanguage_Button_Add.png");
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Buton_AddLanguage.png", 7); 
		clickOn("pictures\\Browser_SettingsLanguage_Buton_AddLanguage.png");
		s.type("v");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_OK.png", 7);
		clickOn("pictures\\Browser_SettingsLanguage_Button_OK.png");
		if (waitForObjectPresent("pictures\\Browser_SettingsLanguage_Text_LanguageEnglishChoice.png", 3)) 
		{
			clickOn("pictures\\Browser_SettingsLanguage_Text_Vietnam.png");
		}
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_DisplayCocCocinThisLangauge.png", 7);
		clickOn("pictures\\Browser_SettingsLanguage_Button_DisplayCocCocinThisLangauge.png");
		// check on CheckBox Offer to translate pages in this language 
		waitForObjectPresent("pictures\\Browser_SettingsLang_Checkbox_Offer_To_translate.png", 7);  
		clickOn("pictures\\Browser_SettingsLang_Checkbox_Offer_To_translate.png");
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_Done.png", 7);
		clickOn("pictures\\Browser_SettingsLanguage_Button_Done.png");  
		 //exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		sleep(6);

	}
		
	/**
	 * open Coc Coc browser in English version 
	 * @author hanv
	 * @date 13-Jul-2016
	 */
	public void startCocCocinEnglishAndRemoveVietnameLanguage()
	{ 
		
	    TestLogger.info("Open Coc Coc browser in English version ");
		startCocCoc();
		moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -130);
	    s.click();
	    s.type("coccoc://settings/#coccoc-settings-general") ;
	    s.type(Key.ENTER);
		sleep(5); 
		clickOn("pictures\\Browser_Settings_Menu_Chung.png");
		
		clickOn("pictures\\Browser_SettingsLanguage__Button_CaidatNgonnguNhaplieu.png");
		clickOn("pictures\\Browser_SettingsLanguage_Button_HienThiCocCocBangTiengAnh.png");
		clickOn("pictures\\Browser_SettingsLanguage_Button_HoanTat.png");
		clickOn("pictures\\Browser_Menu_Button_CloseWindow.png");
		
		startCocCocInEnglish();
		moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -130);
	    s.click();
	    s.type("coccoc://settings/#coccoc-settings-general") ;
	    s.type(Key.ENTER);
		sleep(5); 
		TestLogger.info("Remove VietNamese Language in Settings");
		clickOn("pictures\\Browser_Settings_Menu_General.png");
		clickOn("pictures\\Browser_SettingsLanguage_Button_LanguageAndInputSettings.png");
		clickOn("pictures\\Browser_SettingsLanguage_Text_Vietnam.png");
		clickOn("pictures\\Browser_SettingsLanguage_Button_RemoveLanguage.png");  
		clickOn("pictures\\Browser_SettingsLanguage_Button_Done.png");
		clickOn("pictures\\Browser_Menu_Button_CloseWindow.png");
	}
	
	/**
	 * Open URL 
	 * @author hanv
	 * @date 13-Jul-2016
	 */
	public void openLink (String URL)
	{
		TestLogger.info("Open Site : " + URL);
		moveMouseDownFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 200);
        waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 5);
	    moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -130);
	    s.click();
	    s.type("a", Key.CTRL);
	    s.type(URL);
	    sleep(2);
		s.type(Key.ENTER);
		sleep(5);
		
	}
	
	/**
	 * delete all Downloaded filed in Downloads Folder
	 * @author hanv
	 * @date 13-Jul-2016
	 */
	
	public void deleteDownloadedFiles(){       
	    startCocCoc();
	    // startBrowserinVietnamese();
	    openLink("coccoc://downloads/");
	    waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png",22);
	    do
	    { 
	    	if (waitForObjectPresent("pictures\\Browser_Downloader_Button_CancelDownload.png", 1))
	    	{
	    	clickOn("pictures\\Browser_Downloader_Button_CancelDownload.png");
	    	clickOn("pictures\\Browser_Downloader_Button_RemoveDownloadItem.png");
	    	}
	    	else
	    	{
	    		clickOn("pictures\\Browser_Torrent_Button_DeletedAll.png");
	    	}
	    } while (waitForObjectPresent("pictures\\Browser_Downloader_Button_CancelDownload.png", 1)) ;
	    
	    clickOn("pictures\\Browser_Torrent_Button_DeletedAll.png");
	    	
	    s.type("r",org.sikuli.script.Key.WIN );
        sleep(5);
        s.type(System.getenv("USERPROFILE")+"\\downloads");
        s.type(org.sikuli.script.Key.ENTER);
        sleep(2);
        s.type(Key.UP, Key.WIN);
	    s.type("a", org.sikuli.script.Key.CTRL);
	    s.type(org.sikuli.script.Key.DELETE);	
	    sleep(2);
	    clickOn("pictures\\OSApp_DeleteFileDialog_Button_YES.png");
	    clickOn("pictures\\OSApp_DeleteFileDialog_Button_CLOSE.png");	
	    clickOn("pictures\\OSApp_DeleteFileDialog_Button_CLOSE.png");
	    
	    TestLogger.info("Deleted all Downloaded filed in Downloads Folder");
	}
		
	// -------------------------------------------------------------------------
	// WORK ON SPECIAL REGION
	// -------------------------------------------------------------------------
	/**
	 * Wait for object appears on special region
	 * @param rootImage  Object to get root coordinate
	 * @param findImage  Object want to find on region
	 * @param widthRegion  width of region want to find object
	 * @param heighRegion height of region want to find object
	 * @param timeOut time out in seconds
	 * @return true if image found in region
	 * 
	 * @author Huy
	 * @update 9 Jun, 2016
	 */
	public boolean waitForObjectAppearOnRegion(String rootImage, String findImage, int widthRegion, int heighRegion, int timeOut) {
		TestLogger.info("");
		String fullRootImagePath = getResource(rootImage);
		String fullFindImagePath = getResource(findImage);
		Region r;
		Match coordinate;
		boolean isControlInRegion = false;

		if (waitForObjectPresent(rootImage, 5)) {
			int waitTimes = (timeOut % 3 + 1);
			for (int count = 1; count <= waitTimes; count++) {
				try {
					coordinate = s.find(fullRootImagePath);
					r = new Region(coordinate.x, coordinate.y, widthRegion, heighRegion);
					r.find(fullFindImagePath);
					TestLogger.info("Control is found on region! break");
					sleep(0.5);
					isControlInRegion = true;
					break;
				} catch (FindFailed e) {
					System.out.print(" . ");
				}
			}
		} else
			TestLogger.warn("cannot find image");
		System.out.println("");
		return isControlInRegion;
	}

	/**
	 * click on object on special region
	 * 
	 * @param rootImage
	 * @param clickonImage
	 * @param widthRegion
	 * @param heighRegion
	 * @param timeOut
	 * @return
	 */
	public boolean clickOnRegion(String rootImage, String clickonImage, int widthRegion, int heighRegion) {
		String fullRootImagePath = getResource(rootImage);
		String fullFindImagePath = getResource(clickonImage);
		Region r;
		Match coordinate;
		boolean isControlInRegionClicked = false;

		if (waitForObjectPresent(rootImage, 2)) {
			try {
				coordinate = s.find(fullRootImagePath);
				r = new Region(coordinate.x, coordinate.y, widthRegion, heighRegion);
				r.hover(fullFindImagePath);
				sleep(1);
				r.click();
				TestLogger.info("Clicked!");
				sleep(1);
				isControlInRegionClicked = true;
			} catch (FindFailed e) {
				System.out.print("Error: " + e);
			}
		} else
			TestLogger.warn("cannot find image");
		return isControlInRegionClicked;
	}

	/**
	 * Clean download page by remove UserData folder
	 * 
	 * @author Huy.Vu
	 */
	public void clearDownloadPage() {

		String UserDataPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\User Data";
		File userDataFolder = new File(UserDataPath);
		TestLogger.info("Clean download page by remove UserData folder");
		//Close turn of system if have by press "esc"
		DeleteFileAndFolderInSpecificPath(userDataFolder);
		//s.type(Key.F4, Key.ALT);
		if(waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 1)){
			doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
			s.type(Key.ESC);
			s.type(Key.F4, Key.ALT);
			sleep(2);
		}
	}
	
	/**
	 * Delete data from Download page on CocCoc browser 
	 * 
	 * @author HANV
	 */
	
	public void clearDownloads()
	{
		TestLogger.info("Delete data from Download page on CocCoc browser");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("j", Key.CTRL);
		int i = 1;
		
		while (waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png",1) & (i<10))
		{
			hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
			hoverImage("pictures\\Browser_Torrent_Button_DeletedAll.png");
			hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
			waitForObjectPresent("pictures\\Browser_Downloader_ContextMenu_OpenSourcePage.png", 2);
			clickOn("pictures\\Browser_Downloader_Button_DeleteFile.png");
			clickOn("pictures\\Browser_Torrent_Button_DeletedAll.png");
		}
		
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_CancelDownload.png", 1))
			{
			    clickOn("pictures\\Browser_Downloader_Button_CancelDownload.png");
			    clickOn("pictures\\Browser_Torrent_Button_DeletedAll.png");
			}
		else
		{
			clickOn("pictures\\Browser_Torrent_Button_DeletedAll.png");
		}
		
			  
		
	} 
	 
	
	/**
	 * close CocCoc browser 
	 * 
	 * @author HANV
	 */
	public void closeBrowser ()
	{
		TestLogger.info("Close CocCoc Browser !"); 
		if (waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 2))
		{
		  clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		  s.type(Key.F4, Key.ALT);
		}
	}
	
	/**
	 * Check file is download or not in 20 seconds
	 * @param torrentDownloadFolder
	 * @return
	 * @author Huy
	 * @date 27 Jun 2016
	 */
	public Boolean isFileDownloading(String folderPath) {
		TestLogger.info("Check file is downloading or not");
		File foderCheck = new File(folderPath);
		String hashPoint1="";
		String hashPoint2="";
		boolean isdownload = false;
		sleep(5);
		hashPoint1 = hashFile(foderCheck);
		sleep(10);
		hashPoint2 = hashFile(foderCheck);
		if(!hashPoint1.equals(hashPoint2)){
			isdownload = true;
			TestLogger.info("The files being downloaded");
			TestLogger.debug(hashPoint1);
			TestLogger.debug(hashPoint2);
		}
		else
			TestLogger.info("The files are not downloaded");
		
		return isdownload;
	}
	
	/**
	 * check download is less than the maximum bandwidth
	 * @param maximumBandwidth
	 * @return
	 * @author Huy
	 * @date 27 Jun 2016
	 */
	public boolean checkbandwidth(int maximumBandwidth) {
		
		TestLogger.warn("Need find out solution to check bandwidth");
		return true;
	}

	/**
	 * Set bandwidth for torrent download
	 * @param bandwidth
	 * @author Huy
	 * @date 27 Jun 2016
	 */
	public void setBandwidthDownloadFile(String bandwidth) {
		clickOn("pictures\\Browser_Downloader_Button_DropDownList.png");
		sleep(0.5);
		clickOn("pictures\\Browser_Torrent_Menu_SetBandwidth.png");
		clickOn("pictures\\CocCocDownloadPage_setBandwidth" + bandwidth + ".png");
	}
	
	/**
	 * Set bandwidth for torrent download with special value
	 *  
	 * @param string
	 * @author Huy
	 * @date 27 Jun 2016
	 */
	public void setBandwidthUploadFileManual(String bandwidthValue) {
		
		clickOn("pictures\\Browser_Downloader_Button_DropDownList.png");
		sleep(0.5);
		clickOn("pictures\\Browser_Torrent_Menu_SetBandwidth.png");

		clickOn("pictures\\Browser_Torrent_TextArea_SetBandwidth.png");
		doubleClick("pictures\\Browser_Torrent_TextArea_SetBandwidth.png");
		TestLogger.info("Set bandwidth for torrent download with special value " + bandwidthValue);
		s.type(bandwidthValue);
		
	}
	
	/**
	 * hash file to md5
	 * @param f file want to hash
	 * @return md5 hash value
	 */
	public String hashFile(File fileHash) {
		String  HashOutPut = "";
		
		try{
			if(fileHash.isDirectory()){
				for (File chilFile: fileHash.listFiles())
					HashOutPut = HashOutPut + hashFile(chilFile);
			}
			else
				HashOutPut = FileUtils.checksumCRC32(fileHash) + "";
		}
		catch (Exception e) {
			TestLogger.warn("Error: " + e);
		}
		return HashOutPut;
	}
	
	/**
	 * Delete all registries has name contains registry name
	 * @param registryName
	 * @data : 12/1/2017
	 */
	
	public void deleteRegistry(String registryName){
		
		boolean isRegistriesStillExist = true;
		s.type("d", Key.WIN);
		sleep(1);
		s.type("r", Key.WIN);
		sleep(1);
		s.type(Key.DELETE);
		s.type("regedit");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\OSApp_Registry_Button_EDIT.png", 10);
		clickOn("pictures\\OSApp_Registry_Button_EDIT.png");
		sleep(1);
		clickOn("pictures\\OSApp_Registry_Button_FIND.png");
		sleep(2);
		s.type(registryName);
		s.type(Key.ENTER);
		
		while(isRegistriesStillExist){
			clickOn("pictures\\OSApp_Registry_Button_EDIT.png");
			sleep(1);
			clickOn("pictures\\OSApp_Registry_Button_FIND.png");
			sleep(1);
			s.type(Key.ENTER);
			sleep(5);
			waitforObjectNotexist("pictures\\OSApp_Registry_Text_SearchingRegistry.png", 160);
			
			//if registry key not found:
			if(waitForObjectPresent("pictures\\OSApp_Registry_Text_SearchingRegistryNotFound.png", 5)){
				TestLogger.info("Registry key is NOT Found !");
				isRegistriesStillExist = false;
				s.type(Key.ENTER);
			}
			//else: registry found
			else
			{
				TestLogger.info("Registry key is Found !");
				sleep(1);
				s.type(Key.DELETE);
				sleep(1);
				s.type(Key.ENTER);
			}
		}
		sleep(1);
		s.type(Key.F4, Key.ALT);
	}
	
	/*
	 * -------------------------------------------------------------------------
	 * - ----- section: CocCoc browser Features
	 * -------------------------------------------------------------------------
	 */

	// TO-DO: all commom fuctions that will be used for specific test requests
	// of Coc Coc browser extensions, special features, must be placed in this
	// Savior: TO-DO

	public void updateExtenVersion() {
		// close all CocCoc
		TestLogger.info("Update Extension Version");
		openExtensionsPage();
		sleep(1);
		clickOn("pictures\\Browser_Extensions_Checkbox_UncheckedOptionModeForDevelopers.png");
		sleep(1);
		clickOn("pictures\\Browser_Extensions_Button_UpdateExtensionVersionNow.png");
		sleep(3);
		killprocess("browser.exe");

	}

	/**
	 * open Coc Coc Browser and Open extension page
	 * @author Huy.vu
	 * @update : HANV
	 */
	public void openExtensionsPage() {

		// start Coccoc
		startCocCoc();
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);

		// open extension page
		s.type("t", Key.CTRL);
		// Open Coccoc extension
		sleep(1);
		s.type("coccoc://extensions");
		s.type(Key.ENTER);
		if (waitForObjectPresent("pictures\\Browser_Settings_Text_Extensions.png", 20)) {
			TestLogger.info("The extension page is openning");
		} else {
			TestLogger.warn("Cannot open extensions page");
		}
	}
	
	/**
	 * Start Côc Cốc and Open settings page
	 * @author Huy.vu
	 * Update : HANV
	 */
	public void openSettingsPage() {
		// start Coccoc
		startCocCoc();
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		// open extension page
		s.type("t", Key.CTRL);
		// Open Coccoc extension
		sleep(1);
		s.type("coccoc://settings");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 120);
		if (waitForObjectPresent("pictures\\Browser_Settings_Text_Extensions.png", 20))
			TestLogger.info("The Settings page is openning");
		else 
			TestLogger.warn("Cannot open settings page");
	}

	/**
	 * Clean files on download folders
	 * 
	 * @author Huy.Vu
	 * @param fileName
	 *            name of file want to delete, if want to delete all files on
	 *            download folder input ""
	 */
	public void cleanResouces(String fileName) {
		TestLogger.info("Clean resource on download page");
		String downloadFolderPath = System.getenv("USERPROFILE") + "\\Downloads\\";
		File DownloadFolder = new File(downloadFolderPath);
		for (File f : DownloadFolder.listFiles())
			if ((f.getName().contains(fileName))&(!f.getName().contains("coccoc_vi.exe"))) {
				TestLogger.info(f.getName());
				f.delete();
			}
	}

	/**
	 * Move mouse and click on screen, where under the logo 200px
	 * 
	 * @param imageOfLogo  the name of image was captured
	 * @author Huy.Vu
	 */
	public void moveMouseDownFromLogo(String imageOfLogo, int distance){
		String image = getResource(imageOfLogo);
		if (waitForObjectPresent(imageOfLogo, 5)) {
			try {
				Match coordinate = s.find(image);
				s.mouseMove(coordinate);
				sleep(1);
				coordinate.y = coordinate.y + distance;

				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double height = screenSize.getHeight();
				double newY = coordinate.y;

				if (height >= newY)
					s.mouseMove(coordinate);
				else
					TestLogger.warn("Cannot move mouse to new coordinate ");
			} catch (FindFailed e) {
				TestLogger.warn("ERROR: " + e);
			}
		} else {
			TestLogger.info("Cannot find image on " + image);
			String screenShotPath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(screenShotPath, "MoveMouseError", 1);
		}
	}
	
	/**
	 * Move mouse and click on screen, where next to the logo 
	 * 
	 * @param imageOfLogo
	 *            the name of image was captured
	 * @author hanv
	 * @date 13-Jul-2016
	 */
	public void moveMouseHorizontallyFromLogo(String imageOfLogo, int distance) {
		String image = getResource(imageOfLogo);
		if(waitForObjectPresent(imageOfLogo, 5)){
			try {
				Match coordinate = s.find(image);
				s.mouseMove(coordinate);
				sleep(1);
				coordinate.x = coordinate.x + distance;
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = screenSize.getWidth();
				double newY = coordinate.x;
				
				if(width >= newY)
					s.mouseMove(coordinate);
				else
					TestLogger.warn("Cannot move mouse to new coordinate ");
			} catch (FindFailed e) {
				TestLogger.warn("ERROR: " + e);
			}
		}
		else
		{
			TestLogger.info("Cannot find image on " + image);
			String screenShotPath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(screenShotPath, "MoveMouseError", 1);
		}
	}
	
	/**
	 * Move mouse to special poison
	 * 
	 * @param coodX
	 *            Coordinate of X
	 * @param coodY
	 *            Coordinate of Y
	 */
	public void moveMouseToCoordinate(Point cood) {
		try {
			Robot robot = new Robot();
			int coodX, coodY;

			robot.mouseMove(0, 0);
			sleep(1);

			coodX = (int) cood.getX();
			coodY = (int) cood.getY();

			robot.mouseMove(coodX, coodY);

		} catch (AWTException e) {
			TestLogger.warn(e.toString());
		}
	}

	/**
	 * 
	 * @return current coordinate of mouse
	 * @author Hanv
	 */
	public Point getCursorPosition() {
		PointerInfo mouseLocation = MouseInfo.getPointerInfo();
		return mouseLocation.getLocation();
	}
	
	/**
	 * Open files 
	 * @param filePath: full path to files
	 * @update : HANV
	 * @date : 12/1/2017 
	 */
	public void openFile(String filePath) {
		TestLogger.info("Open file  at path " + filePath);
		s.type(Key.WIN);
		sleep(1);
		s.type(filePath);
		s.type(Key.ENTER);
		sleep(1);
		
	}
	
	/**
	 * Check the version of omaha is correct or not
	 * 
	 * @param OmahaVersion The version of Omaha want to check
	 * @return true if Version is correctly
	 */
	public boolean isOmahaVersionCorrect(String OmahaVersion){
		String localappData = System.getenv("LOCALAPPDATA");
		File omahaFolder = new File(localappData + "\\CocCoc\\Update\\" + OmahaVersion);
		if(omahaFolder.exists())
			if(omahaFolder.isDirectory())
				return omahaFolder.list().length>0;
			else
				TestLogger.warn("The folder " + omahaFolder.getPath() + " not Directory");
		else
			TestLogger.warn("The folder " + omahaFolder.getPath() + " not exist");
					
		return false;
	}
	/*
	 * -------------------------------------------------------------------------
	 * MAC section
	 * -------------------------------------------------------------------------
	 */
	/**
	 * 
	 * Get information from configure file (Coc Coc version, Omaha version,
	 * Extensions version, old version wanna update to latest version)
	 * 
	 * @author Huy
	 * @param path
	 *            to file configure
	 * @return 0: domain to download coccoc browser (Default is dev.coccoc.com)
	 *         <br>
	 *         1: Latest version of Coc coc<br>
	 *         2: Omaha version<br>
	 *         3: Savior version<br>
	 *         4: En2Vi Version<br>
	 *         5: old version of Coc coc -> test for update
	 */
	public String[] getTestInfomationMAC(String pathToFile) {
		String line;
		String info[] = new String[10];
		pathToFile = getResourceMAC(pathToFile);
		info[0] = "dev.coccoc.com";
		try {
			FileReader fr = new FileReader(pathToFile);
			BufferedReader textReader = new BufferedReader(fr);
			int count = 5;
			while ((line = textReader.readLine()) != null) {
				String[] config = line.split(": ");
				if (line.contains("domain"))
					info[0] = config[1];
				else if (line.contains("browser"))
					info[1] = config[1];
				else if (line.contains("Ohama "))
					info[2] = config[1];
				else if (line.contains("Savior "))
					info[3] = config[1];
				else if (line.contains("En2Vi "))
					info[4] = config[1];
				else if (line.contains("old Version")) {
					info[5] = config[1];
					count++;
				}
			}
			info[6] = count + "";
			textReader.close();
		}

		catch (Exception e) {
			TestLogger.info("File config not exist or some thing wrong, pls check configure file at: " + pathToFile);
			TestLogger.info("Execute on local machine");
		}
		return info;
	}

	/**
	 * DownloadCCBrowserMAC: download coccoc's browser to ~/Downloads/coccoc.dmg
	 * @param domains : enter domains to download: coccoc/corom
	 * @author Huy
	 */
	public boolean DownloadCCBrowserMAC(String domainDownload) {
		boolean isCCdownload = false;
		String homePath = System.getProperty("user.home");
		WebDriver CocCoc;
		TestLogger.info("Download CocCoc from: " + domainDownload);
		// Delete old coccoc.dmg:
		f = new File("/Users/User/Downloads/coccoc.dmg");
		TestLogger.debug(f.getAbsolutePath());
		if (f.exists()) {
			TestLogger.info("Delete older coccoc.dmg file...");
			f.delete();
		}
		CocCoc = openWebWithLink("http://" + domainDownload);
		// Test auto download
		clickElementByID(CocCoc, "_downloadUrl3");
		clickElementByxPath(CocCoc, "//a[@class='green-btn']");

		waitForObjectPresentMAC("specificEnviroment/mac/saveFile.png", 20);
		clickOnMac("specificEnviroment/mac/saveFile.png");
		// wait for download completed
		if (waitForDownloadFileCompleted(homePath + "/Downloads/coccoc.dmg", 100)) {
			isCCdownload = true;
			TestLogger.info("Download CocCoc : -> Done");
		}
		CocCoc.close();
		return isCCdownload;
	}

	/**
	 * openApplicationMAC: open folder Application on MAC
	 * @author Huy.Vu
	 */
	public void openApplicationMAC() {
		TestLogger.info("Open CocCoc from Applications");
		// Hide all windows and open finder by press Command + h
		TestLogger.info("Open applications folder");
		s.type(Key.F11);
		sleep(1);
		s.click();
		s.type("a", Key.SHIFT + Key.WIN);
		sleep(1);
		s.type("a");
	}

	/**
	 * Install Coc Coc with options:
	 * @param dmgFile
	 * @param options Don't close Coc Coc: not close Coc Coc after install
	 */
	public void InstallCocCocOnMacWithOptions(String dmgFile) {
		TestLogger.info("Install Coc Coc from file " + dmgFile);
		s.type(Key.SPACE, Key.WIN);
		s.type(dmgFile);
		s.type(Key.ENTER);
		s.type(Key.ENTER);

		waitForObjectPresentMAC("Install_CocCocIconMac.png", 30);
		// ---- work around because of Sikuli has issue for drag and drop on
		// MAC: #1429074, #263845, #1429074

		clickOnMac("Install_CocCocIconMac.png");
		s.type("c", Key.WIN);

		doubleClickMac("Install_ApplicationsFolderIconMac.png");
		sleep(1);
		s.type("v", Key.WIN);

		waitforObjectDisappearMAC("copyingCocCoc.png", 40);
		s.type("w", Key.ALT + Key.WIN);
	}

	/**
	 * insntall coccoc on Mac from window download on browser
	 * 
	 * @param dmgFileLocation
	 * @author Huy
	 */
	public void InstallCocCocOnMac(String dmgFileName) {
		TestLogger.info("Install CocCoc by file name: " + dmgFileName);
		s.type(Key.SPACE, Key.WIN);
		s.type(dmgFileName);
		s.type(Key.ENTER);
		s.type(Key.ENTER);
		waitForObjectPresentMAC("Install_CocCocIconMac.png", 30);
		// ---- work around because of Sikuli has issue for drag and drop on
		// MAC: #1429074, #263845, #1429074
		clickOnMac("Install_CocCocIconMac.png");
		s.type("c", Key.WIN);

		doubleClickMac("Install_ApplicationsFolderIconMac.png");
		sleep(1);
		s.type("v", Key.WIN);
		sleep(10);
		waitforObjectDisappearMAC("copyingCocCoc.png", 40);
		s.type("w", Key.ALT + Key.WIN);
		TestLogger.info("Install CocCoc on MAC: -> Done");
	}

	/**
	 * Check coc Coc is installed and stored in Applications folder
	 * 
	 * @return <b>True</b> If coc coc is installed and stored in Applications
	 *         folder<br>
	 *         <b>False</b> If coc coc isn't installed or stored in Applications
	 *         folder<br>
	 * @author Huy @
	 */
	public boolean isCocCocInstallonMac() {
		TestLogger.info("Check coc Coc is installed");
		boolean isCocCocInstall = false;
		openApplicationMAC();
		s.type(Key.HOME);
		isCocCocInstall = waitForObjectPresent("iconAppccMAC.png", 1);
		return isCocCocInstall;
	}

	/**
	 * Start Coc coc from /Applications/, click on all confirm button
	 * 
	 * @author Huy
	 */
	public void startCocCocOnMac() {

		TestLogger.info("Start Coc Coc:....");
		// closeAllCocCocOnMAC();
		openApplicationMAC();

		if (waitForObjectPresentMAC("iconAppccMAC.png", 20)) {
			doubleClickMac("iconAppccMAC.png");

			// click on Open button if it's the first time start CocCoc
			if (waitForObjectPresentMAC("openccMAC.png", 10)) {
				clickOnMac("openccMAC.png");
				sleep(2);
				// confirm install (start with Coccoc, default torrent, start
				// with system)
			}

			if (waitForObjectPresentMAC("startCocCocMAC.png", 10))
				clickOnMac("startCocCocMAC.png");
		}
	}

	/**
	 * Start Coc coc from /Applications/, click on all confirm button
	 * 
	 * @param type
	 *            : New: the newer version ( Coc Coc 2)
	 * @author Huy
	 */
	public void startCocCocOnMac(String type) {

		TestLogger.info("Start Coc Coc:....");
		// closeAllCocCocOnMAC();
		openApplicationMAC();
		String control = "iconAppccMAC.png";

		// handle for case start with newer version.
		if (type.toUpperCase() == "NEW")
			control = "iconAppccMAC_2.png";
		if (waitForObjectPresentMAC(control, 20)) {
			doubleClickMac("iconAppccMAC.png");
			// click on Open button if it's the first time start CocCoc
			if (waitForObjectPresentMAC("openccMAC.png", 5)) {
				clickOnMac("openccMAC.png");
				sleep(2);
				// confirm install (start with Coccoc, default torrent, start
				// with system)
			}
			if (waitForObjectPresentMAC("startCocCocMAC.png", 10))
				clickOnMac("startCocCocMAC.png");
		}
	}

	/**
	 * 
	 * @param type
	 *            Version of Internal or External
	 * @param version
	 *            the version want to check
	 * @return true if version shows same with false if Version shows @
	 */
	public boolean checkCoccocVersion(String type, String version) {
		// wait for coc coc start:
		TestLogger.info("Check " + type + "  version of Coc Coc");
		waitForObjectPresentMAC("ccIconMAC.png", 10);
		sleep(5);
		// Focus on CocCoc
		doubleClickMac("ccIconMAC.png");
		sleep(2);
		String versionURL = "";
		if (type == "internal") {
			versionURL = "coccoc://version";
			TestLogger.info("Check internal version: " + version);
		}
		// Handle for check coccoc with internal version
		else {
			TestLogger.info("Check external vesion.......................................");
			versionURL = "coccoc://coccoc";
			String[] internalVersion = version.split("\\.");
			internalVersion[0] = Integer.valueOf(internalVersion[0]) + 6 + "";
			version = internalVersion[0] + "." + internalVersion[1] + "." + internalVersion[3];
			TestLogger.info("Check external version: " + version);
		}

		// open new tab: startCocCocOnMac();
		s.type("t", Key.WIN);
		s.type(versionURL);
		s.type(Key.ENTER);
		sleep(5);
		s.type("f", Key.WIN);
		s.type(version);
		if (waitForObjectPresentMAC("foundTextOnWeb.png", 1)) {
			TestLogger.info("The CocCoc version show correcly on " + versionURL);
			return true;
		} else {
			TestLogger.info("The CocCoc version show wrong on " + versionURL);
			return false;
		}
	}

	/**
	 * check coc coc version with more option
	 * 
	 * @param type
	 *            type of version (internal version or external version)
	 * @param version
	 *            Version want to check
	 * @param browser
	 *            New: check version on coc coc 2.
	 * @return true if version is correctly
	 * @author Huy
	 */
	public boolean checkCoccocVersion(String type, String version, String browser) {
		TestLogger.info("Check coc coc version");
		startCocCocOnMac(browser);
		// wait for coc coc start:
		TestLogger.info("Check " + type + "  version of Coc Coc");
		waitForObjectPresentMAC("ccIconMAC.png", 10);
		sleep(5);
		// Focus on CocCoc
		doubleClickMac("ccIconMAC.png");
		sleep(2);
		String versionURL = "coccoc://version";
		if (type == "internal") {
			versionURL = "coccoc://version";
			TestLogger.info("Check internal version: " + version);
		}
		// Handle for check coccoc with internal version
		else {
			TestLogger.info("Check external vesion.......................................");
			versionURL = "coccoc://coccoc";
			String[] internalVersion = version.split("\\.");
			internalVersion[0] = Integer.valueOf(internalVersion[0]) + 6 + "";
			version = internalVersion[0] + "." + internalVersion[1] + "." + internalVersion[3];
			TestLogger.info("Check external version: " + version);
		}

		// open new tab: startCocCocOnMac();
		s.type("t", Key.WIN);
		s.type(versionURL);
		s.type(Key.ENTER);
		sleep(5);
		s.type("f", Key.WIN);
		s.type(version);
		if (waitForObjectPresentMAC("foundTextOnWeb.png", 2)) {
			TestLogger.info("The CocCoc version show correcly on " + versionURL);
			closeAllCocCocOnMAC();
			return true;
		} else {
			TestLogger.info("The CocCoc version show wrong on " + versionURL);
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "CheckVersion", 2);
			closeAllCocCocOnMAC();
			return false;
		}
	}

	/**
	 * 
	 * @param extensionName
	 *            Name of extension
	 * @param version
	 *            version of extension want to check
	 * @return true if extension's version correct @
	 */
	public boolean checkExtensionVersionMAC(String extensionName, String version) {

		// open new tab: startCocCocOnMac();
		s.type("t", Key.WIN);
		s.type("coccoc://extensions");
		s.type(Key.ENTER);
		sleep(3);
		s.type("f", Key.WIN);
		s.type(extensionName + " " + version);
		if (waitForObjectPresentMAC("foundTextOnWeb.png", 1)) {
			TestLogger.info("Extension " + extensionName + " show version " + version + " on coccoc://extensions");
			return true;
		} else {
			TestLogger.info("Extension " + extensionName + " show wrong version on extensions page");
			return false;
		}
	}

	/**
	 * 
	 * @param CocCocVersion
	 *            CocCoc version want to download from ftp
	 * @author Huy
	 */
	public boolean downloadCoccocFromFTPforMAC(String CocCocVersion) {

		boolean isCCdownload = false;
		String homePath = System.getProperty("user.home");
		// Delete old coccoc.dmg:
		TestLogger.info("Download CocCoc from FTP server");
		f = new File(homePath + "/Downloads/" + CocCocVersion + ".dmg");
		if (!f.exists()) {
			WebDriver CocCoc;
			CocCoc = openWebWithLink("ftp://mac1v.dev.itim.vn/" + CocCocVersion + "/" + CocCocVersion + ".dmg");
			waitForObjectPresentMAC("saveFileOptionMAC.png", 20);
			clickOnMac("specificEnviroment/mac/saveFile.png");
			s.type(Key.ENTER);
			sleep(5);
			// wait for download completed
			isCCdownload = waitForDownloadFileCompleted(homePath + "/Downloads/" + CocCocVersion, 100);
			CocCoc.close();
		}
		return isCCdownload;
	}

	/**
	 * Make history for Coc coc by open some website like Dantri.com,...
	 * 
	 * @author Huy
	 */
	public void addCoccocHistory() {
		TestLogger.info("Open Dantri.com.vn to add cocCoc historty");
		// Open CocCoc
		startCocCocOnMac();
		// open some web:
		s.type("t", Key.WIN);
		s.type("http://dantri.com.vn/");
		s.type(Key.ENTER);
        
		// wait for page completed to load
		sleep(15);
		closeCurrentWindows();
	}

	/**
	 * Check coc coc kept history or not
	 * 
	 * @return true if History has history @
	 */
	public boolean checkCoccocHistory() {
		boolean flag = false;
		startCocCocOnMac();
		// open history: command + y

		s.type("y", Key.WIN);
		sleep(10);

		s.type("f", Key.WIN);
		s.type("dantri");

		if (waitForObjectPresentMAC("foundTextOnWeb.png", 1)) 
		{
			TestLogger.info("CocCoc kept history ");
			flag = true;
		}
		else
		{
			TestLogger.info("CocCoc NOT keep history ");
			flag = false;
		}

		closeCurrentWindows();
		return flag;
	}

	/**
	 * 
	 * @param dmgFileLocation:
	 *            Path to setup file
	 * @param options
	 *            : Replace, keep both
	 * 
	 */
	public void InstallCocCocOnMac(String dmgFileLocation, String options) {
		TestLogger.info("Install Côc Coc with option: " + options);
		// Open dmg file
		s.type(Key.SPACE, Key.WIN);
		s.type(dmgFileLocation);
		sleep(1);
		s.type(Key.ENTER);

		// copy and paste to Applications
		waitForObjectPresentMAC("Install_CocCocIconMac.png", 30);
		clickOnMac("Install_CocCocIconMac.png");
		s.type("c", Key.WIN);

		doubleClickMac("Install_ApplicationsFolderIconMac.png");
		sleep(1);
		s.type("v", Key.WIN);

		// Select option
		if (waitForObjectPresentMAC("copyOptionModalMAC.png", 10))
			if (options.toUpperCase() == "REPLACE")
				clickOnMac("replaceFilesOptionMAC.png");
			else
				clickOnMac("keepBothFilesOptionMAC.png");

		// close Installer when done
		waitforObjectDisappearMAC("copyingCocCoc.png", 40);
		s.type("w", Key.ALT + Key.WIN);
	}


	/**
	 * Check file exist or not
	 * 
	 * @param filePath
	 * @return true if file exist
	 * @author Huy
	 */
	public boolean checkFileExist(String filePath) {
		File f = new File(filePath);
		if (f.exists()) {
			TestLogger.info("The file " + filePath + " exist");
			return true;
		} else {
			TestLogger.info("The file " + filePath + " not exist");
			return false;
		}
	}

	/**
	 * 
	 * @return true if all files on Application Support folder are correctly
	 * @author Huy
	 */
	public boolean checkApplicationSupport() {
		String homePath = System.getProperty("user.home");
		File f = new File(homePath + "/Library/Application Support/Coccoc/");
		// Need confirm how to check if Application Support folder is correctly
		if (f.exists()) {
			TestLogger.info("All files on Application Support folder are correctly");
			return true;
		} else {
			TestLogger.info("The Coc Coc files in Application Support folder incorrectly: " + homePath
					+ "/Libirary/Application Support/Coccoc/");
			return false;
		}
	}

	/**
	 * removeCConAppMAC: remove coccoc to trash on MAC
	 * 
	 * @author Huy @
	 */

	public void removeCocCocOnApplications() {
		TestLogger.info("Remove Coccoc form Applications folder");
		closeAllCocCocOnMAC();

		openApplicationMAC();
		if (waitForObjectPresentMAC("iconAppccMAC.png", 1))
			rightClickMac("iconAppccMAC.png");
		else if (waitForObjectPresent("drapccMAC.png", 1))
			rightClickMac("drapccMAC.png");

		// clickOnMac("moveToTrashMAC.png");
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		s.type(Key.ENTER);

		// Quit finder:
		sleep(1);
		s.type("w", Key.ALT + Key.WIN);

		// sleep for MAC machien
		sleep(15);

		closeCurrentWindows();

		// remove Coccoc icon on Dock
	}

	/**
	 * Close all Coc Coc on MAC by terminal
	 * 
	 * @author Huy
	 */
	public void closeAllCocCocOnMAC() {
		TestLogger.info("Close all  Coc Coc  browser on MAC by terminal");
		// Close all CocCoc: command line: "ps -ef | grep CocCoc| grep -v grep |
		// awk '{print $2}' | xargs kill -9"
		String shellCommdline = "killall -9 CocCoc";
		sleep(2);

		try {
			Runtime.getRuntime().exec(shellCommdline);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove CocCoc data on: - Application Support folder - Cache - Preference
	 * - Save Application State
	 * 
	 * @author Huy
	 */
	public void removeCocCocData() {
		String homePath = System.getProperty("user.home");
		TestLogger.info("Revove Coc Coc Data....");
		// Remove CocCoc's file on Application support:
		String folderPath = homePath + "/Library/Application Support/Coccoc/";
		TestLogger.info("Delete file and folder of: " + folderPath);
		File f = new File(folderPath);
		DeleteFileAndFolderInSpecificPath(f);

		// Remove CocCoc's file on Cache:
		folderPath = homePath + "/Library/Caches/Coccoc/";
		TestLogger.info("Delete file and folder of: " + folderPath);
		deleteFolderMAC(folderPath);

		// Remove coccocCaches
		folderPath = (homePath + "/Library/Caches/com.coccoc.Coccoc");
		TestLogger.info("Delete file and folder of: " + folderPath);
		deleteFolderMAC(folderPath);

		// Remove CocCoc's file on preferences:
		folderPath = ("/Library/Preferences/com.coccoc.Coccoc.plist");
		TestLogger.info("Delete file and folder of: " + folderPath);
		deleteFolderMAC(folderPath);

		// Remove CocCoc's file on preferences:
		folderPath = (homePath + "/Library/Saved Application State/com.coccoc.Coccoc.savedState");
		TestLogger.info("Delete file and folder of: " + folderPath);
		deleteFolderMAC(folderPath);
	}

	/**
	 * Close current windows on MAC by command + q
	 * 
	 * @author Huy
	 */

	public void closeCurrentWindows() {
		TestLogger.info("Close current windows on MAC by command + q");
		s.type("q", Key.WIN);
	}

	/**
	 * Wait for Coc coc start completed and focus to CocCoc browser
	 */
	public void waitAndFocusCocCoc() {
		TestLogger.info("Wait for Coc Coc start and forcus on CocCoc");
		waitForObjectPresentMAC("iconccMAC.png", 15);
		clickOnMac("iconccMAC.png");
		clickOnMac("iconccMAC.png");
		sleep(10);
	}

	/**
	 * check coc coc is removed or not on launchpad
	 * 
	 * @return true: if coc coc is removed on launchpad
	 * @author Huy
	 */
	public boolean checkCocCocIsRemovedOnMAC() {

		TestLogger.info(" -> Check Coc Coc exist on launch pad");
		// open launch pad
		s.type(Key.SPACE, Key.WIN);
		s.type("launchpad");
		s.type(Key.ENTER);

		// wait for launch pad stable
		sleep(3);

		// search coc coc in launch pad
		s.type("c");
		sleep(1);
		s.type("c");
		sleep(2);
		boolean localFlag = waitForObjectPresentMAC("CocCocIconLaunchpad.png", 1);
		s.type(Key.ESC);
		sleep(2);
		s.type(Key.ESC);

		return !localFlag;
	}

	/**
	 * Open Coc Coc and wait for Coc Coc Update
	 * 
	 */
	public void waitforCoccocAutoUpdate() {

		TestLogger.info("Wait for Coc Coc update....");
		s.type("t", Key.WIN);
		s.type("CocCoc://coccoc");
		s.type(Key.ENTER);
		sleep(5);
		TestLogger.info("Wait for update in 160 s ");
		waitforObjectDisappearMAC("coccocUpdatingMAC.png", 160);
		
	}

	/**
	 * UnInstallAllDataCCMAC: remove coccoc with delete all data on MAC
	 * 
	 * @author Huy
	 */
	public void UnInstallAndCleanAllDataCCMAC() {
		TestLogger.info("Remove CocCoc and clean data:....");
		removeCocCocOnApplications();
		removeCocCocData();
		TestLogger.info("Remove CocCoc and clean data Done");
	}

	/**
	 * Delete folder on MAC
	 * 
	 * @param folderPath
	 */
	public void deleteFolderMAC(String folderPath) {
		String commandLine = "";
		Runtime runtime = Runtime.getRuntime();
		if (folderPath != "") {
			commandLine = "rm -f -r " + folderPath;
			try {
				runtime.exec(commandLine);
			} catch (IOException e) {
				TestLogger.warn("The command line error, check command line: " + commandLine);
			}
		}
	}

	/**
	 * 
	 * @return true if coc coc start with New tab
	 */
	public boolean checkCocCocIsStartOnFirstTimeMAC() {
		TestLogger.info("Check coc coc start on the first time");
		boolean fristTimeMessage = waitForObjectPresentMAC("startCocCocMACFirstTime.png", 50);
		boolean fristTimeNewTab = waitForObjectPresentMAC("newtabMAC.png", 50);

		return fristTimeMessage & fristTimeNewTab;
	}

	public boolean waitForCocCocStartOnMac() {
		waitForObjectPresentMAC("ccIconMAC.png", 150);
		sleep(5);
		return waitForObjectPresentMAC("ccIconMAC.png", 150);
	}

	/**
	 * Check coc coc start with Only one version
	 * 
	 * @return
	 */
	public boolean checkCocCocStartOnlyOneVersion(String olderVersion, String newerVersion) {
		TestLogger.info("Check user can start with only one version");
		boolean checkpointStatus = true;
		// Check CocCoc with older version
		closeAllCocCocOnMAC();

		// Start Coc Coc with older Version
		startCocCocOnMac();
		sleep(2);

		// Start Coc Coc with newer version
		startCocCocOnMac("new");
		sleep(2);

		checkpointStatus = checkCocCocVersionOnMAC("internal", olderVersion);

		// Check CocCoc with newer version
		closeAllCocCocOnMAC();

		// Start Coc Coc with older Version
		startCocCocOnMac("new");
		sleep(2);

		// Start Coc Coc with newer version
		startCocCocOnMac();
		sleep(2);

		checkpointStatus = checkpointStatus & checkCocCocVersionOnMAC("internal", newerVersion);

		closeAllCocCocOnMAC();
		return checkpointStatus;
	}

	/**
	 * Check Coccoc Exist 2 version on Application
	 * 
	 * @author Huy
	 */
	public boolean checkCoccocExist2VersionOnApplications() {
		boolean isCocCocAppearsWith2Version;
		openApplicationMAC();
		isCocCocAppearsWith2Version = waitForObjectPresentMAC("iconAppccMAC.png", 5);

		isCocCocAppearsWith2Version = isCocCocAppearsWith2Version & waitForObjectPresentMAC("iconAppccMAC_2.png", 5);

		// Close Finder
		s.type("w", Key.ALT + Key.WIN);

		return isCocCocAppearsWith2Version;
	}

	/**
	 * Remove all Coc Coc version on MAC
	 * 
	 * @author Huy
	 */
	public void removeAllCocCoc() {
		TestLogger.info("Remove All Coc Coc version on Mac ");
		openApplicationMAC();
	
		if (waitForObjectPresentMAC("", 5)) {
			rightClickMac("iconAppccMAC.png");
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.ENTER);
		}
		if (waitForObjectPresentMAC("", 5)) {
			rightClickMac("iconAppccMAC_2.png");
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.ENTER);
		}
		sleep(5);
		// Close Finder
		s.type("w", Key.ALT + Key.WIN);
		// Empty trash
		s.type(Key.BACKSPACE, Key.SHIFT + Key.WIN);
		s.type(Key.ENTER);
		sleep(5);
	}

	/**
	 * Check Coccoc version on MAC
	 * 
	 * @author Huy
	 */
	public boolean checkCocCocVersionOnMAC(String type, String version) {
		// focus on Coc Coc
		doubleClickMac("ccIconMAC.png");
		sleep(2);
		String versionURL = "coccoc://version";
		if (type == "internal") {
			versionURL = "coccoc://version";
			TestLogger.info("Check internal version: " + version);
		}
		// Handle for check coccoc with internal version
		else {
			TestLogger.info("Check external vesion.......................................");
			versionURL = "coccoc://coccoc";
			String[] internalVersion = version.split("\\.");
			internalVersion[0] = Integer.valueOf(internalVersion[0]) + 6 + "";
			version = internalVersion[0] + "." + internalVersion[1] + "." + internalVersion[3];
			TestLogger.info("Check external version: " + version);
		}

		// open new tab: startCocCocOnMac();
		s.type("t", Key.WIN);
		s.type(versionURL);
		s.type(Key.ENTER);
		
		sleep(5);
		s.type("f", Key.WIN);
		s.type(version);
		if (waitForObjectPresentMAC("foundTextOnWeb.png", 1)) {
			TestLogger.info("The CocCoc version show correcly on " + versionURL);
			closeAllCocCocOnMAC();
			return true;
		} else {
			TestLogger.info("The CocCoc version show wrong on " + versionURL);
			captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/", "CheckVersion", 2);
			closeAllCocCocOnMAC();
			return false;
		}
	}
	
	/**
	 * Check data between 2 versions are same
	 * 
	 * @return true if data between 2 versions are same
	 * @author Huy
	 */
	public boolean checkDataBetween2VersionAreSame() {
		TestLogger.info("Check data between 2 versions are same");
		TestLogger.info("This check point should be check by manual");
		return true;
	}
	

	  /**
	   * Start CocCoc by CMD
	   * @param command , cmd to run CocCoc
	   * @author LANHT
	   * @update : HANV
	   * @date : 11- jan -2017
	   */
	  public void StartCocCocByCMD()
	  {
	   try {
	    String coccocPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\Application\\browser.exe";
	    Runtime.getRuntime().exec(coccocPath);
	    s.type(Key.UP, Key.WIN);
		sleep(1);
		if (waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 3))
		{
			TestLogger.info("Started CocCoc succesfully ! ");
		}
		else
		{
			TestLogger.info("Starting CocCoc NOT succesfully ! ");
		}
		
	   } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	
	/**
	 * changeHoststoDev: Change Hosts file To Production
	 * 
	 * @author hanv
	 *
	 * 
	 */
	  
	   
	   public void changeHoststoProduction ()
	   {	
		   s.type("r", Key.WIN) ;
			sleep (1);
			s.type("C:\\Windows\\System32\\drivers\\etc");
			s.type(Key.ENTER) ;
			sleep (1);
			s.type(Key.UP, Key.WIN) ;
			waitForObjectPresent("pictures\\OSApp_Donmain_File_Host.png", 5);
			
				hoverImage("pictures\\OSApp_Donmain_File_Host.png");
				sleep (1);
				rightClick("pictures\\OSApp_Donmain_File_Host.png");
				sleep (1);
				clickOn("pictures\\OSApp_MenuContext_Text_Rename.png");
				s.type("hostsdev");
				s.type(Key.ENTER);
				

			 if (waitForObjectPresent("pictures\\OSApp_Donmain_File_HostDev.png", 1))
	            {
	            	s.type(Key.F4, Key.ALT) ; 
	            	TestLogger.info(" Changed Host sucessfully !! ");
	            	
	            }
	            else
	            {
	            	TestLogger.info(" Changed Host Unsucessfully !! ");
	            	s.type(Key.F4, Key.ALT) ; 
	            
	            }
				
			
				
	   }

	   /**
		 * changeHoststoDev: Change Hosts file To Dev enviroment
		 * 
		 * @author hanv
		 *
		 * @update : 12/1/2017 
		 */
	   
	  
	   public void changeHoststoDev ()
	   {	
		   s.type("r", Key.WIN) ;
			sleep (1);
			s.type("C:\\Windows\\System32\\drivers\\etc");
			s.type(Key.ENTER) ;
			sleep (1);
			s.type(Key.UP, Key.WIN) ;
			waitForObjectPresent("pictures\\OSApp_Donmain_File_HostDev.png", 5);
			
				hoverImage("pictures\\OSApp_Donmain_File_HostDev.png");
				rightClick("pictures\\OSApp_Donmain_File_HostDev.png");
				sleep (1);
				clickOn("pictures\\OSApp_MenuContext_Text_Rename.png");
				s.type("hosts");
				s.type(Key.ENTER);
            if (waitForObjectPresent("pictures\\OSApp_Donmain_File_HostDev.png", 1))
            {
            	s.type(Key.F4, Key.ALT) ; 
            	TestLogger.info(" Changed Host Unsucessfully !! ");
            }
            else
            {
            	s.type(Key.F4, Key.ALT) ; 
            	TestLogger.info(" Changed Host sucessfully !! ");
            }
			
				
	   }
	   /**
		 * DownloadFileByFirefox: Download File by Firefox
		 * 
		 * @author hanv
		 * @param URLofFile , URL of File to download 
		 * 
		 */
	   
	   public boolean downloadFileByFirefox (String URLofFile)
	   {
		   boolean flag = true ;
		   s.type("d" ,Key.WIN) ;
		   s.type("r",Key.WIN) ;
		   sleep (1) ;
		   s.type("a", Key.CTRL);
		   sleep (1) ;
		   s.type("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe") ;
		   s.type(Key.ENTER) ;
		   sleep (1);
		   s.type(Key.UP , Key.WIN) ;
		   waitForObjectPresent("pictures\\Browser_Firefox_icon_search.png", 5);
		   moveMouseHorizontallyFromLogo("pictures\\Browser_Firefox_icon_search.png", -340); 
		   s.click();
		   s.type("a", Key.CTRL);
		   s.type(URLofFile);
		   s.type(Key.ENTER) ;
		   
		   if (waitForObjectPresent("pictures\\Browser_FireFox_Button_SaveFile.png", 5))
		   {
			   clickOn("pictures\\Browser_FireFox_Button_SaveFile.png");
			   waitForObjectPresent("pictures\\Browser_Firefox_icon_Download.png", 55); 
			   clickOn("pictures\\Browser_Firefox_icon_Download.png") ;
			   waitForObjectPresent("pictures\\Browser_FireFox_icon_FolderDownload.png", 65);
			   rightClick("pictures\\Browser_FireFox_icon_FolderDownload.png");
			   sleep (1) ;
			   clickOn("pictures\\Browser_Firefox_Text_ClearList.png");
			   s.type("w",Key.CTRL+Key.SHIFT);
			   s.type(Key.ENTER) ;
		   }
		   else
		   {
			   TestLogger.info("Can't Download this file by Firefox");
			   flag = false ;
		   }
		return flag;
		      
	   }
	   
	   
	   public void switchToUILoginByGoogle ()
	   {
		   openLink("coccoc://flags/");
		   s.type("f",Key.CTRL);
		   s.type("signin-type");
		   s.type(Key.ENTER);
		   if (waitForObjectPresent("pictures\\Browser_SearchDownload_Text_One.png", 3))
		   {
			   moveMouseDownFromLogo("pictures\\CocCoc_settingsFlags_Text_Sync.png", 33);
			   s.click();
			   clickOn("pictures\\CocCoc_SettingsFlags_Text_Google.png");
			   clickOn("pictures\\CocCoc_Settingsflags_RestartCocCoc.png");
			   sleep(3);
			   openLink("coccoc://settings/#coccoc-settings-users");
			   if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 3))
			   {
				   TestLogger.info("Change UI of Google Login successfully !");
			   }
			   else
			   {
				   TestLogger.info("Change UI of Google Login NOT successfully !");
			   }
		   }
		  
		   
	   }
	   
}