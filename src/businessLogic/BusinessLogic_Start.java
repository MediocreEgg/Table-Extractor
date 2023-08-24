package businessLogic;

public class BusinessLogic_Start{
	
	public BusinessLogic_Start(){
		if(SettingConfigFile.createConfigFile()) 
		{
			String[] tempSR = ScreenResolution.getScreenCategory(4);
			ScreenResolution.updateScreenResolution(tempSR[0], tempSR[1]);
			DoNotAskAgain.default_DoNotAskAgain();
		}
		MapSettingConfigFile.initMapSetting();
	}
	
}
