package browser_Testsuite_Windows;
import java.io.File;

import org.sikuli.script.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.TestLogger;

public class Browser_Windows_Downloader extends BrowserCommon_Extensions {
	
	private File fileIndownload = new File(System.getenv("USERPROFILE") + "\\Downloads\\Phim ca nhạc YÊU - KHẮC VIỆT.mp4.crdownload");
	private File fileDownloadDone = new File(System.getenv("USERPROFILE") + "\\Downloads\\Phim ca nhạc YÊU - KHẮC VIỆT.mp4"); 
	private File fileDownloadCancel2 = new File(System.getenv("USERPROFILE") + "\\Downloads\\A G A I N.mp4"); 
	private File fileDownloadCancel1 = new File(System.getenv("USERPROFILE") + "\\Downloads\\NB Underground.mp4"); 
	private String siteHasMedia = "http://www.youtube.com/watch?v=fhPRDh6NSRA";
    
	//@BeforeClass
	public void beforTest(){
		TestLogger.info("----------------------------TEST SNIFF FOR DOWNLOADER----------------------");
		
		String userprofile = System.getenv("USERPROFILE");
		String domainDownloadCocCoc = getCocCocVersion("config\\coccocVersion.txt")[0];
		if(DownloadCCBrowser(domainDownloadCocCoc)){
			UninstallAndClearAllData("");
			if(!InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe"))
				setTestcaseStatus("SKIPED", "Cannot install coc coc browser, skipp all test");
		}
		else
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
	}
	
	@AfterMethod
	public void cleanupEnv(){
		TestLogger.info("Clean Coc Coc ");
		  clearDownloads();
		  closeBrowser();
		
	} 
	
	

	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_01 </br>
	 * <b> CaseTitle: </b> Check download page layout</br>
	 * <b> Steps: </b>
	 *     Open download page (coccoc://downloads)</b></br>
	 *  
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  2. On Top appear : - 3 buttons : Add link, Add torrent, Clear all 
	 *  1. Left menu there are 6 categories:"- All, Downloading, Paused, Finished, Torrent, Seeding</br> </b> </br>
	 *  3. At the bottom, there is link to "Settings", Download limit, Upload limit and ratio limit
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_01()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_01: Check download page layout");
		startCocCoc();
		
		openLink("coccoc://downloads");
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		
		//check 3 button on top bar
		if (waitForObjectPresent("pictures\\Browser_Torrent_Menu_MainMenu.png", 5))
			setTestcaseStatus("PASSED", "3 buttons : Add link, Add torrent, Clear all appear on top bar");
		else
			setTestcaseStatus("FAILED", "one of 3 buttons : Add link, Add torrent, Clear all disappear on top bar");
		
		//check 6 menu item appears on left bar
		if (waitForObjectPresent("pictures\\Browser_Downloader_LeftMenu_DownloadPage.png", 5))
			setTestcaseStatus("PASSED", "Left menu have 6 categories: All, Downloading, Paused, Finished, Torrent, Seeding");
		else
			setTestcaseStatus("FAILED", "Left menu miss one of 6 categories: All, Downloading, Paused, Finished, Torrent, Seeding");
		
		//At the bottom, there is link to "Settings", Download limit, Upload limit and ratio limit
		if (waitForObjectPresent("pictures\\Browser_Downloader_button_LinktoSettingPage.png", 5)){
			clickOn("pictures\\Browser_Downloader_button_LinktoSettingPage.png");
			if (waitForObjectPresent("pictures\\Browser_Settings_Menu_DownloadAndTorrentSetting.png", 5))
				setTestcaseStatus("PASSED", "At the bottom, there is link to 'Settings': Download limit, Upload limit and ratio limit");
			else
				setTestcaseStatus("FAILED", "At the bottom, there is link to 'Settings', but not navigate to settings page");
		}
			
		else
			setTestcaseStatus("FAILED", "At the bottom, there is link to 'Settings'");
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_02 </br>
	 * <b> CaseTitle: </b>Check the display of downloading status bar when downloading a file </br>
	 * <b> Steps: </b>
	 * 1. Open 1 new tab, access any page having music, movie, video can be downloaded</b></br>
	 * 2. Click on Savior icon in browser toolbar to download some media file 
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  The download file must be displayed in Download-shelf at the bottom of browser
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_02()
	{
		
	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_02: Check the display of downloading status bar when downloading a file");
		startCocCoc();
		openLink(siteHasMedia);
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -125);
		sleep(5);
		
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		sleep(5);
		
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_LinkText_DisplayFileAtBbottom.png", 25))
		{
			
			setTestcaseStatus("PASSED", "The download file must be displayed in Download-shelf at the bottom of browser ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "The download file must be displayed in Download-shelf at the bottom of browser ");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_04 </br>
	 * <b> CaseTitle: </b>Check "Pause" of downloader</br>
	 * <b> Steps: </b>
	 * 1. Open browser</b></br>
	 * 2. Open 1 new tab, access any page having music, movie, video can be downloaded
	 * 3. Click on icon Ma trang 'Tai xuong' in browser toolbar
	 * 4. Click on 'pause' in download page
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  1. Stop the download at specific status 
	 *  2. Temp file on local PC still exist in selected download folder
	 *  3. Display button "Continue"
	 * @author hanv
	 *
	
	 */
	
	@Test
	public void Browser_SNIFF_Downloader_04()
	{
		
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_04: Check 'Pause' of downloader ");
		startCocCoc();
		
		//Download form youtube
		openLink(siteHasMedia);
		waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 50);
		
		//download youtube file
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -150);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		sleep (1); 
		
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_LinkText_DisplayFileAtBbottom.png", 25))
		{
			
			setTestcaseStatus("PASSED", "The download file are displayed in Download-shelf at the bottom of browser ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "he download file are NOT displayed in Download-shelf at the bottom of browser ");
		}
		
		//Open Download page
		s.type("j", Key.CTRL);
        waitForObjectPresent("pictures\\Browser_DownloadPage_Button_PauseDownload.png", 5);

        clickOn("pictures\\Browser_DownloadPage_Button_PauseDownload.png");
        
        if (waitForObjectPresent("pictures\\Browser_DownloadPage_Button_BackToDownloadStatus.png", 5))
        {
        	
        	
        	setTestcaseStatus("PASSED", "After click on 'pause' button, the button 'Continue' appears");
        }
        else
        {
        	
        	setTestcaseStatus("FAILED", "After click on 'pause' button, the button 'Continue' disappears");
        }
        
        if(fileIndownload.exists())
        {
        	
        	setTestcaseStatus("PASSED", "Temp file on local PC still exist in selected download folder");
        }
        else
        {
        	
        	setTestcaseStatus("FAILED", "Temp file on local PC DOES NOT exist in selected download folder");
        }
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_05 </br>
	 * <b> CaseTitle: </b>Check "Resume" of downloader</br>
	 * <b> Steps: </b>
	 * 1. Open browser
       2. Open 1 new tab, access any page having music, movie, video can be downloaded
       3. Click on icon "M? trang "T?i xu?ng"" in browser toolbar
       4. Click on "pause" in download page
       5. Then click on "Resume"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 * 1. The download is resumed from where it's stopped
       2. After completed, file is saved in selected download folder in local PC and file properties has correct info
	 * @author hanv
	 */
		@Test
		public void Browser_SNIFF_Downloader_05()
		{
			
			TestLogger.info("===============================================================================================================");
			TestLogger.info("Browser_SNIFF_Downloader_05: Check 'Resume' of downloader");
			startCocCoc();
			
			//Download form youtube
			openLink(siteHasMedia);
			waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 50);
			moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -150);
			clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
			
			//Open Download page
			s.type("j", Key.CTRL);
	        waitForObjectPresent("pictures\\Browser_DownloadPage_Button_PauseDownload.png", 5);
	        clickOn("pictures\\Browser_DownloadPage_Button_PauseDownload.png");
	        sleep(2);
	        
	        clickOn("pictures\\Browser_DownloadPage_Button_BackToDownloadStatus.png");
	        sleep(2);
	        
	        if (waitForObjectPresent("pictures\\Browser_DownloadPage_Button_PauseDownload.png", 5))
	        	setTestcaseStatus("PASSED", "The download is resumed from where it's stopped ");
	        else
	        	setTestcaseStatus("FAILED", "The download is NOT resumed from where it's stopped ");
	        
	        waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360);
	        
        	if(fileDownloadDone.exists()) 
        	{
        		
        		setTestcaseStatus("PASSED", "After completed, file is saved in selected download folder in local PC and file properties has correct info");
        	}
        	else 
        	{
        		
        		setTestcaseStatus("FAILED", "After completed, file is NOT saved in selected download folder in local PC and file properties has correct info");
        	}
	      
		}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_06 </br>
	 * <b> CaseTitle: </b>Check "Open folder with downloaded file" of downloader</br>
	 * <b> Steps: </b>
	 * 1. Open browser
       2. Open 1 new tab, access any page having music, movie, video can be downloaded
       3. Click on icon "M? trang "T?i xu?ng"" in browser toolbar
       4. When completed, click on folder icon to open download folder on local PC
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 * Downloaded file is saved in right folder
	 * @author hanv
	 */
	
	@Test
	public void Browser_SNIFF_Downloader_06()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_06: Check 'Open folder with downloaded file' of downloader");
		startCocCoc();
		openLink(siteHasMedia);
		waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 50);
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -150);
		clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
		
		//Open Download page
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
        waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360); 
        clickOn("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png");
        
        
       
        if(fileDownloadDone.exists()) 
        {
        	
        	
        	setTestcaseStatus("PASSED", "Downloaded file is saved in right folder");
        }
	    else
	    {
	    	
			setTestcaseStatus("FAILED", "Downloaded file is NOT saved in right folder");
	    }
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_07 </br>
	 * <b> CaseTitle: </b>Check "Cancel" of downloader</br>
	 * <b> Steps: </b>
	 * 1. Open browser
       2. Open 1 new tab, access any page having music, movie, video can be downloaded
       3. Click on icon "M? trang "T?i xu?ng"" in browser toolbar
       4. Click on icon "Cancel" in download page
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 * Stop the download, menu appears: Try again, Remove from list
	
	 * @author hanv
	
	 */
	
	@Test
	public void Browser_SNIFF_Downloader_07()
	{ 
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_07: Check 'Cancel' of downloader");
        
		startCocCoc();
		//openLink(siteHasMedia);
		openLink("http://vimeo.com/channels/staffpicks/172513451");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_LinkText_DisplayFileAtDockDownload.png", 25))
		{
			
			setTestcaseStatus("PASSED", "The download file are displayed in Download-shelf at the bottom of browser ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "he download file are NOT displayed in Download-shelf at the bottom of browser ");
		}
		
		
		s.type("j", Key.CTRL);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		clickOn("pictures\\Browser_Downloader_Button_CancelDownload.png");	
		
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_tryDownload.png", 2))
			setTestcaseStatus("PASSED", "Stoped the download, menu appears: Try again, Remove from list ");
		else
			setTestcaseStatus("FAILED", "Did not Stop the download, and does not show menu: Try again, Remove from list ");
	}
	
    // Check "Remove from list" from download history 
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_08 </br>
	 * <b> CaseTitle: </b>Check "Remove from list" from download history</br>
	 * <b> Steps: </b>
	 1. Open browser
     2. Open 1 new tab, access any page having music, movie, video can be downloaded
     3. Click on icon "Mở trang "Tải xuống"" in browser toolbar
     4. Click on icon "Cancel" in download page
     5. Click icon "Remove from list" in download page
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 * Selected download is removed from Download list
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_08()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_08: Check 'Remove from list' from download history");
		
		startCocCoc();
		 sleep(4);
		 s.type(Key.UP, Key.WIN);
		openLink("https://www.youtube.com/watch?v=3vA7RM5TRdo");
		waitForObjectPresent("pictures\\Website_youtube_image_logo.png", 45);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		
		openLink("https://vimeo.com/channels/staffpicks/147897290");
		waitForObjectPresent("pictures\\Website_vimeo_Button_JointButton.png", 45);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		
		s.type("j", Key.CTRL);
		
		while (waitForObjectPresent("pictures\\Browser_Downloader_Button_CancelDownload.png", 15))
		{
			clickOn("pictures\\Browser_Downloader_Button_CancelDownload.png");
			clickOn("pictures\\Browser_Downloader_Button_RemoveDownloadItem.png");
		}
		
		if (fileDownloadCancel1.exists() || (fileDownloadCancel2.exists()))
			setTestcaseStatus("FAILED", "Selected download are NOT removed from Download list");
		else
			setTestcaseStatus("PASSED", "Selected download Files are removed from Download list");
		
	}

	 // Check "Remove from list" from download history 
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_09 </br>
	 * <b> CaseTitle: </b>Check "Try again" of downloader</br>
	 * <b> Steps: </b>
	 1. Open browser 
     2. Open 1 new tab, access any page having music, movie, video can be downloaded
     3. Click on icon "Mở trang "Tải xuống"" in browser toolbar
     4. Click on icon "Cancel" in download page
     5. click on icon "Try again"/"Thử lại download"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 * The download starts a new progress, new item
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_09()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_09: Check 'Try again' of downloader");
		startCocCoc();
		//open incognio tab
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (0.5);
		s.type("http://vimeo.com/channels/staffpicks/172513451");
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_vimeo_Button_JointButton.png", 45);
		sleep (8);
		hoverImage("pictures\\Website_vimeo_Button_JointButton.png");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (5);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		clickOn("pictures\\Browser_Downloader_Button_CancelDownload.png");
		
		waitForObjectPresent("pictures\\Browser_Downloader_Button_tryDownload.png", 25);
		clickOn("pictures\\Browser_Downloader_Button_tryDownload.png");
		
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_Pause.png", 8))
		{
			
			setTestcaseStatus("PASSED", "The download starts a new progress, new item ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "The download not starts a new progress, new item ");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_12 </br>
	 * <b> CaseTitle: </b>Check "Open source page"</br>
	 * <b> Steps: </b>
	 1. Open browser, download some media file 
     2. Open download page (coccoc://downloads)
     3. Hover on arrow icon and select "Open source page"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  Media source page should display in new tab
	 * @author hanv
	
	 */
	@Test
	public void Browser_SNIFF_Downloader_12()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_12: Check 'Open source page'");
		
		startCocCoc();
		openLink("http://vimeo.com/channels/staffpicks/172513451");
		sleep (5);
		waitForObjectPresent("pictures\\Website_vimeo_Button_JointButton.png", 45);
		sleep (12);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (5);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		sleep (2);
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		
		clickOn("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Torrent_Button_DeletedAll.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		waitForObjectPresent("pictures\\Browser_Downloader_ContextMenu_OpenSourcePage.png", 10);
		clickOn("pictures\\Browser_Downloader_ContextMenu_OpenSource.png");
		
		if (waitForObjectPresent("pictures\\Website_Vimeo_Logo_VimeoLogo.png", 65))
		{
			
			setTestcaseStatus("PASSED", "Media source page display in new tab ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "Media source page not display in new tab ");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_13 </br>
	 * <b> CaseTitle: </b>Check "Remove file from disk"</br>
	 * <b> Steps: </b>
	 1. Open browser, download some media file 
     2. Open download page (coccoc://downloads)
     3. Hover on arrow icon and select "Remove file from disk"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  Remove files which are downloaded before from HDD
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_13()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_13: Check 'Remove file from disk");
		
		if (fileIndownload.exists() || fileDownloadDone.exists()) 
		{
			fileIndownload.delete();
			fileDownloadDone.delete();
		}
		
		startCocCoc();
		
		openLink("https://www.youtube.com/watch?v=fhPRDh6NSRA");

		waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 50);
		sleep(3);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 15);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		
		sleep(3);
		s.type("j", Key.CTRL);
		
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360);
		
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		waitForObjectPresent("pictures\\Browser_Downloader_Button_DeleteFile.png", 5);
		
		clickOn("pictures\\Browser_Downloader_Button_DeleteFile.png");
		
		if ((!fileIndownload.exists()) & (!fileDownloadDone.exists()))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The file had been deleted on HDD after clicking on button 'remove from hard disk'");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The file still exist on HDD after clicking on 'remove from hard disk'");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_14 </br>
	 * <b> CaseTitle: </b>Check "Open when done"</br>
	 * <b> Steps: </b>
     *   1. Open browser, download some media file 
     *   2. Open download page (coccoc://downloads)
     *   3. When download is in progress, hover on arrow icon and check on "Open when done"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  Downloaded file will be opened automatically in default media player when download finished
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_14()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_14: Check 'open when done'");
		startCocCoc();
		openLink(siteHasMedia);
		waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 120);
		sleep(5);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 15);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");

		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 15);
		
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Torrent_Button_DeletedAll.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		
		waitForObjectPresent("pictures\\Browser_Downloader_ContextMenu_OpenWhenDone.png", 10);
		
		clickOn("pictures\\Browser_Downloader_ContextMenu_OpenWhenDone.png");
		
	    boolean flag  = waitForObjectPresent("pictures\\OSapp_VLC_Title_TitleOfFilm.png", 360);
	    closeVLCPlayer();
		
		if (flag)
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Downloaded file will be opened automatically in default media player when download finished ");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "Downloaded file DOES NOT BE opened automatically in default media player when download finished ");
		}
     }
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_15 </br>
	 * <b> CaseTitle: </b>Check "Play" button display if downloading file is not video format"</br> 
	 * <b> Steps: </b> 
        1. Open browser, download some mp3 file (Ex: http://mp3.zing.vn/bai-hat/Gat-Di-Nuoc-Mat-SlimV-Remix-Noo-Phuoc-Thinh-SlimV/ZW7O6EDF.html)
        2. Open Download page (coccoc://downloads)
        3. Observe GUI "Play" button
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  'Make sure that "Play" button is not display while downloading these kind of files 
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_15()
	{
		TestLogger.info("===============================================================================================================");
		 TestLogger.info("----Browser_SNIFF_Downloader_15: check 'Play' button display if downloading file is not video format");
		 startCocCoc();
		 openLink("http://www.nhaccuatui.com/playlist/xuan-trong-ta-dong-nhi-ft-ngoc-linh-ft-abba-ft-dan-nguyen-ft-quang-le-ft-quang-linh-ft-manh-quynh-ft-my-linh.pTazKOcCdGnv.html");
		 sleep(10);
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 //clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		 sleep (4);
		 clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		 sleep(5);
		 openLink("coccoc://downloads/");
		 
		 waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		 
		 if (!waitForObjectPresent("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png", 3))
		 {
			
			 setTestcaseStatus("PASSED", "The Play button does not display while downloading media files ");
		 }
		 else
		 {
	
			 setTestcaseStatus("FAILED", "The Play button STILL display while downloading media files ");
		 }
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_16 </br>
	 * <b> CaseTitle: </b>Check if "Play" button is showed while/after downloading a video file</br> 
	 * <b> Steps: </b> 
        1. Open browser, download some video files (Ex: https://www.youtube.com/watch?v=8T5SpxV1TbI)
        2. Open Download page (coccoc://downloads)
        3. Observe"Play" button while files are downloading
        4. Wait for downloading is finished
        5. Observe "Play" button after downloading
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  'Make sure that "Play" button is displayed while/after downloading  (GUI of "Play button should be like this:        )
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_16()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_16: Check if 'Play' button is showed while/after downloading a video file ");
		startCocCoc();
		openLink("https://vimeo.com/channels/staffpicks/172513451");
		sleep (12);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (4);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		sleep (2);
		s.type("j", Key.CTRL);
		// check right after clicking Download of Savior 
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 25);
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png", 10))
			setTestcaseStatus("PASSED", "Play button is displayed while downloading ");
		else
			setTestcaseStatus("FAILED", "Play button is NOT displayed while downloading ");
		//check after pausing download progress
		clickOn("pictures\\Browser_Downloader_Button_Pause.png");
		
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png", 10))
			setTestcaseStatus("PASSED", "Play button is displayed when pause ");
		else
			setTestcaseStatus("FAILED", "Play button does not display when pause ");
		
		// check after finishing download progress 
		clickOn("pictures\\Browser_Downloader_Button_Continue.png");
		
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360) ;
		
		if (waitForObjectPresent("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png", 3))
		{
			
			setTestcaseStatus("PASSED", "Play button is displayed after downloading files ");
		}
		else
		{
			
			setTestcaseStatus("FAILED", "Play button is NOT displayed after downloading files ");
		}
	}
		
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_17 </br>
	 * <b> CaseTitle: </b>Check "Play" windows</br> 
	 * <b> Steps: </b> 
       1. Open browser, download some media file 
       2. Open download page (coccoc://downloads)
       3. Hover on some media files which downloading are finished
       4. Click on "Play"
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  4. - Media content is opened in a small screen
      - Title of detach screen is the name of downloaded file that you have saved
      - The icon of "Play" should display on the task bar like this one 
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_17()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_17: Check Play windows");
		startCocCoc();

		openLink(siteHasMedia);
		sleep(2);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		s.type("j", Key.CTRL);
		
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360) ;
		
		waitForObjectPresent("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png", 12);
		
		clickOn("pictures\\Browser_Downloader_Button_PlayFileDownloaded.png");
		
		if (waitForObjectPresent("pictures\\Browser_DownloadPage_Text_FilmTitle.png", 15) )
		{   
			moveMouseDownFromLogo("pictures\\Browser_DownloadPage_Text_FilmTitle.png", 100);
			if (waitForObjectPresent("pictures\\Browser_DownloadPage_Button_Pause.png", 5))
			{
			  clickOn("pictures\\Browser_Savior_Icon_MiniWindow.png");
			  s.type(Key.F4, Key.ALT);
			setTestcaseStatus("PASSED", "Media contain is opened in a small screen correctly");
			}
		}
		else
		{
			clickOn("pictures\\Browser_Savior_Icon_MiniWindow.png");
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("FAILED", "Media contain isn't opened in a small screen correctly");
		}
		
		
		
		
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_18 </br>
	 * <b> CaseTitle: </b>Check Icognito icon in downloaded file if downloading in Icognito mode</br> 
	 * <b> Steps: </b> 
     *  1. Open browser in Icognito mode, download any file 
     *  2. Open download page (coccoc://downloads)
     *  3. Observe the icon of downloaded file
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  '3. Icognito icon should display at the corner of the icon of download file. 
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_Downloader_18()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_18: Check Icognito icon in downloaded file if downloading in Icognito mode");
		
		startCocCoc();
		s.type(Key.ESC);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (1);
		s.type("n", Key.CTRL + Key.SHIFT);
		s.type("https://www.youtube.com/watch?v=OLy0v23hXhE");
		s.type(Key.ENTER);
		sleep(10);
		if (waitForObjectPresent("pictures\\website_nhaccuatui_icon_close.png", 3))
		{
			clickOn("pictures\\website_nhaccuatui_icon_close.png");
		}
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		sleep(4);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		sleep(5);
		openLink("coccoc://downloads/");
		
		waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png",15);
		if ( waitForObjectPresent("pictures\\Browser_DownloadPage_Icon_IcognitoVLCFile.png", 1) || (waitForObjectPresent("pictures\\Browser_DownloadPage_Icon_IcognitoMP3File.png", 1)))
		{
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("PASSED", "Icognito icon display at the corner of the icon of download file");
		}
		else
		{
			s.type(Key.F4, Key.ALT);
			setTestcaseStatus("FAILED", "Icognito icon NOT display at the corner of the icon of download file");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_19 </br>
	 * <b> CaseTitle: </b>Check download menu in Download dock when user downloads a file (mp3, video, word, ...)</br> 
	 * <b> Steps: </b> 
     * 1. Open browser, download any file (can download from youtube, gmail, any site, ...)
       2. Observe download dock at the bottom of page
       3. Click on down arrow button to check menu of downloading file 
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 *  '2. Downloading file appear at the bottom of current page
         3. context menu is opened: 
         - Play
         - Open when done (if file is downloading)
         - Open (If finished downloading)
         - Always open files of this type
         - Show in folder
         - Cancel (Enable if file is downloading, Disable if file is completely downloaded)
	 * @author hanv
	 */
	
	@Test
	public void Browser_SNIFF_Downloader_19()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_19: Check download menu in Download dock when user downloads a file (mp3, video, word, ...)");
		startCocCoc();
		s.type(Key.ESC);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (1);
		TestLogger.info(" 1. Open browser, download any file (can download from youtube, gmail, any site, ...)");
		openLink("https://www.youtube.com/watch?v=TpxQFHIdYIU");
		sleep (5); 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(12);
		clickOn("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png");
		TestLogger.info("2. Observe download dock at the bottom of page");
		TestLogger.info("EXPECT : '2. Downloading file appear at the bottom of current page");
		if (waitForObjectPresent("pictures\\CocCoc_Downloader_Icon_fileDownload.png", 3))
		{
			setTestcaseStatus("PASSED", "Downloading file appear at the bottom of current page");
		}
		else
		{
			setTestcaseStatus("FAILED", "Downloading file DOES NOT appear at the bottom of current page");
		}
		
		TestLogger.info(" 3.Click on down arrow button to check menu of downloading file ");
		openLink("coccoc://downloads/"); 
		waitforObjectNotexist("pictures\\Browser_Torrent_Button_PauseDownload.png", 360);
		clickOn("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Torrent_Button_DeletedAll.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		if (waitForObjectPresent("pictures\\CocCoc_Downloader_Text_MenuContext.png", 3))
		{
			setTestcaseStatus("PASSED", "Context menu is opened");
		}
		else
		{
			setTestcaseStatus("FAILED", "Context menu is NOT opened");
		}
	}
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Downloader_20 </br>
	 * <b> CaseTitle: </b>Check if all context menus in Download dock work well</br> 
	 * <b> Steps: </b> 
        1. Download a file on CC Browser
        2. In Download dock, click on down arrow button
        3. check working of all context menu:
         - Play (Enable if downloading file is mp3, video. Disable if downloading file is word, excel, image)
         - Open when done (if file is downloading)
         - Open (If finished downloading)
         - Always open files of this type
         - Show in folder
         - Cancel (Enable if file is downloading, Disable if file is completely downloaded)
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	    2. context menu is displayed
        3. Make sure that all menu work well:
        - Play: Downloading file is played in PIN screen => Done in Browser_SNIFF_Downloader_17 
        - Open when done: Downloading file will be opened when downloading is completed => Done in Browser_SNIFF_Downloader_14
        - Show in folder: take user to the folder which contains downloaded file => Done in Browser_SNIFF_Downloader_06
        - Cancel: Downloading is canceled => Done in Browser_SNIFF_Downloader_06
	 * @author hanv
	 */
	//  This case was Automated in cases :  Browser_SNIFF_Downloader_17 , Browser_SNIFF_Downloader_14 , Browser_SNIFF_Downloader_06 
	//  Thus , i will NOT write more for Browser_SNIFF_Downloader_20 . 
	@Test
	public void Browser_SNIFF_Downloader_20()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_Downloader_20: Check download menu in Download dock when user downloads a file (mp3, video, word, ...)");
		TestLogger.info(" Check working of all context menu:");
		TestLogger.info("EXPECT : Make sure that all menu work well: "
				+ "- Play: Downloading file is played in PIN screen => Done in Browser_SNIFF_Downloader_17"
				+ "- Open when done: Downloading file will be opened when downloading is completed => Done in Browser_SNIFF_Downloader_14"
				+ "- Show in folder: take user to the folder which contains downloaded file => Done in Browser_SNIFF_Downloader_06"
				+ "- Cancel: Downloading is canceled => Done in Browser_SNIFF_Downloader_06");
		
		
	}
}
