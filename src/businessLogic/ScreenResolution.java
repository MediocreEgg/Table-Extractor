package businessLogic;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import dataClasses.EnumHeaderTitles;

public non-sealed class ScreenResolution extends SettingConfigFile{

	static void default_ScreenResolution() {
		System.out.println("default_ScreenResolution invoked!");
		DisplayMode screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRHEIGHT, screenSize.getHeight());
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRWIDTH, screenSize.getWidth());
	} 
	
	public static <V> void updateScreenResolution(V width, V height) {
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRHEIGHT, height);
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.SRWIDTH, width);
	}
}
