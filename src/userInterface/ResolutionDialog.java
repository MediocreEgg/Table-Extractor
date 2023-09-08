package userInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
	
import businessLogic.DoNotAskAgain;
import businessLogic.ScreenResolution;
import dataClasses.DirPath;

class ResolutionDialog {

	private JFrame resoDialogFrame;
	private JButton confirmButton;
	private JCheckBox chkB_doNotShowAgain;
	private JComboBox<String> cb_resolution;
	
	private int selectedIndex = 0;
	
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
		cb_resolution.setSelectedIndex(selectedIndex);
		cb_resolution.setFont(new Font("Dialog", Font.PLAIN, 12));
		cb_resolution.setBounds(40, 20, 250, 25);
		resoDialogFrame.add(cb_resolution);
		
		cb_resolution.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				cb_resolution.addMouseWheelListener(new MouseWheelListener() {
					@Override
					public void mouseWheelMoved(MouseWheelEvent e) {
						System.out.println(cb_resolution.getSelectedIndex());
						if(e.getWheelRotation() > 0) 
						{
							selectedIndex = (selectedIndex > 3) ? 0 : cb_resolution.getSelectedIndex()+1;
							cb_resolution.setSelectedIndex(selectedIndex);
						}
						else
						{
							selectedIndex = (selectedIndex < 1) ? 4 : cb_resolution.getSelectedIndex()-1;
							cb_resolution.setSelectedIndex(selectedIndex);
						}
					}
				});
			}
		});
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
				ScreenResolution.getScreenCategory(cb_resolution.getSelectedIndex());
				
				if(chkB_doNotShowAgain.isSelected()) 
					DoNotAskAgain.updateDoNotAskAgain(true);
				
				resoDialogFrame.dispose();
				new mainFrame();
			}
		});
	}
	
}
