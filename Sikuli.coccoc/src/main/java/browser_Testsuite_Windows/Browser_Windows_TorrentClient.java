package browser_Testsuite_Windows;

import java.io.File;

import org.sikuli.script.App;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_TorrentClient extends BrowserCommon{
	// site : http://extratorrent.cc/ 
	String userprofile = System.getenv("USERPROFILE");
	String magnetLink = "magnet:?xt=urn:btih:5CAB9C0E2B3CC85A5AF556A065A397789A5EA8C2&dn=chance+the+rapper+coloring+book+2016+mixtape+mp3+320+kbps&tr=udp%3A%2F%2Ftracker.publicbt.com%2Fannounce&tr=udp%3A%2F%2Fglotorrents.pw%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce";
	String magnetTorrent = "magnet:?xt=urn:btih:6b338ddeb503f21652854d88f6bb9175801aea88&dn=The.Last.Heist.2016.HDRip.AC3.x264-BDP&tr=udp%3a%2f%2fexplodie.org%3a6969%2fannounce&tr=http%3a%2f%2ftracker.tfile.me%2fannounce&tr=http%3a%2f%2fbigfoot1942.sektori.org%3a6969%2fannounce&tr=udp%3a%2f%2feddie4.nl%3a6969%2fannounce&tr=udp%3a%2f%2ftracker4.piratux.com%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.trackerfix.com%3a80%2fannounce&tr=udp%3a%2f%2ftracker.pomf.se%3a80%2fannounce&tr=udp%3a%2f%2ftorrent.gresille.org%3a80%2fannounce&tr=udp%3a%2f%2f9.rarbg.me%3a2710%2fannounce&tr=udp%3a%2f%2ftracker.leechers-paradise.org%3a6969%2fannounce&tr=udp%3a%2f%2fglotorrents.pw%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.opentrackr.org%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.blackunicorn.xyz%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.internetwarriors.net%3a1337%2fannounce&tr=udp%3a%2f%2fp4p.arenabg.ch%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.coppersurfer.tk%3a6969%2fannounce&tr=udp%3a%2f%2f9.rarbg.to%3a2710%2fannounce&tr=udp%3a%2f%2ftracker.openbittorrent.com%3a80%2fannounce&tr=udp%3a%2f%2fglotorrents.pw%3a6969%2fannounce&tr=udp%3a%2f%2feddie4.nl%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.leechers-paradise.org%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.piratepublic.com%3a1337%2fannounce&tr=udp%3a%2f%2fzer0day.ch%3a1337%2fannounce&tr=udp%3a%2f%2ftorrent.gresille.org%3a80%2fannounce&tr=udp%3a%2f%2ftracker.sktorrent.net%3a6969%2fannounce&tr=udp%3a%2f%2fthetracker.org%3a80%2fannounce&tr=http%3a%2f%2fexplodie.org%3a6969%2fannounce&tr=udp%3a%2f%2f9.rarbg.to%3a2710%2fannounce&tr=udp%3a%2f%2f9.rarbg.me%3a2710%2fannounce&tr=udp%3a%2f%2ftracker.aletorrenty.pl%3a2710%2fannounce&tr=udp%3a%2f%2fp4p.arenabg.ch%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.opentrackr.org%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.coppersurfer.tk%3a6969%2fannounce";
	String magnetTorrent2 = "magnet:?xt=urn:btih:01E19B42B9A791214A5E4F2E22AD022FB54084E4&dn=la+tour+2+controle+infernale+2014+french+webrip+xvid+eve+avi&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fglotorrents.pw%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce";
	String torrentLink = "http://itorrents.org/torrent/6B338DDEB503F21652854D88F6BB9175801AEA88.torrent?title=[limetorrents.cc]The.Last.Heist.2016.HDRip.AC3.x264-BDP";
	String siteDownloadTorrent = "https://www.limetor.co/The-Last-Heist-2016-HDRip-AC3-x264-BDP-torrent-8015794.html";
	String torrentDownloadFolder =userprofile + "\\Downloads\\The.Last.Heist.2016.HDRip.AC3.x264-BDP";
	String torrentDownloadFolder2= userprofile + "\\Downloads\\Chance The Rapper - Coloring Book";
	String torrent1 = "http://itorrents.org/torrent/6484DBC9BE6A7A0BFB5A30692DF25EA6BBCF44AB.torrent?title=[limetorrents.cc]Java.4.Selenium.WebDriver.Come.Learn.How.To.Program.For.Automation.Testing..Part.2.";
	String torrent2 ="magnet:?xt=urn:btih:8582e6757e80d96b34689025aaebfdb691927e96&dn=Office+Christmas+Party+2016+HDCAM+x264+UnKnOwN&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fglotorrents.pw%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Fzer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969%2Fannounce" ;
	File downloadFileFolder = new File(torrentDownloadFolder);
	File downloadFileFolder2 = new File(torrentDownloadFolder2);
	
	//@BeforeClass
	public void preCondition(){
		TestLogger.info("---------------------------------------------TORRENT CILENT---------------------------------------------");
		TestLogger.info("Setup eviroment for execute test script");
		if(DownloadCCBrowser("dev.coccoc.com")){
			UninstallAndClearAllData("");
			cleanResouces("");
		}
		
		else
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
	}
	
	@AfterMethod
	public void cleanUpDownload(){
		TestLogger.info("--------------------------------Cleanup environment after executing other testcases---------------------------------------------------------------");
		//close Coc Coc browser if exist
		if(waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", 2)){
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type(Key.F4, Key.ALT);
			sleep(1);
		}
		
		//cleanResouces("");
		DeleteFileAndFolderInSpecificPath(downloadFileFolder);
		DeleteFileAndFolderInSpecificPath(downloadFileFolder2);
	}
	
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_01</br>
	 * <b> CaseTitle: </b>Coccoc as Torrent Client</br>
	 * <b> Steps: </b></br>
	 * 1. Installer browser
	 * 2. Select "Đặt Cốc Cốc làm ứng dụng torrent mặc định" in installer dialog
	 * 3. Finish the installation
	 * 4. Open Settings > Torrent Settings
	 * 5. Open a .torrent file in local machine
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 4. Text shows "The default torrent client is currently Cốc Cốc"
	 * 5. The torrent file open in Coc coc browser and the first page displayed is Downloader page
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_01: Coccoc as Torrent Client");
		UninstallAndClearAllData("");
		InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		//goto setting page
		openLink("coccoc://settings/#coccoc-settings-general");
	
		waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 12);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Checkbox_CheckedOptionCoccocIsYourDefaultTorrentClient.png", 5))
			setTestcaseStatus("PASSED", "On setting page, the default option is checked");
		else
			setTestcaseStatus("FAILED", "On setting page, the default option isnot checked");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		
		openFile(userprofile + "\\Downloads\\testFiles\\testDownload.torrent");
		
		if(waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 20))
			setTestcaseStatus("PASSED", "#5 :The default torrent is coc coc");
		else
			setTestcaseStatus("FAILED", "#5 :The default torrent is not coc coc");
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.3_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_02</br>
	 * <b> CaseTitle: </b>Coccoc is not set as Torrent Client</br>
	 * <b> Steps: </b></br>
	 * 1. Installer browser
	 * 2. Do not select "Đặt Cốc Cốc làm ứng dụng torrent mặc định" in installer dialog
	 * 3. Finish the installation
	 * 4. Open Settings > Torrent Settings
	 * 5. Open a .torrent file in local machine
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 4. Text shows " "
	 * 5.  The torrent file will not be openned in Coccoc browser, or it will open in default torrent client if any in local machine
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	
	@Test
	public void Browser_SNIFF_TorrentClient_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_02: Coccoc is not set as Torrent Client");
		
		UninstallAndClearAllData("");
		
		//set default torrent client is utorrent
		
		 App.open(userprofile +"\\AppData\\Roaming\\uTorrent\\uTorrent.exe");
	     clickOn("pictures\\AppTorrent_Menu_Button_Options.png");
		 clickOn("pictures\\AppTorrent_Menu_Button_Preference.png");
		 if (waitForObjectPresent("pictures\\AppTorrent_Settings_Button_MakeItDefault.png", 2))
		 {
		 clickOn("pictures\\AppTorrent_Settings_Button_MakeItDefault.png");
		 clickOn("pictures\\AppTorrent_Settings_Button_OK.png");
		 s.type(Key.F4,Key.ALT);
		 TestLogger.info("Set uTorrent is Default Client in PC ");
		 } 
		 else
		 {
			 TestLogger.info("Set uTorrent is Default Client in PC ");
		 }
		 
		 //1 Installer browser
		// 2. Do not select "Đặt Cốc Cốc làm ứng dụng torrent mặc định" in installer dialog
		 
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 2);

		openLink("coccoc://settings/#coccoc-settings-general");
		
		waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 12);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_SetCoccocAsDefaultTorrentClient.png", 5))
			setTestcaseStatus("PASSED", "On setting page, the default option is un-checked");
		else
			setTestcaseStatus("FAILED", "On setting page, the default option is not checked");
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.F4, Key.ALT);
		
		openFile(userprofile + "\\Downloads\\testFiles\\testDownload.torrent");
		
		if(!waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 3))
		{
			s.type(Key.F4, Key.ALT);
			sleep(2);
			s.type(Key.F4, Key.ALT);
			startCocCoc();
			openLink("coccoc://settings/#coccoc-settings-general");
			if(waitForObjectPresent("pictures\\Browser_Torrent_Button_SetCoccocAsDefaultTorrentClient.png", 5))
			clickOn("pictures\\Browser_Torrent_Button_SetCoccocAsDefaultTorrentClient.png");
			closeBrowser();
			
			setTestcaseStatus("PASSED", "#5 : The torrent file will not be openned in Coccoc browser, or it will open in default torrent client if any in local machine");
		}
		else
		{
			s.type(Key.F4, Key.ALT);
			sleep(2);
			s.type(Key.F4, Key.ALT);
			
			
			setTestcaseStatus("FAILED", "#5 : The default torrent STILL is coc coc ,The torrent file STILL be openned in Coccoc browser");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_03</br>
	 * <b> CaseTitle: </b>Default Torrent settings </br>
	 * <b> Steps: </b></br>
	 * 1. Installer browser
	 * 2. Open Settings (coccoc://settings)
	 * 3. Check for default torrent settings
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Settings for torrent in section: "Tuy chinh torrent" with default values:
	 *   - Max number of connections per client: 1000
	 *   - Max number of connections per item: 100
	 *   - Peers listening port: 3800
	 *   - Max active downloads: 5
	 *   - Max active seeding: 5
	 *   - Use UPnP and NAT-PMP port forwarding: uncheck
	 *   - Ngung seed: uncheck
	 *   
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_03(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_03: Default Torrent settings ");
		startCocCoc();
		//goto setting page
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type("coccoc://settings/#coccoc-settings-downloads");
		sleep(1);
		s.type(Key.ENTER);

		if(waitForObjectPresent("pictures\\Browser_Torrent_Menu_DefaultSetting.png", 5))
			setTestcaseStatus("PASSED", "On setting page, the default options are correct choices");
		else
			setTestcaseStatus("FAILED", "On setting page, the default option are NOT correct choices");
	}

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_04</br>
	 * <b> CaseTitle: </b>Download from a torrent link</br>
	 * <b> Steps: </b></br>
	 * 1. Open some torrent link in browser, for example: http://www.cpasbien.pw/dl-torrent/films/policiers-thrillers/paradise-lost-french-dvdrip-2014.html
       2. Click on link to download
       3. Or open coccoc://downloads, add an URL: http://phimtorrent.com/wp-content/uploads/2015/03/phimtorrent.com-The-Cat-Returns-2014-HD-720p-torrent-3.5GB.torrent
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 4. In both case, the download should start 
	 * @author huy.vu
	 * @Update HANV
	 *
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_04: Download from a torrent link");
		UninstallAndClearAllData("");
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		boolean isTorrentDownload = true;
		String message = "";
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		sleep(5);
		s.type(Key.ENTER);
		sleep(5);
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download torrent from URL");
		}
		else{
			message = ("Coc Coc cannot dowwnload torrent form URL");
			isTorrentDownload = false;
		}
		//close coc coc and clean download folder.
		cleanUpenvironment(downloadFileFolder);
		
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_AddLink.png", 8);
		clickOn("pictures\\Browser_Torrent_Button_AddLink.png");
		sleep(1);
		s.type(torrentLink);
		sleep(5);
		clickOn("pictures\\Browser_Torrent_Button_AddLinkOK.png");
		sleep(5);
		s.type("j", Key.CTRL);
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download torrent by add link");
		}
		else{
			message = ("\nCoc Coc cannot dowwnload torrent by add link");
			isTorrentDownload = false;
		}
		
		if(!isTorrentDownload){
			setTestcaseStatus("FAILED", message);
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_05</br>
	 * <b> CaseTitle: </b>Download from a torrent file</br>
	 * <b> Steps: </b></br>
	 * 1. Open coccoc://downloads
	 * 2. Click Add torrent button
	 * 3. Select some torrent files from local machine
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * The download should start
	 * @author huy.vu
	 * @Update HANV
	 * @date 2 Mar-2017
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_05(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_05: Download from a torrent file ");
		// Open CocCoc browser 
		 startCocCoc();
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		 openLink("coccoc://downloads");
		 waitForObjectPresent("pictures\\Browser_Torrent_Button_AddTorrent.png", 4);
		 clickOn("pictures\\Browser_Torrent_Button_AddTorrent.png");
		 waitForObjectPresent("pictures\\OSApp_Window_Folder_Download.png", 3);
		 clickOn("pictures\\OSApp_Window_Folder_Download.png");
		 s.type(Key.TAB);
		 s.type(Key.TAB);
		 s.type("testFiles\\testDownload.torrent");
		 sleep (4);
		 s.type(Key.ENTER);
		 
		 if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
			{
				clearDownloads();
				setTestcaseStatus("PASSED", "The download should start");
			}
			else
			{
				clearDownloads();
				setTestcaseStatus("PASSED", "The download DID NOT start");
			}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_06</br>
	 * <b> CaseTitle: </b>Pause/Resume a torrent download</br>
	 * <b> Steps: </b></br>
	 * 1. Download some files using torrent client
	 * 2. Open coccoc://downloads page, click on Pause button next to download item
	 * 3. Then click on Resume button 
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 2. The download should be paused
	 * 3. The download should be resumed from where it stopped
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_06(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_06: Pause/Resume a torrent download");
		
		//download Torrent:
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(magnetLink);
		sleep(5);
		s.type(Key.ENTER);
		sleep(5);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		//open download page:
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 30)){
			clickOn("pictures\\Browser_Torrent_Button_PauseDownload.png");
			sleep(1);
			if(waitForObjectPresent("pictures\\Browser_DownloadPage_Button_BackToDownloadStatus.png", 5) & !(isFileDownloading(torrentDownloadFolder2)))
				setTestcaseStatus("PASSED", "Coc Coc can pause the download stream");
			else
				setTestcaseStatus("FAILED", "Coc Coc cannot pause the download stream");
			
			clickOn("pictures\\Browser_DownloadPage_Button_BackToDownloadStatus.png");
			
			if(isFileDownloading(torrentDownloadFolder2))
			{
				clearDownloads();
				setTestcaseStatus("PASSED", "Coc Coc can resum the download stream");
			}
			else
			{
				clearDownloads();
				setTestcaseStatus("FAILED", "Coc Coc cannot resum the download stream");
			}
		}	
		else
			setTestcaseStatus("SKIP", "CocCoc cannot download Torrent, pls check!");
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_07</br>
	 * <b> CaseTitle: </b>Change different download limit</br>
	 * <b> Steps: </b></br>
	 * 1. Download some files using torrent client
	 * 2. Open coccoc://downloads page, hover on arrow icon next to download item and select different download limit e.g. 55 kB/s or fill a custom limit
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * The download limit of current download will not reach more than 55 kB/s
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_07(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_07: Change different download limit");
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(torrentLink);
		sleep(5);
		s.type(Key.ENTER);
		sleep(5);
		
		//open download page:
		s.type("j", Key.CTRL);
		
		setBandwidthDownloadFile("55kbs");
		
		sleep(4);
		
		if(checkbandwidth(55))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The download limit of current download less than 55 kB/s");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The download limit of current download reach more than 55 kB/s");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_08</br>
	 * <b> CaseTitle: </b>Change different upload limit</br>
	 * <b> Steps: </b></br>
	 * 1. Open Fiddler
	 * 2. Download some files using torrent client
	 * 3. Open coccoc://downloads page, hover on arrow icon next to download item and select different upload limit e.g. 55 kB/s or fill a custom limit
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * The download limit of current download will not reach more than 55 kB/s
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_08(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_08: Change different upload limit");
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		sleep(5);
		s.type(Key.ENTER);
		sleep(5);
		
		//open download page:
		s.type("j", Key.CTRL);
		
		setBandwidthUploadFileManual("90");
		sleep(4);
		
		if(checkbandwidth(90))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The download limit of current download less than 90 kB/s");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The download limit of current download reach more than 90 kB/s");
		}
	}

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.3_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_09</br>
	 * <b> CaseTitle: </b>Download from a magnet link</br>
	 * <b> Steps: </b></br>
	 * 1. Go to torrent page
	 * 2. There are 4 ways to download:
	 *   - Left click on the link "Get this torrent"
	 *   - Right click and open in New tab or New windows
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * The download should start
	 * @author huy.vu
	 * @Update HANV
	 * 
	 */
	//@Test
	public void Browser_SNIFF_TorrentClient_09(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_09: Download from a magnet link");
		
		String message = "";
		boolean isTorrentDownload = true;
		
		//2.1: Download by click on magnet link
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(siteDownloadTorrent);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_limetor_magnetLink.png", 20);
		clickOn("pictures\\Website_limetor_magnetLink.png");
		sleep(3);
		clickOn("pictures\\Browser_Tab_Text_TorrentTheLastHeirs.png");
		sleep(2);
		
		clickOn("pictures\\Website_limetor_magnetLink.png");
		sleep(3);
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download by click on magnet link");
		}
		else{
			message = ("\nCoc Coc cannot dowwnload torrent by click on magnet link");
			isTorrentDownload = false;
		}
		
		//2.2 Download by open magnet link
		//close coc coc and clean download folder.
		cleanUpenvironment(downloadFileFolder);
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(siteDownloadTorrent);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Website_limetor_magnetLink.png", 20);
		rightClick("pictures\\Website_limetor_magnetLink.png");
		s.type(Key.DOWN);
		s.type(Key.ENTER);
		sleep(2);
		
		clickOn("pictures\\Browser_Tab_Text_TorrentTheLastHeirs.png");
		sleep(2);
		//re-click for make sure that Torrent is download instead of opens ads link
		rightClick("pictures\\Website_limetor_magnetLink.png");
		s.type(Key.DOWN);
		s.type(Key.ENTER);
		sleep(2);
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download torrent by open magnet link");
		}
		else{
			message = ("\nCoc Coc cannot dowwnload torrent by open magnet link");
			isTorrentDownload = false;
		}
		
		//2.3 Download by open link on new tab
		//close coc coc and clean download folder.
		cleanUpenvironment(downloadFileFolder);
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(magnetTorrent);
		s.type(Key.ENTER);
		sleep(10);
		
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download torrent by access magnet link form OminiBox");
		}
		else{
			message = ("\nCoc Coc cannot download torrent by access magnet link form OminiBox");
			isTorrentDownload = false;
		}
		
		//2.4 Download by open link on new tab
				//close coc coc and clean download folder.
		cleanUpenvironment(downloadFileFolder);
		
		startCocCoc();
		s.type(Key.ESC);
		s.type("j", Key.CTRL);
		sleep(1);
		
		waitForObjectPresent("pictures\\Browser_Torrent_Button_AddLink.png", 50);
		clickOn("pictures\\Browser_Torrent_Button_AddLink.png");
		
		s.type(magnetTorrent);
		s.type(Key.ENTER);
		sleep(10);
		
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can download torrent by access magnet link form Download page");
		}
		else{
			message = ("\nCoc Coc cannot download torrent by access magnet link form Download page");
			isTorrentDownload = false;
		}
		
		if(!isTorrentDownload)
			setTestcaseStatus("FAILED",  message);
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_13</br>
	 * <b> CaseTitle: </b>Change Max active downloads</br>
	 * <b> Steps: </b></br>
	 * 1. Open Settings > Torrent Settings > Show settings
	 * 2. Change Max active downloads value
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Number of active downloads should not exceed set value
	 * @author huy.vu
	 * @date 27 Jun -2016
	 */
	//@Test
	public void Browser_SNIFF_TorrentClient_13(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_13: Change Max active downloads");
		startCocCoc();
		s.type(Key.ESC);
		//set limit active download:
		s.type("t", Key.CTRL);
		s.type("coccoc://settings/#coccoc-settings-downloads");
		waitForObjectPresent("pictures\\Browser_Torrent_TextArea_MaxActiveDownloadSetting.png", 30);
		doubleClick("pictures\\Browser_Torrent_TextArea_MaxActiveDownloadSetting.png");
		s.type("1");
		sleep(1);
		
		//download torrent:
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(magnetLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//download link 2
		s.type("t", Key.CTRL);
		s.type(magnetTorrent2);
		sleep(5);
		s.type(Key.ENTER);
		sleep(15);
		
		//open download page:
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Text_OvermaxNoOfSeedingMsg.png", 60))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Number of active downloads not exceed set value");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "Number of active downloads exceed set value");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_14</br>
	 * <b> CaseTitle: </b>Change Max active downloads</br>
	 * <b> Steps: </b></br>
	 * 1. Open Settings > Torrent Settings > Show settings
	 * 2. Change Max active downloads value
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Number of active downloads should not exceed set value
	 * @author HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_14(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_14: Change Max active seeding");
		startCocCoc();
		s.type(Key.ESC);
		
		//download torrent:
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//download link 2
		s.type("t", Key.CTRL);
		s.type(magnetTorrent2);
		s.type(Key.ENTER);
		sleep(15);
		
		//set limit active download:
		s.type("t", KeyModifier.CTRL);
		s.type("coccoc://settings/#coccoc-settings-downloads");
		doubleClick("pictures\\Browser_Torrent_TextArea_MinSeedingNoSetting.png");
		
		s.type("1");
		sleep(1);
		
		//open download page:
		s.type("j", Key.CTRL);
		
		if(!waitForObjectPresent("pictures\\Browser_Torrent_Text_OvermaxNoOfSeedingMsg.png", 5))
		{
			clearDownloads();
			clearDownloads();
			setTestcaseStatus("PASSED", "Number of active downloads not exceed set value");
		}
		else
		{
			clearDownloads();
			clearDownloads();
			setTestcaseStatus("FAILED", "Number of active downloads exceed set value");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.3_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_16</br>
	 * <b> CaseTitle: </b>Set to not seeding for all torrent downloads</br>
	 * <b> Steps: </b></br>
	 *1. Open Settings > Torrent Settings > Show settings
      2. Select "Stop seeding"
      3. Start some torrent downloads
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * All torrent downloads will not seed
	 * @author HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_16(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_16: Set to not seeding for all torrent downloads");
		startCocCoc();
		s.type(Key.ESC);
		//set limit active download:
		s.type("t", KeyModifier.CTRL);
		s.type("coccoc://settings/#coccoc-settings-downloads");
		s.type(Key.ENTER);
		sleep(3);
		clickOn("pictures\\Browser_Torrent_CheckBox_NOSeeding.png");
		
		//download torrent:
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(magnetLink);
		s.type(Key.ENTER);
		sleep(5);
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360);
		//open download page:
		s.type("j", Key.CTRL);
		clickOn("pictures\\Browser_DownloadPage_Menu_Seeding.png");
		
		if(!waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 5))
		{
		
			clearDownloads();
			s.type("t", Key.CTRL);
			s.type("coccoc://settings/#coccoc-settings-downloads");
			s.type(Key.ENTER);
			sleep(3);
			clickOn("pictures\\Browser_Torrent_CheckBox_NOSeeding.png");
			setTestcaseStatus("PASSED", "All torrent downloads will not seed ");
		}
		else
		{
			clearDownloads();
			s.type("t", Key.CTRL);
			s.type("coccoc://settings/#coccoc-settings-downloads");
			s.type(Key.ENTER);
			sleep(3);
			clickOn("pictures\\Browser_Torrent_CheckBox_NOSeeding.png");
			setTestcaseStatus("FAILED", "All torrent downloads STILL seed");
		}
	}
	
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_17</br>
	 * <b> CaseTitle: </b>Stop seeding a torrent download</br>
	 * <b> Steps: </b></br>
	 * 1. Download some files using torrent client
	 * 2. Open coccoc://downloads page, wait for the download finished, the seeding will start automatically
	 * 3. Click on Stop seeding under the selected item
	 * 4. Or hover on arrow icon and select "Do not seed"
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * The download should stop seeding/uploading
	 * @author HANV
	 * 
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_17(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_17: Stop seeding a torrent download");
		
		startCocCoc();
		s.type(Key.ESC);
		
		//download torrent:
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(magnetLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open download page
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 25);
		//wait for download done
		waitForObjectPresent("pictures\\Browser_Torrent_Button_StopSeeding.png", 360);
		clickOn("pictures\\Browser_Torrent_Button_StopSeeding.png");
		clickOn("pictures\\Browser_DownloadPage_Menu_Seeding.png");
		if(waitForObjectPresent("pictures\\Browser_SeedingPage_Text_NoSeeding.png", 5))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The download stop seeding/uploading");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The download do not stop seeding/uploading");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_18</br>
	 * <b> CaseTitle: </b>SCopy magnet link</br>
	 * <b> Steps: </b></br>
	 * 1. In download page, hover on arrow icon of some torrent download
	 * 2. Select "Copy magnet link"
	 * 3. Paste to some text application, text area
	 * 4. Download this copied magnet link
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Make sure the copied magnet link is a valid link, the download should work normally
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_18(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_18: Copy magnet link");
		String magnetLinkDownloadPage;
		
		startCocCoc();
		s.type(Key.ESC);
		
		//download torrent:
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(magnetLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open download page
		s.type("j", Key.CTRL);
		sleep(5);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 5);
		
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		waitForObjectPresent("pictures\\Browser_Torrent_Button_CopyDownloadLink.png", 10);
		
		clickOn("pictures\\Browser_Torrent_Button_CopyDownloadLink.png");
		
		magnetLinkDownloadPage = getClipboardValue();
		
		if(magnetLinkDownloadPage.equals(magnetLink))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The copied magnet link is a valid link");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The copied magnet link is a invalid link");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Savior_19</br>
	 * <b> CaseTitle: </b>Cannot download same torrent link</br>
	 * <b> Steps: </b></br>
	 * 1. Start download a torrent file (from an internet link or local torrent file)
	 * 2. Repeat step 1 with same item
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * There might be some information message
	 * @author huy.vu
	 * @update : HANV
	 */
	
	@Test
	public void Browser_SNIFF_TorrentClient_19(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_19: Cannot download same torrent link");
		
		startCocCoc();
		s.type(Key.ESC);
		
		//download torrent:
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(magnetTorrent2);
		s.type(Key.ENTER);
		sleep(5);
		
		//download torrent again
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(magnetTorrent2);
		s.type(Key.ENTER);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Text_DuplicateDownloadLinkWarningMsg.png", 10))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The wanrning message appears when adding exist torrent");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The wanrning message does not display when adding exist torrent");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_20</br>
	 * <b> CaseTitle: </b>Torrent download tree view</br>
	 * <b> Steps: </b></br>
	 * 1. Download some torrent file which contains many files inside
	 * 2. Click on yellow arrow symbol in front of download item
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * All files/folders display, each contains:
	 *   - Check box
	 *   - Filename
	 *   - Filesize
	 *   - Complete percentage
	 * @author huy.vu
	 * @update : HANV
	 */
	
	@Test
	public void Browser_SNIFF_TorrentClient_20(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_20: Torrent download tree view");
		
		startCocCoc();
		s.type(Key.ESC);
		
		//download torrent:  pictures\\Browser_Torrent_Button_ExpandTorrentList.png
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open Download page:
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_ExpandTorrentList.png", 20))
			clickOn("pictures\\Browser_Torrent_Button_ExpandTorrentList.png");
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_DropDown_TorrentFolderList.png", 10))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The wanrning message appears when adding exist torrent");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The wanrning message does not display when adding exist torrent");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_20</br>
	 * <b> CaseTitle: </b>Cancel download of some file in torrent package</br>
	 * <b> Steps: </b></br>
	 * 1. Download some torrent file which contains many files inside
	 * 2. Click on yellow arrow symbol in front of download item
	 * 3. Uncheck some files
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * Unchecked files will not be downloaded.
	 * 
	 * @author huy.vu
	 * @update : HANV
	 */
	
	//@Test
	public void Browser_SNIFF_TorrentClient_21(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_21: Cancel download of some file in torrent package");
		
		File mediaFile = new File("");
		String hashValuePoint1 = "1";
		String hashValuePoint2 = "2";
		
		startCocCoc();
		s.type(Key.ESC);
		//download torrent
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open Download page:
		s.type("j", Key.CTRL);
		//expand torrent tree
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_ExpandTorrentList.png", 20)){
			clickOn("pictures\\Browser_Torrent_Button_ExpandTorrentList.png");
			sleep(0.5);
		}
		clickOn("pictures\\Browser_Torrent_Text_DownloadedTorrrentFileName.png");
		
		hashValuePoint1 = hashFile(mediaFile);
		
		sleep(30);
		
		hashValuePoint2 = hashFile(mediaFile);
		
		if(hashValuePoint2 ==  hashValuePoint1)
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "This file stop download after uncheck to download");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "This file do not stop download after uncheck to download");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_22</br>
	 * <b> CaseTitle: </bCheck cancel/continue when downloading a torrent file</br>
	 * <b> Steps: </b></br>
	 * 1. Download a torrent file which contains many files inside
	 * 2. Click on yellow arrow symbol in front of download item
	 * 3. Un-check some files
	 * 4. Re-check these files, observe the Finished folder and Downloading folder
	 * 5. Unchecked all files, observe the Downloading 
	 * 6. Rechecked all files, observe the Finished folder and Downloading folder
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 3. Unchecked files will not be downloaded. 
	 * 4. The torrent file change from finish to downloading
	 * 5. The torrent files change from downloading to finished
	 * 6. The torrent files change from finish to downloading
	 * 
	 * @author huy.vu
	 * @Update : HANV
	 */
	//@Test
	public void Browser_SNIFF_TorrentClient_22(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_22: Check cancel/continue when downloading a torrent file");
		
		File mediaFile = new File(torrentDownloadFolder2);
		String hashValuePoint1 = "1";
		String hashValuePoint2 = "2";
		String hashValuePoint3 = "3";
		
		startCocCoc();
		s.type(Key.ESC);
		//download torrent
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open Download page:
		s.type("j", Key.CTRL);
		sleep(1);
		
		//expand torrent tree
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_ExpandTorrentList.png", 20)){
			clickOn("pictures\\Browser_Torrent_Button_ExpandTorrentList.png");
			sleep(0.5);
		}
		sleep(1);
		clickOn("pictures\\Browser_Torrent_Text_DownloadedTorrrentFileName.png");
		hashValuePoint1 = hashFile(mediaFile);
		sleep(1);
		hashValuePoint2 = hashFile(mediaFile);
		
		TestLogger.info("Resume download!");
		//resume download
		//clickOn("pictures\\Browser_Torrent_Text_DownloadedTorrrentFileName.png");
		sleep(1);
		hashValuePoint3 = hashFile(mediaFile);
		//pictures\\Browser_Torrent_Text_DownloadedTorrrentFileNameWithoutExtension.png
		if((hashValuePoint1.equals(hashValuePoint2))& (!hashValuePoint1.equals(hashValuePoint3)))
			setTestcaseStatus("PASSED", "Coc Coc can stop and resume a file");
		else
			setTestcaseStatus("FAILED", "Coc Coc cannot stop and resume a file");
		
		//stop all file
		clickOn("pictures\\Browser_Torrent_Text_DownloadedTorrrentFileNameWithoutExtension.png");
		
		if(!waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 30))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can stop all files");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "Coc Coc cannot stop all files");
		}
		
		clickOn("pictures\\Browser_Torrent_Text_DownloadedTorrrentFileNameWithoutExtension.png");
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 10))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Coc Coc can resume all files");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "Coc Coc cannot resume all files");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_23</br>
	 * <b> CaseTitle: </b>Context menu is accordance with different torrent downloads</br>
	 * <b> Steps: </b></br>
	 * 1. Download some files and hover on arrow icon, check the context menu when download is:
	 *   - torrent link, magnet link
	 *   - torrent file
	 *   - others
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  The context menu according to download type:
	 *   1. Torrent link, magnet link:
	 *    - Open source page,
	 *    - check box Open when done (when download is in progress)
	 *    - Download limit (with list of options),
	 *    - Upload limit (with list of options),
	 *    - Copy magnet link
	 *    - Remove file from disk (when download finished)
	 *    - Do not seed (when download finished)
	 *   2. Torrent file:
	 *    - check box Open when done (when download is in progress)
	 *    - Download limit (with list of options),
	 *    - Upload limit (with list of options),
	 *    - Remove file from disk (when download finished)
	 *    - Do not seed (when download finished)
	 *   3. Others:
	 *    - Open source page
	 *    - Remove from disk
	 *    - check box Open when done (when download is in progress)
	 * 
	 * @author huy.vu
	 * @update HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_23(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_23: Context menu is accordance with different torrent downloads");
		
		startCocCoc();
		s.type(Key.ESC);
		//download torrent file
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type("magnet:?xt=urn:btih:38AF600E1D8BCF5BFA059134D1EA4D1655300E19&dn=%5BUdemy%5D+The+Complete+Android+N+Developer+Course+%282017%29&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Feddie4.nl%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fcoppersurfer.tk%3A6969%2Fannounce");
		//s.type("dp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.ilibr.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fshadowshq.yi.org%3A6969&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fcoppersurfer.tk%3A6969%2Fannounce");
		//s.type("magnet:?xt=urn:btih:EB57458741537AFF7AF5DE80846E93474BD1D166&dn=Selenium+WebDriver+Recipes+in+CSharp+Second+Edition&tr=udp%3A%2F%2F11.rarbg.com%3A80%2Fannounce&tr=udp%3A%2F%2F11.rarbg.me%2Fannounce&tr=udp%3A%2F%2F9.rarbg.com%3A2710%2Fannounce&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=udp%3A%2F%2Fglotorrents.pw%3A6969&tr=udp%3A%2F%2F11.rarbg.com%2Fannounce&tr=udp%3A%2F%2F9.rarbg.to%3A2710%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Fglotorrents.pw%3A6969%2Fannounce&tr=http%3A%2F%2Ftracker.aletorrenty.pl%3A2710%2Fannounce&tr=http%3A%2F%2Ftracker.pubt.net%3A2710%2Fannounce&tr=udp%3A%2F%2Ftracker.xelion.fr%3A6969%2Fannounce&tr=udp%3A%2F%2F9.rarbg.me%3A2710%2Fannounce&tr=udp%3A%2F%2Fopen.demonii.com%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fcoppersurfer.tk%3A6969%2Fannounce");
		s.type(Key.ENTER);
		sleep(5);
		
		//open Download page:
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_AddLink.png", 10);
		clickOn("pictures\\Browser_Downloader_Button_DropDownList.png");
		hoverImage("pictures\\Browser_Downloader_Button_DropDownList.png");
		
		if(waitForObjectPresent("pictures\\Browser_DownloadPage_Menu_ContextMenuOfADownload.png", 10))
		{
			clearDownloads();
			
			setTestcaseStatus("PASSED", "The context menu is accordance with torrent downloads");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The context menu is accordance with different torrent downloads");
		}

	
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_24</br>
	 * <b> CaseTitle: </b>Seeding state</br>
	 * <b> Steps: </b></br>
	 *  1. Download some torrent, wait to finish
	 *  2. When seeding starts, look the change of icon in the top right corner
	 *  3. Wait to complete the seeding
	 * <b> ExpectedOutput: </b></br>
	 *   The icon will change to other state: the arrow up
	 * 
	 * @author huy.vu
	 * @update HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_24(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_24: Seeding status");
		
		startCocCoc();
		s.type(Key.ESC);
		//download torrent file
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		sleep(5);
		
		//open download page
		s.type("j", Key.CTRL);
		waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 30);
		
		//stop download
		clickOn("pictures\\Browser_Torrent_Button_ExpandTorrentList.png");
		sleep(1);
	
		if(waitForObjectPresent("pictures\\Browser_Torrent_Icon_SeedingOption.png", 10))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "The context menu is accordance with torrent downloads");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "The context menu is accordance with different torrent downloads");
		}
	}

	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_25</br>
	 * <b> CaseTitle: </b>Newtab should be closed when a .torrent file is downloaded</br>
	 * <b> Steps: </b></br>
	 *  1. Open any site with torrent link
	 *  2. Right click on torrent link and select "Save link as"
	 *  3. Open download page, right click on link in step 2
	 *  4. Select "Open in newtab"
	 * <b> ExpectedOutput: </b></br>
	 *   Newtab should be closed automatically as soon as torrent file is started dowloading 
	 * 
	 * @author huy.vu
	 * @update : HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_25(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_25: Newtab should be closed when a .torrent file is downloaded");
		
		startCocCoc();
		sleep(1);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type(Key.ESC);
		//close new tab
		if(waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png", 2)){
			clickOn("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png");
			s.type(Key.F4,Key.CTRL);
		}
		//save torrent as file
		s.type("t", Key.CTRL);
		s.type("magnet:?xt=urn:btih:38AF600E1D8BCF5BFA059134D1EA4D1655300E19&dn=%5BUdemy%5D+The+Complete+Android+N+Developer+Course+%282017%29&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Feddie4.nl%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fcoppersurfer.tk%3A6969%2Fannounce");
		s.type(Key.ENTER);
		
		//openLink("magnet:?xt=urn:btih:38AF600E1D8BCF5BFA059134D1EA4D1655300E19&dn=%5BUdemy%5D+The+Complete+Android+N+Developer+Course+%282017%29&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.opentrackr.org%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Feddie4.nl%3A6969%2Fannounce&tr=udp%3A%2F%2Ftracker.zer0day.to%3A1337%2Fannounce&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969%2Fannounce&tr=udp%3A%2F%2Fcoppersurfer.tk%3A6969%2Fannounce");
	
		//open download page
		s.type("j", Key.CTRL);
		waitforObjectNotexist("pictures\\Browser_Torrent_Button_PauseDownload.png", 10);

		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 10))
		{
			clearDownloads();
			setTestcaseStatus("PASSED", "Newtab be closed automatically as soon as torrent file is started dowloading ");
		}
		else
		{
			clearDownloads();
			setTestcaseStatus("FAILED", "Newtab not close automatically as soon as torrent file is started dowloading ");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_27</br>
	 * <b> CaseTitle: </b>Check downloading torrent if "Enable torrent client" is OFF</br>
	 * <b> Steps: </b></br>
	 *  1. Open coccoc://settings/
	 *  2. Uncheck "Enable torrent client" in Torrent Setting
	 *  3. Open a link to download a torrent file (Ex: http://phimtorrent.com/phim-bo/izombie-2015-season-2-xac-song-an-nao.html)
	 *  4. Click on torrent link: [phimtorrent.com] iZombie 2015 Season 2 (torrent) – E01
	 * <b> ExpectedOutput: </b></br>
	 *   Torrent link is saved on the disk (format of downloaded file is .torrent)
	 * 
	 * @author huy.vu
	 * @update HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_27(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_27: Check downloading torrent if Enable torrent client is OFF");
		startCocCoc();
		s.type(Key.ESC);
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type("coccoc://settings/#coccoc-settings-general");
		sleep(1);
		s.type(Key.ENTER);
		waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 120);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png", 1))
			clickOn("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png");
		
		s.type(Key.F4, Key.ALT);
		startCocCoc();
		//save torrent as file
		
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		s.type("t", KeyModifier.CTRL);
		sleep(1);
		s.type(torrentLink);
		s.type(Key.ENTER);
		if(waitForObjectPresent("pictures\\Browser_DownloadPage_Button_Save.png", 2))
			clickOn("pictures\\Browser_DownloadPage_Button_Save.png");
		
		s.type("j", Key.CTRL);
		
		if(waitForObjectPresent("pictures\\Browser_Torrent_Text_TorrentFileExtension.png", 5))
		{
			clearDownloads();
			openLink("coccoc://settings/#coccoc-settings-general");
			waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 10);
			
			if(waitForObjectPresent("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png", 1))
				clickOn("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png");
			setTestcaseStatus("PASSED", "Torrent link is saved on the disk (format of downloaded file is .torrent)");
		}
		else
		{
			clearDownloads();
			openLink("coccoc://settings/#coccoc-settings-general");
			waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 10);
			
			if(waitForObjectPresent("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png", 1))
				clickOn("pictures\\Browser_Torrent_Checkbox_TorrentSettingTurnedOn.png");
			setTestcaseStatus("FAILED", "Torrent link is not saved on the disk (format of downloaded file is .torrent) ");
		}
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_28</br>
	 * <b> CaseTitle: </b>Check count of download/seeding/Torrent are correctly</br>
	 * <b> Steps: </b></br>
	 *  1. Download some torrent.
	 *  2. wait for some downloads finish
	 *  3. Observe on count of Seeding/downloading/Torrent
	 *  
	 * <b> ExpectedOutput: </b></br>
	 *  4. The count correctly 
	 * 
	 * @author huy.vu
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_28(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_28: Check count of download/seeding/Torrent are correctly");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", KeyModifier.CTRL);
		s.type(magnetLink);
		s.type(Key.ENTER);
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", KeyModifier.CTRL);
		s.type(torrent1);
		s.type(Key.ENTER);
		sleep(1);
		openLink("coccoc://downloads/"); 
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360); 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("f" , Key.CTRL);
		
		s.type("toan bo (2)");
		
		if(waitForObjectPresent("pictures\\Browser_About_text_ConfirmVersionBrowser.png", 5))
		{
			
			setTestcaseStatus("PASSED", "The count of Total is correctly");
		}
		else
		{
			setTestcaseStatus("FAILED", "The count of Total is incorrectly");
		}
		
		
		
		openLink("coccoc://downloads/"); 
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("f" , Key.CTRL);
		s.type("Torrent (2)");
		
		if(waitForObjectPresent("pictures\\Browser_About_text_ConfirmVersionBrowser.png", 5))
		{
			clearDownloads();
			clearDownloads();
			setTestcaseStatus("PASSED", "The count of Torrent is correctly");
		}
		else
		{
			clearDownloads();
			clearDownloads();
			setTestcaseStatus("FAILED", "The count of Torrent is incorrectly");
		}
			
	}
	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_TorrentClient_29</br>
	 * <b> CaseTitle: </b>Downloading process restarts but does nothing if file name is deleted on downloader page without deleting in local computer</br>
	 * <b> Steps: </b></br>
	 *  1. Download a torrent file. Ex: magnet:?xt=urn:btih:6c9d70db207a9acb4b5b97b1f04156e30dcf712d&dn=CES+Cru+-+Catastrophic+Event+Specialists+%28Deluxe%29&tr=udp%3A%2F%2Ftracker.leechers-paradise.org%3A6969&tr=udp%3A%2F%2Fzer0day.ch%3A1337&tr=udp%3A%2F%2Ftracker.coppersurfer.tk%3A6969&tr=udp%3A%2F%2Fpublic.popcorn-tracker.org%3A6969
        2. wait for the download is finished
        3. On this item, click on "Remove from list"
        4. Check the local folder which contains downloaded torrent files
        5. Re-download above torrent file (link at step 1)
	 *  
	 * <b> ExpectedOutput: </b></br>
	    *1. Downloading starts
         3. File name is deleted from downloader page
         4. The downloaded files are save at this local folder
         5. Downlading process is restarted but it does nothing actually
	 *
	 * @Update HANV
	 */
	@Test
	public void Browser_SNIFF_TorrentClient_29(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_TorrentClient_29: Downloading process restarts but does nothing if file name is deleted on downloader page without deleting in local computer");
		startCocCoc();
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		TestLogger.info("1.Download a torrent file");
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("magnet:?xt=urn:btih:61c340d73014d17dc38989566e8729ad938557f8&dn=Selenium%202%20Testing%20Tools%20Beginner%e2%80%99s%20Guide&tr=http%3a%2f%2ftracker.nwps.ws%3a6969%2fannounce&tr=http%3a%2f%2ftracker.winglai.com%2fannounce&tr=http%3a%2f%2ffr33dom.h33t.com%3a3310%2fannounce&tr=http%3a%2f%2fexodus.desync.com%3a6969%2fannounce&tr=http%3a%2f%2ftorrent.gresille.org%2fannounce&tr=http%3a%2f%2ftracker.trackerfix.com%2fannounce&tr=udp%3a%2f%2ftracker.btzoo.eu%3a80%2fannounce&tr=http%3a%2f%2ftracker.windsormetalbattery.com%2fannounce&tr=udp%3a%2f%2f10.rarbg.me%3a80%2fannounce&tr=udp%3a%2f%2fipv4.tracker.harry.lu%3a80%2fannounce&tr=udp%3a%2f%2ftracker.ilibr.org%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.zond.org%3a80%2fannounce&tr=http%3a%2f%2ftorrent-tracker.ru%2fannounce.php&tr=http%3a%2f%2fbigfoot1942.sektori.org%3a6969%2fannounce&tr=http%3a%2f%2ftracker.best-torrents.net%3a6969%2fannounce&tr=http%3a%2f%2fannounce.torrentsmd.com%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.token.ro%3a80%2fannounce&tr=udp%3a%2f%2fopen.demonii.com%3a80&tr=udp%3a%2f%2ftracker.coppersurfer.tk%3a80&tr=http%3a%2f%2ftracker.thepiratebay.org%2fannounce&tr=udp%3a%2f%2f9.rarbg.com%3a2710%2fannounce&tr=udp%3a%2f%2fopen.demonii.com%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.ccc.de%3a80%2fannounce&tr=udp%3a%2f%2ftracker.istole.it%3a80%2fannounce&tr=udp%3a%2f%2ftracker.publicbt.com%3a80%2fannounce&tr=udp%3a%2f%2ftracker.openbittorrent.com%3a80%2fannounce&tr=udp%3a%2f%2ftracker.istole.it%3a80%2fannounce&tr=http%3a%2f%2ftracker.istole.it%2fannounce&tr=udp%3a%2f%2ftracker.publicbt.com%3a80%2fannounce&tr=http%3a%2f%2ftracker.publicbt.com%2fannounce&tr=udp%3a%2f%2ftracker.1337x.org%3a80%2fannounce&tr=http%3a%2f%2fexodus.desync.com%3a6969%2fannounce&tr=http%3a%2f%2ffr33dom.h33t.com%3a3310%2fannounce&tr=udp%3a%2f%2ffr33domtracker.h33t.com%3a3310%2fannounce");
		s.type(Key.ENTER);
		openLink("coccoc://downloads/");
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			setTestcaseStatus("PASSED", "Downloading starts");
		}
		else
		{
			setTestcaseStatus("FAILED", "Downloading DOES NOT start");
		}
		
		TestLogger.info("2. wait for the download is finished");
		waitForObjectPresent("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", 360) ;
		
		TestLogger.info("3. On this item, click on 'Remove from list");
		clickOn("pictures\\Browser_Downloader_Button_RemoveDownloadItem.png");
		TestLogger.info("EXPECT : File name is deleted from downloader page");
		if (waitForObjectPresent("pictures\\CocCoc_TorrentPage_Text_Selenium2TestingTools.png", 3))
		{
			setTestcaseStatus("FAILED", "File name is NOT deleted from downloader page ");
		}
		else
		{
			setTestcaseStatus("PASSED", " File name is deleted from downloader page");
		}
		
		TestLogger.info("4.Check the local folder which contains downloaded torrent files");
		
		TestLogger.info("4. The downloaded files are saved at this local folder");
        File f1939409403 = new File(userprofile +"\\Downloads\\"+"Selenium 2 Testing Tools Beginner’s Guide\\1939409403.jpg");
		
		
		
		if (f1939409403.exists() && f1939409403.isFile() ) 
		{
			TestLogger.info(f1939409403.getAbsolutePath());	
			setTestcaseStatus("PASSED", "The downloaded files are saved at this local folder");
		}
		else
		{
			TestLogger.info(f1939409403.getAbsolutePath());
			setTestcaseStatus("FAILED", "The downloaded files NOT are saved at this local folder");
		}
		
		TestLogger.info(" 5. Re-download above torrent file (link at step 1)");
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("magnet:?xt=urn:btih:61c340d73014d17dc38989566e8729ad938557f8&dn=Selenium%202%20Testing%20Tools%20Beginner%e2%80%99s%20Guide&tr=http%3a%2f%2ftracker.nwps.ws%3a6969%2fannounce&tr=http%3a%2f%2ftracker.winglai.com%2fannounce&tr=http%3a%2f%2ffr33dom.h33t.com%3a3310%2fannounce&tr=http%3a%2f%2fexodus.desync.com%3a6969%2fannounce&tr=http%3a%2f%2ftorrent.gresille.org%2fannounce&tr=http%3a%2f%2ftracker.trackerfix.com%2fannounce&tr=udp%3a%2f%2ftracker.btzoo.eu%3a80%2fannounce&tr=http%3a%2f%2ftracker.windsormetalbattery.com%2fannounce&tr=udp%3a%2f%2f10.rarbg.me%3a80%2fannounce&tr=udp%3a%2f%2fipv4.tracker.harry.lu%3a80%2fannounce&tr=udp%3a%2f%2ftracker.ilibr.org%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.zond.org%3a80%2fannounce&tr=http%3a%2f%2ftorrent-tracker.ru%2fannounce.php&tr=http%3a%2f%2fbigfoot1942.sektori.org%3a6969%2fannounce&tr=http%3a%2f%2ftracker.best-torrents.net%3a6969%2fannounce&tr=http%3a%2f%2fannounce.torrentsmd.com%3a6969%2fannounce&tr=udp%3a%2f%2ftracker.token.ro%3a80%2fannounce&tr=udp%3a%2f%2fopen.demonii.com%3a80&tr=udp%3a%2f%2ftracker.coppersurfer.tk%3a80&tr=http%3a%2f%2ftracker.thepiratebay.org%2fannounce&tr=udp%3a%2f%2f9.rarbg.com%3a2710%2fannounce&tr=udp%3a%2f%2fopen.demonii.com%3a1337%2fannounce&tr=udp%3a%2f%2ftracker.ccc.de%3a80%2fannounce&tr=udp%3a%2f%2ftracker.istole.it%3a80%2fannounce&tr=udp%3a%2f%2ftracker.publicbt.com%3a80%2fannounce&tr=udp%3a%2f%2ftracker.openbittorrent.com%3a80%2fannounce&tr=udp%3a%2f%2ftracker.istole.it%3a80%2fannounce&tr=http%3a%2f%2ftracker.istole.it%2fannounce&tr=udp%3a%2f%2ftracker.publicbt.com%3a80%2fannounce&tr=http%3a%2f%2ftracker.publicbt.com%2fannounce&tr=udp%3a%2f%2ftracker.1337x.org%3a80%2fannounce&tr=http%3a%2f%2fexodus.desync.com%3a6969%2fannounce&tr=http%3a%2f%2ffr33dom.h33t.com%3a3310%2fannounce&tr=udp%3a%2f%2ffr33domtracker.h33t.com%3a3310%2fannounce");
		sleep(5);
		s.type(Key.ENTER);
		sleep(5);
		openLink("coccoc://downloads/");
        TestLogger.info(" 5. Downlading process is restarted but it does nothing actually");
        if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 20))
		{
			setTestcaseStatus("FAILED", "Downlading process is restarted but it DID SOMETHING SPECIALLY");
		}
		else
		{
			setTestcaseStatus("PASSED", "Downlading process is restarted but it does nothing actually");
		}
	}
	
	
}
