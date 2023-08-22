package businessLogic;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;
/*
 * 	Setting Config File Structure:
 *	 	Setting.config
 * 			- LogHeader = value
 * 	    	  ...
 * 			- LogHeader = value
 */

sealed class SettingConfigFile permits ScreenResolution, DoNotAskAgain{

	
	static boolean createConfigFile(){
		System.out.println("com.TableExtractor.businessLogic.createConfigFile invoked!");
		if(Files.notExists(DirPath.getSettingConfigDir()) || new File(DirPath.getSettingConfigDir().toString()).length() == 0) 
			try 
			{
				Files.createFile(DirPath.getSettingConfigDir());
				writeConfigHeaders();
				System.out.println("Successfully Created SettingConfigFile!");
				return true;
			} 
			catch (FileAlreadyExistsException a) { writeConfigHeaders(); }
			catch (IOException z) {	z.printStackTrace(); }
		
		else
			System.out.println("SettingConfigFile already exists!");
		
		return false;
	}
	
	
	private final static void writeConfigHeaders() {
		System.out.println("com.TableExtractor.businessLogic.writeConfigHeaders invoked!");
		Arrays.stream(EnumHeaderTitles.values()).forEach((buildingBlocks) 
			 -> {
					try {
						Files.writeString(DirPath.getSettingConfigDir(), buildingBlocks + "=" + System.lineSeparator(), StandardOpenOption.APPEND);
					} 
					catch (IOException e) { System.out.println("Error in writeConfigHeader"); }
				});
	}
	
	
	protected static <V> void updateLogHeader (EnumHeaderTitles ht, V value) { 
		System.out.println("updateLogHeader invoked! (Value = "+value+")");
		try 
		{
			List<String> tempList = Files.readAllLines(DirPath.getSettingConfigDir());
			StringBuffer tempSB = new StringBuffer();
			
			switch(ht) {
				case SRHEIGHT:
					tempSB.append(tempList.get(1));
					tempList.set(1, tempSB.substring(0, tempSB.indexOf("=")+1)+ value);
					break;
	
				case SRWIDTH:
					tempSB.append(tempList.get(0));
					tempList.set(0, tempSB.substring(0, tempSB.indexOf("=")+1)+ value);
					break;
					
				//add more cases for log headers 
				default:
					break;
			}
			tempList.forEach((s) -> {System.out.println(s);});	
			Files.write(DirPath.getSettingConfigDir(), tempList);  
 		}
		
		catch (IndexOutOfBoundsException a) { writeConfigHeaders(); }
		catch (FileNotFoundException b) { createConfigFile(); } 
		catch (IOException z) { z.printStackTrace(); }
	}
	

	
}
