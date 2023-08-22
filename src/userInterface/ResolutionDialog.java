package userInterface;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataClasses.DirPath;

public final class ResolutionDialog{

	private JFrame resoDialogFrame;
	private JPanel panel1;
	private JButton confirmButton;
	
	
	public ResolutionDialog() {
		initFrame();
		initResoCB();
		initDoNotShowAgainCheckBox();
		initConfirmButton();
		resoDialogFrame.setVisible(true);
	}

	private final void initFrame(){
		resoDialogFrame = new JFrame("Select Application Resolution");
		resoDialogFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resoDialogFrame.setSize(350, 180);
		resoDialogFrame.setLayout(null);
		resoDialogFrame.setIconImage(new ImageIcon(DirPath.getTableExtractorIconDir()).getImage());
		resoDialogFrame.setResizable(false);
		resoDialogFrame.setLocationRelativeTo(null);
	}
	
	
	private final void initResoCB() {
		JComboBox<String> cb_resolution = new JComboBox<String>();
		cb_resolution.setModel(new DefaultComboBoxModel<>(new String[]{"         - Select Application Resolution - ","1920x1080", "1600x900", "1024x768", "640x480"}));
		cb_resolution.setSelectedIndex(0);
		cb_resolution.setBounds(40, 20, 250, 30);
		resoDialogFrame.add(cb_resolution);
	}
	
	
	private final void initDoNotShowAgainCheckBox() {
		JCheckBox chkB_doNotShowAgain = new JCheckBox("Remember this and do not ask again", false);
		chkB_doNotShowAgain.setBounds(36, 60, 250, 30);
		chkB_doNotShowAgain.setFocusable(false);
		chkB_doNotShowAgain.setFont(new Font("Dialog", Font.PLAIN, 12));
		resoDialogFrame.add(chkB_doNotShowAgain);
	}
	
	
	private final void initConfirmButton() {
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(190,100, 100, 25);
		confirmButton.setFocusable(false);
		resoDialogFrame.add(confirmButton);
	}
	
	
}
