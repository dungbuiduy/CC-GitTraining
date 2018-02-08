package browser_Testsuite_Windows;

import java.io.File;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_CrashReport extends BrowserCommon {
	
	/*
	 * Pre-condition
	 * 
	 * Download, uninstall CocCoc and clean file on download folder
	 */
	//@BeforeClass
	public void beforTestAddTone(){
		TestLogger.info("----------------------------TEST SNIFF FOR Crash report----------------------");
		
		String userprofile = System.getenv("USERPROFILE");
		String domainDownloadCocCoc = getCocCocVersion("config\\coccocVersion.txt")[0];
		if(DownloadCCBrowser(domainDownloadCocCoc)){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		}
		else{
			setTestcaseStatus("SKIPED", "Failed to download CocCoc installer, skipp all test");
		}
	}
   
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_CrashReport_01 </br>
	 * <b> CaseTitle: </b>Check the crash report page is displayed normally or not</br>
	 * <b> Steps: </b>
	 '- Open browser
      - Type into addressbox: chrome://crash
	 *  <b> ExpectedOutput: 
	 *  EXPECT : 
	 '- '1. One white-background page with Crash warning msg is displayed: Something went wrong while displaying this webpage. 
	     2. Button "Reload"
	 * @author hanv
	 */
	@Test
	public void Browser_SNIFF_CrashReport_01 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_CrashReport_01: Check the crash report page is displayed normally or not");
		startCocCoc();
		sleep(3);
		openLink("coccoc://crash/");
		
		TestLogger.info("EXPECT. 1.One dark-background page with Crash warning msg is displayed && 2. Button Reload "); 
		if (waitForObjectPresent("pictures\\Browser_CrashReport_Picture_SadFaceIcon.png", 12) && (waitForObjectPresent("pictures\\Browser_CrashReport_Button_ReloadPage.png", 5) )) 
		{
		    closeBrowser();
			setTestcaseStatus("PASSED", "One dark-background page with Crash warning msg is displayed ");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "There is NOT One dark-background page with Crash warning msg is displayed ");
		}
	}
	
	
	/**
	 * <b> Browser_Sniff_TestCase_Windows_v2.8_AUTO </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_CrashReport_02 </br>
	 * <b> CaseTitle: </b> Check if the information of crash report are saved into local folder</br>
	 * <b> Steps: </b>
	 * - Open browser
	 * 1. Open browser
	 * 2. Type into address box: "chrome://crash" several times
	 * 3. Open the folder in your local machine: C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\User Data\Crashpad\reports
	 *  <b> ExpectedOutput: 
	 * EXPECT : 
	 *  User will see .dmp file is saved into C:\Users\<Account_login_Windows>\AppData\Local\CocCoc\Browser\User Data\Crashpad\reports folder
	 * @author hanv
	 */
	
	@Test
	public void Browser_SNIFF_CrashReport_02 ()
	{
		String coccocPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\User Data\\Crashpad\\reports" ;
		int countDumFile = 0;
		File coccocCrashPath = new File(coccocPath);
		DeleteFileAndFolderInSpecificPath(coccocCrashPath);
		sleep(1);
		coccocCrashPath.mkdir();
		
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_CrashReport_03: Check if the information of crash report are saved into local folder");
		
		TestLogger.info("- Open browser ");
		startCocCoc();
		
		//Open coc coc crash several times
		openLink("coccoc://crash/");
		sleep (2);
		s.type("t", Key.CTRL);
		openLink("coccoc://crash/");
		sleep (2);
		s.type("t",Key.CTRL);
		openLink("coccoc://crash/");
		sleep (5);
		
		for (File f : coccocCrashPath.listFiles())
			if (f.getName().contains(".dmp")) {
				countDumFile = countDumFile + 1;
			}
		
		//Check 3 dum files exist on crash folder
		if (countDumFile >= 3)
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "User can see .dmp file is saved into C:\\Users\\<Account_login_Windows>\\AppData\\Local\\CocCoc\\Browser\\User Data\\Crashpad\\reports folder");
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "The file dmp not save into C:\\Users\\<Account_login_Windows>\\AppData\\Local\\CocCoc\\Browser\\User Data\\Crashpad\\reports folder");
		}
	}
	
}
