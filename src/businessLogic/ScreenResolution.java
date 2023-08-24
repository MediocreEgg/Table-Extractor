package businessLogic;

import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

import dataClasses.EnumHeaderTitles;

public class ScreenResolution {

	static void default_ScreenResolution() {
		System.out.println("default_ScreenResolution invoked!");
		DisplayMode screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRHEIGHT, screenSize.getHeight());
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRWIDTH, screenSize.getWidth());
	} 
	
	public static <V> void updateScreenResolution(V width, V height) {
		System.out.println("com.TableExtractor.src.businessLogic.ScreenResolution.updateScreenResolution invoked!");
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRHEIGHT, height);
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRWIDTH, width);
	}
	
	public static String[] getScreenCategory(int caseNum) {
		/*
		 *  • 1920x1080 (16:9)
		 * 	• 1600x900 (16:9)
		 * 	• 1024x768 (4:3)
		 * 	• 640x480 (4:3)
		 */
		switch(caseNum) {
		case 1:		
			return new String[] {"1920", "1080"};
		
		case 2:
			return new String[] {"1600", "900"};
			
		default:
			System.out.println("switch > default");
		case 3:
			return new String[] {"1024", "768"};
		
		case 4:
			return new String[] {"640", "480"};
		}
	}
	
	public static int getWidth() {
		return Integer.parseInt(MapSettingConfigFile.getValue(EnumHeaderTitles.SRWIDTH));
	}
	
	public static int getHeight() {
		return Integer.parseInt(MapSettingConfigFile.getValue(EnumHeaderTitles.SRHEIGHT));
	}
}
