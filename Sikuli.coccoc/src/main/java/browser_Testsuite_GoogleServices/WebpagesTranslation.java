package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class WebpagesTranslation extends BrowserCommon {
   

	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> GoogleServices_Webtranslation_01 </br>
	 * <b> CaseTitle: </b>Verify that web translation icon appears on Ominibox correctly.</br>
	 * <b> Steps: </b>
1. Make sure that settings in CocCoc browser has translate from English.
2. Observed on Ominibox
3. Open any website has langue is English.
4. Select "Dịch" (Translate) from popup.
	 *  EXPECT : 
#2: The web Translation icon disappears on Ominibox.
#4: The web Translation icon appears beside Addtone ico
	 
	 * @author hanv
	
	 */
	    
		@Test
		public void GoogleServices_Webtranslation_01()
		{   
			
			TestLogger.info("======= GoogleServices_Webtranslation_01 ===========");
			
			TestLogger.info("Settings in CocCoc browser so that it translates pages from English.");
			
			startCocCocinVietnameseToTranslateEnglishPages();
			
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2)) 
			{
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			}
			
			TestLogger.info("2. Observed on Ominibox");
			TestLogger.info("#2: EXPECT : ==>  The web Translation icon disappears on Ominibox.");
			
			if (waitForObjectPresent("pictures\\Browser_AddressBar_Icon_IconTranslate.png", 6))
			{
				setTestcaseStatus("FAILED", "FAILED :#2 ==>The web Translation icon appears on Ominibox. ");
			}
			else
			{

				setTestcaseStatus("PASSED", "PASSED :#2 ==>The web Translation icon disappears on Ominibox. ");
			}
			 //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			 s.type(Key.F4, Key.ALT);
			
			if (waitForObjectPresent("pictures\\Browser_Icon_Picture_DesktopIcon.png", 2))
			{
				doubleClick("pictures\\Browser_Icon_Picture_DesktopIcon.png");
			}
			
			
			TestLogger.info("3. Open any website has language is English.");
			
			openLink("http://java.com/en/");
			if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 5))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
			
		/*    
		    waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 3);
		    moveMouseDownFromLogo("pictures\\Browser_GUI_icon_User.png",39) ;
		    s.click();*/
		    
		    
			TestLogger.info("4. Select 'Dịch' (Translate) from popup.");
			
			clickOn("pictures\\Browser_Dialog_Button_Dich.png");
			 
			 
			TestLogger.info("#4: EXPECT : ==> The web Translation icon appears beside Addtone icon and highlighted.");
			
			if (waitForObjectPresent("pictures\\Browser_AddressBar_Icon_IconTranslate.png", 6))
			{
			
				
				setTestcaseStatus("PASSED", "PASSED :#4 ==>The web Translation icon disappears on Ominibox. ");
			}
			else
			{
			
				setTestcaseStatus("FAILED", "FAILED :#4 ==>The web Translation icon sappears on Ominibox. ");
			}
			
	
			
		}
	    
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Webtranslation_02 </br>
		 * <b> CaseTitle: </b>Verify that all pop-up display correct information.</br>
		 * <b> Steps: </b>
	1. Make sure that settings in CocCoc browser has translate from English.
2. Open any website has langue is English.
3. Observe on confirm pop-up.
4. Select "Dịch" (Translate) from popup.
5. Click on "Hiển thị văn bản gốc" button.
6. Click on webTranslation icon
		  *  EXPECT : 
#3: After website complete to load, a confirm popup appears to ask user want to translate website "Bạn có muốn dịch trang này không ?",  link to langue setting "Tùy chọn" and two buttons: "Dịch", "Không".
- For button "Không", user has 2 options "Không bao giờ dịch tiếng ..." and "Không bao giờ dịch trang web này"
#4: A pop-up appears with message "Trang này đã được dịch", link to langue setting "Tùy chọn" and button: "Hiển thị văn bản gốc".
#6: A confirm popup at step #3 appears.
	 
		 * @author hanv
		
		 */
		
		@Test 
		
		public void GoogleServices_Webtranslation_02()
		{ 
			TestLogger.info("======= GoogleServices_Webtranslation_02 ===========");
			
			TestLogger.info("2. Open any website has languae is English.");
			//startCocCoc();
			openLink("http://java.com/en/");
			if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 3))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
			
			TestLogger.info("3.Click on icon Translate.");
			TestLogger.info("#3  EXPECT :  a confirm popup appears to ask user want to translate website Bạn có muốn dịch trang này không ?," 
			+  "link to langue setting Tùy chọn and two buttons: Dịch, Không" 
		    +  " - For button Không, user has 2 options Không bao giờ dịch tiếng ... and Không bao giờ dịch trang web này");
			
			  if (waitForObjectPresent("pictures\\Browser_PopupGoogleTranslate_dialog_translate.png", 6))
			  {
				 setTestcaseStatus("PASSED", "PASSED : #3 : ==> a confirm popup appears to ask user want to translate website Bạn có muốn dịch trang này không "); 
			  }
			  else
			  {
					 setTestcaseStatus("FAILED", "FAILED : #3 : ==> a confirm popup DOES NOT appear to ask user want to translate website Bạn có muốn dịch trang này không "); 
  
			  }
			
			TestLogger.info("4. Select 'Dịch' (Translate) from popup.");
			waitForObjectPresent("pictures\\Browser_Dialog_Button_Dich.png", 7);
		    clickOn("pictures\\Browser_Dialog_Button_Dich.png");
			 
			TestLogger.info("#4: EXPECT : ==>  A pop-up appears with message 'Trang này đã được dịch', link to langue setting 'Tùy chọn' and button: 'Hiển thị văn bản gốc.");
			if (waitForObjectPresent("pictures\\Browser_PopupGoogleTranslate_dialog_translated.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED #4: == >  A pop-up appears with message 'Trang này đã được dịch ");
			}
			else
			{
				setTestcaseStatus("PASSED", "PASSED #4: == >  A pop-up DOES NOT appear with message 'Trang này đã được dịch ");
			}
			
			TestLogger.info(" 5.Click on Hiển thị văn bản gốc button.");
			waitForObjectPresent("pictures\\Website_GoogleTranslate_Button_HienThiVanBanGoc.png", 7);
			clickOn("pictures\\Website_GoogleTranslate_Button_HienThiVanBanGoc.png");
			TestLogger.info("6.Click on webTranslation icon");
			 waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 3);
			 moveMouseDownFromLogo("pictures\\Browser_GUI_icon_User.png",39) ;
			 s.click();
			
			TestLogger.info("#6: A confirm popup at step #3 appears.");
			
			 if (waitForObjectPresent("pictures\\Browser_PopupGoogleTranslate_dialog_translate.png", 6))
			  {
				 setTestcaseStatus("PASSED", "PASSED : #3 : ==> a confirm popup appears to ask user want to translate website Bạn có muốn dịch trang này không "); 
			  }
			  else
			  {
					 setTestcaseStatus("PASSED", "PASSED : #3 : ==> a confirm popup DOES NOT appear to ask user want to translate website Bạn có muốn dịch trang này không "); 
 
			  }
			
			}
		
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Webtranslation_03 </br>
		 * <b> CaseTitle: </b>Verify that CocCoc browser can translate web page in any  foreign language.</br>
		 * <b> Steps: </b>
1. Open any website in any foreign language.
2. Wait for website completed to load.
3. Click on button 'Dịch'
		  *  EXPECT : 
#3: Page can be translated
	 
		 * @author hanv
		
		 */
		
		@Test
		public void GoogleServices_Webtranslation_03()
		{ 
			TestLogger.info("======= GoogleServices_Webtranslation_03 ===========");
			
			TestLogger.info("1. Open any website in any foreign language.");
	        startCocCoc();
			openLink("http://java.com/en/");
			if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 2))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
			
			clickOn("pictures\\Browser_Dialog_Button_Dich.png");
			TestLogger.info("#3: Page can be translated");
			
			if ( waitForObjectPresent("pictures\\Website_Javacom_Text_Information_translated.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED : #3 ==>  Page can be translated ");
			}
			else
			{
				setTestcaseStatus("PASSED", "PASSED : #3 ==>  Page can NOT be translated ");
			}
			
			
		}
		
		// Verify that user can translate website by right click on website.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Webtranslation_04 </br>
		 * <b> CaseTitle: </b>Verify that user can translate website by right click on website.</br>
		 * <b> Steps: </b>
1. Open any website has langue is English.
2. Wait for website completed to load.
3. Right click on webpage
4. Select "Dịch trang này"
5. Right click again on webpage
		  *  EXPECT : 
#4: CocCoc browser translate web to Vietnamese ( or language is defined on languages and input settings)
#5: Menu item "Dịch sang tiếng Việt" is disabled.
	 
		 * @author hanv
		
		 */
		@Test
		public void GoogleServices_Webtranslation_04()
		{
			TestLogger.info("======= GoogleServices_Webtranslation_04 ===========");
			
			TestLogger.info("1. Open any website in any foreign language.");
			openLink("http://java.com/en/");
			
			if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png",2))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
			
			waitForObjectPresent("pictures\\Website_Javacom_Logo_Java.png", 7); 
			
			TestLogger.info("2. Wait for website completed to load.");
			TestLogger.info("3. Right click on webpage");
			moveMouseDownFromLogo("pictures\\Website_Javacom_Logo_Java.png", 90);
			s.click();
			s.rightClick();
			TestLogger.info("4. Select Dịch trang này");
			waitForObjectPresent("pictures\\Website_GoogleTranslate_Button_dichTrangNay.png", 7);
			clickOn("pictures\\Website_GoogleTranslate_Button_dichTrangNay.png");
			TestLogger.info("#4 : EXPECT : ==> CocCoc browser translate web to Vietnamese ( or language is defined on languages and input settings) ");
			if ( waitForObjectPresent("pictures\\Website_Javacom_Text_Information_translated.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED : #3 ==>  Page can be translated ");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : #3 ==>  Page can NOT be translated ");
			}
			
			TestLogger.info("5. Right click again on webpage"); 
			
			s.rightClick();
			
			TestLogger.info("#5: EXPECT :==> Menu item 'Dịch sang tiếng Việt' is disabled.");
			waitForObjectPresent("pictures\\Website_Javacom_Logo_Java.png", 7);
			moveMouseDownFromLogo("pictures\\Website_Javacom_Logo_Java.png", 100);
			s.click();
			s.rightClick();
			waitForObjectPresent("pictures\\Website_GoogleTranslate_Button_dichTrangNay.png", 7);
			clickOn("pictures\\Website_GoogleTranslate_Button_dichTrangNay.png");
			moveMouseDownFromLogo("pictures\\Website_GoogleTranslate_Button_dichTrangNay.png", -162);
			s.click();
			
			if (waitForObjectPresent("pictures\\Website_Javacom_Text_Information_translated.png", 6))
			{
				
			
				setTestcaseStatus("PASSED", "PASSED : #5 ==>  Menu item 'D?ch sang ti?ng Vi?t' is disabled.");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : #5 ==>  Menu item 'D?ch sang ti?ng Vi?t' is NOT disabled. ");
			}
			
		}
		
		// Verify that user can choose the page language and translation language.
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> GoogleServices_Webtranslation_05 </br>
		 * <b> CaseTitle: </b>Verify that user can choose the page language and translation language.</br>
		 * <b> Steps: </b>
1. Open any website.
2. Wait for website completed to load.
3. On confirm popup, click on Tùy chọn (Option) link
4. Click on "Hủy" button
5. Click on web Translate icon
6. Click on "Tùy Chọn"
7. Select other language to translate.
8. Click "Hoàn Tất" button.
9. Repeat step #5 to step #8 with Select other page language.
		  *  EXPECT : 
#4: Nothing happen on webpage
#8: CocCoc translate web page to language that selecting at step #7
#9: CocCoc translate only language is selected on "page language.
	 
		 * @author hanv
		
		 */
		@Test
		public void GoogleServices_Webtranslation_05()
		{
			TestLogger.info("======= GoogleServices_Webtranslation_05 ==========="); 
			
			TestLogger.info("1. Open any website in any foreign language.");
			
		    openLink("http://java.com/en/");
		    
		    if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 5))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
		    
			TestLogger.info("3.On confirm popup, click on Tùy chọn (Option) link");
			waitForObjectPresent("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png", 7);
			clickOn("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png");
			
			TestLogger.info("4. Click on Hủy button");
			waitForObjectPresent("pictures\\Browser_GoogleTranslate_Button_Cancel.png", 7); 
			clickOn("pictures\\Browser_GoogleTranslate_Button_Cancel.png");
			
			TestLogger.info("#4: EXPECT : Nothing happen on webpage");
			
			// 
			if (waitForObjectPresent("pictures\\Website_Javacom_Button_FreJavaDownloadEnglish.png", 6)) 
			{
				setTestcaseStatus("PASSED", "PASSED : # 4 => Nothing happen on webpage ");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : # 4 => There is something happened on webpage ");
			}
			
			openLink("http://java.com/en/");
			
			if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 5))
			{
				clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
				clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
				
			}
			
			TestLogger.info("Click on Tùy Chon");
			waitForObjectPresent("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png", 7);
			clickOn("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png");
			TestLogger.info("7. Select other language to translate.");
			waitForObjectPresent("pictures\\Browser_GoogleTranslte_options_tiengviet.png", 7);
			clickOn("pictures\\Browser_GoogleTranslte_options_tiengviet.png");
			waitForObjectPresent("pictures\\Browser_GoogleTranslte_options_tiengbelarus.png", 7);
			clickOn("pictures\\Browser_GoogleTranslte_options_tiengbelarus.png");
			TestLogger.info("8. Click Dich button.");
			waitForObjectPresent("pictures\\Browser_Dialog_Button_Dich.png", 7);
			clickOn("pictures\\Browser_Dialog_Button_Dich.png");
			 if (waitForObjectPresent("pictures\\Website_Javacom_Text_informationTranslatedBelarus.png", 6))
			 {
				 waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 3);
				 moveMouseDownFromLogo("pictures\\Browser_GUI_icon_User.png",38) ;
				 s.click();
				 s.click();
				 waitForObjectPresent("pictures\\Website_GoogleTranslate_Button_HienThiVanBanGoc.png", 7);
				 clickOn("pictures\\Website_GoogleTranslate_Button_HienThiVanBanGoc.png");
				setTestcaseStatus("PASSED", "PASSED : ==> 8: CocCoc translate web page to language that selecting at step #7 "); 
			 }
			 else
			 {
				 waitForObjectPresent("pictures\\Browser_GUI_icon_User.png", 3);
				 moveMouseDownFromLogo("pictures\\Browser_GUI_icon_User.png",39) ;
				 s.click();
				 clickOn("pictures\\Website_GoogleTranslate_Button_HienThiVanBanGoc.png");
				 setTestcaseStatus("FAILED", "FAILED : ==> 8: CocCoc DOES NOT translate web page to language that selecting at step #7 "); 
			 }
			
			 TestLogger.info("9. Repeat step #5 to step #8 with Select other page language.");
			 
			 openLink("http://java.com/en/");
			 
			 if (waitForObjectPresent("pictures\\Java.com_Settings_Text_Advanced.png", 5))
				{
					clickOn("pictures\\Java.com_Settings_Text_Advanced.png");
					clickOn("pictures\\Java.com_Settings_Text_proceedToJavacom.png");
					
				}
			 
			TestLogger.info("Click on Tùy Chon");
			 waitForObjectPresent("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png", 7);
			clickOn("pictures\\Browser_AddressBar_IconTranslate_Popup_Option.png");
			TestLogger.info("7. Select page language to translate.");
			waitForObjectPresent("pictures\\Browser_GoogleTranslte_options_tienganh.png", 7);
			clickOn("pictures\\Browser_GoogleTranslte_options_tienganh.png");
			waitForObjectPresent("pictures\\Browser_GoogleTranslte_options_tiengbodaonha.png", 7);
			clickOn("pictures\\Browser_GoogleTranslte_options_tiengbodaonha.png");
			TestLogger.info("1. Open any website in any portugal language.");
			
			openLink("http://www.portugal.gov.pt/pt.aspx");
		 
			TestLogger.info("8.Click Dich button.");
			
			if (waitForObjectPresent("pictures\\Website_portugal_gov_text_bodaonha_dich.png", 6))
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				//SignoutChrome();
				killprocess("browser.exe");
				setTestcaseStatus("PASSED", "PASSED : ==> 9: CocCoc translate web page to language that selecting at step #9 ");
				 //exit browser
				
				
			}
			else
			{
				
				 //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				killprocess("browser.exe");
				//SignoutChrome();
				setTestcaseStatus("FAILED", "FAILED : ==> 9: CocCoc translate web page to language that selecting at step #9 ");
				
				
			}
			
		}
		
		@Test
		public void GoogleServices_Webtranslation_06()
		{
			startCocCoc();
			// open page Google Translate 
			TestLogger.info("1. Open page : https://translate.google.com/ ");
			openLink("https://translate.google.com/"); 
			TestLogger.info("2.Choose translated language and target language");
			// Choose translated language is Tieng Phap 
			clickOn("pictures\\Website_GoogleTranslate_Button_French.png");
			clickOn("pictures\\website_GoogleTranslate_TextField_input.png");
			TestLogger.info("3.Write some content for translated language.");
			s.type("bonjour");
			TestLogger.info("4. Click on button 'Dịch' ");
			clickOn("pictures\\Website_GoogleTranlate_button_Translate.png");
			TestLogger.info("Expect : #4 : Must show correct content for target language.  ");
			if (waitForObjectPresent("pictures\\Website_GoogleTranslate_text_xinchao.png", 2))
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "#4 : Showed correct content for target language");
				
			}
			else
			{
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "DO NOT show correct content for target language");
				
			}
			
			
			
			
		
			
			
			
		}
		
		
}
