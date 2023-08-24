package start;

/*	
 * 	Decide which Screen Resolutions are supported by this program:
 * 	• 1920x1080 (16:9)
 * 	• 1600x900 (16:9)
 * 	• 1024x768 (4:3)
 * 	• 640x480 (4:3)
 */

// (idea) Use multhi-threading to check files and initialize the GUIs
// make a simple batch file that runs the application (use case: the application requires restart, startup capability)
class Main {
	public static void main(String[] args) {
		new businessLogic.BusinessLogic_Start();	// Initializes the back-end
		new userInterface.ResolutionDialog();		// Initializes the front-end
  	}	
}
