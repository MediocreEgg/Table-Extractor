package businessLogic;

import java.awt.Dimension;
import java.awt.Toolkit;

import dataClasses.EnumHeaderTitles;

public non-sealed class ScreenResolution extends SettingConfigFile{

	public void default_ScreenResolution() {
		System.out.println("default_ScreenResolution invoked! ");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		updateLogHeader(EnumHeaderTitles.SRHEIGHT, screenSize.height);
		updateLogHeader(EnumHeaderTitles.SRWIDTH, screenSize.width);
	} 
	
}
