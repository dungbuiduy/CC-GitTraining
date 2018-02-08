package browser_Testsuite_Windows;

import java.io.File;

import org.openqa.selenium.Keys;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_Install extends BrowserCommon {
	
	public Browser_Windows_Install() {
	}
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	private String userprofile = System.getenv("USERPROFILE");
	private String localUserdata = System.getenv("LOCALAPPDATA");
	private String userData = System.getenv("APPDATA");
	private File ggFolder = new File(localUserdata + "\\Google");
	private File ChromiumFolder = new File(localUserdata + "\\Chromium");
	
	private boolean testcaseFlag = true;
	
	//@BeforeClass
	public void Browser_SMOKE_Install_00(){
		TestLogger.info("==================================================================================================================================");
		TestLogger.info("|      EXECUTE TEST SCRIPT FOR TEST INSTALL COC COC BROWSER FOR VERSION: " + CocCocVersion[1] + "                           |");
		TestLogger.info("==================================================================================================================================");
		
		
		//Uninstall old browser if any and clean all data
				s.type("d", Key.WIN);
				UninstallAndClearAllData(CocCocVersion[1]);
				DeleteFileAndFolderInSpecificPath(ggFolder);
				DeleteFileAndFolderInSpecificPath(ChromiumFolder);
		//Download Coccoc Browser to local
		testcaseFlag = DownloadCCBrowser(CocCocVersion[0]);		
		//handle for Windows XP
		if(System.getProperty("os.name").contains("XP")){
			TestLogger.info("---------------------------------- HANDLE FOR WINDOWS XP-------------------------------");
			userprofile = "C:\\Documents and Settings\\tester\\My Documents";
			localUserdata = "C:\\Documents and Settings\\tester\\Local Settings\\Application Data";
			timeoutOffer = 5;
		}
		
		
		TestLogger.info("======================================================TEST CASE============================================================\n\n");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_01 </br>
	 * <b> CaseTitle: </b> Check pop-up of installer confirm during the installation</br>
	 * <b> Steps: </b>
	 * Run installer from download pop-up browser or installer file in local machine </br>
	 * <b> ExpectedOutput: </b>
	 * When the installation starts, a pop-up appears:</br>
	 *+ Logo CocCoc browser</br>
	 *+ Option "Đặt thành trình duyệt mặc định"</br>
	 *+ Option "Đặt Cốc Cốc là trình torrent mặc định"</br>
	 *+ Button "Cài Đặt"</br>
	 * @Update hanv
	 * @date 2-june, 2017
	 */
	@Test (groups = { "execute" })
	public void Browser_SMOKE_Install_01(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_01: Check pop-up of installer confirm during the installation");
		// uninstall CocCoc if any 
		UninstallAndClearAllData(CocCocVersion[1]);
		
		//Install latest Coccoc browser
		executeFile(userprofile + "\\Downloads\\coccoc_vi.exe");
		
		//Check install with download pop-up browser or installer file in local machine
		if(waitForObjectPresent("pictures\\Browser_InstallDialog_PopupSettingOption.png", 40)||(waitForObjectPresent("pictures\\specificEnviroment\\win10\\Browser_InstallDialog_PopupSettingOption.png", 40)))
			setTestcaseStatus("PASSED", "Pop-up shows correctly");
		else{	
			testcaseFlag = false;
			setTestcaseStatus("FAILED", "Pop-up shows incorrectly");
			}
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_02 </br>
	 * <b> CaseTitle: </b>Check first-time-run </br>
	 * <b> Steps: </b></br>
	 * 1. If user selected Cốc Cốc as default browser during the installation
	 * => After installed, previous default browser will be closed. Browser Cốc Cốc will start automatically and display:
	 * Welcome page + tabs which have been opended in previous browser
	 * 2. If user didn't select Cốc Cốc as default browser during the installation
	 * => After installed, Browser Cốc Cốc will start automatically and display 2 tabs: Welcome page + New tab</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-JUNE-2017
	 */
	 
	@Test (groups = { "execute" })
	public void Browser_SMOKE_Install_02(){	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_02 : Check first-time-run-  After installed, CocCoc browser will start and open Welcome page and  new tab");
		//Step 1: Insall Coccoc browser (continue testcase 01)
		if (testcaseFlag){	
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
			boolean welcomeTab = waitForObjectPresent("pictures\\Browser_BubbleDialog_Text_Welcomepage.png", 35);
			boolean newTab = waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png", 2);
			if (welcomeTab && newTab )
				setTestcaseStatus("PASSED", "CocCoc start automatically with welcome page and newtab");
			else
				setTestcaseStatus("FAILED", "CocCoc start not after finish install Coc Coc or welcome page/newtab not appears");
		}	
		else
			setTestcaseStatus("SKIP", "Failed at test case install, please check");
	}
	
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_03 </br>
	 * <b> CaseTitle: </b> Check if Widevine, Flash plugin exist by default right after installing browser</br>
	 * <b> Steps: </b></br>
	 * 1. Install Coc Coc Browser 
       2. Open browser right after installing
       3. Go to coccoc://components
       
       Expect :  
       3. Make sure that you can see these plugins exist right after installing browser: 
       Widevine Content Decryption Module, Adobe Flash Player 
	 *
	 * @Update HANV
	 * @date 5-JUNE-2017
	 */
	 
	@Test (groups = { "execute" })
	public void Browser_SMOKE_Install_03(){	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_03 : Check if Widevine, Flash plugin exist by default right after installing browser");
		//Step 1: Insall Coccoc browser (continue testcase 01 & 02)
		
		openLink("coccoc://components"); 
		s.type("f", Key.CTRL);
		s.type("Widevine Content Decryption Module");
		sleep (1);
		s.type(Key.ENTER);
		if (waitForObjectPresent("pictures\\Browser_SearchDownload_Text_One.png", 1))
		{
			setTestcaseStatus("PASSED", "right after installing browser, Widevine Content Decryption Module exists");
		}
		else
		{
			setTestcaseStatus("FAILED", "right after installing browser, Widevine Content Decryption Module DOES NOT exist");
		}
		
		
		openLink("coccoc://components"); 
		s.type("f", Key.CTRL);
		s.type("Adobe Flash Player ");
		sleep (1);
		s.type(Key.ENTER);
		if (waitForObjectPresent("pictures\\Browser_SearchDownload_Text_One.png", 1))
		{
			setTestcaseStatus("PASSED", "right after installing browser,Adobe Flash Player  exists");
		}
		else
		{
			setTestcaseStatus("FAILED", "right after installing browser, Adobe Flash Player DOES NOT exist");
		}
	
		
		
	}
	
	
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL</b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_04 </br>
	 * <b> CaseTitle: </b> Check folder browser after the installation</br>
	 * <b> Steps: </b>
	 * Check if there are all needed files in 2 folders:</br>
	 * a. C:\Users\<Account_login_Windows>\AppData\Local\CocCoc</br>
	 * b. C:\Users\<Account_login_Windows>\AppData\Roaming\CocCoc </br>
	 * <b> ExpectedOutput: </b>
	 * a. Must have 3 folders: Browser, CrashReports, Update</br>
	 * In folder Browser must have 2 subfolder: Application & UserData</br>
	 * => In folder Application must have:</br>
	 * + 1 folder named by browser version</br>
	 * + files: browser.exe, debug.log, VisualElementsManifest.xml</br>
	 * b. Must have 2 files: uid & uid2 (encoded file of uid value)</br>
	 * 
	 * @Update HANV
	 * @date 12-1-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_04(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_04: Check folder browser after the installation");
		
		//Skip test case if last test case failed
		if (testcaseFlag){
			//Check folder exists:
			if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1]))
				setTestcaseStatus("PASSED", "All files and folder are corectly");
			else{
				setTestcaseStatus("FAILED", "Some file or folders are wrong after install");
			}
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");	
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_05 </br>
	 * <b> CaseTitle: </b> CCheck if Coc Coc generate Chromium or Google folder after installing</br>
	 * <b> Pre-condition: Make sure your machine is clean machine: No installed Google Chrome or Chromium
	 * <b> Steps: </b>
	 * 1. Go to Appdata by typing %localappdata% into Run windows
	 * 2. Delete Chromium or Google folder if have
	 * 3. Install CocCoc Browser
	 * 4. Go to Appdata by typing %localappdata% into Run windows
	 * 5. Go to Registry by typing regedit into Run windows
	 * <b> ExpectedOutput: </b></br>
	 * Browser logo is correct with current installed browser</br>
	 * Logo displays in Taskbar, shortcut on desktop, and in folder: C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-june-2017
	 */
	// @Test(groups = { "execute" })
	public void Browser_SMOKE_Install_05() {	
		
	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_05: Check if Coc Coc generate Chromium or Google folder after installing");
		if(testcaseFlag){
			if (!(ggFolder.exists() & ChromiumFolder.exists()))
				setTestcaseStatus("PASSED", "The folder of Google and chromium not exist");
			else
				setTestcaseStatus("FAILED", "The folder of Google or chromium appears on user data foders");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");		
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_06</br>
	 * <b> CaseTitle: </b> Check browse logo after the installation</br>
	 * <b> Steps: </b>
	 * The browser is successfully installed</br>
	 * <b> ExpectedOutput: </b></br>
	 * Browser logo is correct with current installed browser</br>
	 * Logo displays in Taskbar, shortcut on desktop, and in folder: C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-june-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_06() {	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_06: Check browse logo after the installation");
		if(testcaseFlag){
			boolean isIconAppear = true;
			s.type("d", Key.WIN);
			s.type(Key.DOWN);
			sleep(2);
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			sleep(2);
			s.type(Key.DOWN);
			sleep(2);
			s.type(Key.UP);
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 5)){ 	
				s.type("r", Key.WIN);
				sleep(1);
				s.type(localUserdata +"\\CocCoc\\Browser\\Application");
				s.type(Key.ENTER);
				isIconAppear = waitForObjectPresent("pictures\\Browser_Icon_Picture_CoccocLogoInFolder.png", 5);
				s.type(Key.F4, Key.ALT);
				if (isIconAppear)
					setTestcaseStatus("PASSED", "all coccoc's icons are appear correctly");
				else
					setTestcaseStatus("FAILED", "icon on coc coc display wrong");
				}
			else
				setTestcaseStatus("FAILED", "CocCoc Icon not displayed on Desktop");
		}
		else
			setTestcaseStatus("SKIP", "Coc Coc browser installation failed");		
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_07 </br>
	 * <b> CaseTitle: </b> Check task manager when starting browser</br>
	 * <b> Steps: </b>
	 * 1. Start browser</b>
	 * 2. Open Windows Task Manager</br>
	 * <b> ExpectedOutput: </b></br>
	 * Must have: browser.exe + CocCocCrashHandler process</br>
	 * @author loandtt
	 * @Update huy.vu
	 * @date 20-MAY-2015
	 */
	
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_07()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_07: Check CocCoc in task manager");
		if (testcaseFlag){
			
			if (checkCocCocProgress())
				setTestcaseStatus("PASSED", "browser.exe and CocCocCrashHandle is exist on task manager");
			else
				setTestcaseStatus("FAILED", "browser.exe or CocCocCrashHandle is missing on task manager");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_08 </br>
	 * <b> CaseTitle: </b>Check the company signature in file exe and dll</br>
	 * <b> Steps: </b>
	 * 1. Browser is installed successfully</br>
	 * 2. Go to path: C:\Users\<Account_login_Windows>\AppData\Local\CocCoc</br>
	 * 3. Right click in all .dll and .exe files</br>
	 * 4. In context menu select "Properties"</br>
	 * 5. In open window, select tab Digital Signatures</br>
	 * <b> ExpectedOutput: </b></br>
	 * Must have information for company signature:COC COC COMPANY LIMITED</br>
	 * Excep these files: </br>
	 * 1. pepflashplayer.dll, pdf.dll signature info is Google Inc</br>
	 * 2. xinput1_3.dll, d3dcompiler_43.dll, d3dcompiler_46.dll signature info is: microsoft corporation</br>
	 * <br> Update form version 48.2.2546.117: This is only digital signer "COC COC COMPANY LIMITED" with version SHA256 and SHA2 for all file has digital signature
	 * 
	 * @author loandtt
	 * @Update hanv
	 * @date 2-june-2017
	 */
	
	
	 @Test (groups = { "execute" })
	 public void Browser_SMOKE_Install_08()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_08: Check the company signature in file exe and dll");
		
		if(testcaseFlag){	
			String CCFilePath = localUserdata + "\\CocCoc\\Browser\\Application\\" + CocCocVersion[1] ;
			s.type("r", Key.WIN) ;
			sleep (1);
			s.type(CCFilePath);
			s.type(Key.ENTER) ;
			sleep (1);
			s.type(Key.UP, Key.WIN) ;
			waitForObjectPresent("pictures\\Browser_Files_File_libglesv2dll.png", 5);
			
				hoverImage("pictures\\Browser_Files_File_libglesv2dll.png");
				sleep (1);
				rightClick("pictures\\Browser_Files_File_libglesv2dll.png");
				sleep (1);
				clickOn("pictures\\OSApp_MenuContext_Text_Propperty.png");
				clickOn("pictures\\OSApp_Dialog_Button_DigitalSignatures.png");
				if (waitForObjectPresent("pictures\\Browser_Signature_Text_Sha256.png", 4))
				{
					clickOn("pictures//OSApp_MenuDialog_Button_OK.png");
					sleep(1);
					clickOn("pictures\\Browser_Files_File_libglesv2dll.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "The company signature in file exe and dll are correctly");
				}
				else
				{
					clickOn("pictures//OSApp_MenuDialog_Button_OK.png");
					sleep(1);
					clickOn("pictures\\Browser_Files_File_libglesv2dll.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "The company signature in some exe files or dll are wrong");
				}
				
				
		
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_9 </br>
	 * <b> CaseTitle: </b>Check browser version and Omaha client version after the installation</br>
	 * <b> Steps: </b>
	 * 1. Browser is installed successfully</br>
	 * 2. Check browser version from "About us"</br>
	 * 3. Check browser version from path: C:\Users\<Account_Login_Windows>\AppData\Local\CocCoc\Browser\Application</br>
	 * 4. Check version Omaha Client:</br>
	 * + go to path C:\Users\<Account_Login_Windows>\AppData\Local\CocCoc\Update</br>
	 * + find folder named ex: 1.3.39.9</br>
	 * + Right click on file CocCocUpdate.exe => select tab "Details" => find "Product version"</br>
	 * 5. Check Omaha Client version is latest?</br>
	 * run coccocupdate.exe /ua => "no update is available" pop-up appears</br>
	 * <b> ExpectedOutput: </b></br>
	 * Omaha Client version and browser version must be correct with installed browser</br>
	 * @author loandtt
	 * @Update huy.vu
	 * @date 02-JUN-2015
	 */
	
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_09()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_09: Check version on browser after the installation");
		if (testcaseFlag){
			String CocCoc = localUserdata + "\\CocCoc\\Browser\\Application\\browser.exe";
			//Open Coccoc, check version on CocCoc:
			executeFile(CocCoc);
			//wait |CocCoc start and focus on coccoc
			waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 15);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.UP, Key.WIN);
			sleep(1);
			s.type("t", Key.CTRL);
			sleep(1);
			s.type("coccoc://version/");
			sleep(1);
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Browser_Tabs_Text_AboutVersion.png",5);
			s.type(Key.F3);
			s.type(CocCocVersion[1]);
			if(waitForObjectPresent("pictures\\Browser_About_text_ConfirmVersionBrowser.png", 2)){
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "CocCoc browser show version correctly");
				if(isOmahaVersionCorrect(CocCocVersion[2]))
					setTestcaseStatus("PASSED", "verrsion of omaha correctly");
				else
				{
					String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
					captureSnapshot(homePath, "Verrsion of omaha", 1);
					
					setTestcaseStatus("FAILED", "Verrsion of omaha incorrectly");
				}
			}
			else{
				String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
				captureSnapshot(homePath, "CocCocVersion", 1);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "CocCoc browser show version incorrectly");
			}
			
			
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
		}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_10 </br>
	 * <b> CaseTitle: </b>Check extensions version after the installation</br>
	 * <b> Steps: </b></br>
	 * 1. Browser is installed successfully</br>
	 * 2. Go to menu >Công Cụ>Tiện ích mở rộng (extensions)</br>
	 * <b> ExpectedOutput: </b></br>
	 * Must have:</br>
	 * + Unbranded version: 2 extensions (Savior, EnVN dictionary) with corresponding version</br>
	 * + Branded version: 3 extension (Savior, EnVN dictionary, haivl extension) with corresponding version</br>
	 * @author loandtt
	 * @Update huy.vu
	 * @date 2-june-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_10()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_10: Check Extension Version");
		if (testcaseFlag){
			String saviorName = "Savior";
			String en2viName = "Tu Dien";
			String saviorVersion = CocCocVersion[3];
			String en2viVersion = CocCocVersion[4];
			boolean savior = checkExtensionVersion(saviorName, saviorVersion);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			boolean en2vi = checkExtensionVersion(en2viName, en2viVersion);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			
			if (savior & en2vi)
				setTestcaseStatus("PASSED", "Extension version are correct");
			else 
				setTestcaseStatus("FAILED", "Extension version are wrong");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_11 </br>
	 * <b> CaseTitle: </b> Check task scheduler after the installation</br>
	 * <b> Steps: </b></br>
	 * After the browser is successfully installed, go to Windows Schedule Tasks (Administration tools) to check</br>
	 * <b> ExpectedOutput: </b></br>
	 * Must have 3 scheduled task in Task Scheduler:</br>
	 *+ Adobe Flash Player Update (optional)</br>
	 *+ CocCocUpdateTaskUser-…-core (update for browser)</br>
	 *+ CocCocUpdateTaskUser-…-ua (update for Omaha client)</br>
	 * @author loandtt
	 * @Update huy.vu
	 * @date 20-MAY-2015
	*/

	@Test(groups = { "execute" })

	public void Browser_SMOKE_Install_11()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_11: Check Browser tasks are added into Task Scheduler after successful installtion");
		if (testcaseFlag){
			//Check Schedule Task has tasks for CocCoc
			if (checkCocCocOnListSchedulerTask())
				setTestcaseStatus("PASSED", "Coccoc tasks are added on task schedule");
			else
				setTestcaseStatus("FAILED", "one or both tasks are missing on schedule task");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_12 </br>
	 * <b> CaseTitle: </b>Check autorun with system option set ON in installer dialog</br>
	 * <b> Steps: </b></br>
	 * 1. Launch installer file to install browser Coc coc</br>
	 * 2. Observe option "Khởi động trình duyệt cùng hệ thống"</br>
	 * 3. Do not select this option</br>
	 * <b> ExpectedOutput: </b></br>
	 * 2. By default, "Khởi động trình duyệt cùng hệ thống" option is unchecked</br>
	 * 3. After the installation, check on "Cài đặt", section "Cài đặt mặc định của hệ thống", make sure option "Khởi động trình duyệt cùng hệ thống" is not selected</br>
	 * 4. When system starts, browser Coc coc doesn't run automatically</br>
	 * @author loandtt
	 * @Update huy.vu
	 * @date 20-MAY-2015
	 */
	@Test(groups = { "pending" })
	public void Browser_SMOKE_Install_12()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_12: Check autorun with system option set ON in installer dialog.");	
		if(testcaseFlag){
			TestLogger.info("Not execute this test case due cannot restart Computer and continue test script");
			/*
			s.type("t",KeyModifier.CTRL);
			TestLogger.info("Go to page menu >Cài đặt> to make sure option 'Khởi động trình duyệt cùng hệ thống' is selected");
			pasteText("coccoc://settings/");
			s.type(Key.ENTER);
			s.type("khoi dong cung he thong");
			waitForObjectPresent("pictures\\Browser_Settings_Checkbox_UncheckedRunAtSystemStartup.png", 5);
			s.type(Key.F4, KeyModifier.ALT);
			s.type(Key.SHIFT, KeyModifier.CTRL);
			*/
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_13 </br>
	 * <b> CaseTitle: </b>Check autorun with system option set ON in installer dialog</br>
	 * <b> Steps: </b></br>
	 * 1. Launch installer file to install browser Coc coc
	 * 2. Observe option "Khởi động trình duyệt cùng hệ thống"
	 * 3. Tick on option "Khởi động trình duyệt cùng hệ thống"
	 * 4. Restart windows</br>
	 * <b> ExpectedOutput: </b></br>
	 * 2. By default, "Khởi động trình duyệt cùng hệ thống" option is unchecked
	 * 3. After the installation, check on "Cài đặt", section "Cài đặt mặc định của hệ thống", make sure option "Khởi động trình duyệt cùng hệ thống" is selected
	 * 4. When system starts, browser Coc coc runs automatically</br>
	 * @author loandtt
	 * @Update hanv.nv
	 * @date 02-JUN-2017
	 */
	@Test(groups = { "pending" })
	public void Browser_SMOKE_Install_13()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_13: Check autorun with system option set OFF in installer dialog.");
		if(testcaseFlag){
			TestLogger.info("Not execute this test case due cannot restart Computer and continue test script");
			// Check coccoc browser is opened
			//Open new tab -> go to settings -> advance
			//Check options "Khởi động cùng hệ thống is off
			/*
			s.type("t",KeyModifier.CTRL);
			TestLogger.info("Go to page menu >Cài đặt> to make sure option 'Khởi động trình duyệt cùng hệ thống' is selected");
			pasteText("coccoc://settings/");
			s.type(Key.ENTER);
			sleep(2);
			s.type(Key.UP, Key.WIN);
			if(waitForObjectPresent("pictures\\Browser_Settings_Checkbox_UncheckedRunAtSystemStartup.png", 5)){
				setTestcaseStatus("PASSED", "Option start with system is selected");
				s.type(Key.F4, KeyModifier.ALT);
			}
			else{
				s.type(Key.F4, KeyModifier.ALT);
				setTestcaseStatus("FAILED", "Option start with system isn't selected");
			}
			*/
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_14 </br>
	 * <b> CaseTitle: </b>Check install new version above old version</br>
	 * <b> Steps: </b></br>
	 * Precondition: An old browser is installed, there is some user data (browsing history, download history, adding some extensions…)
	 * 1. Install new version without uninstalling old version</br>
	 * <b> ExpectedOutput: </b></br>
	 * 1. Browser is upgraded to new version
	 * 2. User data is kept</br>
	 * @author huy.vu
	 * @Update HANV
	 * @date 03-JUN-2016
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_14()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_14: Check install new version above old version");
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "PASSED Browser_SMOKE_Install_13 Old user data is kept after overwrite new browser");
		}
		
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			TestLogger.info("Install old coccoc browser with verion VN");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\" + CocCocVersion[6]+ "\\coccoc_vi.exe");
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			makeCoccocHistory();
			
			TestLogger.info("Install new coccoc browser without uninstall old browser");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			
			boolean flag = isCocCocHistoryKept();
			
			if(flag)
				setTestcaseStatus("PASSED", "Old user data is kept after overwrite new browser");
			else
				setTestcaseStatus("FAILED", "Old user data isn't kept after overwrite new browser  ");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_15 </br>
	 * <b> CaseTitle: </b>Check install new version with old user data</br>
	 * <b> Steps: </b></br>
	 * Precondition: An old browser is installed, there is some user data (browsing history, download history, adding some extensions…)
	 * 1. Uninstall current browser without deleting User data
	 * 2. Install new version without uninstalling old version</br>
	 * <b> ExpectedOutput: </b></br>
	 * 1. New browser is installed successfully
	 * 2. Old user data is kept</br>
	 * @author loandtt
	 * @Update hanv
	 * @date 02-JUN-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_15()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_15: Check install new version with old user data");
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "PASSED Browser_SMOKE_Install_14 : Old user data is kept after installing new browser");
		}
		
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			TestLogger.info("Install old coccoc browser with verion VN");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\" + CocCocVersion[6]+ "\\coccoc_vi.exe");
			
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			
			makeCoccocHistory();
			
			UninstallWithDefaultOption(CocCocVersion[6]);
			
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
			
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
			s.type(Key.F4, Key.ALT);
			
			if(isCocCocHistoryKept())
				setTestcaseStatus("PASSED", "Old user data is kept after installing new browser");
			else
				setTestcaseStatus("FAILED", "Old user data isn't kept after installing new browser");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Install_16: Check if CC Browser is not set as default browser (Basic browser resources that need to be checked during installation progress or right after the installation Section) </br>
	 * <b> CaseTitle: </b>Check if CC Browser is not "set as default browser"</br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Install Coc Coc with uncheck on Set CocCoc as default browser
	 * 3. Wait for coc coc start
	 * 4. Restart Browser
	 * <b> ExpectedOutput: </b></br>
	 * #3: There is a message displays: "Coc Coc hien khong phai la trinh duyet chinh cua ban" and 2 buttons: "Dat CocCoc lam trinh duyet mac dinh" and "Khong, cam on" 
	 * #4: Button "Dat CocCoc lam trinh duyet mac dinh" is enable, there is a msg inform "CocCoc hien khong la tringh duyet mac dinh cuar ban"
	 * @author huy.vu
	 * @Update hanv
	 * @date 2-june-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_16(){
	
		
		boolean testcaseStatus = true;
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_16: Check if CC Browser is not set as default browser");
		if (System.getProperty("os.name").contains("Window 8") || (System.getProperty("os.name").contains("Window 8.1")))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_16 because it need test manual on Win 8 & Win 8.1");
		}
		
		if (System.getProperty("os.name").contains("Window 10"))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_16 because it need test manual on Win 10");
		}
		
		UninstallAndClearAllData(CocCocVersion[1]);
		// Temp comment this code 
		 setIEasDefaultbrowser();
		
		//Install and close browser
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		//exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		//restart CocCoc 
		startCocCoc();
		
		if (System.getProperty("os.name").contains("Window 7")) 
		{
			if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png",3))
			{
				clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
			}
			testcaseStatus = checkMessageSetDefaulBrowser();
		}
		
	
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("coccoc://settings/#coccoc-settings-general");
		s.type(Key.ENTER);
		
		if(testcaseStatus & checkMessageSetDefaulBrowserOnSettingsPage())
			setTestcaseStatus("PASSED", "All message and button appears correctly when install Coc coc is not default browser ");
		else
			setTestcaseStatus("FAILED", "One of message and button appears wrong when install Coc coc is not default browser   ");
	}
     
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_17 (Basic browser resources that need to be checked during installation progress or right after the installation Section) </br>
	 * <b> CaseTitle: </b>Check if CC Browser is "set as default browser" then change default browser to other else</br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Install Coc Coc with set CocCoc as default browser option is checked
	 * 3. Wait for coc coc start
	 * 4. Set other browser is default browser
	 * 5. Restart Coc Coc
	 * 6. Open coccoc://settings/#coccoc-settings-general
	 * <b> ExpectedOutput: </b></br>
	 * #3: Other browser is set as default browser
	 * #5: There is a message displays: "Coc Coc hien khong phai la trinh duyet chinh cua ban"
	 * #6: Button "Dat CocCoc la trinh duyet mac dinh" is enable, there is a msg inform "Coc Coc hien khong phai la trinh duyet chinh cua ban"
	 * @author huy.vu
	 * @Update huy.vu
	 * @date 2-june-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_17(){
		boolean testcaseStatus = true;
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_17: Check if CC Browser is 'set as default browser' then change default browser to other els");
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_17 because it need test manual on Win 10");
		}
		
		UninstallAndClearAllData(CocCocVersion[1]);
		// set IE is Default 
		setIEasDefaultbrowser();
		//Install with Cocococ is defautl browser 
		InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		//exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
	    //set IE is Default again 
		setIEasDefaultbrowser();
		
		startCocCoc();
		
		if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png",3))
		{
			clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
		}
		
		testcaseStatus = checkMessageSetDefaulBrowser();
		
		s.type("t", Key.CTRL);
		sleep(1);
		s.type("coccoc://settings/#coccoc-settings-general");
		s.type(Key.SPACE);
		sleep(2);
		s.type(Key.ENTER);
		
		if(testcaseStatus & checkMessageSetDefaulBrowserOnSettingsPage())
			setTestcaseStatus("PASSED", "All message and button appears correctly when set other browser as default browser ");
		else
			setTestcaseStatus("FAILED", "One of message and button appears wrong  when set other browser as default browser");
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_18 (Basic browser resources that need to be checked during installation progress or right after the installation Section) </br>
	 * <b> CaseTitle: </b>Check if dialog "Coc Coc hien khong phai la trinh duyet chinh cua ban" still be displayed although user clicked X button for this dialog 1 month before </br>
	 * <b> Steps: </b></br>
	 * 1. Install CC Browser
	 * 2. Uncheck "set CC as default brower" option
	 * 3. Restart browser 1st time
	 * 4. Select button "Khong, cam on"/"No, thanks" for msg "Coc Coc hien khong phai la trinh duyet chinh cua ban" the first time
	 * 5. Restart browser 2nd time
	 * 6. Select button "Khong, cam on"/"No, thanks" for msg "Coc Coc hien khong phai la trinh duyet chinh cua ban" the second time
	 * 7. Change setting date and time of local machine to future date: 1 month later (Ex: Current date: 11-May-2016, change to 11-Jun-2016)
	 * 8. Restart CC Browser 3rd time
	 * <b> ExpectedOutput: </b></br>
	 * #8: Make sure that msg "Coc Coc hien khong phai la trinh duyet chinh cua ban"  can be displayed again
	 * @author huy.vu
	 * @Update  HANV
	 * 
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_18(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_18:Check dialog sitll be displayed although user clicked X button for this dialog 1 month before ");
		TestLogger.info("+++" + System.getProperty("os.name"));
		
		if (System.getProperty("os.name").contains("Windows 8") || (System.getProperty("os.name").contains("Windows 8.1")))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_18 because it need test manual on Win 8 & Win 8.1");
		}
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_18 because it need test manual on Win 10");
		}
		
		boolean testcaseStatus = true;
		TestLogger.info("Check if CC Browser is not default browser");
		UninstallAndClearAllData(CocCocVersion[1]);
		setIEasDefaultbrowser();
		//Install 
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		//and close browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		sleep(3);
		
		startCocCoc();
		
		//click on "no, thanks" button
		waitForObjectPresent("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png",5);
		clickOn("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png");
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		sleep(3);
		
		changeMonth(1);
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		testcaseStatus = checkMessageSetDefaulBrowser();
		
		changeMonth(-1);
		
		
		if(testcaseStatus)
		{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("PASSED", "All message and button appears correctly when setting other browser as default browser ");
		}
		else{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("FAILED", "One of message and button appears wrong  when setting other browser as default browser");
		}
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_19  </br>
	 * <b> CaseTitle: </b>Check if dialog "Cốc Cốc isn't your default browser" still be displayed after installing CC 3 months although user selected "No, thanks" button</br>
	 * <b> Steps: </b></br>
	 1. Continue Browser_SMOKE_Install_16 testcase 
     2. Click on "No, thanks" button, then close CC Browser
     3. Change setting date and time of local machine to future date: 2 months later (it means 3 months later compare to real date)
     4. Start CC Browser
       Expect : Make sure that msg "Cốc Cốc isn't your default browser"  can be displayed again
	 * @Update HANV
	 * @date 2-6-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_19(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_19:Check if dialog  Cốc Cốc isn't your default browser still be displayed after installing CC 3 months although user selected No, thanks button ");
		if (System.getProperty("os.name").contains("Windows 8") || (System.getProperty("os.name").contains("Windows 8.1")))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_19 because it need test manual on Win 8 & Win 8.1");
		}
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_19 because it need test manual on Win 10");
		}
		boolean testcaseStatus = true;
		
		UninstallAndClearAllData(CocCocVersion[1]);
		// Temp comment this code 
		// setIEasDefaultbrowser();
		
		//Install and close browser
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		//exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		
		//restart CocCoc 
		startCocCoc();
		
		if (System.getProperty("os.name").contains("Window 7")) 
		{
			if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png",3))
			{
				clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
			}
			
		}
		
		
		TestLogger.info(" 1. Continue Browser_SMOKE_Install_16 testcase ");
		
		//click on "no, thanks" button
		TestLogger.info("2. Click on No, thanks button, then close CC Browser");
		if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png",5))
		{
		clickOn("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png");
		}
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		// exit CocCoc Browser
		s.type(Key.F4, Key.ALT);
		sleep(3);
		TestLogger.info("3.Change setting date and time of local machine to future date: 2 months later (it means 3 months later compare to real date)");
		changeMonth(3);
		TestLogger.info("4. Start CC Browser");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		testcaseStatus = checkMessageSetDefaulBrowser();
		
		changeMonth(-3); 
	
		if(testcaseStatus)
		{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("PASSED", "msg Cốc Cốc isn't your default browser can be displayed again");
		}
		else{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("FAILED", "msg Cốc Cốc isn't your default browser can NOT be displayed againr");
		}
		
		
	}
	
	/**
	 1. Continue Browser_SMOKE_Install_16 testcase 
     2. Click on "No, thanks" button, then close CC Browser
     3. Change setting date and time of local machine to future date: 4 months later (it means 7 months later compare to real date)
     4. Start CC Browser
        Expect : Make sure that msg "Cốc Cốc isn't your default browser"  can be displayed again
	 * @Update HANV
	 * @date 12-1-2017
	 */
	
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_21(){
		
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SMOKE_Install_21:Check if dialog  Cốc Cốc isn't your default browser still be displayed after installing CC 7 months although user selected No, thanks button ");
		if (System.getProperty("os.name").contains("Windows 8") || (System.getProperty("os.name").contains("Windows 8.1")))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_21 because it need test manual on Win 8 & Win 8.1");
		}
		
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			setTestcaseStatus("SKIP", "Skip Browser_SMOKE_Install_21 because it need test manual on Win 10");
		}
		boolean testcaseStatus = true;
		
		UninstallAndClearAllData(CocCocVersion[1]);
		// Temp comment this code 
		// setIEasDefaultbrowser();
		
		//Install and close browser
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		//exit browser
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		s.type(Key.F4, Key.ALT);
		
		//restart CocCoc 
		startCocCoc();
		
		if (System.getProperty("os.name").contains("Window 7")) 
		{
			if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png",3))
			{
				clickOn("pictures\\Browser_BubleDialog_Button_CloseWarningDialog.png");
			}
			
		}
		TestLogger.info(" 1. Continue Browser_SMOKE_Install_16 testcase ");
		
		//click on "no, thanks" button
		TestLogger.info("2. Click on No, thanks button, then close CC Browser");
		if (waitForObjectPresent("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png",5))
		{
		clickOn("pictures\\Browser_BubleDialog_Button_RejectSetDefaultBrowser.png");
		}
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep (2);
		// exit CocCoc Browser
		s.type(Key.F4, Key.ALT);
		sleep(3);
		TestLogger.info("3.Change setting date and time of local machine to future date: 7 months later (it means 3 months later compare to real date)");
		changeMonth(7);
		TestLogger.info("4. Start CC Browser");
		startCocCoc();
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		testcaseStatus = checkMessageSetDefaulBrowser();
		
		changeMonth(-7); 
	
		if(testcaseStatus)
		{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("PASSED", "msg Cốc Cốc isn't your default browser can be displayed again");
		}
		else{
			waitForObjectPresent("pictures\\Browser_AddressBar_icon_SaviorDisabled.png",5);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
			sleep(3);
			setTestcaseStatus("FAILED", "msg Cốc Cốc isn't your default browser can NOT be displayed againr");
		}
		
		
	
	}
	
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_21 </br>
	 * <b> CaseTitle: </b>Check with "make-coccoc-default"</br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Open command line, and change path to folder where the installer is saved
	 * 3. Type in command line: coccoc_vi.exe /silent /forcedcmdline "make-coccoc-default" /install</br>
	 * <b> ExpectedOutput: </b></br>
	 * Coc Coc is installed successfully
	 * Coc Coc is launched automatically after the installation
	 * Check in settings, Coc Coc is set as default browser</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-6-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_27()
	{
		String cmd = ("coccoc_vi.exe /silent /forcedcmdline \"make-coccoc-default\" /install");
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_27:  Install CocCoc in silient mode with command line: " + cmd);
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			installCoccocByCMD(cmd);
			boolean isCCstartAuto = waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png", 28);
			//killprocess("cmd.exe");
			if(!isCCstartAuto){
				//Open Coccoc and focus on Coc Coc
				startCocCoc();
				waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 15);
				sleep(10);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type("t", Key.CTRL);
				sleep(1);
				s.type("coccoc://settings/");
				sleep(1);
				s.type(Key.ENTER);
				
				waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 6);
				s.type(Key.UP, Key.WIN);
				s.type(Key.END);
				boolean isCCstartWithSystem= waitForObjectPresent("pictures\\Browser_Settings_Checkbox_CheckedRunAtSystemStartup.png", 15);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type(Key.F4, Key.ALT);
				if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1])){
					if(isCCstartWithSystem)
						setTestcaseStatus("PASSED", "Coc Coc is startup with windows");
					else
						setTestcaseStatus("FAILED", "Coccoc not start with systems ");
				}
				else
					setTestcaseStatus("FAILED", "Some files on \\CocCoc\\Applications wrong when install by cmd: " + cmd);
			}
			else
				setTestcaseStatus("PASSED", "Coccoc start after installing coc coc");
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_28 </br>
	 * <b> CaseTitle: </b>Check with "auto-launch-coccoc"</br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Open command line, and change path to folder where the installer is saved
	 * 3. Type in command line: coccoc_vi.exe /silent /forcedcmdline "auto-launch-coccoc" /install</br>
	 * <b> ExpectedOutput: </b></br>
	 * Coc Coc is installed successfully
	 * Coc Coc is launched automatically after the installation
	 * Check in settings, Coc Coc is set to run on system startup</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-6-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_28()
	{
		String cmd = "coccoc_vi.exe /silent /forcedcmdline \"auto-launch-coccoc\" /install";
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_28:  Install CocCoc in silient mode with command line: " + cmd);
		TestLogger.info("Install Coc Coc in silent mode with command line: " + cmd);
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			installCoccocByCMD(cmd);
			
			if(!waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png",35)){
				//killprocess("cmd.exe");
				if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1]))
					setTestcaseStatus("PASSED", "ALL files on \\CocCoc\\Applications is Correct when install by cmd: " + cmd );
				else
					setTestcaseStatus("FAILED", "Some files on \\CocCoc\\Applications wrong when install by cmd: " + cmd);
			}
			else
			{
				//killprocess("cmd.exe");
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "Coccoc start after installing coc coc");
			}
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_29 </br>
	 * <b> CaseTitle: </b>Check with "do-not-launch-chrome"</br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Open command line, and change path to folder where the installer is saved
	 * 3. Type in command line: coccoc_vi.exe /silent /forcedcmdline "do-not-launch-chrome" /install</br>
	 * <b> ExpectedOutput: </b></br>
	 * Coc Coc is installed successfully
	 * Coc Coc is NOT launched automatically after the installation </br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-6-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_29()
	{
		String cmd = "coccoc_vi.exe /silent /forcedcmdline \"do-not-launch-chrome\" /install";
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_29: Install CocCoc in silient mode");
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			installCoccocByCMD(cmd);
			boolean isButtonInstallAppears = waitForObjectPresent("pictures\\Browser_Setup_Button_ChooseSetup.png", 8);
			s.type("d", Key.WIN);
			waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 35);
			
			isButtonInstallAppears = isButtonInstallAppears & waitForObjectPresent("pictures\\Browser_Tabs_Text_UnfocusedTabTitle.png",5);
			
			if(!isButtonInstallAppears){
				//killprocess("cmd.exe");
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
				waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 15);
				sleep(3);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type(Key.F4, Key.ALT);
				
				if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1]))
					setTestcaseStatus("PASSED", "Coc Coc is NOT launched automatically after the installation by cmd " + cmd);
				else
					setTestcaseStatus("FAILED", "Some files on \\CocCoc\\Applications wrong when install by cmd: " + cmd);
			}
			else
			{
				//killprocess("cmd.exe");
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "Coc Coc STILL launch automatically after the command " + cmd);
			}
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Install_30 </br>
	 * <b> CaseTitle: </b></br>
	 * <b> Steps: </b></br>
	 * 1. Download latest version of Coc coc 
	 * 2. Open command line, and change path to folder where the installer is saved
	 * 3. Combine two parameters or all in one command, for example:
	 * coccoc_vi.exe /silent /forcedcmdline "do-not-launch-chrome --make-coccoc-default --auto-launch-coccoc" /install</br>
	 * <b> ExpectedOutput: </b></br>
	 * Coc Coc is installed but will not launch automatically after the installation, in Settings Cococ is set as default browser and to run on system startup</br>
	 * @author loandtt
	 * @Update HANV
	 * @date 2-june-2017
	 */
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Install_30()
	{
		String cmd = "coccoc_vi.exe /silent /forcedcmdline \"do-not-launch-chrome --make-coccoc-default --auto-launch-coccoc\" /install";
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Install_30:  Check combination of some parameters ");
		TestLogger.info("Open command line, and change path to folder where the installer is saved");
		if(testcaseFlag){
			UninstallAndClearAllData(CocCocVersion[1]);
			
			installCoccocByCMD(cmd);
			
			if(!waitForObjectPresent("pictures\\Browser_Setup_Button_ChooseSetup.png", 20)){
				//killprocess("cmd.exe");
				String CocCoc = localUserdata + "\\CocCoc\\Browser\\Application\\browser.exe";
				executeFile(CocCoc);
				//wait |CocCoc start and focus on coccoc
				waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 15);
				sleep(5);
				clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
				sleep(10);
				s.type(Key.F4, Key.ALT);
				
				if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1])){
					startCocCoc();
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png"); 
					s.type("t", Key.CTRL);
					sleep(1);
					s.type("coccoc://settings/");
					s.type(Key.ENTER);
					waitForObjectPresent("pictures\\Browser_Tabs_Text_SettingsPage.png", 6);
					s.type(Key.UP, Key.WIN);
					s.type(Key.END);
					boolean isCCrunOnstartup = waitForObjectPresent("pictures\\Browser_Settings_Checkbox_CheckedRunAtSystemStartup.png", 5);
					if(isCCrunOnstartup)
						setTestcaseStatus("PASSED", "Coc Coc is installed but will not launch automatically after the installation, in Settings Cococ is set as default browser and to run on system startup");
					else
						setTestcaseStatus("FAILED", "CocCoc installed but not start with system");
				}
				else
					setTestcaseStatus("FAILED", "Some files on \\CocCoc\\Applications wrong when install by cmd: " + cmd);
			}
			else
			{ 
				//killprocess("cmd.exe");
				setTestcaseStatus("FAILED", "The dialog to ask user install still appears ");
			}
		}
		else
			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
	}
//	/**
//	 * <b> Browser_Smoke_TestCase_Windows_v1.8.3_AUTO-CONTROL </b> </br>
//	 * <b> CaseID: </b> Browser_SMOKE_Install_23 </br>
//	 * <b> CaseTitle: </b>Check when /forcedcmdline has no parameter</br>
//	 * <b> Steps: </b></br>
//	 * 1. Download latest version of Coc coc 
//	 * 2. Open command line, and change path to folder where the installer is saved
//	 * 3. Type in command line: coccoc_vi.exe /silent /forcedcmdline "" /install</br>
//	 * <b> ExpectedOutput: </b></br>
//	 * In this case Coc Coc will be installed as normal mode with visible install dialogs</br>
//	 * @author loandtt
//	 * @Update huy.vu
//	 * @date 07-APR-2016
//	 */
//	@Test(groups = { "pending" })
//	public void Browser_SMOKE_Install_24()
//	{
//		String cmd = "coccoc_vi.exe /silent /forcedcmdline \"\" /install";
//		TestLogger.info("===============================================================================================================");
//		TestLogger.info("Run Browser_SMOKE_Install_19:  Install Coc Coc with command line: " + cmd);
//		if(testcaseFlag){
//			UninstallAndClearAllData(CocCocVersion[1]);
//			
//			//Open command line, and change path to folder where the installer is saved
//			installCoccocByCMD(cmd);
//			
//			boolean isSetupButtonAppears = waitForObjectPresent("pictures\\Browser_InstallDialog_Button_Install.png", 15);
//			InstallCoccocWithDefaultOption("");
//			if(isSetupButtonAppears){
//				sleep(10);
//				if(areAllFoldersCocCocAppers(localUserdata, userData, CocCocVersion[1]))
//					setTestcaseStatus("PASSED", "Coc Coc is installed as normal mode with visible install dialogs ");
//				else
//					setTestcaseStatus("FAILED", "Some files on \\CocCoc\\Applications wrong when install by cmd: " + cmd);
//			}
//			else
//				setTestcaseStatus("FAILED", "Coccoc cannot install on silient mode with cmd: " + cmd );
//		}
//		else
//			setTestcaseStatus("SKIP", "Failed at test case install, Please check");
//	}
}