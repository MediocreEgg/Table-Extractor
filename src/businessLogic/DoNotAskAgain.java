package businessLogic;

import dataClasses.EnumHeaderTitles;

public class DoNotAskAgain{
	private static final Boolean defaultBoolean = false;
	
	public static void default_DoNotAskAgain() {
		System.out.println("com.TableExtractor.src.businessLogic.DoNotAskAgain.default_DoNotAskAgain invoked!");
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, defaultBoolean.toString());
	}
	
	
	public static void updateDoNotAskAgain(Boolean bool) {
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, bool.toString());
	}
	
	
	public static String getDoNotAskAgain() {
		return MapSettingConfigFile.getValue(EnumHeaderTitles.DONOTASKAGAIN);
	}
}
