package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class SigninAndSyn extends BrowserCommon {
  
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_01 </br>
	 * <b> CaseTitle: </b>Check UI for Sign-in in general page..</br>
	 * <b> Steps: </b>
	 * 1. Install latest CocCoc browser.
       2. Start CocCoc browser.
       3. Observe on Omnibox.
       4. Click user button beside minimize buton.
       5. Click on "Ðang nh?p vào C?c C?c" ("Sign-in to C?c C?c for EN version).
       6. Click on back button.
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	 *  #3: The user button locate beside minimize button.
        #4:  - A modal box appears to info current user (cá nhân 1/persional 1).
         3 Buttons must display : 
         + "Ðang nh?p vào C?c C?c" (Signin to C?c C?c" for EN version).
         +  Chuyê?n dô?i nguo`i 
         +  Truy câ?p â?n danh
        #5: The Sign-in modal appears allow user login to Google account.
      - Back button on the top left.
      - Google logo.
      - text: "Thêm tài kho?n Google c?a b?n"/"Add your Google account".
      - User's avatar.
      - Username/password textbox.
      - Sign-in-button.
      - "Need help ?" and "Create an account" link.
        #6: A modal box appears again. </br>
	 
	 
	 * @author hanv
	
	 */
	
	//@BeforeTest
	public void switchToUILoginByGoogle ()
	   {
		   
		   switchToUILoginByGoogle();
		   
	   }
	
	@Test
	public void GoogleServices_Signin_Sync_01()
	{
		TestLogger.info("GoogleServices_Signin_Sync_01");
		
		startCocCocInEnglish();
		openLink("coccoc://settings/#coccoc-settings-users");
		SignoutCocCoc();
		TestLogger.info("3. Observe on Omnibox.");
		TestLogger.info("#3 : Expect : The user button locate beside minimize button.");
		
		if (waitForObjectPresent("pictures\\Browser_Menu_icon_UserButtonAndMinimizeButton.png", 5)) 
		{
			setTestcaseStatus("PASSED"," PASSED #3 =>The user button locate beside minimize button. ");
		
			
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED # 3 => there is NO user button locate beside minimize button ");
		
		}
		
		TestLogger.info("4. Click user button beside minimize buton.");
		waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 7);
		clickOn("pictures\\Browser_GUI_icon_User.png");
		
		TestLogger.info("# 4 : ==> Expect : - A modal box appears to info current user ."
				+ "\n AND 3 Buttons must display :\n" );
        TestLogger.info("Đăng nhập vào Cốc Cốc (Signin to Cốc Cốc for EN version");
    	TestLogger.info ("+ Chuyển đổi người ") ; 
        TestLogger.info ("+ Truy cập ẩn danh ");
        
		 if (waitForObjectPresent("pictures\\Browser_SigninUsser_Modal_Signin.png", 16))  
		 {
			 setTestcaseStatus("PASSED" , " PASSED # 4 => - A modal box appears to info current user ");
			 
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "FAILED # 4 => - A modal box DOES NOT appear to info current user ");
			
		 }
        
		TestLogger.info("5. Click on 'Đăng nhập vào Cốc Cốc' ('Sign-in to Cốc Cốc for EN version).");
		waitForObjectPresent("pictures\\Browser_GoogleSyn_Button_SigninCocCoc.png", 7);
		clickOn("pictures\\Browser_GoogleSyn_Button_SigninCocCoc.png"); 
		
		TestLogger.info("#5 : ==> Expect : The Sign-in modal appears allow user login to Google account\n" 
      + " -Back button on the top left\n"  
      + " -Google logo\n "
      + " -text: 'Thêm tài khoản Google của bạn/Add your Google account \n"
      + " -User's avatar \n"
      + " -Username/password textbox.\n"
      + " -Sign-in-button.\n-"
      + " -Need help ?  and Create an account link.\n");
		
		
		if (waitForObjectPresent("pictures\\Browser_SigninGoogle_Modal_signinGoogle.png", 16))
		{
			setTestcaseStatus("PASSED", "PASSED # 5 => The Sign-in modal appears allow user login to Google account ");
			
		}
		else
		{
			
			setTestcaseStatus("FAILED", "FAILED # 5 => The Sign-in modal DOES NOT appears to allow user login to Google account ");
			
			
		}
		
		TestLogger.info("6. Click on close button.");
		waitForObjectPresent("pictures\\Browser_Downloader_Button_Close.png", 7);
		clickOn("pictures\\Browser_Downloader_Button_Close.png");  
		TestLogger.info("#6: No modal box appears again.");
		
	   if (waitForObjectPresent("pictures\\Browser_SigninGoogle_Modal_signinGoogle.png", 6))
	   {
		   closeBrowser();
		  
		   setTestcaseStatus("FAILED", "FAILED # 6 =>  A Login modal box still appears again. ");
			
	   }
	   else
	   {
		    closeBrowser();
			setTestcaseStatus("PASSED"," PASSED # 6 => A modal box Does NOT appears again.");
		   
	   }
	   
	}
	  
	
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_02 </br>
	 * <b> CaseTitle: </b>Check UI for Sign-in Settings page...</br>
	 * <b> Steps: </b>
	 * 1. Install latest CocCoc browser.
2. Start CocCoc browser
3. Goto Setting page > CocCoc menu 
4. Click On User (Người dùng) OR enter into Omnibox coccoc://settings/#coccoc-settings-users.
5. Click on "Sign in to Cốc Cốc" ("Đăng nhập vào Cốc Cốc") button.
6. Click on back button.
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	 *  #4: Sign-in section must display on the top of Settings page.
#5:  The Sign-in modal appears allow user login to Google account.
      - Back button on the top left.
      - Google logo.
      - text: "Thêm tài kho?n Google c?a b?n"/"Add your Google account".
      - User's avatar.
      - Username/password textbox.
      - Sign-in-button.
      - "Need help ?" and "Create an account" link.

#6:  - A modal box appears to info current user (cá nhân 1/persional 1).
      
        3 Buttons must display : 
         + "Đăng nhập vào Cốc Cốc" (Signin to Cốc Cốc" for EN version).
         +  Chuyển đổi người 
         +  Truy cập ẩn danh
	 
	 
	 * @author hanv
	
	 */

	
	@Test
	public void GoogleServices_Signin_Sync_02()
	{ 
		TestLogger.info("=== GoogleServices_Signin_Sync_02 ======");
		startCocCocInEnglish();
		TestLogger.info("3. Goto Setting page > CocCoc menu ");
		TestLogger.info("4. Click On User (Người dùng) OR enter into Omnibox ");
	    openLink("coccoc://settings/#coccoc-settings-users");
	    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
		clickOn("pictures\\Browser_Settings_Menu_User.png");
		
		TestLogger.info("#4.EXPECT :  Sign-in section must display on the top of Settings page. ");
		if (waitForObjectPresent("pictures\\Browser_User_Block_SigninSection.png", 6)) 
		{
			setTestcaseStatus("PASSED", " PASSED #4 : ==> Sign-in section must display on the top of Settings page.");
			
		}
		else
		{
			 setTestcaseStatus("FAILED", "FAILED # 4 => Sign-in section NOT display on the top of Settings page. ");
			
		}
		
		TestLogger.info("5. Click on 'Sign in to Cốc Cốc' ('Đăng nhập vào Cốc Cốc') button.");
		 waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7);
		clickOn("pictures\\Browser_Settings_Button_Signintococcoc.png");  
		
		TestLogger.info("#5 : ==> EXPECT : The Sign-in modal appears allow user login to Google account\n" 
			      + " -Back button on the top left\n"  
			      + " -Google logo\n "
			      + " -text: 'Thêm tài khoản Google của bạn/Add your Google account \n"
			      + " -User's avatar \n"
			      + " -Username/password textbox.\n"
			      + " -Sign-in-button.\n-"
			      + " -Need help ?  and Create an account link.\n");
		

		if (waitForObjectPresent("pictures\\Browser_SigninGoogle_Modal_signinGoogle.png", 6))  
		{
			setTestcaseStatus("PASSED","PASSED # 5 => The Sign-in modal appears allow user login to Google account ");
			
		}
		else
		{
			
			setTestcaseStatus("FAILED", "FAILED # 5 => The Sign-in modal DOES NOT appears to allow user login to Google account ");
			
			
		}
		
		TestLogger.info("6. Click on close button.");
		waitForObjectPresent("pictures\\Browser_Downloader_Button_Close.png", 7);
		clickOn("pictures\\Browser_Downloader_Button_Close.png");  
		TestLogger.info("#6: No modal box appears again.");
		sleep (2) ;
	   if (waitForObjectPresent("pictures\\Browser_SigninGoogle_Modal_signinGoogle.png", 6))
	   {
		   closeBrowser();
		  
		   setTestcaseStatus("FAILED", "FAILED # 6 =>  A Login modal box still appears again. ");
			
	   }
	   else
	   {
		    closeBrowser();
			setTestcaseStatus("PASSED"," PASSED # 6 => A modal box Does NOT appears again.");
		   
	   }
		
	}
	
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_03 </br>
	 * <b> CaseTitle: </b>Check UI for User modal after login success,Check UI for Sync settings,Check UI after user disconnect....</br>
	 * <b> Steps: </b>
	  1. Install latest CocCoc browser.
      2. Start CocCoc browser.
      3.Click on User Button (which next to Minizium button)
      4. Login with valid Google account.
      5. Click on user button.
      6. Go to settings page.
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	 #5: 
      - A modal appears to info user login success with title: " You're now signin to CocCoc" (Bạn đã đăng nhập vào Cốc Cốc" ).
      - Info message: Your tabs, bookmarks, history, and other settings will be synced to your Google account ("Các tab, dấu trang, lịch sử và các cái đặt khác sẽ được đồng bộ hóa với tài khoản Google của bạn.).
     - Link go to Settings page (Cài đặt).
     - Button "Ok, got it" ("OK" for VI version).
      - Avatar change to user logo (if google account have avatar).
     #6: - "Disconnect your Google Account..." replacess for "Signin to CocCoc" button and disable for a few seconds (after login successful).
      - "Set up sync..." button appers beside  "Disconnect your Google Account..." button.
	 ===================
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_04 </br>
	 * <b> CaseTitle: </b>Check UI for Sync settings.</br>
	 * <b> Steps: </b>
	 1. Install latest CocCoc browser.
2. Start CocCoc browser.
3.Click on User Button (which next to minimize button)
4. Login with valid Google account.
5. Go to settings page.
6. Click on "Advanceed sync settings..." ("Cài d?t d?ng b? hóa nâng cao...") button.
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	#6: A sync modal appears with:
  - Tile  "Setup Sync" ("Cài d?t d?ng b? hóa nâng cao").
  - Combo box with 2 options: "Sync everything" (Ð?ng b? hóa t?t c?" and "Choose what to sync" ("Ch?n…)
  - Checkbox with items can sync. (their are disabled when selecting "Sync everything").
  - Encryption options with two options: 
        "Encrypt synced passwords with your Google Credentials".
         "Encrypt all synced data with your own sync passphrase".
- "Ok" and "Cancel" buttons.

      =====================
     * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_05 </br>
	 * <b> CaseTitle: </b>Check UI after user disconnect..</br>
	 * <b> Steps: </b>
	1. Install latest CocCoc.
2. Start CocCoc browser.
3. Click on User Button (which next to minimize button)
4. Login with valid Google account.
5. Go to settings page.
6. Click on button "Disconnect your Google Account".
7. Click on Disconnect account.
8. Go to Settings page.
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	#6: A Popup appears to confirm user that user want to also clear history, bookmarks, settings and other CocCoc data stored on this device or not ?
    #7: The user button appears without any account name.
    #8: - "Advanced sync settings…" disappears.
      - "Sign in to C?c C?c" button replaces for "Disconnect your Google Account...".

	 
	 * @author hanv
	
	 */

	@Test
	public void GoogleServices_Signin_Sync_03_04_05()
	{ 
		TestLogger.info("=== GoogleServices_Signin_Sync_03_04_05 =====");
		startCocCocInEnglish();
		TestLogger.info("3.Click on User Button (which next to Minizium button)");
		clickOn("pictures\\specificEnviroment\\win10\\Browser_GUI_icon_User.png");
		waitForObjectPresent("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png", 7);  
		clickOn("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png");
		TestLogger.info("Login with valid Google account. ");
		waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Email.png", 15);
		clickOn("pictures\\Browser_GoogleSync_Button_Email.png");
		sleep(3);
		s.type(userNameGmail3); 
		waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 17);
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 17);
		clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
		s.type(passwordGmail3);
		waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 18);
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		
		waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png", 8);
		clickOn("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png");
		
		sleep(3);
	
		TestLogger.info("#5: EXPECT:  A modal appears to info user login success with title:\n" 
		+ " -You're now signin to CocCoc  (Bạn đã đăng nhập vào Cốc Cốc' )\n" 
        + "- Info message: Your tabs, bookmarks, history, and other settings will be synced to your Google account ('Các tab, dấu trang, lịch sử và các cái đặt khác sẽ được đồng bộ hóa với tài khoản Google của bạn.)."
        + "- Link go to Settings page (Cài đặt).\n"
        + "- Button 'Ok, got it' ('OK' for VI version).\n"
        + "- Avatar change to user logo (if google account have avatar)\n");
		
		if (waitForObjectPresent("pictures\\Browser_Users_SigninGoogle_Button_signinAnyway.png", 3))
		{
			clickOn("pictures\\Browser_Users_SigninGoogle_Button_signinAnyway.png");
		}
		
		 waitForObjectPresent("pictures\\Browser_Users_SigninGoogle_Button_QA.png", 4) ;
		 clickOn("pictures\\Browser_Users_SigninGoogle_Button_QA.png");
		 
		if (waitForObjectPresent("pictures\\Browser_GoogleSyn_Popup__SigninSucces.png", 6))  
		{
			 clickOn("pictures\\Browser_Users_SigninGoogle_Button_QA.png");
			setTestcaseStatus("PASSED"," PASSED #5 => A modal appears to info user login success with title ");
		}
		else
		{
			 clickOn("pictures\\Browser_Users_SigninGoogle_Button_QA.png");
			 setTestcaseStatus("FAILED", "FAILED #5 => A modal DOES NOT appear to info user login success with title");
		}
		
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");

		openLink("coccoc://settings/#coccoc-settings-general"); 
		 
	 
	     waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
		
		clickOn("pictures\\Browser_Settings_Menu_User.png");
		
		TestLogger.info("#6: - EXPECT : Disconnect your Google Account...' replacess for 'Signin to CocCoc' button and "
		+ "disable for a few seconds (after login successful)." 
		+ "Set up sync...' button appers beside  'Disconnect your Google Account...' button.");
		
		if (waitForObjectPresent("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 6))
		{
			setTestcaseStatus("PASSED", "PASSED #6: => Disconnect your Google Account appear on Setting page");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED # 6 => Disconnect your Google Account DOES NOT appear on Setting page");
		}
		
		TestLogger.info("RUN : GoogleServices_Signin_Sync_04");
		TestLogger.info("7.Click on 'Advanceed sync settings...' (Cài đặt đồng bộ hóa nâng cao...) button.");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_Button_AdvancedSynSetting.png", 7);
		clickOn("pictures\\Browser_Settings_Users_Button_AdvancedSynSetting.png");
		
		TestLogger.info("#6: - EXPECT : A sync modal appears with:\n"
  + "-Tile  Setup Sync (Cài đặt đồng bộ hóa nâng cao).\n"
  + "-Combo box with 2 options: Sync everything (Đồng bộ hóa tất cả and Choose what to sync (Chọn…)\n"
  + "-Checkbox with items can sync. (their are disabled when selecting Sync everything).\n "
  + "-Encryption options with two options: \n"
  + "-Encrypt synced passwords with your Google Credentials.\n"     
  + "-Encrypt all synced data with your own sync passphrase.\n"      
  + " - 'Ok' and 'Cancel' buttons.\n");
		
		
		if (waitForObjectPresent("pictures\\Brwoser_Googlesyn_UserSyncEverything.png", 6)) 
		{
			setTestcaseStatus("PASSED","PASSED GoogleServices_Signin_Sync_04 ");
			 waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Cancel.png", 7);
			clickOn("pictures\\Browser_GoogleSync_Button_Cancel.png");
			 
		}
		else
		{
			waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Cancel.png", 7); 
			clickOn("pictures\\Browser_GoogleSync_Button_Cancel.png");
			setTestcaseStatus("FAILED", "FAILED =>>  GoogleServices_Signin_Sync_04");
		
		}
		
		TestLogger.info("RUN : GoogleServices_Signin_Sync_05"); 
		
		TestLogger.info("7.Click on button Disconnect your Google Account.");
		waitForObjectPresent("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 7); 
		clickOn("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png");  
		TestLogger.info("#7: EXEPCT : A Popup appears to confirm user that user want to also clear history, bookmarks, settings and other CocCoc data stored on this device or not ?");
		if (waitForObjectPresent("pictures\\Browser_Users_Popup_DisconnectYourGoogleAccounPopUp.png", 6)) 
		{
			setTestcaseStatus("PASSED","PASSED #7 : A Popup appears to confirm user that user want to also clear history");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED # 7 :A Popup DOES NOT appear to confirm user that user want to also clear history ");
		}
		waitForObjectPresent("pictures\\Browser_Users_Popup_Checkbox.png", 7);  
		clickOn("pictures\\Browser_Users_Popup_Checkbox.png");
		TestLogger.info("8.Click on Disconnect account.");
		waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 8);
		clickOn("pictures\\Browser_SettingPage_Button_Signout.png");
		
		
		TestLogger.info("#8 : EXPECT :The user button appears without any account name. ");
		if (waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 6))
		{
			setTestcaseStatus("PASSED", "PASSED : The user button appears without any account name.");
			 
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED #8 => The user button DOES NOT appear without any account name");
			
		}
		
		TestLogger.info(" 9. Go to Settings page.");
		openLink("coccoc://settings/#coccoc-settings-users");
		
		
		TestLogger.info("#9: EXPECT : - Advanced sync settings… disappears. - Sign in to Cốc Cốc button replaces for 'Disconnect your Google Account....");
		
		if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 6)) 
			
		{
			closeBrowser();
			setTestcaseStatus("PASSED", "PASSED ==>  GoogleServices_Signin_Sync_05 ");
			
		}
		else
		{
			closeBrowser();
			setTestcaseStatus("FAILED", "FAILED => GoogleServices_Signin_Sync_05 ");
		}
	}
	
	
	//Verify warning message when user signing with invalid username/password on browser.
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_06 </br>
	 * <b> CaseTitle: </b> Verify warning message when user signing with invalid username/password on browser....</br>
	 * <b> Steps: </b>
	 1. Click user button beside minimize buton.
2. Click on "Sign-in to C?c C?c" (" Ðang nh?p vào C?c C?c for VI version).
3. Click on "Sing in" button.
4. Enter any email and blank password (email not exist, blank password, password wrong).
5. Click on "Sing in" button.
6. Enter wrong email and password (invalid email, wrong password).
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	 #4: The email textbox is highlighted with warning "Enter your email address.".
#5: The password textbox is highlighted with warning "Enter your password.".
#6: The password textbox is highlighted with warning "The email or password you entered is incorrect.".
	 
	 * @author hanv
	
	 */

	

	public void GoogleServices_Signin_Sync_06()
	{ 
		
	  TestLogger.info("==== GoogleServices_Signin_Sync_06 ====");
	  startCocCocInEnglish();
	  TestLogger.info("3. Click user button beside minimize buton.");
	  waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 7);
	  clickOn("pictures\\Browser_GUI_icon_User.png");
	  waitForObjectPresent("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png", 7);
	  clickOn("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png");
	  TestLogger.info("4. Enter any email and blank password (email not exist, blank password, password wrong).");
	  
	  waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Email.png", 7);
		clickOn("pictures\\Browser_GoogleSync_Button_Email.png");
		sleep(5);
	
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		TestLogger.info("# 4 : EXPECT : The email textbox is highlighted with warning 'Enter your email address.''");
		
		if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_PleaseReEnterYourEmail.png", 6))  
		{
			setTestcaseStatus("PASSED", "PASSED #4 => The email textbox is highlighted with warning 'Enter your email address. ");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED #4 => The email textbox is NOT highlighted with warning 'Enter your email address. ");
		}
		waitForObjectPresent("pictures\\Browser_GoogleSync_Button_Email.png", 7);
		clickOn("pictures\\Browser_GoogleSync_Button_Email.png");
		sleep(5);
		s.type(userNameGmail3); 
		waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 7);
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		TestLogger.info("5. Enter wrong email and password (invalid email, wrong password).");
		waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 7);
		clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
		s.type(" ");
		waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 7);
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		sleep(3);
		TestLogger.info("#5 : EXPECT : The password textbox is highlighted with warning The email or password you entered is incorrect.");
		
		if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_PleaseEnterYourPassword.png",7)) 
		{
			setTestcaseStatus("PASSED", "PASSED #5 => The password textbox is highlighted with warning The email or password you entered is incorrect. ");
		}
		else
		{
			setTestcaseStatus("FAILED", "FAILED #5 => The password textbox is NOT highlighted with warning The email or password you entered is incorrect. ");
		}
	  
		TestLogger.info("6.  Enter wrong email and password (invalid email, wrong password).");
		waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 7);
		clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
		s.type("abcbf");
		clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
		sleep(3);
		
		TestLogger.info("#6: EXPECT => The password textbox is highlighted with warning 'The email or password you entered is incorrect.");
		
		
			if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_emailORPassisNOTCorrect.png", 6))  
			{
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED #6 => The password textbox is highlighted with warning 'The email or password you entered is incorrect. ");
			}
			else
			{
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "FAILED #6 => The password textbox is highlighted with warning 'The email or password you entered is incorrect. ");
			}
		
		
		
		
	}
	
	     
	     //Verify warning message when user sign in with invalid username/password from settings page.
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Signin_Sync_07 </br>
	 * <b> CaseTitle: </b> Verify warning message when user sign in with invalid username/password from settings page..</br>
	 * <b> Steps: </b>
	1. Go to Cốc Cốc settings page.
2. Click on User (Người dùng) button.
3. Click on "Sing in" button.
4. Enter any email and blank password (email not exist, blank password, password wrong).
5. Click on "Sing in" button.
6. Enter wrong email and password (invalid email, wrong password).
	 *  <b> ExpectedOutput: </br> 
	 *  EXPECT : 
	 #4: The email textbox is highline with warning "Enter your email address.".
     #5: The password textbox is highline with warning "Enter your password.".
     #6: The password textbox is highline with warning "The email or password you entered is incorrect.".
	 
	 * @author hanv
	
	 */
		
		public void GoogleServices_Signin_Sync_07()
		{ 
			
			
			TestLogger.info("==== GoogleServices_Signin_Sync_07 ===");
		    startCocCocInEnglish();
		    TestLogger.info("1. Goto Setting page > CocCoc menu ");
			openLink("coccoc://settings/#coccoc-settings-users");
			TestLogger.info("2. Click On User (Người dùng) OR enter into Omnibox ");
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
			clickOn("pictures\\Browser_Settings_Menu_User.png");
			TestLogger.info("Click on 'Sing in' button.");
			waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7);
			clickOn("pictures\\Browser_Settings_Button_Signintococcoc.png");
		    TestLogger.info("4. Enter any email and blank password (email not exist, blank password, password wrong).");
		    waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 7);
			clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
			sleep(5);
			s.type(" "); 
			clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
			TestLogger.info("# 4 : EXPECT : The email textbox is highlighted with warning 'Enter your email address.''");
			
			if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_PleaseReEnterYourEmail.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED #4 => The email textbox is highlighted with warning 'Enter your email address. ");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED #4 => The email textbox is NOT highlighted with warning 'Enter your email address. ");
			}
			
			clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
			sleep(5);
			s.type(userNameGmail3); 
			 waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 7);
			clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
			TestLogger.info("5.  Enter wrong email and password (invalid email, wrong password).");
			waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 7);
			clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
			s.type(" ");
			waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 7);
			clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
			sleep(3);
			TestLogger.info("#5 : EXPECT : The password textbox is highlighted with warning The email or password you entered is incorrect.");
			
			if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_PleaseEnterYourPassword.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED #5 => The password textbox is highlighted with warning The email or password you entered is incorrect. ");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED #5 => The password textbox is NOT highlighted with warning The email or password you entered is incorrect. ");
			}
		  
			TestLogger.info("6.  Enter wrong email and password (invalid email, wrong password).");
			clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
			s.type("abcbf");
			waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 7);
			clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
			sleep(3);
			
			TestLogger.info("#6: EXPECT => The password textbox is highlighted with warning 'The email or password you entered is incorrect.");
			
			
				if (waitForObjectPresent("pictures\\Browser_GoogleSync_Textfiled_emailORPassisNOTCorrect.png", 5))
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED #6 => The password textbox is highlighted with warning 'The email or password you entered is incorrect. ");
				}
				else
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED #6 => The password textbox is highlighted with warning 'The email or password you entered is incorrect. ");
				}
			
			
			
			
		}
		
		
		// Verify user can create new Google account 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_08 </br>
		 * <b> CaseTitle: </b> Verify warning message when user sign in with invalid username/password from settings page..</br>
		 * <b> Steps: </b>
		1. Click on User Button (which next to minimize button)
2. Click on "Create an account" link
3. Enter valid to all require fields
4. Click on "next step" button
5. Enter Google verification code and click "next step"
		 *  <b> ExpectedOutput: </br> 
		 *  EXPECT : 
#2: "Create your Google account" page opens on new tab with address: chrome://chrome-signin/?source=8&constrained=0&frameUrlId=1&auto_close=1&showAccountManagement=1
#4: Google send Google verification code to user via phone.
#5: User login success with account was create.
     - Current user is replaced by Google account
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_08()
		{
			
			  TestLogger.info("==== GoogleServices_Signin_Sync_08 ===");
			  startCocCocInEnglish();
			  sleep(5);
			  TestLogger.info("1. Click user button beside minimize buton.");
			  waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 8);
			  clickOn("pictures\\Browser_GUI_icon_User.png");
			  waitForObjectPresent("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png", 8);
			  clickOn("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png");
			  clickOn("pictures\\Browser_SigninGoogle_Button_MoreOption.png");
			  TestLogger.info("2. Click on 'Create an account' link");
			  waitForObjectPresent("pictures\\Browser_GoogleSynin_Textlink_CreateAnAcount.png", 8);
			  clickOn("pictures\\Browser_GoogleSynin_Textlink_CreateAnAcount.png");  
			  TestLogger.info("#2 : Expect : Open Dialog for Create An Ancount");
			  if (waitForObjectPresent("pictures\\Website_Gmail_Popup_CreateAnAncount.png", 20))
			  {
				  clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				  setTestcaseStatus("PASSED", "PASSED # 2 : =>  Create your Google account' page opens on new tab with address: chrome://chrome-signin/?source=8&constrained=0&frameUrlId=1&auto_close=1&showAccountManagement=1 ");
			  }
			  else
			  {
				  clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				  setTestcaseStatus("FAILED", "FAILED #2 : => Create your Google account' page DOES NOT open on new tab with address:");
			  }
			  
			  
			  
		}
		
		// Verify that browser auto sync all data after login success.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_11 </br>
		 * <b> CaseTitle: </b> Verify that browser auto sync all data after login success..</br>
		 * <b> Steps: </b>
		1. Open modal to Sign in.
2. Enter email/password as old Google account (contain info about extensions, bookmark, etc...).
3. Click on Sign in button.
4. Open Google Dashboard (https://www.google.com/settings/chrome/sync) on new tab
5. Check all items on Google Dashboard are sync to CocCoc (Extension, setting, auto completed, history, theme, bookmark, password)
		 *  <b> ExpectedOutput: </br> 
		 *  EXPECT : 
#5: All data is sync to CocCoc correctly and fully.
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_11()
		{
			  
			 TestLogger.info("==== GoogleServices_Signin_Sync_11 ===");
			  startCocCocInEnglish();
			  TestLogger.info("1. Open modal to Sign in.");
			  waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 8);
			  clickOn("pictures\\Browser_GUI_icon_User.png");
			  waitForObjectPresent("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png", 8);
			  clickOn("pictures\\Browser_SigninGoogle_Button_SigninToCoccoc.png");
			  
			  TestLogger.info("2. Enter email/password as old Google account (contain info about extensions, bookmark, etc...). ");
			  waitForObjectPresent("pictures\\Browser_GoogleSynin_TextFiled_Pass.png", 8);
				clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
				s.type("a", Key.CTRL);
				sleep(3);
				s.type(userNameGmail4); 
				clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
				waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 8);
				clickOn("pictures\\Browser_GoogleSynin_TextFiled_Pass.png");
				s.type(passwordGmail4);
				waitForObjectPresent("pictures\\Browser_GoogleSynin_Button_Next.png", 8);
				clickOn("pictures\\Browser_GoogleSynin_Button_Next.png");
				
				if (waitForObjectPresent("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png", 4))
				{
					
					clickOn("pictures\\Browser_SettingsLanguage_Button_OK_GOT_IT.png");
				}
				
				waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 8);
			
				TestLogger.info("3. Open Google Dashboard (https://www.google.com/settings/chrome/sync) on new tab");
				clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
				openLink("https://www.google.com/settings/chrome/sync");
				
				if (waitForObjectPresent("pictures\\Browser_GoogleSyn_TextField_EnterYourEmail.png", 3))
				{
					
					clickOn("pictures\\Browser_GoogleSyn_TextField_EnterYourEmail.png");
					s.type(userNameGmail4);
					s.type(Key.ENTER);
					waitForObjectPresent("pictures\\Browser_GoogleSyn_TextField_Password.png", 4);
					clickOn("pictures\\Browser_GoogleSyn_TextField_Password.png");
					s.type(passwordGmail4);
					s.type(Key.ENTER);
					
				}
				
				TestLogger.info("5. Check all items on Google Dashboard are sync to CocCoc (Extension, setting, auto completed, history, theme, bookmark, password)");
				TestLogger.info("#5: EXPECT : =>  All data is sync to CocCoc correctly and fully.");
				
				
				
				if (waitForObjectPresent("pictures\\Website_Googlesynin_Picture_DashboardUser.png", 8))
				{
					SignoutCocCoc();
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED #3 : ==> All data is sync to CocCoc correctly and fully.");
				}
				else
				{
					SignoutCocCoc();
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED #3 : ==> All data is NOT synced to CocCoc correctly and fully.");
				}
			  
			
		}
		
		
	
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_13 </br>
		 * <b> CaseTitle: </b>Verify that user can encrypt sync data with user's own sync passphrase</br>
		 * <b> Steps: </b>
		1. Open modal to Sign in.
2. Enter email/password as old Google account (contain info about extensions, bookmark, etc...).
3. Click on Sign in button.
4. Open CocCoc settings.
5. Open advances sync settings.
6. Select option "Encrypt all synced data with your own sync passphrase".
7. Enter password to sync into "passphrase" and "Confirm passphrase" textbox and click ok
8. Check all items on Google Dashboard are sync to CocCoc (Extension, setting, auto completed, history, theme, bookmark, password)
9. Open Google Dashboard (https://www.google.com/settings/chrome/sync) on new tab.
10. Observe on Password
		 *  EXPECT : 
#10: a lock icon appears on Password.
		 
		 * @author hanv
		
		 */
		//Verify that user can encrypt sync data with user's own sync passphrase
		
		public void GoogleServices_Signin_Sync_13()
		{
			
	     TestLogger.info("=== GoogleServices_Signin_Sync_13 ===");
		 TestLogger.info("1. Open modal to Sign in.");
		 
		 startCocCocInEnglish();
		 sleep (6);
		 
		 TestLogger.info("2. Enter email/password as old Google account (contain info about extensions, bookmark, etc...).");
		
		 TestLogger.info("3. Click on Sign in button.");
		 SigninToCocCoc(userNameGmail4, passwordGmail4);
		 
		 TestLogger.info("4. Open CocCoc settings.");
		 clickOn("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");  
		 openLink("coccoc://settings/#coccoc-settings-users");
		
		 TestLogger.info("5. Open advances sync settings");
		 waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
		 clickOn("pictures\\Browser_Settings_Menu_User.png");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_Button_AdvancedSynSetting.png", 7);
		 clickOn("pictures\\Browser_Settings_Users_Button_AdvancedSynSetting.png");  
		 
		 TestLogger.info("6. Select option Encrypt all synced data with your own sync passphrase.");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_EncryptALLSyrcedData.png", 7);  
		 clickOn("pictures\\Browser_Settings_Users_EncryptALLSyrcedData.png");
		 
		 TestLogger.info("7. Enter password to sync into passphrase and Confirm passphrase textbox and click ok");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_Button_Passphase2.png", 7); 
		 clickOn("pictures\\Browser_Settings_Users_Button_Passphase2.png");
		 s.type("12345");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_Button_Passphase1.png", 7); 
		 clickOn("pictures\\Browser_Settings_Users_Button_Passphase1.png");
		 s.type("12345");
		 waitForObjectPresent("pictures\\Browser_Dialog_Button_OK.png", 7);  
		 clickOn("pictures\\Browser_Dialog_Button_OK.png");
		 
		 
		 TestLogger.info("9. Open Google Dashboard (https://www.google.com/settings/chrome/sync) on new tab.");
		 waitForObjectPresent("pictures\\Browser_Settings_Users_Button_linkChromeDashboard.png", 7);  
		 clickOn("pictures\\Browser_Settings_Users_Button_linkChromeDashboard.png");
		 
		 TestLogger.info("#10: EXPECT : ==>  a lock icon appears on Password.");
		 
		 if (waitForObjectPresent("pictures\\Browser_SyncAccount_icon_Clock.png", 7))  
		 {    
			 
			 s.type(Key.END);
			 sleep(2);
			 s.type(Key.END);
			 clickOn("pictures\\Browser_Setttings_Usersr_Button_Reset_sync.png");
			 waitForObjectPresent("pictures\\Browser_Users_Button_OKBlue.png", 7);
			 clickOn("pictures\\Browser_Users_Button_OKBlue.png");
			 sleep(5);
			 SignoutCocCoc();
			 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
			 setTestcaseStatus("PASSED", "PASSED #10 : == >> a lock icon appears on Password.");
			
		 }
		 else
		 {
			 s.type(Key.END);
			 sleep(2);
			 s.type(Key.END);
			 clickOn("pictures\\Browser_Setttings_Usersr_Button_Reset_sync.png");
			 waitForObjectPresent("pictures\\Browser_Users_Button_OKBlue.png", 7);
			 clickOn("pictures\\Browser_Users_Button_OKBlue.png");
			 sleep(5);
			 SignoutCocCoc();
			 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
			 setTestcaseStatus("FAILED", "FAILED #10 : == >> a lock icon DOES NOT appear on Password.");
		 }
		 
		 
		 
		}
		
		
		
		//Verify user can disconnect without remove user data on browser.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_14 </br>
		 * <b> CaseTitle: </b>Verify user can disconnect without remove user data on browser.</br>
		 * <b> Steps: </b>
1. Open modal to Sign in.
2. Enter email/password as old Google account (contain info about extensions, bookmark, etc...).
3. Click on Sign in button.
4. Open CocCoc settings.
5. Open advances sync settings.
6. Select option "Encrypt all synced data with your own sync passphrase".
7. Enter password to sync into "passphrase" and "Confirm passphrase" textbox and click ok
8. Check all items on Google Dashboard are sync to CocCoc (Extension, setting, auto completed, history, theme, bookmark, password)
9. Open Google Dashboard (https://www.google.com/settings/chrome/sync) on new tab.
10. Observe on Password
		 *  EXPECT : 
#10: a lock icon appears on Password.
		 
		 * @author hanv
		
		 */
		//@Test
		public void GoogleServices_Signin_Sync_14()
		{
			    
			    TestLogger.info("=== GoogleServices_Signin_Sync_14  ==");
			    startCocCocInEnglish();
			    SigninToCocCoc(userNameGmail3, passwordGmail3);
			    openLink("coccoc://settings/#coccoc-settings-general");
			    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
				clickOn("pictures\\Browser_Settings_Menu_User.png");
				TestLogger.info("2.Click on Disconnect your Google account.");
				 waitForObjectPresent("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 5);
				clickOn("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png");
				waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 7);
				clickOn("pictures\\Browser_SettingPage_Button_Signout.png");
				
				TestLogger.info("#3a: EXPECT : Google account is disconnected.");
				if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7))
				{
					setTestcaseStatus("PASSED", "PASSED #3a ==> Google account is disconnected ");
				}
				else
				{
					setTestcaseStatus("FAILED", "FAILED #3a ==> Google account is NOT disconnected ");
				}
				
				
				TestLogger.info("# 3b : EXPECTED : All user data are keep on CocCoc browser (extension, bookmark, etc.)");
				
				openLink("coccoc://settings/#coccoc-settings-users");
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
				
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 150);
				int i=1;
				do 
				{
					i++;
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					sleep (2);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
					s.type(Key.DOWN);
				
					
				} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 1) && (i<6));
				
				if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 5))
				{ 
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED #3b ==> All user data are keep on CocCoc browser (extension, bookmark, etc.) ");	
				}
				else
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED #3b ==> All user data are NOT keep on CocCoc browser (extension, bookmark, etc.) ");
				}
		}
		
		//
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_15 </br>
		 * <b> CaseTitle: </b>Verify user can disconnect with all data are removed on browser.</br>
		 * <b> Steps: </b>
1. Open settings page.
2. Click on Disconnect your Google account.
3. Select option "Also clear your history, bookmarks, settings, and other Cốc Cốc data stored on this device."
4. Click "Disconnect account" button.
		 *  EXPECT : 
#4: 
 - CocCoc browser restart with opening only new tab.
 - The Google account is disconnected.
 - All data are removed
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_15()
		{ 
			
			    TestLogger.info("===  GoogleServices_Signin_Sync_15  ==");
			    startCocCocInEnglish();
			    SigninToCocCoc(userNameGmail3, passwordGmail3);
			   
			    TestLogger.info("1.Open Settings page");
				
			    openLink("coccoc://settings/#coccoc-settings-users");
				
			    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
				clickOn("pictures\\Browser_Settings_Menu_User.png");
				TestLogger.info("2.Click on Disconnect your Google account.");
				waitForObjectPresent("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 5);
				clickOn("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png");
					
				TestLogger.info("3.Select option Also clear your history, bookmarks, settings, and other Cốc Cốc data stored on this device.");
				waitForObjectPresent("pictures\\Browser_Users_Popup_Checkbox.png", 7);
				clickOn("pictures\\Browser_Users_Popup_Checkbox.png");
				waitForObjectPresent("pictures\\Browser_SettingPage_Button_Signout.png", 7);
				clickOn("pictures\\Browser_SettingPage_Button_Signout.png");
			
				
				TestLogger.info("#3a: EXPECT : Google account is disconnected.");
				

			    TestLogger.info("#3:" 
                + "- CocCoc browser restart with opening only new tab.\n" 
                + "- The Google account is disconnected.\n"
                + "- All data are removed\n");
			TestLogger.info("EXPECT : 3a. CocCoc browser restart with opening only new tab.");
			
			
			if (waitForObjectPresent("pictures\\Browser_Tabs_Text_OnlyOneNewtabDisplay.png",7))  
			{
				setTestcaseStatus("PASSED", "PASSED #3 ==> 3a. CocCoc browser restart with opening only new tab. ");	
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED #3 ==> 3a. CocCoc browser DOES NOT restart with opening only new tab. ");
			}
			
			
			TestLogger.info("EXPECT : 3b: The Google account is disconnected..");
			
		    openLink("coccoc://settings/#coccoc-settings-users");
		    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
			clickOn("pictures\\Browser_Settings_Menu_User.png");
			
			if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7))
			{
				setTestcaseStatus("PASSED", "PASSED #3 ==> 3b. The Google account is disconnected..");	
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED #3 ==> 3b. The Google account is NOT disconnected. ");
			}
			
			
			TestLogger.info("EXPECT : 3c. All data are removed ");
			waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
			clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
			
			
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 7))
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "FAILED #3 ==> 3c. All data are NOT removed ");
			}
			else
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED #3 ==> 3c. All data are NOT removed ");
			}
		}
		
		//Verify user can disconnect with all data are removed on other browser and machine
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_16 </br>
		 * <b> CaseTitle: </b>Verify user can disconnect with all data are removed on other browser and machine</br>
		 * <b> Steps: </b>
1. Open Google Dashboard from other browser/machine
2. Login to Google account
3. Click on "Clear sync" ("Đặt lại đồng bộ hóa")
4. Switch to CocCoc browser
		 *  EXPECT : 
#4: The Google account is disconnected.
- All data are removed
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_16()
		{
			startCocCocInEnglish();
			SigninToCocCoc(userNameGmail4, passwordGmail4);
			waitForObjectPresent("pictures\\Browser_Menu_Button_Minimizewindow.png", 7);  
			clickOn("pictures\\Browser_Menu_Button_Minimizewindow.png");
			TestLogger.info("1.Open Google Dashboard from other browser/machine");
			//2. Login to Google account
			signinChrome(userNameGmail4, passwordGmail4);
			waitForObjectPresent("pictures\\Browser_AdressBar_icon_Favorite.png", 7);  
			moveMouseHorizontallyFromLogo("pictures\\Browser_AdressBar_icon_Favorite.png", -130);
			s.click();
			s.type("https://www.google.com/settings/chrome/sync");
			s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Website_Google_logo_Google.png", 7);  
			moveMouseDownFromLogo("pictures\\Website_Google_logo_Google.png",100);
			s.click();
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
			s.type(Key.DOWN);
			sleep (1);
		    s.type(Key.DOWN);
		    sleep (1);
		    s.type(Key.DOWN);
			//3. Click on "Clear sync" ("Đặt lại đồng bộ hóa")
			clickOn("pictures\\Browser_Setttings_Usersr_Button_Reset_sync.png");  
			waitForObjectPresent("pictures\\Browser_Users_Button_OKBlue.png", 7);  
			clickOn("pictures\\Browser_Users_Button_OKBlue.png");
			sleep(3);
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			s.type(Key.F4, Key.ALT);
			startCocCocInEnglish();
			sleep (5);
			// s.type(Key.UP, Key.WIN);
			// 4. Switch to CocCoc browser
			openLink("coccoc://settings/#coccoc-settings-users");
			
			//#4: The Google account is disconnected.
			//  All data are removed
			if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7))
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED : => GoogleServices_Signin_Sync_16 ");
			}
			else
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("fAILED", "FAILED => GoogleServices_Signin_Sync_16");
			}
			
			
		}
		
		//Verify user can disconnect by remove user on People section.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_17 </br>
		 * <b> CaseTitle: </b>Verify user can disconnect by remove user on People section.</br>
		 * <b> Steps: </b>
1. Open Settings page
2. Remove current user (or other Google account) on People section.
3. Confirm message
		 *  EXPECT : 
#3:
 - CocCoc browser restart with opening only new tab.
 - The Google account is disconnected.
 - All data are removed
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_17()
		{
			
			    TestLogger.info("=== GoogleServices_Signin_Sync_17  ==");
			    startCocCocInEnglish();
			    // s.type(Key.UP, Key.WIN);
			    SigninToCocCoc(userNameGmail3, passwordGmail3);
			    TestLogger.info("1.Open Settings page");
				
			    openLink("coccoc://settings/#coccoc-settings-users");
			    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
				
				clickOn("pictures\\Browser_Settings_Menu_User.png");
				TestLogger.info("Remove current user (or other Google account) on People section");
				 waitForObjectPresent("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 7);
				moveMouseDownFromLogo("pictures\\Browser_Setttings__Button_UserDisconnectYourGoogleAccount.png", 105);
				waitForObjectPresent("pictures\\Browser_Settings_button_removeAccount.png", 7);
				clickOn("pictures\\Browser_Settings_button_removeAccount.png");
				waitForObjectPresent("pictures\\Browser_Settings_button_remove.png", 7);
				clickOn("pictures\\Browser_Settings_button_remove.png");
				TestLogger.info("3.Confirm message"); 
				TestLogger.info("#3:" 
                + "- CocCoc browser restart with opening only new tab.\n" 
                + "- The Google account is disconnected.\n"
                + "- All data are removed\n");
				TestLogger.info("EXPECT : 3a. CocCoc browser restart with opening only new tab.");
				if (waitForObjectPresent("pictures\\Browser_Tabs_Text_OnlyOneNewtabDisplay.png", 5))
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED #3 ==> 3a. CocCoc browser restart with opening only new tab. ");	
				}
				else
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED #3 ==> 3a. CocCoc browser DOES NOT restart with opening only new tab. ");
				}
				
				
				TestLogger.info("EXPECT : 3b: The Google account is disconnected..");
				startCocCocInEnglish();
			    openLink("coccoc://settings/#coccoc-settings-users");
			    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
				clickOn("pictures\\Browser_Settings_Menu_User.png");  
				
				if (waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 5))
				{
				
					setTestcaseStatus("PASSED", "PASSED #3 ==> 3b. The Google account is disconnected..");	
				}
				else
				{
					
					setTestcaseStatus("FAILED", "FAILED #3 ==> 3b. The Google account is NOT disconnected. ");
				}
				
				
				TestLogger.info("EXPECT : 3c. All data are removed ");
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
				
				
				if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 5))
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED #3 ==> 3c. All data are NOT removed ");
					
				}
				else
				{
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED #3 ==> 3c. All data are removed ");
				}
				
				
		}
		
		
		//Verify that user cannot login when user was logged in that Google account by other user.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_18 </br>
		 * <b> CaseTitle: </b>Verify that user cannot login when user was login that Google account by other user.</br>
		 * <b> Steps: </b>
1. Login with Google account.
2. Create new user on settings.
3. Re-login with Google account on step #1.
		 *  EXPECT : 

#3: An info message appears to ask user that account is already being used on this computer.
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_18()
		{
			    startCocCocInEnglish();
			    SigninToCocCoc(userNameGmail4, passwordGmail4);
			    waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
				clickOn("pictures\\Browser_Settings_Menu_User.png");
				waitForObjectPresent("pictures\\Browser_Users_Button_Addperson.png", 7);
				clickOn("pictures\\Browser_Users_Button_Addperson.png");
				waitForObjectPresent("pictures\\Browser_Settings_Users_AddUser.png", 7);
				clickOn("pictures\\Browser_Settings_Users_AddUser.png"); 
				
				SigninToCocCoc(userNameGmail4, passwordGmail4);
				
				
				
				TestLogger.info("#3: An info message appears to ask user that account is already being used on this computer.");
				
				TestLogger.info("#3 : EXPECT : ==> An info message appears to ask user that account is already being used on this computer");
				
				if (waitForObjectPresent("pictures\\Browser_GoogleSyn_Popup_Thisaccountisalreadybebingusedonthiscomputer.png", 7)) 
				{
					 moveMouseHorizontallyFromLogo("pictures\\Browser_GoogleSyn_Popup_Thisaccountisalreadybebingusedonthiscomputer.png", -160);
					 s.click();
					 waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7);
					 moveMouseDownFromLogo("pictures\\Browser_Settings_Button_Signintococcoc.png", 168);
					 waitForObjectPresent("pictures\\Browser_Settings_button_removeAccount.png", 7);
					 clickOn("pictures\\Browser_Settings_button_removeAccount.png");
					 waitForObjectPresent("pictures\\Browser_Settings_button_remove.png", 7);
				     clickOn("pictures\\Browser_Settings_button_remove.png");
				     SignoutCocCoc();
				     clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
						s.type(Key.F4, Key.ALT);
					 setTestcaseStatus("PASSED", "PASSED =>An info message appears to ask user that account is already being used on this computer" );
					
				}
				
				else
				{
					 moveMouseHorizontallyFromLogo("pictures\\Browser_GoogleSyn_Popup_Thisaccountisalreadybebingusedonthiscomputer.png", -160);
					 s.click();
					 waitForObjectPresent("pictures\\Browser_Settings_Button_Signintococcoc.png", 7);
					 moveMouseDownFromLogo("pictures\\Browser_Settings_Button_Signintococcoc.png", 168);
					 waitForObjectPresent("pictures\\Browser_Settings_button_removeAccount.png", 7);
					 clickOn("pictures\\Browser_Settings_button_removeAccount.png");    
					 waitForObjectPresent("pictures\\Browser_Settings_button_remove.png", 7);
				     clickOn("pictures\\Browser_Settings_button_remove.png");
				     SignoutCocCoc();
				     clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
						s.type(Key.F4, Key.ALT);
					 setTestcaseStatus("FAILED", "FAILED => An info message DOES NOT appear to ask user that account is already being used on this computer");
				}		
				
		}
		
		
		
		 // Verify that  CocCoc sync with Google account when any data are updated form other browser/machine
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_19 </br>
		 * <b> CaseTitle: </b>Verify that  CocCoc sync with Google account when any data are updated form other browser/machine</br>
		 * <b> Steps: </b>
1. Login Google account on Chrome (local machine or other machine).
2. Install extension, add password, bookmark, etc.
3. Switch to CocCoc
		 *  EXPECT : 

#3: All change are sync to CocCoc browser.
		 
		 * @author hanv
		
		 */
		
		public void GoogleServices_Signin_Sync_19()
		{
			
			
			TestLogger.info("1. Login Google account on Chrome (local machine or other machine).");
			// SignoutChrome();
			
			signinChrome(userNameGmail3,passwordGmail3);
			s.click();
			s.type(Key.F4, Key.ALT);
			
			
			TestLogger.info("2. Switch to CocCoc browser and login same account "); 
            startCocCocInEnglish();
            // s.type(Key.UP, Key.WIN);
			SigninToCocCoc(userNameGmail3,passwordGmail3);
			
			TestLogger.info("3. All change are synced to CocCoc browser."); 
			openLink("coccoc://extensions/");
			waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 140);
			
			s.click();
			int i =1;
			do 
			{
				i++ ;
				s.type(Key.DOWN);
				sleep (1);
				s.type(Key.DOWN);
				sleep (1);
				s.type(Key.DOWN);
				sleep (1);
			    s.type(Key.DOWN);
			    sleep (1);
			    s.type(Key.DOWN);
			} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 1) && (i<7));
			
			TestLogger.info("#3:"
					+ " EXPECTED : ==> All change are synced to CocCoc browser."); 
			
			 if  (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 26))
			 {
				 setTestcaseStatus("PASSED", "PASSED :All change are synced to CocCoc browser. ");
				 SignoutCocCoc();
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				 sleep (4);
				 SignoutChrome();
				 
			 }
			 else
			 {
				 setTestcaseStatus("FAILED", "FAILED :All change are  NOT synced to CocCoc browser. ");
				 SignoutCocCoc();
				 sleep (4);
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				 sleep (2);
				 SignoutChrome();
				 
			 }
			
		
		}
	
		// Verify that user can re-login with Google account
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_20 </br>
		 * <b> CaseTitle: </b>Verify that user can re-login with Google account</br>
		 * <b> Steps: </b>
1. Login with Google account.
2. Disconnect Google account.
3. Re-login with Google account.
		 *  EXPECT : 

#3: Login successfully
		 
		 * @author hanv
		
		 */
	
		public void GoogleServices_Signin_Sync_20()
		{
			
			 TestLogger.info("==== GogleServices_Signin_Sync_20 ======");
			 startCocCocInEnglish();
			 TestLogger.info("1. Login with Google account.");
			 SigninToCocCoc(userNameGmail4, passwordGmail4);
			 TestLogger.info("2. Disconnect Google account.");
			 SignoutCocCoc();
			 SigninToCocCoc(userNameGmail4, passwordGmail4);
			 TestLogger.info("3.Re-login with Google account.");
			 TestLogger.info("# EXPECT :  #3: Login successfully");
		     openLink("coccoc://settings/#coccoc-settings-users");
		     waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
			 clickOn("pictures\\Browser_Settings_Menu_User.png");
			 if  (waitForObjectPresent("pictures\\Browser_GoogleSync_Text_SinginAsAccount4.png", 5))  
			 {
				 
				 SignoutCocCoc();
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				 setTestcaseStatus("PASSED", "PASSED ==> Login successfully");
				 
			 }
			 
			 else
			 {
				 SignoutCocCoc();
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				 setTestcaseStatus("FAILED", "FAILED ==> Login NOT successfully"); 
				 
			 }
			 
			 
		}
		
		       
				
				// Verify that user can switch to other Google account.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Signin_Sync_21 </br>
		 * <b> CaseTitle: </b>Verify that user can switch to other Google account.</br>
		 * <b> Steps: </b>
1. Login with Google account.
2. Create new user on settings.
3. Login with other Google account.
4. Click on User button on top right of browser.
5. Click on Switch person button
6. Select Google account is login at step #1.
		 *  EXPECT : 

#3 User login success, all data are sync to CocCoc correctly.
#6: User switch to Google account at step 1 successful, all user data switch to Google account at step #1
		 
		 * @author hanv
		
		 */
				
				public void GoogleServices_Signin_Sync_21()
				{
					TestLogger.info("1. Login with Google account.");
					startCocCocInEnglish();
					SigninToCocCoc(userNameGmail3, passwordGmail3);
					
					openLink("coccoc://settings/#coccoc-settings-users"); 
					 waitForObjectPresent("pictures\\Browser_Settings_Menu_User.png", 7);
					clickOn("pictures\\Browser_Settings_Menu_User.png");
					TestLogger.info("2. Create new user on settings.");
					 waitForObjectPresent("pictures\\Browser_Users_Button_Addperson.png", 7);
					clickOn("pictures\\Browser_Users_Button_Addperson.png");
					 waitForObjectPresent("pictures\\Browser_Settings_Users_AddUser.png", 7);
					clickOn("pictures\\Browser_Settings_Users_AddUser.png") ;
				    
					TestLogger.info("3.Login with other Google account.");
					SigninToCocCoc(userNameGmail6, passwordGmail6);
					openLink("coccoc://settings/#coccoc-settings-users"); 
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 135);
				    
				    s.click();
				    int i =1;
				    
				    do 
					{
						i++ ;
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
					    s.type(Key.DOWN);
					    sleep (1);
					    s.type(Key.DOWN);
					} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 1) && (i<6));
				   

					TestLogger.info("#3 User login success, all data are sync to CocCoc correctly.");
					
					 if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 8))
					 {
						 setTestcaseStatus("PASSED", "PASSED # 3 :  User login success, all data are sync to CocCoc correctly. ");
						
					 }
					 else
					 {
						 setTestcaseStatus("FAILED", "FAILED # 3 :  User login NOT success, all data are NOT synced to CocCoc correctly. ");
					 }
					  
					 
					TestLogger.info("4. Click on User button on top right of browser.");
					waitForObjectPresent("pictures\\Browser_Menu_Button_Minimizewindow.png", 7);  
					moveMouseHorizontallyFromLogo("pictures\\Browser_Menu_Button_Minimizewindow.png",-42);
				    s.click();
					TestLogger.info("5. Click on Switch person button");
					waitForObjectPresent("pictures\\Browser_User_Button_Switchperson.png", 7);
					clickOn("pictures\\Browser_User_Button_Switchperson.png");  
				    TestLogger.info("6. Select Google account is login at step #1."); 
				    waitForObjectPresent("pictures\\Browser_GoogleSyn_avatar_Account3.png", 7);  
					clickOn("pictures\\Browser_GoogleSyn_avatar_Account3.png");
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
					clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
					moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 135);
					
					s.click();
					int j =1;
					
				    do 
						{
							j++ ;
							s.type(Key.DOWN);
							sleep (1);
							s.type(Key.DOWN);
							sleep (1);
							s.type(Key.DOWN);
							sleep (1);
						    s.type(Key.DOWN);
						    sleep (1);
						    s.type(Key.DOWN);
						} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 1) && (j<6));
				    
					TestLogger.info("#6: User switch to Google account at step 1 successful, all user data switch to Google account at step #1");
					
					if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 5))
					{
						setTestcaseStatus("PASSED", "PASSED :  #6 : User switch to Google account at step 1 successful, all user data switch to Google account at step #1");
						SignoutCocCoc();
						SignoutCocCoc();
						clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
						s.type(Key.F4, Key.ALT);
					}
					else
					{
						setTestcaseStatus("FAILED", "FAILED :  #6 : User switch to Google account at step 1 successful BUT all user data DOES NOT  switch to Google account at step #1");
						SignoutCocCoc();
						SignoutCocCoc();
						clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
						s.type(Key.F4, Key.ALT);
					}
					
					
					
					
					
				}
				
				
				/**
				 * <b> Browser_GoogleServices_v1.1 </b> </br>
				 * <b> CaseID: </b> GoogleServices_Signin_Sync_22 </br>
				 * <b> CaseTitle: </b>Verify that the data synced not changed after add more Google account and remove in People section.</br>
				 * <b> Steps: </b>
1. Login with Google account.
2. Sync all data.
3. Observe on all data synced
4. Login with other Google account and sync data.
5. Observe on all data synced.
6. Disconnect Google accout at step #4
7. Observe on all data synced
				 *  EXPECT : 
#3 User login success, all data are sync to CocCoc correctly.
#5: User switch to Google account at step 1 successful, all data of Google accout signin at step#4 are synced.
#7: all data synced same on step #3
				 
				 * @author hanv
				
				 */
			
				public void GoogleServices_Signin_Sync_22()
				{
					TestLogger.info("1. Login with Google account.");
					startCocCocInEnglish();
					SigninToCocCoc(userNameGmail3, passwordGmail3);
					openLink("coccoc://settings/#coccoc-settings-users"); 
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    clickOn("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png");
				    waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 135);
				    s.click();
				    int i=1;
				    do 
					{
						i++ ;
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
					    s.type(Key.DOWN);
					    sleep (1);
					    s.type(Key.DOWN);
					} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 1) && (i<6));
				    
				  
				    TestLogger.info("2.Sync all data.");
				    TestLogger.info("3. Observe on all data synced");
				    
				    TestLogger.info("#3 : EXPECT : => User login success, all data are sync to CocCoc correctly.");
				    
				    if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 6))
					 {
						 setTestcaseStatus("PASSED", "PASSED # 3 :  User login success, all data are sync to CocCoc correctly. ");
						
					 }
					 else
					 {
						
						 setTestcaseStatus("FAILED", "FAILED # 3 :  User login NOT success, all data are NOT synced to CocCoc correctly. ");
					 }
			         
				    
				    
					TestLogger.info("4.Login with other Google account.");
					
					
					openLink("coccoc://settings/#coccoc-settings-users");
					
					TestLogger.info("2. Create new user on settings.");
				    waitForObjectPresent("pictures\\Browser_Users_Button_Addperson.png", 7);
					clickOn("pictures\\Browser_Users_Button_Addperson.png");
					 waitForObjectPresent("pictures\\Browser_Settings_Users_AddUser.png", 7); 
					clickOn("pictures\\Browser_Settings_Users_AddUser.png") ;
					sleep(10);
					SigninToCocCoc(userNameGmail6, passwordGmail6);
					
				    openLink("coccoc://extensions/");
				    waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 135);
				    s.click();
				    int k=1;
				    do 
					{
						k++ ;
						
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
					    s.type(Key.DOWN);
					    sleep (1);
					    s.type(Key.DOWN);
					    
					} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 1) && (k<6));  
				    
					TestLogger.info("5. Observe on all data synced.");
					
					TestLogger.info("#5:EXPECT :=>  User switch to Google account at step 1 successful, all data of Google accout signin at step#4 are synced.");
					

					 if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Icon_mega.png", 5))
					 {
						 setTestcaseStatus("PASSED", "PASSED # 5 : User switch to Google account at step 1 successful, all data of Google accout signin at step#4 ");
					 }
					 else
					 {
						 setTestcaseStatus("FAILED", "FAILED # 5 :  User switch to Google account at step 1 NOT successful, all data of Google accout NOT signin at step#4 ");
					 }
					
					TestLogger.info("6. Disconnect Google accout at step #4");
					
					SignoutCocCoc();
					
					TestLogger.info("7. Observe on all data synced");
					
				    openLink("coccoc://extensions/");
				    waitForObjectPresent("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 7);
				    moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Text_ExtensionMenu.png", 135);
				    s.click();
				    int l =1; 
				    do 
					{
						l++ ;
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
						s.type(Key.DOWN);
						sleep (1);
					    s.type(Key.DOWN);
					    sleep (1);
					    s.type(Key.DOWN);
					} while (!waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 1) && (l<6));  
				   
				    
					TestLogger.info("#7: all data synced same on step #3");
					
					 if (waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_ilivid.png", 5))
					 {
						 setTestcaseStatus("PASSED", "PASSED # 7 :  User login success, all data are sync to CocCoc correctly. ");
						 SignoutCocCoc();
						 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
							s.type(Key.F4, Key.ALT);
					 }
					 else
					 {
						 setTestcaseStatus("FAILED", "FAILED # 7 :  User login NOT success, all data are NOT synced to CocCoc correctly. ");
						 SignoutCocCoc();
						 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
							s.type(Key.F4, Key.ALT);
					 }
					  
				}
}
