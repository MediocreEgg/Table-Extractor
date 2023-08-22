package businessLogic;

import dataClasses.EnumHeaderTitles;

public non-sealed class DoNotAskAgain extends SettingConfigFile {
	
	static void default_DoNotAskAgain() {
		System.out.println("com.TableExtractor.src.businessLogic.DoNotAskAgain.default_DoNotAskAgain invoked!");
		updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, true);
	}
	
	public static void updateDoNotAskAgain(boolean toggle) {
		updateLogHeader(EnumHeaderTitles.DONOTASKAGAIN, toggle);
	}
}
