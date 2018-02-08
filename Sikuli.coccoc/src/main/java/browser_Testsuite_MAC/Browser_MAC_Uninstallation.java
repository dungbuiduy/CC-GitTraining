

package browser_Testsuite_MAC;

import org.junit.BeforeClass;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_MAC_Uninstallation extends BrowserCommon{
	public Browser_MAC_Uninstallation() {

	}
	
	private String[] CocCocVersion = getTestInfomationMAC("config/coccocVersionMAC.txt");
	@BeforeClass
	public void Browser_SMOKE_00(){
		TestLogger.info("====================================================================================================");
		TestLogger.info("Test uninstall for build: " + CocCocVersion[1]);
		TestLogger.info("====================================================================================================");
		if(DownloadCCBrowserMAC(CocCocVersion[0])){
			setTestcaseStatus("SKIP", "Skip test uninstall because of cannot download CocCoc form serrver, please check!");
		}
		UnInstallAndCleanAllDataCCMAC();
	}
	/**
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_07 </br>
	 * <b> CaseTitle: </b>Uninstall browser</br> 
	 * <b> Steps: </b></br> 
	 * 1. Close all Coc Coc windows
	 * 2. Open Applications, drag and drop Coc Coc icon to Trash</br> 
	 * <b> ExpectedOutput: </b></br>
	 * Coc Coc is uninstalled and removed from Applications</br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_07() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_07: Uninstall browser");	
		
		InstallCocCocOnMac("coccoc.dmg");
		//close all CocCoc browser
		closeAllCocCocOnMAC();
		
		//Uninstall CocCoc: Drag and drop Coc Coc from Applocation to trash
		removeCocCocOnApplications();
		
		//Check Coc Coc is removed on launch pad
		if(checkCocCocIsRemovedOnMAC())
			setTestcaseStatus("PASSED","CocCoc is removed");
		else
			setTestcaseStatus("FAILED", "CocCoc isn't removed");

	}
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_08 </br>
	 * <b> CaseTitle: </b>Re-install browser when user data is clean</br> 
	 * <b> Steps: </b></br> 
	 * 1. Uninstall browser as above case
	 * 2. Open Applications  > Utilities  > Terminal, type command: find ~/ -iname "*coccoc*"
	 * Remove all files folders related to coccoc if needed (using "rm -rf /path/to/file/folder), e.g:
	 * tester/Libirary/Application Support/coccoc
	 * tester/Libirary/Caches/coccoc
	 * tester/Library/Preferences/com.coccoc.Coccoc.plist
	 * 3. 	
	 * 4. Open browser</br> 
	 * <b> ExpectedOutput: </b></br>
	 * Browser opens with two tabs: Welcome page + New tab</br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_08() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_08: Re-install browser when user data is clean");
		UnInstallAndCleanAllDataCCMAC();
		
		InstallCocCocOnMacWithOptions("coccoc.dmg");
		
		startCocCocOnMac();
		
		//UNinstall Coc coc
		if(checkCocCocIsStartOnFirstTimeMAC())
			setTestcaseStatus("PASSED","CocCoc opens welcome page and new tab on the first time");
		else
			setTestcaseStatus("FAILED", "CocCoc doesn'r open welcome page and new tab on the first time");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_09 </br>
	 * <b> CaseTitle: </b>Re-install browser without deleting user data</br> 
	 * <b> Steps: </b></br> 
	 * 1. Uninstall browser, do not remove install folder
	 * 2. Install browser
	 * 3. Open browser</br> 
	 * <b> ExpectedOutput: </b></br>
	 * Browser opens with only New tab</br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_09() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_09: Uninstall without deleting user data");
		UnInstallAndCleanAllDataCCMAC();
		InstallCocCocOnMac("coccoc.dmg");
		
		removeCocCocOnApplications();
		
		InstallCocCocOnMacWithOptions("coccoc.dmg");
		
		startCocCocOnMac();
		
		if(waitForObjectPresentMAC("newtabMAC.png", 50))
			setTestcaseStatus("PASSED","CocCoc opens new tab on the first time after reinstall");
		else
			setTestcaseStatus("FAILED", "CocCoc doesn'r open new tab on the first time after reinstall");
	}
}

