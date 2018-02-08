package browser_Testsuite_Windows;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_SpellChecker extends BrowserCommon {
	private String stringWrong = "cin cho chay";
	private String siteTest = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea";
	private String userprofile = System.getenv("USERPROFILE");
	int timeout = 5;
	
	//@BeforeClass
	public void preconditionSpellChecker(){
		TestLogger.info("----------------------------TEST SCRIP FOR SPELL CHECKER----------------------");
		TestLogger.warn("This test script just handle for basic case, NEED to re-check manual for complex case");
		if(DownloadCCBrowser("dev.coccoc.com")){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		}
		else{
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
		}
	}
	@AfterMethod
	public void preConditionMethod(){
		closeBrowser();
	}
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_01</br>
	 * <b> CaseTitle: </b>Check if SpellChecker is turned on by default at the first time browser starts</br>
	 * <b> Steps: </b></br>
	 * 1. Install browser & start at the first time
	 * 2. Go to some site (i.e vnexpress.net) which has text area
	 * 3. Type into the text area/input box some words containing spelling mistakes (i.e. "sấu xí")
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. words containing spelling mistake will be red-highlighted
	 * 2. Right click onto the highlighted word(s), SpellChecker menu appears and default checking language is Vietnamese
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_SpellChecker_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_SpellChecker_01: Check if SpellChecker is turned on by default at the first time browser starts in vietnamese version");
		
		//start Coc coc and open website has text area
		startCocCoc();
		openLink("coccoc://settings/languages");
		
		if (waitForObjectPresent("pictures\\Browser_Addone_Checkbox_UsingThisLanguagetoCheckSpell.png", 3))
		{
			TestLogger.info("SpellChecker is turn on by default");
		}
		else
		{
			TestLogger.info("SpellChecker is NOT turn on by default");
		}
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		//disable addtone
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		hoverImage("pictures\\Website_TextArea_Zoom.png");
		sleep(1);
		//focus on text area and delete old text
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sentences has the wrong spell
		s.type(stringWrong);
		
		if(waitForObjectPresent("pictures\\Browser_SpellChecker_Text_ErrorSpellCIM.png", timeout))
			setTestcaseStatus("PASSED", "Words containing spelling mistake be red-highlighted");
		else
			setTestcaseStatus("FAILED", "Words containing spelling mistake not red-highlight");
		
		s.type(Key.SPACE);
		s.type(Key.CONTEXT);
		
		// rightClick("pictures\\Browser_SpellChecker_Text_ErrorSpellCIM.png");
		sleep(1);
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu.png");
		
		if(waitForObjectPresent("pictures\\Browser_SpellChecker_Radio_ChooseVietnameseAsDefaultLanguage.png", timeout))
			setTestcaseStatus("PASSED", "SpellChecker menu appears and default checking language is Vietnamese");
		else
			setTestcaseStatus("FAILED", "SpellChecker menu appears and default checking language is NOT Vietnamese");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_02</br>
	 * <b> CaseTitle: </b>Check if SpellChecker is turned on by default at the first time browser starts in EN version</br>
	 * <b> Steps: </b></br>
	 * 1. Install browser & start at the first time
	 * 2. Go to some site (i.e vnexpress.net) which has text area
	 * 3. Type into the text area/input box some words containing spelling mistakes (i.e. "sấu xí")
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. words containing spelling mistake will be red-highlighted
	 * 2. Right click onto the highlighted word(s), SpellChecker menu appears and default checking language is Vietnamese
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_SpellChecker_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_SpellChecker_02: Check if SpellChecker is turned on by default at the first time browser starts in English version");
		
		//start Coc coc and open website has text area
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
		
		if (waitForObjectPresent("pictures\\Browser_Addone_Checkbox_UsingThisLanguagetoCheckSpell_EN.png", 3))
		{
			TestLogger.info("SpellChecker is turn on by default");
		}
		else
		{
			TestLogger.info("SpellChecker is NOT turn on by default");
		}
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(1);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		//disable addtone
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		
		//focus on text area and delete old text
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sentences has the wrong spell
		s.type(stringWrong);
		
		if(waitForObjectPresent("pictures\\Browser_SpellChecker_Text_ErrorSpellCIM.png", timeout))
			setTestcaseStatus("PASSED", "Words containing spelling mistake be red-highlighted");
		else
			setTestcaseStatus("FAILED", "Words containing spelling mistake not red-highlight");
		
		s.type(Key.SPACE);
		s.type(Key.CONTEXT);
		
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu_En.png");
		
		if(waitForObjectPresent("pictures\\Browser_SpellChecker_Radio_ChooseEnglishAsDefaultLanguage.png", timeout))
			setTestcaseStatus("PASSED", "SpellChecker menu appears and default checking language is Vietnamese");
		else
			setTestcaseStatus("FAILED", "SpellChecker menu appears and default checking language is NOT Vietnamese");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_03</br>
	 * <b> CaseTitle: </b>Check if user can turn off SpellChecker or not</br>
	 * <b> Steps: </b></br>
	 * 1. Install browser & start at the first time
	 * 2. Go to some site (i.e vnexpress.net) which has text area
	 * 3. Type into the text area/input box some words containing spelling mistakes
	 * 3. Right click on highlighted word(s) to open SpellChecker context menu
	 * 4. Uncheck the option:"Check the spelling of text fields"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. No word is highlighted in the text area
	 * @author huy.vu
	 * @Update HANV
	 *
	 */
	
	
	@Test (dependsOnMethods = { "Browser_SNIFF_SpellChecker_01" })
	public void Browser_SNIFF_SpellChecker_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_SpellChecker_03: Check if user can turn off SpellChecker or not");
		
		//start Coc coc and open website has text area
		startCocCoc();
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		
		//disable addtone
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		
		//turn off Spell checker
		rightClick("pictures\\Website_TextArea_Zoom.png");
		sleep(1);
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu.png");
		sleep(1);
		if (waitForObjectPresent("pictures\\Browser_SpellChecker_Text_CheckboxSpellForAllTextArea.png", 2))
		{
		clickOn("pictures\\Browser_SpellChecker_Text_CheckSpellForAllTextArea.png");
		}
		
		//focus on text area and delete old text
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sentences has the wrong spell
		s.type(stringWrong);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type("+", Key.CTRL);
		s.type("+", Key.CTRL);
			
		if(waitforObjectNotexist("pictures\\Browser_SpellChecker_Text_ErrorSpellCIM.png", 2))
		{
			clickOn("pictures\\Browser_AddressBar_icon_zoomin.png"); 
			clickOn("pictures\\Browser_AddressBar_button_resetZoom.png"); 
			setTestcaseStatus("PASSED", "No word is highlighted in the text area");
		}
		else
		{
			clickOn("pictures\\Browser_AddressBar_icon_zoomin.png"); 
			clickOn("pictures\\Browser_AddressBar_button_resetZoom.png"); 
			setTestcaseStatus("FAILED", "Word still highlighted in the text area");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_04</br>
	 * <b> CaseTitle: </b>Check if SpellChecker works normally after being turned off and turned on again</br>
	 * <b> Steps: </b></br>
	 * 1. Install browser & start at the first time
	 * 2. Go to some site (i.e vnexpress.net) which has text area
	 * 3. Type into the text area/input box some words containing spelling mistakes
	 * 3. Right click on highlighted word(s) to open SpellChecker context menu
	 * 4. Uncheck the option:"Check the spelling of text fields"
	 * 5  Check the spelling of text fields
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 1. word is highlighted in the text area
	 * @author huy.vu
	 * @Update HANV
	 * 
	 * 
	 */
	@Test (dependsOnMethods = { "Browser_SNIFF_SpellChecker_01" , "Browser_SNIFF_SpellChecker_03" })
	public void Browser_SNIFF_SpellChecker_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_SpellChecker_04: Check if SpellChecker works normally after being turned off and turned on again");
		
		//start Coc coc and open website has text area
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		
		//turn off Spell checker
		rightClick("pictures\\Website_TextArea_Zoom.png");
		sleep(1);
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu.png");
		sleep(1);
		
		clickOn("pictures\\Browser_SpellChecker_Text_CheckSpellForAllTextArea.png");
		s.type(Key.F4, Key.ALT);
		
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		
		//focus on text area and delete old text
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sentences has the wrong spell
		s.type(stringWrong);
		
		
		s.type(Key.SPACE);
		s.type(Key.CONTEXT);
		
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu.png");
		sleep(1);
		//turn off
		if (waitForObjectPresent("pictures\\Browser_SpellChecker_Text_CheckboxSpellForAllTextArea.png", 2))
		{
		clickOn("pictures\\Browser_SpellChecker_Text_CheckSpellForAllTextArea.png");
		}
		
		 // and turn on Spell checker
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		s.type(stringWrong);
		
		s.type(Key.SPACE);
		s.type(Key.CONTEXT);
		
		sleep(1);
		hoverImage("pictures\\Browser_SpellChecker_Text_CheckSpellOptionInContextMenu.png");
		
		clickOn("pictures\\Browser_SpellChecker_Text_CheckSpellForAllTextArea.png");
	
		if(waitForObjectPresent("pictures\\Browser_SpellChecker_Text_ErrorSpellCIM.png", 2))
		{
			 
			setTestcaseStatus("PASSED", "word is highlighted in the text area");
		}
		else
		{
			 
			setTestcaseStatus("FAILED", "No word is highlighted in the text area");
		}
	}
	
//----------------------------------------------------------------------------------------
//	SKIP Test case 05~11
//----------------------------------------------------------------------------------------
//
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_05</br>
//	 * <b> CaseTitle: </b>Check if user can turn off the option:"Ask Coc Coc for suggestion"</br>
//	 * <b> Steps: </b></br>
//	 * 1. Go to some site (i.e vnexpress.net) which has text area
//	 * 2. Right click onto the text area to open SpellChecker context menu
//	 * 3. Uncheck the option:"Ask Coc Coc for suggestion"
//	 * 4. Type into the text area/input box some words containing spelling mistakes
//	 * 5. Double left click on the highlighted word(s)
//	 * 
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. No suggestion box appears
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_05(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_05: Check if SpellChecker works normally after being turned off and turned on again");
//		setTestcaseStatus("SKIP", "If user turns off Ask Cốc Cốc for suggestion, a suggestion from Chromium will appear, need check by manual");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_06</br>
//	 * <b> CaseTitle: </b>Check if Suggestion option can be turned on again after being turned off</br>
//	 * <b> Steps: </b></br>
//	 * 1. Go to some site (i.e vnexpress.net) which has text area
//	 * 2. Right click onto the text area to open SpellChecker context menu
//	 * 3. Choose the option:"Ask Coc Coc for suggestion" again
//	 * 4. Type into the text area/input box some words containing spelling mistakes
//	 * 5. Double left click on the highlighted word(s)
//	 * 
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. No suggestion box appears
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_06(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_06: Check if SpellChecker works normally after being turned off and turned on again");
//		setTestcaseStatus("SKIP", "If user turns off Ask Cốc Cốc for suggestion, a suggestion from Chromium will appear, need check by manual");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_07</br>
//	 * <b> CaseTitle: </b>Using Fiddler: Check request to spellchecker after typing separator (',' | '.' | ';' )</br>
//	 * <b> Steps: </b></br>
//	 * 1. Query = "Sag nay,"
//	 * 2. Condition : not type separator too fast ( < 0.3 s ) and after type space, not wait to long ( waiting time between : 0.5s to 1s )
//	 * 3. Use Fiddler to capture packet
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. have one request send to spell.itim.vn for the whole text : "Sag nay,"
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_07(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_07: Using Fiddler: Check request to spellchecker after typing separator (',' | '.' | ';' )");
//		setTestcaseStatus("SKIP", "Cannot be automation test due need using third party tool (Fiddler/WireShark) to capture packet for check point, and all of them very unstable when checking by automation");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_08</br>
//	 * <b> CaseTitle: </b>CUsing Fiddler: Check request to spellchecker after typing space</br>
//	 * <b> Steps: </b></br>
//	 * 1. Query = "Sag ,"
//	 * 2. Use Fiddler to capture packet
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. have one request send to spell.itim.vn for the whole text : "Sag "
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_08(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_08: Using Fiddler: Check request to spellchecker after typing space");
//		setTestcaseStatus("SKIP", "Cannot be automation test due need using third party tool (Fiddler/WireShark) to capture packet for check point, and all of them very unstable when checking by automation");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_09</br>
//	 * <b> CaseTitle: </b>Using Fiddler: Check request to spellchecker after finish typing and have long wait ( > 1s )</br>
//	 * <b> Steps: </b></br>
//	 * 1. Query = "kong muon hoc hanh gi ca"
//	 * 2. Condition : Type quickly, and only wait when finish the typing all query ( Not wait longer 0.5s after typing "Kong", not wait longer 0.5s after typing "hah" )
//	 * 3. Use Fiddler to capture packet
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. have one request send to spell.itim.vn for the whole text : "kong muon hoc hanh gi ca"
//	 *
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_09(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_09: Using Fiddler: Check request to spellchecker after finish typing and have long wait ( > 1s )");
//		setTestcaseStatus("SKIP", "Cannot be automation test due need using third party tool (Fiddler/WireShark) to capture packet for check point, and all of them very unstable when checking by automation");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_10</br>
//	 * <b> CaseTitle: </b>Using Fiddler: Check do not send request to spellchecker after typing separator if typing too quick ( waiting time after typing separator < 0.3 s )</br>
//	 * <b> Steps: </b></br>
//	 * 1. Query = "kong. muon hoc hanh gi ca"
//	 * 2.- Condition : After typing "." continue type next syllable ( not wait loger 0.3 s )
//	 * 3. Use Fiddler to capture packet
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. DO NOT have any request send to spell.itim.vn for text "Buon." . Only have request send to spell.itim.vn for whole text "Buon. Troi l?i mua" when finish typing
//	 *
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_10(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_10: Using Fiddler: Check do not send request to spellchecker after typing separator if typing too quick ( waiting time after typing separator < 0.3 s )");
//		setTestcaseStatus("SKIP", "Cannot be automation test due need using third party tool (Fiddler/WireShark) to capture packet for check point, and all of them very unstable when checking by automation");
//	}
//	
//	/**
//	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
//	 * <b> CaseID: </b> Browser_SNIFF_SpellChecker_10</br>
//	 * <b> CaseTitle: </b>Using Fiddler: Check do not send request to spellchecker after typing space if typing too quick ( 0.3 s < waiting time after typing space < 0.5 s )</br>
//	 * <b> Steps: </b></br>
//	 * 1. Query = "Jo em fai làm sao"
//	 * Condition : After typing "Jo " continue type next syllable ( not wait loger 0.5 s ) and after typing "fai " continue type next syllable ( not wait loger 0.5 s )
//	 * 3. Use Fiddler to capture packet
//	 * <b> ExpectedOutput: </b></br>
//	 * 1. DO NOT have any request send to spell.itim.vn for text "Jo " or "Jo em fai ". Only have request send to spell.itim.vn for whole text "Jo em fai làm sao" when finish typing.
//	 *
//	 * @author huy.vu
//	 * @Update huy.vu
//	 * @date 13 Jul -2016
//	 */
//	@Test
//	public void Browser_SNIFF_SpellChecker_11(){
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Browser_SNIFF_AddTone_11: Using Fiddler: Check do not send request to spellchecker after typing separator if typing too quick ( waiting time after typing separator < 0.3 s )");
//	}
	
}
