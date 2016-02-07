package create.gui;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;



public class StringPanel extends JPanel {
	String output ="";
	double ans=0;
	boolean operanD=false;
	char state='n';
	double operand=0;
	boolean floating=false;
	String aftDec="";
	boolean calc=false;
	
	boolean multB=false;
	boolean addB=false;
	boolean divB=false;
	boolean subB=false;
	boolean pointB=false;
	
	
	
	private JTextField screen;
	private SpringLayout currentLayout;
	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton point;
	private JButton add;
	private JButton equals;
	private JButton clear;
	private JButton multiply;
	private JButton subtract;
	private JButton divide;
	
	public StringPanel() {
		setBackground(Color.CYAN);
		screen = new JTextField();
		currentLayout= new SpringLayout();

		
		zero=new JButton("0");
		zero.addActionListener(new ListentoZero());		
		one=new JButton("1");
		
		one.addActionListener(new ListentoOne());
		
		two=new JButton("2");
		two.addActionListener(new ListentoTwo());
		
		three=new JButton("3");
		three.addActionListener(new ListentoThree());
		
		four=new JButton("4");
		four.addActionListener(new ListentoFour());
		
		five=new JButton("5");
		five.addActionListener(new ListentoFive());
		
		six=new JButton("6");
		six.addActionListener(new ListentoSix());
		
		seven=new JButton("7");
		seven.addActionListener(new ListentoSeven());
		
		eight=new JButton("8");
		eight.addActionListener(new ListentoEight());
		
		nine=new JButton("9");
		nine.addActionListener(new ListentoNine());
		
		add=new JButton("+");
		currentLayout.putConstraint(SpringLayout.NORTH, add, 0, SpringLayout.NORTH, zero);
		currentLayout.putConstraint(SpringLayout.SOUTH, add, 23, SpringLayout.NORTH, zero);
		add.addActionListener(new ListentoAdd());
		
		equals=new JButton("=");
		currentLayout.putConstraint(SpringLayout.EAST, add, -6, SpringLayout.WEST, equals);
		currentLayout.putConstraint(SpringLayout.NORTH, equals, 0, SpringLayout.NORTH, one);
		currentLayout.putConstraint(SpringLayout.WEST, equals, 215, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, equals, 3, SpringLayout.SOUTH, zero);
		equals.addActionListener(new ListentoEquals());
		
		point =new JButton(".");
		currentLayout.putConstraint(SpringLayout.NORTH, point, 0, SpringLayout.NORTH, zero);
		currentLayout.putConstraint(SpringLayout.WEST, point, 6, SpringLayout.EAST, zero);
		point.addActionListener(new ListentoPoint());
		
		clear =new JButton("C");
		currentLayout.putConstraint(SpringLayout.NORTH, clear, 0, SpringLayout.NORTH, four);
		currentLayout.putConstraint(SpringLayout.WEST, clear, 0, SpringLayout.WEST, equals);
		clear.addActionListener(new ListentoClear());
		
		multiply=new JButton("X");
		currentLayout.putConstraint(SpringLayout.WEST, multiply, 13, SpringLayout.EAST, three);
		currentLayout.putConstraint(SpringLayout.SOUTH, multiply, -6, SpringLayout.NORTH, add);
		currentLayout.putConstraint(SpringLayout.EAST, multiply, -6, SpringLayout.WEST, equals);
		multiply.addActionListener(new ListentoMultiply());
		
		subtract=new JButton("-");
		subtract.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		currentLayout.putConstraint(SpringLayout.WEST, add, 15, SpringLayout.EAST, subtract);
		currentLayout.putConstraint(SpringLayout.NORTH, subtract, 0, SpringLayout.NORTH, zero);
		currentLayout.putConstraint(SpringLayout.WEST, subtract, 0, SpringLayout.WEST, three);
		subtract.addActionListener(new ListentoSubtract());
		
		divide=new JButton("/");
		currentLayout.putConstraint(SpringLayout.NORTH, multiply, 6, SpringLayout.SOUTH, divide);
		currentLayout.putConstraint(SpringLayout.EAST, divide, 0, SpringLayout.EAST, add);
		currentLayout.putConstraint(SpringLayout.WEST, divide, 13, SpringLayout.EAST, six);
		currentLayout.putConstraint(SpringLayout.NORTH, divide, 0, SpringLayout.NORTH, four);
		divide.addActionListener(new ListentoDivide());
		
		setupPanel();
		
		screen.setText("0");
	}
	
	class ListentoZero implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addZero();
			System.out.println("pressed");
			resetButtons();
			
		}
	}
		
	class ListentoOne implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			
			addOne();
			resetButtons();
				
			}
	}
	class ListentoTwo implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			
			addTwo();
			resetButtons();
			
				}
			}
	
	class ListentoThree implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addThree();
			
				
			resetButtons();
				}
			}
	
	class ListentoFour implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addFour();
				
			resetButtons();
				}
			}
	
	class ListentoFive implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addFive();
			
				
			resetButtons();
				}
			}
	
	class ListentoSix implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			
			addSix();
			resetButtons();
				}
			}
	class ListentoSeven implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addSeven();
		
			
			resetButtons();	
				}
			}
	
	class ListentoEight implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			
			addEight();
		
			
			resetButtons();
				
				}
			}
	
	class ListentoNine implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			
			addNine();
			
				
			resetButtons();
				}
			}

	
	
	class ListentoPoint implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			floating=true;
			screen.setText(output+=".");
				
				}
			}
	
	
	void addZero(){
		if(floating)
			aftDec+="0";
				
				if(!operanD)
					ans=(ans*10);
					
					
				else
				operand=(operand*10);
			
				
				screen.setText(output+="0");
	}


	void addOne(){
		if(floating)
			aftDec+="1";
		
		else if(!operanD)
			ans=(ans*10)+1;
			
		else
		operand=(operand*10)+1;

		screen.setText(output+="1");

	}

	void addTwo(){
		if(floating)
			aftDec+="2";
		
		else if(!operanD)
			ans=(ans*10)+2;
			
		else
		operand=(operand*10)+2;

		screen.setText(output+="2");

	}


	void addThree(){
		if(floating)
			aftDec+="3";
		
		else if(!operanD)
			ans=(ans*10)+3;
			
		else
		operand=(operand*10)+3;

		screen.setText(output+="3");

	}

	void addFour(){


		if(floating)
			aftDec+="4";
		
		else if(!operanD)
			ans=(ans*10)+4;
			
		else
		operand=(operand*10)+4;

		screen.setText(output+="4");
	}

	void addFive(){
		if(floating)
			aftDec+="5";
		
		else if(!operanD)
			ans=(ans*10)+5;
			
		else
		operand=(operand*10)+5;

		screen.setText(output+="5");
	}

	void addSix(){
		if(floating)
			aftDec+="6";
		
		else if(!operanD)
			ans=(ans*10)+6;
			
		else
		operand=(operand*10)+6;

		screen.setText(output+="6");
			

	}

	void addSeven(){
		if(floating)
			aftDec+="7";
		
		else if(!operanD)
			ans=(ans*10)+7;
			
		else
		operand=(operand*10)+7;

		screen.setText(output+="7");
	}

	void addEight(){
		if(floating)
			aftDec+="8";
		
		else if(!operanD)
			ans=(ans*10)+8;
			
		else
		operand=(operand*10)+8;

		screen.setText(output+="8");

	}


	void addNine(){
		if(floating)
			aftDec+="9";
		
		else if(!operanD)
			ans=(ans*10)+9;
			
		else
		operand=(operand*10)+9;

		screen.setText(output+="9");
	}


	
	
	class ListentoAdd implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!addB){
			allOperators();
			output="";
			state='a';
			addB=true;
			}
		}
		
	}
	
	class ListentoMultiply implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!multB){
			allOperators();
			output="";
			state='m';
			multB=true;
			}
		
		}
	}
	
	class ListentoSubtract implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!subB){
			allOperators();
			output="";
			state='s';
			subB=true;
			}
		}
	}
	
	class ListentoDivide implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!divB){
			allOperators();
			output="";
			state='d';
			divB=true;
			}
		}
	}
	 
	class ListentoEquals implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			equal();
		}
		
		
	}
	
	class ListentoClear implements ActionListener{
		public void actionPerformed(ActionEvent arg){
			output ="";
			ans=0;
			operanD=false;
			state='n';
			operand=0;
			floating=false;
			aftDec="";
			screen.setText("0");
		}
		
	}
		
	
	public void allOperators(){
		if(operanD)
			equal();
		
		if(!aftDec.equals(""))
			ans+=Double.parseDouble("0."+aftDec);
		
		aftDec="";
		operanD=true;
		
		floating=false;
		operand=0;
	}
	
	public void resetButtons(){
		addB=false;multB=false;subB=false;divB=false;
	}
	
	public void equal(){
		if(!aftDec.equals("") && operanD)
			operand+=Double.parseDouble("0."+aftDec);
			
			else if(!aftDec.equals(""))
				ans+=Double.parseDouble("0."+aftDec);
			
			//System.out.println(aftDec);
			
			switch(state){
			case 'a':ans+=operand;
			screen.setText(Double.toString(ans));
			break;
			
			case 'm':ans*=operand;screen.setText(Double.toString(ans));
			break;
			
			case 's':ans-=operand;screen.setText(Double.toString(ans));
			break;
			
			case 'd':ans/=operand;screen.setText(Double.toString(ans));
			break;
			
			case 'n' : screen.setText(Double.toString(ans));
			break;
			}
			calc=true;
			state='n';
	}
	private void setupPanel(){
			this.add(screen);
			this.setLayout(currentLayout);
			this.add(zero);
			this.add(one);
			this.add(two);
			this.add(three);
			this.add(four);
			this.add(five);
			this.add(six);
			this.add(seven);
			this.add(eight);
			this.add(nine);
			this.add(add);
			this.add(equals);
			this.add(point);
			this.add(clear);
			this.add(multiply);
			this.add(subtract);
			this.add(divide);
			
		currentLayout.putConstraint(SpringLayout.EAST, nine, 0, SpringLayout.EAST, three);
		currentLayout.putConstraint(SpringLayout.WEST, six, 0, SpringLayout.WEST, three);
		currentLayout.putConstraint(SpringLayout.SOUTH, six, -6, SpringLayout.NORTH, three);
		currentLayout.putConstraint(SpringLayout.NORTH, three, 0, SpringLayout.NORTH, one);
		currentLayout.putConstraint(SpringLayout.WEST, three, 6, SpringLayout.EAST, two);		

		currentLayout.putConstraint(SpringLayout.WEST, zero, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, zero, -10, SpringLayout.SOUTH, this);
		
		currentLayout.putConstraint(SpringLayout.NORTH, two, 0, SpringLayout.NORTH, one);
		currentLayout.putConstraint(SpringLayout.WEST, two, 6, SpringLayout.EAST, one);
		
		currentLayout.putConstraint(SpringLayout.SOUTH, four, -6, SpringLayout.NORTH, one);
		
		currentLayout.putConstraint(SpringLayout.NORTH, five, 0, SpringLayout.NORTH, four);
		currentLayout.putConstraint(SpringLayout.WEST, five, 0, SpringLayout.WEST, two);
		
		currentLayout.putConstraint(SpringLayout.SOUTH, seven, -6, SpringLayout.NORTH, four);
		
		currentLayout.putConstraint(SpringLayout.WEST, eight, 0, SpringLayout.WEST, two);
		currentLayout.putConstraint(SpringLayout.SOUTH, eight, -6, SpringLayout.NORTH, five);
		
		currentLayout.putConstraint(SpringLayout.SOUTH, nine, -6, SpringLayout.NORTH, six);
		
		currentLayout.putConstraint(SpringLayout.NORTH, screen, 34, SpringLayout.NORTH, this);
		currentLayout.putConstraint(SpringLayout.WEST, screen, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.EAST, screen, -10, SpringLayout.EAST, this);
		
		currentLayout.putConstraint(SpringLayout.WEST, one, 10, SpringLayout.WEST, this);
		currentLayout.putConstraint(SpringLayout.SOUTH, one, -39, SpringLayout.SOUTH, this);
		
		currentLayout.putConstraint(SpringLayout.EAST, four, -6, SpringLayout.WEST, five);
		currentLayout.putConstraint(SpringLayout.EAST, seven, -6, SpringLayout.WEST, eight);
	}
}
	