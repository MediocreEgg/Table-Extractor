package userInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import businessLogic.DoNotAskAgain;
import businessLogic.ScreenResolution;
import dataClasses.DirPath;
import dataClasses.EnumHeaderTitles;

public class ResolutionDialog {

	private JFrame resoDialogFrame;
	private JButton confirmButton;
	private JCheckBox chkB_doNotShowAgain;
	private JComboBox<String> cb_resolution;
	
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
		resoDialogFrame.setIconImage(DirPath.getTableExtractorIconDir());
		resoDialogFrame.setResizable(false);
		resoDialogFrame.setLocationRelativeTo(null);
	}
	
	
	private final void initResoCB() {
		cb_resolution = new JComboBox<String>();
		cb_resolution.setModel(new DefaultComboBoxModel<>(new String[]{"         - Select Application Resolution - ","1920x1080", "1600x900", "1024x768", "640x480"}));
		cb_resolution.setSelectedIndex(0);
		cb_resolution.setFont(new Font("Dialog", Font.PLAIN, 12));
		cb_resolution.setBounds(40, 20, 250, 25);
		resoDialogFrame.add(cb_resolution);
	}
	
	
	private final void initDoNotShowAgainCheckBox() {
		chkB_doNotShowAgain = new JCheckBox("Remember this and do not ask again", false);
		chkB_doNotShowAgain.setBounds(36, 50, 250, 30);
		chkB_doNotShowAgain.setFocusable(false);
		chkB_doNotShowAgain.setFont(new Font("Dialog", Font.PLAIN, 12));
		resoDialogFrame.add(chkB_doNotShowAgain);
	}
	
	
	private final void initConfirmButton() {
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(190, 95, 100, 25);
		confirmButton.setFocusable(false);
		resoDialogFrame.add(confirmButton);

		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] sr = ScreenResolution.getScreenCategory(cb_resolution.getSelectedIndex());
				ScreenResolution.updateScreenResolution(sr[0], sr[1]);
				
				if(chkB_doNotShowAgain.isSelected()) 
					if(!"ON".equals(DoNotAskAgain.getDonotAskAgain()))
						DoNotAskAgain.updateDoNotAskAgain("ON");
				else 
					if(!"OFF".equals(DoNotAskAgain.getDonotAskAgain()))
						DoNotAskAgain.updateDoNotAskAgain("OFF");
				
				resoDialogFrame.dispose();
				new mainFrame();
			}
		});
		
	}
}
