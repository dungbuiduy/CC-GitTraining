package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class SafeBrowsing extends BrowserCommon {
   
	    
		// Check Malware extension blocking when installing a malware extension
	/**
	 * <b> Browser_GoogleServices_v1.1 </b> </br>
	 * <b> CaseID: </b> Browser_SNIFF_Others_01 </br>
	 * <b> CaseTitle: </b>Check Malware extension blocking when installing a malware extension</br>
	 * <b> Steps: </b>
Configure: uncomment service.corom.vn in hosts file as this functions works with production environment
Install a malicious extension in the blacklist of CocCoc (refer: https://trac.coccoc.vn/coccoc/ticket/31000) from Google Web Store.

=> In this case, Zwinky
	  *  EXPECT : 
After the extension is installed, a information bar displays to notify about malware extension:
VI version: "Tiện ích Zwinky có thể là phần mềm độc hại và đã bị vô hiệu hóa" with three buttons: "Tiếp tục khóa tiện ích", "Xóa khỏi trình duyệt", "Tôi tin tưởng tiện ích này, bật lại tiện ích"
EN version: "Extension Zwinky probably is a malware and has been disabled" with tree buttons "Keep disabled", "Remove from browser", "I trust this extension, enable it"
 
	 * @author hanv
	
	 */
		@Test
		public void Browser_SNIFF_Others_01()
		{
		  TestLogger.info("Install a malicious extension in the blacklist of CocCoc");
			
			startCocCocInEnglish();
			waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("https://chrome.google.com/webstore/search/ilivid?hl=vi");
		    s.type(Key.ENTER);
			waitForObjectPresent("pictures\\Website_GoogleStore_Icon_Iconilivid.png", 7);  		
			clickOn("pictures\\Website_GoogleStore_Icon_Iconilivid.png");
			waitForObjectPresent("pictures\\Website_GoogleStore_Button_themvaochrome.png", 7); 
			clickOn("pictures\\Website_GoogleStore_Button_themvaochrome.png");
			waitForObjectPresent("pictures\\Website_GoogleStore_Button_AddExtension.png", 7);
			clickOn("pictures\\Website_GoogleStore_Button_AddExtension.png");	
			if (waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslate.png", 6))
			{
				waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png", 7);
				clickOn("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png");
			}
			TestLogger.info(" After the extension is installed, a information bar displays to notify about malware extension:\n" +
           "EN version: 'Extension Zwinky probably is a malware and has been disabled' with tree buttons 'Keep disabled', 'Remove from browser', 'I trust this extension, enable it'");
			
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_CloseInfoBar.png", 6))
			{
				
			
				setTestcaseStatus("PASSED", " PASSED ==> # 1After the extension is installed, a information bar displays to notify about malware extension");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED : ==> # 1 After the extension is installed, a information bar DOES displays to notify about malware extension");
				
			}
			
			
			
			
		}
		
		//Check button "Keep disabled" in info bar 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Browser_SNIFF_Others_02 </br>
		 * <b> CaseTitle: </b>Check button "Keep disabled" in info bar </br>
		 * <b> Steps: </b>
1. Install a malicious extension (in the blacklist) from Apps store
2. In the info bar, click on button "Keep disabled"
3. Open Extensions and check
4. Enable this extension
		 *  EXPECT : 
2. Inforbar is closed when user clicks on this button
3. In extension list, the extension is disabled and there is a message: 
VI: "Tiện ích có thể là phần mềm độc hại và đã bị vô hiệu hóa" 
EN: Potential malware.
 
4. When extension is enabled, message changes to:
VI: "Tiện ích có thể là phần mềm độc hại"
EN : "Potential malware."
		 
		 * @author hanv
		
		 */
		@Test
		public void Browser_SNIFF_Others_02()
		{
		
			TestLogger.info("2. In the info bar, click on button Keep disabled");  
			waitForObjectPresent("pictures\\Browser_Extension_Popup_KeepDisabled.png", 7);   
			clickOn("pictures\\Browser_Extension_Popup_KeepDisabled.png");
			
			TestLogger.info("#2. Inforbar is closed when user clicks on this button");  
			if (waitForObjectPresent("pictures\\Browser_Extension_Popup_KeepDisabled.png", 2))
			{
				setTestcaseStatus("FAILED", "FAILED : ==> #2 :Inforbar is NOT closed when user clicks on this button ");
			}
			else
			{
				setTestcaseStatus("PASSED", " PASSED ==> #2. Inforbar is closed when user clicks on this button ");
			}
			
			
			
			TestLogger.info("3. Open Extensions and check");
			waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("coccoc://extensions/");
		    s.type(Key.ENTER);
		    waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_Savior.png", 7);
			clickOn("pictures\\Browser_ExtensionPage__icon_Savior.png");
			int i= 1;
			do 
			{
			    i++ ;
				s.type(Key.DOWN); 
				s.type(Key.DOWN);  
				s.type(Key.DOWN); 
				
				
			} while (!waitForObjectPresent("pictures\\Browser_ExtenstionPage_TextLink_GetMoreExtension.png", 1) && (i<6)) ;
			 TestLogger.info("#3. In extension list, the extension is disabled and there is a message:'Potential malware.");
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_CheckBox_StatusDisabled.png", 6))
			{
				setTestcaseStatus("PASSED", "PASSED => #3. In extension list, the extension is disabled and there is a message:'Potential malware.");
			}
			else
			{
				setTestcaseStatus("FAILED", "FAILED => #3. In extension list, the extension is enabled");
			}
			TestLogger.info("4. Enable this extension");
			 waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 402);
			s.click();
			
			hoverImage("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png");
			TestLogger.info("#4. In extension list, the extension is esabled and there is a message:'Potential malware.");
			
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Checkbox_StatusEnabled.png", 6))  
			{
				waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 518);
				s.click();
				
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
				sleep (3);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED => #4. In extension list, the extension is esabled and there is a message:'Potential malware.");
				
			}
			else
			{
				waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 518);
				s.click();
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
				sleep (3);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "FAILED => #4. In extension list, the extension is disabled and there is a message:'Potential malware.");
			}
			
			
		}
		//Check button "Remove from browser" in info bar 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Browser_SNIFF_Others_03 </br>
		 * <b> CaseTitle: </b>Check button "Remove from browser" in info bar  </br>
		 * <b> Steps: </b>
1. Install a malicious extension (in the blacklist) from Apps store
2. In the info bar, click on button "Remove from browser"
3. Open Extensions and check
		 *  EXPECT : 
#3: The extension is removed from Extension list
		 
		 * @author hanv
		
		 */
		@Test
		public void Browser_SNIFF_Others_03()
		{
            TestLogger.info("Install a malicious extension in the blacklist of CocCoc");
			
			startCocCocInEnglish();
			
			openLink("https://chrome.google.com/webstore/search/ilivid?hl=vi");
		   
			waitForObjectPresent("pictures\\Website_GoogleStore_Icon_Iconilivid.png", 7);
			
			clickOn("pictures\\Website_GoogleStore_Icon_Iconilivid.png");
			waitForObjectPresent("pictures\\Website_GoogleStore_Button_themvaochrome.png", 7);
			clickOn("pictures\\Website_GoogleStore_Button_themvaochrome.png");
			waitForObjectPresent("pictures\\Website_GoogleStore_Button_AddExtension.png", 7);
			clickOn("pictures\\Website_GoogleStore_Button_AddExtension.png");
			sleep(2);
			if (waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslate.png", 6))
			{
				waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png", 7);
				clickOn("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png");
			}
			
			TestLogger.info("2. In the info bar, click on button 'Remove from browser'");
			waitForObjectPresent("pictures\\Browser_Extension_Popup_Remove_From_browser.png", 7);
			clickOn("pictures\\Browser_Extension_Popup_Remove_From_browser.png"); 
			
			TestLogger.info("3. Open Extensions and check");
           
			waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("coccoc://extensions/");
		    s.type(Key.ENTER);
		    waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_Savior.png", 7);
			clickOn("pictures\\Browser_ExtensionPage__icon_Savior.png");
			int i =1 ;
			do 
			{
			    i++;
				s.type(Key.DOWN); 
				sleep (1);
				s.type(Key.DOWN);  
				sleep (1);
				s.type(Key.DOWN); 
				
				
			} while (!waitForObjectPresent("pictures\\Browser_ExtenstionPage_TextLink_GetMoreExtension.png", 1) && (i<6)) ;
			
			
			TestLogger.info("EXPECT #3 : The extension is removed from Extension list ");
			
			 if (!waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 3))
			 {
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
				 setTestcaseStatus("PASSED", "PASSED #3 : => The extension is removed from Extension list ");
			 }
			 else
			 {
				 clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				 s.type(Key.F4, Key.ALT);
				 setTestcaseStatus("FAILED", "FAILED #3 => The extension is NOT removed from Extension list  ");
			 }
			
		}
		
		// Check button "I trust this extension, enable it" in info bar 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Browser_SNIFF_Others_04 </br>
		 * <b> CaseTitle: </b>Check button "I trust this extension, enable it" in info bar   </br>
		 * <b> Steps: </b>
1. Install a malicious extension (in the blacklist) from Apps store
2. In the info bar, click on button "I trust this extension, enable it" 
3. Open Extensions and check
		 *  EXPECT : 
#3: The extension is enabled
		 
		 * @author hanv
		
		 */
		@Test
		public void Browser_SNIFF_Others_04()
		{
            TestLogger.info("Install a malicious extension in the blacklist of CocCoc");
			
			//startCocCocInEnglish();
			waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("https://chrome.google.com/webstore/search/ilivid?hl=vi");
		    s.type(Key.ENTER);
		    waitForObjectPresent("pictures\\Website_GoogleStore_Icon_Iconilivid.png", 7);
			clickOn("pictures\\Website_GoogleStore_Icon_Iconilivid.png");
			 waitForObjectPresent("pictures\\Website_GoogleStore_Button_themvaochrome.png", 7);
			clickOn("pictures\\Website_GoogleStore_Button_themvaochrome.png");
			waitForObjectPresent("pictures\\Website_GoogleStore_Button_AddExtension.png", 7);
			clickOn("pictures\\Website_GoogleStore_Button_AddExtension.png");
			sleep(2);
			if (waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslate.png", 6))
			{
				waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png", 7);
				clickOn("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png");
			}
			TestLogger.info("2. In the info bar, click on button 'I trust this extension, enable it' ");
			waitForObjectPresent("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png", 7);
			clickOn("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png");  
			
			TestLogger.info("3. Open Extensions and check");
			TestLogger.info("The extension is enabled");
			waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("coccoc://extensions/");
		    s.type(Key.ENTER);
		    waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_Savior.png", 7); 
			clickOn("pictures\\Browser_ExtensionPage__icon_Savior.png");
			int i=1;
			do 
			{
			    i++;
				s.type(Key.DOWN); 
				s.type(Key.DOWN);  
				s.type(Key.DOWN); 
				
				
			} while (!waitForObjectPresent("pictures\\Browser_ExtenstionPage_TextLink_GetMoreExtension.png", 1) && (i<6)) ;
			
			if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Checkbox_StatusEnabled.png", 3))
			{
				waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 517);
				s.click();
				 waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
				sleep (5);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED => #3. In extension list, the extension is esabled and there is a message:'Potential malware.");
				
			}
			else
			{
				waitForObjectPresent("pictures\\Browser_ExtensionPage_icon_ilivid.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 517);
				s.click();
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);
				clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
				sleep (5);
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "FAILED => #3. In extension list, the extension is disabled and there is a message:'Potential malware.");
			}
			
		}
		
		 // Check button Close (X) in info bar 
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Browser_SNIFF_Others_05 </br>
		 * <b> CaseTitle: </b>Check button Close (X) in info bar   </br>
		 * <b> Steps: </b>
1. Install a malicious extension (in the blacklist) from Apps store
2. In the info bar, click on button Close (X) on the right
		 *  EXPECT : 
#2 : The info bar is closed, the extension is disabled in Extension list
		 
		 * @author hanv
		
		 */
		@Test
		public void Browser_SNIFF_Others_05()
		{
			 TestLogger.info("Install a malicious extension in the blacklist of CocCoc");
				
				startCocCocInEnglish();
				waitForObjectPresent("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
				s.click();
				s.type("https://chrome.google.com/webstore/search/ilivid?hl=vi");
			    s.type(Key.ENTER);
			    waitForObjectPresent("pictures\\Website_GoogleStore_Icon_Iconilivid.png", 7);
				clickOn("pictures\\Website_GoogleStore_Icon_Iconilivid.png");
				 waitForObjectPresent("pictures\\Website_GoogleStore_Button_themvaochrome.png", 7);
				clickOn("pictures\\Website_GoogleStore_Button_themvaochrome.png");
				 waitForObjectPresent("pictures\\Website_GoogleStore_Button_AddExtension.png", 7);
				clickOn("pictures\\Website_GoogleStore_Button_AddExtension.png");
				sleep(2);
				
				if (waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslate.png", 3)) 
				{
					 waitForObjectPresent("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png", 7);
					 clickOn("pictures\\Website_GoogleTranslte_Modal_DialogTranslateNope.png");
				}
				TestLogger.info("2. In the info bar, click on button Close (X) on the right");
				waitForObjectPresent("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png", 7);
				moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png", 481);
				s.click();
				
				sleep(3);
				TestLogger.info("EXPECT : The info bar is closed, the extension is disabled in Extension list");
				TestLogger.info("Check : The info bar is closed ");
				
				if (waitForObjectPresent("pictures\\Browser_ExtensionPage_Popup_iTrustThisExtension.png", 6))  
				{
					
					setTestcaseStatus("FAILED", "FAILED : ==> #2 The info bar is NOT closed ");
				}
				else
				{
					
					setTestcaseStatus("PASSED", " PASSED ==> #2 The info bar is closed ");
				}
				
				TestLogger.info("Check : The extension is disabled in Extension list");
				
				moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
				s.click();
				s.type("coccoc://extensions/");
			    s.type(Key.ENTER);
			    waitForObjectPresent("pictures\\Browser_ExtensionPage__icon_Savior.png", 7);
				clickOn("pictures\\Browser_ExtensionPage__icon_Savior.png");  
				int i =1;
				
				do 
				{
				    i++;
					s.type(Key.DOWN); 
					s.type(Key.DOWN);  
					s.type(Key.DOWN); 
					
					
				} while (!waitForObjectPresent("pictures\\Browser_ExtenstionPage_TextLink_GetMoreExtension.png", 1) && (i<6)) ;  
				
				if (waitForObjectPresent("pictures\\Browser_ExtensionPage_CheckBox_StatusDisabled.png", 3))  
				{
					moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 517);
					s.click();
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);
					clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
					sleep (5);
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("PASSED", "PASSED => #. In extension list, the extension is disabled");
				}
				else
				{
					moveMouseHorizontallyFromLogo("pictures\\Browser_ExtensionPage_icon_ilivid.png", 517);
					s.click();
					waitForObjectPresent("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png", 7);  
					clickOn("pictures\\Browser_ExtensionPage_Button_RemoveExtension.png");
					sleep (5);
					clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
					s.type(Key.F4, Key.ALT);
					setTestcaseStatus("FAILED", "FAILED => #.  In extension list, the extension is NOT disabled");
				}
				
				
		}
		
		
		//Check if there is warning for malicious website
		/**
		 * <b> Browser_GoogleServices_v1.1 </b> </br>
		 * <b> CaseID: </b> Browser_SNIFF_Others_06 </br>
		 * <b> CaseTitle: </b>Check if there is warning for malicious website  </br>
		 * <b> Steps: </b>
1. Open one malicious link (can found from http://malwaredomains.lehigh.edu/files/domains.txt)
		 *  EXPECT : 
#1 : Security red error page displays
		 
		 * @author hanv
		
		 */
		@Test
		public void Browser_SNIFF_Others_06()
		{
			startCocCocInEnglish();
			TestLogger.info("1. Open one malicious link (can found from http://malwaredomains.lehigh.edu/files/domains.txt)"); 
			moveMouseHorizontallyFromLogo("pictures\\CocCoc_Address_icon_iconSaviorDiabled.png", -130);
			s.click();
			s.type("http://bakuzbuq.ru/");
		    s.type(Key.ENTER);
			sleep(5);
			TestLogger.info("EXPECT : Security red error page displays");
			if (waitForObjectPresent("pictures\\Website_Vipprojects_ImageSecurityRedErrorPage.png", 5))  
			{
				
				 //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("PASSED", "PASSED : Security red error page displays ");
			}
			else
			{
				
				 //exit browser
				clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
				sleep (2);
				s.type(Key.F4, Key.ALT);
				setTestcaseStatus("FAILED", "FAILED : Security red error page DOES NOT display ");
			}
		}
		
		
}
