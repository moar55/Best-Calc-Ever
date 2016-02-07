package create.gui;

import javax.swing.JFrame;

public class StringFrame extends JFrame {
	private StringPanel currentPanel;
	
	public StringFrame() {
		currentPanel=new StringPanel();	
		setupFrame();
		
	}
	
	private void setupFrame(){
		this.setContentPane(currentPanel);
	
	}
	
	public void start(){
		this.setSize(320,320);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
