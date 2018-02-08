package browser_Testsuite_Windows;

import java.io.File;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.TestLogger;

public class Browser_Windows_OtherSettings extends BrowserCommon_Extensions{
	
	//define global variable
	private String userprofile = System.getenv("USERPROFILE");
	int timeout = 5;
	
	//Pre-condition
	//@BeforeClass
	public void beforTestSuite(){
		TestLogger.info("----------------------------TEST SNIFF FOR other Settings----------------------");
		String domainDownloadCocCoc = getCocCocVersion("config\\coccocVersion.txt")[0];
		if(DownloadCCBrowser(domainDownloadCocCoc)){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		}
		else
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
	}
	
	@AfterMethod
	public void preconditionMethod(){
		closeBrowser();
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_01</br>
	 * <b> CaseTitle: </b>Check sync data with Google account</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
       2. In "Sign in" part, click on "Sign in to Cốc Cốc", and implement to sign in with Google account
       3. Set up sync settings 
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. Sign in successfully
       2. Bookmarks and extensions are loaded automatically if have in Google account before
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	@Test
	public void Browser_SNIFF_OtherSettings_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_01: Check sync data with Google account");
		UninstallAndClearAllData("");
		InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
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
		
		SigninToCocCoc(userNameGmail6, passwordGmail6);
		openLink("coccoc://extensions/");
		if (waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 15) && (waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 15)))
		{
			setTestcaseStatus("PASSED", "2. Extensions are loaded automatically ");
		}
		else
		{
			setTestcaseStatus("FAILED", "2. Extensions are NOT loaded automatically ");
		}
		
		openLink("coccoc://bookmarks/");
		
		if (waitForObjectPresent("pictures\\Browser_BookMark_icon_Vnexpress.png", 5))
		{
			setTestcaseStatus("PASSED", "2. Bookmarks are loaded automatically ");
		}
		
		else
		{
			setTestcaseStatus("FAILED", "2. Bookmarks are NOT loaded automatically ");
		}
		
	
		
		
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_02</br>
	 * <b> CaseTitle: </b>Check disconnect Google account</br>
	 * <b> Steps: </b></br>
	 *     1. Open chrome://settings/
           2. In "Sign in" part, make sure that any account is logged in
           3. Click "Disconnect Google Account"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *     1. Account is logged out successfully
           2. Bookmarks and extensions are still remained on browser, still can change but not save into account
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	
	@Test 
	public void Browser_SNIFF_OtherSettings_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_02: Check disconnect Google account");
		startCocCocInEnglish();
		 openLink("coccoc://settings/#coccoc-settings-users");
		  // Disconnect Google Account
		    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
			clickOn("pictures\\Browser_Settings_Menu_User.png");
			waitForObjectPresent("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png", 7);
			clickOn("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png");
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
			
			
			openLink("coccoc://extensions/");
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 15) && (waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 15)))
			{
				setTestcaseStatus("PASSED", "2. Extensions are still remained on browser");
			}
			else
			{
				setTestcaseStatus("FAILED", "2. Extensions are still NOT remained on browser, ");
			}
			
			openLink("coccoc://bookmarks/");
			
			if (waitForObjectPresent("pictures\\Browser_BookMark_icon_Vnexpress.png", 5))
			{
				setTestcaseStatus("PASSED", "2.Bookmarks are still remained on browser  ");
			}
			
			else
			{
				setTestcaseStatus("FAILED", "2. Bookmarks are NOT still remained on browser");
			}
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_03</br>
	 * <b> CaseTitle: </b>Check setting when start up browser (open newtab)</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "On startup" part, tick to select "Open the New Tab page"
	 * 3. Access some websites and close browser
	 * 4. Reopen browser
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Browser is opened with only one tab is New Tab
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	
	
	@Test
	public void Browser_SNIFF_OtherSettings_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_03: Check setting when start up browser (open newtab)");
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Text_GeneralOpenNewtabOnStartupOption.png");
		accessVideoFromURL();
		openLink("http://vnexpress.net/");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//restart coc coc
		s.type(Key.F4, Key.ALT);
		sleep(2);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		if(waitForObjectPresent("pictures\\Browser_Tabs_Text_OnlyOneNewtabDisplayVN.png", 20))
			setTestcaseStatus("PASSED", "Browser is opened with only one tab is New Tab");
		else
			setTestcaseStatus("FAILED", "Browser doesn't open with only one tab is New Tab");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_04</br>
	 * <b> CaseTitle: </b>Check setting when start up browser (open accessing websites)</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "On startup" part, tick to select "Continue where I left off"
	 * 3. Access some websites and close browser
	 * 4. Reopen browser
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Browser is opened with all tabs as before close browser
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_04: Check setting when start up browser (open accessing websites)");
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Text_GeneralContinueWhereYouLeftOffOption.png");
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		openLink(URLVideo);
		waitForObjectPresent("pictures\\Browser_Tabs_Text_LastOpenedTab.png", 20);
		//restart coc coc
		s.type(Key.F4, Key.ALT);
		sleep(2);
		s.type("d", Key.WIN);
		sleep(1);
		s.type(Key.UP);
		s.type(Key.UP);
		waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 5);
		doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		
		if(waitForObjectPresent("pictures\\Browser_Tabs_Text_LastOpenedTab.png", 20))
			setTestcaseStatus("PASSED", "Browser is opened with all tabs as before close browser");
		else
			setTestcaseStatus("FAILED", "Browser doesn't open with all tabs as before close browser");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_05</br>
	 * <b> CaseTitle: </b>Check setting when start up browser (open specific websites)</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "On startup" part, tick to select "Open a specific page or set of pages." and click on "Set pages" to use url which user wish
	 * 3. Access some websites and close browser
	 * 4. Reopen browser
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Browser is opened with specific page which user set before
	 * @author huy.vu
	 * @Update HANV
	 *
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_05(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_05: Check setting when start up browser (open specific websites)");
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Text_GeneralOpenNewtabOnStartupOption.png");
		s.type(Key.F4, Key.ALT);
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Text_GeneralSetPagesOption.png");
		sleep(1);
		clickOn("pictures\\Browser_Settings_TextArea_GeneralSetPagesEnterURL.png");
		s.type("http://vnexpress.net/");
		s.type(Key.ENTER);
		sleep(1);
		clickOn("pictures\\Browser_Settings_TextArea_GeneralSetPagesEnterURL.png");
		s.type("http://dantri.com.vn/");
		clickOn("pictures\\Browser_Settings_Text_TitlePageStartUp.png");
		sleep(1);
		clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesOK.png");
		waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 5); 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//restart coc coc
		s.type(Key.F4, Key.ALT);
		sleep(2);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		if(waitForObjectPresent("pictures\\Browser_Tabs_Text_LastOpenedPageCoccoc1.png", 20) && (waitForObjectPresent("pictures\\Browser_Tabs_Text_LastOpenedPageCoccoc2.png", 20)))
		{
			openLink("coccoc://settings/#coccoc-settings-general");
			clickOn("pictures\\Browser_Settings_Text_GeneralOpenNewtabOnStartupOption.png");
			setTestcaseStatus("PASSED", "Browser is opened with specific page which user set before");
		}
		else
		{
			openLink("coccoc://settings/#coccoc-settings-general");
			clickOn("pictures\\Browser_Settings_Text_GeneralOpenNewtabOnStartupOption.png");
			setTestcaseStatus("FAILED", "Browser doesn't opene with specific page which user set before");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_06</br>
	 * <b> CaseTitle: </b>Check setting for Appearance to get theme</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, click on "Get themes" will redirect to google web store
	 * 3. Select any theme to use
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * New theme will apply on browser immediately
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_06(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_06: Check setting for Appearance to get theme");
		
		//Open google store and add theme into Coc Coc
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("https://chrome.google.com/webstore/detail/raindropsnon-aero/dpagcfbbmlebfnkeogkigellbgmfkjfg?hl=vi");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_Settings_Button_AddNewThemeToBrowser.png", 30);
		clickOn("pictures\\Browser_Settings_Button_AddNewThemeToBrowser.png");
		waitForObjectPresent("pictures\\Browser_Settings_Button_ThemeAddedToBrowser.png", 30);
		sleep(2);
		s.type(Key.ESC);
		sleep(2);
		
		s.type(Key.F4, Key.ALT);
		sleep(2);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		if(waitForObjectPresent("pictures\\Browser_Tabs_Picture_NewThemeApplied.png", timeout))
			setTestcaseStatus("PASSED", "Browser is opened with specific page which user set before");
		else
			setTestcaseStatus("FAILED", "Browser doesn't opene with specific page which user set before");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_07</br>
	 * <b> CaseTitle: </b>Check setting for Appearance to remove theme</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. Make sure that you is using any theme
	 * 3. In "Appearance" part, click on "Reset to default theme"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Default theme will be used and applied on browser immediately
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_07(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_07: Default theme will be used and applied on browser immediately");
		
		//Open google store and add theme into Coc Coc
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("https://chrome.google.com/webstore/detail/raindropsnon-aero/dpagcfbbmlebfnkeogkigellbgmfkjfg?hl=vi");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_Settings_Button_AddNewThemeToBrowser.png", 30);
		clickOn("pictures\\Browser_Settings_Button_AddNewThemeToBrowser.png");
		waitForObjectPresent("pictures\\Browser_Settings_Button_ThemeAddedToBrowser.png", 30);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		sleep(2);
		
		//reset to default theme
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Menu_ViewSetting.png");
		waitForObjectPresent("pictures\\Browser_Settings_Button_ViewResetDefaultThemeOption.png", 10);
		clickOn("pictures\\Browser_Settings_Button_ViewResetDefaultThemeOption.png");
		s.type(Key.F4, Key.ALT);
		sleep(2);
		if(startCocCoc()){
			if(waitforObjectNotexist("pictures\\Browser_Tabs_Picture_NewThemeApplied.png", timeout))
				setTestcaseStatus("PASSED", "Default theme will be used and applied on browser immediately");
			else
				setTestcaseStatus("FAILED", "Default theme is NOT used and applied on browser immediately");
		}
		else
			setTestcaseStatus("SKIPED", "Cannot start Coc Coc");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_08</br>
	 * <b> CaseTitle: </b>Check setting to show Home button as New Tab button</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, tick on "Show Home button"
	 * 3. Click "Change", select "Use the New Tab page", click OK
	 * 4. Click button Home before omnibox
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * After click on Home button, 1 new tab is opened
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_08(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_08: Check setting to show Home button as New Tab button");
		
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Menu_ViewSetting.png");
		sleep(1);
		clickOnRegion("pictures\\Browser_Settings_Button_DownloadTheme.png", "pictures\\Browser_Setings_Checkbox_ShowHomePage.png", 50, 60);
		sleep(1);

			clickOn("pictures\\Browser_Omnibox_Icon_HomeButton.png");
			if(waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png", 20)) 
			{
				openLink("coccoc://settings/#coccoc-settings-view");
				clickOn("pictures\\Browser_Settings_Text_ViewShowHomeButtonOption.png");
				setTestcaseStatus("PASSED", "After click on Home button, 1 new tab is opened");
			}
			else
			{
				openLink("coccoc://settings/#coccoc-settings-view");
				clickOn("pictures\\Browser_Settings_Text_ViewShowHomeButtonOption.png");
				setTestcaseStatus("FAILED", "After click on Home button, 1 new tab doesn't open");
			}
		
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_09</br>
	 * <b> CaseTitle: </b>Check setting to show Home button as specific page</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, tick on "Show Home button"
	 * 3. Click "Change", select "Open this page", and type specific page, then OK
	 * 4. Click button Home before omnibox
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * After click on Home button, specific page is opened
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	@Test
	public void Browser_SNIFF_OtherSettings_09(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_09: Check setting to show Home button as New Tab button");
		
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Menu_ViewSetting.png");
		sleep(2);
		
		clickOnRegion("pictures\\Browser_Settings_Button_DownloadTheme.png", "pictures\\Browser_Setings_Checkbox_ShowHomePage.png", 50, 60);
		sleep(1);
		openLink("coccoc://settings/#coccoc-settings-view");
		clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesChangeURLHomepageOption.png");
		clickOn("pictures\\Browser_Settings_Text_GeneralOpenSpecificPageOrSetOfPage.png");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Settings_Text_GeneralOpenSpecificPageOrSetOfPage.png", 128);
		s.click();
		s.type("a",Key.CTRL);
		s.type("coccoc.com");
		clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesOK.png");
		sleep(1);
		
		clickOn("pictures\\Browser_Omnibox_Icon_HomeButton.png");
		
		if(waitForObjectPresent("pictures\\Website_coccoc_Button_DownloadBrowser.png", 20))
		{
			
			openLink("coccoc://settings/#coccoc-settings-view");
			clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesChangeURLHomepageOption.png");
			clickOn("pictures\\Browser_Settings_Button_UseNewTab.png");
			clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesOK.png");
			
			setTestcaseStatus("PASSED", "After click on Home button, 1 new tab is opened");
		}
		else
		{
			
			openLink("coccoc://settings/#coccoc-settings-view");
			clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesChangeURLHomepageOption.png");
			clickOn("pictures\\Browser_Settings_Button_UseNewTab.png");
			clickOn("pictures\\Browser_Settings_Button_GeneralSetPagesOK.png");
			setTestcaseStatus("FAILED", "After click on Home button, 1 new tab doesn't open");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_10</br>
	 * <b> CaseTitle: </b>Check setting to hiden Home button</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, don't tick on "Show Home button"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Don't have Home button before omnibox anymore
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_10(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_10: Check setting to hiden Home button");
		
		startCocCoc();
		openLink("coccoc://settings/#coccoc-settings-view"); 
		clickOn("pictures\\Browser_Settings_Text_ViewShowHomeButtonOption.png");
		if(!waitForObjectPresent("pictures\\Browser_Omnibox_Icon_HomeButton.png", 1))
			setTestcaseStatus("PASSED", "Don't have Home button before omnibox anymore");
		else
			setTestcaseStatus("FAILED", "After click on Home button, 1 new tab doesn't open");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_11</br>
	 * <b> CaseTitle: </b>Check setting to unshow Bookmarks bar</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, don't tick on "Always show the bookmarks bar"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *Don't display the bookmarks bar under address bar
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_11(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_11: Check setting to unshow Bookmarks bar");
		
		openSettingsPage();

		clickOn("pictures\\Browser_Settings_Menu_ViewSetting.png");
		if (waitForObjectPresent("pictures\\Browser_Users_Checkbox_BookMarkChecked.png",15))
		clickOn("pictures\\Browser_Users_Checkbox_BookMarkChecked.png");
		
		if(waitforObjectNotexist("pictures\\Browser_MenuBar_Button_RecentClosedTabs.png", 3))
			setTestcaseStatus("PASSED", "Bookmarks bar not show under address bar");
		else
			setTestcaseStatus("FAILED", "Bookmarks bar shows under address bar");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_12</br>
	 * <b> CaseTitle: </b>Check setting to show Bookmarks bar</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Appearance" part, tick on "Always show the bookmarks bar"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *Don't display the bookmarks bar under address bar
	 * @Update HANV
	 *
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_12(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_12: Check setting to show Bookmarks bar");
		
		openSettingsPage();
		
		clickOn("pictures\\Browser_Settings_Menu_ViewSetting.png");
		if (waitForObjectPresent("pictures\\Browser_Users_Checkbox_BookMarkUnCheck.png",15))
			clickOn("pictures\\Browser_Users_Checkbox_BookMarkUnCheck.png");
		
		sleep(1);
				
		if(waitForObjectPresent("pictures\\Browser_MenuBar_Button_RecentClosedTabs.png", 20))
		{
			
			setTestcaseStatus("PASSED", "Bookmarks bar shows under address bar");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "Bookmarks bar not show under address bar");
		}
	}
	
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_13</br>
	 * <b> CaseTitle: </b>Check add new user for browser</br>
	 * <b> Steps: </b></br>
	 *     1. Open chrome://settings/
           2. In "Users" part, click on "Add new user"
           3. Select a picture and name and create
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *     1. New window of browser is displayed with picture at the right corner of window
           2. In chrome://settings/: have at least 2 user. 1 user with selected name and picture (have "current" status in the end)
	 * @Update HANV
	 *
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_13(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_13: Check add new user for browser");
		
		openSettingsPage();
		openLink("coccoc://settings/#coccoc-settings-users");
		clickOn("pictures\\Browser_Settings_Button_AddUserVN.png");
		clickOn("pictures\\Browser_Settings_Avatar_UserDog.png"); 
		clickOn("pictures\\Browser_Users_Button_Add.png");
		
		if (waitForObjectPresent("pictures\\Browser_Settings_icon_UserDog.png", 5))
		{
			setTestcaseStatus("PASSED", "1. New window of browser is displayed with picture at the right corner of window");
		}
		else
		{
			setTestcaseStatus("FAILED", "1. New window of browser is NOT displayed with picture at the right corner of window");
		}
		
		openLink("coccoc://settings/#coccoc-settings-users");
		
		if (waitForObjectPresent("pictures\\Browser_SettingsUser_icon_TwoPerson.png", 5))
		{
			setTestcaseStatus("PASSED", "2. In chrome://settings/: have at least 2 user. 1 user with selected name and picture (have current status in the end)");
		}
		else
		{
			setTestcaseStatus("FAILED", "2. In chrome://settings/: have NOT at least 2 user. 1 user with selected name and picture (have current status in the end)");
		}
		
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_14</br>
	 * <b> CaseTitle: </b>Check remove 1 user for browser</br>
	 * <b> Steps: </b></br>
	 *         1. Open chrome://settings/
               2. In "Users" part, click on "Add new user"
               3. Select a picture and name and create
               4. In chrome://settings/: click on x icon at the end of user name
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *     User is deleted
	 * @Update HANV
	 *
	 */
	
	@Test
	public void Browser_SNIFF_OtherSettings_14(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_14: Check remove 1 user for browser");
        openLink("coccoc://settings/#coccoc-settings-users"); 
        clickOn("pictures\\Browser_Settings_Avatar_UserDog.png");
		clickOn("pictures\\Browser_Settings_Button_RemoveSite.png");
		clickOn("pictures\\Browser_UserPage_Button_DeteteVN.png");
		if (waitForObjectPresent("pictures\\Browser_SettingsUser_icon_TwoPerson.png", 5))
		{
			setTestcaseStatus("FAILED", "User is NOT deleted");
		}
		else
		{
			setTestcaseStatus("PASSED", "User is deleted");
		}
		
	}
	
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_15</br>
	 * <b> CaseTitle: </b>Check import bookmarks and settings</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Users" part, click on "Import bookmarks and settings"
	 * 3. Choose browser and items to import
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. Import successfully
	 * 2. Check bookmarks and settings to see the changes
	 * @author huy.vu
	 * @Update HANV
	 * @date 27 March 2017
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_15(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_15: Check import bookmarks and settings");
		// open Chrome browser 
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
		// open an URL to bookmark 
		s.type("https://www.tutorialspoint.com/cucumber/cucumber_java_testing.htm");
		s.type(Key.ENTER);
		clickOn("pictures\\Browser_AdressBar_icon_Favorite.png");
		clickOn("pictures\\Browser_BookMark_Button_Done.png"); 
		s.type(Key.F4, Key.ALT);
		// close Chrome browser 
		
		
		// start CocCoc and open settings page 
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Menu_UsersSetting.png");
		sleep(1);
		clickOn("pictures\\Browser_Settings_Button_UsersImportBookmark.png");
		sleep(1);
		clickOn("pictures\\Browser_BookmarkSettings_DropList_InternerExplorer.png");
		clickOn("pictures\\Browser_BookmarkSettings_DropList_Chrome.png");
		clickOn("pictures\\Browser_Settings_Button_UsersConfirmImportBookmark.png");
		sleep(1);
		
		
		if(waitForObjectPresent("pictures\\Browser_Settings_Text_UsersImportBookMarkSuccesfull.png", 20) )
		{
			openLink("coccoc://bookmarks/");
			if (waitForObjectPresent("pictures\\Browser_BookMark_icon_tutorial.png", 5))
			{
			setTestcaseStatus("PASSED", "Import Bookmark successfully");
			}
			else
			{
				setTestcaseStatus("FAILED", "Import Bookmark unsuccessfully");
			}
		}
		else
		{
			setTestcaseStatus("FAILED", "Import unsuccessful");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_16</br>
	 * <b> CaseTitle: </b>Check make Cốc Cốc default browser in settings</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Default browser" part, click on "Make Cốc Cốc my default browser"
	 * 3. Click any link from other application
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. In "Default browser" part, display message: " The default browser is currently Cốc Cốc"
	 * 2. That link is opened in Cốc Cốc browser
	 * @author huy.vu
	 * @Update hanv
	 * @date 22 Aug 2016
	 * 
	 * NOTE : there is NOT this case in Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx
	 * However, i still keep this case in case of update in the future 
	 */
	//@Test
	public void Browser_SNIFF_OtherSettings_16a(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_16: Check make Cốc Cốc default browser in settings");
		
		setIEasDefaultbrowser();
		
		openSettingsPage();
		if(checkMessageSetDefaulBrowserOnSettingsPage()){
			
			clickOn("pictures\\Browser_Setting_Button_GeneralMakeCocCocAsDefaultBrowser.png");
			sleep(1);
			s.type(Key.F4, Key.ALT);
			sleep(2);
			killprocess("browser.exe");
			sleep(2);
			
			//open Notepad and make a link:
			s.type("r", Key.WIN);
			waitForObjectPresent("pictures\\OSApp_Run_Picture_RunIcon.png", 10);
			s.type("wordpad");
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\OSApp_WordPad_Text_WordpadTitlebar.png", 10);
			sleep (3);
			s.type("http://coccoc.com");
			s.type(Key.ENTER);
			//click and confirm on link:
			clickOn("pictures\\OSApp_WordPad_Text_CoccocLink.png");
			sleep(1);
			clickOn("pictures\\OSApp_WordPad_Button_YesOption.png");
			
			//check Coccoc is opened
			killprocess("wordpad.exe");
			if(waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 10))
				setTestcaseStatus("PASSED", "That link is opened in Coc Coc browser");
			else
				setTestcaseStatus("FAILED", "That link is not open in Coc Coc browser");
		}
		else
			setTestcaseStatus("FAILED", "In Default browser part, display message:The default browser is NOT currently  Coc Coc");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_17</br>
	 * <b> CaseTitle: </b>Check make Cốc Cốc default browser in message after open browser</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Default browser" part, click on "Make Cốc Cốc my default browser"
	 * 3. Click any link from other application
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. In "Default browser" part, display message: " The default browser is currently Cốc Cốc"
	 * 2. That link is opened in Cốc Cốc browser
	 * @author hanv
	 * @Update huy.vu
	 * @date 22 Aug 2016
	 * NOTE : there is NOT this case in Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx
	 * However, i still keep this case in case of update in the future 
	 */
	//@Test
	public void Browser_SNIFF_OtherSettings_17a(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_17: Check make  Coc Coc default browser in message after open browser");
		
        setIEasDefaultbrowser();
		startCocCoc();
		// Click Set as default
		if (waitForObjectPresent("pictures\\Browser_popup_Button_SetBrowserDefault.png", 5))
		{
			clickOn("pictures\\Browser_popup_Button_SetBrowserDefault.png");
		}
		openLink("coccoc://settings/#coccoc-settings-general");
		sleep (2);
		
		
		if (waitForObjectPresent("pictures\\Browser_Settings_Text_GeneralCoccocIsYourDefaultBrowser.png", 5))
			setTestcaseStatus("PASSED", "PASSED=>  In Default browser part, display message:The default browser is currently  Coc Coc");
		else
			setTestcaseStatus("FAILED", "FAILED=>  In Default browser part, display message:The default browser is NOT currently  Coc Coc");
		//close coc coc:
		sleep(1);
		s.type(Key.F4, Key.ALT);
		sleep(2);
		killprocess("browser.exe");
		sleep(2);
		
		
		//open Notepad and make a link:
		s.type("r", Key.WIN);
		waitForObjectPresent("pictures\\OSApp_Run_Picture_RunIcon.png", 10);
		s.type("wordpad");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\OSApp_WordPad_Text_WordpadTitlebar.png", 10);
		
		sleep (3);
		s.type("http://coccoc.com");
		s.type(Key.ENTER);
		//click and confirm on link:
		clickOn("pictures\\OSApp_WordPad_Text_CoccocLink.png");
		sleep(1);
		clickOn("pictures\\OSApp_WordPad_Button_YesOption.png");
		
		//check Coccoc is opened
		killprocess("wordpad.exe");
		if(waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 10))
			setTestcaseStatus("PASSED", "That link is opened in Coc Coc browser");
		else
			setTestcaseStatus("FAILED", "That link is not open in Coc Coc browser");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_18</br>
	 * <b> CaseTitle: </b>Check work of privacy settings</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Privacy" part, click on "Content settings..."
	 * 3. Select option for Cookies, Images …
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Make sure that they are applied well
	 * @author hanv
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_16(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_18: Check work of privacy settings");
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Text_PrivacySetting.png");
		TestLogger.info("2. In Privacy part, click on Content settings...");
		TestLogger.info("Choose Option: don't show image on any websites ");
		clickOn("pictures\\Browser_Settings_Button_ContentSetting.png");
		clickOn("pictures\\Browser_Settings_Radio_ContentSetting-DontShowAnyImages.png");
		clickOn("pictures\\Browser_Settings_Button_ContentSettingOK.png");
		TestLogger.info("#2.EXPECT : Make sure that image NOT SHOWED in any websites.");
		openLink("www.dantri.com.vn");
		if (waitforObjectNotexist("pictures\\Website_Dantri_Picture_DantriLogo.png", 3))
		{
			
			openLink("coccoc://settings/#coccoc-settings-privacy");
			clickOn("pictures\\Browser_Settings_Button_ContentSetting.png");
			clickOn("pictures\\Browser_Settings_Button_DisplayImages.png");
			clickOn("pictures\\Browser_Settings_Button_ContentSettingOK.png");
			setTestcaseStatus("PASSED", "Make sure that image NOT SHOWED in any websites ");
		}
		else
		{
			openLink("coccoc://settings/#coccoc-settings-privacy");
			clickOn("pictures\\Browser_Settings_Button_ContentSetting.png");
			clickOn("pictures\\Browser_Settings_Button_DisplayImages.png");
			clickOn("pictures\\Browser_Settings_Button_ContentSettingOK.png");
			setTestcaseStatus("FAILED", " image STILL be SHOWED in any websites ");
		}
	} 
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_19</br>
	 * <b> CaseTitle: </b>Check clear browsing data</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Privacy" part, click on "Clear browsing data..."
	 * 3. Select period of time and item to delete
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Data is deleted successfully
	 * @author hanv
	 * @Update huy.vu
	 * @date 22 Aug 2016
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_17(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_17: Check clear browsing data");
		startCocCoc();
		openLink("http://vnexpress.net/");
		sleep(3);
		openLink("http://dantri.com.vn/");
		sleep(3);
		openLink("http://www.nhaccuatui.com/vh/auto/l1YSP9LqdsLZ1");
		sleep(3);
		openSettingsPage();
		
        clickOn("pictures\\Browser_Settings_Text_PrivacySetting.png");
        clickOn("pictures\\Browser_Settings_Button_PrivacyClearBrowsingData.png");
        clickOn("pictures\\Browser_Setting_Button_PrivacyDropDownMenu.png");
        s.type("m");
        s.type(Key.ENTER);
        s.type(Key.TAB);
        s.type(Key.ENTER);
        sleep(10);
        openLink("coccoc://history/");
        TestLogger.info("EXPECT : #2 Data is deleted successfully "); 
        if (waitForObjectPresent("pictures\\Browser_Settings_Text_PrivacyConfirmBrowsingDataDeleted.png", 5)) 	
        	setTestcaseStatus("PASSED", "Data is deleted successfully ");
        else
        	setTestcaseStatus("FAILED", "Data is NOT deleted successfully ");
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_18</br>
	 * <b> CaseTitle: </b>Check if "Automaticcally send usage statistics and crash reports to Coc Coc" is checked ON</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://settings/
       2. In "Privacy" part, observe "Automaticcally send usage statistics and crash reports to Cốc Cốc" checkbox
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Make sure that this option is checked ON
	 * @author hanv
	 * @date 5 june 2017
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_18(){
		
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_18: Check if Automaticcally send usage statistics and crash reports to Coc Coc is checked ON");
		startCocCoc();
		TestLogger.info("1. Open coccoc://settings/");
		openLink("coccoc://settings/#coccoc-settings-privacy");
		TestLogger.info("2. In Privacy part, observe Automaticcally send usage statistics and crash reports to Coc Coc checkbox");
		TestLogger.info("Check that : Make sure that this option is checked ON ");
		
		if (waitForObjectPresent("pictures\\CocCoc_settingsPrivacy_Checkbox_checkedAutomaticSendStatisticsandCrashReportstoCocCoc.png", 3))
		{
			setTestcaseStatus("PASSED", "this option is checked ON");
		}
		else
		{
			setTestcaseStatus("FAILED", "this option is NOT checked ON");
		}
		
		
	}
	
	

	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_30</br>
	 * <b> CaseTitle: </b>Check clear browsing data</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Privacy" part, click on "Clear browsing data..."
	 * 3. Select period of time and item to delete
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Data is deleted successfully
	 * @author hanv
	 * @Update huy.vu
	 * @date 2- June 2017
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_30(){ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_30: Check change language for browser and check spelling");
		startCocCoc();
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
		
		if (waitForObjectPresent("pictures\\Browser_Tabs_Text_NewtabTitleInEnglish.png", 5))
			setTestcaseStatus("PASSED", "displayed proper language which is selected for Coc coc Browser");
		else
			setTestcaseStatus("FAILED", "NOT displayed proper language which is selected  for Coc coc Browser ");
		openLink("https://www.wikipedia.org/");
		waitForObjectPresent("pictures\\Website_Wikipedia_TextArea_SearchBox.png",30);
		clickOn("pictures\\Website_Wikipedia_TextArea_SearchBox.png");
		sleep(1);
		s.type("i lovess you ") ;
		
		if (waitForObjectPresent("pictures\\Browser_SpellChecker_Text_ErrorSpellLovess.png", 5) )
			setTestcaseStatus("PASSED", "Type text into textarea box and check spell work with proper language");
		else
			setTestcaseStatus("FAILED", "Type text into textarea box and check spell DOES NOT work with proper language");
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_33</br>
	 * <b> CaseTitle: </b>Check if Widevine Content Decryption Module works well on CC Browser</br>
	 * <b> Steps: </b></br>
        1. Open browser
        2. Play some videos on:
         http://demo.castlabs.com/
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *   Make sure that we can play videos which has been decrypted with DRM: com.widevine.alpha (via Common Encryption)
	 * @author hanv
	 * @date 5 june 2017
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_33(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_33:Check if Widevine Content Decryption Module works well on CC Browser ");
		startCocCoc();
		openLink("https://demo.castlabs.com/");
        clickOn("pictures\\site_castlabs_image_logo.png");
        
        // Scroll down until see DRM button 
        while (waitforObjectNotexist("pictures\\site_castlabs_button_DRM.png", 2))
        {
        	s.type(Key.DOWN);
        	sleep(1);
        	s.type(Key.DOWN);
        	sleep(1);
        	s.type(Key.DOWN);
        	sleep(1);
        	s.type(Key.DOWN);
        	sleep(1);
        	s.type(Key.DOWN);
        	sleep(1);
        	s.type(Key.DOWN);
        }
        // Click DRM button to open DRM Video
        
        clickOn("pictures\\site_castlabs_button_DRM.png");
        
		waitForObjectPresent("pictures\\site_castlabs_button_play.png", 24);
		
		clickOn("pictures\\site_castlabs_button_play.png");
		
		if (waitForObjectPresent("pictures\\site_castlabs_button_pause.png", 4))
		{
			setTestcaseStatus("PASSED", "we can play videos on http://demo.castlabs.com/ which has been decrypted with DRM: com.widevine.alpha (via Common Encryption)");
		}
		else
		{
			setTestcaseStatus("FAILED", "we can NOT play videos on http://demo.castlabs.com/ which has been decrypted with DRM: com.widevine.alpha (via Common Encryption)");
		}
		 
	}
	
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_34</br>
	 * <b> CaseTitle: </b>Check if hint "You can search the Internet from here" is shown when users access google.com</br>
	 * <b> Steps: </b></br>
      '1. Open CC Browser
       2. Access google.com by some ways:
        - Input "google.com" directly to Omnibox
        - click "google.com" on most visited site if have
       3. Observe google.com page after accessing this page
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *   '2. google.com page is opened
          3. Make sure that hint "You can search the internet from here" is shown 
	 * @author hanv
	 * @date 5 june 2017
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_34(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_34:Check if hint You can search the Internet from here is shown when users access google.com");
		startCocCoc();
		openLink("google.com");
		
		if (waitForObjectPresent("pictures\\Browser_BubbleDialog_Text_Welcomepage.png", 4))
		{
			setTestcaseStatus("PASSED", "The hint 'You can search the internet from here' is shown ");
		}
		else
		{
			setTestcaseStatus("FAILED", "The hint 'You can search the internet from here' NOT is shown ");
		}
		 
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_27</br>
	 * <b> CaseTitle: </b>Check clear browsing data</br>
	 * <b> Steps: </b></br>
	 * 1. Open chrome://settings/
	 * 2. In "Download" part, change path for download folder
	 * 3. Download something
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Downloaded file is displayed in download folder in new path
	 * @author hanv
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_OtherSettings_27(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_27: Check change download location");
		
		String userprofile = System.getenv("USERPROFILE");
		String filePath = userprofile + "\\Desktop";
		boolean isFileDownloadToLocation = false;
		File fileTestDownload = new File(filePath + "\\coccoc_vi.exe");
		//make sure file test not exist
		DeleteFileAndFolderInSpecificPath(fileTestDownload);
		//Change location for downnload
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Menu_DownloadAndTorrentSetting.png");
		clickOn("pictures\\Browser_Settings_Button_DownloadLocationChange.png");
		clickOn("pictures\\OSApp_Desktop_icon_Computer.png");
		s.type(Key.ENTER);
		//access and download coccoc file
		openLink("http://dev.coccoc.com/vi/win/thanks.html");
		sleep(15);
		isFileDownloadToLocation = (fileTestDownload.exists() && fileTestDownload.isFile());
		fileTestDownload.delete();
		if (isFileDownloadToLocation)
			setTestcaseStatus("PASSED", "Downloaded file is displayed in download folder in new path");
		else
			setTestcaseStatus("FAILED", "Downloaded file is NOT displayed in download folder in new path");
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>Browser_SNIFF_OtherSettings_28</br>
	 * <b> CaseTitle: </b>Check run background apps when Cốc Cốc is closed</br>
	 * <b> Steps: </b></br>
	 *   1. Open chrome://settings/
         2. In "System" part, tick on "Continue running background apps when Cốc Cốc is closed"
         3. Make sure that have apps is running
         4. Closed browser  
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Check in tray, still icon for apps of Cốc Cốc browser
	 * @author hanv
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_OtherSettings_28(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_OtherSettings_28: Check run background apps when Cốc Cốc is closed");
		openSettingsPage();
		clickOn("pictures\\Browser_Settings_Button_Other.png"); 
		
		clickOnRegion("pictures\\Browser_Settings_Text_System.png", "pictures\\Browser_Setings_Checkbox_ShowHomePage.png", 100, 160);
		
		// install an app on Browser 
		openLink("https://chrome.google.com/webstore/detail/google-keep-notes-and-lis/hmjkmjkepdijhoojdojkdfohbdgmmhki?hl=vi"); 
		clickOn("pictures\\Browser_Settings_Button_AddNewThemeToBrowser.png");
		clickOn("pictures\\Website_GoogleStore_Button_AddExtensionVN.png");
		openLink("coccoc://apps/"); 
		if (waitForObjectPresent("pictures\\Browser_Apps_icon_GoogleKeep.png", 25))
		{
			clickOn("pictures\\Browser_Apps_icon_GoogleKeep.png");
			TestLogger.info("App Google Keep was Installed"); 
			// close Browser 
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type(Key.F4 ,Key.ALT ); 
			if (waitForObjectPresent("pictures\\Browser_Apps_Menu_GoogleKeep.png", 5))	
			{
				clickOn("pictures\\Browser_Apps_Menu_GoogleKeep.png");
				s.type(Key.F4 ,Key.ALT ); 
				openSettingsPage();
				openLink("coccoc://extensions/");
				moveMouseHorizontallyFromLogo(("pictures\\Browser_Extension_icon_GoogleKeep.png"),515);
			    s.click();
			    clickOn("pictures\\Browser_Extension_button_deleteApp.png");
			    closeBrowser();
				setTestcaseStatus("PASSED", "Check in tray, still icon for apps of Cốc Cốc browser still exist");
			}
			else
			{
				setTestcaseStatus("FAILED", "Check in tray, still icon for apps of Cốc Cốc browser DOES NOT exist");
			}
		}
		else
		{
			setTestcaseStatus("FAILED", "App Google Keep was NOT Installed");
		}
		
		
		
	}
}
