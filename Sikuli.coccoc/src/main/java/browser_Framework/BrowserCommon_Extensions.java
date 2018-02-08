package browser_Framework;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Match;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class BrowserCommon_Extensions extends BrowserCommon{
	
	/**
	 * Check extension status on coccoc://extensions
	 * 
	 * @param extensionName
	 *            Savior/Dict,...
	 * @param extensionStatus
	 *            Disable or enable
	 * @author huy.vu
	 * @return
	 */
	public boolean checkExtensionStatus(String extensionName, String extensionStatus) {
		TestLogger.info("Check extension " + extensionName + " in " + extensionStatus + " state:");
		boolean local_status = false;
		String imageExtensionIcon;
		String imageExtensionStatus;

		if (extensionName.equalsIgnoreCase("Savior"))
			imageExtensionIcon = "pictures\\Browser_ExtensionPage_Icon_Savior.png";
		else
			imageExtensionIcon = "pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png";
		if (extensionStatus.equalsIgnoreCase("enable"))
			imageExtensionStatus = "pictures\\Browser_ExtensionPage_ExtennsionsEnabled.png";
		else
			imageExtensionStatus = "pictures\\Browser_ExtensionPage__ExtennsionsDisabled.png";

		local_status = waitForObjectAppearOnRegion(imageExtensionIcon, imageExtensionStatus, 520, 120, 10);

		return local_status;
	}

	/**
	 * Pre-condition: Coc coc extension page is started.
	 * @author huy.vu
	 * @param extensionName
	 * @param extensionStatus
	 */
	public void changeExtensionStatus(String extensionName, String extensionStatus) {
		String imageExtensionIcon;
		String imageExtensionStatus;

		// handle for extension
		if (extensionName.equalsIgnoreCase("Savior"))
			imageExtensionIcon = "pictures\\Browser_ExtensionPage_Icon_Savior.png";
		else
			imageExtensionIcon = "pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png";

		// handle for status
		if (extensionStatus.equalsIgnoreCase("Enable"))
			imageExtensionStatus = "pictures\\Browser_ExtensionPage__ExtennsionsDisabled.png";
		else
			imageExtensionStatus = "pictures\\Browser_ExtensionPage_ExtennsionsEnabled.png";

		if (waitForObjectAppearOnRegion(imageExtensionIcon, imageExtensionStatus, 520, 120, 1))
			clickOnRegion(imageExtensionIcon, imageExtensionStatus, 520, 120);
		sleep(1);
	}

	/**
	 * Change Extension Option
	 * @author huy.vu
	 * @param extensionName
	 * @param extensionOption
	 * @param status
	 */
	public void changeExtensionOption(String extensionName, String extensionOption) {
		String imageExtensionIcon;
		String imageExtensionOption;

		changeExtensionStatus("Savior", "Enable");
		// handle for extension
		if (extensionName == "Savior")
			imageExtensionIcon = "pictures\\Browser_ExtensionPage_Icon_Savior.png";
		else
			imageExtensionIcon = "pictures\\Browser_EnVnDictionary_Icon_EnVnExtensionIcon.png";

		TestLogger.info("Change option " + extensionOption + " of " + extensionName);
		// handle for status
		if (extensionOption == "Alow incognito tab")
			imageExtensionOption = "pictures\\Browser_ExtensionPage_Checkbox_DeniedIncognitoTab.png"; 
		else
			imageExtensionOption = "pictures\\Browser_ExtensionPage_Checkbox_AlowIncognitoTab.png";

		if (waitForObjectAppearOnRegion(imageExtensionIcon, imageExtensionOption, 520, 120, 1))
			clickOnRegion(imageExtensionIcon, imageExtensionOption, 520, 120);
		sleep(1);
	}
	
	
///////////////////////////////////////////////////////////////
//                 Section: SAVIOR Extension                 //
///////////////////////////////////////////////////////////////
	/**
	 * Check media can be detected
	 * 
	 * @author Hanv
	 * @Updater: Huy
	 * @Date: 13-Apr-2016
	 * @return
	 * @ 
	 */
	public boolean mediaCanBeDetected(ExcelFileController controllerExel,
			int rowInExcel, String excelLocation, HSSFSheet excelSheet,
			String siteName)  {
		TestLogger.info("Check media can be detected: ");
		boolean flag = false;
		
		waitForObjectPresent("pictures\\Browser_Savior_button_downloadMedia.png", 25) ;
		sleep(4);
		clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
		//sleep(10);
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadFromDropDownlist.png", 5)){
				
				flag = true;
				TestLogger.info("Media can be deteched by Savior");
				controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 2, "Y");
				controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
						rowInExcel, 6, "Y");
				if (siteName.equalsIgnoreCase("haivn.com"))
				{
					moveMouseDownFromLogo("pictures\\Browser_Savior_button_downloadMedia.png", 38);
					s.click();
				}
				
			 moveMouseToCoordinate(AdsHandler.p);
			  
			}
		 else{
			TestLogger.warn("Media cannot be deteched by Savior");
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
			// Write report to excel file on test suite
		}
		return flag;
	}

	/**
	 * Check button download appears
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @param nameOfButtonDownload
	 * @return CocCoc_DownloadMediaButton.png
	 * @ 
	 */
	public boolean buttonDownloadIsEnabled(ExcelFileController controllerExel, int rowInExcel, String excelLocation, HSSFSheet excelSheet,
			String siteName, String[] nameOfButtonDownload)  {
		TestLogger.info("Check button download appears when hovering on media content: ");
		boolean flag = false;
		
		
		if (waitForObjectPresent(nameOfButtonDownload[1], 15)) {
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult", rowInExcel, 7, "Y");
			
			clickOn(nameOfButtonDownload[1]);
			flag = true;
			
			/*if (siteName.equalsIgnoreCase("xemphimso.com")) {
				if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
					clickOn(nameOfButtonDownload[2]);
				}
			}
			
			if (siteName.equalsIgnoreCase("twitter.com")) {
				if (waitForObjectPresent(nameOfButtonDownload[3], 25)){
					clickOn(nameOfButtonDownload[3]);
				}
			}*/
			
			
			/*if (siteName.equalsIgnoreCase("phim.in")) {
				if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
					clickOn(nameOfButtonDownload[2]);
				}
			} */
			
			
			if (siteName.equalsIgnoreCase("nhac.hay365.com")) {
				if (waitForObjectPresent(nameOfButtonDownload[4], 25)){
					clickOn(nameOfButtonDownload[4]);
				}
			}
			
			
			if (siteName.equalsIgnoreCase("fptplay.net")) {
				if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
					clickOn(nameOfButtonDownload[2]);
				}
			} 
			
			/*if (siteName.equalsIgnoreCase("phim14.net")) {
				if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
					clickOn(nameOfButtonDownload[2]);
					
				}
			}*/ 
			
			/*if (siteName.equalsIgnoreCase("hayhaytv.vn")) {
				if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
					clickOn(nameOfButtonDownload[2]);
				}
			} 
			
			 if (siteName.equalsIgnoreCase("hdviet.com")) {
				 if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
						clickOn(nameOfButtonDownload[2]);
					}
				} 
				 */
			/* if (siteName.equalsIgnoreCase("biphim.com")) {
				 if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
						clickOn(nameOfButtonDownload[2]);
					}
				} */
			 
			/* if (siteName.equalsIgnoreCase("cohet.tv")) {
				 if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
						clickOn(nameOfButtonDownload[2]);
					}
				}*/
			 
			 /*if (siteName.equalsIgnoreCase("vetv.vn")) {
				 if (waitForObjectPresent(nameOfButtonDownload[2], 25)){
						clickOn(nameOfButtonDownload[2]);
					}
				}*/
			 
			 if (siteName.equalsIgnoreCase("xnxx.com")) {
				 if (waitForObjectPresent(nameOfButtonDownload[3], 25)){
						clickOn(nameOfButtonDownload[3]);
					}
				}  
			 
			 if (siteName.equalsIgnoreCase("xemphimone.com")) {
				 if (waitForObjectPresent(nameOfButtonDownload[4], 25)){
						clickOn(nameOfButtonDownload[4]);
					}
				}  
			 
			 if (siteName.equalsIgnoreCase("cliptv.vn")) {
				 if (waitForObjectPresent(nameOfButtonDownload[4], 25)){
						clickOn(nameOfButtonDownload[4]);
					}
				}
			 
			TestLogger.info("button download appears when hovering on media content");

		} 
		// handle when checkpoint failed
		else {
			// Capture screenshot
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult", rowInExcel, 7, "N");

			TestLogger.warn("Button download doesn't display when hovering on media content, download by cliking on download button on the Omibox bar ");
			Point currentMousePoision = getCursorPosition();
			clickOn("pictures\\Browser_Savior_button_downloadMedia.png");
			sleep (30);

			// get name of image from ButtonDownload column in excel file and
			// compare in
			// Switch command

			TestLogger.info("this must be download button on Omibox =>> OR " + nameOfButtonDownload[3] + "OR " + nameOfButtonDownload[4]  );
			switch (siteName) {

			case "phim14.net": {
				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}

			case "phim.in": {
				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}

			case "hdonline.vn": {
				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}

			case "xemphimso.com": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			case "chiasenhac.com": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			case "2sao.vn": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			case "biphim.com": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			case "vkool.net": {
				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			case "vetv.vn": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			case "cohet.tv": {

				waitForObjectPresent(nameOfButtonDownload[4], 25);
				clickOn(nameOfButtonDownload[4]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			
			default:
				waitForObjectPresent(nameOfButtonDownload[3], 25);
				clickOn(nameOfButtonDownload[3]);
				moveMouseToCoordinate(currentMousePoision);

				break;
			}
			// Note site to collect on report
			writeContainToTextFile( "saviorReport\\downloadMediaButtonEnable.txt", siteName, true);
		}
		return flag;
	}

	/**
	 * Check button detach display
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @return
	 * @ 
	 */
	public boolean buttonDetachIsDisplayed(ExcelFileController controllerExel,
			int rowInExcel, String excelLocation, HSSFSheet excelSheet,
			String siteName)  {
		TestLogger.info("Check button detach display");
		boolean flag = false;
		if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 8)) {
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 8, "Y");
			if (siteName.equalsIgnoreCase("phim14.net"))
		     {
				doubleClick("pictures\\Browser_Savior_Button_PIN.png");
				sleep (10);
		     }
			else
			{
			clickOn("pictures\\Browser_Savior_Button_PIN.png");
			}
			
			flag = true;
			
			TestLogger.info("--> PASSED");
					 
		} else {
			TestLogger.warn("Button detach not display, pls check");
			String homePath = System.getProperty("user.home")
					+ "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
//			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
			
//					rowInExcel, 8, "N");
//			// Note site to collect on report
//			writeContainToTextFile("saviorReport\\\detachButtonDisapears.txt",
//					siteName, true);
		}
		return flag;
	}

	/**
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @return
	 * @ 
	 */
	public boolean checkButtonDetachWorksCorrectly(
			ExcelFileController controllerExel, int rowInExcel,
			String excelLocation, HSSFSheet resultSheet, HSSFSheet dataSheet,
			String siteName)  {
		boolean flag = false;
		
		 if (siteName.equalsIgnoreCase("anime47.com"))
		 {
			 s.type(Key.HOME);
			 s.type(Key.HOME);
			 s.type(Key.HOME);
			 clickOn("pictures\\Browser_Savior_Button_PIN.png");
		 }
	    
		TestLogger.info("Check detach feature work correctly");
		if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIPWindowRestore.png", 12)) { 

			moveMouseDownFromLogo("pictures\\Browser_Savior_Button_PIPWindowRestore.png", 100);
			//======== Can Giai Quyet Not Cot Pause Button ============
			switch (siteName) 
			{
			
			case "phimmoi.net" :
			{
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_PhimmoiButton_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
					
				}
				break;
			}
			
			case "phim14.net" : 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phim14_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
				
			case "phim3s.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phim3s.net_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "anime47.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Webite_Anime47.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			
			case "hdonline.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_HdonlineButton_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "vivo.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Vivo.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "fptplay.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Fptplay_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
				
			case "vuighe.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vuighe.net_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xemphimso.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimso_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xemvtv.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Webiste_xemvtv.net_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "hayhaytv.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayhaytv.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "biphim.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Biphim.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xemphimon.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimon.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "vkool.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phim.in": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.in_Button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "mp3.zing.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_mp3.zing.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "nhaccuatui.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhaccuatui.com_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "radio.zing.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhac.vui.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "soundcloud.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_soundcloud_Button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "nhacso.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhacso.net_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "keeng.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Keengvn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xvideos.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xvideos.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "xnxx.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nxnxx.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "phimsexporn.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimsexporn.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "pornhub.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Pormhub_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "xhamster.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Xhamster_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "vlxx.tv": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_VLxxTV_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "tube8.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Tube88_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "youporn.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_YouPorm_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "redtube.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Redtube_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "nhac.vui.vn ": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_radio.zing_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "voh.com.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_VOH_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "facebook.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_facebookButton_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "chatvl.info": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_chatvl.com_Button_pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "youtube.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youtube_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "yan.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Yan_button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "tv.zing.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_tv.zing_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xem.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Xemvn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "talktv.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Talk.vn_Button_Pause.vn.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "haivn.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Xemvn_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "dailymotion.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_dailyMotion_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "cohet.tv": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Cohet.tv_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "chimsedinang.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_chimsedinang.com_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "video.vnexpress.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_VNExpress_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "clip.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\website_Clip.vn_Button_Pause.vn.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "kenhvideo.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_KenhVideo_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "vetv.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Vetv_Button_Pause1.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "video.ngoisao.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_video.ngoisao.net_button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "video.thethao247.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Thethao247_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "vimeo.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Vimeo_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "news.zing.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youtube_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "me.zing.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youtube_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "hdviet.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_twitter_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "24h.com.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_24h_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "phim.clip.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.clip.vn_Button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "video.ringring.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_videoringringvn_button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			/*
			case "v.nhaccuatui.com": 
			{	
				
				if (waitForObjectPresent("saviorTop55\\PIP_pauseButtonPhimhd.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			*/
			
			case "clip.vietnamnet.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipVietNam_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "afamily.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipAfamily_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "media.bongdaplus.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipbongdaplus_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "bongdaclip.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipbongdaclip_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "gamek.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipgamek_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "twitter.com": 
			{	
				 
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_twitter_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "haiivl.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youtube_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "2sao.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_2sao_button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "videos.vietgiaitri.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website__Vietgiaitri_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "megafun.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\website_megafun.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "cand.com.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_cand.com.vn_Button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "ohay.tv": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youtube_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			case "phim.megabox.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\website_Megabox_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "anhtrang.org": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_AnhTrang_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "8bongda.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_8bongda.com_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xemphimone.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimone_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "bongda365.com.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongda365_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimvipvn.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimhd_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "animeax.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Animeax_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "phimdata.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimdata_Button_pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimnhanh.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimnhanh_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "vipphim.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_VIPPhim_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimvon.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimvon_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "pubvn.tv": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Pubvn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phim22.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phim22_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phim7.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phim7_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "nhac.hay365.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hay365_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "ssphim.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_ssphim_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimtructuyenhd.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimtructuyenhd_Button_Pasue.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "xuongphim.tv": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimtructuyenhd_Button_Pasue.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "vino.vn/mp3": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phimtructuyenhd_Button_Pasue.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "haivl.io": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_haivl.io_Button_Pause.io.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "nhacvang.org": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_haivl.io_Button_Pause.io.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			case "clipvuivn.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipvui.vn_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimporn.com": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimporm_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "123tv.vn": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_123tv_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			case "phimonlinehd.net": 
			{	
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_PhimonlineHD_Button_Pause.png", 5)) {
					controllerExel.writeToCell(excelLocation, resultSheet,
							"FinalResult", rowInExcel, 9, "Y");
					flag = true;
					TestLogger.info("--> PASSED");
				}
				
				
				break;
			}
			
			
			
			default : TestLogger.info("");
				
			}
				
			
			
			
		// ====================	 PAUSE Button =========== 
			
			
		} else {
			TestLogger.warn("Detach works incrorrectly, pls check");
			String homePath = System.getProperty("user.home")
					+ "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
			
			
			
			
//			controllerExel.writeToCell(excelLocation, resultSheet,
//					"FinalResult", rowInExcel, 9, "N");
//			// Note site to collect on report
//			writeContainToTextFile("saviorReport\\\detachButtonCanWork.txt",
//					siteName, true);
		}
		return flag;
	}

	/**
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @return
	 */
	public boolean detachedWindowRestoresCorrectly(
			ExcelFileController controllerExel, int rowInExcel,
			String excelLocation, HSSFSheet excelSheet, String siteName) {
		boolean flag = false;
		clickOn("pictures\\Browser_Savior_Button_PIPWindowRestore.png");
		sleep (2);
		if (waitforObjectNotexist("pictures\\Browser_Savior_Button_PIPWindowRestore.png", 12)) {
			TestLogger.info("The restore button work correctly");
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 10, "Y");
			flag = true;
		} else {
			TestLogger
					.warn("The restore button does not appears, please to check");
			String homePath = System.getProperty("user.home")
					+ "/Desktop/screenShot/";
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 10, "Y");
			captureSnapshot(homePath, siteName, 1);
			
		}
		return flag;
	}


	/**
	 * Check name of media download
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @param nameOfSong
	 */
	public boolean checkFileNameCanbeDetectCorrectly(
			ExcelFileController controllerExel, int rowInExcel,
			String excelLocation, HSSFSheet excelSheet, String nameOfSong,
			String siteName) {
		boolean flag = false;
		TestLogger.info("Check name of media download is " + nameOfSong);
		String downloadFolder = System.getProperty("user.home") + "\\Downloads";
		File DownloadFolder = new File(downloadFolder);
		for (File f : DownloadFolder.listFiles())
			if ((f.getName().contains(nameOfSong))) {
				flag = true;
			}
		if (flag) {
			TestLogger.info("--> PASSED");
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 3, "Y");
		} else {
			TestLogger.warn("Filename is Not Correct! Please check!");
			String homePath = System.getProperty("user.home")
					+ "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 3, "N");
			// Note site to collect on report
			writeContainToTextFile(
					"saviorReport\\filenameCanBeDetectedCorrectly.txt",
					siteName, true);

		}

		return flag;
	}

	/**
	 * Check media can be played well on local machine
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @return
	 * @ 
	 */
	public boolean mediaCanBePlayedWellOnLocalMachine(
		ExcelFileController controllerExel, int rowInExcel,
		String excelLocation, HSSFSheet excelSheet, String siteName)  {
		TestLogger.info("Check media can be played well");
		boolean flag = false;
		moveMouseDownFromLogo("pictures\\Browser_DownloadPage_Button_DisplayInFolder.png", -20);
		s.click();
		// waitForObjectPresent("pictures\\SaviorWeekly\\OSApp_MediaPlayer_Logo_VLC.png", 2);
		// Maximize VLC windows
		// clickOn("pictures\\SaviorWeekly\\OSApp_MediaPlayer_Logo_VLC.png"); 
		//clickOn("pictures\\SaviorWeekly\\OSApp_MediaPlayer_Logo_VLC.png");
		sleep(0.5);
		s.type(Key.UP, Key.WIN);
		
		if (waitForObjectPresent("pictures\\OSApp_MediaPlayer_Button_Close.png", 1))
		{
			clickOn("pictures\\OSApp_MediaPlayer_Button_Close.png");
		}
		
		if (waitForObjectPresent("pictures\\OSApp_MediaPlayer_Button_PauseVLC.png", 3)) {
			clickOn("pictures\\OSApp_MediaPlayer_Button_PauseVLC.png");
			flag = true;
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult",
					rowInExcel, 5, "Y");
			TestLogger.info("--> PASSED");
		} else {
			TestLogger.warn("Media cannot play, please check!");
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath, siteName, 1);
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult", rowInExcel, 5, "N");
			// Note site to collect on report
			writeContainToTextFile("saviorReport\\mediaCanBePlayedWell.txt", siteName, true);

		}
		TestLogger.info("Close media player:");
		s.type("q", Key.CTRL);
		return flag;
	}

	/**
	 * Check media can be download by Savior Pre-condition: the download page is
	 * opened
	 * 
	 * @param controllerExel
	 * @param rowInExcel
	 * @param excelLocation
	 * @param excelSheet
	 * @return
	 * @ 
	 */
	public boolean mediaCanBeDownloaded(ExcelFileController controllerExel,
			int rowInExcel, String excelLocation, HSSFSheet excelSheet,
			String siteName)  {
		TestLogger.info("Check media can be download by Savior: ");
		boolean flag = false;
		
		// Wait for download page load done
		  // Open Download page in Coc Coc 
		  s.type("t",Key.CTRL);
		  sleep(1);
	      clickOn("pictures\\Browser_Omibox_Address_ EnterURL.png");
	      sleep(1);
		  s.type("coccoc://downloads/");
		  sleep(1);
		  s.type(Key.ENTER);
		  waitForObjectPresent("pictures\\Browser_Torrent_Button_DeletedAll.png", 5); 

		// wait for download done
		waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png",3);
		if (waitforObjectNotexist("pictures\\Browser_Torrent_Button_PauseDownload.png", 360)) {
			controllerExel.writeToCell(excelLocation, excelSheet, "FinalResult", rowInExcel, 4, "Y");
			flag = true;
		}
		else {
			String homePath = System.getProperty("user.home") + "/Desktop/screenShot/";
			captureSnapshot(homePath,siteName, 1);
			//write report to text file: do on Test suite
		}
		return flag;
	}

	/**
	 * Check savior icon is in enable or disable state
	 * @param extensionStatus
	 * @author huy.vu
	 * @return String
	 */
	public boolean checkSaviorIcon(String extensionStatus) {
		
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -200);
		sleep(0.5);
		if(extensionStatus == "Disapears")
			return (waitForObjectPresent("pictures\\Browser_Savior_Iocon_SaviorExtensiondisabled.png", 1)); 
		else
			return waitForObjectPresent("pictures\\Browser_Savior_Iocon_SaviorExtensionEnabled.png", 10);
			
	}
	
	/**
	 * Check savior icon appears or not on incognito mode
	 * @param extensionStatus Disapears or Appears
	 * @author huy.vu
	 * @return String
	 */
	public boolean checkSaviorIconInIncognitoMode(String extensionStatus){
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -200);
		sleep(0.5);
		if(extensionStatus.equalsIgnoreCase("Disapears"))
			return (waitforObjectNotexist("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 2));
		else
			return waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 5);
	}
	
	/**
	 * acccess and play video on youtube (link: https://www.youtube.com/watch?v=RZQNe8IMLtQ)
	 * @return True if Coc Coc can be play video on youtube
	 * @author huy.vu
	 * @date 31 Aug 2016
	 * 
	 */
	public boolean accessWebAndPlayVideo(String webUrl) {
		if(!waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 5))
			startCocCoc();
		
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(webUrl);
		s.type(Key.ENTER);
		sleep(5);
		
		//reload if network error
		for (int loop = 1; loop <= 5; loop++){
			if(waitForObjectPresent("pictures\\Website_youtube_Button_Registry.png", 15)){
				if(waitForObjectPresent("pictures\\Browser_Savior_Button_CloseWarningFonFirstTime.png", 1)){
					TestLogger.info("close warning popup of savior for fist time");
					clickOn("pictures\\Browser_Savior_Button_CloseWarningFonFirstTime.png");
					sleep(5);
					moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -200);
				}
				break;
			}
			else{
				s.type(Key.F5);
				sleep(5);
			}
		}
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -200);
		return waitForObjectPresent("pictures\\Browser_Savior_Button_PauseOfYoutubeOnPIPwindow.png", 5);
	}
	
	/**
	 * Download media content by click on download button and wait for download completed
	 * @author huy.vu
	 */
	public boolean downloadMediaContentOnYoutube() {
		boolean isDownlodSuccess = false;
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -100);
		if(waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 10)){
			clickOn("pictures\\Browser_Savior_Button_DownloadOnVideo.png");
			sleep(3);
			
			// wait for download done
			isDownlodSuccess = waitForCocCocDownloadCompleted();
		}
		return isDownlodSuccess;
	}
	
	/**
	 * Wait for coc coc finish to download
	 * @author huy.vu
	 * 
	 */
	public boolean waitForCocCocDownloadCompleted(){
		// wait for download done
		boolean isFileDownloading = false;
		clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
		sleep(3);
		s.type("j", Key.CTRL);
		if(waitForObjectPresent("pictures\\Browser_Torrent_Button_PauseDownload.png", 15))
			if (waitforObjectNotexist("pictures\\Browser_Torrent_Button_PauseDownload.png", 360)) {
				TestLogger.info("Download  done");
				isFileDownloading = true;
			}
		
		return isFileDownloading;
	}

	/**
	 * Select quatilty of video to download
	 * @param videoQuality quality of video want to download: FullHD, HD, Standard, Medium, Small, mobile
	 * @author huy.vu
	 * @return String 
	 * 
	 */
	public void selectQualityVideoToDownload(String videoQuality) {
		String imageName =  "saviorExtension_DownloadWith" + videoQuality + ".png";
		
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -300);
		
		waitForObjectPresent("pictures\\Browser_Savior_Picture_DownloadQuality.png", 20);
		
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		moveMouseDownFromLogo("pictures\\Website_youtube_Button_Registry.png", -300);
		
		clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		sleep(1);
		while (waitforObjectNotexist("pictures\\Browser_Savior_FileType_mp4.png", 1))
		{
			clickOn("pictures\\Browser_Savior_Picture_DownloadQuality.png");
		}
		
		clickOnRegion("pictures\\Browser_Savior_FileType_mp4.png", "pictures\\"+imageName, 150, 120);
		sleep(1);
		
		//clickOn(imageName);
		
	}
	
	
	
	public boolean checkExtensionOptionsStatus(String extensionName, String extensionOption, String extensionStatus){
		boolean localFlag = true;
		return localFlag;
	}
	
	/**
	 * Set media info
	 * @author huy.vu
	 */
	public String[] setMediaFileInfo() {
		String fileInfo[] = new String[10];
		//URL for testcase _30
		fileInfo[0] = "http://www.nhaccuatui.com/vh/auto/l1YSP9LqdsLZ1";
		//URL youtube
		fileInfo[1] = "https://www.youtube.com/watch?v=NPzAFTs4jHU";
		//file Name
		fileInfo[2] = "The Piano Guys - Love Story (Taylor Swift).mp4";
		//file size:
		//FULL HD
		fileInfo[3] = "49968422" ; // "90781259";
		//HD
		fileInfo[4] = "49968422";
		//Standard
		fileInfo[5] = "28149597";
		//medium
		fileInfo[6] = "18969496";
		//Small
		fileInfo[7] = "16470234";
		//mobile
		fileInfo[8] = "10379954"; 
		return fileInfo;
	}
	
	/**
	 * open CocCoc and 
	 * Access to URL on CocCoc 
	 * @author HANV
	 */
	public void accessVideoFromURL(){
		String urlVideo = setMediaFileInfo()[0];
		
		if(!waitForObjectPresent("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png", 2))
			startCocCoc();
		doubleClick("pictures\\Browser_Icon_Menu_CoccocLogoOnBrowser.png");
		s.type(Key.ESC);
		sleep(1);
		s.type("t", Key.CTRL);
		sleep(1);
		s.type(urlVideo);
		s.type(Key.ENTER);
		sleep(1);
	}
	
	/**
	 * Check file download well : File exist with full size
	 * @author huy.vu
	 * @return TRue if file correctly
	 * 
	 */
	public boolean checkFileDownloadWell(String fileQuality) {
		TestLogger.info("Check media file can download well");
		
		String[] mediaFileInfo = setMediaFileInfo();
		String fileName = mediaFileInfo[2];
		String fileSize = "0";
		boolean isFileDownload = false;
		String mediaFilePath = System.getenv("USERPROFILE") + "\\Downloads\\" + fileName;
		File meediaPath = new File(mediaFilePath);
		if(meediaPath.exists()){
			//set file size
			switch (fileQuality) {
			case "FullHD":
				fileSize = mediaFileInfo[3];
				break;
			case "Small":
				fileSize = mediaFileInfo[7];
				break;
			case "Medium" : 
				
				fileSize = mediaFileInfo[6];
				break;
            case "mobile" : 
				
				fileSize = mediaFileInfo[8];
				break;
				
			default:
				fileSize = "0";
			}
			
			//check file correctly
			if((meediaPath.length() + "").contains(fileSize)){
				TestLogger.info("The file download correctly");
				isFileDownload = true;
			}
			else
				TestLogger.warn("The site of file is " + meediaPath.length() + " Byte");
		}
		else
			TestLogger.warn("The file not exist on Downloads folders");
			
		return isFileDownload;
	}
}
