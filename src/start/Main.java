package start;

import businessLogic.BusinessLogic_Start;
import dataClasses.EnumHeaderTitles;
import userInterface.userInterface_Start;

/*	
 * 	Decide which Screen Resolutions are supported by this program:
 * 	• 1920x1080 (16:9)
 * 	• 1600x900 (16:9)
 * 	• 1024x768 (4:3)
 * 	• 640x480 (4:3)
 */

// (idea) Use multhi-threading to check files and initialize the GUIs
// make a simple batch file that runs the application (use case: the application requires restart, startup capability)
// (Decision) Should I use Serialization and Deserialization for SettingConfig? (For now I'll use conventional method [Files])
/*	Pros:
 * 	-
 * 	-
 * 	
 *  Cons: 
 * 	-
 * 	-
 */

class Main {
	public static void main(String[] args) {
		long a = System.nanoTime();
		new BusinessLogic_Start();	// Initializes the back-end
//		new userInterface_Start();
		long b = System.nanoTime()-a;
		System.out.println(b/1000000 +  " ms");
		
	}	
}
