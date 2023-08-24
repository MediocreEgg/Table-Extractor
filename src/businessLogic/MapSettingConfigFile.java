package businessLogic;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;

// make optional return methods

sealed class MapSettingConfigFile permits DoNotAskAgain{

	
	private static HashMap <String, String> MapSetting = new HashMap<String, String>();
	
	
	static final void initMapSetting() {	
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
			z.printStackTrace();
		}
	}

	
	static List<Object> getKeySet() {
		return Arrays.asList(MapSetting.keySet());
	}
	
	
	static <K> String getValue(EnumHeaderTitles key) {
		return MapSetting.get(key.toString());
	}
	
	
	static <K> boolean isKeyPresent(K key) {
		return MapSetting.containsKey(key);
	}
	
	
	static <V> boolean isValuePresent(V value) {
		return MapSetting.containsValue(value);
	}
	
}
