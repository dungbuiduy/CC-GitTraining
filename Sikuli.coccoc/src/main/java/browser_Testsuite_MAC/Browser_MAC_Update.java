

package browser_Testsuite_MAC;

import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_MAC_Update extends BrowserCommon{
	public Browser_MAC_Update() {

	}
private String[] CocCocVersion = getTestInfomationMAC("config/coccocVersionMAC.txt");
	
	@Test
	public void Browser_SMOKE_00() {
		boolean isCCinstallerDownload = false;
		TestLogger.info("=====================================================================================");
		TestLogger.info(" TEST INSTALL FOR COC COC BROWSER ON MAC BUILD : " + CocCocVersion[1]);
		TestLogger.info("=====================================================================================");
		TestLogger.info("Download installer from: " + CocCocVersion[0] + " to ~/Downloads/coccoc.dmg");
		
		isCCinstallerDownload = DownloadCCBrowserMAC(CocCocVersion[0]);
		if(!(isCCinstallerDownload & downloadCoccocFromFTPforMAC(CocCocVersion[5]))){
			setTestcaseStatus("SKIP", "Skip test Update because of cannot download CocCoc form serrver, please check!");
		}
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_10 </br>
	 * <b> CaseTitle: </b>Check browser update automatically when there is newer version</br> 
	 * <b> Steps: </b></br> 
	 * 1. Open Coc Coc browser 
	 * 2. Check if there is folder ~/Library/Application Support/.Sparkle
	 * 3. Close browser and reopen in terminal: ~/Library/Application Support/Coccoc/.Sparkle ls -a /</br> 
	 * <b> ExpectedOutput: </b></br>
	 * 1. New package will be downloaded inside folder ~/Library/Application Support/.Sparkle
	 * 2. Coc Coc browser is updated to latest version, there will be no notification or update progress, so check if the latest version is shown in About Coc Coc
	 * 3. After some time the folder ~/Library/Application Support/.Sparkle will be removed automatically</br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 * String fileName = "Coccoc " + CocCocVersion[1].split("\\.")[0] + "." + CocCocVersion[1].split("\\.")[1] + "."+ CocCocVersion[1].split("\\.")[3];
	 */
	@Test
	public void Browser_SMOKE_10() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_10 and _11: Check coc coc update");
		String homePath = System.getProperty("user.home");
		String fileName = "Coccoc " + CocCocVersion[1].split("\\.")[0] + "." + CocCocVersion[1].split("\\.")[1] + "."+ CocCocVersion[1].split("\\.")[3];
		String filePath = homePath + "/Library/Application Support/Coccoc/.Sparkle/" + fileName;
		boolean isCocCocfileNotExist;
		boolean isCocCocfileExist;
		boolean updateProcess;
		boolean CoccocVersion;
		
		UnInstallAndCleanAllDataCCMAC();
		
		//create file name
		InstallCocCocOnMac(CocCocVersion[5]);
		
		startCocCocOnMac();
		//wait for Coccoc check update automatically
		sleep(10);
		isCocCocfileExist = checkFileExist(filePath);
		
		//Start and wait for CocCoc update
		waitforCoccocAutoUpdate();
		
		updateProcess = waitForObjectPresentMAC("relauchMac.png", 150);
		clickOnMac("relauchMac.png");
		//Sleep for wait Coc Coc is close to upgrade to newer version
		waitforObjectDisappearMAC("iconccMAC.png", 10);
		
		//wait for Coc coc restart
		waitForObjectPresentMAC("iconccMAC.png", 150);
		sleep(5);
		
		CoccocVersion = checkCoccocVersion("external", CocCocVersion[1]);
		isCocCocfileNotExist = !(checkFileExist(homePath + "/Library/Application Support/Coccoc/.Sparkle/" + fileName));
		
		closeAllCocCocOnMAC();
		
		if(isCocCocfileExist & CoccocVersion & isCocCocfileNotExist & updateProcess)
			setTestcaseStatus("PASSED", "CocCoc update with correct process");
		else
			setTestcaseStatus("FAILED", "CocCoc update with some process wrong");
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_MAC_v1.3_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b> Browser_SMOKE_Uninstall_10 </br>
	 * <b> CaseTitle: </b>Check update manually</br> 
	 * <b> Steps: </b></br> 
	 * 1. Open Coc Coc menu > About Coc Coc</br> 
	 * <b> ExpectedOutput: </b></br>
	 * 1. Browser starts updating right away if there is available update</br>
	 * @author loandtt
	 * @date 25-JUN-2015
	 */
	@Test
	public void Browser_SMOKE_11() {
		TestLogger.info("-------------------------------------------------------------------------------------");
		TestLogger.info("Run Browser_SMOKE_11: Check update manually: Intergration on testcase_10");
		
	}
}

