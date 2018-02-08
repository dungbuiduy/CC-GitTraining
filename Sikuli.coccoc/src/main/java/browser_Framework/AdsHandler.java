package browser_Framework;

import java.awt.Point;

import org.openqa.selenium.Keys;
import org.sikuli.script.Key;

public class AdsHandler extends BrowserCommon {
	// 1. Close all ads (if have)
    // 2. Make sure that media was played on web ( navigate other media if error...)
    // 3. Move mouse form out of media to media contain. -> make sure detach, download ... appear  
	static Point p ;
	int i = 0 , j =0 ;
	public void handlePlayMediaOnWeb(String siteName)
	{
		switch (siteName) {
		
		case "porn99.net":
		{
		    if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_porn99.net_Text_Chitiet.png", 15))
		    {
		    	clickOn("pictures\\SaviorWeekly\\Website_porn99.net_Text_Chitiet.png.png");
		    	sleep(15);
		    	clickOn("pictures\\SaviorWeekly\\Website_porn99.net_Text_Truycapkhongantoan.png");
		    }
		    sleep(15);
		    if (waitForObjectPresent("pictures\\pictures\\SaviorWeekly\\Website_porn99.net_picture_logo.png", 35))
		    {
		    	moveMouseDownFromLogo("pictures\\pictures\\SaviorWeekly\\Website_porn99.net_picture_logo.png",330);
		    	if (waitForObjectPresent("pictures\\pictures\\SaviorWeekly\\Website_porn99.net_Button_Play.png", 45))
			    {
			    	clickOn("pictures\\SaviorWeekly\\Website_porn99.net_Button_Play.png");
			    	
			    	
			    	if (waitForObjectPresent("pictures\\SaviorWeekly\\website_porn99.net_Button_Play2.png", 15))
			    	{
			    		clickOn("pictures\\SaviorWeekly\\website_porn99.net_Button_Play2.png");
			    	}
			    	sleep (15);
			    	if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_porn99_icon_volumn.png",4))
			    	{
			    		clickOn("pictures\\SaviorWeekly\\Website_porn99_icon_volumn.png");
			    	}
			    	
			    	sleep(15);
			    	moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_porn99.net_picture_logo.png",320);
			    }
		    }
		    moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_porn99.net_picture_logo.png",320);
		    p = getCursorPosition();
			break;
			
			
		}
		
		
		case "xhamster.com":
		{
			do 
				
		  {
				
			i++ ;
		   waitForObjectPresent("pictures\\SaviorWeekly\\Website_xHamster_Picture_logo.png", 50);
		 
		   moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xHamster_Picture_logo.png", 250);
		  
		   moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xHamster_Picture_logo.png", 300);
		   if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xHamsterButton_Pause.png", 35))
		   {
			   TestLogger.info("Video is playing Now !"); 
				p = getCursorPosition();
				break;
			   
		   }
		   else
		   {
			   s.type(Key.F5);
		   }
		 
		  } while (! waitForObjectPresent("Website_xHamster_Picture_logo", 5) && (i<3)) ;
			p = getCursorPosition();
			break;
		  
		}
		   
		 
		case "tube8.com":
		{
			
			do
			{
			i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_tube8_picture_logo.png", 50);
			sleep(15);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_tube8_picture_logo.png", 280);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_tube8_Button__play.png", 40))
			{
				clickOn("pictures\\SaviorWeekly\\Website_tube8_Button__play.png");
				sleep (5);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_tube8_picture_logo.png", 280);
				
			}
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_tube8_Button_Pause.png", 15))
			 {
				 TestLogger.info("Video is playing now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_tube8_picture_logo.png", 280);
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_tube8_Button_Pause.png", 6) && (i<3)) ;
			p = getCursorPosition();
			break;
				
			
			
			
		}
		
		case "youporn.com":
		{
			do
			{
				i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_youporn__picture_logo.png", 50);
			sleep(15);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_youporn__picture_logo.png", 280);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youporn_Button_Pause.png", 35))
			 {
				 TestLogger.info("Video is playing now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_youporn__picture_logo.png", 290);
					p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_Youporn_Button_Pause.png", 6) && (i <3)) ;
			p = getCursorPosition();
			break;
		}
		// LOI
		
		
		case "vlxx.tv":
		{
		
		   do
		  {
		   i++ ;
		   waitForObjectPresent("pictures\\SaviorWeekly\\Website_VLXX__Button_Download.png", 10);
		   moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_VLXX__Button_Download.png", -300);
		   s.click();
		   sleep(5);
		   moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_VLXX__Button_Download.png", -300);
		   if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 10))
		   {
			   TestLogger.info("Video is playing now ");
				p = getCursorPosition();
			   break;
		   }
		   else
		   {
			   s.type(Key.F5);
			   sleep (15);
			   s.type(Key.HOME);
			   
		   }
		   
		   
		  } 
		   while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i < 4));
		   p = getCursorPosition();
		  break;
		}
		
		case "redtube.com":
		{
			
			do 
			{
			i++ ;
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_Redtube_Picture_logo.png", 50) ;
			sleep (20);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_Redtube_Picture_logo.png", 200);
			sleep (2);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_Redtube_Picture_logo.png", 200);
			sleep (2);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_Redtube_Picture_logo.png", 200);
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 6))
			{
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break;
			}
			
			else
			{
				s.type(Key.F5);
			}
			
			
			
			} while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i<4));
			p = getCursorPosition();
			break;
		}
		
		
		
		case "voh.com.vn":
		{
			do
			{
		     i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_voh_Picture_logo.png", 35) ;
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_voh_Picture_logo.png", 250);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_voh_Picture_logo.png", 260);
		
			s.click();
			
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_voh_Button_Pause.png", 25))
			{
				TestLogger.info("Video is playing Now ! "); 
				p = getCursorPosition();
				break; 
			}
			else
			{
				s.type(Key.F5);
			}
			//Handle for site "http://www.voh.com.vn/videos"
			
			} while (! waitForObjectPresent("pictures\\SaviorWeekly\\Website_voh_Button_Pause.png", 5) && (i < 3));
			p = getCursorPosition();
			break;
		}
		
		case "facebook.com":
		{
			
			
			do 
			{
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_facebook_Button_Later.png", 2))
				{
					clickOn("pictures\\SaviorWeekly\\Website_facebook_Button_Later.png");
				}
				
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_facebook_Picture_Logo.png", 30);
				//Handle for site "http://facebook.com"
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_facebook_Picture_Logo.png", 200);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_facebook_Picture_Logo.png", 200);
				s.click();
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_facebookButton_pause.png", 15))
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_facebook_Picture_Logo.png", 200);
					
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_facebookButton_pause.png", 5) && (i < 3)) ;
			p = getCursorPosition();
			break;
		}
		
		case "chatvl.info":
		{
			
			do
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 20);
				//Handle for site chatvl.vn
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 300);
				sleep (5);
				s.click();
				if (waitForObjectPresent("pictures\\SaviorWeekly\\website_chatvl.com_Button_Pause.png", 25))
				{
					TestLogger.info("Video is playing Now !"); 
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\website_chatvl.com_Button_Pause.png", 5) &&(i < 3));
			p = getCursorPosition();
			break;
		}
		
		case "pornhub.com":
		{
			
			do
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_pornhub_Picture_logo.png", 50);
				//Handle for site chatvl.vn
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_pornhub_Picture_logo.png", 220);
				sleep (1) ;
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_pornhub_Picture_logo.png", 220);
			   if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_pornhubbutton_pause.png", 25))
				{
					TestLogger.info("Video is playing Now !"); 
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_pornhubbutton_pause.png", 5) && (i < 3));
			p = getCursorPosition();
			break;
		}
		
		
		case "youtube.com":
		{
			
			do
			{
				i++;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_youtube_Picture_Logo.png", 30);
				//Handle for site youtube.com
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_youtube_Picture_Logo.png", 250);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_youtube_Picture_Logo.png", 250);
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_youtube_Button_pause.png", 25))
				{
					TestLogger.info("Video is playing Now !"); 
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_youtube_Button_pause.png", 5) && (i<4));
			p = getCursorPosition();
			break;
		}
		
		
		case "yan.vn":
		{
			
			do 
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_yan.vn_Picture_logo.png", 25); 
				sleep (35);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_yan.vn_Picture_logo.png", 150);
				
				if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 10))
				{
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					sleep (30);
					break;
				}
				else
				{
					s.type(Key.F5);
				}
			}
			while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 6) && (i<4)) ;
			p = getCursorPosition();
			break;
			
		
		}
		case "tv.zing.vn":
		{
			do
			{
		    i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_tv.zing_icon_Search.png", 30);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_tv.zing_icon_Search.png", 450);
			sleep (7);
			//Handle for site tv.zing.vn
			//if(waitForObjectPresent("pictures\\SaviorWeekly\\Website_tv.zing_Button_Daxem.png", 5))
			// clickOn("pictures\\SaviorWeekly\\Website_tv.zing_Button_Daxem.png");
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_tv.zing_icon_Search.png", 450);
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_tv.zing_Button_Pause.png",3))
			{
				TestLogger.info("Video is playing Now !"); 
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			} 
			while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_tv.zing_Button_Pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			break;
			
		}
		
		
		case "xem.vn":
		{
		
			
			do 
			{
				
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_xem.vn_Picture_logo.png", 15); 
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xem.vn_Picture_logo.png", 250);
				    sleep (25);
					s.click();
					
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xem.vn_Picture_logo.png", 280);
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xem.vn_Picture_logo.png", 250);
			
				 
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xem.vn_Button_Pause.png", 6))
				{
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
			}
			while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_xem.vn_Button_Pause.png", 6) && (i<4)) ;
			p = getCursorPosition();
			break;
		}
		
		
		case "talktv.vn":
		{
			do 
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_talktv_Button_DangKi.png", 30);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_talktv_Button_DangKi.png", 150);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_talktv_Button_DangKi.png", 250);
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_talktv_Button_Pause.png", 5))
				{
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_talktv_Button_Pause.png", 5) && (i<4)) ;
			
			p = getCursorPosition();
			break;
			
			
		}
		
		
		
		
		case "haivn.com":
		{
		
			do 
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_haivn_icon_Search.png", 30);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haivn_icon_Search.png", 150);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haivn_icon_Search.png", 200);
				s.click();
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_haivn_Button_pause.png", 15))
				{
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_haivn_Button_pause.png", 5) && (i< 4)) ;
			
			p = getCursorPosition();
			break;
			
		}
		
		
		
		//dailymotion.com
		case "dailymotion.com":
		{
			
			
			
			do 
			{
				
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_dailymotion_Picutre_Logo.png", 30);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_dailymotion_Picutre_Logo.png", 260);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_dailymotion_Picutre_Logo.png", 280);
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_dailymotion_Button_pause.png", 35))
				{
					TestLogger.info("Video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_dailymotion_Button_pause.png", 5) && (i<4)) ;
			
			p = getCursorPosition();
			break;
		}
		
		
		
		case "cohet.tv":
		{
			do 
			{
				
				i++ ;
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_cohet_Picture_logo.png", 55)) 
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_cohet_Picture_logo.png", 250);
					
				}
				sleep (10) ; 
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_cohet_Picture_logo.png", 250);
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_cohet_Button_pause.png", 12))
				{
					TestLogger.info("video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{ 
					TestLogger.info("refesh video page  because it is NOT  playing Now ! ");
					s.type(Key.F5);
				}
			} while  ((!waitForObjectPresent("pictures\\SaviorWeekly\\Website_cohet_Button_pause.png", 4) || (waitForObjectPresent("pictures\\SaviorWeekly\\cohet_error.png", 5)) ) && (i<4)) ;
			p = getCursorPosition();
			 break; 
			
			
		}
		// LOI
		case "chimsedinang.com":
		{
			   
			do 
			{
				i++ ;
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_chimsedinang_Picture_logo.png", 15)) 
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_chimsedinang_Picture_logo.png",450);
					s.click();
					
				}
				sleep (2);
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_chimsedinang_Button_pause.png", 15))
				{
					TestLogger.info("video is playing Now ! ");
					p = getCursorPosition();
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_chimsedinang_Picture_logo.png",450);
					sleep(2);
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_chimsedinang_Picture_logo.png",450);
					break;
				}
				else
				{ 
					TestLogger.info("refesh video page  because it is NOT  playing Now ! ");
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_chimsedinang_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			 break; 
			
		}
		
		
		case "video.vnexpress.net":{
			
			do 
			{
				i++ ;
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vnexpress_Picture_logo.png", 35)) 
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vnexpress_Picture_logo.png",250);
					
				}
			
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vnexpress_Button_pause.png", 15))
				{
					
					TestLogger.info("video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{ 
					TestLogger.info("refesh video page  because it is NOT  playing Now ! ");
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_vnexpress_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			 break; 
			
			
		}
		
		
		
		
		case "clip.vn":
		{
			
			
			do 
			{
				i ++ ;
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clip_item_search.png", 35)) 
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_clip_item_search.png",200);
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_clip_item_search.png",200);
				}
			    if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clip_Button_Tatquangcao.png", 25))
			    {
			    	clickOn("pictures\\SaviorWeekly\\Website_clip_Button_Tatquangcao.png");
			    }
			    
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clip_Button_pause.png", 55))
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_clip_item_search.png",200);
					TestLogger.info("video is playing Now ! ");
					p = getCursorPosition();
					break;
				}
				else
				{ 
					TestLogger.info("refesh video page  because it is NOT  playing Now ! ");
					s.type(Key.F5);
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_clip_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			 break; 
			
		}
		
		
		
		
		case "kenhvideo.com":
		   {
			  
			   
			   do
				{
				    i++ ;
				    s.type(Key.HOME);
				    sleep (8) ;
					if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_kenhvideo_Picture_logo.png", 15))
					{
						
						moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_kenhvideo_Picture_logo.png",500);
						// scroll to [pause] button 
							s.type(Key.DOWN);
							s.type(Key.DOWN);
							s.type(Key.DOWN);
							sleep(2);
							s.type(Key.DOWN);
						}
					
					
					 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_kenhvideo_Button_Pause1.png", 12))
					 {
					    
						 TestLogger.info("Video is playing now !");
						 p = getCursorPosition();
						 break;
					 }
					 else
					 {
						 s.type(Key.F5);
					 }
				  
				} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_kenhvideo_Button_Pause.png", 10) && (i<4)) ;
				p = getCursorPosition();
				break;
			   
		   }
		   // LOI
		 case "vetv.vn":
		 {
			 
			 do
				{
				 
				 i++ ;
				 
					if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vetv_Picure_logo.png", 15))
					{
						moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vetv_Picure_logo.png",290);
						s.click();
					}
					
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vetv_Picure_logo.png",290);
					
					if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Vetv_Button_Pause.png", 12))
						 {
						     
							 TestLogger.info("Video is playing now !");
							 p = getCursorPosition();
							 break;
						 }
						 else
						 {
							 s.type(Key.F5);
						 }
				
				} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_Vetv_Button_Pause.png", 10) && (i<4)) ;
				p = getCursorPosition();
				 break;
			 
			 
			 
		 }
		
		 case "video.ngoisao.net":
		 {
			 
			
			 do
				{
				 
				 i++ ;
				 
					if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_ngoisao.net_picture_Logo.png", 5))
					{
						moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ngoisao.net_picture_Logo.png",360);
						sleep (15);
						moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ngoisao.net_picture_Logo.png",360);
					}
					
				 

				 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_ngoisao.net_Button_pause.png", 12))
				 {
					 TestLogger.info("Video is playing now !");
						p = getCursorPosition();
					 break;
				 }
				 else
				 {
					 s.type(Key.F5);
				 }
				} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_ngoisao.net_Button_pause.png", 10) && (i<4)) ;
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ngoisao.net_picture_Logo.png", 380);
				 p = getCursorPosition();
				 break;
			 
			 
		 }
		 
		
		 case "video.thethao247.vn":
		 {
			 
			 do
			 {
			 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_thethao247__Button_Play.png", 130);
			 sleep(10);
			 clickOn("pictures\\SaviorWeekly\\Website_thethao247__Button_Play.png");
			 sleep(40);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_thethao247_Picture_logo.png", 480);
			 if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5)) 
			 {
				 TestLogger.info("Video is playing now !");
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			
			 } while (! waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i<4)) ;
			 p = getCursorPosition();
			break;
			 
			 
			 
		 }
		 
		 
		 
		 case "vimeo.com":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_vimeo_Picture_Logo.png", 20);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vimeo_Picture_Logo.png", 150);
			 s.click();
			 p = getCursorPosition();
			 break;
		 }
		 // LOI
		 case "radio.zing.vn":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_zingRadio_Picture_logo.png", 20);
			 sleep(5);
				p = getCursorPosition();
			 break;
		 }
		 // LOI
		 case "animeax.com":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_animeax_Button_Play.png", 50);
			 clickOn("pictures\\SaviorWeekly\\Website_animeax_Button_Play.png");
			 sleep(5);
			 p = getCursorPosition();
			 break;
		 }
		 
		 case "phimdata.com":
		 {
			 do
			 {
			 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\_Website_phimdata_Picture_logo.png", 5);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\_Website_phimdata_Picture_logo.png", 230);
			 
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimdata_Button_Pause.png", 50);
			 clickOn("pictures\\SaviorWeekly\\Website_phimdata_Button_Pause.png");
			 sleep(15);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\_Website_phimdata_Picture_logo.png", 230);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimdata_Button_Pause.png", 5))
			 {
				 TestLogger.info("Video is playing Now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\_Website_phimdata_Picture_logo.png", 230);
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
				 sleep (15);
			 }
			 
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimdata_Button_Pause.png", 5) && (i<4));
			 p = getCursorPosition();
			 break;
			
		 }
		 case "phimnhanh.net":
		 {
			 i=1 ;
			 do
			 {
			 i++;
			 sleep(25);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimnhanh_picture_logo.png", 400);
			 s.click();
			 if (waitForObjectPresent("pictures\\Website_phimdata_Button_Pause.png", 5))
			 {
				 TestLogger.info("Video is playing Now !");
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\Website_phimdata_Button_Pause.png", 5) && (i<4)) ;
			 break;
		 }
		 
		 
		 case "vipphim.net":
		 {
			 
			 do
			 {
			 i++ ;
			 sleep(20);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vipphim_Picture_Logo.png", 200);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vipphim_Button_pause.png", 5))
			 {
			 TestLogger.info("Video is playing Now !");
			 p = getCursorPosition(); 
			 break ;
			 } 
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_vipphim_Button_pause.png", 5) && (i<4)) ;
			 break;
		 }
		 
		 case "phimvon.com":{
			 
			 do 
			 {
				 i++ ;
				 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimvonPicture_logo.png", 10);
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvonPicture_logo.png",250);
				 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimvon_Button_Play.png", 15);
				 sleep (12);
				 clickOn("pictures\\SaviorWeekly\\Website_phimvon_Button_Play.png");
				 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website__Phimvon_Button_Pause.png", 6))
				 {
					 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvonPicture_logo.png",250);
					 TestLogger.info("Video is playing Now ! ");
						p = getCursorPosition();
					 break;
				 }
				 else
				 {
					 s.type(Key.F5);
					 sleep (15);
					 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvonPicture_logo.png",250);
				 }
					 
				 
				 
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website__Phimvon_Button_Pause.png", 6) && (i<4)) ;
			 
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvonPicture_logo.png",250);
				p = getCursorPosition();
			 break;
			 
		 } 
		 
		 // LOI
		 case "pubvn.tv":
		 {
			 do
			 {
			 i++ ;
			 s.type(Key.HOME);
			 sleep (5);
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_Pubvn_picture_logo.png", 50);
//			 String imagePath = getResource("pictures\\SaviorWeekly\\Website_pubvn_Button_Play.png");
//			 scrollPageToObject(imagePath);
			 do 
			 {
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
				 s.type(Key.DOWN);
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_pubvn_control_volumn.png", 2));
			 
			 clickOn("pictures\\SaviorWeekly\\Website_pubvn_Button_Play.png");
			 sleep(35);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_pubvn_Button_Lighton.png", -100);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_pubvn_Button_Pause.png", 7))
			 {
				 TestLogger.info("Video is playing Now !");
					p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_pubvn_Button_Pause.png", 7) && (i<4));
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_pubvn_Button_Lighton.png", -100);
				p = getCursorPosition();
			 break;
			 
		 }
		 // LOI
		 case "phim22.com":
		 {
			do
			{
				sleep (6);
				i++ ;
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png", 15))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png");
				}
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png", 3))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png");
				}
				
			 sleep(30);
			 s.type(Key.HOME);
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Picture_logo.png", 50);
			
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim22_Picture_logo.png", 380);
			 
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Button_OK.png", 5))
			 {
				 clickOn("pictures\\SaviorWeekly\\Website_phim22_Button_OK.png");
				 sleep (3);
				 s.type(Key.F5);
				 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png", 15))
					{
						clickOn("pictures\\SaviorWeekly\\Website_phim22_Button_Close.png");
					}
			 }
			
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_Phim22_button_Pause.png", 12))
			 {
				 TestLogger.info("Video is playing now !");
				 s.type(Key.HOME);
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim22_Picture_logo.png", 380);
					p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
				 s.type(Key.HOME);
			 }
			} while (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim22_Text_error.png", 10) && (i<4)) ;
			p = getCursorPosition();
			 break;
			 
		 }
		 
		 
		 case "phim7.com":
		 {
			 do
			 {
			 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim7_Button_logo.png", 50);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim7_Button_logo.png", 380);
			 s.click();
			 if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 8))
			 {
				 TestLogger.info("Video is playing Now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim7_Button_logo.png", 380);
				 p = getCursorPosition();
				 break ;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 
			 
			 } while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 8) && (i<2)) ;
			 
			
			 break;
		 }
		 
		 case "hayxemphim.com":{
			 do 
			 {
		      i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Picture_Logo.png", 20);
			 if(waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Button_Play.png", 6))
			 {

		     clickOn("pictures\\SaviorWeekly\\Website_hayxemphim_Button_Play.png");
		      if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Text_Error.png", 8))
		    		  { 
		    	        s.type(Key.F5);
		    	        sleep (20);
		    		  }
		           
		      else if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Button_Pause.png", 5))
		           {
		    	     moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hayxemphim_Picture_Logo.png",400);
		    	     TestLogger.info("Video is playing Now ");
		    	 	p = getCursorPosition();
		    	     break;
		           }
		    
			
			
			 }
			 else
			 {
				 s.type(Key.F5);
				 sleep (15);
			 }
			 
			 } while ( (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Text_Error.png", 8)) || (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayxemphim_Button_Pause.png", 8)) && (i<4)) ;
				p = getCursorPosition();
			 break;
			 
		 }
		 case "m-viet.com":
		 {
			 if(waitForObjectPresent("pictures\\SaviorWeekly\\Website_m-viet_Button_Play.png", 50)){
				 sleep(5);
				 s.click();
			 }
			 p = getCursorPosition();
			 break;
		 }
		 
		 // LOI
		 case "nhac.hay365.com":
		 {
			 
			 do
			 {
				 
				 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhachay365_Picture_logo.png", 50) ;
		
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhachay365_Picture_logo.png", 400);
			 
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhachay365_Button_pause.png", 70))
			 {
				 TestLogger.info("Video is playing Now !");
					p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 
			 
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhachay365_Button_pause.png", 5) && (i<4));
				p = getCursorPosition();
			 break;
		 }
		 
		 case "ssphim.com":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_ssphim_Picture_logo.png", 50);
			 sleep(10);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ssphim_Picture_logo.png", 350);
			 p = getCursorPosition();
			 break;
		 }
		 
		 
		 case "phimtructuyenhd.com":
		 {
			 do
			 {
			 i++ ;
			 sleep (12);
			 s.type(Key.HOME);
			 s.type(Key.HOME);
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimtructuyen_Picture_logo.png", 50);
			
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimtructuyen_Picture_logo.png", 350);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimtructuyen_Button_pause.png", 15))
			 { 
				
				 TestLogger.info("video is playing Now !");
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
				 sleep (12);
				 s.type(Key.HOME);
				 
			 }
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimtructuyen_Button_pause.png", 7) && (i<4)) ;
		
				p = getCursorPosition();
			break;
		 }
		 
		 // LOI
		 case "xuongphim.tv":
		 {
			do
			{
			i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xuongphim_picture_logo.png", 50);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xuongphim_picture_logo.png", 300);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xuongphim_Button_pause.png", 35))
			{
				
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_xuongphim_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			break;
		 }
		 
		 
		 case "vino.vn/mp3":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_vino_Button_Pause.png", 50);
			 p = getCursorPosition();
			 break;
		 }
		 
		 
		 case "haivl.io":
		 {
			 do
			 {
			  i ++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiio_picture_Menu.png", 50);
			 sleep (15) ;
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiio_picture_Menu.png", 180);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiio_Button_play.png", 5))
			 {
				 clickOn("pictures\\SaviorWeekly\\Website_haiio_Button_play.png");
			 }
			 
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiio_paButton_use.png", 8))
			 {
				 TestLogger.info("Video is playing Now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiio_picture_Menu.png", 180);
				 p = getCursorPosition();
				 break ;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiio_paButton_use.png", 8) && (i<4)) ;
			 
			 p = getCursorPosition();
			 break;
			 
		 }
		 
		 case "nhacvang.org":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhacvang_Button_search.png", 50);
			 sleep(10);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhacvang_Button_search.png", 350);
			 p = getCursorPosition();
			 break;
		 }
		 
	
		 case "clipvuivn.com":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipvui.vn_picture_logo.png", 30);
			 
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_clipvui.vn_picture_logo.png", 300);
			 s.click();
				p = getCursorPosition();
			 break;
		 }
		 
		 case "phimporn.com":
		 {
			 
			 do
			 {
				 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimporm.com_picture_logo.png", 50);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimporm.com_picture_logo.png", 300);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimporm.com_picture_logo.png", 300);
			 
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimporm.com_Button_pause.png",55))
			 {
				 TestLogger.info("Video is playing Now !");
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimporm.com_picture_logo.png", 300);
				 p = getCursorPosition();
				 break ;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimporm.com_Button_pause.png", 6) && (i<4)) ;
			 
			 p = getCursorPosition();
			 break;
			 
			 
		 }
		 case "123tv.vn":
		 {
			 
			 do
			 {
			 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_123tv_picture_logo.png", 35);
			 sleep (15);
			 clickOn("pictures\\SaviorWeekly\\website_123tv_Button_play.png");
			 sleep(20);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_123tv_picture_logo.png", 350);
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_123tv_Button_pause.png", 15))
			 {
				 TestLogger.info("Video is playing now !"); 
				  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_123tv_picture_logo.png", 350);
				  p = getCursorPosition();
				  break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
		
			 } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_123tv_Button_pause.png", 5) && (i<4)) ;
			 p = getCursorPosition();
			 break;
		 }
		
		 case "phimonlinehd.net":
		 {
			 
			 do
			 {
			 i++ ;
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimonlineHD_picture_logo.png", 20);
			 sleep(10);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimonlineHD_picture_logo.png", 250);
			 if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5)) 
					 {
				     TestLogger.info("Video is playing Now !");
				     p = getCursorPosition();
				     break;
					 }
			 else
			 {
				 s.type(Key.F5);
			 }
			 } while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i<4)) ;
			 
			 break;
			 
		 }
		 case "hai24h.net":
		 {
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_hai24h.net_Button_likeOnFacebook.png", 30);
			 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hai24h.net_Button_likeOnFacebook.png", 150);
			 s.click();
			 p = getCursorPosition();
			 break;
		 }
		

		// ================= Haperfect =================
        
		case "phimhd.vn": {
			do
			{
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimHD_picture_logo.png", 50);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimHD_picture_logo.png", 200);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimHD_picture_logo.png", 240);
		
			s.type(Key.DOWN);
			s.type(Key.DOWN);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimhd_Button_pause.png", 5))
			{
				TestLogger.info("Video is playing Now !"); 
				p = getCursorPosition();
				break;
			}
			else
			{ 
				i++;
				s.type(Key.F5);
			}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimhd_Button_pause.png", 5) && (i<4)) ;
			
			break;
		}

		case "phimvipvn.net": {

			do 
			{
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimvipvn_picture_logo.png", 10);
			// Handle for site phimvipvn.net
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvipvn_picture_logo.png", 470);
			s.click();
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimvipvn_Button_pause.png", 5))
			{
				s.type("Video is playing Now !");
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimvipvn_picture_logo.png", 470);
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
		
	
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimvipvn_Button_pause.png", 5) && (i<4)) ;
			p= getCursorPosition();
			break;
		}
		
		
		case "24h.com.vn": {
			// doi logo Bolbol
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_24h_Text_tuyendung.png", 10);
			// di chuyen xuong toa do tu logo Bolbol
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_24h_Text_tuyendung.png", 330);
            if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_24h_Button_play.png", 10))
            {
			clickOn("pictures\\SaviorWeekly\\Website_24h_Button_play.png");
            }
			// doi 5s cho quang cao
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_24h_Button_closeAds.png", 6);
			clickOn("pictures\\SaviorWeekly\\Website_24h_Button_closeAds.png");
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_24h_Text_tuyendung.png", 350);
			p = getCursorPosition();
			break;
		}

		case "nhaccuatui.com": {
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhaccuatui_Button_Chophep.png", 3))
			{
				clickOn("pictures\\SaviorWeekly\\Website_nhaccuatui_Button_Chophep.png");
			}
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhaccuatui_Button_CloseAds.png", 4))
			{
				clickOn("pictures\\SaviorWeekly\\Website_nhaccuatui_Button_CloseAds.png");
			}
            
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhaccuatui_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhaccuatui_picture_logo.png", 200);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhaccuatui_picture_logo.png", 250);
			p = getCursorPosition();
			break;
		}

		case "clip.vietnamnet.vn": {
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_mvietnamnet_picture_logo.png", 50);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mvietnamnet_picture_logo.png", 200);
			s.click();
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mvietnamnet_picture_logo.png", 300);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mvietnamnet_picture_logo.png", 330);
			p = getCursorPosition();
			break;
		}

		case "afamily.vn": {
			do
			{

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_afamily_picture_logo.png", 50);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_afamily_picture_logo.png", 380);
			sleep (5);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_afamily_picture_logo.png", 380);
			sleep (5);
		
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 12))
			{
				TestLogger.info("Video is playing Now ");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5)) ;
			p = getCursorPosition();
			break;
		}

		case "media.bongdaplus.vn": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_picture_logo.png",
					200);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_Button_ads.png", 12))
			{
				clickOn("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_Button_ads.png");
			}
			sleep(12);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_Button_play.png", 5))
			{
				clickOn("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_Button_play.png");
			}
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mediabongdaplusvn_picture_logo.png",
					240);
			p = getCursorPosition();
			break;
		}

		case "bongdaclip.com": {
            do 
            {
            i++ ;
            
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongdaclipcom_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_bongdaclipcom_picture_logo.png", 350);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongdaclip.com_Button_play.png", 6);
			
			clickOn("pictures\\SaviorWeekly\\Website_bongdaclip.com_Button_play.png");
			sleep(25);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongdaclip.com_Button_pause.png", 5))
			{
				TestLogger.info("Video is playing Now ! ");
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_bongdaclipcom_picture_logo.png", 360);
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			
            } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongdaclip.com_Button_pause.png", 6) && (i< 4)) ;
        	p = getCursorPosition();
			break;
		}

		case "gamek.vn": {
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_gamekvn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_gamekvn_picture_logo.png", 600);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_gamekvn_picture_logo.png", 640);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_gamekvn_picture_logo.png", 630);
			p = getCursorPosition();
			break;
		}
		
		
		case "phapluattp.vn": {
			
			do 
			{
				i ++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_phapluattp.vn_picture_logo.png", 5);

				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phapluattp.vn_picture_logo.png", 350);
	             s.click();
	             if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phapluattp.vn_Button_pause.png", 12))
	             {
	            	 TestLogger.info("Video is playing Now ! ");
	            	 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phapluattp.vn_picture_logo.png", 350);
	            	 p= getCursorPosition();
	            	 break;
	             }
	             else
	             {
	            	 s.type(Key.F5);
	             }
	             
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phapluattp.vn_Button_pause.png", 5) && (i<3)) ; 
			
			p= getCursorPosition();
             
			break;
		}

		case "video.ringring.vn": {
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_video.ringring.vn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_video.ringring.vn_picture_logo.png",
					200);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_video.ringring.vn_picture_logo.png",
					230);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_video.ringring.vn_picture_logo.png",
					240);
			p = getCursorPosition();
			break;
		}

		
		  case "phim.clip.vn": {
		  
		  waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimclipvn_icon_search.png", 5);
		  
		  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimclipvn_icon_search.png", 200);
		  if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clipvn_Button_facebbook.png", 5))
		  {
		  clickOn("pictures\\SaviorWeekly\\Website_clipvn_Button_facebbook.png");
		  clickOn("pictures\\SaviorWeekly\\Website_clipvn_TextField_User.png");
		  s.type("coccocbrowser03@gmail.com");
		  
		  
		  clickOn("pictures\\SaviorWeekly\\Website_clipvn_TextField_passbtn.png");
		  s.type("browsertest3");
		  clickOn("pictures\\SaviorWeekly\\Website_facebook_Button_login.png");
		  }
		  sleep(12);
		 
		  if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_clip.vn_Button_xemtiep.png", 5))
		  {
			  clickOn("pictures\\SaviorWeekly\\Website_clip.vn_Button_xemtiep.png");
		  }
		  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimclipvn_icon_search.png", 200);
		  p = getCursorPosition();
		  break; 
		  
		  }
		 
        
		case "2sao.vn": {
			do 
			{
				i++ ;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_2sao.vn_picture_logo.png", 35);
				sleep(15);
				
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_2sao.vn_picture_logo.png", 650);
				
				s.click();
				sleep(15);
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_2sao.vn_picture_logo.png", 630);
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_2sao.vn_Button_pause.png", 25))
				{
					TestLogger.info("Video is playing now !");
					p = getCursorPosition();
					break; 
				}
				else
				{
					s.type(Key.F5);
					s.type(Key.HOME);
					
				}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_2sao.vn_Button_pause.png", 5) && (i<4)) ;

			
			p = getCursorPosition();
			break;
		}
		case "haiivl.com": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 100);
			s.click();
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 120);
			p = getCursorPosition();
			break;
		}

		case "chatvl.com": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 250);
			s.click();
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_haiivl.com_picture_logo.png", 270);
			p = getCursorPosition();
			break;
		}

		case "videos.vietgiaitri.com": {
			
         do 
         {
        	 i++ ;
			waitForObjectPresent(
					"pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_picture_logo.png", 5);

			moveMouseDownFromLogo(
					"pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_picture_logo.png", 360);

			sleep (10) ;
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vietgiaitri_Button_closeAds.png", 10)) {
				clickOn("pictures\\SaviorWeekly\\Website_vietgiaitri_Button_closeAds.png");
			    sleep (10);
			     if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vietgiaitri_Button_closeAds2.png", 5))
			     {
			    	 clickOn("pictures\\SaviorWeekly\\Website_vietgiaitri_Button_closeAds2.png");
			     }
			    
			}
			moveMouseDownFromLogo(
					"pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_picture_logo.png", 380);
			s.click();
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_Button_pause.png", 15))
			{
				TestLogger.info("Video is playing now !");
				moveMouseDownFromLogo(
						"pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_picture_logo.png", 380);
				p = getCursorPosition();
				break ;
			}
			else
			{
				s.type(Key.F5);
			}
			
			
         } while (! waitForObjectPresent("pictures\\SaviorWeekly\\Website_videos.vietgiaitri.com_Button_pause.png", 5) && (i<4)) ;
		   break;
		}

	

		case "megafun.vn": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_megafun.vn_picture_logo.png", 5); 

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_megafun.vn_picture_logo.png", 550);
			sleep(20);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_megafun.vn_picture_logo.png", 580);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_megafun.vn_picture_logo.png", 590);
			p = getCursorPosition();
			break;
		}
     
		case "cand.com.vn": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Webiste_cand.com.vn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Webiste_cand.com.vn_picture_logo.png", 700);

			s.click();
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Webiste_cand.com.vn_picture_logo.png", 730);
			p = getCursorPosition();
			break;
		}

		case "ohay.tv": {
			i = 0 ;
            do 
            {
            
            i++;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_ohay.tv_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ohay.tv_picture_logo.png", 550);
			sleep (2);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ohay.tv_picture_logo.png", 580);
			s.click();
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_ohay_Button_pause.png", 6))
			{
				TestLogger.info("Video is playing Now !"); 
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
		
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_ohay_Button_pause.png", 6) && (i<4));
			
			p = getCursorPosition();
			break;
		}
		
		case "phim.megabox.vn": {
			do
			{
            i++;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.megabox.vn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim.megabox.vn_picture_logo.png", 220);
            sleep (5);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim.megabox.vn_picture_logo.png", 240);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.megabox.vn_Button_pause.png", 6))
			{
				TestLogger.info("Video is playing Now !"); 
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
		
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.megabox.vn_Button_pause.png", 6) && (i<4));
			p = getCursorPosition();
			
			break;
		}

		case "anhtrang.org": {
		   i=1;
           do
           {
        	i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_anhtrang.org_Picture_logo.png", 5);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_anhtrang.org_Picture_logo.png", 340);
			s.click();
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_anhtrang.org_Button_pause.png", 5))
			{
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			
           } while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_anhtrang.org_Button_pause.png", 5) && (i<4)) ;
            p = getCursorPosition();
			break;
		}

		case "bongda365.com.vn": {
            sleep (5);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_bongda365.com.vn_picture_logo.png", 35);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_bongda365.com.vn_picture_logo.png", 440);
			s.click();
			p = getCursorPosition();
			break;
		}

		case "xemphimone.com": {
			i=1;
			do
			{
			i++;
            s.type(Key.HOME);
            sleep(3);
            s.type(Key.HOME);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimone.com_Text_Taiphim.png", 10);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimone.com_Text_Taiphim.png", -200);
			sleep (3);
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimone.com_Text_Taiphim.png", -200);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimone_Button_pause.png", 6))
			{
				TestLogger.info("Video is playing Now !"); 
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimone.com_Text_Taiphim.png", -200);
				p = getCursorPosition();
				break;
				
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimone_Button_pause.png", 6) && (i<4));
			p = getCursorPosition();
			break;
		}

		case "8bongda.com": {

			  do 
			  {
				 
				 s.type(Key.PAGE_DOWN); 
				 sleep(5);
				 s.type(Key.PAGE_DOWN); 
				 i++ ;
			  }
			  
			  while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_8bongda_picture_logo.png", 8) && (i<4)) ;
				
			  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_8bongda_picture_logo.png", 100);
	          s.click(); 
	          sleep(30);
	          moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_8bongdapicture_messi.png", 250);
	          p = getCursorPosition();
			  break;
			
		}
		
		
		
		

		case " twitter.com": {
			do
			{
            i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_twitter.com_text_theodoi.png", 8);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_twitter.com_text_theodoi.png", 550);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_twitter.com_text_theodoi.png", 570);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_twitter.com_Button_pause.png", 16))
			{
				TestLogger.info("Video is playing Now ");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			} while (! waitForObjectPresent("pictures\\SaviorWeekly\\Website_twitter.com_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			break;
		}

		case "news.zing.vn": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_news.zing.vn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_news.zing.vn_picture_logo.png", 270);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_news.zing.vn_picture_logo.png", 280);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_news.zing.vn_picture_logo.png", 260);
			p = getCursorPosition();
			break;
		}
		case "hdviet.com": {
			
			do
			{
				
			  i++;
			  
              if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hdviet_button_Play.png", 8))
              {
            	  clickOn("pictures\\SaviorWeekly\\Website_hdviet_button_Play.png");
              }

			
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hdviet.com_Button_boqua.png", 15))
			{
		   
			clickOn("pictures\\SaviorWeekly\\Website_hdviet.com_Button_boqua.png");
            sleep(35);
			}
			
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hdviet_picture_logo.png", 150);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hdviet_picture_logo.png", 180);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hdviet_Button_pause.png", 5))
			{
				
				TestLogger.info("Video is playing Now ");
				
				
				p = getCursorPosition();
				
				break;
				
			}
			else
			{
				s.type(Key.F5);
			}
			
			
			
			} while (!waitForObjectPresent("Website_hdviet_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			break;
		}
		
		case "vivo.vn": {

			do
			{
			i++ ;
            waitForObjectPresent("pictures\\SaviorWeekly\\Website_vivo_picture_logo.png", 30);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vivo_picture_logo.png", 300);
			sleep (7);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vivo_picture_logo.png", 320);
			sleep (7);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vivo_Button_pause.png", 100))
			{
				TestLogger.info("Video is playing Now !");
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vivo_picture_logo.png", 360);
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_vivo_Button_pause.png", 5) && (i<4)) ;
			
			break;
		}
        
		case "keeng.vn": {
            do
            {
            i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_keeng.vn_picture_logo.png", 35);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_keeng.vn_picture_logo.png", 300);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_keeng.vn_picture_logo.png", 330);
			// s.click();
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_keeng_Button_pause.png", 5))
			{
				TestLogger.info("Video is playing Now ! ");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			
            } while (! waitForObjectPresent("pictures\\SaviorWeekly\\Website_keeng_Button_pause.png", 5) && (i<4));
			break;
		}

		case "nhacso.net": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhacso.net_icon_search.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhacso.net_icon_search.png", 300);

			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhacso_Button_skipAds.png", 8))
			{
			clickOn("pictures\\SaviorWeekly\\Website_nhacso_Button_skipAds.png");
			}
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhacso.net_icon_search.png", 320);
			p = getCursorPosition();
			break;
		}

		case "biphim.com": {
            s.type(Key.HOME);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_biphim.com_picture_logo.png", 10);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_biphim.com_picture_logo.png", 740);
			 if (waitForObjectPresent("pictures\\Browser_Savior_Button_DownloadOnVideo.png", 15))  
			 {
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_biphim.com_picture_logo.png", 760); 
					s.click();
					// moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_biphim_Button_Xem.png", 620);
					p = getCursorPosition();
					break;
			 }
			 else {
				    s.type(Key.F5);
					s.type(Key.HOME);
					sleep(2);
					waitForObjectPresent("pictures\\SaviorWeekly\\Website_biphim.com_picture_logo.png", 10);
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_biphim.com_picture_logo.png", 750);
					p = getCursorPosition();
					break; 
			 }
			
		}

		case "mp3.zing.vn": {
            //sleep(8);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_mp3.zing.vn_picture_logo.png", 5);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mp3.zing.vn_picture_logo.png", 200);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_mp3.zing.vn_picture_logo.png", 250);
			p = getCursorPosition();
			break;
		}
        // LOI
		case "xemvtv.net": {
            s.type(Key.HOME);
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemvtv.net_picture_logo.png", 35);
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemvtv.net_picture_logo.png", 250);
              sleep(15);
              s.type(Key.HOME);
          	moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemvtv.net_picture_logo.png", 350);
        	p = getCursorPosition();
			break;
		}
        
		case "hayhaytv.vn": {
			
			do
			{
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hayhaytv.vn_icon_Search.png", 280);	
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayhaytv.vn_Button_Start.png", 3)) 
			{
				clickOn("pictures\\SaviorWeekly\\Website_hayhaytv.vn_Button_Start.png");
				sleep (60) ;
			}
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hayhaytv.vn_icon_Search.png", 280);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayhaytv.vn_Button_Pause.png", 15))
			{
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break ;
			}
			else
			{   
				i++ ;
				s.type(Key.F5);
				sleep (15);
				s.type(Key.HOME);
				
				
				
				
			}
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_hayhaytv.vn_Button_Pause.png", 5) && (i<4)) ;  
			p = getCursorPosition();
			break; 
	            
		
			
			
			
		}
		
		case "phim14.net": {
			do
			{
			i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.vn_picture_logo.png", 20); 

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim14.vn_picture_logo.png", 520);
			sleep (2);
			s.click();
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.vn_Button_Pause.png",25))
			{
				TestLogger.info("Video is playing Now !");
			     break;
			} 
			else
			{
				s.click();
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png", 5))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png");
					sleep (10);
					if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.vn_Button_Pause.png",25))
					{
						TestLogger.info("Video is playing Now !");
					    break;
					} 
				}
			}
			
			
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14_Button_closeAds.png", 20)) {
				clickOn("pictures\\SaviorWeekly\\Website_phim14_Button_closeAds.png"); 
				
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png", 5))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png");
					sleep (10);
				}
			
			
            }
			
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14_Button_skipAds.png", 20)) {
				clickOn("pictures\\SaviorWeekly\\Website_phim14_Button_skipAds.png"); 
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png", 5))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png");
				}
            }
			
            s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim14.vn_picture_logo.png", 370);
			
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14_Button_skipAds.png", 20)) {
				clickOn("pictures\\SaviorWeekly\\Website_phim14_Button_skipAds.png"); 
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png", 5))
				{
					clickOn("pictures\\SaviorWeekly\\Website_phim14.net_icon_tab.png");
				}
            }
			
			
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.vn_Button_Pause.png",25))
			 {
				 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim14.vn_picture_logo.png", 370);
				 TestLogger.info("Video is playing Now !");
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
			 }
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim14.vn_Button_Pause.png", 5) && (i<4));
			p = getCursorPosition();
			break;
		}

		case "phim3s.net": {

			
			do 
			{
			i++ ;
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim3s.net_pic_Tatden.png", 15);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phim3s.net_pic_Tatden.png", -160);
			sleep (30);
			
			
			
			 if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim3s_Button_pause.png",30))
			 {
				 TestLogger.info("Video is playing Now");
				
				 p = getCursorPosition();
				 break;
			 }
			 else
			 {
				 s.type(Key.F5);
				 TestLogger.info("Refesh this page thus video is NOT avaiable Now ! => times " + i );
			 }
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim3s_Button_pause.png", 5) && (i<4)) ;
			 p = getCursorPosition();
			break;
		}
		
		
		
		case "anime47.com": {
			do
			{
			i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_anime47.com_Menu_Home.png", 30);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_anime47.com_Menu_Home.png", 300);
			s.click();
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_anime47.com_Menu_Home.png", 300);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_anime47_Button_pause.png", 15))
			{
				TestLogger.info("Video is playing Now ");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_anime47_Button_pause.png", 5) && (i<4));
			p = getCursorPosition();
			break;
		}

		//
		case "hdonline.vn": {
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_hdonline.vn_icon_logo.png", 8);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hdonline.vn_icon_logo.png", 360);
			sleep(6);
			s.click();
            if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_hdonline.vn_picture_bannerQC.png", 20))
            {
            	sleep(1);
            }
            
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_hdonline.vn_icon_logo.png", 300);
			p = getCursorPosition();
			break;
		}

		//
		case "fptplay.net": {
			do
			{
				i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_ptplay.net_text_Phim.png", 30);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ptplay.net_text_Phim.png", 300);
			sleep(30);
			
            /*clickOn("pictures\\SaviorWeekly\\Website_fptplay.net_Button_play.png");
			sleep(30);*/
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ptplay.net_text_Phim.png", 330);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ptplay.net_text_Phim.png", 350);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_fptplay.net_Button_pause.png", 15))
			{
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_ptplay.net_text_Phim.png", 350);
				TestLogger.info("Video is playing Now ");
				p = getCursorPosition();
				break;
				
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_fptplay.net_Button_pause.png", 15) && (i<3));
			p = getCursorPosition();
			break;
		}

		//
		case "vuighe.net": {
			do 
			{
				i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_vuighe_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vuighe_picture_logo.png", 300);
			
			
			
			sleep (20);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vuighe_picture_logo.png", 250);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vuighe_Button_pause.png", 20))
			{
				TestLogger.info("Video is playing Now");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_vuighe_Button_pause.png", 5) && (i<4)) ;
			p = getCursorPosition();
			break;
		}
		//
		case "xemphimso.com": {
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xemphimso.com_picture_logo.png", 35);
			s.type(Key.HOME);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimso.com_picture_logo.png", 530);
		
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimso.com_picture_logo.png", 520);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xemphimso.com_picture_logo.png", 550);
			p = getCursorPosition();
			break;
		}

		

		case "xemphimon.com": {
			do
			{
			i++ ;
			sleep(20);
			s.type(Key.HOME);
			s.type(Key.HOME);
			waitForObjectPresent("pictures\\SaviorWeekly\\WEbsite_xemphimon.com_picture_logo.png", 15);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\WEbsite_xemphimon.com_picture_logo.png", 500);
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\WEbsite_xemphimon.com_picture_logo.png", 500);
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 10)) 
			{
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i<4)) ;
			break;
		}

		
		case "chiasenhac.com": { 
		
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_chiasenhac.com_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_chiasenhac.com_picture_logo.png", 200);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_chiasenhac.com_picture_logo.png", 250);
			p = getCursorPosition();
			break;
		}
      
		case "vkool.net": {
			
			do 
			{
				i++ ; 
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_icon_Closeqctrangkhac.png", 5))
				{
					 
           	     clickOn("pictures\\SaviorWeekly\\Website_vkool.net_icon_Closeqctrangkhac.png");
           	     sleep (20);
           	         waitForObjectPresent("pictures\\SaviorWeekly\\vkool.net_icon.png", 25);
					 clickOn("pictures\\SaviorWeekly\\vkool.net_icon.png");
					 s.type(Key.HOME);
					 sleep (8); 
					 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
					 s.type(Key.HOME);
					 moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 420); 
				}
				else if (waitForObjectPresent("pictures\\SaviorWeekly\\vkool.net_OK.png", 20))
				 {  
					 clickOn("pictures\\SaviorWeekly\\vkool.net_OK.png");
					 s.type(Key.F5);
					// s.type(Key.F5);
					 sleep(25) ;
					 s.type(Key.HOME);
					 waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 10);
		             moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
		            
				 }
				else
				{
					 sleep(25) ;
					 s.type(Key.HOME);
					 waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png",30);
		             moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
		             sleep(25);
		             s.type(Key.HOME);
		             moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
		             
				}
				
					
			
				
				
			} while ( (waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_icon_Closeqctrangkhac.png", 10) || waitForObjectPresent("pictures\\SaviorWeekly\\vkool.net_OK.png", 10)) && (i<4));
			
			 sleep(25) ;
			 s.type(Key.HOME);
			 waitForObjectPresent("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 25);
             moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 450); 
             sleep(25);
             s.type(Key.HOME);
             moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
             if (waitForObjectPresent("pictures\\SaviorWeekly\\vkool.net_pause.png", 20))
             {
           	  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_vkool.net_Picture_logo.png", 440); 
          	p = getCursorPosition();
           	  break ;
           	  
             }
         	p = getCursorPosition();
             break ;
				
			
		}
		case "phim.in": {
			
			do 
			{
				
		    i++ ;
		    clickOn("pictures\\SaviorWeekly\\Webiste_phim.in_text_video.png");
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\WEbsite_phim.in_Picture_logo.png", 350);
		
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phim.in_Button_play.png", 10);
			clickOn("pictures\\SaviorWeekly\\Website_phim.in_Button_play.png");
			sleep (7);
		    clickOn("pictures\\SaviorWeekly\\Webiste_phim.in_text_video.png");
			s.type(Key.HOME);
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\WEbsite_phim.in_Picture_logo.png", 350);
			
			if (waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 10))
			{
				TestLogger.info("Video is playing Now !");
				p = getCursorPosition();
				break;
			}
			else
			{
			  s.type(Key.F5);
			}
			
			} while (!waitForObjectPresent("pictures\\Browser_Savior_Button_PIN.png", 5) && (i<4)) ;
				
			p = getCursorPosition();
			break;
		}
		
		//
		case "nhac.vui": 
		{
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhac.vui.vn_Button_closeAds.png", 10);
			clickOn("pictures\\SaviorWeekly\\Website_nhac.vui.vn_Button_closeAds.png");

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_nhac.vui.vn_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhac.vui.vn_picture_logo.png", 320);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_nhac.vui.vn_picture_logo.png", 340);
			p = getCursorPosition();
			break;
		}
		
		case "me.zing.vn": {
			do
			{
                i++;
				waitForObjectPresent("pictures\\SaviorWeekly\\Website_me.zing.vn_Text_ChatvoiAdmin.png", 5);

				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_me.zing.vn_Text_ChatvoiAdmin.png", 220);
				s.click();
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_me.zing.vn_Text_ChatvoiAdmin.png", 230);
				if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_me.zing.vn_Button_pause.png", 15))
				{
					TestLogger.info("Video is playing Now !"); 
					p = getCursorPosition();
					break;
				}
				else
				{
					s.type(Key.F5);
				}
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_me.zing.vn_Button_pause.png", 5) && (i<4)) ;

			p = getCursorPosition();
			break;
		}
		

        case "v.nhaccuatui.com": {
			

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_v.nhaccuatui.com_icon_home.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_v.nhaccuatui.com_icon_home.png", 220);
			
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_v.nhaccuatui.com_icon_home.png", 240);
			p = getCursorPosition();
			break;
		}
        
		case "phimmoi.net": {
			do
			{
			i++; 
			s.type(Key.HOME);
			
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimmoi.net_picture_logo.png", 15);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_picture_logo.png",850);
		
			s.type(Key.HOME);
			  
			do 
			{
			  j++ ; 
			  moveMouseHorizontallyFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_Text_TitleFilm.png", 226 );
			  s.click();
			  s.type(Key.DOWN);
			  sleep (1);
			  s.type(Key.DOWN);
			  sleep (2);
			  s.type(Key.DOWN);
			  sleep (2);
			  s.type(Key.DOWN);
			  s.type(Key.DOWN);
			
			  moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_Text_TitleFilm.png", 500);
			  
			  
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimmoi.net_Button_pause.png", 2) && (j<4)) ;
			
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_picture_logo.png",850);
			moveMouseHorizontallyFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_Text_TitleFilm.png", 226 );
			  s.click();
			  s.type(Key.DOWN);
			  sleep (1);
			  s.type(Key.DOWN);
			  
			/*if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimmoi.net_Button_closeAds.png", 30)) 
			{
				clickOn("pictures\\SaviorWeekly\\Website_phimmoi.net_Button_closeAds.png");
			}
			*/
			s.type(Key.HOME);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_picture_logo.png",850);
			
			   if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimmoi.net_Button_pause.png", 5))
			   {
				   TestLogger.info("Video is playing Now !");
				   moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_phimmoi.net_picture_logo.png",580);
					p = getCursorPosition();
				   break;
			   }
			   else
			   {
				   s.type(Key.F5);
			   }
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimmoi.net_Button_pause.png", 5) && (i<4));
			p = getCursorPosition();
			break;
		}

		case "soundcloud.com": {
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_soundcloud.com_picture_logo.png", 5);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_soundcloud.com_picture_logo.png", 150);
			p = getCursorPosition();
			break;
		}

		case "xvideos.com": {
			do
			{
				
		   i++; 
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xvideos.com_Text_Checker.png", 30);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xvideos.com_Text_Checker.png", 200);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xvideos.com_Button_play.png", 30))
			{
			clickOn("pictures\\SaviorWeekly\\Website_xvideos.com_Button_play.png");
			}
			sleep (15);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xvideos.com_Text_Checker.png", 220);
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_xvideos.com_Button_pause.png", 15))
			{
				moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xvideos.com_Text_Checker.png", 220);
				TestLogger.info("Video is playing Now ");
				p = getCursorPosition();
				break;
				
			}
			else
			{
				s.type(Key.F5);
			}
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_xvideos.com_Button_pause.png", 15) && (i<4));
			p = getCursorPosition();
			break;
		}

		case "xnxx.com": {
			do
			{
			i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\Website_xnxx.com_picture_logo.png", 15);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xnxx.com_picture_logo.png", 350);
			sleep (5);
			
			clickOn("pictures\\SaviorWeekly\\Website_xnxx.com_Button_play.png");
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xnxx.com_picture_logo.png", 350);
			sleep (5) ;
			if (waitForObjectPresent("pictures\\SaviorWeekly\\PIP_pauseButtonxnxx.com.png", 15))
				{
					moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_xnxx.com_picture_logo.png", 380);
					TestLogger.info("Video is playing Now !");
					p = getCursorPosition();
					break;
				}
			
		        else
			   {
				s.type(Key.F5);
			   }
				
			} while (!waitForObjectPresent("pictures\\SaviorWeekly\\Website_xnxx.com_button_Pause.png", 6) && (i<3)) ;
			  p = getCursorPosition();
			  break;
		
		
		}

		case "phimsexporn.com": {
            do
            {
            i++ ;
			waitForObjectPresent("pictures\\SaviorWeekly\\phimsexporn.com_logo.png", 55);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\phimsexporn.com_logo.png", 250);
			sleep (15);
			moveMouseDownFromLogo("pictures\\SaviorWeekly\\phimsexporn.com_logo.png", 250); 
			s.click();
			if (waitForObjectPresent("pictures\\SaviorWeekly\\Website_phimsexporn.com_Button_pause.png", 15))
			{
				TestLogger.info("Video is playing Now !");
				
				p = getCursorPosition();
				break;
			}
			else
			{
				s.type(Key.F5);
			}
            } while (!waitForObjectPresent("pictures\\SaviorWeekly\\phimsexporn.com_pause.png", 5) && (i<4)); 
        	p = getCursorPosition();
            break;
			
		}

		
		case "dinotube.com": {

			waitForObjectPresent("pictures\\SaviorWeekly\\Website_dinotube.com_picture_logo.png", 45);

			moveMouseDownFromLogo("pictures\\SaviorWeekly\\Website_dinotube.com_picture_logo.png", 200);
			p = getCursorPosition();
			break;
		}
        
		default:
			TestLogger.warn("This site  " + siteName
					+ " not handle yet! Please check");
			break;

		}
	}

	

}
