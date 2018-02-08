package browser_Testsuite_Others;

import java.sql.Timestamp;
import java.util.Date;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.TestLogger;

public class Browser_Windows_Addtone_Daily extends BrowserCommon_Extensions{
	
	private String addToneStr = "con cho boi trong be nuoc";
	private String siteTest = "http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_textarea";
	private String userprofile = System.getenv("USERPROFILE");
	int timeout = 5;
	
	@BeforeClass
	public void beforTestAddTone(){
		TestLogger.info("----------------------------TEST SNIFF FOR ADDTONE----------------------");
		String domainDownloadCocCoc = getCocCocVersion("config\\coccocVersion.txt")[0];
		if(DownloadCCBrowser(domainDownloadCocCoc)){
			UninstallAndClearAllData("");
			InstallCoccocWithDefaultOption(userprofile + "\\Downloads\\coccoc_vi.exe");
		}
		else{
			setTestcaseStatus("SKIPPED", "Failed to download CocCoc installer, skip all test");
		}
	}
	
	@Test
	public void AddTone_DailyCheck(){
		int loop = 1;
		int countPass = 0;
		int countFail = 0;
		int countSkip = 0;
		Date date= new Date();
		String generalMessage = "Start time = " + new Timestamp(date.getTime());
		for(loop=1; loop <= 30; loop++){
			TestLogger.info("---------------------------------------------Loop: " + loop + "---------------------------------------------------------------");
			startCocCoc();
			s.type("t", Key.CTRL);
			s.type(siteTest);
			s.type(Key.ENTER);
			if(waitForObjectPresent("sniff\\Addtone_textArea.png", 20)){
				//focus on text area and delete old text
				hoverImage("sniff\\Addtone_textArea.png");
				sleep(1);
				clickOn("sniff\\Addtone_textArea.png");
				s.type("a", Key.CTRL);
				s.type(Key.DELETE);
				sleep(1);
				//type vietnamese without tone
				s.type(addToneStr);
				if(waitForObjectPresent("sniff\\Extension_Addtone_suggestion.png", timeout)){
					countPass = countPass + 1;
					TestLogger.info("Addtone suggestion box appears when user pauses typing around 2s");
				}
				else{
					String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
					captureSnapshot(homePath, "ScreenShotTestCaseFailed", 1);
					countFail = countFail + 1;
					TestLogger.warn("Failed: Addtone suggestion box not appears when user pauses typing around 2s ");
				}
			}
			else{
				countSkip = countSkip + 1;
				TestLogger.warn("SKIPED: Cannot open page to test!");
			}
			//cleanup
			clearDownloadPage();
			sleep(30);
		}
		//Write report
		date= new Date();
		generalMessage = generalMessage + "---------------------------------------------------------------------------\r\n"
				+ "Total Passed: " + countPass + "\r\n"
				+ "Total Failed: " + countFail + "\r\n"
				+ "Total Skiped: " + countSkip + "\r\n"
				+ "End time = " + new Timestamp(date.getTime())
				+ "\r\n---------------------------------------------------------------------------" ;
		TestLogger.info(generalMessage);
		writeContainToTextFile("c:\\ws\\log\\Addtonelog.txt", generalMessage, true);
	
	}
}
