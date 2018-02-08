package browser_Testsuite_Others;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.sikuli.script.Key;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import browser_Framework.BrowserCommon_Extensions;
import browser_Framework.ExcelFileController;
import browser_Framework.TestLogger;

public class FeatureRequest_checkLinkDemoSkins extends BrowserCommon_Extensions {
	HSSFWorkbook excelFile;
	HSSFSheet sheetFinalResult,sheetAutomationData;
	HSSFCell cell;
	String result;
	ExcelFileController controllerExel;
	String pathExcel;
	int totalTest=0, totalLinkNotNavigate = 0, totalLinkFailed = 0, totalLinkOK= 0;
	int toltalSite = 175;
	String Url ="", domain ="", bannerImage="", listLinkFailedOpen = "", listLinkFailedNavigate = "", listLinkOK = "",  bannerPath = "", bannerButt = "", bannerButton = "" , Status =" ";
	String coccocPath = System.getenv("LOCALAPPDATA") + "\\CocCoc\\Browser\\Application\\browser.exe";
	
	@BeforeTest
	public void preConditionTest(){
		TestLogger.info("==========================Feature request: Check links demo skins=================================");
		try{
			//define excel file to test
			controllerExel = new ExcelFileController();
			pathExcel = getResource("pictures\\Banner\\dataTest.xls");
			excelFile = controllerExel.getExcelFile(pathExcel);
			sheetAutomationData = controllerExel.getSheetFromExcelFile(excelFile, "Data");
		}
		catch(Exception e){
			setTestcaseStatus("SKIPED", "Skiped test due " + e.toString());
		}
		
	}
	@Test
	public void testSuite() throws IOException{
	
		for(int line = 1; line < toltalSite ; line++)
		{
			try{
		
				setClipboardValue(null);
				//Get links & image names from excel file
				Url = controllerExel.getCellFromSheet(sheetAutomationData, line, 1).getStringCellValue();
				domain = controllerExel.getCellFromSheet(sheetAutomationData, line,0).getStringCellValue();
				bannerImage = controllerExel.getCellFromSheet(sheetAutomationData, line, 2).getStringCellValue();
				bannerButt = controllerExel.getCellFromSheet(sheetAutomationData, line, 3).getStringCellValue();
				bannerPath = "pictures\\Banner\\" + bannerImage + ".png";
				bannerButton = "pictures\\Banner\\" + bannerButt + ".png";
				sheetFinalResult = controllerExel.getSheetFromExcelFile(excelFile, "Data");
				TestLogger.info("---------------------------------------------------------------------------------------------------------");
				TestLogger.info("Link to test: " + Url + "\t--> Vender: " + domain);
				
				//Open browser
				//clearDownloadPage();
				// startCocCoc();
				//Kill old Coccoc
				killprocess("browser.exe");
				s.type(Key.UP);
				sleep(1);
				s.type("d", Key.WIN);
				sleep(0.5);
				s.type(Key.UP);
				sleep(1);
				s.type(Key.UP);
				
				// start with default profile
				if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 3))
				{
					doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
					sleep (1);
					s.type(Key.UP, Key.WIN);
				}
				else {
					s.type(Key.WIN);
					sleep(1);
					s.type(coccocPath);
					sleep(1);
					s.type(Key.ENTER);
				}
				
				
				openLink(Url);
				s.type(Key.F5);
				//Confirm banner displayed on Newtab
			   if(waitForObjectPresent(bannerPath, 18)){
				   if (line ==1) 
				     {
					     waitForObjectPresent("pictures\\Banner\\lazada_Button.png", 10);
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 150);
						 s.click();  
				     } 
				   else if (line ==26)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
						 s.click(); 
				     }
				     else if (line ==48)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
						 s.click(); 
				     }
				   	else if (line ==61)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
						 s.click(); 
				     }
				     else if (line ==66)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 255);
						 s.click(); 
				     }
				     else if (line ==89)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==90)
				     {
				    	 moveMouseDownFromLogo("pictures\\pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==91)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==92)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				  
				     else if (line ==93) 
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click();  
				     } else if (line ==94)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==95)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==96)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     else if (line ==97)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				 
				   
				     else if (line ==98) 
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click();  
				     } else if (line ==99)
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
						 s.click(); 
				     }
				     
				     else
				     {
				    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 410);
						 s.click(); 
				     }
					
					
					
					if  (domain.contains("vnfbs.com"))
					{
						
					    waitForObjectPresent("pictures\\Banner\\alert_fbs.png",3);
						clickOn("pictures\\Banner\\allow_fbs.png");
						
					}
					
					if  (domain.contains("Tiki.vn") || domain.contains("tiki.vn")  )
					{
						
					    waitForObjectPresent("pictures\\Banner\\alert.png",13);
					
					    clickOn("pictures\\Banner\\allow.png");

					}
					
					if  (domain.contains("facebook.com/bitisshoes"))
					{
					    waitForObjectPresent("pictures\\Banner\\face.png",3) ;
					 
						clickOn("pictures\\Banner\\close_face.png");
						
					}
					
					sleep(4);
					s.type(Key.F6);
					sleep(5);
					s.type("c", Key.CTRL);
					
					TestLogger.info("===> Domain is : " + getClipboardValue());
					
					if(getClipboardValue().contains(domain)){
						
						listLinkOK = listLinkOK + "\n\t- " + Url;
						totalLinkOK = totalLinkOK + 1;
						
					    controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "OK");
						
						TestLogger.info("The link:  " + Url + " is OK");
					}
					
					else{
						listLinkFailedNavigate = listLinkFailedNavigate + "\n\t- " + Url;
						totalLinkFailed = totalLinkFailed + 1;
						controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "NOK");
						
						captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/DemoSkins/", "ScreenShotSkinNotNavigate" , 1);
						TestLogger.warn("The URL: " + Url + " doesn't navigate to domain site");
					}
				}
			   else
			   {
				    int j =1; 
				// Re-run 3 times to check if that Skin banner on that URL is working or not ..
					do 
					{
						j++ ;
						openLink (Url) ;
					} 
					while (!waitForObjectPresent(bannerPath, 6) && (j < 3)) ;
					
					 if(waitForObjectPresent(bannerPath, 6)){
						   if (line ==1) 
						     {
							     waitForObjectPresent("pictures\\Banner\\lazada_Button.png", 10);
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 150);
								 s.click();  
						     } 
						   else if (line ==26)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
								 s.click(); 
						     }
						     else if (line ==48)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
								 s.click(); 
						     }
						   	else if (line ==61)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 340);
								 s.click(); 
						     }
						     else if (line ==66)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 255);
								 s.click(); 
						     }
						     else if (line ==89)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==90)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==91)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==92)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						  
						     else if (line ==93) 
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click();  
						     } else if (line ==94)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==95)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==96)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     else if (line ==97)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						 
						   
						     else if (line ==98) 
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click();  
						     } else if (line ==99)
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 330);
								 s.click(); 
						     }
						     
						     else
						     {
						    	 moveMouseDownFromLogo("pictures\\Banner\\searchbox.png", 410);
								 s.click(); 
						     }
							
							
							
							if  (domain.contains("vnfbs.com"))
							{
								
							    waitForObjectPresent("pictures\\Banner\\alert_fbs.png",3);
								clickOn("pictures\\Banner\\allow_fbs.png");
								
							}
							
							if  (domain.contains("tiki.vn"))
							{
								
							    waitForObjectPresent("pictures\\Banner\\alert.png",3);
							
							    clickOn("pictures\\Banner\\allow.png");

							}
							
							if  (domain.contains("facebook.com/bitisshoes"))
							{
							    waitForObjectPresent("pictures\\Banner\\face.png",3) ;
							 
								clickOn("pictures\\Banner\\close_face.png");
								
							}
							
							sleep(4);
							s.type(Key.F6);
							sleep(5);
							s.type("c", Key.CTRL);
							
						
							if(getClipboardValue().contains(domain)){
								listLinkOK = listLinkOK + "\n\t- " + Url;
								totalLinkOK = totalLinkOK + 1;
								
							    controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "OK");
								
								TestLogger.info("The link:  " + Url + " is OK");
							}
							
							else{
								listLinkFailedNavigate = listLinkFailedNavigate + "\n\t- " + Url;
								totalLinkFailed = totalLinkFailed + 1;
								controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "NOK");
								
								captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/DemoSkins/", "ScreenShotSkinNotNavigate" , 1);
								TestLogger.error("The URL: " + Url + " doesn't navigate to domain site after ");
							}
			   }
				else{
					// totalLinkFailed = totalTest;
					listLinkFailedOpen = listLinkFailedOpen + "\n\t- " + Url;
					totalLinkFailed = totalLinkFailed + 1;
					controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "NOK");
					captureSnapshot(System.getProperty("user.home") + "/Desktop/screenShot/DemoSkins/", "ScreenShotLinkCannotOpen", 1);
					TestLogger.warn("Cannot open link " + Url + " or video/skins not dislay correctly");
				}
			  }
			}
			catch(Exception e){
				totalLinkFailed = totalLinkFailed + 1;
				controllerExel.writeToCell(pathExcel, sheetFinalResult, "Data", line, 4, "NOK");
				TestLogger.warn("Not test this link due:\t" + e.toString());
				
			}
		}
		
		
		
		TestLogger.info("\n========================================FINAL TEST REPORT======================================================");
		
		totalTest = totalLinkOK + totalLinkFailed ;
		TestLogger.info("Total link test " +  totalTest );
		
		TestLogger.info("Link OK: "+ totalLinkOK );
		TestLogger.info("Link NOK: "+ totalLinkFailed );
		
		TestLogger.info("=========== No.Links OK:  "  + totalLinkOK + "  ======== :  \n");
		
		for ( int k = 1; k < toltalSite ; k++)
		{
			if (controllerExel== null)
			{
				setTestcaseStatus("FAILED", "==> FAILED NULL ");
			}
			Status = controllerExel.getCellFromSheet(sheetAutomationData, k, 4).getStringCellValue();
			if (Status.equalsIgnoreCase("OK"))
			{
				Url = controllerExel.getCellFromSheet(sheetAutomationData, k, 1).getStringCellValue();
				TestLogger.info(Url);
			}
		}
		
		
		
		TestLogger.info("\n =========== No.Links FAILED :" + totalLinkFailed + "======== :  \n");
		
		for ( int k = 1; k < toltalSite ; k++)	
		{
			if (controllerExel== null)
			{
				setTestcaseStatus("FAILED", "==> FAILED NULL ");
			}
			
			Status = controllerExel.getCellFromSheet(sheetAutomationData, k, 4).getStringCellValue();
			
			if (Status.equalsIgnoreCase("NOK"))
			{
				Url = controllerExel.getCellFromSheet(sheetAutomationData, k, 1).getStringCellValue();
				TestLogger.info(Url);
				
			}
		}
	}
	

	
}