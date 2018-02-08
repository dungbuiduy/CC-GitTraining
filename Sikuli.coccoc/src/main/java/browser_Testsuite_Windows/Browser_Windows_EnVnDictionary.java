package browser_Testsuite_Windows;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.TestLogger;

public class Browser_Windows_EnVnDictionary extends BrowserCommon_Extensions{
	
	private String siteTest = "http://www.w3schools.com/css/css_text.asp";
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	String userprofile = System.getenv("USERPROFILE");
	
	//@BeforeTest
	public void beforTestEnViDictionary(){
		TestLogger.info("-------------------------TEST SNIFF FOR EN-VI DICTIONARY----------------------------");
		
		if(DownloadCCBrowser("dev.coccoc.com")){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
			TestLogger.info("==========================================TEST CASE=====================================================================");
		}
		else{
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
		}
	}
	
	@AfterMethod
	public void cleanEnvironment(){
		//close coc coc if exist
		if(waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 1)){
			TestLogger.info("Close Coc Coc browser");
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");  
			s.type(Key.F4, Key.ALT);
		}
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_01</br>
	 * <b> CaseTitle: </b>Check default status of EnVnDictionary extension on browser </br>
	 * <b> Steps: </b></br>
	 * 1. Start browser
	 * 2. Open extension list page by inputing on omibox: chrome://extensions/
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  1. EnVnDictionary extension show in extension list
	 *  2. Status of EnVnDictionary is Enable
	 *  3. "Allow in incognito/Cho phep o che do an danh" checkbox is checked
	 *  4. "Allow access to file URLs/Cho phép truy cập vào các URL của tep" check box is uncheck
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 15 Jul -2016
	 */
	@Test (groups = { "Primary" })
	public void Browser_SNIFF_EnVnDictionary_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_01: Check default status of EnVnDictionary extension on browser");
		openExtensionsPage();
		
		if(checkExtensionStatus("EN-VI", "enable"))
			setTestcaseStatus("PASSED", "The default status of EN-VI Dictionary is enable");
		else
			setTestcaseStatus("FAILED", "The default status of EN-VI Dictionary is disable, pls recheck on screenshot");
		
		if(waitForObjectAppearOnRegion("pictures\\Browser_ExtensionPage_Icon_Savior.png", "pictures\\Browser_EnVnDictionary_Checkbox_AllowInIncognitoMode.png", 520,185, 1))
			setTestcaseStatus("PASSED", "'Allow in incognito/Cho phep o che do an danh' checkbox is checked");
		else
			setTestcaseStatus("FAILED", "'Allow in incognito/Cho phep o che do an danh' checkbox is unchecked");
		
		if(waitForObjectAppearOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVNDictionary_Checkbox_UncheckedAllowAccessFileURL.png", 520, 180, 1))
			setTestcaseStatus("PASSED", "'Allow access to file URLs/Cho phép truy cập vào các URL của tep' checkbox is unchecked");
		else
			setTestcaseStatus("FAILED", "'Allow access to file URLs/Cho phép truy cập vào các URL của tep' checkbox is checked");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_02</br>
	 * <b> CaseTitle: </b>Check version of EnVnDictionary extension on browser</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser
	 * 2. Open extension list page by inputing on omibox: chrome://extensions/
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  1. Version of extension must correspond with version of browser
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 15 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_02: Check version of EnVnDictionary extension on browser");
		String en2viName = "Tu Dien";
		String en2viVersion = CocCocVersion[4];
		
		if(checkExtensionVersion(en2viName, en2viVersion))
			setTestcaseStatus("PASSED", "Version of extension correspond with version of browser");
		else 
			setTestcaseStatus("FAILED", "ersion of extension not correspond with version of browser");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_03</br>
	 * <b> CaseTitle: </b>Check working of EnVnDictionary extension on browser by double click</br>
	 * <b> Steps: </b></br>
	 * 1. Be sure that EnVnDictionary extension is turn ON.
	 * 2. Open English language link. For ex: http://www.bbc.com/
	 * 3. Use mouse select one English word in the web page by "doubled click".
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  1. One pop-window will be shown and translate it to VietNamese and the popup can scroll of content is very long
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 15 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_03: Check working of EnVnDictionary extension on browser by double click");
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot load web page to test");
	}

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_04</br>
	 * <b> CaseTitle: </b>Check working of EnVnDictionary extension on browser by blacken one word</br>
	 * <b> Steps: </b></br>
	 * 1. Be sure that EnVnDictionary extension is turn ON.
	 * 2. Open English language link. For ex: http://www.bbc.com/
	 * 3. Use mouse select one English word in the web page by blacked one English word and right click.
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  1. There is a menu show beside backed word, Select "Translate: blacken word" menu => Show translate popup.
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 15 Jul -2016
	 */
	@Test (groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_04: Check working of EnVnDictionary extension on browser by blacken one word");
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot load web page to test");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_05</br>
	 * <b> CaseTitle: </b>Check working of EnVnDictionary extension on browser by blacken one word</br>
	 * <b> Steps: </b></br>
	 * 1. input on omibox: chrome://extensions/
       2. Uncheck "Enable/Đã bật" checkbox of EnVnDictionary extension
       3. Open new tab, access English language link. For ex: http://www.bbc.com/ => Check working of EnVnDictionary.
       4. Restart browser, access below English language link => Check working of EnVnDictionary.
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  3. EnVnDictionary will NOT work on the page.
	 *  4. After re-start browser, access English language page, EnVnDictionary still will NOT work
	 * @author huy.vu
	 * @Update huy.vuttp://www.w3schools.com/css/css_text.asp
	 * 
	 * @date 15 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_05(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_05: Check status of EnVnDictionary After turn off extension");
		openExtensionsPage();
		changeExtensionStatus("EnVi", "Disable");
		
		//open site test
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitforObjectNotexist("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
			
			TestLogger.info("restart Coc Coc browser");
			doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
			s.type(Key.ESC);
			sleep(1);
			s.type(Key.F4, Key.ALT);
			
			startCocCoc();
			s.type(Key.ESC);
			s.type("t", Key.CTRL);
			s.type(siteTest);
			sleep (1);
			s.type(Key.ENTER);
			if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
				hoverImage("pictures\\Website_w3school_text_Formatting.png");
				doubleClick("pictures\\Website_w3school_text_Formatting.png");
				
				if(waitforObjectNotexist("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				{
					openLink("coccoc://extensions/");
					changeExtensionStatus("EnVi", "Enable");
					setTestcaseStatus("PASSED", "After re-start browser, EnVnDictionary not work");
				}
				else
				{
					openLink("coccoc://extensions/");
					changeExtensionStatus("EnVi", "Enable");
					setTestcaseStatus("FAILED", "After re-start browser, EnVnDictionary still work");
				}
			}
			else
			{
				openLink("coccoc://extensions/");
				changeExtensionStatus("EnVi", "Enable");
				setTestcaseStatus("SKIPED", "Cannot load web page again to test");
			}
		}
		else
		{
			openLink("coccoc://extensions/");
			changeExtensionStatus("EnVi", "Enable");
			setTestcaseStatus("SKIPED", "Cannot load web page to test");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_06</br>
	 * <b> CaseTitle: </b>Check status of EnVnDictionary After turn off extension -> turn on extension</br>
	 * <b> Steps: </b></br>
	 * 1. input on omibox: chrome://extensions/
	 * 2. Uncheck "Enable/Đã bật" check box of EnVnDictionary extension
	 * 3. Restart browser
	 * 4. Open extension list page, Re turn on EnVnDictionary by checking the checkbox.
	 * 5. Open new tab, access English language link
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * After turn on, EnVnDictionary must word normally
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 19 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_06(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_06: Check status of EnVnDictionary After turn off extension -> turn on extension");
		openExtensionsPage();
		changeExtensionStatus("EnVi", "Disable");
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		s.type(Key.F4, Key.ALT);
	    //Check that Coc Coc is closed 100% 
		openExtensionsPage();
		changeExtensionStatus("EnVi", "Enable");
		
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		s.type(Key.F4, Key.ALT);
		
		startCocCoc();
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type(siteTest);
		sleep (1);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot load web page to test");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_07</br>
	 * <b> CaseTitle: </b>Check status of EnVnDictionary in Incognito when  unchecking "Allow in incognito/Cho phep o che do an danh" check box</br>
	 * <b> Steps: </b></br>
	 * hecking the checkbox.
	 * 1. input on omibox: chrome://extensions/
	 * 2. Uncheck checkbox "Allow in incognito/Cho phep o che do an danh" of EnVnDictionary extension
	 * 3. Restart browser
	 * 4. Open extension list, Re turn on lại EnVnDictionary
	 * 5. Open new tab, access English language link
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * EnVnDictionary will NOT work on incognito page.
	 * @author huy.vu
	 * @Update HANV
	 * @date 15 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_07(){
		
		 
		 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_07:Check status of EnVnDictionary in Incognito when  unchecking 'Allow in incognito/Cho phep o che đo an danh' check box");
		openExtensionsPage();
		
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVnDictionary_Checkbox_AllowInIncognitoMode.png", 520,185);
		// Check Uncheck checkbox "Allow in incognito/Cho phep o che do an danh" of EnVnDictionary extension is OK 
		if (waitForObjectAppearOnRegion("pictures\\Browser_EnViDictionary_Text_ExtensionName&Logo.png", "pictures\\Browser_ExtensionPage_Checkbox_AlowIncognitoTab.png", 218, 61, 5))
		 {
			 TestLogger.info("NOK : Still NOT Uncheck checkbox");
			 setTestcaseStatus("FAILED", "Still NOT Uncheck checkbox");
		 }
		 else
		 {
			 TestLogger.info("OK : Unchecked Checkbox Successfully ! ");
		 }
		
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		s.type(Key.F4, Key.ALT);
		
		startCocCoc();
		
		if (waitforObjectNotexist("pictures\\Browser_Menu_Text_icognito.png", 1))
		{
			clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		}
		
		clickOn("pictures\\Browser_Menu_Text_icognito.png");
		
		openLink(siteTest);
		
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			
			if(waitforObjectNotexist("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 2))
			{
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVnDictionary_Checkbox_AllowInIncognitoMode.png", 520,185);

				s.type(Key.F4, Key.CTRL);
				doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
				s.type(Key.ESC);
				sleep(1);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "After re-start browser, EnVnDictionary not work in incognito mode");
			}
			else 
			{
				
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVnDictionary_Checkbox_AllowInIncognitoMode.png", 520,185);

				s.type(Key.F4, Key.CTRL);
				doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
				s.type(Key.ESC);
				sleep(1);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "After re-start browser, EnVnDictionary still work in incognito mode");
			}
		}
		else
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVnDictionary_Checkbox_AllowInIncognitoMode.png", 520,185);

			s.type(Key.F4, Key.CTRL);
			setTestcaseStatus("SKIPED", "Cannot load web page again to test");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_08</br>
	 * <b> CaseTitle: </b>CCheck status of EnVnDictionary in Incognito when  checking "Allow in incognito/Cho phep o che do an danh" check box</br>
	 * <b> Steps: </b></br>
	 * hecking the checkbox.
	 * 1. input on omibox: chrome://extensions/,  be sure that "Allow in incognito/Cho phep o che do an danh" is checked.
	 * 2. Open new incognito window, access English language link. For ex: http://www.bbc.com/
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * EnVnDictionary will NOT work on incognito page.
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 19 Jul -2016
	 */
	@Test  (groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_08(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_08: EnVnDictionary must work normally on incognito page.");
		startCocCoc();
		if (waitforObjectNotexist("pictures\\Browser_Menu_Text_icognito.png", 1))
		{
			clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		}
		
		clickOn("pictures\\Browser_Menu_Text_icognito.png");
	
		s.type(siteTest);
		s.type(Key.ENTER);
		
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.CTRL);
				setTestcaseStatus("PASSED", "EnVnDictionary work in incognito mode");
			}
			else
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.CTRL);
				setTestcaseStatus("FAILED", "EnVnDictionary Does NOT work in incognito mode");
			}
		}
		else
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type(Key.F4, Key.CTRL);
			setTestcaseStatus("SKIPED", "Cannot load web page again to test");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_09</br>
	 * <b> CaseTitle: </b>Check 'Allow access to file URLs/cho phép truy cập vào các URL của tep' of EnVnDictionary extension when checking on it</br>
	 * <b> Steps: </b></br>
	 * hecking the checkbox.
	 * 1. input on omibox: chrome://extensions/
	 * 2.Check "Allow access to file URLs/cho phép truy cập vào các URL của tệp" check box of EnVnDictionary extension
	 * 3. Open one link, start by file://.  (Save any English laguage page on your computer => Open the file by Cốc Cốc browser)
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * EnVnDictionary must work normally on the page.
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 19 Jul -2016
	 */
	@Test
	public void Browser_SNIFF_EnVnDictionary_09(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_09: Check 'Allow access to file URLs/cho phép truy cập vào các URL của tep' of EnVnDictionary extension when checking on it");
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVNDictionary_Checkbox_UncheckedAllowAccessFileURL.png", 520, 200);
		
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		s.type(Key.F4, Key.ALT);
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type("file:///" + userprofile + "/Downloads/testFiles/testTranslate.html");
		s.type(Key.ENTER);
		waitforObjectNotexist("pictures\\Browser_Menu_icon_w3school.png", 45);
		doubleClick("pictures\\Website_w3school_text_Formatting.png");
		if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVNDictionary_Checkbox_checkedAllowAccessFileURL.png", 520, 200);
			setTestcaseStatus("PASSED", "EnVnDictionary works normally with URL");
		}
		else
		{
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVNDictionary_Checkbox_checkedAllowAccessFileURL.png", 520, 200);
			setTestcaseStatus("FAILED", "EnVnDictionary does not work with URL");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_10</br>
	 * <b> CaseTitle: </b>Check "Allow access to file URLs/cho phép truy cập vào các URL của tep" of EnVnDictionary extension when unchecking it</br>
	 * <b> Steps: </b></br>
	 * hecking the checkbox.
	 * 1. input on omibox: chrome://extensions/
	 * 2. Uncheck "Allow access to file URLs/cho phép truy cập vào các URL của tep" check box of EnVnDictionary extension
	 * 3. Re-start browser.
	 * 4. Open one link, start by file://.  (Save any English laguage page on your computer => Open the file by Cốc Cốc browser)
	 * <b> ExpectedOutput: </b></br>
	 * EEnVnDictionary must NOT work on the page
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 19 Jul -2016
	 */
	@Test (groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_10(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_10: Check 'Allow access to file URLs/cho phép truy cập vào các URL của tep' of EnVnDictionary extension when checking on it");
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type("file:///" + userprofile + "/Downloads/testFiles/testTranslate.html");
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			
			if(waitforObjectNotexist("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "After re-start browser, EnVnDictionary not work");
			else
				setTestcaseStatus("FAILED", "After re-start browser, EnVnDictionary still work");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot load web page again to test");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_11</br>
	 * <b> CaseTitle: </b>Check "Permissions/Quyen" link</br>
	 * <b> Steps: </b></br>
	 * checking the checkbox.
	 * 1. input on omibox: chrome://extensions/
	 * 2. click on "Permissions/Quyen" link
	 * <b> ExpectedOutput: </b></br>
	 * One pop up show, contents:
	 * Title of the popup:
	 * Current Permisstions/Quyền hiện tại
	 * Từ điển Anh-Việt
	 * It can/Tiện ích mở rộng/ứng dụng có thể:
	 * 	Access your data all wevsites/Truy nhập dữ liệu của bạn trên tất cả các trang web
	 *  Access your tabs and browsing activity/Truy cập các tab và hoạt động duyệt của bạn.
	 *  Close button/Nút Đóng
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test 
	public void Browser_SNIFF_EnVnDictionary_11(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_11: Check 'Permissions/Quyen' link");
		
		openExtensionsPage();
		
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_EnVnDictionary_LinkText_DetailsPage.png", 550,185);
		
		if(waitForObjectPresent("pictures\\Browser_EnViDictionary_Text_ExtensionName&Logo.png", 5))
			setTestcaseStatus("PASSED", "The Title of the popup correctly");
		else
			setTestcaseStatus("FAILED", "The Title of the popup incorrectly");
		
		if(waitForObjectPresent("pictures\\Browser_EnViDictionary_Text_PermissionDefinition.png", 5))
			setTestcaseStatus("PASSED", "The permission show correctly");
		else
			setTestcaseStatus("FAILED", "The permission show incorrectly");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_12</br>
	 * <b> CaseTitle: </b>Check option page </br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions
	 * 2. Click on "Tùy chọn" to open option page of En-Vn Dictionary
	 * <b> ExpectedOutput: </b></br>
	 *There are 3 options:
	 *- Nháy đúp để dịch từ sang tiếng Việt
	 *- Nhập vào từ cần dịch
	 *- Nháy đúp để dịch từ sang tiếng Việt (for text area)
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test 
	public void Browser_SNIFF_EnVnDictionary_12(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_12: Check option page ");
		
		openExtensionsPage();
		
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
		sleep(5);
		if(waitForObjectPresent("pictures\\Browser_EnViDictionary_Menu_DefaultOptions.png", 5))
			setTestcaseStatus("PASSED", "The Options show corrctly");
		else
			setTestcaseStatus("FAILED", "The Options show incorrctly");
	}
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_13</br>
	 * <b> CaseTitle: </b>Check working of option 'Nhay đup de dich tu sang tieng Viet'</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions
	 * 2. Click on "Tùy chọn" to open option page of En-Vn Dictionary
	 * 3. Select "Nháy đúp để dịch từ sang tiếng Việt"
	 * 4. Open some page contains english content and double click on any word
	 * 5. Open again and uncheck "Nháy đúp để dịch sang tiếng Việt"
	 * 6. Recheck on english page
	 * <b> ExpectedOutput: </b></br>
	 * 4. Translation should display for selected word
	 * 6. No translation displays
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test 
	public void Browser_SNIFF_EnVnDictionary_13(){
		
		
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_13: Check working of option 'Nhay đup de dich tu sang tieng Viet'");
		
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
		sleep(5);
		clickOn("pictures\\Browser_EnViDictionary_Checkbox_CheckedOptionDoubleClickToTranslate.png"); 
		if (waitForObjectAppearOnRegion("pictures\\Browser_EnViDictionary_Checkbox_CheckedOptionDoubleClickToTranslate.png","pictures\\Browser_EnViDictionary_Checkbox_UnCheckBoxOptionDoubleClickToTranslate" ,-150,50,3))
		{
			setTestcaseStatus("FAILED", "Still NOT choose Checkbox ");
		}
		else
		{
			TestLogger.info(" PASS : Checked box");
		}
			
		
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
			hoverImage("pictures\\Website_w3school_text_Formatting.png");
			doubleClick("pictures\\Website_w3school_text_Formatting.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
			
			TestLogger.info("restart Coc Coc browser");
			doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
			sleep(1);
			s.type(Key.F4, Key.ALT);
			
			startCocCoc();
			s.type(Key.ESC);
			s.type("t", Key.CTRL);
			s.type(siteTest);
			s.type(Key.ENTER);
			if(waitForObjectPresent("pictures\\Website_w3school_text_Formatting.png", 20)){
				hoverImage("pictures\\Website_w3school_text_Formatting.png");
				doubleClick("pictures\\Website_w3school_text_Formatting.png");
				
				if(waitforObjectNotexist("pictures\\Browser_EnVnDictionary_Text_FormattingTranslationResult.png", 5))
				{
					openLink("coccoc://extensions/");
					clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
					clickOn("pictures\\Browser_EnViDictionary_Checkbox_CheckedOptionDoubleClickToTranslate.png");
					setTestcaseStatus("PASSED", "After re-start browser, EnVnDictionary not work");
				}
				else
				{
					openLink("coccoc://extensions/");
					clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
					clickOn("pictures\\Browser_EnViDictionary_Checkbox_CheckedOptionDoubleClickToTranslate.png");
					setTestcaseStatus("FAILED", "After re-start browser, EnVnDictionary still work");
				}
			}
			else
				setTestcaseStatus("SKIPED", "Cannot load web page again to test");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot load web page to test");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_14</br>
	 * <b> CaseTitle: </b>Check working of option 'Nhap vao tu can dich'</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions
	 * 2. Click on "Tùy chọn" to open option page of En-Vn Dictionary
	 * 3. Select "Nhập vào từ cần dịch"
	 * 4. Open some text area to add some english text, for example comment area on facebook
	 * 5. Select one word and right click
	 * 6. Select "Dịch:english"
	 * 7. Re-open option page and uncheck the option
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * If the option "Nhập vào từ cần dịch" is checked, translation should display in step 6. Otherwise no translation shows
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 21 Jul -2016
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_14(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_14: Check working of option 'Nhap vao tu can dich'");
		
		String siteTestTextArea = "http://giaitri.vnexpress.net/tin-tuc/phim/sau-man-anh/cac-vai-dien-kinh-dien-se-ra-sao-neu-thay-dien-vien-3440046-p5.html";;
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type(siteTestTextArea);
		s.type(Key.ENTER); 
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 300);
		s.click();
		if(waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 20)){
			scrollPageToObject("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			hoverImage("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			clickOn("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			
			s.type("format");
			hoverImage("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
			doubleClick("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVNDictionary_Text_FormatTranslationResult.png", 5))
				setTestcaseStatus("PASSED", "A pop-window shows to translate word");
			else
				setTestcaseStatus("FAILED", "Nothing pop-window shows to translate word");
			
			TestLogger.info("restart Coc Coc browser");
			doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
			s.type(Key.ESC);
			sleep(1);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			
			
			s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			openExtensionsPage();
			
			clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
			sleep(2);
			clickOn("pictures\\Browser_Settings_Checkbox_TranslateCheckedOptionInputWordToTranslate.png");
			
			
			s.type(Key.F4, Key.ALT);
			startCocCoc();
			s.type(Key.ESC);
			s.type("t", Key.CTRL);
			s.type(siteTestTextArea);
			s.type(Key.ENTER);
			if(waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 20)){
				scrollPageToObject("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
				hoverImage("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
				clickOn("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
				
				s.type("format");
				hoverImage("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
				doubleClick("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
				/*s.rightClick();
				clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");*/
				
				if(waitForObjectPresent("pictures\\Browser_EnVNDictionary_Text_FormatTranslationResult.png", 2))
				{
					s.type("t", Key.CTRL);
					openLink("coccoc://extensions/");
					clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
					clickOn("pictures\\Browser_Settings_Checkbox_TranslateCheckedOptionInputWordToTranslate.png");
					s.type(Key.F4, Key.ALT);
					
					if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
					{
						clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
					}
					
					
					setTestcaseStatus("PASSED", "After turn on trasnlate, EnVnDictionary work");
				}
				else
				{
					s.type("t", Key.CTRL);
					openLink("coccoc://extensions/");
					clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
					clickOn("pictures\\Browser_Settings_Checkbox_TranslateCheckedOptionInputWordToTranslate.png");
					s.type(Key.F4, Key.ALT);
					
					if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
					{
						clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
					}
					setTestcaseStatus("FAILED", "After turn on trasnlate, EnVnDictionary does not work");
				}
			}
			else
			{
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
				clickOn("pictures\\Browser_Settings_Checkbox_TranslateCheckedOptionInputWordToTranslate.png");
				setTestcaseStatus("SKIP", "Cannot load web page again to test");
			}
		}
		else
		{
			   openLink("coccoc://extensions/");
			   clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
			   clickOn("pictures\\Browser_Settings_Checkbox_TranslateCheckedOptionInputWordToTranslate.png");
			   setTestcaseStatus("SKIP", "Cannot load web page to test");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_15</br>
	 * <b> CaseTitle: </b>Check working of dictionary in textbox/input area without select "Nhập vào từ cần dịch""</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions
       2. Click on "Tùy ch?n" to open option page of En-Vn Dictionary
       3. Do not select "Nh?p vào t? c?n d?ch"
       4. Enter some English text into textbox/input area: "hello"
       5. double click or hightlight the English word ("hello") > right click
	 *  
	 * <b> ExpectedOutput: </b></br>
	 * The 2nd option "Nháy đúp để dịch từ sang tiếng Việt" should be dimmed
	 * @author huy.vu
	 * @Update HANV
	 * @date 16 mar -2017
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_15(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_15: Check working of dictionary in textbox/input area without select Nhập vào từ cần dịch");
		
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
		sleep(2);
		clickOn("pictures\\Browser_Settings_Checkbox_UnCheckedOptionInputWordToTranslate.png");
		if(waitForObjectPresent("pictures\\Browser_EnViDictionary_Checkbox_UncheckedOptionDoubleClickToTranslate.png", 2))
		{
			clickOn("pictures\\Browser_Settings_Checkbox_UnCheckedOptionInputWordToTranslate.png");
			setTestcaseStatus("PASSED", "The 2nd option 'nhay dup de dich sang Tieng Viet' be dimmed");
		}
		else
		{
			clickOn("pictures\\Browser_Settings_Checkbox_UnCheckedOptionInputWordToTranslate.png");
			setTestcaseStatus("FAILED", "The 2nd option 'nhay dup de dich sang Tieng Viet' still active");	
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_EnVnDictionary_16</br>
	 * <b> CaseTitle: </b>Check working of option "Nhap vao tu can dich" and "Nhay dup de dich tu sang tieng Viet" 2nd option</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://extensions
	 * 2. Click on "Tùy chọn" to open option page of En-Vn Dictionary
	 * 3. Select "Nhập vào từ cần dịch"
	 * 4. Then select "Nháy đúp để dịch từ sang tiếng Việt"
	 * 5. Open some text area to add some english text, for example comment area on facebook
	 * 6. Double click on some word
	 * 7. Re-open option page and deselect this option
	 *  
	 * <b> ExpectedOutput: </b></br>
	 * Translation should show when this option is checked. Otherwise no translation shows
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test(groups = {"Dependency"}) 
	public void Browser_SNIFF_EnVnDictionary_16(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_EnVnDictionary_16: Check working of option 'Nhap vao tu can dich' and 'Nhay dup de dich tu sang tieng Viet' 2nd options");
		String siteTestTextArea = "http://giaitri.vnexpress.net/tin-tuc/phim/sau-man-anh/cac-vai-dien-kinh-dien-se-ra-sao-neu-thay-dien-vien-3440046-p5.html";;
		openExtensionsPage();
		clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
		sleep(2);
		clickOn("pictures\\Browser_EnViDictionary_Checkbox_UncheckedOptionDoubleClickToTranslate.png");
		
		s.type("t", Key.CTRL);
		s.type(siteTestTextArea);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 20)){
			scrollPageToObject("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			hoverImage("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			clickOn("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
			
			s.type("format");
			hoverImage("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
			doubleClick("pictures\\Browser_EnViDictionary_Text_FormatTextToTranslate.png");
			s.rightClick();
			clickOn("pictures\\Browser_EnViDictionary_Text_Translate.png");
			
			if(waitForObjectPresent("pictures\\Browser_EnVNDictionary_Text_FormatTranslationResult.png", 2))
			{
				
				s.type("t", Key.CTRL);
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
				clickOn("pictures\\Browser_EnViDictionary_Checkbox_UncheckedOptionDoubleClickToTranslate.png");
				s.type(Key.F4, Key.ALT);
				
				if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
				{
					clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
				}
				
				setTestcaseStatus("PASSED", "After turn of trasnlate, EnVnDictionary work");
			}
			else
			{
				s.type("t", Key.CTRL);
				openLink("coccoc://extensions/");
				clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
				clickOn("pictures\\Browser_EnViDictionary_Checkbox_UncheckedOptionDoubleClickToTranslate.png");
				s.type(Key.F4, Key.ALT);
				
				if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
				{
					clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
				}
				
				setTestcaseStatus("FAILED", "After turn of trasnlate, EnVnDictionary does NOT work");
			}
		}
		else
		{
			s.type("t", Key.CTRL);
			openLink("coccoc://extensions/");
			clickOnRegion("pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png", "pictures\\Browser_Settings_LinkText_ExtensionOptions.png", 550,185);
			clickOn("pictures\\Browser_EnViDictionary_Checkbox_UncheckedOptionDoubleClickToTranslate.png");
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("SKIPED", "Cannot load web page again to test");
		}
	}
}
