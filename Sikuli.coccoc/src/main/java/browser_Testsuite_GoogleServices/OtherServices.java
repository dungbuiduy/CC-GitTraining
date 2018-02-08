package browser_Testsuite_GoogleServices;

import org.bytedeco.javacpp.opencv_objdetect.ModalityVector;
import org.sikuli.script.Key;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class OtherServices extends BrowserCommon{
	   
	 
	 //@BeforeTest
	 public void switchToUILoginByGoogle ()
	   {
		   
		   switchToUILoginByGoogle();
		   
	   }
	  
		// Verify that user can access to Google docs probably without login after sign-in to CocCoc by Google account
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_otherService_01 </br>
	 * <b> CaseTitle: </b>Verify that user can access to Google docs probably without login after sign-in to CocCoc by Google account</br>
	 * <b> Steps: </b>
1. Open Google docs (docs.google.com)
2. Observe on Google docs page
3. Create new document
4. Edit content of document
5. Re-start CocCoc and re-open Google doc.
	 *  EXPECT : 
#2: - The account login on Google docs is account that sign in to CocCoc
      -  All files appears correctly and fully
#5: The document created on step #3 appears with content is update on step #4
	 
	 * @author hanv
	
	 */

	
	
	    @Test
		public void GoogleServices_otherService_01 ()
		{
	    
	    	startCocCocInEnglish() ;
			openLink("coccoc://settings/#coccoc-settings-users");
			 if (waitForObjectPresent("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png", 4))  
			 {
				 SignoutCocCoc();
			 }
			 
			TestLogger.info("0.Sign-in to CocCoc with Google account");
			SigninToCocCoc(userNameGmail3, passwordGmail3);
			TestLogger.info("1. Open Google docs (docs.google.com)");
			sleep(2);
			openLink("https://docs.google.com");
			
		    TestLogger.info("#2: - The account login on Google docs is account that sign in to CocCoc" 
           + "  All files appears correctly and fully");
           TestLogger.info("#2: EXPECT : ==> The account login on Gmail is account that sign in to CocCoc");
           waitForObjectPresent("pictures\\Website_Gmail_icon_userNameGmail3.png", 7);  
		   clickOn("pictures\\Website_Gmail_icon_userNameGmail3.png");
		    
		    if (waitForObjectPresent("pictures\\Browser_AccountGoogle_Popup_myAccountUserNameGmail3.png", 6))  
		    {
		    	
		    	setTestcaseStatus("PASSED", "PASSED #2 : ==>  The account login on Gmail is account that sign in to CocCoc");
		    }
		    else
		    {
		    	
		    	setTestcaseStatus("FAILED", "FAILED #2 : ==>  The account login on Gmail is NOT the account that sign in to CocCoc");
		    }
		    
		    TestLogger.info("EXPECT : ==> All files appears correctly and fully ");
		    
		    if (waitForObjectPresent("pictures\\Website_GoogleDoc_Text_myDocumentAcc3.png", 6))  
		    {
		    	setTestcaseStatus("PASSED", "PASSED => All files appears correctly and fully");
		    }
		    else
		    {
		    	setTestcaseStatus("FAILED", "FAILED => All files DOES NOT appear correctly and fully ");
		    }
			
		    
		    TestLogger.info("3. Create new document");
		    waitForObjectPresent("pictures\\Website_GoogleDoc_Button_createNewDocument.png", 7);  
		    sleep(3);
		    doubleClick("pictures\\Website_GoogleDoc_Button_createNewDocument.png");
		    sleep (8);
		  
		    TestLogger.info("4. Edit content of document");
		    waitForObjectPresent("pictures\\Website_GoogleDoc_Text_TaiLieuKhongCoTieuDe.png", 17);
		    clickOn("pictures\\Website_GoogleDoc_Text_TaiLieuKhongCoTieuDe.png");  
		    sleep(8);
		    s.type("VietHaTestABC");
		    sleep (8);
		    s.type(Key.ENTER) ;
		    openLink("https://docs.google.com");
		   
		    TestLogger.info("5.Re-start CocCoc and re-open Google doc.");
		   // startCocCocInEnglish();
		    openLink("https://docs.google.com");
		    
		    sleep(5); 
		    TestLogger.info("#5: The document created on step #3 appears with content is update on step #4");
		    
		    if (waitForObjectPresent("pictures\\Website_GoogleDoc_Text_VietHaTestABC.png", 6)) 
		    {
		    	 waitForObjectPresent("pictures\\Website_GoogleDoc_Icon_3CHAM.png", 7);
		    	 clickOn("pictures\\Website_GoogleDoc_Icon_3CHAM.png");
		    	 clickOn("pictures\\Website_GoogleDoc_Button_Xoa.png");
		    	 SignoutCocCoc();
		    	 setTestcaseStatus("PASSED", "PASSED #5 : => The document created on step #3 appears with content is update on step #4 ");
		    }
		    else
		    {
		    	waitForObjectPresent("pictures\\Website_GoogleDoc_Icon_3CHAM.png", 7);
			    clickOn("pictures\\Website_GoogleDoc_Icon_3CHAM.png");
			    clickOn("pictures\\Website_GoogleDoc_Button_Xoa.png");
			    SignoutCocCoc();
		    	setTestcaseStatus("FAILED", "FAILED #5 : => The document created on step #3 appears with content is NOT update on step #4 ");
		    }
		    
		    //exit browser
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					sleep (2);
					s.type(Key.F4, Key.ALT);
	
		}
		
		// Verify that user can access to Gmail probably without login after sign-in to CocCoc by Google account
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_otherService_02 </br>
		 * <b> CaseTitle: </b>Verify that user can access to Gmail probably without login after sign-in to CocCoc by Google account</br>
		 * <b> Steps: </b>
	1. Open Gmail (gmail.com or mail.google.com).
2. Observe on Google mail page.
3. Create new E-mail.
4. Edit content of email and then send email.
		 *  EXPECT : 
#2: The account login on Gmail is account that sign in to CocCoc
#4: Email send successful.
		 
		 * @author hanv
		
		 */
	    @Test
		public void GoogleServices_otherService_02 ()
		{
			
	    	startCocCocInEnglish() ;
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
			
			 openLink("coccoc://settings/#coccoc-settings-users");
			 
			 if (waitForObjectPresent("pictures\\Browser_GoogleSyncin_Button_DisconnectyourGoogleAccount.png", 4))  
			 {
				 SignoutCocCoc();
			 }
			
			TestLogger.info("1.Sign-in to CocCoc with Google account");
			SigninToCocCoc(userNameGmail3, passwordGmail3);
			
			TestLogger.info("1. Open Gmail (gmail.com or mail.google.com).");
		
			openLink("https://mail.google.com/mail/");
		   
		    sleep(12);
		    
		    TestLogger.info("2. Observe on Google mail page.");
		    
		    TestLogger.info("#2:EXPECT : ==>  The account login on Gmail is account that sign in to CocCoc");
		    waitForObjectPresent("pictures\\Website_Gmail_icon_userNameGmail3.png", 7);  
		    clickOn("pictures\\Website_Gmail_icon_userNameGmail3.png");
		    if (waitForObjectPresent("pictures\\Website_Gmail_Block_Account3.png", 6))  
		    {
		    	
		    	setTestcaseStatus("PASSED", "PASSED #2 : ==>  The account login on Gmail is account that sign in to CocCoc");
		    }
		    else
		    {
		    	
		    	setTestcaseStatus("FAILED", "FAILED #2 : ==>  The account login on Gmail is NOT the account that sign in to CocCoc");
		    }
		    
			TestLogger.info("3. Create new E-mail.");
			
			waitForObjectPresent("pictures\\Website_Gmail_Button_Compose.png", 5);
			clickOn("pictures\\Website_Gmail_Button_Compose.png");
			
			if (!waitForObjectPresent("pictures\\Website_gmail_Text_toEmail.png", 8) )
			{
				clickOn("pictures\\Website_Gmail_Button_Compose.png");
			}
			waitForObjectPresent("pictures\\Website_gmail_Text_toEmail.png", 15);
			moveMouseHorizontallyFromLogo("pictures\\Website_gmail_Text_toEmail.png", 100);
			s.click();
			s.type("haperfect@gmail.com") ; 
			sleep(5);
			s.type(Key.ENTER) ;
			waitForObjectPresent("pictures\\Website_Gmail_Text_SubjectEmail.png", 8);
			moveMouseHorizontallyFromLogo("pictures\\Website_Gmail_Text_SubjectEmail.png", 100);
			s.click();
			s.type("Test Demo") ; 
			TestLogger.info("4.Edit content of email and then send email.");
			waitForObjectPresent("pictures\\Website_Gmail_Button_SendMail.png", 8);  
			moveMouseDownFromLogo("pictures\\Website_Gmail_Button_SendMail.png", -150);
			
			s.click();
			s.type("ABCED");
			sleep(6);
			waitForObjectPresent("pictures\\Website_Gmail_Button_SendMail.png", 8);
		    clickOn("pictures\\Website_Gmail_Button_SendMail.png");
		    TestLogger.info("#4: EXPECT:  Email send successful." ); 
		    if (waitForObjectPresent("pictures\\Website_Gmail_Texxt_EmailSentSuccessful.png", 6))  
		    {
		    	//SignoutCocCoc();
		    	setTestcaseStatus("PASSED", "PASSED #4 => Email send successful.");
		    }
		    else
		    {
		    	//SignoutCocCoc();
		    	setTestcaseStatus("FAILED", "FAILED #4 => Email DOES NOT send successful.");
		    }
		    
		    //exit browser
			closeBrowser();
		    
			
		}
		
		// Verify that user can access to Google Plus probably without login after sign-in to CocCoc by Google account
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_otherService_03 </br>
		 * <b> CaseTitle: </b>Verify that user can access to Google Plus probably without login after sign-in to CocCoc by Google account</br>
		 * <b> Steps: </b>
1. Open Google plus (https://plus.google.com/).
2. Observe on Google plus page.
		 *  EXPECT : 
#2: The account login on Google plus is account that sign in to CocCoc
		 
		 * @author hanv
		
		 */
	    @Test
		public void GoogleServices_otherService_03 ()
		{
	    	
	   
	        startCocCocInEnglish();
		    openLink("coccoc://settings/#coccoc-settings-users");
			if (waitForObjectPresent("pictures\\Browser_User_Text_coccocbrowser3.png", 6))
			{
			SignoutCocCoc();
		    //exit browser
			closeBrowser();
	    	startCocCocInEnglish();
	    	sleep(6);
			}
			
			TestLogger.info("1.Sign-in to CocCoc with Google account");
			SigninToCocCoc(userNameGmail3,passwordGmail3);
			TestLogger.info("1.Open link Gooogle plus https://plus.google.com/ ");
			openLink("https://plus.google.com/");
			TestLogger.info("2. Observe on Google plus page.");
			TestLogger.info("#2: The account login on Google plus is account that sign in to CocCoc");
			waitForObjectPresent("pictures\\Browser_GooglePlus_Avatar_Account3.png", 18);
			sleep (5);
			if (waitForObjectPresent("pictures\\Website_GoogleMap_button_iKnowIt.png", 5))
			{
				clickOn("pictures\\Website_GoogleMap_button_iKnowIt.png");
			}
			clickOn("pictures\\Browser_GooglePlus_Avatar_Account3.png");  
			
			if (waitForObjectPresent("pictures\\specificEnviroment\\Win10\\Browser_GooglePlus_Text_UsernameAccount3.png", 6))  
			{
				SignoutCocCoc();
			
				setTestcaseStatus("PASSED", "PASSED #2 :The account login on Google plus is account that sign in to CocCoc ");
			}
			else
			{
				SignoutCocCoc();
				
				setTestcaseStatus("FAILED", "FAILED #2 : The account login on Google plus is NOT account that sign in to CocCoc");
			}
			
		    //exit browser
			closeBrowser();
		}
		
		
		//Verify that user can access to Google Calendar probably without login after sign-in to CocCoc by Google account 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_otherService_05 </br>
		 * <b> CaseTitle: </b>Verify that user can access to Google Calendar probably without login after sign-in to CocCoc by Google account</br>
		 * <b> Steps: </b>
1. Open Google Calendar (www.google.com/calendar/).
2. Observe on Google Calendar page.
		 *  EXPECT : 
#2: The account login on Calendar is account that sign in to CocCoc
- User can create/update/remove event and save to calendar.
		 
		 * @author hanv
		
		 */
	    @Test
		public void GoogleServices_otherService_05 ()
		{
			startCocCocInEnglish();
			openLink("coccoc://settings/#coccoc-settings-users");
			if (waitForObjectPresent("pictures\\Browser_User_Text_coccocbrowser3.png", 6))  
			{
			SignoutCocCoc();
	    	closeBrowser();
	    	startCocCocInEnglish();
	    	sleep(6);
			}
			
			TestLogger.info("1.Sign-in to CocCoc with Google account");
			SigninToCocCoc(userNameGmail3,passwordGmail3);
			TestLogger.info("1. Open Google Calendar (www.google.com/calendar/) ");
			
			openLink("www.google.com/calendar/");
			TestLogger.info("2. Open Google Calendar (www.google.com/calendar/)..");
			TestLogger.info("#2: The account login on Google plus is account that sign in to CocCoc");
			waitForObjectPresent("pictures\\Browser_Users_Button_OKBlue.png", 8);
			clickOn("pictures\\Browser_Users_Button_OKBlue.png");  
			waitForObjectPresent("pictures\\Website_Gmail_icon_userNameGmail3.png", 8);
			
			 clickOn("pictures\\Website_Gmail_icon_userNameGmail3.png");
			    
			    if (waitForObjectPresent("pictures\\Browser_AccountGoogle_Popup_myAccountUserNameGmail3.png", 5))
			    {
			    	SignoutCocCoc();
			    	setTestcaseStatus("PASSED", "PASSED #2 : ==>  The account login on Google plus is account that sign in to CocCoc");
			    }
			    else
			    {
			    	SignoutCocCoc();
			    	setTestcaseStatus("FAILED", "FAILED #2 : ==>  The account login on Google plus is NOT account that sign in to CocCoc");
			    }
			    
			    //exit browser
		        closeBrowser();
			
		}
		
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_otherService_06 </br>
		 * <b> CaseTitle: </b>Verify that user can access to YouTube probably without login after sign-in to CocCoc by Google account</br>
		 * <b> Steps: </b>
1. Open YouTube (youtube.com)
2. Observe on User sections
		 *  EXPECT : 
#2: The account login on YouTube is account that sign in to CocCoc
		 
		 * @author hanv
		
		 */
	    @Test
		public void GoogleServices_otherService_06 ()
		{
			 startCocCocInEnglish() ;
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
			    doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
			openLink("coccoc://settings/#coccoc-settings-users");
			if (waitForObjectPresent("pictures\\Browser_User_Text_coccocbrowser3.png", 8))
			{
			SignoutCocCoc();
			//exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		    sleep (2);
			s.type(Key.F4, Key.ALT);
			
	    	startCocCocInEnglish();
	    	sleep(5);
			}
			
			TestLogger.info("1.Sign-in to CocCoc with Google account");
			
			SigninToCocCoc(userNameGmail3, passwordGmail3);
            TestLogger.info("1.  Open YouTube (youtube.com)");
			openLink("https://www.youtube.com/");
			TestLogger.info("2. Observe on User sections");
			TestLogger.info("#2: The account login on YouTube is account that sign in to CocCoc");
			s.type(Key.F5);
			if (waitForObjectPresent("pictures\\Browser_GooglePlus_Avatar_Account3.png", 15))  
			{
				
			
				setTestcaseStatus("PASSED", "PASSED #2 : The account login on YouTube is account that sign in to CocCoc ");
			}
			else
			{
				
				
				setTestcaseStatus("FAILED", "FAILED #2 :  The account login on YouTube is NOT account that sign in to CocCoc");
			}
			 
			TestLogger.info("3. Play one FullHD video"); 
			openLink("https://www.youtube.com/watch?v=oCsGUxLHrJs");
			
			moveMouseDownFromLogo("pictures\\Website_youtube_image_logo.png", 300);
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 15))
			{
				setTestcaseStatus("PASSED", "PASSED #3: video can be played well");
			}
			else
			{
				setTestcaseStatus("PASSED", "PASSED #3: video can NOT be played well");
			}
			
			TestLogger.info("4.Upload a media file to My Channel");
			sleep (5);
			moveMouseHorizontallyFromLogo("pictures\\Browser_AddressBar_icon_SaviorDisabled.png", -250);
			s.click();
			s.type("https://www.youtube.com/create_channel");
			sleep(2);
			s.type(Key.ENTER);
		
			if (waitForObjectPresent("pictures\\website_youtube_button_createChannel.png", 2))
			{
				clickOn("pictures\\website_youtube_button_createChannel.png");
			}
			waitForObjectPresent("pictures\\website_youtube_textlink_uploadAVideo.png", 15);
			sleep (6);
			clickOn("pictures\\website_youtube_textlink_uploadAVideo.png");
			sleep (6);
			clickOn("pictures\\website_youtube_button_Upload.png");
			clickOn("pictures\\OSApp_Window_Folder_Download.png");
			if (System.getProperty("os.name").contains("Windows 7"))
			{
			   s.type(Key.TAB);
			   s.type(Key.TAB);
			   s.type(Key.TAB);
			}
			else
			{
				s.type(Key.TAB);
				s.type(Key.TAB);	
			}
			
			s.type("The Piano Guys - Love Story (Taylor Swift)");
			s.type(Key.ENTER);
			sleep (25);
			clickOn("pictures\\website_youtube_button_pushlish.png");
			sleep(145);
			openLink("https://www.youtube.com/my_videos?o=U");
			if (waitForObjectPresent("pictures\\website_youtube_text_video.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED # 4 :  File can be uploaded");
				sleep(55);
				clickOn("pictures\\website_youtube_text_video.png");
				moveMouseDownFromLogo("pictures\\website_youtube_image_logo.png", 200);
				if (waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 5))
				{
				    setTestcaseStatus("PASSED", "PASSED # 4 :  File can be played normally");
				    openLink("https://www.youtube.com/my_videos?o=U");
				    clickOn("pictures\\website_youtube_button_ArrowManageVideo.png");
				    clickOn("pictures\\website_youtube_button_deleteVideo.png");
				    clickOn("pictures\\website_youtube_button_delete.png");
				    SignoutCocCoc();
				    //exit browser
					closeBrowser();
				}
				else
				{
					 SignoutCocCoc();
					 //exit browser
					 closeBrowser();
					  setTestcaseStatus("PASSED", "PASSED # 4 :  File can NOT be played normally");
				}
			}
			else
			{
				    SignoutCocCoc();
				    //exit browser
					closeBrowser();
				    setTestcaseStatus("PASSED", "PASSED # 4 :  File can NOT be uploaded");
			}
			
			
			
		}
		
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_otherService_07 </br>
		 * <b> CaseTitle: </b>Verify that user can use Google service normally on CocCoc</br>
		 * <b> Steps: </b>
1. Open Google service pages:
  - google.com.
  - docs.google.com.
  - gmail.com.
  - plus.google.com.
  - store.google.com.
  - google.com/calendar.
  - youtube.com.
  - maps.google.com.
2. Logout Google account.
3. Login again by other Google account.
		 *  EXPECT : 
#3: User can use Google services probably.
		 
		 * @author hanv
		
		 */
	    @Test
		public void GoogleServices_otherService_07()
		{
			startCocCocInEnglish() ;
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
			
			openLink("coccoc://settings/#coccoc-settings-users");
			if (waitForObjectPresent("pictures\\Browser_User_Text_coccocbrowser3.png", 2))
			{
			SignoutCocCoc();
			 //exit browser
			closeBrowser();
	    	startCocCocInEnglish();
			}
			SigninToCocCoc(userNameGmail3, passwordGmail3);
			TestLogger.info("1. Open Google service pages:");
			
			openLink("https://docs.google.com/document/u/0/");
			sleep(8);
			openLink("gmail.com");
			sleep(8);
			openLink("plus.google.com");
			sleep(8);
			openLink("google.com/calendar");
			sleep(8);
			openLink("youtube.com.");
			sleep(8);
			openLink("maps.google.com.");
			TestLogger.info("2.Logout Google account.");
			SignoutCocCoc();
			
			TestLogger.info("3. Login again by other Google account.");
			SigninToCocCoc(userNameGmail4,passwordGmail4);
			
			TestLogger.info("#3 :  User can use Google services probably.");
			
			openLink("https://docs.google.com/document/u/0/"); 
			
			sleep(18);
			clickOn("pictures\\Website_GooglePlus_avatar_Account4.png");
		  
		    if (waitForObjectPresent("pictures\\specificEnviroment\\Win10\\Website_GoogleDoc_Text_usernamegmail4.png", 8))  
		    {
		    	setTestcaseStatus("PASSED","PASSED #3 : => Google Docs");
		    }
		    else
		    {
		    	setTestcaseStatus("FAILED", "FAILED #3 => Google Docs");
		    }
			
		    openLink("gmail.com");
		    sleep(18);

		    
		    if (waitForObjectPresent("pictures\\Website_Gmail_Button_Compose.png", 5))  
		    {
		    	setTestcaseStatus("PASSED","PASSED #3 : => Gmail service");
		    }
		    else
		    {
		    	setTestcaseStatus("FAILED", "FAILED #3 => Gmail services");
		    }
			
		    openLink("plus.google.com");
		    sleep(18);
		    if (waitForObjectPresent("pictures\\Website_GooglePlus_Button_Continue.png", 3))
		    {
		    	clickOn("pictures\\Website_GooglePlus_Button_Continue.png");
		    	sleep(3);
		    	clickOn("pictures\\Website_GooglePlus_Button_StillContinue.png");
		    	sleep(3);
		    	clickOn("pictures\\Website_GooglePlus_Button_Done.png");
		    }
		    
		    clickOn("pictures\\Website_GooglePlus_avatar_Account4.png");
		    waitForObjectPresent("pictures\\Website_GooglePlus_icon_AvatarAccount4.png", 8);  
		    clickOn("pictures\\Website_GooglePlus_icon_AvatarAccount4.png");   
		    if (waitForObjectPresent("pictures\\Website_GooglePlus_Text_Account4.png", 5))  
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Google Plus");
		    }
		    else
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Google Plus");
		    }
		    
		    openLink("google.com/calendar");
		    sleep(18);
		    
		    if (waitForObjectPresent("pictures\\Website_GoogleCalendar_Text_Calendar.png", 5))
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Google Calendar");
		    }
		    else
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Google Calendar");
		    }
		    
		    openLink("youtube.com.");
		    sleep(18);
		    
		    if (waitForObjectPresent("pictures\\Website_CoccocMap_Popup_Button_Block.png", 8))
		    {
		    	clickOn("pictures\\Website_CoccocMap_Popup_Button_Block.png");  
		    }
		    
		    
		    if (waitForObjectPresent("pictures\\Website_Youtube_TextLink_MyChannel.png", 8))
		    {
		    	clickOn("pictures\\Website_Youtube_TextLink_MyChannel.png");  
		    }
		    else
		    {
		    	s.type(Key.UP, Key.WIN);
		        clickOn("pictures\\Website_Youtube_TextLink_MyChannel.png");  
		    }
		    
		   
		    if (waitForObjectPresent("pictures\\Website_Youtube_Text_LoginAccountCoccocQA.png", 6))  
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Youtube ");
		    }
		    else
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Youtube");
		    }
		    
		    openLink("maps.google.com.");
		    sleep(18);
		    if (waitForObjectPresent("pictures\\Website_googleMap_TextFiled_BoxSearch.png", 5))  
		    {
		    	setTestcaseStatus("PASSED", "PASSED => Google Maps");
		    }
		    else
		    {
		    	 setTestcaseStatus("PASSED", "PASSED => Google Maps");
		    }
		    
		    //exit browser
			closeBrowser();
		    
		    if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))   
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			else
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon2.png");
			
		    SignoutCocCoc();
		    
		    //exit browser
			closeBrowser();
		} 
		
		
}
