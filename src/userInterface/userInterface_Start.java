package userInterface;

import businessLogic.DoNotAskAgain;
import businessLogic.TempSerializeMap;

public class userInterface_Start {
	
	// To Myself this is broken due to error in Setting.config in which headers are missing with values.
	// To overcome is by doing check before initializing the MapSetting var.
	public userInterface_Start() {
		if((DoNotAskAgain.getDoNotAskAgain()).equals("true"))
			new mainFrame();
		else {
			new TempSerializeMap().createTempFile();
			new ResolutionDialog();
		}
	}
}
`