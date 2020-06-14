import javax.swing.JOptionPane;

public class Steal {

	private String options[]= {"+100 парички всеки път, когато попаднете на квадратче „Шанс“.",
			"+100 парички всеки път, когато попаднете на квадратче „Invest“",
			"+100 парички всеки път, когато попаднем на квадратче „Steal“."};



	public void steal(Player p) {
		JOptionPane.showMessageDialog(null, options[p.steal-1]);
			
		
	}
}
