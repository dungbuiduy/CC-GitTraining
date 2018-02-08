

package browser_Testsuite_MAC;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_MAC_Install extends BrowserCommon{ 

	public Browser_MAC_Install() {

	}
	
private String[] CocCocVersion = getTestInfomationMAC("config/coccocVersionMAC.txt");
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_00</br>
	 * <b> CaseTitle: </b>Download Coccoc</br> 
	 * <b> Steps: </b></br> 
	 * 1. Download installer from:
	 * - http://dev.coccoc.com or</br> 
	 * <b> ExpectedOutput: </b></br>
	 * Check incon apple and extention type .dmg</br>
	 * @author loandtt
	 * @throws FindFailed 
	 * @date 25-JUN-2015
	 */
	
	@BeforeClass
	public void Browser_SMOKE_00() {
		boolean isCCinstallerDownload = false;
		TestLogger.info("==============================================================================================================");
		TestLogger.info(" TEST INSTALL FOR COC COC BROWSER ON MAC BUILD : " + CocCocVersion[1]);
		TestLogger.info("==============================================================================================================");
		TestLogger.info("Download installer from: " + CocCocVersion[0] + " to ~/Downloads/coccoc.dmg");
		isCCinstallerDownload = DownloadCCBrowserMAC(CocCocVersion[0]);
		if(!(isCCinstallerDownload & downloadCoccocFromFTPforMAC(CocCocVersion[5]))){
			setTestcaseStatus("SKIP", "Skip test install because of cannot download CocCoc form serrver, please check!");
		}
		UnInstallAndCleanAllDataCCMAC();
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_01 </br>
	 * <b> CaseTitle: </b>Install package</br> 
	 * <b> Steps: </b></br> 
	 * 1. Download installer from:
	 * - http://dev.coccoc.com or
	 * - Open in Safari link: ftp://mac1v.dev.itim.vn/38.0.2125.106
 	 * (link provided with corresponding version, connect with Guest user)
	 * 2. Double click on .dmg file (for example: 38.0.2125.106.dmg)
	 * 3. In opened window, drag and drop Cốc Cốc icon to Applications (can be found in Dock or Finder menu > Go > Applications)</br> 
	 * <b> ExpectedOutput: </b></br>
	 * 1. Cốc Cốc browser is installed successfully and stored in Applications</br>
	 * @author loandtt
	 * @throws FindFailed 
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_01() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_01: Install package");	
		//Install Coccoc form dmg file
		//InstallCocCocOnMac(homePath + "/Downloads/coccoc.dmg");
		InstallCocCocOnMac("coccoc.dmg");
		
		// Check coc coc install success full and stored in Applications folder
		if(isCocCocInstallonMac())
			setTestcaseStatus("PASSED","Cốc Cốc browser is installed successfully and stored in Applications");
		else
			setTestcaseStatus("FAILED","Cốc Cốc browser isn't installed successfully or stored in Applications");
		
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.1_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_02 </br>
	 * <b> CaseTitle: </b>Check first run browser</br> 
	 * <b> Steps: </b></br> 
	 * 1. Open Coc Coc from Applications
	 * 2. Open from Coc Coc menu > About Coc Coc
	 * 3. Open from Coc Coc menu Windows > Extensions </br> 
	 * <b> ExpectedOutput: </b></br>
	 * 1. Coc Coc browser opens with Welcome tab + New tab
	 * 2. Browser version appears to users should be like:  50.2.155
	 * 3. Internal version should be like: coc_coc_browser/50.2.155 Chrome/44.2.2403.155
	 * 4. Extensions version should be correct/br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_02() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_02: Check first run browser");
		
		//Start Coccoc from /Applications -> Make sure that Coc Coc start with 2 tab Welcome tab + New tab
		startCocCocOnMac();
		
		waitAndFocusCocCoc();
		
		//go to Coccoc://coccoc -> Check external version
		boolean externalVersion = checkCoccocVersion("external", CocCocVersion[1]);
		
		//go to Coccoc://version -> check internal version
		boolean internalVersion = checkCoccocVersion("internal", CocCocVersion[1]);
		
		//Go to coccoc://extensions -> check extension version
		boolean extensionVersion = checkExtensionVersionMAC("Savior", CocCocVersion[3]);
		
		extensionVersion = extensionVersion & checkExtensionVersionMAC("Dictionary", CocCocVersion[4]);;
		//Set testcase status
		
		closeCurrentWindows();
		if(externalVersion & internalVersion & extensionVersion)
			setTestcaseStatus("PASSED", "Version of internal, external, and extensions are correctly");
		else
			setTestcaseStatus("FAILED", "Version of internal or external or extensions wrong");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_03 </br>
	 * <b> CaseTitle: </b>Check install folder</br> 
	 * <b> Steps: </b></br> 
	 * 1. Open Finder, from the menu click on Go > Home
	 * 2. Open user folder ~Library/Application Support/Coccoc (~ means user home, for example tester/Library/...)
	 * 3. Open user folder ~Library/Preferences</br> 
	 * <b> ExpectedOutput: </b></br>
	 * 2. All appropriates files and folders present
	 * 3. There is file com.coccoc.Coccoc.plist</br>
	 * @author loandtt
	 * @updater: Huy.Vu
	 * @date 31-Mar, 2016
	 */
	@Test
	public void Browser_SMOKE_03() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_03: Check install folder");
		
		//go to ~Library/Application Support/Coccoc -> check all file correctly
		boolean ApplicationSupport = checkApplicationSupport();
		//goto ~Library/Preferences/ -> check file com.coccoc.Coccoc.plist exist
		boolean Preferences = checkFileExist(System.getProperty("user.home") + "/Library/Preferences/com.coccoc.Coccoc.plist");
		
		//Set test case status
		if (ApplicationSupport & Preferences)
			setTestcaseStatus("PASSED", "All appropriates files and folders present");
		else
			setTestcaseStatus("FAILED", "Some appropriates files and folders are not exist");
	}
	/**
	 * PENDING ON MAC DUE ISSUE: CANNOT DRAG AND DROP ON MAC BY SIKULI: RAISE ISSUE TO RAIMAN: https://bugs.launchpad.net/sikuli/+bug/1546915
	 * <b> Browser_Smoke_TestCase_MAC_v1.1_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_04 </br>
	 * <b> CaseTitle: </b>Install new version above old version</br> 
	 * <b> Steps: </b></br> 
	 * Precondition: An old browser is installed, there is some user data (browsing history, download history, adding some extensions…)
	 * - Download new version from http://dev.coccoc.com
	 * - Install new version without uninstalling old version</br> 
	 * - Drag and drop Coccoc to Applications > Choose "Replace"
	 * <b> ExpectedOutput: </b></br>
	 * 1. Browser is upgraded to new version
	 * 2. User data is kept</br>
	 * @author loandtt
	 * @updater: Huy.Vu
	 * @date 31-Mar, 2016
	 */
	@Test
	public void Browser_SMOKE_04() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_04: Install new version above old version with option 'Replace'");
		//Clean environment: uninstall coc coc and delete old data
		UnInstallAndCleanAllDataCCMAC();
		
		//install older Coc Coc version
		InstallCocCocOnMac(CocCocVersion[5] + ".dmg");
		//add some data to history
		addCoccocHistory();
		
		//install new coc coc version with options "Replace"
		InstallCocCocOnMac("coccoc.dmg", "Replace");
		
		// Check version correctly, Data is kept
		if(checkCoccocHistory()&checkCoccocVersion("internal", CocCocVersion[1]))
			setTestcaseStatus("PASSED", "Old data is kept");
		else
			setTestcaseStatus("FAILED", "Old data is not kept");
	}

	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.1_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_05 </br>
	 * <b> CaseTitle: </b>Install new version above old version</br> 
	 * <b> Steps: </b></br> 
	 * Precondition: An old browser is installed, there is some user data (browsing history, download history, adding some extensions…)
	 * - Download new version from http://dev.coccoc.com
	 * - Install new version without uninstalling old version</br> 
	 * - Drag and drop Coccoc to Applications > Choose "Keep both files"
	 * <b> ExpectedOutput: </b></br>
	 * 1. In Applications exists two version old Coccoc. 
	 * NOTE:
	 *  - User can run only one at the time
	 *  - Two browsers have same user data
	 *  - Savior extension seems to work with newer version, so there will be case Savior only displays in new version</br>
	 * @author loandtt
	 * @updater: Huy.Vu
	 * @date 31-Mar, 2016
	 */
	@Test
	public void Browser_SMOKE_05() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_05: Install new version above old version with option 'Keep both files'");
		boolean isCocCocExist2Version;
		boolean isVersionCorrect;
		boolean isDataKept;
		boolean isDataBetween2VersionSame;
		boolean isCocCocStartOnluOneVersion;
		
		UnInstallAndCleanAllDataCCMAC();
		//install older Coc Coc version
		InstallCocCocOnMac(CocCocVersion[5] + ".dmg");
		
		//add some data to history
		addCoccocHistory();
		
		//install new coc coc version with options "Keep both files"
		InstallCocCocOnMac("coccoc.dmg","Keep both files");
		
		//Check Coccoc on Applications folder has 2 Coc Coc version -> Done
		isCocCocExist2Version = checkCoccocExist2VersionOnApplications();
		
		// Check version correctly, Data is kept
		isVersionCorrect = checkCoccocVersion("internal", CocCocVersion[1], "new");
		isDataKept = checkCoccocHistory();
		
		// Check data between 2 version are same -> check history ->
		isDataBetween2VersionSame = checkDataBetween2VersionAreSame();
		
		// Check user just open only one Coccoc on the same time
		isCocCocStartOnluOneVersion = checkCocCocStartOnlyOneVersion(CocCocVersion[1], CocCocVersion[5]);
		
		// Savior extension seems to work with newer version, so there will be case Savior only displays in new version -> Not check version
		boolean testcaseFlag = isVersionCorrect & isDataKept & isDataBetween2VersionSame & isCocCocStartOnluOneVersion & isCocCocExist2Version;
		
		//uninstall Coc Coc due this is special case.
		removeAllCocCoc();
		if(testcaseFlag)
			setTestcaseStatus("PASSED", "Old data is kept");
		else
			setTestcaseStatus("FAILED", "Old data is not kept");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_06 </br>
	 * <b> CaseTitle: </b>Install new version with old data</br> 
	 * <b> Steps: </b></br> 
	 * Precondition: An old browser is installed, there is some user data (browsing history, download history, adding some extensions…)
	 * - Uninstall current browser without deleting User data
	 * - Install new version without uninstalling old version</br> 
	 * <b> ExpectedOutput: </b></br>
	 * 1. New browser is installed successfully
	 * 2. Old user data is kept</br>
	 * @author loandtt
	 * @updater: Huy.Vu
	 * @date 31-Mar, 2016
	 */
	@Test
	public void Browser_SMOKE_06() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_06: Install new version with old data");
		UnInstallAndCleanAllDataCCMAC();
		//Install Coccoc
		InstallCocCocOnMac(CocCocVersion[5] + ".dmg");
		//Make some history data
		addCoccocHistory();
		
		//uninstall CocCoc
		removeCocCocOnApplications();
		
		//install CocCoc
		InstallCocCocOnMac("coccoc.dmg");
		
		//Make sure Data is kept
		if(checkCoccocHistory())
			setTestcaseStatus("PASSED", "Old data is kept");
		else
			setTestcaseStatus("FAILED", "Old data is not kept");
	}

}

