package browser_Testsuite_Windows;

import java.io.File;

import org.seleniumhq.jetty9.servlet.ServletTester;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_Update extends BrowserCommon {

	
	public Browser_Windows_Update() {
	}
	//Get environment:
	private String userprofile = System.getenv("USERPROFILE");
	private String localUserdata = System.getenv("LOCALAPPDATA");
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	private String versionTest = "";
	private boolean testcaseFlag = true;
	//private String olderCocCocVersion = CocCocVersion[6] ; 
	
	//@BeforeClass
	public void Browser_SMOKE_Update_00(){

		TestLogger.info("=====================================================================================================");
		TestLogger.info("|      EXECUTE TEST SCRIPT FOR TEST UPDATE COC COC BROWSER FOR VERSION: " + CocCocVersion[1] + "            |");
		TestLogger.info("======================================================================================================");
		s.type("d", Key.WIN);
		UninstallAndClearAllData(CocCocVersion[1]);
		//Download Coccoc to local
		testcaseFlag = DownloadCCBrowser(CocCocVersion[0]);
		
	/*	for (int i = 1; i <= countVersionUpdate; i++){
			testcaseFlag = testcaseFlag & DownloadCCBrowserOnFTP(CocCocVersion[5 + i]);
		}*/
		
		if(!testcaseFlag)
			setTestcaseStatus("SKIPTED", "Skip to test update due cannot download coc coc browser");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_01</br>
	 * <b> CaseTitle: </b>Check version of browser after update</br>
	 * <b> Steps: </b></br>
	 * 1. Update successfully (followed steps in sheet #Test Environment)
	 * 2. Go to Menu, open About Us/gioi thieu
	 * 3. Go to folder path: C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application </br>
	 * <b> ExpectedOutput: </b></br>
	 * 1. In page About Us, display correct version of browser updated and there is no warning
	 * 2. In install folder, display:
	 * +  folder named current version (after update)
	 * +  folder Omaha version: new files added
	 *
	 * @author loandtt
	 * @Updater Huy
	 * @date 02-Jun-2017
	 */
	@Test (groups = {"execute"})
	public void Browser_SMOKE_Update_01(){	
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Update_01: Check version of browser after update ");
		
		int count;
		String latestVersion = CocCocVersion[1];
		String olderCocCocVersion;
		String message = "";
		boolean isCocCocUpdateSuccess = true;
		String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
		
		for (count =  0; count < countOldVersionBrowser ; count++){
			olderCocCocVersion = CocCocVersion[(5 + count)];
			TestLogger.info("Test Coc Coc update for version: " + olderCocCocVersion );	
			TestLogger.info("==============================================================");
			//Step 1: install old version
			//Uninstall old browser if any and clean all data
			UninstallAndClearAllData(CocCocVersion[1]);
			String olderVersionPath= userprofile + "\\Downloads\\" + olderCocCocVersion + "\\coccoc_vi.exe";
			if(testcaseFlag){
				InstallCoccocWithDefaultOption(olderVersionPath);
				//Step 2: goto menu -> About us -> Check version is latest, no warning appears
				if(checkCoccocUpdateProcess())
				{
					if(waitForObjectPresent("pictures\\Browser_Settings_Button_ReupdateBrowserVersion.png", 130))
						clickOn("pictures\\Browser_Settings_Button_ReupdateBrowserVersion.png");
					
					waitForObjectPresent("pictures\\Browser_Settings_Text_CoccocIsUpToDate.png",30);
					s.type(Key.F4, KeyModifier.ALT);
					
			    	if(isOmahaVersionCorrect(CocCocVersion[2]))
			    	{
			    		TestLogger.info("The Omaha version after updated correctly");
			    	}
					else{
						captureSnapshot(homePath, "ScreenShotforUpdateFailed", 1);
						TestLogger.warn("The File old_browser.exe not exists: Know Issue -> test cases not being marked as failed on this check point");
						message = message + "The Omaha version wrong when update from " + olderCocCocVersion + "to " + latestVersion;
						isCocCocUpdateSuccess = false;
					}
					
					//Step 3: Go to CocCoc folder -> Check sub folder with Name is current folder
					File f = new File(localUserdata + "\\CocCoc\\Browser\\Application\\" + latestVersion);
					File fileBrowser = new File(localUserdata + "\\CocCoc\\Browser\\Application\\browser.exe");
					
					if(f.isDirectory() && ( fileBrowser.isFile()))
					 {
						isCocCocUpdateSuccess = true ; 
						setTestcaseStatus("PASSED", "In install folder, display folder named current version (after update)");
					 }
					 
					 else
					 {
							captureSnapshot(homePath, "ScreenShotforUpdateFailed", 1);
							message = message + "\n\t- The folder of latest version not exists ";
							TestLogger.warn("Update Coc Coc from version " + olderCocCocVersion + " to version " + CocCocVersion[1] + " Failed");
							setTestcaseStatus("FAILED", "In install folder, DOES NOT display folder named current version (after update)");
					 
							isCocCocUpdateSuccess = false;
							TestLogger.warn("Failed: The folder of latest version not exists ");
					}
					
					
				}
				else{
					captureSnapshot(homePath, "ScreenShotforUpdateFailed", 1);
				
					message = message + "\n -> Update Coc Coc from version " + olderCocCocVersion + " to version " + CocCocVersion[1] + " Failed\n-------------";
					isCocCocUpdateSuccess = false;
				}
			}
			
			
			else{
				isCocCocUpdateSuccess = false;
				setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
			}  
			
		}
		   
		if(isCocCocUpdateSuccess)
			setTestcaseStatus("PASSED", "Update Coc Coc from all old verrsions version success");
		else
			setTestcaseStatus("FAILED", "Update Coc Coc from some old verrsions version unsuccess due" + message);
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_02</br>
	 * <b> CaseTitle: </b>Check binary files in browser folder after update vs binary files from fresh installer</br>
	 * <b> Steps: </b></br>
	 * 1. Update successfully (followed steps in sheet #Test Environment)</br>
	 * 2. Go to folder path:</br>
	 * C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\Application </br>
	 * => Copy and save following files/folders:</br>
	 * + folder has folder name as latest version which has been updated</br>
	 * + file: browser.exe, first run, VisualElementsManifest</br>
	 * + folder: Dictionaries (if update version has this extension)</br>
	 * 3. Install from fresh installer latest version, copy and save files/folders as step 2 after install</br>
	 * 4. Open tool Total Commander> From menu bar>Commands>Synchronize dirs...</br>
	 * => select target 2 folders including 2 copies in 2 steps above to compare</br>
	 * <b> Expected Output: </b></br>
	 *  + 2 these folders must be the same about name, number of files, file content (exclude date time difference)</br>
	 *  + Upgrade version has more file old_browser.exe</br>
	 * @author loandtt
	 * @date 2-JUNE-2017
	 */
	@Test (groups = {"execute"})
	public void Browser_SMOKE_Update_02(){
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Run Browser_SMOKE_Update_02: Check binary files in browser folder after update vs binary files from fresh installer");	
		
		int count;
		String coccocFolder = localUserdata + "\\CocCoc\\Browser\\Application\\";
		String CocCoclatestVersion = CocCocVersion[1];
		File srcFolder = new File(coccocFolder + CocCoclatestVersion);
		String coccocSetupLocation = userprofile + "\\Downloads\\coccoc_vi.exe";
		boolean isFoldersCorrect = true;
		File destFolder;
		String olderCocCocVersion;
		
		//Step 1: Continue testcase Update_01: Do this step on testcase 01
		//Step 2: Copied file and folder of latest version on test case #01
		//Step 3: install latest cc version and compare files
		
		UninstallAndClearAllData(CocCocVersion[1]);
    	sleep(3);
		if(InstallCoccocWithDefaultOption(coccocSetupLocation)){
			for (count =  0; count < countOldVersionBrowser ; count++){
				olderCocCocVersion = CocCocVersion[5 + count];
				if(versionTest.contains(olderCocCocVersion)){
					TestLogger.info("--- Check these folders must be the same about name, number of files, file content for update from version: " + olderCocCocVersion);
					
					//Step 3: Make sure files and  folders on steps 2 are same, file older_version not exist
					destFolder = new File("c:\\tmp\\" + "\\" + olderCocCocVersion+ "\\" + CocCoclatestVersion);
					try {
						TestLogger.info("\t --->Compare all file between 2 folders .....");
						if(getDiff(srcFolder, destFolder, true)){
							File f = new File(localUserdata + "\\CocCoc\\Browser\\Application\\old_browser.exe");
							if(!f.exists())
								TestLogger.info("\t\t ->> All files and folders are sane name, number of file, file contains");
							else{
								TestLogger.warn("The file old_browser.exe still exist");
								isFoldersCorrect = false;
							}
						}
						else{
							isFoldersCorrect = false;
							TestLogger.warn("Some file or Folders not match");
						}
					} catch (Exception e) {
						TestLogger.warn("Some error occour! Pls check testscrit!!!!");
					}
				}
				else
					TestLogger.warn("Do not test file for version " + olderCocCocVersion + " due update failed!");
			}
			if(isFoldersCorrect)
				setTestcaseStatus("PASSED", "All file and folder same about name, number of file and file contains");
			else
				setTestcaseStatus("FAILED", "Some thing not correct, pls check log for more details");
		}
		else
			setTestcaseStatus("SKIP", "Cannot install Coc Coc browser, Skip this testcase.");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_03</br>
	 * <b> CaseTitle: </b>Check re-branding message when update from any version older than 33.0.1750.157 </br>
	 * <b> Steps: </b></br>
	 * 1. Update successfully
	 * 2. Run first time</br>
	 * <b> Expected Output: </b></br>
	 *  + Must display a pop-up message informing that the browser has changed name and logo from </br>
	 * @author loandtt
	 * @date 25-MAY-2015
	 */
	@Test (groups = {"pending"})
	public void Browser_SMOKE_Update_03(){
		//String older version: 33.0.1750.154_vi.exe
		TestLogger.info("Run Browser_SMOKE_Update_03");	
		TestLogger.info("Check re-branding message when update from any version older than 33.0.1750.157");
		TestLogger.info("Skip this testcase due out of date");
		
		/*
		//Step 1: install coccoc browser version 33.0.1750.157
		
		InstallChromeWithDefaultOption("33.0.1750.154_vi.exe");	
		
		//Step 2: Wait for update completed -> Check popup
		waitForObjectPresent(15000);
		typeTextOn2("t",KeyModifier.CTRL);
		waitForObjectPresent(2000);
		pasteText("chrome://chrome/");
		waitForObjectPresent(2000);
		typeTextOn(Key.ENTER);
		waitForObjectPresent2("updateingchrome",15000);
		
		if(waitForObjectPresent2("changechromecc.png", 30))	{
			typeTextOn2(Key.F4, KeyModifier.ALT);
			setTestcaseStatus("PASSED", "Re-branding message when update from any version older than 33.0.1750.157");
			}
			else
			{
				typeTextOn2(Key.F4, KeyModifier.ALT);
				setTestcaseStatus("FAILED", "Re-branding message when update from any version older than 33.0.1750.157");
			}*/
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Update_04</br>
	 * <b> CaseTitle: </b>Check NO re-branding browser message when update from 33.0.1750.157 </br>
	 * <b> Steps: </b></br>
	 * 1. Update successfully
	 * 2. Run first time</br>
	 * <b> ExpectedOutput: </b></br>
	 * No pop-up informing that the browser has changed name and logo</br>
	 * @author loandtt
	 * @date 25-MAY-2015
	 */
	@Test (groups = {"pending"})
	public void Browser_SMOKE_Update_04(){	
		TestLogger.info("Run Browser_SMOKE_Update_04");	
		TestLogger.info("Check re-branding message when update from any version older than 33.0.1750.157");
		TestLogger.info("Skip this testcase because this case is no needed checking now");
		
		
		/*
		InstallChromeWithDefaultOption("33.0.1750.157_vi.exe");	
		waitForObjectPresent(22000);
		TestLogger.info("Check Must display a pop-up message informing that the browser has changed name and logo from");
		waitForObjectPresent(3000);
		if(isObjectPresent("maximum.png"))
		{
			clickOn("maximum.png");
		}
		else
			waitForObjectPresent(2000);
		waitForObjectPresent(5000);
		if(!isObjectPresent("changechromecc.png"))
		{	
			waitForObjectPresent(3000);
			typeTextOn2("t",KeyModifier.CTRL);
			waitForObjectPresent(2000);
			pasteText("chrome://chrome/");
			waitForObjectPresent(2000);
			typeTextOn(Key.ENTER);
			waitForObjectPresent(15000);	
			if(isObjectPresent("updateingchrome.png"))
			{
				waitForObjectPresent(20000);
				clickOn("rerunchrome.png");
				waitForObjectPresent2("ccupdated.png", 20);	
				waitForObjectPresent(3000);
				typeTextOn2(Key.F4, KeyModifier.ALT);
			}
			else
			{
				waitForObjectPresent2("ccupdated.png", 10);
				waitForObjectPresent(3000);
				typeTextOn2(Key.F4, KeyModifier.ALT);
			}
		}*/
	}
}