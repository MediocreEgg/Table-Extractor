package businessLogic;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import dataClasses.DirPath;

public class MapSettingConfigFile {

	private HashMap <String, String> MapSetting = new HashMap<String, String>();
	
	public final void initMapSetting() {	
		System.out.println("com.TableExtractor.businessLogic.MapSettingConfigFile.initMapSetting");
		try 
		{
			Files.readAllLines(DirPath.getSettingConfigDir()).forEach((pairs)
				-> {
						String[] tempSB = pairs.split("=");
						MapSetting.put(tempSB[0], tempSB[1]);
				   });
		}
		
		catch(Exception z) {
			System.err.println("com.TableExtractor.src.businessLogic.SettingConfigFile.setMapSetting error");
		}
		
//		MapSetting.forEach((key, value) -> { System.out.println(key + " = " + value); });
	}

	
	public List<Object> getKeySet() {
		return Arrays.asList(MapSetting.keySet());
	}
	
	
	public <K> Object getValue(K key) {
		return MapSetting.get(key);
	}
	
	
	public <K> boolean isKeyPresent(K key) {
		return MapSetting.containsKey(key);
	}
	
	
	public <V> boolean isValuePresent(V value) {
		return MapSetting.containsKey(value);
	}
	
}
