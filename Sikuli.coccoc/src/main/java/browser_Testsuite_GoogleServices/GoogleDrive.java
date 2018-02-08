package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleDrive extends BrowserCommon {
	
	@Test
	public void GoogleServices_GoogleDrive_01()
	{
		  
		   TestLogger.info("1. Open Google Driver page (https://www.google.com/drive/)");
		   // startCocCocInEnglish();
		   // SigninToCocCoc(userNameGmail4, passwordGmail4);
		   //closeBrowser();
		  // startCocCoc();
		  
		    openLink("https://www.google.com/drive/");
		   TestLogger.info("2. Observe on Google Driver page"); 
		   TestLogger.info("Expect : Must show logo Google Drive and Button 'Go to Google Drive'");
		   if (waitForObjectPresent("pictures\\Website_GoogleDrive_logo_GoogleDrive.png", 4) || (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveVN.png", 3)) || (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_AccessToGoogleDriveEN.png", 3)))
		   {
			  
			   //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
			   setTestcaseStatus("PASSED", "Showed logo Google Drive and Button 'Go to Google Drive"); 
		   }
		   else
		   {
			   //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
			   setTestcaseStatus("FAILED", "DO NOT Show logo Google Drive and Button 'Go to Google Drive"); 
		   }
		   
		   
		   
	} 
	
	
	@Test
	public void GoogleServices_GoogleDrive_02()
	{
		TestLogger.info("1. Access on Google Drive page :  https://drive.google.com/drive/my-drive"); 
		startCocCoc();
		openLink("https://drive.google.com/drive/my-drive"); 
		TestLogger.info("2. Click on options on the left menu ");
		TestLogger.info("Expect :  Must show correct pages after clicking on the options on the menu.");
		clickOn("pictures\\Website_GoogleDrive_menu_MyDrive.png");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_MyDrive.png", 5))
		{
		
			setTestcaseStatus("PASSED", "Showed My Drive page after click on My Driver option"); 
			
		}
		else
		{
			
			setTestcaseStatus("PASSED", "Do NOT Show My Drive page after click on My Driver option"); 
		}
		
		// Click on options Computer 
		clickOn("pictures\\Website_GoogleDrive_menu_Computers.png");
		 
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_computer.png", 5))
		{
			setTestcaseStatus("PASSED", "Showed Computers page after click on Computers option"); 
			
		}
		else
		{
			setTestcaseStatus("PASSED", "Do NOT Show Computers page after click on Computers option"); 
		}
		
		// Click on options Shared with me 
		  clickOn("pictures\\Website_GoogleDrive_menu_SharedWihMe.png");
		 if (waitForObjectPresent("pictures\\Website_GoogleDrive_text_SharedWithMe.png", 5))
		{
				setTestcaseStatus("PASSED", "Showed Shared With Me page after click on Shared with Me option"); 
				
		}
		 else
		{
				setTestcaseStatus("PASSED", "Do NOT Shared with me page after click on Shared with Me option"); 
		}
		 
		 //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
		 
		
	}
	
	@Test
	public void GoogleServices_GoogleDrive_03()
	{
		
		TestLogger.info("1. Access page : https://drive.google.com/drive/my-drive ");
		startCocCocInEnglish();
		openLink("https://drive.google.com/drive/my-drive ");
		sleep (20);
		TestLogger.info("2. Click on New Button");
		clickOn("pictures\\Website_GoogleDrive_Button_New.png");
		TestLogger.info("3. Choose Upload file");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_button_uploadFile.png", 2))
		{
		clickOn("pictures\\Website_GoogleDrive_button_uploadFile.png");
		}
		else
		{
			clickOn("pictures\\Website_GoogleDrive_button_uploadFileEN.png");
		}
		
		TestLogger.info("4. Choose a file to upload");
		
		clickOn("pictures\\Website_GoogleDrive_folfer_Downloads.png");
		s.type(Key.TAB);
		s.type(Key.TAB);	
		sleep(5);
		s.type("coccoc_vi.exe");
		s.type(Key.ENTER);
		s.type(Key.ENTER);
		TestLogger.info("Expect : File must be uploaded successfully ");
		sleep(120);
		
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_OK.png", 15))
		{
			 //exit browser
			closeBrowser();
			if (waitForObjectPresent("pictures\\Website_GoogleDrive_Button_Leave.png", 5))
			{
			clickOn("pictures\\Website_GoogleDrive_Button_Leave.png");
			}
			
			setTestcaseStatus("PASSED", "File is uploaded successfully");
		}
		else
		{
			 //exit browser
			closeBrowser();
			setTestcaseStatus("FAILED", "File is NOT uploaded successfully");
		}
			
	}
	
	@Test
	public void GoogleServices_GoogleDrive_04()
	{
		
		TestLogger.info("1. Access page : https://drive.google.com/drive/my-drive ");
		startCocCocInEnglish();
		openLink(" https://drive.google.com/drive/my-drive");
		sleep (25);
		TestLogger.info("2. Choose an file to edit");
		clickOn("pictures\\Website_GoogleDrive_file_coccoc_vi.png");
		s.type(Key.CONTEXT);
		TestLogger.info("3. Add or change title of file ");
		clickOn("pictures\\Website_GoogleDrive_Submenu_Rename.png");
		sleep (5);
		s.type("coccoc");
		s.type(Key.ENTER);
		TestLogger.info("Expect :  Content and title of File must be changed successfully");
		if (waitForObjectPresent("pictures\\Website_GoogleDrive_File_Coccoc.png", 4))
		{
			clickOn("pictures\\Website_GoogleDrive_File_Coccoc.png");
			s.type(Key.CONTEXT);
			clickOn("pictures\\Website_GoogleDrive_submenu_Remove.png");
			setTestcaseStatus("PASSED", "Content and title of File is changed successfully");
		}
		else
		{
			setTestcaseStatus("FAILED", "Content and title of File is NOT changed successfully");
		}
			
		
	}
	

}
