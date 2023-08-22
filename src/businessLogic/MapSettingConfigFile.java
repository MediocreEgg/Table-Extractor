package businessLogic;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import dataClasses.DirPath;

public class MapSettingConfigFile {

	private static HashMap <String, String> MapSetting = new HashMap<String, String>();
	
	public static final void initMapSetting() {	
		System.out.println("com.TableExtractor.businessLogic.MapSettingConfigFile.initMapSetting");
		try 
		{
			Files.readAllLines(DirPath.getSettingConfigDir()).forEach((pairs)
				-> {
						String[] tempSB = pairs.split("=");
						MapSetting.put(tempSB[0], tempSB[1]);
				   });
		}
		
		catch(IOException z) {
			System.err.println("com.TableExtractor.src.businessLogic.SettingConfigFile.initMapSetting error");
//			z.printStackTrace();
		}
		
		MapSetting.forEach((key, value) -> { System.out.println(key + " = " + value); });
	}

	
	public static List<Object> getKeySet() {
		return Arrays.asList(MapSetting.keySet());
	}
	
	
	public static HashMap<String, String> getObject() {
		return MapSetting;
	}

	//make it optional
	public static int getScreenWidth() {
		return Integer.parseInt((String) getValue("SRWIDTH"));
	}
	
	//make it optional
	public static int getScreenHeight() {
		return Integer.parseInt((String) getValue("SRHEIGHT"));
	}
	
	
	public static <K> Object getValue(K key) {
		return MapSetting.get(key);
	}
	
	
	public static <K> boolean isKeyPresent(K key) {
		return MapSetting.containsKey(key);
	}
	
	
	public static <V> boolean isValuePresent(V value) {
		return MapSetting.containsValue(value);
	}
	
	
}
