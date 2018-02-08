package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Geolocation extends BrowserCommon {
    

	//Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_Geolocation_01 </br>
	 * <b> CaseTitle: </b>Verify that default of POI setting is "Ask when a site wants to show notifications (recommended)"</br>
	 * <b> Steps: </b>
1. Open settings page
2. Go to Privacy -> content settings… -> location
	 *  EXPECT : 
'#2:
- There are 3 options: 
  + "Ask when a site wants to show notifications (recommended)" (default)
  + Allow all sites to track your physical location
  + Do not allow any site to track your physical location
- Button: Manage Exceptions…
	 * @author hanv
	
	 */
	@Test
	public void Google_services_Geolocation_01 ()
	{
		
		TestLogger.info("========Google_services_Geolocation_01========");
		startCocCocInEnglish() ;
		
		TestLogger.info("1.Open settings page");
		
	    openLink("coccoc://settings/#coccoc-settings-users");
		
	 
		TestLogger.info("2.Go to Privacy -> content settings… -> location");
		waitForObjectPresent("pictures\\Browser_Settings_TextLink_Privacy.png", 8);
		clickOn("pictures\\Browser_Settings_TextLink_Privacy.png");
		// waitForObjectPresent("pictures\\Browser_Settings_button_contentSettings.png", 8);
		waitForObjectPresent("pictures\\Browser_Settings_button_contentSettings.png", 8);
		clickOn("pictures\\Browser_Settings_button_contentSettings.png");
		waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
		moveMouseDownFromLogo("pictures\\Browser_Settings_button_Done.png", -150);
		s.click();
		int i =1;
		do
		{
			i++ ;
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			
		} while (! waitForObjectPresent("pictures\\Browser_Settings_Text_Notifications.png", 1) && (i<6)) ;
		
		TestLogger.info("#2.- There are 3 options:" 
		        + "Ask when a site wants to show notifications (recommended)\n" 
		        + "Allow all sites to track your physical location\n"
		        + "Do not allow any site to track your physical location\n"
		        + "- Button: Manage Exceptions…\n");
		
		if (waitForObjectPresent("pictures\\Browser_Settings_Modal_Location.png", 6)) 
		{
			waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
			clickOn("pictures\\Browser_Settings_button_Done.png");
			setTestcaseStatus("PASSED", "PASSED =>  : #2.- There are 3 options:");
			
		}
		else
		{
			waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
			clickOn("pictures\\Browser_Settings_button_Done.png");
			setTestcaseStatus("FAILED", "FAILED : ==> #2.- There are NOT 3 options:");
		}
			
		
		
	}
	
	// Check button (Cho phép/chặn) when website requite to use Geolocation  API on the first time.
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_Geolocation_02 </br>
	 * <b> CaseTitle: </b>Check button (Cho phép/chặn) when website requite to use Geolocation  API on the first time.</br>
	 * <b> Steps: </b>
1. Open any web require permission to access POI
2. Click on Allow or Block button
3. Observe on Ominibox
	 *  EXPECT : 
#1: A modal appears to confirm user Allow/Block website access POI.
#3: The POI icon appears beside Addtone icon.
	 * @author hanv
	
	 */
	
	@Test
	public void Google_services_Geolocation_02 ()
	{
		
		TestLogger.info("========Google_services_Geolocation_02========");
	    TestLogger.info("1. Open any web require permission to access POI");
	    openLink("https://www.google.com/maps/") ; 
	    if (waitForObjectPresent("pictures\\Website_GoogleMap_button_iKnowIt.png", 4))
	    {
	    	clickOn("pictures\\Website_GoogleMap_button_iKnowIt");
	    }
	    
	    
	    waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
	    clickOn("pictures\\website_googleMap_icon_showDialog.png");
		sleep(3);
		if (waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 2)!=true);
		{
			waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
			clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			closeBrowser();
		}
		
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		openLink("https://www.google.com/maps/") ; 
		waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
		clickOn("pictures\\website_googleMap_icon_showDialog.png");
		TestLogger.info("#1: A modal appears to confirm user Allow/Block website access POI.");
		if (waitForObjectPresent("pictures\\Browser_Modal_Dialog_Allow_Block.png", 6))
		{
			setTestcaseStatus("PASSED", "PASSED : ==> #1 : A modal appears to confirm user Allow/Block website access POI. ");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "FAILED : ==> #1 : A modal DOES NOT appear to confirm user Allow/Block website access POI. ");
		}
		
		TestLogger.info("2. Click on Allow or Block button");
		waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 8);
		clickOn("pictures\\WebSite_CoccocMap_Dialog_Allow.png");
		TestLogger.info("3. Observe on Ominibox");
		
		TestLogger.info("#3: The POI icon appears beside Addtone icon.");
		
		if (waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 6))
		{   
			waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
			clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			closeBrowser();
			setTestcaseStatus("PASSED", "PASSED : ==> #3 : The POI icon appears beside Addtone icon. ");
			
		}
		else
		{
		
			closeBrowser();
			setTestcaseStatus("FAILED", "FAILED : ==> #3 : The POI icon DOES NOT appear beside Addtone icon. ");
		}
		
	
	}
	//Verify CocCoc can support Geolocation (IP or GPS (if have))
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_Geolocation_03 </br>
	 * <b> CaseTitle: </b>Verify CocCoc can support Geolocation (IP or GPS (if have))</br>
	 * <b> Steps: </b>
1. Open any web require permission to access POI. (e.g.: opens page: http://www.w3schools.com/html/tryit.asp?filename=tryhtml5_geolocation and then click "try" button).
2. On confirm modal, click on Allow button.
3. Observe on website.
	 *  EXPECT : 
#3: Website can detect user's location.
	 * @author hanv
	
	 */
	@Test
	public void Google_services_Geolocation_03 () 
	{
		
		TestLogger.info("========Google_services_Geolocation_03========");
		// startCocCocInEnglish();
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		TestLogger.info("1. Open any web require permission to access POI.");
		openLink("https://www.google.com/maps/") ; 
		if (waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15))
		{
	     clickOn("pictures\\website_googleMap_icon_showDialog.png");
		}
		waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 8);
		
		TestLogger.info("2. On confirm modal, click on Allow button.");
		
		clickOn("pictures\\WebSite_CoccocMap_Dialog_Allow.png");
		
		TestLogger.info("3. Observe on website.");
		TestLogger.info("#3: Website can detect user's location");
		waitForObjectPresent("pictures\\Website_CoccocMap_Icon_displayMyLocation.png", 8);
		doubleClick("pictures\\Website_CoccocMap_Icon_displayMyLocation.png");
		
		if (waitForObjectPresent("pictures\\Website_CoccocMap_icon_myPOI.png", 15))
		{
			waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
			clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			
			closeBrowser();
			setTestcaseStatus("PASSED", "PASSED => #3 Website can detect user's location ");
		}
		else
		{
			waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
			clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			clickOn("pictures\\Website_SettingPOI_TextLink_ClearSettings.png");
			closeBrowser();
			setTestcaseStatus("FAILED", "FAILED => #3 Website can NOT detect user's location ");
		}
		
		
	}
	
	
	// Verify that Geolocation works as settings mention ( disable/enable Geolocation, exception).
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_Geolocation_04 </br>
	 * <b> CaseTitle: </b>Verify that Geolocation works as settings mention ( disable/enable Geolocation, exception).</br>
	 * <b> Steps: </b>
1. Open any web require permission to access POI.
2. On confirm modal, click on "Block"("Chặn") button.
3. Observe on website.
4. Open location settings.
5. Click on "Manage exceptions…" button
6. Remove the website on step #1 on list
7. Re-open website on step #1
8. On confirm modal, click on "Allow"("Cho phép") button.
9. Observe on Website
	 *  EXPECT : 
#2: The small, red "x" appears on POI icon.
#3: Website cannot detect to user's location.
#8: POI icon appears without "x".
#9: Website can detect user's location.
	 * @author hanv
	
	 */
	@Test
	public void Google_services_Geolocation_04 ()
	{
		
	 TestLogger.info("========Google_services_Geolocation_04========");
	 //startCocCocInEnglish();
	 
	 if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
	 TestLogger.info("1. Open any web require permission to access POI.");
	 openLink("https://www.google.com/maps/") ; 
	 waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
     clickOn("pictures\\website_googleMap_icon_showDialog.png");
	 waitForObjectPresent("pictures\\Website_CoccocMap_Popup_Button_Block.png", 8);
		
	 TestLogger.info("2. On confirm modal, click on Block , Chặn button.");
	 waitForObjectPresent("pictures\\Website_CoccocMap_Popup_Button_Block.png", 8);
	 clickOn("pictures\\Website_CoccocMap_Popup_Button_Block.png");
	 
	 TestLogger.info("#2: The small, red x appears on POI icon.");
	 if (waitForObjectPresent("pictures\\Website_CoccocMap_icon_DisableiconPOI.png", 6)) 
	 {
		 setTestcaseStatus("PASSED", "PASSED : ==>#2: The small, red x appears on POI icon. ");
	 }
	 else
	 {
		 setTestcaseStatus("FAILED", "FAILED : ==>#2: The small, red x DOES NOT appear on POI icon. ");
	 }
	 
	 
	 TestLogger.info("3. Observe on website.");
	 
	 TestLogger.info("#3 : Website cannot detect to user's location."); 
	 waitForObjectPresent("pictures\\Website_CoccocMap_Icon_displayMyLocation.png", 8);
	 clickOn("pictures\\Website_CoccocMap_Icon_displayMyLocation.png");
	 
	 if (waitForObjectPresent("pictures\\Website_CoccocMap_icon_myPOI.png", 5))
	 {
		 
		 setTestcaseStatus("FAILED", "FAILED :==> #3 : Website STILL CAN detect to user's location. ");
	 }
	 else
	 {
		 setTestcaseStatus("PASSED", "PASSED : ==> #3 : Website cannot detect to user's location. ");
		 
	 }
	 
	 
	 
	 TestLogger.info("4. Open location settings.");
	 clickOn("pictures\\Website_CoccocMap_icon_DisableiconPOI.png");
	 TestLogger.info(".Click on Manage exceptions… button");
	 clickOn("pictures\\website_CocCoc_textlink_ManageLocationSetting.png");
	
	 TestLogger.info(" Remove the website on on list");
	 waitForObjectPresent("pictures\\Browser_Settings_Text_Domain_block.png", 8);
	 clickOn("pictures\\Browser_Settings_Text_Domain_block.png");
	 waitForObjectPresent("pictures\\Browser_Settings_Button_RemoveSite.png", 8);
	 clickOn("pictures\\Browser_Settings_Button_RemoveSite.png");
	 moveMouseDownFromLogo("pictures\\Browser_Settings_Button_RemoveSite.png", 220);
     s.click();
     
	 TestLogger.info("7. Re-open website on step #1");
	 openLink("https://www.google.com/maps/") ;
	 waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
     clickOn("pictures\\website_googleMap_icon_showDialog.png");
  
	 waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 8);
		
	 TestLogger.info("8. On confirm modal, click on Allow(Cho phép) button.");
	 
	 clickOn("pictures\\WebSite_CoccocMap_Dialog_Allow.png");
	 
	 TestLogger.info("#8 : EXPECT : ==> POI icon appears without x.");
	 waitForObjectPresent("pictures\\Website_CoccocMap_Icon_displayMyLocation.png", 8);
	 clickOn("pictures\\Website_CoccocMap_Icon_displayMyLocation.png");
	  if (waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 5))
	  {
		  
		  setTestcaseStatus("PASSED", "PASSED : ==> POI icon appears without x ");
	  }
	  else
	  {
		  
		  setTestcaseStatus("FAILED", "FAILED : ==> POI icon STILL appear with x. ");
	  }
	 
	 TestLogger.info("9. Observe on Website");
	  
	 
	 TestLogger.info("#9: EXPECT: ==>  Website can detect user's location.");
	 //waitForObjectPresent("pictures\\Website_CoccocMap_Icon_displayMyLocation.png", 8);
	 //clickOn("pictures\\Website_CoccocMap_Icon_displayMyLocation.png");
	 
	 if (waitForObjectPresent("pictures\\Website_CoccocMap_icon_myPOI.png", 5))
	 {
		 closeBrowser();
		 setTestcaseStatus("PASSED", "PASSED :==> #9 : Website can detect user's location ");
	 }
	 else
	 {
		 closeBrowser();
		 setTestcaseStatus("FAILED", "FAILED : ==> #9 : Website can NOT detect user's location  ");
		 
	 }
	 
	 
	}
	
	//Verify that user can open POI setting by click POI icon on Ominibox
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Google_services_Geolocation_05 </br>
	 * <b> CaseTitle: </b>Verify that user can open POI setting by double click POI icon on Ominibox</br>
	 * <b> Steps: </b>
1. Open any web require permission to access POI
2. Click on Allow or Block button
3. Click POI button on Ominibox .
4. Click Manage Location Settings . 
	 *  EXPECT : 
#4: Dialog : Gelocation Exception appear and CocCoc open settings page and modal "location setting" .
	 * @author hanv
	
	 */
	@Test
	public void Google_services_Geolocation_05 ()
	{
		
		TestLogger.info("========Google_services_Geolocation_05========");
		// startCocCocInEnglish();
		 if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		openLink("https://www.google.com/maps");
		waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15) ;
	    clickOn("pictures\\website_googleMap_icon_showDialog.png");
	     
	     
		if (waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 2)!=true);
		{
			waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
			clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
			waitForObjectPresent("pictures\\Website_SettingPOI_TextLink_ClearSettings.png", 8);
			closeBrowser();
			clickOn("pictures\\Browser_Menu_Button_CloseWindow.png");
		}
		
		// startCocCocInEnglish();
		if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
		else
			doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
		
		TestLogger.info("1. Open any web require permission to access POI.");
		openLink("https://www.google.com/maps");
		if (waitForObjectPresent("pictures\\website_googleMap_icon_showDialog.png", 15))
		{
	     clickOn("pictures\\website_googleMap_icon_showDialog.png");
		}
		waitForObjectPresent("pictures\\WebSite_CoccocMap_Dialog_Allow.png", 8);
		TestLogger.info("2. Click on Allow or Block button");
		clickOn("pictures\\WebSite_CoccocMap_Dialog_Allow.png");
		
		TestLogger.info("3. Click POI button on Ominibox .");
		waitForObjectPresent("pictures\\Website_CoccocMap_image_iconPOI.png", 8);
		clickOn("pictures\\Website_CoccocMap_image_iconPOI.png");
		
		TestLogger.info("4. Click Manage Location Settings . ");
		waitForObjectPresent("pictures\\website_CocCoc_textlink_ManageLocationSetting.png", 8);
		clickOn("pictures\\website_CocCoc_textlink_ManageLocationSetting.png");
		TestLogger.info("#4.Dialog : Gelocation Exception appear and CocCoc open settings page and modal 'location setting' .");
		// Check Dialog : Gelocation Exception appear 
		
		if (waitForObjectPresent("pictures\\Browser_Settings_Locations_dialogGeolocation.png", 5)) 
		{
			
			moveMouseHorizontallyFromLogo("pictures\\Browser_Settings_Text_LearnMore.png", 455);
			s.click();
			setTestcaseStatus("PASSED", "PASSED : ==> Dialog : Gelocation Exception appear ");
		}
		else
		{
			moveMouseHorizontallyFromLogo("pictures\\Browser_Settings_Text_LearnMore.png", 455);
			s.click();
			setTestcaseStatus("FAILED", "FAILED : ==> Dialog : Gelocation Exception DOES NOT appear ");
		}
		
		// Check CocCoc will open modal 'location setting' .
		
		if (waitForObjectPresent("pictures\\Browser_ContentSettings_Modal_location_setting.png", 5)) 
			
		{
			setTestcaseStatus("PASSED", "PASSED : =>  CocCoc opened  modal 'location setting'");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED : =>  CocCoc DID NOT open  modal 'location setting'");
		}
		
		waitForObjectPresent("pictures\\Browser_Settings_button_Done.png", 8);
		clickOn("pictures\\Browser_Settings_button_Done.png");
		openLink("coccoc://settings/#coccoc-settings-general");
		
		// Check CocCoc will open settings page
		if (waitForObjectPresent("pictures\\Browser_AddressBar_Text_LinkSettings.png", 5))
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "PASSED : =>  CocCoc opened settings page'");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "FAILED : =>  CocCoc DID NOT open setting page'");
		}
		
		
		
	}
	
	
}
