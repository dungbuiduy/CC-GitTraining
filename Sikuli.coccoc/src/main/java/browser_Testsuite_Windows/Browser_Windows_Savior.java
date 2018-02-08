package browser_Testsuite_Windows;

import java.io.File;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.TestLogger;

public class Browser_Windows_Savior extends BrowserCommon_Extensions{
	
	private boolean continueExcute = true;
	String mediaInfo[] = setMediaFileInfo();
	String userprofile = System.getenv("USERPROFILE");
	String pathtoFile = userprofile + "\\Downloads\\The Piano Guys - Love Story (Taylor Swift).mp4"; 
	String pathtoFilemp3 = userprofile + "\\Download\\MukBang Những Người Đang Đói Không Lên Xem Một Mình Ăn Hết 1 Con Gà 3KG.mp3" ;
	//---------------------------------------------------------------------------------------------------------------------------------------
	// Pre-condition
	//---------------------------------------------------------------------------------------------------------------------------------------
	//@BeforeClass
	public void beforTestSavior(){
		TestLogger.info("-------------------------Precondition--------------------");
		if(DownloadCCBrowser("coccoc.com")){
			UninstallAndClearAllData("");
			String userprofile = System.getenv("USERPROFILE");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		}
		else{
			setTestcaseStatus("SKIP", "Failed to download CocCoc installer, skipp all test");
		}
	}
	//@BeforeMethod
	public void prepareEnvironment(){
		cleanResouces("");
		clearDownloadPage();
	}
	
	@AfterMethod
	public void cleanEnvironment(){
		
		clearDownloads();
		closeBrowser();
		//cleanResouces("");
	}
	//---------------------------------------------------------------------------------------------------------------------------------------
	// Test case
	//---------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_01: Check default status of Savior extension on browser</br>
	 * <b> CaseTitle: </b>Check default status of Savior extension on browser</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu -> Tien ich mo rong
	 * <b> ExpectedOutput: </b></br>
	 * 1. Savior extension display in the list of extensions
	 * 2. Savior is in turn on status
	 * 3. Option allow in private tab in  is checked
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test(groups = { "Primary" })
	public void Browser_SNIFF_Savior_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_01: Check default status of Savior extension on browser");
		//clearDownloadPage();
		openExtensionsPage();
		
		if(checkExtensionStatus("Savior", "enable"))
			setTestcaseStatus("PASSED", "Default status of Savior is in Enable");
		else
			setTestcaseStatus("FAILED", "Default status of Savior not in Enable, pls check!");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_02: Check status of Savior after being turned off</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu > tien ic mo rong
	 * 2. Un-check the check box "Da Bat"
	 * 3. Open 1 new tab, access any page having music, video can be downloaded
	 * 4. Close the browser and restart it, access to page before"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Savior doesn't display in toolbar
	 * 2. After restarted, access to any page having download music, movie, video => Savior doesn't display in browser toolbar
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_02: Check status of Savior after being turned off");
		
		openExtensionsPage();
		changeExtensionStatus("Savior", "Disable");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		
		if(accessWebAndPlayVideo(mediaInfo[1])){
			if(checkSaviorIcon("Disapears") == false )
			{

				setTestcaseStatus("PASSED", "Savior icon disappears on omnibox");
			}
			else
			{
				
				setTestcaseStatus("FAILED", "Savior icon still appears on omnibox");
			}
		}
		else
			setTestcaseStatus("SKIP", "Cannot open and play video, Skip this checkpoint");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_03: Check status of Savior after being turned off, then turned on again</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu > tien ic mo rong
	 * 2. Check the check box "Da Bat"
	 * 3. Close and restart browser
	 * 4. Go to extensions page to turn on Savior
	 * 5. Open 1 new tab, access any page having music, movie, video can be downloaded
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Savior doesn't display in toolbar
	 * 2. After restarted, access to any page having download music, movie, video => Savior display in browser Omnibox
	 * 3. Can download normaly
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 07 Jun -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_03: Check status of Savior after being turned off, then turned on again");
		//1. After turning off, Savior will not display in the toolbar -> check on testcase 2
		
		openExtensionsPage();
		changeExtensionStatus("Savior", "Enable");
		
		if(accessWebAndPlayVideo(mediaInfo[1])){
			if(checkSaviorIcon("appears")){
				setTestcaseStatus("PASSED", "Savior icon appears on omnibox");
				downloadMediaContentOnYoutube();
				if(checkFileDownloadWell("HD"))
					setTestcaseStatus("PASSED", "Savior can download music/movies/video file normally");
				else
					setTestcaseStatus("FAILED", "Savior has problem for download media content");
			}
			else
				setTestcaseStatus("FAILED", "Savior icon still disappears on omnibox");
		}
		else
			setTestcaseStatus("Skiped", "Cannot open and play video, Skip this checkpoint");
	}
		
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_04:Check status of Savior on incognito window without choosing extension option: 'Allow in incognito mode'"</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu > tien ic mo rong > 
	 * 2. un-check on Allow in incognito mode
	 * 3. Close and restart browser
	 * 4. Open new tab on incognito mode
	 * 5. Access website has music, movies... can be play
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Savior doesn't display in toolbar
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_04: Check status of Savior on incognito window without choosing extension option: 'Allow in incognito mode'");
		//delete old user Data
		//clearDownloadPage();

		openExtensionsPage();
		clickOnRegion("pictures\\Browser_ExtensionPage__icon_Savior.png", "pictures\\Browser_SetingsSavior_Checkbox_AlowIncognito.png",80, 122);
		//open incognio tab
		s.type(Key.F4, Key.ALT);
		sleep(1);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("n", Key.CTRL + Key.SHIFT);
		
		if(accessWebAndPlayVideo(mediaInfo[1])){
			if(checkSaviorIconInIncognitoMode("Disapears"))
			{
				closeBrowser();
				setTestcaseStatus("PASSED", "Savior not work in incognito mode");
			}
			else
			{
				closeBrowser();
				setTestcaseStatus("FAILED", "Savior icon still appears on omnibox");
			}
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("SKIP", "Cannot open and play video, Skip this checkpoint");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_05: Check status of Savior on incognito window after tick onto extension option: Allow in incognito mode"</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu > tien ic mo rong > 
	 * 2. check on Allow in incognito mode
	 * 3. Close and restart browser
	 * 4. Open new tab on incognito mode
	 * 5. Access website has music, movies... can be play
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 2. After restarted, access to any page having download music, movie, video => Savior can display in browser toolbar and download video
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_05(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_05: Check status of Savior on incognito window after tick onto extension option: Allow in incognito mode");
		//clearDownloadPage();
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_ExtensionPage__icon_Savior.png", "pictures\\Browser_SetingsSavior_Checkbox_DenyIncognito.png",80, 122);

		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		sleep(1);
		startCocCoc();
		//open incognio tab
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (0.5);
		s.type("n", Key.CTRL + Key.SHIFT);
		if(accessWebAndPlayVideo(mediaInfo[1])){
			if(checkSaviorIconInIncognitoMode("appears")){
				closeBrowser();
				setTestcaseStatus("PASSED", "Savior is enabled in incognito mode");
			}
			else
			{
				closeBrowser();
				killprocess("browser.exe");
				setTestcaseStatus("FAILED", "Savior icon still disappears on omnibox");
			}
		}
		else
		{
			closeBrowser();
			killprocess("browser.exe");
			setTestcaseStatus("SKIPED", "Cannot open and play video, Skip this checkpoint");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_06: Check changing default value of option "Download in one click"</br>
	 * <b> CaseTitle: </b>Check changing default value of option "Download in one click"</br>
	 * <b> Steps: </b></br>
	 *1. Browser menu> Công Cụ> Tiện ích mở rộng
      2. Click on "Tùy chọn"
      3. Change default value in "tải xuống sau 1 cú nhấp chuột"
      4. Change default value in "Chất lượng phương tiện ưa thích"
	 *
	 * <b> ExpectedOutput: </b></br>
	 *1. Default value of "tải xuống sau 1 cú nhấp chuột" is unchecked (not selected)
      2. After changing default value, access some page to download file video: 
=> only need to click on Savior icon, the download will start right away, no download pop-up displayed
      3. Downloaded file has size as selected in "Chất lượng phương tiện ưa thích"
	 * @author huy.vu
	 * @Update HANV
	 *
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_06(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_06: Check changing default value of option 'Download in one click'");
		
		//clearDownloadPage();
		boolean isFileDownloadWell;
		//startCocCoc();
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
		sleep(1);
		if(waitForObjectPresent("pictures\\Browser_Savior_Checkbox_UncheckedOptionDownloadByOneClick.png", 5)){
			setTestcaseStatus("PASSED" , "Default value of download by one click is uncheck");
			clickOn("pictures\\Browser_Savior_Checkbox_UncheckedOptionDownloadByOneClick.png");
			sleep(1);
			clickOn("pictures\\Browser_Savior_Button_SaveAndCloseSetting.png");
			s.type(Key.F4,Key.ALT);
			startCocCoc();
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			accessWebAndPlayVideo(mediaInfo[1]);
			sleep(1);
			waitForObjectPresent("pictures\\Browser_Savior_button_downloadMedia.png", 30);
			sleep(1);
			//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
			
			//wait for download done
			waitForCocCocDownloadCompleted();
			
			isFileDownloadWell = checkFileDownloadWell("HD");
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Checkbox_CheckedOptionDownloadByOneClick.png");
			sleep(1);
			clickOn("pictures\\Browser_Savior_Button_SaveAndCloseSetting.png");
			
			if(isFileDownloadWell)
			{
				
				setTestcaseStatus("PASSED", "Savior can download music/movies/video file by one clicked");
			}
			else
			{
				setTestcaseStatus("FAILED", "Savior has problem for download media content");
			}
		}
		else
			setTestcaseStatus("SKIPED", "Cannot open Savior option");
	}
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_08: Check changing default value of option: 'Ignore streams smaller than:'</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Browser menu> Cong cu > tien ic mo rong
	 * 2. Select Options
	 * 3. Change value of 'ignore stream less than'
	 * 4. Access website has music, movies... can be play -> download media
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Savior doesn't display in toolbar
	 * 2. After restarted, access to any page having download music, movie, video => Savior doesn't display in browser toolbar
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 07 Jun -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_08(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_08: Check changing default value of option: 'Ignore streams smaller than:'");
		TestLogger.warn("Wait for confirm about streams smaller than...");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_09: Check quality and type of file download with Savior</br>
	 * <b> CaseTitle: </b>Check status of Savior after being turned off</br>
	 * <b> Steps: </b></br>
	 * 1. Access website has music, movies... can be play -> download media
	 * 2. Download media by click on Savior icon at right of Omnibox
	 * 3. Select file size download
	 * 4. Compare File
	 * 5. Open media file
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. File name, size, type, quality must the same as value in Savior before Download
	 * 2. Check sound and video quality
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_09(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info(" Browser_SNIFF_Savior_09: Check quality and type of file download with Savior");
		if(continueExcute){
			//clearDownloadPage();
			startCocCoc();
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			accessWebAndPlayVideo(mediaInfo[1]);
			sleep(5);
			waitForObjectPresent("pictures\\Browser_Savior_button_downloadMedia.png", 30);
			clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
			waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 30);
			clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
			sleep(5);
			waitForCocCocDownloadCompleted();
			
			if(checkFileDownloadWell("HD"))
				setTestcaseStatus("PASSED", "Savior can download video which quality and type of file download same with download by other downloader");
			else
				setTestcaseStatus("FAILED", "Savior has problem for download media content");
		}
		else
			setTestcaseStatus("SKIPED", "Skip this test case due pre-condition failed");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_10: Check downloading a media file when choosing option 'Download in one click'</br>
	 * <b> CaseTitle: </b>Check downloading a media file when choosing option 'Download in one click'</br>
	 * <b> Steps: </b></br>
	 * 1. Access web site has music, movies... can be play -> download media
	 * 2. Download media by click on Savior icon at right of Omnibox
	 * 3. Select file size download
	 * 4. Compare File
	 * 5. Open media file
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. After one click on Savior icon, file will be downloaded automatically to local without selecting in download pop-ups
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 07 Jun -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_10(){
		if(continueExcute){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_10: Check downloading a media file when choosing option 'Download in one click'");
		TestLogger.info("Marge with test case _03 and _06");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_11: Check the display of file name and number of file on Savior pop-up window in comparison with files running on a webpage</br>
	 * <b> CaseTitle: </b>Check the display of file name and number of file on Savior pop-up window in comparison with files running on a webpage</br>
	 * <b> Steps: </b></br>
	 * 1. Access web site has music, movies... can be play -> download media
	 * 2. Click on Savior icon and compare file name/quantity in the pop-up and web site
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. In Savior pop-up, filename displays correctly
	 * 2. In Savior pop-up, number of downloadable files must be the same in the web site
	 * @author huy.vu
	 * @UPDATE HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_11(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_11: Check the display of file name and number of file on Savior pop-up window in comparison with files running on a webpage");
		
		//saviorOption_DisplayPIP
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		accessWebAndPlayVideo(mediaInfo[1]);
		sleep(1);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_DownloadListThePianoGuys.png", 20))
			setTestcaseStatus("PASSED", "In Savior pop-up, filename displays correctly and number of downloadable files same in the web site");
		else
			setTestcaseStatus("FAILED", "In Savior pop-up, filename displays not correctly and number of downloadable files not the same in the web site");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_12</br>
	 * <b> CaseTitle: </b>Check enable/disable download controls on media player</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions/
	 * 2. Observe option Show download button near downloadable media
	 * 3. Uncheck the option
	 * 4. Open media link and hover on media player area
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. By default after the browser installation, option is checked
	 * 2. When disabled the download controls will not show when hovering on media player
	 * @author huy.vu
	 * @Update:  HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_12(){
		if(continueExcute){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_12: Check enable/disable download controls on media player");

		openExtensionsPage();
		clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Checkbox_DisplayDownloadNextToDownloadableFile.png", 2)){
			setTestcaseStatus("PASSED", "By default after the browser installation, option is checked");
			clickOn("pictures\\Browser_Savior_Checkbox_DisplayDownloadNextToDownloadableFile.png");
			accessWebAndPlayVideo(mediaInfo[1]);
			sleep(1);
			if(!waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadButton.png", 2))
			{
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
				clickOn("pictures\\Browser_Savior_Checkbox_DisplayDownloadNextToDownloadableFile.png");
				setTestcaseStatus("PASSED", "When disabled the download controls not show when hovering on media player");
			}
			else
			{
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
				clickOn("pictures\\Browser_Savior_Checkbox_DisplayDownloadNextToDownloadableFile.png");
				setTestcaseStatus("FAILED", "When disabled the download controls still show when hovering on media player");
			}
		}
		else
		{
			
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Checkbox_DisplayDownloadNextToDownloadableFile.png");
			setTestcaseStatus("FAILED", "By default after the browser installation, option is  unchecked");
		}
    }
}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_13</br>
	 * <b> CaseTitle: </b>Check if "Remember last chosen quality" is ON</br>
	 * <b> Steps: </b></br>
	 * 1. Select coccoc://extensions, Savior > Option (or right click on Savior icon)
	 * 2. Select preferred media quality as High, Medium or Low
	 * 3. Select option "Remember last chosen quality"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Last selected preferred media will be saved even when user choosing download file with different file format from download pop-up
	 * @author huy.vu
	 * @UPDATE HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_13(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_13: Check if 'Remember last chosen quality' is ON");
		
		openExtensionsPage();
		
		clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
		clickOn("pictures\\Browser_Savior_Option_lowQuality.png");
		clickOn("pictures\\Browser_Savior_Button_SaveAndClose.png");
		accessWebAndPlayVideo(mediaInfo[1]);
		sleep(1);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_DownloadList_low.png", 5))
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Option_HighQuality.png");
			clickOn("pictures\\Browser_Savior_Button_SaveAndClose.png");
			setTestcaseStatus("PASSED", "Last selected preferred media will be saved even when user choosing download file with different file format from download pop-up");}
		
		else
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Option_HighQuality.png");
			clickOn("pictures\\Browser_Savior_Button_SaveAndClose.png");
			setTestcaseStatus("FAILED", "Last selected preferred media will NOT saved even when user choosing download file with different file format from download pop-up");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_14</br>
	 * <b> CaseTitle: </b>Check if "Remember last chosen quality" is OFF</br>
	 * <b> Steps: </b></br>
	 * 1. Select chrome://extensions, Savior > Option (or right click on Savior icon)
	 * 2. Select preferred media quality as High, Medium or Low
	 * 3. Deselect option "Remember last chosen quality"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Last selected preferred media will be saved even when user choosing download file with different file format from download pop-up
	 * @author huy.vu
	 * @date 07 Jun -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_14(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_14: Check if 'Remember last chosen quality' is OFF");
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
		
		//make sure that the option 'remember last quality' is checked
		if((waitForObjectPresent("pictures\\Browser_Savior_Checkbox_CheckedOptionRememberLastDownloadQuality.png", 5))){
			clickOn("pictures\\Browser_Savior_Checkbox_UncheckedOptionRememberLastDownloadQuality.png");
			sleep(2);
		}
		
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		openLink("https://www.youtube.com/watch?v=NPzAFTs4jHU");
	    sleep (3);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_DownloadListThePianoGuys.png", 9))
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Checkbox_UncheckedOptionRememberLastDownloadQuality.png");
			clickOn("pictures\\Browser_Savior_Button_SaveAndClose.png");
			setTestcaseStatus("PASSED", "Last selected preferred media save even when user choosing download file with different file format from download pop-up");
		}
		else
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_ExtensionPage_icon_Savior.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550, 120);
			clickOn("pictures\\Browser_Savior_Checkbox_UncheckedOptionRememberLastDownloadQuality.png");
			clickOn("pictures\\Browser_Savior_Button_SaveAndClose.png"); 
			setTestcaseStatus("FAILED", "Last selected preferred media not save even when user choosing download file with different file format from download pop-up");
		}
	}

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_15</br>
	 * <b> CaseTitle: </b>Default state when hovering on media player</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Hover on media player area
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Download button displays with prefered quality as 'hight'
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_15(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_15: Default state when hovering on media player");

		openExtensionsPage();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
	
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		openLink("https://www.youtube.com/watch?v=NPzAFTs4jHU");
		sleep(6);
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -220);
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_HightQuality.png", 3))
		{
			
			setTestcaseStatus("PASSED", " Download button displays with prefered quality as 'hight'");
		}
		else
		{
			
			setTestcaseStatus("FAILED", " Download button does NOT displays with prefered quality as 'hight'");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_16</br>
	 * <b> CaseTitle: </b>Check when clicking on Download button</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Hover on media player area
	 * 3. Click on Download button
	 * <b> ExpectedOutput: </b></br>
	 * File is downloaded successfully with default quality as high
	 * @author HANV
	 * @date 08 Mar -2017
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_16(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_16: Check when clicking on Download button");
		startCocCoc();
		openLink("https://www.youtube.com/watch?v=NPzAFTs4jHU");
		sleep(5);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png"); 
		
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_DownloadListThePianoGuys.png", 5))
		{
			waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideoOption.png", 15);
			clickOn("pictures\\Browser_Savior_Button_DownloadOnVideoOption.png"); 
			waitForCocCocDownloadCompleted();
			
			File fileDownload = new File (pathtoFile) ; 
			
			if (fileDownload.exists() && (fileDownload.isFile()))
			{
				TestLogger.info("==> " + fileDownload.length());
				
				if (fileDownload.length()== 49968422)
				{
					setTestcaseStatus("PASSED", "Download button displays with prefered quality as 'hight'");
				}
				else
				{
					setTestcaseStatus("FAILED", "Download button displays with prefered quality not as 'hight'");
				}
			}
			
		}
			
		else
			
		{
			setTestcaseStatus("FAILED", "Button Download button DOES NOT displays with prefered quality not as 'hight'");
		}
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_17</br>
	 * <b> CaseTitle: </b>Check download with different file formats</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Hover on media player area
	 * 3. Select different file format if available
	 * 4. Download with selected file format
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 3. File size is loaded when user selects different formats
	 * 4. File is downloaded successfully with selected format
	 * @author huy.vu
	 * @Update : HANV
	 */
	
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_17(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_17: Check download with different file formats");
		startCocCoc();
		openLink("https://www.youtube.com/watch?v=NPzAFTs4jHU");
		sleep(5);
		
		selectQualityVideoToDownload("small");
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png",360);
		
		if(checkFileDownloadWell("small"))
			setTestcaseStatus("PASSED", "File size and file format are downloaded when user selects different formats");
		else
			setTestcaseStatus("FAILED", "File size and file format are downloaded when user selects not different formats");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_18</br>
	 * <b> CaseTitle: </bCheck next time access state</br>
	 * <b> Steps: </b></br>
	 * 1. Hover on media player area after selecting other file formats than default quality as above case
	 *
	 * <b> ExpectedOutput: </b></br>
	 * 1. Last selected file format, file size (if available) will display
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_18(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_18: Check next time access state");
		boolean isNextAccessStateCorrect = true;
		startCocCoc();
		
		accessWebAndPlayVideo(mediaInfo[1]);
		 /*
		selectQualityVideoToDownload("FullHD");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFullHDFile01.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for FullHD");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for FullHD");
			isNextAccessStateCorrect = false;
		}
		*/
	   
		selectQualityVideoToDownload("HD");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFullHDFile02.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for HD");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for HD");
			isNextAccessStateCorrect = false;
		}
		
		
		/*selectQualityVideoToDownload("Standard");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadStandardFile03.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for Standard");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for Standard");
			isNextAccessStateCorrect = false;
		}*/
		
		selectQualityVideoToDownload("Medium");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadMediumFile04.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for Medium");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for Medium");
			isNextAccessStateCorrect = false;
		}
		/*selectQualityVideoToDownload("small");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadSmallFile05.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for Small");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for Small");
			isNextAccessStateCorrect = false;
		}*/
		/*selectQualityVideoToDownload("mobile");
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadMobileFile06.png", 10)){
			setTestcaseStatus("PASSED", "Last selected file format, file size display correctly for mobile");
		}
		else{
			TestLogger.warn("Last selected file format, file size display incorrectly for mobile");
			isNextAccessStateCorrect = false;
		}
		*/
		if(!isNextAccessStateCorrect)
			setTestcaseStatus("FAILED", "File size display wrong with some qualities");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_19</br>
	 * <b> CaseTitle: </bCheck if file can be download only one time</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be downloaded
	 * 2. Hover on media player area
	 * 3. Click on Download button
	 * 4. When completed, click again to download
	 *
	 * <b> ExpectedOutput: </b></br>Nothing happens, file can be download once
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_19(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_19: Check if file can be download only one time");
		startCocCoc();
		clearDownloads();
		accessWebAndPlayVideo(mediaInfo[1]);
		sleep(2);
		//download second time
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -180);
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 10)){
			clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
			waitForObjectPresent("pictures\\Browser_Savior_Icon_DownloadProcessDone.png", 68);
			moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -180);
			clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
			s.type("j", Key.CTRL);
			sleep (3);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type("f", Key.CTRL);
			s.type("piano");
			 if (waitForObjectPresent("pictures\\Browser_SearchPage_Text_SearchResultOfBrowserVersion.png", 3))
				
				setTestcaseStatus("PASSED", " file can be download only one time");
			else
				setTestcaseStatus("PASSED", "File can be download more one time");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_20</br>
	 * <b> CaseTitle: </b>Check the synchronization between 2 download buttons at default state</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Click on Savior icon next to the address bar, select different qualities (High, Medium, Low)
	 * 3. Hover on media player area
	 *
	 * <b> ExpectedOutput: </b></br>Quality selected is same as selected in Savior
	 * @author huy.vu
	 * @date 13 Jun -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_20(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_20: Check the synchronization between 2 download buttons at default state: marge with test case: 18");
		
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_21</br>
	 * <b> CaseTitle: </b>Check when prefered quality selected as 'High'</br>
	 * <b> Steps: </b></br>
	 *  1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Hover on media player area for the first time
	 * 3. Prefered quality selected as "High"
	 * 4. Click "Download" button"
	 * 
	 * Expected: Quality selected is same as selected in Savior
	 * @author huy.vu
	 * @Update : HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_21(){
		if(continueExcute){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_21: Check when prefered quality selected as 'High'");
		startCocCoc();
		clearDownloads();
		accessWebAndPlayVideo(mediaInfo[1]);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		clickOn("pictures\\Browser_Savior_Text_PreferedQualityHigh.png"); 
		selectQualityVideoToDownload("FullHD");
		downloadMediaContentOnYoutube();
		if(checkFileDownloadWell("FullHD"))
			setTestcaseStatus("PASSED", "Quality selected is same as selected in Savior");
		}
		else
			setTestcaseStatus("FAILED", "Quality selected is not same as selected in Savior");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_22</br>
	 * <b> CaseTitle: </b>Check the synchronization between 2 download buttons at default state</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Click on Savior icon next to the address bar, select different qualities (High, Medium, Low)
	 * 3. Hover on media player area
	 *
	 * <b> ExpectedOutput: </b></br>Quality selected is same as selected in Savior
	 * @author huy.vu
	 * @Update : HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_22(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_22: Check when prefered quality selected as 'Medium'");
		startCocCoc();
		clearDownloads();
		accessWebAndPlayVideo(mediaInfo[1]);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		moveMouseDownFromLogo("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 45);
		s.click();
		sleep(2);
		clickOn("pictures\\Browser_Savior_Text_PreferedQualityMedium.png");
		
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		accessWebAndPlayVideo(mediaInfo[1]);
		//selectQualityVideoToDownload("HD");
		sleep (4);
		selectQualityVideoToDownload("Medium");
		downloadMediaContentOnYoutube();
		
		if(checkFileDownloadWell("Medium"))
		{
			
			setTestcaseStatus("PASSED", "Quality selected is same as selected in Savior");
		} 
		else
		{
			  
			setTestcaseStatus("FAILED", "Quality selected is not same as selected in Savior");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_23</br>
	 * <b> CaseTitle: </b>Check when prefer quality selected as 'Low'</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be download
	 * 2. Click on Savior icon next to the address bar, select different qualities (High, Medium, Low)
	 * 3. Hover on media player area
	 *
	 * <b> ExpectedOutput: </b></br>File will be download with the low quality available (for example mp4, Small)
	 * @author huy.vu
	 * @UPDATE: HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_23(){
		
		if(continueExcute){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_23: Check when prefered quality selected as 'low'");
		startCocCoc();
		clearDownloads();
		accessWebAndPlayVideo(mediaInfo[1]);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png"); 
		moveMouseDownFromLogo("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 45);
		s.click();
		sleep(2);
		clickOn("pictures\\Browser_Savior_Text_PreferedQualityLow.png");
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		accessWebAndPlayVideo(mediaInfo[1]);
		selectQualityVideoToDownload("HD");
		sleep(4);
		//selectQualityVideoToDownload("mobile");
		downloadMediaContentOnYoutube();
	
		if(checkFileDownloadWell("HD"))
			setTestcaseStatus("PASSED", "Quality selected is same as selected in Savior");
		else
			setTestcaseStatus("FAILED", "Quality selected is not same as selected in Savior");
		}
	}
	  

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_24</br>
	 * <b> CaseTitle: </b>Check if Subtittle is detected when hover over media player for the sites are suppported subtitle on youtube.com</br>
	 * <b> Steps: </b></br>
	   '1. Open CC Browser, access a media site which is suppported subtitle on youtube: 
       https://www.youtube.com/watch?v=A2WcLDXKyCo
       https://www.youtube.com/watch?v=FN7ALfpGxiI
       2. Hover over media player
       3. Click on "Preferred Quality"
       4. Scroll down to observer
	 * <b> ExpectedOutput: </b></br>
       4. Make sure that subtitle is detected. Currently, CC only support to download subtitle on youtube, not for other sites. 

         There are 2 types of subtitle for now: 
       - English subtitle
       - Vietnamese subtitle
	 * 
	 * @UPDATE: HANV
	 */
	
	@Test
	public void Browser_SNIFF_Savior_24(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_24:Check if Subtittle is detected when hover over media player for the sites are suppported subtitle on youtube.com");
		TestLogger.info("1. Open CC Browser, access a media site which is suppported subtitle on youtube: ");
		startCocCoc();
		openLink(" https://www.youtube.com/watch?v=A2WcLDXKyCo"); 
		TestLogger.info("2. Hover over media player");
		moveMouseDownFromLogo("pictures\\Website_youtube_image_logo.png", 250);
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		sleep(3);
		TestLogger.info(" 3. Click on 'Preferred Quality'");
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		sleep(3);
		int i =1;
		do
		{
		 i++ ;
		s.type(Key.DOWN);
		sleep (2);
		s.type(Key.DOWN);
		sleep (2);
		s.type(Key.DOWN);
		sleep (2);
		s.type(Key.DOWN);
		sleep (2);
		s.type(Key.DOWN);
		
		
		}
		 while (!waitForObjectPresent("pictures\\CocCoc_Savior_Text_SubTittle.png", 3) && (i<5));
		
		TestLogger.info("EPXECT :   There are 2 types of subtitle for now: - English subtitle - Vietnamese subtitle ");
		
		if (waitForObjectPresent("pictures\\CocCoc_Savior_Text_SubTittle.png", 3))
		{
			setTestcaseStatus("PASSED", "PASSED =>There are 2 types of subtitle for now:" 
       + " - English subtitle "
       + " - Vietnamese subtitle");
			
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED => =>There are NOT 2 types of subtitle for now:" 
            + " - English subtitle "
            + " - Vietnamese subtitle");
		}
			
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_25</br>
	 * <b> CaseTitle: </b>Check if Subtittle is detected when hover over media player for the sites are suppported subtitle on youtube.com</br>
	 * <b> Steps: </b></br>
	   '1. Open CC Browser, access a media site which is suppported subtitle on youtube: 
       https://www.youtube.com/watch?v=A2WcLDXKyCo
       https://www.youtube.com/watch?v=FN7ALfpGxiI
       2. Hover over media player
       3. Click on "Preferred Quality"
       4. Scroll down to observer
	 * <b> ExpectedOutput: </b></br>
       4. Make sure that subtitle is detected. Currently, CC only support to download subtitle on youtube, not for other sites. 

         There are 2 types of subtitle for now: 
       - English subtitle
       - Vietnamese subtitle
	 * 
	 * @UPDATE: HANV
	 */
	
	@Test
	public void Browser_SNIFF_Savior_25(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_25:Check if Subtittle is detected on Savior button for the sites are suppported subtitle on youtube.com");
		TestLogger.info("'1. Open CC Browser, access any media site as: ");
		startCocCoc();
		openLink(" https://www.youtube.com/watch?v=A2WcLDXKyCo"); 
		sleep(5);
		TestLogger.info("2. Click on Savior button on Omnibox");
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png"); 
		TestLogger.info("3. Click on Preferred Quality");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", -66);
		s.click();
		sleep(3);
		
		TestLogger.info("EXPECT :   There are 2 types of subtitle for now:English subtitle + Vietnamese subtitle");
		if (waitForObjectPresent("pictures\\CocCoc_Savior_Text_SubTittle.png", 3))
		{
			setTestcaseStatus("PASSED", "PASSED =>There are 2 types of subtitle for now:" 
       + " - English subtitle "
       + " - Vietnamese subtitle");
			
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED => =>There are NOT 2 types of subtitle for now:" 
            + " - English subtitle "
            + " - Vietnamese subtitle");
		}
			
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_26</br>
	 * <b> CaseTitle: </b>Check if user is able to see "Play Now" button when downloading a video</br>
	 * <b> Steps: </b></br>
	      '1. Open CC Browser, access any media site as: 
           http://mp3.zing.vn/video-clip/Noi-Nay-Co-Anh-Son-Tung-M-TP/ZW79ZBE8.html
           https://www.youtube.com/watch?v=FN7ALfpGxiI
           2. Click on "Download" button
	 * <b> ExpectedOutput: </b></br>
           2. "Play Now" button should show to replace Download and Prefered Quality button
           A pop-up show: "Click "Play Now" button to watch downloading video now!" and a checkbox "Do not show again"
	 * 
	 * @UPDATE: HANV
	 */
	
	@Test
	public void Browser_SNIFF_Savior_26(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_26:Check if user is able to see 'Play Now' button when downloading a video");
		TestLogger.info("'1. Open CC Browser, access any media site as: ");
		startCocCoc();
		openLink("https://www.youtube.com/watch?v=K9v3JGzDems"); 
		sleep(5);
		moveMouseDownFromLogo("pictures\\Website_youtube_image_logo.png", 250);
		
		TestLogger.info("  2. Click on 'Download' button");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Savior_Button_DownloadOnVideo.png", -100);
		s.click();
		sleep(3);
		s.click();
		sleep(2);
		s.type(Key.DOWN);
		sleep(2);
		s.type(Key.HOME);
		sleep(1);
		s.type(Key.DOWN);
		sleep(2);
		waitForObjectPresent("pictures\\saviorExtension_DownloadWithHD2.png", 3);
		clickOn("pictures\\saviorExtension_DownloadWithHD2.png");
		sleep(2);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png"); 
		sleep (3) ; 
		
		TestLogger.info("EXPECT :  2. 'Play Now' button should show to replace Download and Prefered Quality button &&  A pop-up show: Click Play Now button to watch downloading video now! and a checkbox Do not show again");
		
		if  ((waitForObjectPresent("pictures\\CocCoc_savior_button_playNow.png", 4)) && (waitForObjectPresent("pictures\\Coccoc_Savior_popup_PressToWatchNow.png", 4)))
		{
			setTestcaseStatus("PASSED", "PASSED => Play Now button should show to replace Download and Prefered Quality button & A pop-up show: Click Play Now button to watch downloading video now! and a checkbox Do not show again");
		}
		else
		{
			setTestcaseStatus("FAILED","FAILED => Play Now button should show to replace Download and Prefered Quality button & A pop-up show: Click Play Now button to watch downloading video now! and a checkbox Do not show again");
		}
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_27</br>
	 * <b> CaseTitle: </b>Check if "Play Now" button work well</br>
	 * <b> Steps: </b></br>
	      '1. Open CC Browser, access any media site as: 
           http://mp3.zing.vn/video-clip/Noi-Nay-Co-Anh-Son-Tung-M-TP/ZW79ZBE8.html
           https://www.youtube.com/watch?v=FN7ALfpGxiI
           2. Click on "Download" button
           3. Click on "Play Now" button
           4. Click on Pause, Start, Mute, FullScreen
	 * <b> ExpectedOutput: </b></br>
          3. - Media content is opened in a small screen
          - Title of detach screen is the name of downloaded file that you have saved
          - The icon of "Play" should display on the task bar like this one 
          4. All button Pause, Start, Mute, FullScreen should work well
	 * 
	 * @UPDATE: HANV
	 */
	@Test
	public void Browser_SNIFF_Savior_27(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_27: Check if 'Play Now' button work well");
		TestLogger.info("1. Open CC Browser, access a media site which is suppported subtitle on youtube: ");
		startCocCoc();
		openLink("https://www.youtube.com/watch?v=Z8RD6vSRKJ0"); 
		sleep(5);
		moveMouseDownFromLogo("pictures\\Website_youtube_image_logo.png", 250);
		TestLogger.info("2.Click on 'Download' button");
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png"); 
		sleep (3) ;  
		waitForObjectPresent("pictures\\CocCoc_savior_button_playNow.png", 4) ;
		TestLogger.info("3. Click on 'Play Now' button");
		clickOn("pictures\\CocCoc_savior_button_playNow.png"); 
		TestLogger.info("EXPECT :- Media content is opened in a small screen and Title of detach screen is the name of downloaded file that you have saved ");
		if (waitForObjectPresent("pictures\\CocCoc_saviorDetach_text_titleFilm.png", 5))
		{
			setTestcaseStatus("PASSED", "PASSED =>- Media content is opened in a small screen and Title of detach screen is the name of downloaded file that you have saved ");
			 moveMouseDownFromLogo("pictures\\CocCoc_saviorDetach_text_titleFilm.png", 150);
			 if (waitForObjectPresent("pictures\\CocCoc_SaviorDetach_Button_pause.png", 4))
			 {
				clickOn("pictures\\CocCoc_SaviorDetach_Button_pause.png");
				if (waitForObjectPresent("pictures\\CocCoc_SaviorDetach_Button_play.png", 4))
				{
				s.type(Key.F4, Key.ALT);
				   setTestcaseStatus("PASSED", " PASSED :  All button Pause, Start, Mute, FullScreen should work well");
				 
				}
				else
				{
				   s.type(Key.F4, Key.ALT);
				   setTestcaseStatus("FAILED", "FAILED :  All button Pause, Start, Mute, FullScreen DOES NOT work well");	
				}
			
			 }
		} 
		else
		{
			setTestcaseStatus("FAILED", "FAILED =>- Media content is  NOT opened in a small screen and Title of detach screen is the name of downloaded file that you have saved ");
		}
			
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_28</br>
	 * <b> CaseTitle: </b>Check if audio (sound only) is detected when hover over media player while playing video</br>
	 * <b> Steps: </b></br>
	      '1. Open CC Browser, access any media site as: 
           https://www.youtube.com/watch?v=Ok74oD2b0vU
           http://mp3.zing.vn/video-clip/We-Hear-U-Karik-DJ-XILLIX/ZW79U0AZ.html
           2. Hover over media player
           3. Click on "Preferred Quality"
           4. Scroll down to observer
	 * <b> ExpectedOutput: </b></br>
          3. List of quality types which user wants to download is shown
          4. Make sure that audio is detected. There are 2 types of audio quality for now: 
          mp3: 128 kbps and mp3 320 kbps
         
	 * 
	 * @Update : HANV 
	 * 
	 */ 
	
	@Test
	public void Browser_SNIFF_Savior_28(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_28: Check if audio (sound only) is detected when hover over media player while playing video");
		TestLogger.info("1. Open CC Browser, access a media site which is suppported subtitle on youtube: ");
		startCocCoc();
		openLink(" https://www.youtube.com/watch?v=A2WcLDXKyCo"); 
		TestLogger.info("2. Hover over media player");
		moveMouseDownFromLogo("pictures\\Website_youtube_image_logo.png", 250);
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		sleep(5);
		TestLogger.info(" 3. Click on 'Preferred Quality'");
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		sleep(5);
		TestLogger.info("EXPECT : 4. Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		
		if (waitForObjectPresent("pictures\\Coccoc_savior_text_128_320kb.png", 4))
		{
			setTestcaseStatus("PASSED", "PASSED => Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED => Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		}
		
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_29</br>
	 * <b> CaseTitle: </b>Check if audio (sound only) is detected on Savior button when playing video</br>
	 * <b> Steps: </b></br>
	      '1. Open CC Browser, access any media site as: 
           https://www.youtube.com/watch?v=Ok74oD2b0vU
           http://mp3.zing.vn/video-clip/We-Hear-U-Karik-DJ-XILLIX/ZW79U0AZ.html
           2. Click on Savior button on Omnibox
           3. Click on "Preferred Quality"
           4. Scroll down to observer
	 * <b> ExpectedOutput: </b></br>
          4. Make sure that audio is detected. There are 2 types of audio quality for now: 
          mp3: 128 kbps and mp3 320 kbps    
	 * 
	 * @Update : HANV 
	 * 
	 */ 
	
	@Test
	public void Browser_SNIFF_Savior_29(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_29: Check if audio (sound only) is detected on Savior button when playing video");
		TestLogger.info("1. Open CC Browser, access a media site which is suppported subtitle on youtube: ");
		startCocCoc();
		openLink(" https://www.youtube.com/watch?v=A2WcLDXKyCo");
		sleep(5); 
		TestLogger.info("2. Click on Savior button on Omnibox");
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png"); 
		TestLogger.info("3. Click on Preferred Quality");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", -66);
		s.click();
		
        TestLogger.info("EXPECT : 4. Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		
		if (waitForObjectPresent("pictures\\Coccoc_savior_text_128_320kb.png", 4))
		{
			setTestcaseStatus("PASSED", "PASSED => Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED => Make sure that audio is detected. There are 2 types of audio quality for now: mp3: 128 kbps and mp3 320 kbps");
		}
		
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_30</br>
	 * <b> CaseTitle: </b>Check that sound only is saved as .mp3 file format only</br>
	 * <b> Steps: </b></br>
	      '1. Open CC Browser, access any media site as: 
           https://www.youtube.com/watch?v=Ok74oD2b0vU
           http://mp3.zing.vn/video-clip/We-Hear-U-Karik-DJ-XILLIX/ZW79U0AZ.html
           2. Click on Savior button on Omnibox
           3. Click on "Preferred Quality"
           4. Select .mp3  (128 or 320 kbps) file type
           5. Click on Download button
	 * <b> ExpectedOutput: </b></br>
         4. Make sure that audio is detected. There are 2 types of audio quality for now: 
         mp3: 128 kbps and mp3 320 kbps
         5. Downloaded file is saved at local disk. File type is saved as .mp3 file format only. 
         File is openned successfully, no error with media program
         
	 * 
	 * @Update : HANV 
	 * 
	 */ 
	
	@Test
	public void Browser_SNIFF_Savior_30(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_30: Check that sound only is saved as .mp3 file format only");
		TestLogger.info("1. Open CC Browser, access a media site which is suppported subtitle on youtube: ");
		startCocCoc();
		openLink(" https://www.youtube.com/watch?v=A2WcLDXKyCo"); 
		TestLogger.info("2. Click on Savior button on Omnibox");
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png"); 
		
		TestLogger.info("3. Click on Preferred Quality");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", -66);
		s.click();
		sleep(3);
		TestLogger.info("4.Select .mp3  (128 or 320 kbps) file type");
		clickOn("pictures\\Coccoc_savior_text_128_320kb.png");
		sleep (3);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideoOption.png"); 
		
		waitForCocCocDownloadCompleted();
		
		TestLogger.info("EXPECT : 5. Downloaded file is saved at local disk. File type is saved as .mp3 file format only."); 
		
		File filemp3 = new File(pathtoFilemp3);
		
		if (filemp3.exists() && filemp3.isFile())
		{
			if (filemp3.getName().contains(".mp3"))
			{
				setTestcaseStatus("PASSED", "PASSED : Downloaded file is saved at local disk. File type is saved as .mp3 file format only");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : Downloaded file is NOT saved at local disk. File type is NOT saved as .mp3 file format only");
			}
		}
		
		openLink("coccoc://downloads/"); 
		doubleClick("pictures\\CocCoc_DownloadPage_Textlink_titlevideo.png");
		if (waitForObjectPresent("pictures\\App_VLC_Button_pause.png", 4))
		{
			clickOn("pictures\\App_VLC_Button_pause.png");
			s.type(Key.F4, Key.ALT);
			killprocess("vlc.exe");
			setTestcaseStatus("PASSED", " File is openned successfully, no error with media program");
		}
		else
		{
			
		    s.type(Key.F4, Key.ALT);
		    killprocess("vlc.exe");
			setTestcaseStatus("PASSED", " File is openned successfully, error with media program");
		}
		
		
		
	}
	
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_31</br>
	 * <b> CaseTitle: </b>Detach a media content </br>
	 * <b> Steps: </b></br>
	 * 1. Open a media website, access to some video or music link
	 * 2. Hover on media player
	 * 3. Click on "Detach" button
	 *
	 * <b> ExpectedOutput: </b>
	 * </br>2. Detach button appears next to Download button
	 * 3. Media content is opened in a small screen, title of detach screen is page title from where the media is detached
	 * Note: only media content should be opened in Detach screen
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_31(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_31: Detach a media content");
		startCocCoc();
		accessWebAndPlayVideo(mediaInfo[1]);
		clickOn("pictures\\Browser_Savior_Button_PIN.png");
		sleep(1);
		moveMouseDownFromLogo("pictures\\Browser_Savior_Button_PIPWindowRestore.png", 100);
		if (waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 5)) {
			clickOn("pictures\\Browser_Savior_Button_PIPWindowRestore.png");
			setTestcaseStatus("PASSED", "Media content is opened in a small screen, title of detach screen is page title from where the media is detached" );
		}
		else
			setTestcaseStatus("FAILED", "Media content is not opened in a small screen, title of detach screen is page title from where the media is detached" );
		
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_34</br>
	 * <b> CaseTitle: </b>Play media in detach screen</br>
	 * <b> Steps: </b></br>
	 * 1. Open a media website, access to some video or music link
	 * 2. Hover on media player
	 * 3. Click on "Detach" button
	 * 4. Click on Play button
	 * 5. Click on other play controls: Stop, Pause, Volume, Fullscreen mode�
	 *
	 * <b> ExpectedOutput: </b></br>
	 * Some detach screen plays media content automatically, some needs to click on Play button
	 * Play controls in detach screen should work normally
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test(groups = {"Primary"}) 
	public void Browser_SNIFF_Savior_34(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_34: Play media in detach screen");
		
		startCocCoc();
		accessWebAndPlayVideo(mediaInfo[1]);
		sleep(1);
		clickOn("pictures\\Browser_Savior_Button_PIN.png");
		sleep(5);
		moveMouseDownFromLogo("pictures\\Browser_Savior_Button_PIPWindowRestore.png", 100);
		TestLogger.info(" Click on other play controls: Stop, Pause, Volume, Fullscreen mode…"); 
		
		if (waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 5)) {
			
			setTestcaseStatus("PASSED", "SAvior STILL can play media in detach screen after pressing Detach button ");
			clickOn("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png"); 
			
			 if (!waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 2))
			 {
				 clickOn("pictures\\Browser_Savior_Button_PIPWindowRestore.png"); 
				 setTestcaseStatus("PASSED", "Play controls in detach screen work normally ");
			 }
			
		}
		else
			setTestcaseStatus("FAILED", "SAvior cannot play media in detach screen");
		
	}
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_35</br>
	 * <b> CaseTitle: </b>Detach multiple screens</br>
	 * <b> Steps: </b></br>
	 * 1. Open a media website, access to some video or music link
	 * 2. Hover on media player
	 * 3. Click on "Detach" button several times
	 *
	 * <b> ExpectedOutput: </b></br>
	 * One media content can be detached in many screens
	 * @author huy.vu
	 * @update: HANV
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_35(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_35: Detach multiple screens");
		//clearDownloadPage();
		startCocCoc();
		accessWebAndPlayVideo(mediaInfo[1]);
		clickOn("pictures\\Browser_Savior_Button_PIN.png");
		sleep(1);
		
		accessWebAndPlayVideo("https://www.youtube.com/watch?v=P94DusN4LsY");
		clickOn("pictures\\Browser_Savior_Button_PIN.png");
		
		if(waitForObjectPresent("pictures\\Browser_Savior_Text_MusicNameOnPIPwindow01.png", 5) & waitForObjectPresent("pictures\\Browser_Savior_Text_MusicNameOnPIPwindow02.png",5))
		{
			clickOn("pictures\\Browser_Savior_Button_PIPWindowRestore.png");
			sleep (5);
			moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -200);
			clickOn("pictures\\Browser_Savior_Button_PIPWindowRestore.png");
			setTestcaseStatus("PASSED", "Savior can detach multiple screens");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "Savior cannot detach multiple screens");
		}
	}
	

	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_36</br>
	 * <b> CaseTitle: </b>Check if user is able to Download video after uploading embedded video from Facebook</br>
	 * <b> Steps: </b></br>
	 *  1. Log in Facebook on CocCoc Browser
        2. Upload a video on your Facebook from your computer
        3. Play this video on CocCoc Browser
        4. Hover over the video: try to PIN, download
        5. Download via Savior button 
	 *
	 * <b> ExpectedOutput: </b></br>
	 *   2. Video is uploaded successfully
         4. Video is opened in a small screen after user PIN the video, download video normally
         5. Savior can detect the video ( Savior change to green color), download this video via Savior successfully
	 * @author huy.vu
	 * @Update : HANV
	 * @date 8 Mar -2017
	 */
	//@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_36(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_36: Check Savior work with share video on facebook timeline");
		
		//clearDownloadPage();
		
		loginFacebook();
		
		clickOn("pictures\\Website_facebook_Button_playMedia.png");
		
		sleep(35);
		
		moveMouseDownFromLogo("pictures\\Website_Facebook_MediaTitleThePianoGuys.png", -200);
		
		if(waitForObjectPresent("pictures\\Browser_Savior_button_downloadMedia.png", 5) & waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5))
			setTestcaseStatus("PASSED", "Download and pin button are displayed when play video on timeline");
		else
			setTestcaseStatus("FAILED", "Download and pin button are not displayed when play video on timeline");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_37</br>
	 * <b> CaseTitle: </b>Check Savior work with his video is shared on facebook timeline</br>
	 * <b> Steps: </b></br>
	 1. Log in Facebook on CocCoc Browser
     2. Upload an embedded video on your Facebook: (Ex: <iframe src="http://www.nhaccuatui.com/vh/auto/l1YSP9LqdsLZ1" width="620" height="350" frameborder="0" allowfullscreen></iframe>)
     3. Click on the embedded link on your facebook
     4. Download via Savior button 
	 *
	 * <b> ExpectedOutput: </b></br>
	 *2. Embedded video is uploaded successfully
      3. User can play video normally,PIN/Download button when hover over video
      4. Savior can detect video, user download successfully
	 * @author HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_Savior_37(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_35:Check download button and PIP button do not display when user play video in share link");
		
		//clearDownloadPage();
		accessVideoFromURL();
		sleep(40);
		moveMouseDownFromLogo("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 500);
		
		if((waitForObjectPresent("pictures\\Browser_Savior_button_downloadMedia.png", 2) && waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 2)))
			setTestcaseStatus("PASSED", "Download and pin button are display when play video");
		else
			setTestcaseStatus("FAILED", "Download and pin button are NOT displayed when play video");
		
	}
	
	/**
	 * <b> samba1o\QA\WIP\TestReferentials\Browser\Browser_Sniff_TestCase_Windows_v2.6.xlsx  </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_45</br>
	 * <b> CaseTitle: </b>Check : Check multiple download UI</br>
	 * <b> Steps: </b></br>
	 * 1. Open 1 new tab, access any page having music, movie, video can be downloaded, mp3.zing.vn for example
       2. Click on some media which has been provided by its site with more than 1 files in different video quality
       3. Mouse hover on media player
       4. Moving out of media player area
	 *
	 * <b> ExpectedOutput: </b></br>
	 * Check UI:
      - Select option: all, none
      - Download selected button
      - All downloadable files listed, each file with download button
      - When moving out of media player, the list disappears and when user focuses back to media player, the download list shows in collapse mode: "n media found". Click on it to open download mode
	 * @author hanv
	 * @date 26 Dec -2016
	 */
	
	@Test
	public void Browser_SNIFF_Savior_45 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_45: Check multiple download UI ");
		//clearDownloadPage();
		startCocCoc();
		TestLogger.info("1. Open 1 new tab, access any page having music, movie, video can be downloaded, mp3.zing.vn for example");
		openLink("http://fptplay.net/xem-video/hinh-xam-cam-ki-tap-11-577a0e2517dc1352b143dce7.html");
		sleep (15);
		if (waitForObjectPresent("pictures\\Website_fptplay_Button_Skip.png", 15))
		{
			clickOn("pictures\\Website_fptplay_Button_Skip.png");
		}
		
		clickOn("pictures\\Browser_Tab_icon_FPTplay.png");
		TestLogger.info("2. Mouse hover on media player");
		waitForObjectPresent("pictures\\Browser_Menu_Button_Reload.png", 18);
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_Anime.png", 200);
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 4);
		
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		
		TestLogger.info("3. Click on some media which has been provided by its site with more than 1 files in different video quality");
		clickOn("pictures\\Website_Fptplay_Text_chunklist_b394000.m3u8.mp4.png");
		
		TestLogger.info("2a- Expect : When moving out of media player, the list disappears ");
		hoverImage("pictures\\Website_fptplay_Tab_iconFptplay.png");
		//moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_Anime.png", 200);
		sleep (5);
		
		if (waitForObjectPresent("pictures\\Website_Fptplay_Text_chunklist_b394000.m3u8.mp4.png", 2))
		{
			setTestcaseStatus("FAILED", " When moving out of media player, the list doesn't disappear");
		}
		else
		{
			
			setTestcaseStatus("PASSED", " When moving out of media player, the list disappears");
		}
		
		
		TestLogger.info("when user focuses back to media player" ) ;
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_AudioStory.png", 200);
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_Anime.png", 200);
		TestLogger.info("Expect : the download list shows in collapse mode: n media found");
		if (waitForObjectPresent("pictures\\Website_Fptplay_Text_chunklist_b394000.m3u8.mp4.png", 3))
		{
			
			setTestcaseStatus("PASSED", "the download list shows in collapse mode: n media found");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "the download list DOES NOT show in collapse mode: n media found");
		}
			
	}
	
	/**
	 * <b> samba1o\QA\WIP\TestReferentials\Browser\Browser_Sniff_TestCase_Windows_v2.3.xlsx  </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_46</br>
	 * <b> CaseTitle: </b>Check : Check download all files</br>
	 * <b> Steps: </b></br>
	 *  1. Open 1 new tab, access any page having music, movie, video can be downloaded, mp3.zing.vn for example
        2. Click on some media which has been provided by its site with more than 1 files in different video quality
        3. Mouse hover on media player
        4. Check "all" and click on button "Download selected"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * All files in the list are downloaded succesfully
	 * @author hanv
	 * @date 26 Dec -2016
	 */
	
	
	@Test
	public void Browser_SNIFF_Savior_46 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_46: Check download all files");
		//clearDownloadPage();
		startCocCoc();
		TestLogger.info("1. Open 1 new tab, access any page having music, movie, video can be downloaded, mp3.zing.vn for example");
		openLink("https://fptplay.net/xem-video/hinh-xam-cam-ki-tap-11-577a0e2517dc1352b143dce7.html");
		sleep (25);
		waitForObjectPresent("pictures\\Website_fptplay_Button_Skip.png", 30);
	
		TestLogger.info("2. Mouse hover on media player");
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_NgoaiHangAnh.png", 200);
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 4);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		
		TestLogger.info("3.  Check 'all' and click on button 'Download selected'");
		clickOn("pictures\\Browser_Savior_Button_ChooseAll.png");
		
		clickOn("pictures\\Browser_Savior_Button_DownloadSelectedFiles.png"); 
		
		TestLogger.info("Expect : All files in the list are downloaded succesfully ");
		// open page downloads : coccoc://downloads/ 
		s.type("j",Key.CTRL); 
		sleep (2);
		s.type("f", Key.CTRL);
		s.type("chunklist"); 
		
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_text_result1in4.png", 4)) 
		{
			clickOn("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png");
			s.type("f", Key.CTRL);
			s.type("chunklist"); 
			clickOn("pictures\\OSApp_VLC_icon_image.png");
			s.type("a", Key.CTRL);
			s.type(Key.DELETE);
			sleep (5);
			s.type(Key.ENTER);
			clickOn("pictures\\OSApp_Window_icon_Reload.png");
			s.type(Key.F4,Key.ALT);
			setTestcaseStatus("PASSED", "All files in the list are downloaded succesfully");
		}
		else
		{
			clickOn("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png");
			s.type("f", Key.CTRL);
			s.type("chunklist"); 
			clickOn("pictures\\OSApp_VLC_icon_image.png");
			s.type("a", Key.CTRL);
			s.type(Key.DELETE);
			sleep (5);
			s.type(Key.ENTER);
			clickOn("pictures\\OSApp_Window_icon_Reload.png");
			s.type(Key.F4,Key.ALT);
			setTestcaseStatus("FAILED", "All files in the list are NOT downloaded succesfully");
		}
	}
	
	
	/**
	 * <b> samba1o\QA\WIP\TestReferentials\Browser\Browser_Sniff_TestCase_Windows_v2.3.xlsx  </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_47</br>
	 * <b> CaseTitle: </b>Check : Undo selection</br>
	 * <b> Steps: </b></br>
	 * 1. Select all or some files from the list
	 * 2. Click "none"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * All selections are removed, button "Download selected" is dimmed
	 * @author hanv
	 * @date 26 Dec -2016
	 */
	@Test
	public void Browser_SNIFF_Savior_47 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_47:Check Undo selection");
		
		startCocCoc();
		openLink("https://fptplay.net/xem-video/hinh-xam-cam-ki-tap-11-577a0e2517dc1352b143dce7.html");
		sleep (25);
		if (waitForObjectPresent("pictures\\Website_fptplay_Button_Skip.png", 5))
		{
			clickOn("pictures\\Website_fptplay_Button_Skip.png");
		}
		
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_NgoaiHangAnh.png", 200);
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 4);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		TestLogger.info("1. Select all or some files from the list");
		clickOn("pictures\\Browser_Savior_Button_ChooseAll.png");
		TestLogger.info("2.Click 'unchoose' All "); 
		clickOn("pictures\\Browser_Savior_Button_UnChooseAll.png");
		TestLogger.info("3.All selections are removed, button 'Download selected' is dimmed");
		
		clickOn("pictures\\Browser_Savior_Button_DownloadSelectedFiles.png"); 
		// open page downloads : coccoc://downloads/ 
		s.type("j",Key.CTRL); 
		// if icon DisplayInFolder is available => FAIL
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 3))
		{
			
			setTestcaseStatus("FAILED", "the feature unselect is Wrong . All selections are NOT removed, button 'Download selected' is NOT  dimmed ");
		}
		// if icon DisplayInFolder is NOT available => PASS
		else
		{
			
			setTestcaseStatus("PASSED", "3.All selections are removed, button 'Download selected' is dimmed");
		}
		
	}
	
	/**
	 * <b> samba1o\QA\WIP\TestReferentials\Browser\Browser_Sniff_TestCase_Windows_v2.3.xlsx  </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_48</br>
	 * <b> CaseTitle: </b>Check : Download selected files </br>
	 * <b> Steps: </b></br>
	 * 1. Select all or some files from the list
	 * 2. 2. Click on "Download selected" or click on "Download" button in each line
	 *
	 * <b> ExpectedOutput: </b></br>
	 * Selected files are downloaded
	 * @author hanv
	 * @date 26 Dec -2016
	 */
	
	
	@Test
	public void Browser_SNIFF_Savior_48 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_48: Download selected files ");
		//clearDownloadPage();
		startCocCoc();
		openLink("https://fptplay.net/xem-video/hinh-xam-cam-ki-tap-11-577a0e2517dc1352b143dce7.html");
		sleep (13);
		if (waitForObjectPresent("pictures\\Website_fptplay_Button_Skip.png", 15))
		{
			clickOn("pictures\\Website_fptplay_Button_Skip.png");
		}
		clickOn("pictures\\Browser_Tab_icon_FPTplay.png");
		
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_Anime.png", 200);
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 4);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		TestLogger.info("1. Select all or some files from the list");
		
		clickOn("pictures\\Website_Fptplay_Text_chunklist_b394000.m3u8.mp4.png");
		TestLogger.info("2. Click on 'Download selected' or click on 'Download' button in each line"); 
		
		clickOn("pictures\\Browser_Savior_Button_DownloadSelectedFiles.png"); 
		TestLogger.info("Expect : Selected files are downloaded ");
		// open page downloads : coccoc://downloads/ 
		s.type("j",Key.CTRL); 
		// if file Chunklist_b394000.m3u8.mp is available on Downloads page => PASS
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_TextLink_Chunklist_b394000.m3u8.mp.png", 5))
		{
			
			setTestcaseStatus("PASSED", "Selected files are downloaded ");
		}
		// if file Chunklist_b394000.m3u8.mp is NOT available on Downloads page => FAIL
		else
		{
			
			setTestcaseStatus("FAILED", "Selected files are NOT downloaded ");
			
		}
			
	}
	
	/**
	 * <b> samba1o\QA\WIP\TestReferentials\Browser\Browser_Sniff_TestCase_Windows_v2.3.xlsx  </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_49</br>
	 * <b> CaseTitle: </b>Check : Check download button dim when the download finished </br>
	 * <b> Steps: </b></br>
	 * 1. Select all or some files from the list
	 * 2. Click on "Download selected"
	 *
	 * <b> ExpectedOutput: </b></br>
	 * When the download completed, button "Download" become disabled
	 * @author hanv
	 * @date 26 Dec -2016
	 */
	
	
	@Test
	public void Browser_SNIFF_Savior_49 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Savior_49: Check download button dim when the download finished ");
		startCocCoc();
		openLink("http://fptplay.net/xem-video/hinh-xam-cam-ki-tap-11-577a0e2517dc1352b143dce7.html");
		waitForObjectPresent("pictures\\Website_fptplay_Button_Skip.png", 29);
		moveMouseDownFromLogo("pictures\\Website_Fptplay_Menu_NgoaiHangAnh.png", 200);
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 4);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		TestLogger.info("1. Select all or some files from the list");
		
		clickOn("pictures\\Website_Fptplay_Text_chunklist_b394000.m3u8.mp4.png");
		TestLogger.info("2. Click on 'Download selected' or click on 'Download' button in each line"); 
		
		clickOn("pictures\\Browser_Savior_Button_DownloadSelectedFiles.png"); 
		s.type("j",Key.CTRL); 
		waitForObjectPresent("pictures\\Browser_DownloadPage_TextLink_Chunklist_b394000.m3u8.mp.png", 5);
		waitForObjectPresent("pictures\\Website_fptplay_Tab_iconFptplay.png", 7);
		clickOn("pictures\\Website_fptplay_Tab_iconFptplay.png");
		
		// Click on Button Download in 2nd time to check if it is Dimmed or NOT 
		clickOn("pictures\\Browser_Savior_Button_DownloadSelectedFiles.png"); 
		s.type("j",Key.CTRL); 
		
		
		clickOn("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png");
		s.type("f",Key.CTRL);
		sleep(1);
		s.type("chunklist_b394000.m3u8");
		// if search result is 1 ==> PASS 
		if (waitForObjectPresent("pictures\\Browser_SearchDownload_Text_One.png", 3))
		{
			
			setTestcaseStatus("PASSED", "When the download completed, button 'Download' become disabled");
		}
		// if search result is > 1 ==> FAIL  
		else
		{
			
			setTestcaseStatus("FAILED", "When the download completed, button 'Download' NOT become disabled");
		}
			
	}
	
}
