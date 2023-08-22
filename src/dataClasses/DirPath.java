package dataClasses;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DirPath {
	private final static String workingDir = System.getProperty("user.dir");
	private static Path targetpath_SettingConfigFile = null;
	
	public static void setTargetPath_SettingConfig(String dir) {
		targetpath_SettingConfigFile = Paths.get(dir);
	}
	
	public final static void ResetToDefault_SettingConfig() {
		targetpath_SettingConfigFile = null;
	}
	
	public final static String getWorkingDir() {
		return workingDir;
	}
	
	public final static String getSettingDir() {
		return workingDir + "\\Setting";
	}
	
	public final static String getResourceDir() {
		return workingDir + "\\Resources";
	}
	
	private final static Path getTargetPath_SettingConfig() {
		return targetpath_SettingConfigFile;
	}
	
	public static final Path getSettingConfigDir() {
		return (getTargetPath_SettingConfig() == null) ? Paths.get(DirPath.getSettingDir() + "\\Setting.config") : getTargetPath_SettingConfig();
	}
	
	public final static String getTableExtractorIconDir() {
		return DirPath.getResourceDir() + "\\TableExtractor_Icon.png";
	}
}
