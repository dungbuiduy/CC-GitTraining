package browser_Testsuite_Windows;


import java.io.File;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;
public class Browser_Windows_Uninstall extends BrowserCommon {
	
	public Browser_Windows_Uninstall() {

	}
	public String userprofile = System.getenv("USERPROFILE");
	private String localUserdata = System.getenv("LOCALAPPDATA"); //For example: C:\Users\Huy\AppData\Local
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	private boolean testcaseFlag = true;
	
	//@BeforeClass
	public void Browser_SMOKE_Uninstall_00(){
		
		TestLogger.info("======================================================================================================");
		TestLogger.info("|      EXECUTE TEST SCRIPT FOR TEST UN-INSTALL COC COC BROWSER FOR VERSION: " + CocCocVersion[1] + "            |");
		TestLogger.info("=======================================================================================================");
		s.type("d", Key.WIN);
		//Download Coccoc to local
		if(!DownloadCCBrowser(CocCocVersion[0]))
			setTestcaseStatus("SKIP", "Cannot download CocCoc.exe file, skip test");
	}
	
	@BeforeMethod
	public void Precondition(){
		UninstallAndClearAllData(CocCocVersion[1]);
		setIEasDefaultbrowser();
	}

	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_01 </br>
	 * <b> CaseTitle: </b>Uninstall CocCoc with keeping user data when CocCoc is not default browser</br>
	 * <b> Steps: </b></br>
	 * 1. Make sure Browser Coc Coc is not default browser
	 * 2. Start uninstall coccoc browser
	 * 3. From Uninstall dialog, DO NOT tick on "Also delete your browsing data"
	 * 4. Click Uninstall</br>
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * 
	 * #2.Browser is uninstalled
	 * - check file is removed:
	 *  + folder Browser\Application is removed
	 *  + folder Browser\User Data is removed
	 *  +  folder CrashReports is intouched
	 *  + folder Update is empty
	 *- Check tasks windows task scheduler are removed after 1 hour
	 * @author HANV
	 * @date 2 /6, 2017
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_01() {
		TestLogger.info("===========================================================================================================================");
		TestLogger.info("Execute testcase Browser_SMOKE_Uninstall_01: Uninstall when Coc Coc is not default browser; Keep user data");
		if(testcaseFlag){
			
			String messageFaile = "Test case uninstall failed due: ";
			Boolean ununstallFlag = true;
			TestLogger.info(" 1. Make sure Browser Coc Coc is not default browser");
			InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
			
			TestLogger.info("2. Uninstall Browser from Control Panel -> Programs and Features");
			TestLogger.info("3. From Uninstall dialog, DO NOT tick on Also delete your browsing data");
			TestLogger.info("4. Click Uninstall");
			 if (startUninstallCocCoc(false)== true)
			 {
				 setTestcaseStatus("PASSED", "Browser is uninstalled");
			 }
			 else
			 {
				 setTestcaseStatus("PASSED", "Browser is NOT uninstalled");
			 }
			
			
			// <----------------
			//Check folder: - check file is removed, Browser\Application, Update is empty, CrashReports intouched
			TestLogger.info("__________________________________");
			TestLogger.info("Check CocCoc's folder on userdata correctly");
			sleep(10);
			File ApplicationPath = new File (localUserdata + "\\CocCoc\\Browser\\Application"); //Check is removed
			File userDataPath =new File ( localUserdata + "\\CocCoc\\Browser\\User Data"); //Check not empty
			File crashReportPath = new File (localUserdata + "\\CocCoc\\CrashReports"); //check crash report empty
			File updatePath = new File (localUserdata + "\\CocCoc\\Update"); //Check is removed
			
			
			TestLogger.debug(updatePath.getPath());
			sleep(10);
			
			if(!ApplicationPath.exists())
				if(!isFolderEmpty(userDataPath))
					if(isFolderEmpty(crashReportPath))
						if(!updatePath.exists())
							setTestcaseStatus("PASSED", "All folders are correctly");
						else{
							ununstallFlag = false;
							messageFaile = messageFaile  + "\n\t - Folder update is incorrect";
						}
					else{
						ununstallFlag = false;
						messageFaile = messageFaile  + "\n\t - Folder Crash Report is incorrect";
					}
				else{
					ununstallFlag = false;
					messageFaile = messageFaile  + "\n\t - Folder User Data are incorrect";
				}
			else{
				ununstallFlag = false;
				messageFaile = messageFaile  + "\n\t - Folder Applications are incorrect";
			}
			
			// Check Folder C:\Users\\username\\AppData\Roaming\CocCoc, file uid still exists
		       File pathToRoamingCocCoc = new File (userprofile + "\\AppData\\Roaming\\CocCoc") ;
			
				if ( pathToRoamingCocCoc.list().length >0 )
				{
					ununstallFlag =true ;
					setTestcaseStatus("PASSED", " file uid still exists");
				}
				else
				{
					ununstallFlag =false ;
					setTestcaseStatus("FAILED", " file uid  NOT exists");
				}
			 
			
			if (ununstallFlag)
				setTestcaseStatus("PASSED", "Uninstall CocCoc work correctly with keeping user data when CocCoc is not default browser");
			else
				setTestcaseStatus("FAILED", messageFaile);
		}
		else
			setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_02 </br>
	 * <b> CaseTitle: </b>Uninstall when Coc Coc is not default browser; Delete user data</br>
	 * <b> Steps: </b></br>
	    1. install Browser Coc Coc is not default browser
        2. Uninstall Browser from Control Panel -> Programs and Features
        3. From Uninstall dialog, tick on "Also delete your browsing data"
        4. Click Uninstall</br>
        
	 * <b> ExpectedOutput: </b></br>
	 *   1) Browser Coc Coc is removed
	 *   2) Check in install folder: 
     *   C:\\Users\\username\AppData\Local\CocCoc
         - folder Browser is removed
         - folder CrashReports is intouched
         - folder Update is empty
         Folder C:\\Users\\username\AppData\Roaming\CocCoc, file uid still exist
	 *
	 *  @ : HANV
	 *  @ 2-Jan, 2017
	 * 
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_02() {
		if(testcaseFlag){
	
			TestLogger.info("===========================================================================================================================");
			TestLogger.info("Execute testcase Browser_SMOKE_Uninstall_02: Uninstall when Coc Coc is not default browser; Delete user data");
			
			TestLogger.info("Step 1: install Browser Coc Coc is not default browser ");
			
			InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		
			TestLogger.info("Step 2: Start uninstall coccoc browser  ");
		
			TestLogger.info("Step 3: Uninstall Coccoc with check options Also delete your browsing data");
			
			TestLogger.info("Expect : Browser is uninstalled ");
			
			if (startUninstallCocCoc(true) == true ) 
			{
				setTestcaseStatus("PASSED", "Browser is uninstalled successfully ! ");
			}
			else
			{
				setTestcaseStatus("FAILED", "Browser is NOT uninstalled successfully ! ");
			}
			
			// Check Folder C:\Users\\username\\AppData\Roaming\CocCoc, file uid still exists
		       File pathToRoamingCocCoc = new File (userprofile + "\\AppData\\Roaming\\CocCoc") ;
			
				if ( pathToRoamingCocCoc.list().length >0 )
				{
					setTestcaseStatus("PASSED", " file uid still exists");
				}
				else
				{
					setTestcaseStatus("FAILED", " file uid  NOT exists");
				}
				
			//Check folder: - check file is removed, Browser\Application, Update is empty, CrashReports intouched
			File ApplicationPath = new File (localUserdata + "\\CocCoc\\Browser\\Application"); //Check is removed
			File userDataPath =new File ( localUserdata + "\\CocCoc\\Browser\\User Data"); //Check is removed
			File crashReportPath = new File (localUserdata + "\\CocCoc\\CrashReports"); //check crash report empty
			File updatePath = new File (localUserdata + "\\CocCoc\\Update"); // Update is empty
			sleep(5);
			TestLogger.info("__________________________________");
			TestLogger.info("Check File and Folder are correctly");
			if(!ApplicationPath.exists())
			{
				
				if(!userDataPath.exists())
				{
					if(isFolderEmpty(crashReportPath))
					{
						if(!updatePath.exists())
						{
							setTestcaseStatus("PASSED", "All folders are correctly");
						}
						else
						{
							setTestcaseStatus("FAILED", "Folder update is incorrect");
						}
					}
					else
						setTestcaseStatus("FAILED", "Folder Crash Report is Not Empty");
				}
				else
					setTestcaseStatus("PASSED", "Folder User Data are removed correctly");
			}		
			else
				setTestcaseStatus("PASSED", "Folder Applications are removed ");
			
		}   
		
		  
		else
			setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_03 </br>
	 * <b> CaseTitle: </b>Uninstall CocCoc while keeping user data & when CocCoc is default browser</br>
	 * <b> Steps: </b></br>
	 *1. Browser Coc Coc is default browser
      2. Uninstall Browser from Control Panel -> Programs and Features
      3. From Uninstall dialog, do not tick on  "Also delete your browsing data"
      4. Select default browser is IE for example
      5. Click Uninstall button</br>
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *
	 * 1) Browser Coc Coc is uninstalled
       2) Check file/folder removal as fllowing : 
       * - Browser is uninstalled
	 * - check file is removed:
	 *  + folder Browser\Application is removed
	 *  + folder Browser\User Data is removed
	 *  +  folder CrashReports is intouched
	 *  + folder Update is empty
       3) IE is set as default
       4) User Data is intouched 
       
       <b> CaseID: </b> Browser_SMOKE_Uninstall_10 </br>
	 * <b> CaseTitle: </b>Check display of default browser selection in uninstall dialog when Coc Coc is default browser</br>
	* 1) Set Coc Coc browser as default browser
	* 2) Uninstall Coc Coc
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * In Uninstall dialog, there is option to allow user to select another default browser
        
	 
	 *
	 * @author Huy.vu
	 * @update :  HANV
	 * @date 16 1, 2017
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_03_10() {
		TestLogger.info("===========================================================================================================================");
		TestLogger.info("Execute testcase Browser_SMOKE_Uninstall_03: Uninstall when Coc Coc is default browser and select default browser; Keep user data");
		if(testcaseFlag){
			//---------> Check for Browser_SMOKE_Uninstall_03 & Browser_SMOKE_Uninstall_10
		
			InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe",0);
			
			TestLogger.info("2. Uninstall Browser from Control Panel -> Programs and Features");
			TestLogger.info("3. From Uninstall dialog, do not tick on  Also delete your browsing data");
			TestLogger.info("4. Select default browser is IE for example");
			
			if (startUninstallCocCoc(false) ==true)
			{
				setTestcaseStatus("PASSED", " Browser_SMOKE_Uninstall_03 : IE is set as default , Browser Coc Coc is uninstalled  ");
				setTestcaseStatus("PASSED", " Browser_SMOKE_Uninstall_10 : In Uninstall dialog, there is option to allow user to select another default browser  ");
			}
			else
			{
				setTestcaseStatus("FAILED", " Browser_SMOKE_Uninstall_03 : IE is NOT set as default , Browser Coc Coc is NOT uninstalled  ");
				setTestcaseStatus("FAILED", " Browser_SMOKE_Uninstall_10 : In Uninstall dialog, there is NOT option to allow user to select another default browser  ");
			}
			
			
			//Check folder: - Browser\Application is removed, Update is removed , CrashReports empty ,Usesr Data is not Empty
			TestLogger.info("__________________________________");
			TestLogger.info("Expected : User Data is intouched : Check all files and folders are correctly after uninstall");
			File ApplicationPath = new File (localUserdata + "\\CocCoc\\Browser\\Application"); //Check is removed
			File userDataPath =new File ( localUserdata + "\\CocCoc\\Browser\\User Data"); //Check not empty
			File crashReportPath = new File (localUserdata + "\\CocCoc\\CrashReports"); //check crash report empty
			File updatePath = new File (localUserdata + "\\CocCoc\\Update"); //Check is removed
			sleep(10);
			if(!ApplicationPath.exists())
				if(!isFolderEmpty(userDataPath))
					if(isFolderEmpty(crashReportPath))
	
						if(!updatePath.exists())
							setTestcaseStatus("PASSED", "All folders are correctly");
						else
							setTestcaseStatus("FAILED", "Folder update is incorrect");
					else
						setTestcaseStatus("FAILED", "Folder Crash Report is NOT empty");
				else
					setTestcaseStatus("FAILED", "Folder User Data are empty");
			else
				setTestcaseStatus("PASSED", "Folder Applications are incorrect");
		}
		else
			setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");

			
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_04 </br>
	 * <b> CaseTitle: </b>Uninstall when Coc Coc is default browser and do not select default browser; Delete user data</br>
	 * <b> Steps: </b></br>
	 * 1. Browser Coc Coc is default browser
       2. Uninstall Browser from Control Panel -> Programs and Features
       3. From Uninstall dialog, tick on "Also delete your browsing data"
       4. Do not select default browser in the suggestion list
       5. Click Uninstall button</br>
	 * 
	 * <b> ExpectedOutput: </b></br>
	 *  1) Browser Coc Coc is uninstalled
        2) Check file/folder removal as above
        3) User Data is removed (folder path as above)
        4) Last default browser (before Coc Coc has been set as default) will be reset to default
	 * @author Huy.vu
	 * @update : HANV
	 * @date 17 1, 2017
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_04() {
		TestLogger.info("===========================================================================================================================");
		TestLogger.info("Execute testcase Browser_SMOKE_Uninstall_04:Uninstall when Coc Coc is default browser and do not select default browser; Delete user data");
		if(testcaseFlag){
			TestLogger.info("Step 2: Make sure Browser Coc Coc is default browser");
			InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 0);
			 
			TestLogger.info(" Uninstall Browser from Control Panel -> Programs and Features");
     		TestLogger.info("--- Open uninstall coc coc");
     		// kill all coc coc browser
     		killprocess("browser.exe");
     		killprocess("CocCocCrashHandler.exe");
     		killprocess("delegate_execute.exe");
     		killprocess("CocCocUpdate.exe");
     		sleep(2);
     		String browerPath = "";
     		if (System.getProperty("os.name").contains("XP")) {
     			
     			browerPath = "C:\\Documents and Settings\\tester\\Local Settings\\Application Data";
     		}
     		else
     			browerPath = System.getenv("LOCALAPPDATA")+ "\\CocCoc\\Browser\\Application\\browser.exe";
     		
     		if(new File(browerPath).exists()){
     			
     			s.type("r", Key.WIN);
     			sleep(1);
     			s.type(Key.BACKSPACE);
     			//s.type(browerPath + " -uninstall");
     			s.type("appwiz.cpl");
     			s.type(Key.ENTER);
     			sleep(3);
     			s.type(Key.F3);
     			sleep(1);
     			s.type("coc coc");
     			sleep(1);
     			s.type(Key.DOWN);
     			sleep(1);
     			s.type(Key.DOWN);
     			sleep(1);
     			s.type(Key.DOWN);
     			s.type(Key.ENTER);
     			sleep (6);
     			
     			TestLogger.info("3. From Uninstall dialog, tick on Also delete your browsing data");
     			
     			 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png", 1))
				 {
				      clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png");
				 }
				 else
				 {
					 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png", 1))
					 {
					 clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png");
					 }
					 
					
					 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_Uninstall.png", 1))
						 clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
				 }
     			 
     			 
     			 TestLogger.info("4. Do not select default browser in the suggestion list"); 
     			 TestLogger.info("5. Click Uninstall button ");
     			if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_Uninstall.png", 1))
     			{
     			clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
     			
     			}
     			
     			clickOn("pictures\\OSApp_UninstallDialog_Text_UninstallorChangeAprogram.png");
     			s.type(Key.ENTER);
				s.type(Key.F4, Key.ALT);
				openFile(userprofile + "\\Downloads\\testFiles\\testTranslate.html");
				
     		    // Check Firefox is Default after that 
    			if (waitForObjectPresent("pictures\\Firefox_Tab_Text_CSSText.png", 15)) {
    				TestLogger.info("Firefox is set Default");
    				sleep(1);
    				s.type(Key.F4, Key.ALT);
    				killprocess("iexplore.exe");
    				setTestcaseStatus("PASSED", "Last default browser (before Coc Coc has been set as default) will be reset to default");
    				
    			}
    			else
    			{
    				TestLogger.info("Firefox is NOT set Default");
    				sleep(1);
    				s.type(Key.F4, Key.ALT);
    				killprocess("iexplore.exe");
    				setTestcaseStatus("FAILED", "Last default browser (before Coc Coc has been set as default) NOT be reset to default");
    			}
     		
	
			//Check folder: - check file is removed, Browser\Application, Update is empty, CrashReports intouched
			TestLogger.info("__________________________________");
			TestLogger.info("Check file and folder are correctly after uninstall");
			File ApplicationPath = new File (localUserdata + "\\CocCoc\\Browser\\Application"); //Check is removed
			File userDataPath =new File ( localUserdata + "\\CocCoc\\Browser\\User Data"); //Check is removed
			File crashReportPath = new File (localUserdata + "\\CocCoc\\CrashReports"); //check crash report empty
			File updatePath = new File (localUserdata + "\\CocCoc\\Update"); //Check is empty
			sleep(10);
			if(!ApplicationPath.exists())
				if(!userDataPath.exists())
					if(isFolderEmpty(crashReportPath))
						if(!updatePath.exists())
							setTestcaseStatus("PASSED", "All folders are correctly");
						else
							setTestcaseStatus("FAILED", "Folder update is not empty");
					else
						setTestcaseStatus("FAILED", "Folder Crash Report is not Empty");
				else
					setTestcaseStatus("PASSED", "Folder User Data are removed");
			else
				setTestcaseStatus("PASSED", "Folder Applications are Removed");
		}
		else
			setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
	  }
		
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_05 </br>
	 * <b> CaseTitle: </b>CocCoc task in Task Scheduler is removed after uninstall one hour</br>
	 * <b> Steps: </b></br>
	 * 1. uninstall CocCoc
	 * 2. Wait for 1 hour and check schedule task
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * No schedule task for CocCoc
	 * @author Huy.vu
	 * @date 11 Jan, 2016
	 */

	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_05(){
		TestLogger.info("===========================================================================================================================");
		TestLogger.info("Execute testcase Browser_SMOKE_Uninstall_05: Check if Coc Coc browser tasks are removed from Task Scheduler after 1 hour uninstalled");
		if(testcaseFlag){
			//Steps 1: Wait for 1 hours
			//60 seconds * 60 mins and 5 min for buffer 
			int hour = (60*60) + 120;
			sleep(hour);	
			if(!checkCocCocOnListSchedulerTask())
				setTestcaseStatus("PASSED", "After uninstall 1hour, cocCoc task on scheduler task are removed");
			else
				setTestcaseStatus("FAILED", "After uninstall 1hour, cocCoc task on scheduler task aren't removed");
		}
		else
			setTestcaseStatus("SKIP", "Download Coc Coc failed, Stop to test.");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_06 </br>
	 * <b> CaseTitle: </b>Check Uninstall page</br>
	* 1) After Browser is uninstalled from obove cases, a webpage display on Internet Explorer
	* 2) Select some reasons to uninstall 
	* 3) Click Send button
	 * 
	 * <b> ExpectedOutput: </b></br>
	 * A dialog message displays, click Close button, user will be redirected to https://corom.com 
	 * @aouthor : HANV 
	 * @date : 17/1/2017 
	 */
	 
	
	@Test(groups = { "execute" })
	public void Browser_SMOKE_Uninstall_06(){
		TestLogger.info("Browser_SMOKE_Uninstall_06: Check Uninstall page");
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe", 1);
		TestLogger.info("1.Uninstall CocCoc Browser ");
		// kill all coc coc browser
				killprocess("browser.exe");
				killprocess("CocCocCrashHandler.exe");
				killprocess("delegate_execute.exe");
				killprocess("CocCocUpdate.exe");
				sleep(2);
				String browerPath = System.getenv("LOCALAPPDATA")+ "\\CocCoc\\Browser\\Application\\browser.exe";
				
				if(new File(browerPath).exists()){
					
					s.type("r", Key.WIN);
					sleep(1);
					s.type(Key.BACKSPACE);
					s.type("appwiz.cpl");
					s.type(Key.ENTER);
					sleep(3);
					s.type(Key.F3);
					sleep(1);
					s.type("coc coc");
					sleep(1);
					s.type(Key.DOWN);
					sleep(1);
					s.type(Key.DOWN);
					sleep(1);
					s.type(Key.DOWN);
					s.type(Key.ENTER);
					sleep (6);
				   if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png", 1))
						 {
						      clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteData.png");
						 }
						 else
						 {
							 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png", 1))
							 {
							 clickOn("pictures\\Browser_UninstallDialog_Checkbox_DeleteFile.png");
							 }
							 
							
							 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_Uninstall.png", 1))
								 clickOn("pictures\\Browser_UninstallDialog_Button_Uninstall.png");
						 }
				     }
					
					if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption.png", 1))
					{
						clickOn("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption.png");
						moveMouseHorizontallyFromLogo("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption.png", 150);
						s.click();
						clickOn("pictures\\Browser_UninstallDialog_List_IE.png");
						s.type(Key.ENTER);
						sleep(2);
						clickOn("pictures\\OSApp_UninstallDialog_Text_UninstallorChangeAprogram.png");
						s.type(Key.F4, Key.ALT);
						
					}
					
					else
					{
					 if (waitForObjectPresent("pictures\\Browser_UninstallDialog_Button_ChooseUninstallOption.png", 1))
					 {
					 clickOn("pictures\\Browser_UninstallDialog_Button_ChooseUninstallOption.png");
					 }
					 else
					 {
						    sleep(1);
						    s.type(Key.ENTER);
						    sleep(2);
						    clickOn("pictures\\OSApp_UninstallDialog_Text_UninstallorChangeAprogram.png"); 
					 }
					
					s.type(Key.F4, Key.ALT);
					
					}
					
					// Check IE After Browser is uninstalled , a webpage display on Internet Explorer
					if (waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png", 2)) {
						TestLogger.info(" After Browser is uninstalled , a webpage display on Internet Explorer");
						clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessage.png");
						sleep(1);
						s.type(Key.UP, Key.WIN);
						sleep(1);

						// chose reason uninstall
						clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox01.png");
						s.type(Key.DOWN);
						sleep(1);
						s.type(Key.DOWN);
						sleep(1);
						s.type(Key.DOWN);
						sleep(1);
						clickOn("pictures\\Browser_UninstallSurvey_Button_Send.png");

						// Chose good feature
						waitForObjectPresent("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox02.png", 5);
						clickOn("pictures\\Browser_UninstallSurvey_Text_PittyMessageCheckbox02.png");
						sleep(1);
						// Select favious browser
						s.type(Key.TAB);
						s.type(Key.DOWN);

						// Click send
						 clickOn("pictures\\Browser_UninstallSurvey_Button_Send.png");
						
						 clickOn("pictures\\Browser_UninstallSurvey_Button_Close.png");
						 
						 if (waitForObjectPresent("pictures\\Website_CocCoc_image_Logo.png" ,2))
						 {
						   setTestcaseStatus("PASSED", "user are redirected to https://corom.com");	 
						 }
						 else
						 {
							 setTestcaseStatus("FAILED", "user are NOT redirected to https://corom.com");	 
						 }
					    	s.type(Key.F4, Key.ALT);
						
					}
		
		
	}
	
	@Test
	public void Browser_SMOKE_Uninstall_11 ()
	{
		//---------> Check for Browser_SMOKE_Uninstall_11
		// uninstall CocCoc & delete All Files if available 
		 UninstallAndClearAllData(CocCocVersion[1]);
		 
		//Step 1: Make sure Browser Coc Coc is not default browser
		InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe",1);
		
		TestLogger.info("--- uninstall coc coc");
		// kill all coc coc browser
		killprocess("browser.exe");
		killprocess("CocCocCrashHandler.exe");
		killprocess("delegate_execute.exe");
		killprocess("CocCocUpdate.exe");
		sleep(2);
		String browerPath = "";
		if (System.getProperty("os.name").contains("XP")) {
			
			browerPath = "C:\\Documents and Settings\\tester\\Local Settings\\Application Data";
		}
		else
			browerPath = System.getenv("LOCALAPPDATA")+ "\\CocCoc\\Browser\\Application\\browser.exe";
		
		if(new File(browerPath).exists()){
			
			s.type("r", Key.WIN);
			sleep(1);
			s.type(Key.BACKSPACE);
			s.type("appwiz.cpl");
			s.type(Key.ENTER);
			sleep(3);
			s.type(Key.F3);
			sleep(1);
			s.type("coc coc");
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			sleep(1);
			s.type(Key.DOWN);
			s.type(Key.ENTER);
			
		}	
		
	
		TestLogger.info("__________________________________");
		TestLogger.info("Check combobox to change other browser appears on uninstall modal");
		
		if(!waitForObjectPresent("pictures\\Browser_UninstallDialog_Checkbox_ChangeDefaultBrowserOption.png", 1)){
			setTestcaseStatus("PASSED", "In Uninstall dialog, there is NOT option to allow user to select another default browser ");
		}
		else
			TestLogger.warn("FAILED: In Uninstall dialog, there is STILL option to allow user to select another default browser");
		
	
	}
	
	

	
	
	
}