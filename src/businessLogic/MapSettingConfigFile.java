package businessLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;

// make optional return methods
/*
 *  There should be Header-Value integrity check in which checks the corresponding vales of header are correct.
 * 	It is mandatory to check the integrity of the Config File every time that the app starts.
 * 	The action to be taken (FAIL) is by either manually restore the appropriate values or delete the config file itself.
 * 	Another approach is providing a method in which if the value in a header is null/missing/erroneous update it with a default value 
 */


class MapSettingConfigFile{
	
	private static HashMap <String, String> MapSetting = new HashMap<String, String>();

	
	public static final void loadMapSetting() {	
		System.out.println("com.TableExtractor.businessLogic.MapSettingConfigFile.initMapSetting");
		try (BufferedReader br = Files.newBufferedReader(DirPath.getSettingConfigDir()))
		{
			String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                MapSetting.put(parts[0], parts[1]);
            }
			
		}
		
		catch(ArrayIndexOutOfBoundsException a) {
			JOptionPane.showMessageDialog(null, "There is/are missing attributes. Check Setting.config");
			a.printStackTrace();
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
