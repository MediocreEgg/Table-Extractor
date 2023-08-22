package start;

import businessLogic.BusinessLogic_Start;
import businessLogic.MapSettingConfigFile;

/*	
 * 	Decide which Screen Resolutions are supported by this program:
 * 	• 1920x1080 (16:9)
 * 	• 1600x900 (16:9)
 * 	• 1024x768 (4:3)
 * 	• 640x480 (4:3)
 * 
 * 
 * 
 * 
 * 
 * 
 */

// (idea) Use multhi-threading to check files and initialize the GUIs
public class Main {
	static BusinessLogic_Start bl = new BusinessLogic_Start();
	
	public static void main(String[] args) {
		new userInterface.ResolutionDialog();
	}	
}
