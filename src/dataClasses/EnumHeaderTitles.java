package dataClasses;

//import java.util.Arrays;
//import java.util.List;

public enum EnumHeaderTitles {
	// SR == Screen Resolution
	 ISFIRSTRUN, DONOTASKAGAIN, SRWIDTH, SRHEIGHT;
	 
	private final static int numOfTitles = EnumHeaderTitles.values().length;
//	private final static List<Integer> enumHM = getTitleHash();
	
	
	public static int length() {
		return numOfTitles;
	}
	
//	public static <T> boolean isEnumHeaderTitle(T input) {
//		return enumHM.contains(input);	
//	}
//	
//	private static List<Integer> getTitleHash() {
//		List<Integer> list = Arrays.asList(new Integer[length()]);
//		for(EnumHeaderTitles eht : EnumHeaderTitles.values())
//			list.add(eht.hashCode());
//		
//		return list;
//	}
}
