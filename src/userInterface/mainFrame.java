package userInterface;

import javax.swing.JFrame;
import businessLogic.ScreenResolution;
import dataClasses.DirPath;

class mainFrame {
	private JFrame mainFrame;
	
	/*
	 *	invokes the following methods: 
	 *		• initFrame - initialize the properties of mainFrame.
	 * 
	 */
	public mainFrame(){
		initFrame();
	}
	
	void initFrame(){
		mainFrame = new JFrame();
		mainFrame.setTitle("Table Extractor");
		mainFrame.setIconImage(DirPath.getTableExtractorIconDir());
		mainFrame.setResizable(false);
		mainFrame.setSize(ScreenResolution.getWidth(), ScreenResolution.getHeight());
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}
