import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

class GameBoard extends JFrame {
	int t1,t2;
	
	GameBoard() {
		setSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t1=calculate();
		t2=calculate();
		
	}
	
	
	private int calculate() {
		int n;
		do {
			n=rand.nextInt(turtalPosition.length-1);
		}while(turtalPosition[n]==-1);
		int x =turtalPosition[n];
		turtalPosition[n]=-1;
		
		return x;
	}
	
	public int[] turtalPosition = {0,1,3,4};
	private Random rand=new Random();

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Color colorsPalete[] = { Color.RED, Color.DARK_GRAY, Color.white, Color.DARK_GRAY, Color.RED };
		Color colorsPalete2[] = { Color.DARK_GRAY, Color.RED, Color.white, Color.RED, Color.DARK_GRAY };

		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (row == 0) {
					
					renderSquare(g, col, row, colorsPalete[col], false);
				} else if (row == 4) {
					renderSquare(g, col, row, colorsPalete2[col], false);
				} else {
					renderSquare(g, col, row, Color.BLACK, false);
				}
			}
		}
		fillBoard(g);
		fillBlankSpacesInBoard(g);
	
		
		
	
		
	}

	public void fillBoard(Graphics g) {
		for (int j = 0; j < 5; j++) {

			for (int i = 0; i < 5; i++) {
				if (j == 0) {
					if (i != 4) {

						renderCircle(g, i, j, Color.GREEN, Color.YELLOW, true);
					} else if (i == 4) {

						renderSquare(g, i, j, Color.YELLOW, true);
					}
				} else if (j == 4) {
					if (i != 4) {
						renderCircle(g, i, j, Color.YELLOW, Color.GREEN, true);

					} else {

						renderSquare(g, j, i, Color.GREEN, true);
					}
				}
			}

		}
		
		
		
	}
	public void fillBlankSpacesInBoard(Graphics g) {
		
		for (int j = 1; j < 4; j++) {

			for (int i = 0; i < 5; i++) {
				
				if(j==3&&i!=2||j==1) {
					renderSquare(g, i, j, Color.GRAY, false);
				
				}else if(j!=1){
					renderSquare(g, i, j, Color.WHITE, false);
				}
				if(i==2&&j==2) {
					renderCircle(g, i, j, Color.GRAY, Color.GRAY, true);
				}
			
			}
			
		}
		renderSquare(g, 2,1, Color.WHITE, false);
		
		renderTurtal(g,t1,2,Color.red);
		renderTurtal(g,t2,2,Color.red);
	}

	public void renderSquare(Graphics g, int row, int col, Color c, boolean figure) {

		g.setColor(c);
		if (figure) {
			g.fill3DRect((row * 80) + 20, (col * 80) + 40, 40, 40,true);

		} else

			g.fill3DRect((row * 80), (col * 80), 80, 80,true);
	

	}
	
	public void renderTurtal(Graphics g,int row, int col, Color c) {
		g.setColor(c);
		g.drawOval((row*80) + 20, (col * 70) + 40, 40, 40);
		
		
		
	}

	public void renderCircle(Graphics g, int row, int col, Color background, Color foreground, boolean figure) {

		g.setColor(background);
		g.fillOval((row * 80) + 20, (col * 80) + 40, 40, 40);
		if(figure)
		g.setColor(foreground);
		g.fillOval((row * 80) + 21, (col * 80) + 41, 38, 38);

	}

}
