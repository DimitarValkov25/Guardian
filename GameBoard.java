import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

class GameBoard extends JFrame {
	GameBoard() {
		setSize(new Dimension(400, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

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
		
	}

	public void renderSquare(Graphics g, int row, int col, Color c, boolean figure) {

		g.setColor(c);
		if (figure) {
			g.fillRect((row * 80) + 20, (col * 80) + 40, 40, 40);

		} else

			g.fillRect((row * 80), (col * 80), 80, 80);

	}

	public void renderCircle(Graphics g, int row, int col, Color background, Color foreground, boolean figure) {

		g.setColor(background);
		g.fillOval((row * 80) + 20, (col * 80) + 40, 40, 40);
		if(figure)
		g.setColor(foreground);
		g.fillOval((row * 80) + 21, (col * 80) + 41, 38, 38);

	}

}
