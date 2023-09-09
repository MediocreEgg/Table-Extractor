package businessLogic;


import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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

final class SettingConfigFile {
	private static final int limit_newline = EnumHeaderTitles.length()-1;
	private static HashMap<String, String> lineHolder = new HashMap<String, String>();
	
	
	static boolean createConfigFile() throws IOException {
		System.out.println("com.TableExtractor.businessLogic.createConfigFile invoked!");
		if(Files.notExists(DirPath.getSettingConfigDir()) || Files.size(DirPath.getSettingConfigDir()) == 0) 
		{
			try 
			{
				Files.createFile(DirPath.getSettingConfigDir());
				System.out.println("Successfully Created SettingConfigFile!");
			} 
			
			catch (FileAlreadyExistsException a) 
			{
				System.err.println("File Already Exist!");
			}
			
			catch (IOException b) 
			{
				b.printStackTrace();
			}

			finally 
			{
				writeConfigHeaders();
			}
		
			return true;
		}
		

		return false;
	}

	
	private final static void writeConfigHeaders() {
		System.out.println("com.TableExtractor.businessLogic.writeConfigHeaders invoked!");
		StringBuilder temp_str = new StringBuilder();
		int iterationCounter = 0;
		
		try 
		{
			for(EnumHeaderTitles eht: EnumHeaderTitles.values()) {
				temp_str.append(eht.toString() + "= ");
				
				if(iterationCounter < limit_newline) {
					temp_str.append(System.lineSeparator());
					iterationCounter++;
				}
			}
			
			Files.writeString(DirPath.getSettingConfigDir(), temp_str.toString(), StandardOpenOption.APPEND);
		} 
		catch (IOException e) { e.printStackTrace(); }
	}
 
		
	static <V> void updateLogHeader(EnumHeaderTitles eht, String value) {
		System.out.println("com.TableExtractor.src.businessLogic.SettingConfigFile.updateLogHeader invoked!\t("+value+")");
		if(value == null || eht == null)
			return;

		
		try {
			updateLineHolder();
			lineHolder.replace(eht.toString(), value);
			Files.write(DirPath.getSettingConfigDir(), lineHolderToList());
			MapSettingConfigFile.loadMapSetting();
		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	
	static void updateScreenResolution(String width, String height) {
		if(width == null || height == null)
			return;
		
		try
		{
			updateLineHolder();
			lineHolder.replace(EnumHeaderTitles.SRWIDTH.toString(), width);
			lineHolder.replace(EnumHeaderTitles.SRHEIGHT.toString(), height);
			
			Files.write(DirPath.getSettingConfigDir(), lineHolderToList());
			MapSettingConfigFile.loadMapSetting();
		}

		catch (IOException z) {
			z.printStackTrace();
		}
	}

	
	private static void updateLineHolder() {
		String[] ArrStr = null;
		try {
			for(String str : Files.readAllLines(DirPath.getSettingConfigDir()))
			{
				ArrStr = str.split("=");
				
				if(ArrStr[0].hashCode() == 0 || ArrStr[1].hashCode() == 0)
					RepairSetting.doConfigIntegrityCheck();
				
				lineHolder.put(ArrStr[0], ArrStr[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private static List<String> lineHolderToList(){
		List<String> tempList = new ArrayList<>();
		lineHolder.forEach((k, v) -> { tempList.add(k + "=" + v); });
		return tempList;
	}
}
