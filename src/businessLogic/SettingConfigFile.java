package businessLogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;
import dataClasses.EnumHeaderValuePair;
/*
 * 	Setting Config File Structure:
 *	 	Setting.config
 * 			- LogHeader = value
 * 	    	  ...
 * 			- LogHeader = value
 */

final class SettingConfigFile {
	private static final int limit_newline = EnumHeaderTitles.length()-1;
	private static HashMap<String, StringBuilder> lineHolder = new HashMap<String, StringBuilder>();
	
	
	static boolean createConfigFile() throws IOException {
		System.out.println("com.TableExtractor.businessLogic.createConfigFile invoked!");
		if(Files.notExists(DirPath.getSettingConfigDir()) || Files.size(DirPath.getSettingConfigDir()) == 0) 
		{
			try 
			{
				Files.createFile(DirPath.getSettingConfigDir());
				writeConfigHeaders();
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
		
			return true;
		}
		
		else
			System.out.println("SettingConfigFile already exists!");

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

		try
		{
			Map<String, String> tempMap = new HashMap<String, String>();
			String[] ArrStr = null;
			
			for(String str : Files.readAllLines(DirPath.getSettingConfigDir()))
			{
				ArrStr = str.split("=");
				
//				if(ArrStr.length != 2)
//				{
//					RepairSetting.doConfigIntegrityCheck();
//					updateLogHeader(eht, value);
//					return;
//				}
				
				tempMap.put(ArrStr[0], ArrStr[1]);
			}
			
			tempMap.replace(eht.toString(), value);
			List<String> tempList = new ArrayList<String>();
			tempMap.forEach((k, v) -> tempList.add(k + "=" + v));
			
			Files.write(DirPath.getSettingConfigDir(), tempList);
			MapSettingConfigFile.loadMapSetting();
		}

		catch (IOException z) {
			z.printStackTrace();
		}
	}

	
	static <V> void updateScreenResolution(V width, V height) {
		if(width == null || height == null)
			return;
		
		try
		{
			Map<String, StringBuilder> tempMap = new HashMap<String, StringBuilder>();
	
			for(String HeaderValue: Files.readAllLines(DirPath.getSettingConfigDir()).toArray(new String[0])) {
				String[] ArrStr = HeaderValue.split("=");
				tempMap.put(ArrStr[0], new StringBuilder().append(ArrStr[1]));
			}
			
			tempMap.replace(EnumHeaderTitles.SRWIDTH.toString(), new StringBuilder().append(width));
			tempMap.replace(EnumHeaderTitles.SRHEIGHT.toString(), new StringBuilder().append(height));
			

			List<String> tempList = new ArrayList<String>();
			tempMap.forEach((k, v) -> tempList.add(k + "=" + v));
			
			Files.write(DirPath.getSettingConfigDir(), tempList);
			MapSettingConfigFile.loadMapSetting();
		}

		catch (IOException z) {
			z.printStackTrace();
		}
	}

}
