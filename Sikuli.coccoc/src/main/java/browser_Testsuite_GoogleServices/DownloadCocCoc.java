package browser_Testsuite_GoogleServices;

import java.io.File;

import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class DownloadCocCoc extends BrowserCommon{

	
	// Verify that auto download work well on Chrome.
	// Verify that the CocCoc setup file work well when download form Chrome.
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_download_01_02 </br>
	 * <b> CaseTitle: </b>Verify that auto download work well on Chrome & Verify that the CocCoc setup file work well when download form Chrome.</br>
	 * <b> Steps: </b>
	 * 1. Open any CocCoc website on Chrome browser (http://coccoc.com; http://coccoc.vn)
       2. Click on Download button
       3. Confirm on Terms of Service
	 * 4. Wait for download completed.
       5. Install CocCoc browser.
	 *  <b> ExpectedOutput: </br> 
	 *  
	 *  EXPECT : 
	 *  #3: Chrome auto download setup file of CocCoc browser after a few seconds without any virus alert.
        
	 *  #4: Nothing any alert appears until CocCoc browser is completed download.
        #5: User can install CocCoc browser with file was download (CocCoc_vi.exe or coccoc_en.exe)</br> </b> </br>
	 
	 
	 * @author hanv
	
	 */
	@Test
	public void Google_services_download_01_02()
	{
		// remove Coc Coc if it is available 
		
		TestLogger.info("===> Google_services_download_01_02 ====");
		s.type("d", Key.WIN);
		startUninstallCocCoc(true);
		
		TestLogger.info("1. Open any CocCoc website on Chrome browser (http://coccoc.com)");
		doubleClick("pictures\\BrowserChrome_Desktop_icon_Chrome.png");
		sleep(5);
		doubleClick("pictures\\Browser_InstallComplete_ChromeTitle.png");
		moveMouseHorizontallyFromLogo("pictures\\Browser_Menu_Button_Reload.png", 125);
		s.click();
		s.type("http://coccoc.com");
		s.type(Key.ENTER);
		sleep(15);
		TestLogger.info("2. Click on Download button");
		clickOn("pictures\\Website_CocCoc_icon_EnglishFlag.png"); 
		sleep(5);
		clickOn("pictures\\Website_CocCoc_Button_Download.png");  
		TestLogger.info("3. Confirm on Terms of Service");
		clickOn("pictures\\Website_CoCoc_Button_ConfirmDownload.png");  
		sleep(10);
		TestLogger.info("#3: Chrome auto download setup file of CocCoc browser after a few seconds without any virus alert.");
		
		if (waitForObjectPresent("pictures\\Website_Coccoc_DowloadBar_setupCocCocexe.png", 25))  
		{
			setTestcaseStatus("PASSED", "PASSED => #3: Chrome auto download setup file of CocCoc browser after a few seconds without any virus alert. ");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED => # #3: Chrome DOEN NOT auto download setup file of CocCoc browser after a few seconds without any virus alert.");
		}
		
		TestLogger.info("4. Wait for download completed.");
		waitForObjectPresent("pictures\\Browser_Setup_File_CoccocEn.png", 45) ;
		clickOn("pictures\\Browser_Setup_File_CoccocEn.png");
		sleep(25);
		TestLogger.info("5. Install CocCoc browser.");
		clickOn("pictures\\Website_CocCoc_Button_install.png");  
		
		TestLogger.info("#5. User can install CocCoc browser with file was download");
		sleep(15);
		waitForObjectPresent("pictures\\Browser_InstallDialog_DownloadComplete.png", 180);
		waitForObjectPresent("pictures\\Browser_InstallDialog_Installing.png", 30);
		waitForObjectPresent("pictures\\Browser_InstallDialog_ShowInstallComplete.png", 5);

		if (waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 75))
		{
			killprocess("chrome.exe");
			clickOn("pictures\\Browser_InstallDialog_PopupInstallComplete.png");
			sleep(2);
			clickOn("pictures\\Browser_InstallDialog_PopupInstallComplete_CloseButton.png");
			sleep(2);
			if (waitForObjectPresent("pictures\\Browser_InstallComplete_PopupSearchInternetFromHere.png", 5) 
					&& waitForObjectPresent("pictures\\Browser_InstallComplete_PopupTranslateThisPage.png", 5) ) {
				clickOn("pictures\\Browser_InstallComplete_PopupSearchInternetFromHere_Don'tShowAgain.png");
				sleep(2);
				clickOn("pictures\\Browser_InstallComplete_PopupSearchInternetFromHere_Button_GotIt.png");
				sleep(2);
				clickOn("pictures\\Browser_InstallComplete_PopupTranslate_Button_Nope.png");
			}
			else {
				System.out.println("Don't show Search Internet and Translate popup");
			}
						
			setTestcaseStatus("PASSED", "PASSED => #5. User can install CocCoc browser with file was download");
			
		}
		else
		{
			killprocess("chrome.exe");
			setTestcaseStatus("FAILED", "FAILED => #5 .User can NOT install CocCoc browser with file was download");
		}
		
		
	} 
	
//	@Test 
//	public void demo()
//	{
//		if (waitForObjectPresent("icon_zalo.png", 4))
//		{
//			App.open("C:\\Users\\hanv\\AppData\\Local\\Programs\\Zalo\\Zalo.exe");
//			
//			//doubleClick("icon_zalo.png");
//			waitForObjectPresent("telephone.png", 4);
//			clickOn("telephone.png");
//			s.click();
//			s.type("01689992931");
//			s.type(Key.ENTER);	
//		}
//	}
	
	
	

}
