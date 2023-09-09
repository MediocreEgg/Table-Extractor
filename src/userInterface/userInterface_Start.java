package userInterface;

import businessLogic.DoNotAskAgain;
import businessLogic.TempSerializeMap;

public class userInterface_Start {
	
	public userInterface_Start() {
		if((DoNotAskAgain.getDoNotAskAgain()).equals("true"))
			new mainFrame();
		else {
			new ResolutionDialog();
		}
	}
}
