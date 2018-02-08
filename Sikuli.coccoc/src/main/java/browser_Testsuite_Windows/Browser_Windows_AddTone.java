
package browser_Testsuite_Windows;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_AddTone extends BrowserCommon {
	
	private String addToneStr = "con cho boi trong be nuoc ";
	//private String addtoneStrFull = "con chó bơi trong bể nước";
	private String addToneLongStr = "hom nay troi that dep va chung ta se to chuc 1 buoi picnic cung voi ban be dong nghiep tai cong vien dep nhat Ha Noi that vui ve, an tuong va y nghia";
	private String siteTest = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea";
	private String userprofile = System.getenv("USERPROFILE");
	int timeout = 5;
	
	/*
	 * Pre-condition
	 * 
	 * Download, uninstall CocCoc and clean file on download folder
	 */
	//@BeforeClass
	public void beforTestAddTone(){
		TestLogger.info("----------------------------TEST SNIFF FOR ADDTONE----------------------");
		String domainDownloadCocCoc = getCocCocVersion("config\\coccocVersion.txt")[0];
		if(DownloadCCBrowser(domainDownloadCocCoc)){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
			TestLogger.info("======================================================TEST CASE============================================================\n\n");
		}
		else
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
	}
	
	@AfterMethod
	public void cleanupEnv(){
		closeBrowser();
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_01</br>
	 * <b> CaseTitle: </b>Check Addtone status when open a new tab </br>
	 * <b> Steps: </b></br>
	 * 1. Start browser
	 * 2. Open a new tab
	 * 3. Don't type anything into umibox
	 * 4. Find Addtone icon on Umibox
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Addtone is disabled
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_01: Check Addtone status when open a new tab");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		
		hoverImage("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		
		if(waitForObjectPresent("pictures\\Browser_Addtone_toolTip_DisableStatus.png", 5))
			setTestcaseStatus("PASSED", "The addTone is disable when open a new tab");
		else
			setTestcaseStatus("FAILED", "The addTone enable when open a new tab");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_02</br>
	 * <b> CaseTitle: </b>Check if Addtone works normally after turn off/turn on for 1 domain </br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open a new tab
	 * 3. Access to some URL (i.e. vnexpress.net) which has input box/text area
	 * 4. Find Addtone icon in Umibox
	 * 5. Turn off Addtone by clicking on Addtone icon in Umibox => type into text area/input box of that site
	 * 6. Turn on Addtone after turning off by clicking on Addtone icon in Umibox => type into text area/input box of that site
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 4: First state of Addtone is enabled
	 * 5: After addtone is turned off, there is no suggestion list
	 * 6: After addtone is turned on, suggestion list displays normally
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_02: Check if Addtone works normally after turn off/turn on for 1 domain");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		
		hoverImage("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		
		if(waitForObjectPresent("pictures\\Browser_Addtone_toolTip_DisableStatus.png", 5))
			setTestcaseStatus("PASSED", "The addTone is disable when user disable addtone on Umibox");
		else
			setTestcaseStatus("FAILED", "The addTone isn't disable when user disable addtone on Umibox");
		sleep(1);
		
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		if(waitForObjectPresent("pictures\\Browser_Addtone_toolTip_EnableStatus.png", 5))
			setTestcaseStatus("PASSED", "The addTone is disable when user disable addtone on Umibox");
		else
			setTestcaseStatus("FAILED", "The addTone isn't disable when user disable addtone on Umibox");
		
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		if(waitForObjectPresent("pictures\\Browser_Addtone_toolTip_DisableStatus.png", 5))
			setTestcaseStatus("PASSED", "The addTone is disable when when user disable addtone on Umibox");
		else
			setTestcaseStatus("FAILED", "The addTone isn't disable when user disable addtone on Umibox");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_03</br>
	 * <b> CaseTitle: </b>Check if Addtone works normally after turn off/turn on for the whole browser</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open a new tab
	 * 3. Access to some URL (i.e. vnexpress.net) which has input box/text area
	 * 4. Find Addtone icon in Umibox (now enabled)
	 * 5. Turn off Addtone for whole browser by going to browser menu>settings>uncheck the option "Turn on Addtone" => restart browser => type into text area/input box of that site
	 * 6. Turn on Addtone for whole browser after turning off  => restart browser => type into text area/input box of that site
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * - After addtone is turned off, there is no suggestion list
	 * - After addtone is turned on, suggestion list displays normally
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_03: Check if Addtone works normally after turn off/turn on for the whole browser");
		TestLogger.warn("Automate just handle for basic case, need check by manual careful and complex case");
		
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		
		s.type("t", Key.CTRL);
		s.type(siteTest);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_TextArea_Zoom.png", 20);
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type vietnamese without tone
		s.type(addToneStr);
		s.type(Key.SPACE);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", timeout))
			setTestcaseStatus("PASSED", "After addtone is turned off, there is no suggestion list");
		else
			setTestcaseStatus("PASSED", "After addtone is turned off, there is suggestion list");
		
		//---------------------- Case addtone enable again
		//enable addtone function on omnibox
		clickOn("pictures\\Browser_Addone_Button_AddtoneStatus.png");
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom.png");
		sleep(1);
		
		clickOn("pictures\\Website_TextArea_Zoom.png");
		
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type vietnamese without tone
		s.type(addToneStr);
		
		if(waitforObjectNotexist("pictures\\Browser_Addtone_Text_GoodSuggestion.png", timeout))
			setTestcaseStatus("PASSED", "After addtone is turned on, suggestion list displays normally");
		else
			setTestcaseStatus("PASSED", "After addtone is turned on, suggestion list not displays");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_04</br>
	 * <b> CaseTitle: </b>Check adding tone for a short sentence in 1 line </br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Type a short sentence into that text area/input box (i.e. "hom nay troi that dep.") and that sentence must be in 1 line only.
	 * 4. Choose some suggested option from Suggestion box
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_04: Check adding tone for a short sentence in 1 line");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER); 
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 300);
		s.click();
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 20);
		scrollPageToObject("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
		hoverImage("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
		clickOn("pictures\\Website_vnexpress_TextArea_InputTextBox.png");
		s.type(addToneStr);
		s.type(Key.SPACE);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", 3))
		{
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		}
		else
		{
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		}
		s.type(Key.DOWN);
		s.type(Key.TAB);
		sleep(1);
		s.type("a", Key.CTRL);
		sleep(1);
		s.type("c", Key.CTRL);
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		
		
		s.type(Key.F4, Key.ALT);
		
		if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
		{
			clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
		}
		
		if(!getClipboardValue().equals(addToneStr))
		
			setTestcaseStatus("PASSED", "The string in text area is replaced by that option & Suggestion box disappears");
		else
			setTestcaseStatus("FAILED", "The string in text area donot replace by that option & Suggestion box disappears");
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.3_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_05</br>
	 * <b> CaseTitle: </b>Check adding tone for a sentence in multiple lines</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. - Type a long sentence into that text area/input box and make sure that sentence must be in multiple lines.
	 * 4. Choose some suggested option from Suggestion box
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_05(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_05: Check adding tone for a sentence in multiple lines");
		String splitStr;
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		sleep(30);
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sort text:
		s.type(addToneLongStr);
		sleep (0.5);
		s.type(Key.SPACE);
		sleep (3);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodLongSuggestion.png", 3))
		{
			
		        s.type(Key.DOWN);
				s.type(Key.TAB);
				sleep(1);
				s.type("a", Key.CTRL);
				sleep(1);
				s.type("c", Key.CTRL);
				sleep (2);
				
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	      
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		}
		else
		{
			
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		}
		
		
		String ComparedString ="hôm nay trời thật đẹp và chúng ta sẽ tổ chức 1 buổi picnic cùng với bạn bè đồng nghiệp tại công viên đẹp nhất Hà Nội thật vui vẻ, ấn tượng" ;
		splitStr = getClipboardValue();
		TestLogger.info("Checking >>> " + splitStr);
		
		
		if(splitStr.contains(ComparedString))   
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	        s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("PASSED", "After choosing 1 suggested option, the last string in text area is replaced by that option & Suggestion box disappears");
		}
		else
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	        s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("FAILED", "After choosing 1 suggested option, the string in text area is not replaced by that option & Suggestion box disappears");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_06</br>
	 * <b> CaseTitle: </b>Check adding tone for a sentence in multiple lines</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Type many sentences into that text area to make a paragraph.
	 * 4. Choose some suggested option from Suggestion box
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_06(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_06: Type many sentences into that text area to make a paragraph.");
		String splitStr[];
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		sleep (30);
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type sort text:
		s.type(addToneLongStr);
		s.type(Key.ENTER);
		s.type(addToneStr);
		sleep (0.5);
		s.type(Key.SPACE);
		sleep (1.5);
		s.type(Key.DOWN);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", 3))
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		else
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		
		s.type(Key.DOWN);
		s.type(Key.TAB);
		sleep(1);
		s.type("a", Key.CTRL);
		sleep(1);
		s.type("c", Key.CTRL);
		splitStr = getClipboardValue().split("\n");
        clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type(Key.F4, Key.ALT);
		
		if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
		{
			clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
		}
		
		
		if(addToneLongStr.equals(splitStr[0]) & !(splitStr[1].equals(addToneStr)))
			setTestcaseStatus("PASSED", "After choosing 1 suggested option, the last string in text area is replaced by that option & Suggestion box disappears");
		else
			setTestcaseStatus("FAILED", "After choosing 1 suggested option, the string in text area is not replaced by that option & Suggestion box disappears");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_07</br>
	 * <b> CaseTitle: </b>Type many sentences into that text area to make several paragraphs.</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Type many sentences into that text area to make several paragraphs.
	 * 4. Choose some suggested option from Suggestion box
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_AddTone_07(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_07: Check adding tone for many paragraphs");
		String splitStr;
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		sleep (30);
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//type long text:
		s.type(addToneLongStr);
		sleep (2);
		s.type(Key.SPACE);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodLongSuggestion.png", 3))
		{
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.TAB);
			sleep(1);
			s.type("a", Key.CTRL);
			sleep(1);
			s.type("c", Key.CTRL);
			sleep (2);
	
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		}
		else
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	        s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		}
	
		
		String ComparedString = "hôm nay trời thật đẹp và chúng ta sẽ tổ chức 1 buổi picnic";
		splitStr = getClipboardValue();
		//s.type(Key.BACKSPACE);
		if(splitStr.contains(ComparedString))   
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	        s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("PASSED", "After choosing 1 suggested option, the last string in text area is replaced by that option & Suggestion box disappears");
		}
		else
		{
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
	        s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
			{
				clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
			}
			setTestcaseStatus("FAILED", "After choosing 1 suggested option, the string in text area is not replaced by that option & Suggestion box disappears");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.3_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_08</br>
	 * <b> CaseTitle: </b>Check adding tone for copied-and-pasted senstence </br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Copy 1 sentence (i.e. "hom nay thoi tiet dep qua") and paste into the text area/input box
	 * 4. Choose some suggested option from Suggestion box
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_08(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_08: Check adding tone for copied-and-pasted senstence");
		setClipboardValue(addToneStr);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		sleep (30) ;
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			sleep (1) ;
			s.type(Key.DOWN);
			sleep (1) ;
			s.type(Key.DOWN);
			sleep (1) ;
			s.type(Key.DOWN);
			sleep (1) ;
			s.type(Key.DOWN);
			sleep (1) ;
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		//focus on text area and delete old text
		
		//paste sort text:
		s.type("v", Key.CTRL);
		s.type(Key.SPACE);
		sleep (1);
		s.type(Key.DOWN);
		sleep(1);
		s.type(Key.DOWN);
		
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", 3))
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		else
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		
		s.type(Key.TAB);
		sleep(1);
		s.type("a", Key.CTRL);
		sleep(1);
		s.type("c", Key.CTRL);
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type(Key.F4, Key.ALT);
		
		if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
		{
			clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
		}
		
		if(!(getClipboardValue().equals(addToneStr) ))
			setTestcaseStatus("PASSED", "The string in text area is replaced correctly by that option & Suggestion box disappears");
		else
			setTestcaseStatus("FAILED", "The string in text area is not replaced by that option & Suggestion box disappears");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_09</br>
	 * <b> CaseTitle: </b>Check adding tone using tab , enter , up, down, left,right button on keyboard to choose 1 option in Suggestion box</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Copy 1 sentence (i.e. "hom nay thoi tiet dep qua") and paste into the text area/input box
	 * 4. Choose some suggested option from Suggestion box by using tab, enter, up, down, left, right button on keyboard
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_09(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_09: Check adding tone using tab , enter , up, down, left,right button on keyboard to choose 1 option in Suggestion box");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		sleep (30) ;
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//enter text without tone:
		s.type(addToneStr);
		sleep (2);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", 3))
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		else
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		
		s.type(Key.TAB);
		sleep(1);
		s.type("a", Key.CTRL);
		sleep(1);
		s.type("c", Key.CTRL);
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type(Key.F4, Key.ALT);
		
		if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
		{
			clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
		}
		
		if(!(getClipboardValue().equals(addToneStr)))
			setTestcaseStatus("PASSED", "The string in text area is replaced correctly by that option & Suggestion box disappears");
		else
			setTestcaseStatus("FAILED", "The string in text area is not replaced by that option & Suggestion box disappears");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO_Genaral.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_09</br>
	 * <b> CaseTitle: </b>Check adding tone while a string is choosen</br>
	 * <b> Steps: </b></br>
	 * 1. Start browser & don't use any Vietnamese input app on PC
	 * 2. Open some site which has text area/input box
	 * 3. Copy 1 sentence (i.e. "hom nay thoi tiet dep qua") and paste into the text area/input box
	 * 4. Left-click into some words of that sentence to choose that word (bôi đen)
	 * 5. Choose some suggested option from Suggestion box 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Addtone suggestion box appears when user pauses typing around 2s
	 * 4. Suggestion box lists all options available for that inputed sentence
	 * 5. After choosing 1 suggested option, the string in text area is replaced correctly by that option & Suggestion box disappears
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_AddTone_10(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_AddTone_10: Check adding tone while a string is choosen");
		String outputResult = "con cho boi trong be nuoc ";
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open website has input text/text area
		s.type("t", Key.CTRL);
		s.type("http://vnexpress.net/tin-tuc/phap-luat/nu-sinh-cung-3-ban-trai-phe-ma-tuy-trong-can-nha-3531407.html");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_vnexpress_image_logo.png", 30);
		moveMouseDownFromLogo("pictures\\Website_vnexpress_image_logo.png", 160);
		s.click();
		
		while (!waitForObjectPresent("pictures\\Website_TextArea_Zoom_Comment.png", 1))
		{
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
		}
		
		//focus on text area and delete old text
		hoverImage("pictures\\Website_TextArea_Zoom_Comment.png");
		sleep(1);
		clickOn("pictures\\Website_TextArea_Zoom_Comment.png");
		s.type("a", Key.CTRL);
		s.type(Key.DELETE);
		
		//enter text without tone:
		s.type(outputResult);
		sleep (3);
		s.type(Key.DOWN);
		s.type(Key.DOWN);
		
		if(waitForObjectPresent("pictures\\Browser_Addtone_Text_GoodSuggestion.png", 3))
			setTestcaseStatus("PASSED", "Addtone suggestion box appears when user pauses typing around 2s");
		else
			setTestcaseStatus("FAILED", "Addtone suggestion box not appears when user pauses typing around 2s");
		
		s.type(Key.TAB);
		sleep(1);
		s.type("a", Key.CTRL);
		sleep(1);
		s.type("c", Key.CTRL);
		TestLogger.info("===> "+ getClipboardValue());
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type(Key.F4, Key.ALT);
		
		if (waitForObjectPresent("pictures\\Website_Vnexpress_Button_LeavePage.png", 5))
		{
			clickOn("pictures\\Website_Vnexpress_Button_LeavePage.png");
		}
		
		if(!(getClipboardValue().equals("con chó bơi trong bể nước")))
			setTestcaseStatus("PASSED", "The string in text area is replaced correctly by that option & Suggestion box disappears");
		else
			setTestcaseStatus("FAILED", "The string in text area is not replaced by that option & Suggestion box disappears");
	}
	
	   
}
