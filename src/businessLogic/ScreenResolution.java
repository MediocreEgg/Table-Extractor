package businessLogic;

import dataClasses.EnumHeaderTitles;

public class ScreenResolution{

	static void default_ScreenResolution() {
		System.out.println("default_ScreenResolution invoked!");
		SettingConfigFile.updateScreenResolution("1024", "768");
	} 
	

	public static void getScreenCategory(int caseNum) {
		/*
		 *  • 1920x1080 (16:9)
		 * 	• 1600x900 (16:9)
		 * 	• 1024x768 (4:3)
		 * 	• 640x480 (4:3)
		 */
		switch(caseNum) {
		case 1:		
			SettingConfigFile.updateScreenResolution("1920", "1080");
			break;
			
		case 2:
			SettingConfigFile.updateScreenResolution("1600", "900");
			break;
			
		default:
			System.out.println("switch > default");
		case 3:
			SettingConfigFile.updateScreenResolution("1024", "768");
			break;
		
		case 4:
			SettingConfigFile.updateScreenResolution("640", "480");
			break;
		}
	}
	
	
	public static int getWidth() {
		return Integer.parseInt(MapSettingConfigFile.getValue(EnumHeaderTitles.SRWIDTH));
	}
	
	
	public static int getHeight() {
		return Integer.parseInt(MapSettingConfigFile.getValue(EnumHeaderTitles.SRHEIGHT));
	}
}
