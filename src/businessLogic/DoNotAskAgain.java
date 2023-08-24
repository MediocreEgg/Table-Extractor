package businessLogic;

import dataClasses.EnumHeaderTitles;

public non-sealed class DoNotAskAgain extends MapSettingConfigFile {
	
	public static void default_DoNotAskAgain() {
		System.out.println("com.TableExtractor.src.businessLogic.DoNotAskAgain.default_DoNotAskAgain invoked!");
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, "OFF");
	}
	
	public static void updateDoNotAskAgain(String toggle) {
		SettingConfigFile.updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, toggle);
	}
	
	public static String getDonotAskAgain() {
		return getValue(EnumHeaderTitles.DONOTASKAGAIN);
	}
}
