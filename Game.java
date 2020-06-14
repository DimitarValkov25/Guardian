import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Game extends JPanel {

	private String title;
	int w,h;
	
	FieldButton fieldButtons[] =new FieldButton[20];
	
	
	private List<FieldButton> buttons =new ArrayList<FieldButton>()
;	
	private List<FieldButton> tempButtons =new ArrayList<FieldButton>()
			;	
	
	Player player1 =new Player(fieldButtons,"Player");
	Player player2=new Player(fieldButtons,"Bot");
	
	
	public Game(String title,int w,int h) {
		this.w=w;
		this.h=h;
		this.title=title;
		init();	
	}
	
	private String fieldNames [] = {"Trap","Chance","Invest","Steal","Party Hard"};
	//private String fieldNames [] = {"T","C","I","S","P"};

	boolean bot=false;
	
	private LinkedList<FieldButton> ll =new LinkedList<FieldButton>();

	public JPanel createButtons(int w,int h,int start,int end,boolean axisX,boolean swap) {
		JPanel panel =new JPanel();
		
		if(axisX)
			panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		else
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		
		if(swap) {
		for(int i=start;i>=end;i--){
		
			fieldButtons[i] =new FieldButton();
			fieldButtons[i].setPreferredSize(new Dimension(w,h));
			fieldButtons[i].setMinimumSize(new Dimension(w,h));
			fieldButtons[i].setMaximumSize(new Dimension(w,h));
			fieldButtons[i].setBackground(Color.black);
			buttons.add(fieldButtons[i]);
			
			panel.add(fieldButtons[i]);
		}
		}else {
			for(int i=end;i<=start;i++){
				
				fieldButtons[i] =new FieldButton();
				fieldButtons[i].setPreferredSize(new Dimension(w,h));
				fieldButtons[i].setMinimumSize(new Dimension(w,h));
				fieldButtons[i].setMaximumSize(new Dimension(w,h));
				fieldButtons[i].setBackground(Color.black);
				buttons.add(fieldButtons[i]);
				
				panel.add(fieldButtons[i]);
			}
		}
			
		
		
		//buttons.remove(0);
		return panel;
	}
	
	private void addButtons() {
		buttons.clear();
		for(int i =0;i<fieldButtons.length;i++) {
			buttons.add(fieldButtons[i]);
		}
	}
	
	private Random rand =new Random();
	
	private void createField(List<FieldButton> buttons,int end,int number) {
		int n;
		System.out.println(buttons.size());
		
		for(int i=0;i<end;i++) {
			n=rand.nextInt(buttons.size());

			buttons.get(n).setText(fieldNames[number]);
			buttons.remove(n);
			
			
		}
	}
	
	public void spawn() {
		buttons.remove(7);
	
	for(int i=0;i<buttons.size();i++) {
		tempButtons.add(buttons.get(i));
	}
		for(int i=0;i<fieldNames.length;i++) {
			if(i==0)
				createField(tempButtons,7,i);
			else
				createField(tempButtons,3,i);
			
			
			
		}
		
	}
	
	
	
	public void init() {
		JFrame frame =new JFrame();
		frame.setSize(new Dimension(w,h));
		
		frame.setResizable(false);
		
		frame.setContentPane(this);
		this.setLayout(new BorderLayout());
		
		JPanel center =new JPanel();
		center.setLayout(new BorderLayout());
		this.add(center,BorderLayout.CENTER);
		
		
	this.add(createButtons(90,40,7,0,true,true),BorderLayout.SOUTH);
	center.add(createButtons(90,180,9,8,false,true),BorderLayout.WEST);	
	this.add(createButtons(90,40,17,10,true,false),BorderLayout.NORTH);
	center.add(createButtons(90,180,19,18,false,true),BorderLayout.EAST);	
	
	
	
	spawn();
	fieldButtons[0].setText("Start");
	fieldButtons[0].setUserData("Player,Bot");
	addButtons();
	
	
	JPanel subCenter=new JPanel();
	
	
	subCenter.setLayout(new BoxLayout(subCenter,BoxLayout.Y_AXIS));
	JTextField jtf =new JTextField();
	
	JButton roll =new JButton("Roll a Dice");
	//roll.setPreferredSize(new Dimension(32,32));
	//roll.setMinimumSize(new Dimension(32,32));
	//roll.setMaximumSize(new Dimension(32,32));
	subCenter.add(jtf);
	subCenter.add(roll);
	
	center.add(subCenter,BorderLayout.CENTER);
	
	
	roll.addActionListener(e ->{
		int dice=rand.nextInt(6)+1;
		if(!bot) {
			player1.movePlayer(dice);
			bot=true;
		}else {
			player2.movePlayer(dice);
			bot=false;
		}
		
	});
	
	frame.setVisible(true);
	
	
	
	
	}
	
}
