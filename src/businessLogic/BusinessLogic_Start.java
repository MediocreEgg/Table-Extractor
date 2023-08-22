package businessLogic;

public class BusinessLogic_Start{
	
	public BusinessLogic_Start(){
		if(SettingConfigFile.createConfigFile()) 
		{
			ScreenResolution.updateScreenResolution(300, 400);
			DoNotAskAgain.default_DoNotAskAgain();
		}
//		MapSettingConfigFile.initMapSetting();
	}
	
}
