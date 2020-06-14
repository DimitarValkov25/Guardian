import java.util.Scanner;

import javax.swing.JOptionPane;

public class Trap {

	
	
	boolean svoboden;
	
public void plandTrap(Player p) {
	String n =JOptionPane.showInputDialog(null, "Желаете ли да заложите капан? \n" + 
			"*	(1) : Данъчна ревизия (100 шп) \n" + 
			"*	(2) : Развод по котешки (200 шп) \n" + 
			"*	(3) : Пропаганда (100 шп) \n" + 
			"*	(4) : Проглеждане (50 шп) \n" + 
			"*	(5) : Хазартен бос (100 шп) \n" + 
			"*	(N) : Не, благодаря, не вярвам в злото" );
		p.traps[Integer.parseInt(n)]=true;
	
}
	
	
}
