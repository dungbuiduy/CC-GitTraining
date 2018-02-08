package browser_Testsuite_Windows;
import org.sikuli.script.Key;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;
public class Browser_Windows_NewTab extends BrowserCommon {
	
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	private String userprofile = System.getenv("USERPROFILE");
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_02</br>
	 * <b> CaseTitle: </b> Check defaut most visited list </br>
	 * <b> Steps: </b></br>
	 *  1. Open a new tab
        2. Check the most visited URL list below the Search box
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  2. For fresh installation, list of most visited websites:
           youtube.com
           vnexpress.net
           mp3.zing.vn
           24h.com.vn
           dantri.com.vn
           vietnamnet.vn
           nhaccuatui.com
           wikipedia.org
	 *
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_Newtab_02 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Newtab_02: Check defaut most visited list");
		// uninstall CocCoc if any 
		UninstallAndClearAllData(CocCocVersion[1]);
				
		// Install latest Coccoc browser
		InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.UP,Key.WIN);
		TestLogger.info("1. Open a new tab ");
		s.type("t", Key.CTRL);
		TestLogger.info("2. Check the most visited URL list below the Search box");
		TestLogger.info("Expect :  For fresh installation, list of most visited websites:"
				+ "youtube.com"
				+ "vnexpress.net"
				+ "mp3.zing.vn"
				+ "24h.com.vn"
				+ "dantri.com.vn"
				+ "vietnamnet.vn"
				+ "nhaccuatui.com"
				+ "wikipedia.org");
		
		
		// Check youtube displayed on at the fist of list
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		s.click();
		
		if (waitForObjectPresent("pictures\\Website_youtube_image_logo.png", 3))
		{
			
			setTestcaseStatus("PASSED", "site : youtube displayed on at the fist of list on New Tab");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "site : youtube DOES NOT BE displayed on at the fist of list on New Tab");
		}
		
		// Check Vietnamnet site displayed on at the 6th of MOST VISITED list
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		TestLogger.info("1. Open a new tab ");
		s.type(Key.UP,Key.WIN);
		sleep(1);
		s.type("t", Key.CTRL);
		
		moveMouseHorizontallyFromLogo("pictures\\site_dantri_image_icon.png", 147);
		s.click(); 
		if (waitForObjectPresent("pictures\\Website_Vietnamnet_image_logo.png", 3))
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "site : Vietnamnet displayed on at the 6th of list on New Tab");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "site : Vietnamnet DOES NOT BE displayed on at the 6th of list on New Tab");
		}
		
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_03</br>
	 * <b> CaseTitle: </b> Check add 1 web </br>
	 * <b> Steps: </b></br>
	 *    1. Open a new tab
          2. connect 1 website not have on list web
          3. open new newtab
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *    3. If Browser has just been installed, last opened website will display at the beginning of the list. Same thing with the first 8 websites if they don't exist in most visited list
	 *
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_Newtab_03 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Newtab_03: Check defaut most visited list");
		UninstallAndClearAllData(CocCocVersion[1]);
		
		// Install latest Coccoc browser
		InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.UP,Key.WIN);
		s.type("t", Key.CTRL);
		TestLogger.info("1. Open a new tab ");
		TestLogger.info("connect 1 website not have on list web ");
		s.type("https://map.coccoc.com/map") ;
		s.type(Key.ENTER) ; 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		s.type("t", Key.CTRL); 
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		s.click();
		if (waitForObjectPresent("pictures\\Site_CocCocMap_image_logo.png", 5))
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "last opened website will display at the beginning of the list ");
		}
		
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "last opened website DOES NOT display at the beginning of the list ");
		}
	}
		
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_04</br>
	 * <b> CaseTitle: </b> Check when delete 1 URLs in most visited list </br>
	 * <b> Steps: </b></br>
	 *   1. Open a new tab
         2. Delete 1 URLs in most visited list
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *   2. After deleting 1 URLs in a list, 1 msg displayed: "Thumnail removed" + 3 buttons appears: Undo, Restore all, (x) close
	 *
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_Newtab_04 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Newtab_04: Check when delete 1 URLs in most visited list");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		TestLogger.info("1. Open a new tab ");
		s.type("t", Key.CTRL);
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		clickOn("pictures\\Site_NewTab_icon_removeList.png");
		if (waitForObjectPresent("pictures\\CocCoc_newtab_image_recoverURL.png", 4))
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "After deleting 1 URLs in a list, 1 msg displayed: Thumnail removed+ 3 buttons appears: Undo, Restore all, (x) close");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "After deleting 1 URLs in a list, 1 msg NOT displayed: Thumnail removed+ 3 buttons appears: Undo, Restore all, (x) close");
		}
		
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_05</br>
	 * <b> CaseTitle: </b> Delete - Undo items in Most visited list </br>
	 * <b> Steps: </b></br>
	 *  1. Focus in Most visited list
        2. Hover on the right corner of each item
        3. Click (X) button to Delete
        4. Click on" Hoàn tác" 
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  2. Icon x appears
        3. There is info message displayed: "Ðã xóa hình thu nh?" & 2 nút "Hoàn tác" - "Khôi ph?c t?t c?"
        4. - Button " Hoàn tác" is not override by Popular website list
           - Last deleted website is restored
	 *
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_Newtab_05 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Newtab_04: Check when delete 1 URLs in most visited list");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		TestLogger.info("1. Open a new tab ");
		s.type("t", Key.CTRL);
		TestLogger.info("2. Hover on the right corner of each item");
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		s.click();
		// get URL of OPENED site 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -100);
		s.click();
		s.type("a", Key.CTRL);
		s.type("c", Key.CTRL);
		String URL1 = getClipboardValue() ;
		
		TestLogger.info("====> URL 1 " + URL1);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		TestLogger.info("3. Click (X) button to Delete");
		clickOn("pictures\\Site_NewTab_icon_removeList.png"); 
		
		TestLogger.info("4. Click on Hoàn tác "); 
		clickOn("pictures\\CocCoc_newtab_image_recoverURL.png");
		
		// Check  - Last deleted website is restored
		moveMouseDownFromLogo("pictures\\Browser_Menu_Button_Reload.png", 100);
		s.click(); 
		
		// get URL of Recovered site 
	     clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
	     moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -100);
		 s.click();
		 s.type("a", Key.CTRL);
		 s.type("c", Key.CTRL);
		 String URL2 = getClipboardValue() ;  
		 TestLogger.info("====> URL 2 " + URL2); 
		 
		 
		 if (URL2.contains(URL1)) 
		 {
			 closeBrowser();
			 setTestcaseStatus("PASSED", "Last deleted website is restored");
		 }
		 else
		 {
			 closeBrowser();
			 setTestcaseStatus("FAILED", "Last deleted website is NOT restored" );
		 }
					
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_AddTone_06</br>
	 * <b> CaseTitle: </b> Title of item in Most visited list </br>
	 * <b> Steps: </b></br>
	 *     1. Focus in Most visited list
           2. Hover on each item
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *     1. Thumbnail changes color to darker
           2. Show title of web sites as tooltip
	 *
	 * @Update HANV
	 */
	
	@Test
	public void Browser_SNIFF_Newtab_06 ()
	{
		        // uninstall CocCoc if any 
				UninstallAndClearAllData(CocCocVersion[1]);	
				//Install latest Coccoc browser
				InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.UP,Key.WIN);
				TestLogger.info("1. Open a new tab ");
				s.type("t", Key.CTRL);
				TestLogger.info(" 2. Hover on each item");
				TestLogger.info("EXPECT : Show title of website as tooltip"); 
				//Check toolTip of Yotube 
				 hoverImage("pictures\\site_youtube_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_youtube_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of Youtube");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of Youtube");
				 }
				 
				 TestLogger.info("EXPECT : Show title of web sites as tooltip ");
				//Check toolTip of Vnexpress
				 hoverImage("pictures\\site_vnexpress_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_vnexpress_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of Vnexpress");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of VnExpress");
				 }
				 
				//Check toolTip of Zing MP3
				 hoverImage("pictures\\site_Zing_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_zing_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of Zing MP3");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of Zing MP3");
				 }
				
				//Check toolTip of 24h
				 hoverImage("pictures\\site_24h_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_24h_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of 24h");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of 24h");
				 }
				
				//Check toolTip of dantri
				 hoverImage("pictures\\site_dantri_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_dantri_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of dantri");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of dantri"); 
				 }
				//Check toolTip of vietnamnet
				 hoverImage("pictures\\site_vietnamnet_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_vietnamnet_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of vietnamnet");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of vietnamnet"); 
				 }
						
				 
				//Check toolTip of nhaccuatui
				 moveMouseDownFromLogo("pictures\\site_nhaccuatui_image_icon.png",-48); 
				 if (waitForObjectPresent("pictures\\site_nhaccuatui_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of nhaccuatui");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of nhaccuatui"); 
				 }
				 
				//Check toolTip of Wiki 
				 hoverImage("pictures\\site_Wiki_image_icon.png"); 
				 if (waitForObjectPresent("pictures\\site_Wiki_text_tooltip.png", 4))
				 {
					 setTestcaseStatus("PASSED", "Showed ToolTip of Wiki");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", " DO NOT Show ToolTip of Wiki"); 
				 }
					
	}
}
