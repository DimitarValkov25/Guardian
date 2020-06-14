import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

	
	String title;
	private FieldButton buttons[];
	float money=1000;
	
	boolean traps[] = {false,false,false,false,false};
	
	int steal=0;
	
	Random r =new Random();
	public Player(FieldButton buttons[],String title) {
		this.buttons=buttons;
		this.title=title;
		steal =r.nextInt(3)+1;
	}
	
	
	public void movePlayer(int range) {
		int player =whereIsPlayer(title);
		
		if(!buttons[player].getUserData().contains(",")) {
			buttons[player].setUserData("");
		}else {
			buttons[player].setUserData(buttons[player].getUserData().replace(title, "").replace(",", ""));
		}
		
		
		buttons[player].setBackground(Color.black);
		
		System.out.println(player+" "+(player+range));
		
		if(player+range>=buttons.length) {
			player=0;
		}
		if(title.equals("Bot")){
			buttons[player+range].setBackground(Color.RED);
			}else {
				buttons[player+range].setBackground(Color.blue);
			}
		buttons[player+range].setUserData(title);
	}
	private  int whereIsPlayer(String title) {
		for(int i=0;i<buttons.length;i++) {
			if(buttons[i].getUserData().contains(title)) {
				return i;
			}
		}
		return -1;
	}
	
	

}
