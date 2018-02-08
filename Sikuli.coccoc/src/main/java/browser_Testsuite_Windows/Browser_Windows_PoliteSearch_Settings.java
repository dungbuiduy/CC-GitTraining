package browser_Testsuite_Windows;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_PoliteSearch_Settings extends BrowserCommon {

	public String userprofile = System.getenv("USERPROFILE");
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");

	
	/**
	 * <b> \\samba1o\QA\WIP\AutomationTest\Sikuli\BROWSER_SNIFF\Browser_Sniff_TestCase_Windows_v2.8_AUTO.xlsx </b> </br>
	 * <b> CaseID: </b>rowser_SNIFF_PoliteSearch_Settings_01</br>
	 * <b> CaseTitle: </b>Browser_SNIFF_PoliteSearch_Settings_01: Check default metasearcher after install browser Coccoc</br>
	 * <b> Steps: </b></br>
	    1. Install browser Coccoc
        2. Open chrome://settings/
        3. In Search part
	 * <b> ExpectedOutput: </b></br>
	 *   1. Google is selected as default search engine
         2. "Use Cốc Cốc metasearcher" is ticked by default
	 * 
	 * @date : 5-June-2017 
	 * @update HANV
	 */
	
	@Test
	public void Browser_SNIFF_PoliteSearch_Settings_01 ()
	{
		TestLogger.info("===============================================================================================================");
		TestLogger.info("Browser_SNIFF_PoliteSearch_Settings_01: Check default metasearcher after install browser Coccoc");
		    UninstallAndClearAllData(CocCocVersion[1]);
		    
		   // Make sure Browser Coc Coc is default browser
		    TestLogger.info("1.Install browser Coccoc");
			InstallCoccocWithVariant(userprofile + "\\Downloads\\coccoc_vi.exe",0);
			startCocCoc();
			TestLogger.info("2.Open chrome://settings/");
			openLink("coccoc://settings/#coccoc-settings-view");
			TestLogger.info("Check that 1. Google is selected as default search engine & 2. Use Cốc Cốc metasearcher is ticked by default");
			if (waitForObjectPresent("pictures\\Coccoc_SearchEngineSettings_Text_Google.png", 2)
					&& (waitForObjectPresent("pictures\\Coccoc_SearchEngineSettings_Checkbox_CheckedMetasearcherCocCoc.png", 5)))
			{
				setTestcaseStatus("PASSED", "1. Google is selected as default search engine &&"
						+ " 2. Use Cốc Cốc metasearcher  is ticked by default");
			}
			else
			{
				setTestcaseStatus("FAILED", "1. Google is NOT selected as default search engine &&"
						+ " 2. Use Cốc Cốc metasearcher NOT is ticked by default");
			}
			
			
	}

}
