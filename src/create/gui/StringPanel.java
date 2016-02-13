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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;



public class StringPanel extends JPanel {
	
	String output ="";
	BigDecimal ans=BigDecimal.ZERO;
	boolean operanD=false;
	char state;
	BigDecimal operand=BigDecimal.ZERO;
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
	private JButton delete;
	private JButton sin; 
	private JButton cos;
	private JButton tan;
	private JButton fact;
	private JButton pi;
	
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
		
		delete=new JButton("DEL");
		currentLayout.putConstraint(SpringLayout.NORTH, delete, 0, SpringLayout.NORTH, seven);
		currentLayout.putConstraint(SpringLayout.WEST, delete, 73, SpringLayout.EAST, nine);
		delete.addActionListener(new ListentoBack());
		
		sin=new JButton ("sin");
		currentLayout.putConstraint(SpringLayout.NORTH, sin, 0, SpringLayout.NORTH, seven);
		currentLayout.putConstraint(SpringLayout.WEST, sin, 9, SpringLayout.EAST, delete);
		sin.addActionListener(new ListentoSin());
	
		cos=new JButton("cos");
		currentLayout.putConstraint(SpringLayout.NORTH, cos, 0, SpringLayout.NORTH, four);
		currentLayout.putConstraint(SpringLayout.WEST, cos, 0, SpringLayout.WEST, sin);
		cos.addActionListener(new ListentoCos());
		
		tan=new JButton("tan");
		currentLayout.putConstraint(SpringLayout.NORTH, tan, 0, SpringLayout.NORTH, one);
		currentLayout.putConstraint(SpringLayout.WEST, tan, 0, SpringLayout.WEST, sin);
		tan.addActionListener(new ListentoTan());
		
		fact=new JButton("!");
		currentLayout.putConstraint(SpringLayout.NORTH, fact, 0, SpringLayout.NORTH, seven);
		currentLayout.putConstraint(SpringLayout.WEST, fact, 0, SpringLayout.WEST, add);
		currentLayout.putConstraint(SpringLayout.EAST, fact, 55, SpringLayout.WEST, add);
		fact.addActionListener(new ListentoFact());
		
		pi=new JButton("Π");
		currentLayout.putConstraint(SpringLayout.NORTH, pi, 0, SpringLayout.NORTH, zero);
		currentLayout.putConstraint(SpringLayout.EAST, pi, 0, SpringLayout.EAST, sin);
		pi.addActionListener(new ListentoPi());
		setupPanel();
		
		screen.setText("0");
	}
	
	class ListentoZero implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			addZero();
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

	
	
	class ListentoSin implements ActionListener{
		public void actionPerformed(ActionEvent arg){
			if(!operanD)
			state='S';
			try {
				equal();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
		
	class ListentoCos implements ActionListener{
			public void actionPerformed(ActionEvent arg){
				if(!operanD)
				state='c';
				try {
					equal();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
	}
	
	class ListentoTan implements ActionListener{
				public void actionPerformed(ActionEvent arg){
					if(!operanD)
					state='t';
					try {
						equal();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
	
	class ListentoFact implements ActionListener{
					public void actionPerformed(ActionEvent arg){
						if(!operanD)
						state='f';
						
						try {
							equal();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
	}
	
	class ListentoPoint implements ActionListener{
		public void actionPerformed(ActionEvent arg) {
			if(!floating){
			floating=true;
			screen.setText(output+=".");
			}	
				}
			}
	
	public void keyPressed(KeyEvent e) {

	    int key = e.getKeyCode();

	    if (key == KeyEvent.VK_LEFT) {
	        screen.setText("YOO");
	    }

	    
	    }
	
	class ListentoBack implements ActionListener{
		public void actionPerformed(ActionEvent arg){
			
			DecimalFormat h=new DecimalFormat();
			h.setParseBigDecimal(true);

			if(floating){
				
				if(aftDec.length()==0){
					floating=false;
					output =output.substring(0,output.length()-1);

				}
					
				else if(aftDec.length()==1){
					aftDec="";
					output =output.substring(0,output.length()-1);

				}
				
				else{
					aftDec=aftDec.substring(0, aftDec.length()-1);
					output=output.substring(0,output.length()-1);
				}
				
				screen.setText(output);
					
			}
			
			else {
				
				
				if(operanD){
					
					if(operand.compareTo(BigDecimal.valueOf(9))<=0){					
					 output="";
					 operand=BigDecimal.ZERO;
					 screen.setText("0");
					}
					
					else{
						output =output.substring(0,output.length()-1);
						screen.setText(output);
						
					try {
						operand=(BigDecimal)h.parse(output);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
				}
				
			
			else{
				if(ans.compareTo(BigDecimal.valueOf(9))<=0)	{			
					output="";
					screen.setText("0");
					ans=BigDecimal.ZERO;
				}
				else{
					output =output.substring(0,output.length()-1);
					try {
						ans=(BigDecimal) h.parse(output);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				screen.setText(output);

				}
			}
			}
			
			}
		}
	
	
	
	void addZero(){
		
		
		
		if(floating)
			aftDec+="0";
				
				if(!operanD)
					ans=ans.multiply(BigDecimal.TEN);
					
					
				else
				operand=operand.multiply(BigDecimal.TEN);
			
				
				screen.setText(output+="0");
	}


	void addOne(){
		
		
		
		if(floating)
			aftDec+="1";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.ONE);
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.ONE);

		screen.setText(output+="1");

	}

	void addTwo(){
		
		
		if(floating)
			aftDec+="2";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(2));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(2));

		screen.setText(output+="2");

	}


	void addThree(){
		
		
		
		if(floating)
			aftDec+="3";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(3));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(3));

		screen.setText(output+="3");

	}

	void addFour(){

		
		
		if(floating)
			aftDec+="4";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(4));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(4));

		screen.setText(output+="4");
	}

	void addFive(){
		
		if(floating)
			aftDec+="5";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(5));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(5));

		screen.setText(output+="5");
	}

	void addSix(){
		
		if(floating)
			aftDec+="6";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(6));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(6));

		screen.setText(output+="6");
			

	}

	void addSeven(){
		
		if(floating)
			aftDec+="7";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(7));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(7));

		screen.setText(output+="7");
	}

	void addEight(){
		
		if(floating)
			aftDec+="8";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(8));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(8));

		screen.setText(output+="8");

	}


	void addNine(){
		
		if(floating)
			aftDec+="9";
		
		else if(!operanD)
			ans=(ans.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(9));
			
		else
		operand=(operand.multiply(BigDecimal.TEN)).add(BigDecimal.valueOf(9));

		screen.setText(output+="9");
	}


	
	Double recFact(Double b){
		
		if(b==0)
			return 1.0;
		
		return b*recFact(b-1);
	}
	
	class ListentoAdd implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!addB){
			try {
				allOperators();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output="";
			state='a';
			addB=true;
			}
		}
		
	}
	
	class ListentoMultiply implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!multB){
			try {
				allOperators();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output="";
			state='m';
			multB=true;
			}
		
		}
	}
	
	class ListentoSubtract implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!subB){
			try {
				allOperators();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output="";
			state='s';
			subB=true;
			}
		}
	}
	
	class ListentoDivide implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			if(!divB){
			try {
				allOperators();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output="";
			state='d';
			divB=true;
			}
		}
	}
	 
	class ListentoEquals implements ActionListener	{
		public void actionPerformed(ActionEvent arg) {
			try {
				equal();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	class ListentoPi implements ActionListener{
		public void actionPerformed(ActionEvent arg){
			if(operanD){
				operand=BigDecimal.valueOf(Math.PI);
				output=operand.toString();
			}
			
			else{
				ans=BigDecimal.valueOf(Math.PI);
				output=ans.toString();
			}
			screen.setText(output);
		}
	}
	
	class ListentoClear implements ActionListener{
		public void actionPerformed(ActionEvent arg){
			output ="";
			ans=BigDecimal.ZERO;
			operanD=false;
			state='n';
			operand=BigDecimal.ZERO;
			floating=false;
			aftDec="";
			screen.setText("0");
		}
		
	}
		
	
	public void allOperators() throws ParseException{
		if(operanD)
			equal();
		
		DecimalFormat h=new DecimalFormat();
		h.setParseBigDecimal(true);
		
		if(floating){
			
			ans=ans.add((BigDecimal)h.parse("0."+aftDec));
		}
		aftDec="";
		operanD=true;
		
		floating=false;
		operand=BigDecimal.ZERO;
	}
	
	public void resetButtons(){
		addB=false;multB=false;subB=false;divB=false;
	}
	
	public void equal() throws ParseException{
		DecimalFormat h=new DecimalFormat();
		h.setParseBigDecimal(true);
		
		if(floating && operanD)
			operand=operand.add((BigDecimal)h.parse("0."+aftDec));
			
			else if(floating)
				ans=ans.add((BigDecimal)h.parse("0."+aftDec));
			
			//System.out.println(aftDec);
			
			switch(state){
			
			case 'a':ans=ans.add(operand);
			break;
			
			case 'm':ans=ans.multiply(operand);
			break;
			
			case 's':ans=ans.subtract(operand);
			break;
			
			case 'd':ans=BigDecimal.valueOf(ans.doubleValue()/operand.doubleValue());
			break;
			
			case 'S': ans=BigDecimal.valueOf(Math.round((Math.sin(ans.doubleValue())*Math.pow(10, 12))/Math.pow(10, 12)));
			break;
			
			case 'c' : ans=BigDecimal.valueOf(Math.round(Math.cos(ans.doubleValue())*Math.pow(10, 12))/Math.pow(10, 12));
			break;
			
			case 't' : ans=BigDecimal.valueOf(Math.round(Math.tan(ans.doubleValue()))*Math.pow(10, 12)/Math.pow(10, 12));
			break;
			
			case 'f': ans=BigDecimal.valueOf(recFact(ans.doubleValue()));
			break;
			
			}
			
		/*	if(!(ans.divide(BigDecimal.ONE).equals(ans))){
			 output=Integer.toString(ans.intValue());
			}
			
			else
				*/
			
				output=ans.toString();
			
			screen.setText(output);
			
			calc=true;
			operanD=false;
			
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
			this.add(delete);
			this.add(sin);
			this.add(cos);
			this.add(tan);
			this.add(fact);
			this.add(pi);
			
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
	