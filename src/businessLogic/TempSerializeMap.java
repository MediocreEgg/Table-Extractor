package businessLogic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import dataClasses.DirPath;

public class TempSerializeMap {
	
	
	public void createTempFile() {
		try 
		{
			File tempHash = File.createTempFile("SettingHash", ".tmp");
			tempHash.deleteOnExit();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
