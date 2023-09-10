package businessLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;

class RepairSetting {
	
	/*	
	 * 	Cases to be wary about:
	 *	• Missing Header
	 *	• Missing Value
	 *	• Erroneous Value
	 *	• Unrecognized Line
	 */	
	
	private static HashMap <String,String> hm = new HashMap<String, String>();
	
	//default Repair Method
	//Check FIRST if there are no missing Headers
	//If there are value stand-alone delete that pair
	static void doConfigIntegrityCheck() {
		System.out.println("com.TableExtractor.src.businessLogic.RepairSetting.doConfigIntegrityCheck invoked!");
		try(BufferedReader br = new BufferedReader(new FileReader(DirPath.getSettingConfigDir().toString()))){
			String[] b = null; 
			Iterator<String> a = br.lines().iterator();
			
			while(a.hasNext()) {
				b = a.next().split("=");
				
				if(b[0] != "")
					hm.put(b[0], b[1]);
				
				System.out.println(b[0].hashCode() + " " + b[1].hashCode());
			}
			
			for(EnumHeaderTitles eht : EnumHeaderTitles.values())
				if(hm.containsKey(eht.toString()) == false)
					doHeaderFix(eht, hm);
			
			
			
			
			Files.write(DirPath.getSettingConfigDir(), toList());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private static void doHeaderFix(EnumHeaderTitles missingHeader, HashMap<String, String> tmpHM) {
		tmpHM.put(missingHeader.toString(), " ");
	}
	
	
	private static List<String> toList(){
		List<String> tempList = new ArrayList<>();
		hm.forEach((k, v) -> { tempList.add(k + "=" + v); });
		return tempList;
	}
	
}
