package create.gui;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StringFrame extends JFrame {
	private StringPanel currentPanel;
	
	public StringFrame() {
		currentPanel=new StringPanel();	
		setupFrame();
		
	}
	
	private void setupFrame(){
		this.setContentPane(currentPanel);
		this.setTitle("Calculator");
		ImageIcon img = new ImageIcon("images\\calculator.png");
		this.setIconImage(img.getImage());
	}
	
	public void start(){
		this.setSize(370,370);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
