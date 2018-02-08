package browser_Testsuite_GoogleServices;

import org.sikuli.script.Key;
import org.testng.annotations.Test;

import browser_Framework.BrowserCommon;
import browser_Framework.TestLogger;

public class GoogleCalendar extends BrowserCommon {
	
	@Test
	public void GoogleServices_GoogleCalendar_01()
	 {
		 TestLogger.info("Verify that user can access to Google Calendar page after login on Gmail page without relogin ");
		 startCocCoc();
		 openLink("https://calendar.google.com/calendar");
		 TestLogger.info("Expect : Must show logo Google Calendar and avatar of user ");
		 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_Text_Calendar.png", 5) && (waitForObjectPresent("pictures\\Website_GoogleCalendar_Button_create.png", 5)))
		 {
			 setTestcaseStatus("PASSED", " showed logo Google Calendar and avatar of user");
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", " Did NOT show logo Google Calendar and avatar of user");
		 }
		 
		  //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT);
	 }
	
	  @Test
	 public void GoogleServices_GoogleCalendar_02()
	 {     
		 TestLogger.info("Verify that user can create a Remind successfully on Google Calendar page ");
		 startCocCoc();
		 openLink("https://calendar.google.com/calendar");
		 sleep(5);
		 clickOn("pictures\\Website_GoogleCalendar_Button_Week.png"); 
		 moveMouseDownFromLogo("pictures\\Website_GoogleCalendar_Button_Week.png", 100);
		 s.click();
		 s.type("PLAY MORE");
		 s.type(Key.ENTER);
		 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_text_PlayMore.png", 5))
		 {
			setTestcaseStatus("PASSED", "user can create a Remind successfully on Google Calendar page"); 
		 }
		 else
		 {
			 setTestcaseStatus("FAILED", "user can NOT create a Remind successfully on Google Calendar page"); 
		 }
		 
		    //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT); 
	 }
	 
	 
	 @Test
	 public void GoogleServices_GoogleCalendar_03() 
	 { 
		 TestLogger.info("Verify that user can EDIT a Remind successfully on Google Calendar page ");
		 startCocCoc();
		 openLink("https://calendar.google.com/calendar");
		 sleep(5);
		 clickOn("pictures\\Website_GoogleCalendar_Button_Week.png"); 
		 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_text_PlayMore.png", 5))
		 {
			 clickOn("pictures\\Website_GoogleCalendar_text_PlayMore.png");
			 clickOn("pictures\\Website_GoogleCalendar_button_EditEvent.png");
			 s.type("123");
			 clickOn("pictures\\Website_Google_button_Save.png");
			 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_Text_PlayMoreEdit.png", 5))
			 {
				 setTestcaseStatus("PASSED", "User can EDIT a Remind successfully on Google Calendar page");
			 }
			 else
			 {
				 setTestcaseStatus("FAILED", "User can NOT EDIT a Remind successfully on Google Calendar page");
			 }
				 
			 
		 }
		 
		    //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT); 
		 
	 }
	 
	 @Test
	 public void GoogleServices_GoogleCalendar_04() 
	 { 
		 TestLogger.info("Verify that user can Delete a Remind successfully on Google Calendar page ");
		 startCocCoc();
		 openLink("https://calendar.google.com/calendar");
		 sleep(5);
		 clickOn("pictures\\Website_GoogleCalendar_Button_Week.png"); 
		 TestLogger.info("2. Choose a remind to delete.");
		 
		 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_text_PlayMore.png", 5))
		 {
			 clickOn("pictures\\Website_GoogleCalendar_text_PlayMore.png");
			 clickOn("pictures\\Website_GoogleCalendar_button_EditEvent.png");
			 TestLogger.info("3. Delete that remind");
			 clickOn("pictures\\Website_GoogleCalendar_Button_Delete.png");
			 
			 TestLogger.info("Expect : That remind must be deleted successfully.");
			 if (waitForObjectPresent("pictures\\Website_GoogleCalendar_Text_PlayMoreEdit.png", 5))
			 {
				 setTestcaseStatus("FAILED", "User can NOT DELETE a Remind successfully on Google Calendar page");
			 }
			 else
			 {
				 setTestcaseStatus("PASSED", "User can DELETE a Remind successfully on Google Calendar page");
			 }
				 
			 
		 }
		 
		   //exit browser
			clickOn("pictures\\Browser_AddressBar_icon_SaviorDisabled.png");
			sleep (2);
			s.type(Key.F4, Key.ALT); 
	 }
}
