package businessLogic;

import java.io.IOException;


public class BusinessLogic_Start{
	
	public BusinessLogic_Start(){
		try {
			if(SettingConfigFile.createConfigFile()) 
			{
				ScreenResolution.default_ScreenResolution();
				DoNotAskAgain.default_DoNotAskAgain();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		RepairSetting.doConfigIntegrityCheck();
	}
	
}
