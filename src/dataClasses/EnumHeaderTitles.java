package dataClasses;

public enum EnumHeaderTitles {
	// SR == Screen Resolution
	 ISFIRSTRUN, DONOTASKAGAIN, SRWIDTH, SRHEIGHT;
	 
	private final static int numOfTitles = EnumHeaderTitles.values().length;

	public static int length() {
		return numOfTitles;
	}
	
	
}
