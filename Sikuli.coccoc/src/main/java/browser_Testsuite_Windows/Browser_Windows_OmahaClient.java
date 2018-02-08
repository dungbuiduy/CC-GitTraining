package browser_Testsuite_Windows;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class Browser_Windows_OmahaClient extends BrowserCommon {

	public String userprofile = System.getenv("USERPROFILE");
	private String[] CocCocVersion = getCocCocVersion("config\\coccocVersion.txt");
	String OmahaNewVersion = CocCocVersion[2];
	
	 

	/**
	 * 
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Plugins_02</br>
	 * Pre-condition: old omaha is installed (2.5.15.33)
       Steps:
       1. Install browser which contains old omaha  (e.g. 2.5.15.33)
       2. Add Host as dev environment
       3. Open folder: C:\Users\[account]\AppData\Local\CocCoc\Update
       4. Open command line, go to Coccoc update folder:
       CocCocUpdate.exe /ua

     * Expect : 
     *'3. User will see a folder names 2.5.15.33 - that's current Omaha version 
       4. By this command, Omaha client will check if there is newer version on server. If there is newer version (Omaha or Browser), download and install process will happen. 
      - Omaha will update to ver. 2.5.15.34: a folder name  2.5.15.34 is generated
       - 2.5.15.33 folder is empty
       - All files from folder 2.5.15.33 is copied to folder 2.5.15.34
	 */
	@Test
	public void Browser_SMOKE_Plugins_02(){
		TestLogger.info("----------------------------TEST SNIFF FOR OmahaClient----------------------");
		changeHoststoProduction();
		startUninstallCocCoc(true);
		downloadFileByFirefox("ftp://browser3v.dev.itim.vn/corom/52.4.2743.242/installers/standalone_coccoc_vi.exe"); 
		File f= new File (userprofile + "\\Downloads\\" + "standalone_coccoc_vi.exe"); 
		boolean flag1= false, flag2= false,flag3 =false , available = false ;
	
	    InstallCoccocWithDefaultOption(f.getAbsolutePath()); 
			
			 TestLogger.info("2.Open folder: C:\\Users\\[account]\\AppData\\Local\\CocCoc\\Update");
			 TestLogger.info("2.Expect : User will see a folder names 2.5.15.25 - that's current Omaha version ");
		       File f1 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update") ;
			 
				if (f1.isDirectory())
				{
					File[] files = f1.listFiles();
					 
					for (File file : files) 
					{
						if (file.isDirectory() && (file.getName().equalsIgnoreCase("2.5.15.25")))
						{
							flag1= true ;
						}
					}
					   
				}
				
				if (flag1= true) 
				{
					 setTestcaseStatus("PASSED", "User see a folder names 2.5.15.25 - that's current Omaha version");
				}
					
				else
			    {
			    	 setTestcaseStatus("FAILED", "User DOES see a folder names 2.5.15.25 - that's current Omaha version");
			    }
				
				
			// If New Ohama Client version  = Old version , Skip this Test case 
			if (OmahaNewVersion.equalsIgnoreCase("2.5.15.25"))
			{
				TestLogger.info(" There is NOT newer version (Omaha or Browser) now !");
				TestLogger.info(" Lastest Ohama Version is 2.5.15.25 " );
				setTestcaseStatus("SKIPPED", "SKIPPED because ==> There is NOT newer version (Omaha Client) now ");
			}
			// if New Ohama Client Version is > Old version ,continue checking this test case 
			else
			{
			 TestLogger.info("2. Add Host as dev environment");
			 changeHoststoDev();
				
			  TestLogger.info(" 3. Open command line, go to Coccoc update folder:  ,type command : CocCocUpdate.exe /ua");	
			    s.type("r", Key.WIN) ;
				sleep (1);
				s.type("cmd");
				s.type(Key.ENTER) ;
				sleep (1);
				s.type("cd  " + f1.getAbsolutePath());
				s.type(Key.ENTER);
				sleep (1);
				
				s.type("CocCocUpdate.exe/ua");
				s.type(Key.ENTER);
				s.type("exit");
				s.type(Key.ENTER);
				sleep (25);
			
				 File f2 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update"); 
				 File[] total = f2.listFiles();
				
					 for (File file : total) 
					  {
						  sleep (25) ;
						  TestLogger.info("Still is waiting for folder created !! ");
						  if (file.getName().equalsIgnoreCase(OmahaNewVersion))
						  {
							  available = true;
						  }
					   } 
				
				 
				 
				 if (available= true) 
				 {
					 setTestcaseStatus("PASSED", " The new version of Omaha"  + OmahaNewVersion + "  was generated");
				 }
				 else
				 {
					 setTestcaseStatus("FAILED", "  The new version of Omaha"  + OmahaNewVersion + " NOT  was generated");
				 }
				
				
		    File f3 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update"); 
			File[] files = f3.listFiles();
			
			for (File file : files)
			{
				// Check that all files from folder 2.5.15.25 is copied to New Omaha folder 
				if (file.getName().equalsIgnoreCase(OmahaNewVersion) && file.listFiles().length> 0) 
				{
					flag2 = true ;
				} 
				// Check that Folder : 2.5.15.25  is empty
				if (file.getName().equalsIgnoreCase("2.5.15.25") && file.listFiles().length == 0) 
				{
					flag3 = true ;
				} 
				
			}
			
			if (flag2 = true)
			{
				 setTestcaseStatus("PASSED", "All files from folder 2.5.15.25 is copied to folder " + OmahaNewVersion);
			}
			
			else
    		{
    			setTestcaseStatus("FAILED", "All files from folder 2.5.15.25 is NOT copied to folder "  + OmahaNewVersion);
    		} 
			
		
		    if (flag3 = true )
		    {
		    	setTestcaseStatus("PASSED", " 2.5.15.25 folder is empty");
		    }
		    else
		    {
		    	setTestcaseStatus("FAILED", " 2.5.15.25 folder is NOT empty");
		    }
		    
	   }
	}
	
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Plugins_01</br>
	 *1. Install CC Browser on clean machine
      2. Check browser version via "About us"
      3. Check Omaha Client from path:
      C:\Users\<Account_Login_Windows>\AppData\Local\CocCoc\Update
           + find folder named (ex: 2.5.15.33)
           + Right click on file CocCocUpdate.exe => select tab "Details" => find "Product version"
          Expect : 
           '1. Make sure that CC Browser is installed successfully.
            No error message found
            2 & 3. Browser version and Omaha version are correct
	 */
	@Test
	public void Browser_SMOKE_Plugins_01(){
		
		 TestLogger.info("Check if CocCoc Browser is installed normally with new Omaha");
		 if (OmahaNewVersion.equalsIgnoreCase("2.5.15.25"))
		 {
			 TestLogger.info("There is No New Ohama Client version ! ");
			 setTestcaseStatus("SKIPPED", "Skip this testcase because => There is No New Ohama Client version");
		 }
		 else
		 {
			 
		 changeHoststoDev();
		 startUninstallCocCoc(true);
		 TestLogger.info("1. Install CC Browser on clean machine");
		 downloadFileByFirefox("http://coccoc.com/vi/win/thanks.html");
		 File f= new File (userprofile + "\\Downloads\\" + "coccoc_vi.exe"); 
		 InstallCoccocWithDefaultOption(f.getAbsolutePath()); 
	     TestLogger.info("2. Check browser version via 'About us'");
	     startCocCoc();
		 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
	     s.type("coccoc://version");
	     s.type("f", Key.CTRL);
	     s.type(CocCocVersion[1]);
	     TestLogger.info("EXPECT : 2  Browser version is correct ");
	     if (waitForObjectPresent("pictures\\Browser_About_text_ConfirmVersionBrowser.png", 5))
	     {
	    	 setTestcaseStatus("PASSED", ". Browser version is correct");
	     }
	     else
	     {
	    	 setTestcaseStatus("FAILED", ". Browser version is NOT correct");
	     }
	    
	      TestLogger.info(" Check Omaha Client from path: C:\\Users\\<Account_Login_Windows>\\AppData\\Local\\CocCoc\\Update + find folder named (ex: 2.5.15.25)");
	      File f1 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update\\" + OmahaNewVersion) ;
	      if (f1.exists())
	    	  
	        s.type("r", Key.WIN) ;	
			sleep (1);
			s.type(f1.getAbsolutePath());
			s.type(Key.ENTER) ;
			sleep (1);
			s.type(Key.UP, Key.WIN) ;
			TestLogger.info("EXPECT : 3. Check that Omaha version is correct ");
			if (waitForObjectPresent("pictures\\Browser_Omaha_file_Update.png", 5)) 
			{
				hoverImage("pictures\\Browser_Omaha_file_Update.png");
				rightClick("pictures\\Browser_Omaha_file_Update.png");
				clickOn("pictures\\Browser_Ohama_Menu_Property.png");
				clickOn("pictures\\Browser_Ohama_Menu_details.png") ;
				
				
				if (waitForObjectPresent("pictures\\Browser_Ohama_Text_Version.png", 5))
				{
				   setTestcaseStatus("PASSED", "Omaha version is correct");
				}
				else
				{
					setTestcaseStatus("FAILED", "Omaha version is NOT correct");
				
				}
			}
			
	  }
	}
	/**
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Plugins_04</br>
	 * 1. Uninstall CC Browser
       2. Go to path:
       C:\Users\<Account_Login_Windows>\AppData\Local\CocCoc\
       Expect:
       1. Make sure that CC Browser is uninstalled successfully.
          No error message found
       2. Folder "Update" should be deleted
          Folder "CrashReport" is kept
	 */
	@Test
	public void Browser_SMOKE_Plugins_04(){
		 TestLogger.info("==== Check if CocCoc Browser is uninstalled normally with new Omaha =====");
		 
		 if (OmahaNewVersion.equalsIgnoreCase("2.5.15.25"))
		 {
			 TestLogger.info("There is No New Ohama Client version ! ");
			 setTestcaseStatus("SKIPPED", "Skip this testcase because => There is No New Ohama Client version");
		 }
		 else
		 {
		 boolean check1 = false;
		 boolean check2 = false;
	     TestLogger.info("1. Uninstall CC Browser");
	     startUninstallCocCoc(true);
	     TestLogger.info("2.Go to path: C:\\Users\\<Account_Login_Windows>\\AppData\\Local\\CocCoc\\");
	     TestLogger.info("EXPECT : Folder Update' should be deleted");
	     File f1 = new File (userprofile +"\\AppData\\Local\\CocCoc");
	     if (f1.isDirectory())
	     {
	    	 File[] listFile = f1.listFiles();
	    	 
	    	 for (File name : listFile)
	    	 {
	    		 
	    		 if (name.getName().equalsIgnoreCase("Update"))
	    		 {
	    			 check1= true;
	    			 
	    		 }	
	    		 
	    		 if (name.getName().equalsIgnoreCase("CrashReports"))
		    		 
	    		 {
		    		 check2= true ;
	    			
	    		 }
	    		
	    	 }
	    	 // Check Folder Update' be deleted
	    	 if (check1= true)
	    	 {
	    		 
	    		 setTestcaseStatus("FAILED", "Folder Update' NOT be deleted");
	    	 }
	    	 else
	    	 {
	    		 setTestcaseStatus("PASSED", "Folder Update' be deleted");
	    	 }
	    	 
	    	
	    	 // Check Folder CrashReport is kept
	    	 if (check2= true)
	    	 {
	    		 setTestcaseStatus("PASSED", "Folder CrashReport is kept");
	    	 }
	    	 else
	    	 {
	    		 setTestcaseStatus("FAILED", "Folder CrashReport is not kept"); 
	    	 }
	     }
	     
	  }
	     
		
	} 
	
	
	/**
	 * Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Plugins_03</br>
	 * Pre-condition: Make sure that there was an old version of CC Browser with old Omaha is installed on machine (Ex: CC ver. 58.3.130, Omaha 2.5.15.15)

       1. Check Browser version: coccoc://version
          Check Omaha version from path:
           C:\Users\<Account_Login_Windows>\AppData\Local\CocCoc\Update

       2. Add Host as DEV environment
       3. Open CocCoc Browser >  check "About us": coccoc://help/
       4. Restart CC Browser by clicking "Relaunch" button
       Expect : 
        1. - Browser is old version (in this example is 58.3.130) 
           - The new version of Omaha (2.5.15.25) should be generated 
           - All file from old Omaha folder are copied into new Omaha folder
           - Old Omaha folder (2.5.15.15) is empty

        3.  CocCoc Browser is updated successfully to lastest version
            No error message found
        4. After relaunched, CC Browser should be started normally and upgrade to lastest version.
	 */
	@Test
	public void Browser_SMOKE_Plugins_03(){
	
		boolean Ok = false ;
		File fileOnDownload = new File(userprofile + "\\Downloads");
	    deleteAllFilesinFolder(fileOnDownload);
		changeHoststoProduction();
		
		TestLogger.info("Browser_SMOKE_Plugins_03");
		TestLogger.info("========Check if CocCoc Browser is updated normally with new Omaha========");
		
		TestLogger.info("'Pre-condition: Make sure that there was an old version of CC Browser with old Omaha is installed on machine (Ex: CC ver. 58.3.130, Omaha 2.5.15.15)");
		
		startUninstallCocCoc(true);
		downloadFileByFirefox("ftp://browser3v.dev.itim.vn/corom_from2v/52.3.2743.130/installers/standalone_coccoc_vi.exe"); 
		File f= new File (userprofile + "\\Downloads\\" + "standalone_coccoc_vi.exe"); 
	    // install old version
		InstallCoccocWithDefaultOption(f.getAbsolutePath()); 
		
		if ( waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 60))
		{
		 clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png"); 
		 s.type("w", Key.CTRL + Key.SHIFT);
		 
		}
	    // Check Omaha is old version 
		 File f1 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update"); 
		 File[] totalFiles = f1.listFiles();
		  for (File file : totalFiles) 
		  {
			  if (file.getName().equalsIgnoreCase("2.5.15.15"))
			  {
				  Ok = true;
			  }
		  }
			
		if (Ok ==true) 
		{
			setTestcaseStatus("PASSED", "Omaha is correct Version (2.5.15.15)! ");
			
		}
		else
		{
			setTestcaseStatus("FAILED", "Omaha is NOT correct Version (2.5.15.15 )! ");
		}
		// Change Host to Dev 
		changeHoststoDev();  
		
		TestLogger.info(" Open command line, go to Coccoc update folder:");	
	    s.type("r", Key.WIN) ;
		sleep (1);
		s.type("cmd");
		s.type(Key.ENTER) ;
		sleep (1);
		s.type("cd  " + f1.getAbsolutePath());
		s.type(Key.ENTER);
		sleep (1);
		s.type("CocCocUpdate.exe/ua");
		s.type(Key.ENTER);
		
		 File folder1 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update"); 
		 File[] totalFilez = folder1.listFiles();
		 
			 for (File files : totalFilez) 
			  {
				  sleep (20) ;
				  TestLogger.info("Still is waiting for folder created !! ");
				  if (files.getName().equalsIgnoreCase("2.5.15.25"))
				  {
					  if(files.listFiles().length>0)
					  {
					  Ok = true;
					  }
				  }
			   } 
		
		 
		 if (Ok= true) 
		 {
			 setTestcaseStatus("PASSED", " The new version of Omaha (2.5.15.25) are be generated & - All file from old Omaha folder are copied into new Omaha folder");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", " The new version of Omaha (2.5.15.25) is NOT be generated & - All file from old Omaha folder are NOT copied into new Omaha folder");
		 }
		
		 
		 File folder2 = new File (userprofile +"\\AppData\\Local\\CocCoc\\Update\\2.5.15.15"); 
		 
		 if (folder2.listFiles().length==0)
		 {
			 setTestcaseStatus("PASSED", "Old Omaha folder (2.5.15.15) is empty");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "Old Omaha folder (2.5.15.15) is NOT empty");
		 }
		 
		
		 
	} 
	
	
	/**
	 * 
	 * <b> Browser_Smoke_TestCase_Windows_v1.9.2_AUTO-CONTROL </b> </br>
	 * <b> CaseID: </b>Browser_SMOKE_Plugins_06</br>
	 * Check if there is only one CocCocSeeder.exe run in task manager . 
	 *
       Steps:
      '1. Open folder: C:\Users\[account]\AppData\Local\CocCoc\Update
       2. Access Omaha folder
       3. Open Task Manager
       4. Try to run CocCocSeeder.exe

     * Expect : 
       '2. Make sure that user is able to see file name CocCocSeeder.exe
        3 &4. There is one CocCocSeeder.exe run in task manager
	 */
	@Test
	public void Browser_SMOKE_Plugins_06(){
		TestLogger.info("Browser_SMOKE_Plugins_06");
		TestLogger.info("========Check if there is only one CocCocSeeder.exe run in task manager .========");
		 if (OmahaNewVersion.equalsIgnoreCase("2.5.15.25"))
		 {
			 TestLogger.info("There is No New Ohama Client version ! ");
			 setTestcaseStatus("SKIPPED", "Skip this testcase because => There is No New Ohama Client version");
		 }
		 else
		 {
			 
		 changeHoststoDev();
		 startUninstallCocCoc(true);
		 TestLogger.info("1. Install CC Browser on/ clean machine");
		 downloadFileByFirefox("http://coccoc.com/vi/win/thanks.html");
		 File f= new File (userprofile + "\\Downloads\\" + "coccoc_vi.exe"); 
		 InstallCoccocWithDefaultOption(f.getAbsolutePath()); 
		 // Check Make sure that user is able to see file name CocCocSeeder.exe
		
		 File fCocCocSeeder = new File(userprofile + "\\AppData\\Local\\CocCoc\\Update\\CocCocSeeder.exe");
		 if (fCocCocSeeder.exists() && fCocCocSeeder.isFile())
		 {
			 setTestcaseStatus("PASSED", "User is able to see file name CocCocSeeder.exe");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", " User is NOT able to see file name CocCocSeeder.exe");
		 }
		 
		 // Check that there is one CocCocSeeder.exe run in task manager
		 List<String> processes = listRunningProcesses();
	      String result = "";

	      // display the processes in TaskManager
	      Iterator<String> it = processes.iterator();
	      while (it.hasNext()) {
	         result += it.next() +",";
	   
	         System.out.println("Running processes : " + result);
	         
	         if (result.equalsIgnoreCase("CocCocSeeder.exe"))
	         {
	        	 setTestcaseStatus("PASSED", "There is one CocCocSeeder.exe run in task manager");
	         }
	         else
	         {
	        	 setTestcaseStatus("FAILED", "There is  NOT CocCocSeeder.exe run in task manager");
	         }
	      }
	     
		 
	   }
		 
    }  
}
