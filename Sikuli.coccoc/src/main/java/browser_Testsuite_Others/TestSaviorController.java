package browser_Testsuite_Others;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sikuli.script.Key;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser_Framework.AdsHandler;
import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.ExcelFileController;
import browser_Framework.TestLogger;

public class TestSaviorController extends BrowserCommon_Extensions {

	
	static String VersionSavior = "0.18.0" ;
	
	HSSFWorkbook excelFile;
	HSSFSheet sheetFinalResult,sheetAutomationData;
	HSSFCell cell;
	String result;
	ExcelFileController controllerExel;
	String pathExcel;
	String nameOfSong;
	String nameOfSite;
	String userprofile = System.getenv("USERPROFILE");
	String coccocSetupLocation = userprofile + "\\Downloads\\coccoc_vi.exe";
	String isExecute;
	String SiteURL;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	Calendar cal = Calendar.getInstance();
	String fileName = (dateFormat.format(cal.getTime()));
	AdsHandler adsHandle = new AdsHandler();
	boolean f1,f2,f3,f4,flag,flag2,flag2_1,flag3 ;
	String nameOfButtonDownload[] = {"0","pictures\\Browser_Savior_Button_DownloadOnVideo.png","pictures\\Browser_Savior_Button_DownloadOnVideoOption.png" ,"pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png","pictures\\Browser_Savior_Button_DownloadOnVideoOption.png"} ;
	
	
	@BeforeTest
	public void preCondition() throws Exception {
		TestLogger.info("-------------------------------Prepare environment to test-----------------------------------");

		try{
			controllerExel = new ExcelFileController();
			pathExcel = getResource("pictures\\SaviorWeekly\\SaviorTracking.xls");
			excelFile = controllerExel.getExcelFile(pathExcel);
			sheetFinalResult = controllerExel.getSheetFromExcelFile(excelFile, "FinalResult");
			sheetAutomationData = controllerExel.getSheetFromExcelFile(excelFile, "AutomationData");
			//Setup Coc Coc browser
			
		   // UninstallAndClearAllData("");
		   // DownloadCCBrowser("coccoc.com");
		   // InstallCoccocWithDefaultOption(coccocSetupLocation);
		   // confirmSaviorVersion();
			
			//Clean older report for savior problem file
			File saviorReportFolder = new File ("saviorReport");
			if(saviorReportFolder.exists())
				DeleteFileAndFolderInSpecificPath(saviorReportFolder);
			saviorReportFolder.mkdirs();
		}
		catch(Exception e)
		{
			setTestcaseStatus("SKIPED", "There are some problem when geting data form excel file, install CocCoc browser, please check! \n ERROR: " + e.toString());
		}
	}
	
	@Test
	public void testSite() throws Exception {
		TestLogger.info("-------------------------------Test Savior extension:-----------------------------------");

		int totalSiteTest=0,  totalSiteSkip = 0;
		int NumberInExcel ;
		for( NumberInExcel = 1; NumberInExcel < 75; NumberInExcel++)
		{
			try{

			// ========== SECTION PRE-CONDITION: get site information
			nameOfSite = controllerExel.getCellFromSheet(sheetAutomationData, NumberInExcel, 1).getStringCellValue();
			isExecute = controllerExel.getCellFromSheet(sheetAutomationData, NumberInExcel,2).getStringCellValue();
			SiteURL = controllerExel.getCellFromSheet(sheetAutomationData, NumberInExcel, 3).getStringCellValue();
			nameOfSong = controllerExel.getCellFromSheet(sheetAutomationData, NumberInExcel, 4).getStringCellValue();
			
		
			//======== SECTION TEST
			if(isExecute.equals("Y")){
				totalSiteTest = totalSiteTest + 1;
				TestLogger.info("-------------------------------------------------------------------------------------------");
				TestLogger.info("Checking Site " + nameOfSite);
				TestLogger.info("-------------------------------------------------------------------------------------------");
				//cleanupBrowser("");
				
				// Open web in top sites
				TestLogger.info("Open Site: " + SiteURL);
				
				// Put URL into Address
				startCocCoc();
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep(0.5);
				s.type("t",Key.CTRL);
				s.type(SiteURL);
				s.type(Key.ENTER);
				
				//Open other chapter to make sure that video can be played: very risk, need find other solution
				
				
				// handle for each sites: Output: handlePlayMediaOnWeb(siteName)
			    // 1. Close all ads (if have)
			    // 2. Make sure that media was played on web ( navigate other media if error...)
			    // 3. Move mouse form out of media to media contain. -> make sure detach, download ... appear
				
			     adsHandle.handlePlayMediaOnWeb(nameOfSite);
				
				
				
				//SECTION CHECK AND WIRITE RESULT TO EXCEL FILE
				// Check Media can be detected
				TestLogger.info("------> Check savior feature: ");
			     flag = mediaCanBeDetected(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite);
				 
				 // if savior can't detach Media , Skip testing other savior functions ,
		           if (flag== true)
		           {
		        	   f1 =buttonDownloadIsEnabled(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite,nameOfButtonDownload);
		        	   
					   flag2 = buttonDetachIsDisplayed(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite);
		        	   
		        	   
					   if (flag2==true)
					   {
						   flag2_1 = checkButtonDetachWorksCorrectly(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, sheetAutomationData, nameOfSite);
						   
						   if (flag2_1==true)
							   {
							    f2 =  detachedWindowRestoresCorrectly(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite);
							   }
							   else
							   {
								   controllerExel.writeToCell(pathExcel, sheetFinalResult,
											"FinalResult", NumberInExcel, 9, "N");
									writeContainToTextFile("saviorReport\\detachButtonCanWork.txt",
											nameOfSite, true);
									
									controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
											NumberInExcel, 10, "N");
									writeContainToTextFile("saviorReport\\detachRestore.txt",
											nameOfSite, true);
									
							   }
					   }
					   else { 
						   
						   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
								   NumberInExcel, 8, "N");
						   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
			        			   NumberInExcel, 9, "N/A");
			        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
			        			   NumberInExcel, 10, "N/A");
			        	   
							writeContainToTextFile("saviorReport\\detachButtonDisapears.txt",
									nameOfSite, true);
			        	   
						   System.out.print("FAILURE #2 : Detach doesn't work ,thus, skip detach window function");
						   
					   
					   }
					   
					   
					  flag3 = mediaCanBeDownloaded(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite);
					  
					  if (flag3==true)
					  {
						 
						 f3= checkFileNameCanbeDetectCorrectly(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSong, nameOfSite);
						 f4=  mediaCanBePlayedWellOnLocalMachine(controllerExel,NumberInExcel, pathExcel, sheetFinalResult, nameOfSite);
						
					  }
					  else 
					  
					  { 
						  controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
			        			   NumberInExcel, 3, "N/A");
						  controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
								  NumberInExcel, 4, "N/A");
			        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
			        			   NumberInExcel, 5, "N/A");
							// Note site to collect on report
							writeContainToTextFile("saviorReport\\mediaCanBeDownloaded.txt",
									nameOfSite, true);
			        	   writeContainToTextFile(
			   					"saviorReport\\filenameCanBeDetectedCorrectly.txt",
			   					nameOfSite, true);
			        	   writeContainToTextFile("saviorReport\\mediaCanBePlayedWell.txt",
			        			nameOfSite, true);
			        	   
						  System.out.print("FAILURE #3 : Media can't Download , thus, skip check file name and media can played");
						  
					  }
		           }
		           else 
		           {
		        	   
		        	   System.out.print("FAILURE #1 : Savior can't detach Media, thus, skip other Functions => Tick N/A");
		        	   
		        		controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        				NumberInExcel, 2, "N");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 3, "N/A");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 4, "N/A");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 5, "N/A");

		        		controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        				NumberInExcel, 6,"N");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 7, "N/A");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 8, "N/A");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 9, "N/A");
		        	   controllerExel.writeToCell(pathExcel, sheetFinalResult, "FinalResult",
		        			   NumberInExcel, 10, "N/A"); 
		   
		        	   
		        	
		        	   writeContainToTextFile(
		   					"saviorReport\\downloadMediaButtonEnable.txt", nameOfSite,
		   					true);
		        	   writeContainToTextFile(
			   					"saviorReport\\SaviorCannotDetectMedia.txt", nameOfSite,
			   					true);
		        	   
		        	   
		        	   /*
		        	   writeContainToTextFile("saviorReport\\detachRestore.txt",
		        			   nameOfSite, true);
		        	   writeContainToTextFile("saviorReport\\mediaCanBeDownloaded.txt",
		        			   nameOfSite, true);
		        	   writeContainToTextFile("saviorReport\\detachButtonDisapears.txt",
		        			   nameOfSite, true);
		        	   writeContainToTextFile("saviorReport\\detachButtonCanWork.txt",
		        			   nameOfSite, true);
		        	   writeContainToTextFile("saviorReport\\mediaCanBePlayedWell.txt",
		        			   nameOfSite, true);
		        	   writeContainToTextFile("saviorReport\\filenameCanBeDetectedCorrectly.txt",
		        			   nameOfSite, true); */
		        	   
		        	   
		           
		           }
		           
		           // Check siteFails or sitePassed
		           
		           // SitePASSED when all boolean = true 
		         if ( (f1 && f2 && f3 && f4 && flag && flag2_1 && flag2 && flag3) == true)
		   	    {
		        	 writeContainToTextFile("saviorReport\\sitePassed.txt", nameOfSite,true);
		   	    }
		         // one of boolean results = false ==> siteFailed
		         else
		         {
		        	 writeContainToTextFile("saviorReport\\siteFailed.txt", nameOfSite,true);
		        	
		         }
		   			
		       //====================SECTION: CLEAN UP=====================
					cleanupBrowser("");
		           
			}
			// if Column = ! "Y" , skip test site 
			else
			{
				totalSiteSkip = totalSiteSkip +1;
			}
  
		          
		
		}
	  
		catch (Exception e)
		{
			String folderPath = "";
			int level = 1;
			TestLogger.info("Test script has problem whem execute test on site: " + nameOfSite + "Error:\n " + e.toString());
			captureSnapshot(folderPath, "Error: " + nameOfSite, level);
		}
			
	    // end of for loop 
		
	
	}
		showSaviorReport(totalSiteTest, totalSiteSkip);
		
	}
			


	
	//======================= Special function for 
	private void confirmSaviorVersion() {
		
		if(!checkExtensionVersion("Savior",VersionSavior ))
			setTestcaseStatus("SKIP", "The version of Savior wrong, SKIPT Test");
	}
	
	private void cleanupBrowser(String mediaFileName) {
		clearDownloads();
		closeBrowser();
		killprocess("browser.exe");
		cleanResouces(mediaFileName);
		
	}
	
	
	private void showSaviorReport(int numberOfSiteTest, int numberOfSiteSkip) {
		
		
		
		//get sites that Savior has problem
		String listSitePassed = "\n" + readTextFile("saviorReport\\sitePassed.txt") ;
		String listSiteFailed = "\n" + readTextFile("saviorReport\\siteFailed.txt") ;
		String SaviorCannotDetectMedia = "\n" + readTextFile("saviorReport\\SaviorCannotDetectMedia.txt") ;
		String filenameCanBeDetectedCorrectly = "\n" + readTextFile("saviorReport\\filenameCanBeDetectedCorrectly.txt");
		String mediaCanBeDownloaded = "\n" + readTextFile("saviorReport\\mediaCanBeDownloaded.txt");
		String mediaCanBePlayedWell= "\n" + readTextFile("saviorReport\\mediaCanBePlayedWell.txt");
		String downloadMediaButtonEnable = "\n" + readTextFile("saviorReport\\downloadMediaButtonEnable.txt");
		String detachButtonDisapears = "\n" + readTextFile("saviorReport\\detachButtonDisapears.txt");
		String detachButtonCanWork = "\n" + readTextFile("saviorReport\\detachButtonCanWork.txt");
		String detachRestore = "\n" + readTextFile("saviorReport\\detachRestore.txt");
		
		//show report
		TestLogger.info("======================FINIAL REPORT: =======================");

		TestLogger.info("Total site tested: " + numberOfSiteTest);
		TestLogger.info("Total site skiped: " + numberOfSiteSkip);
		TestLogger.info(" Total site passed: " + listSitePassed );
		TestLogger.info(" Total site failed: " + listSiteFailed );
		TestLogger.info("=============Savior problem details=================== ");
		TestLogger.info(" - Media can NOT be detected and Savior icon is NOT enabled when media is played: " + SaviorCannotDetectMedia);
		TestLogger.info(" - Filename can NOT be detected correctly: " + filenameCanBeDetectedCorrectly);
		TestLogger.info(" - Media can NOT be downloaded: " + mediaCanBeDownloaded);
		TestLogger.info(" - Downloaded media can NOT be played well on local machine: " + mediaCanBePlayedWell);
		TestLogger.info(" - Download button is NOT enabled when media is played: " + downloadMediaButtonEnable);
		TestLogger.info(" - Detach button DOES NOT appear on hover: " + detachButtonDisapears);
		TestLogger.info(" - Detach button DOES NOT work correctly: " + detachButtonCanWork);
		TestLogger.info(" - Detached window DOES NOT restore correctly: " + detachRestore);
		sleep (15);
		
		// Chay xong Tat May 
		/* s.type("d", Key.WIN);
		s.type("r", Key.WIN);
		sleep(3);
		s.type(Key.BACKSPACE);
		typeTextOn("shutdown -s -t 00");
		typeTextOn(Key.ENTER);
		sleep(10); */
	}
}
