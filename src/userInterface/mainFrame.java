package userInterface;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import businessLogic.MapSettingConfigFile;

public class mainFrame {
	private JFrame mainFrame;
	
	/*
	 *	invokes the following methods: 
	 *		• initFrame - initialize the properties of mainFrame.
	 * 
	 */
	public mainFrame(){
		
//		initFrame();
		
	}
	
	void initFrame(){
		mainFrame = new JFrame();
		mainFrame.setTitle("Table Extractor");
//		mainFrame.setIconImage();
//		mainFrame.setSize(MapSettingConfigFile.getScreenWidth(), MapSettingConfigFile.getScreenHeight());
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.pack();
	}
}
