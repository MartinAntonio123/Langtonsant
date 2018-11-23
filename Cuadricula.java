import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Cuadricula extends Canvas{

	private int[][] cordinadas ;

	public Cuadricula(){
		cordinadas = new int[70][70];
		for (int i=0;i<70;i++) {
			for (int j=0;j<70;j++) {
				cordinadas[i][j] = 0;
			}
		}
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.DARK_GRAY);
		for (int i=0;i<70;i++) {
			for (int j=0;j<70;j++) {
				if (cordinadas[i][j] == 1) {
					g.fillRect(i*30,j*30,30,30);
				}
			}
		}
		g.setColor(Color.black);
		for (int i = 0; i < 2000 ; i = i + 30) {
      g.drawLine(0,i,2000,i);
      g.drawLine(i,0,i,2000);
    }
	}
	public int getColor(int x, int y){
		return cordinadas[x][y];
	}
	public void setColor(int x, int y){
		if (cordinadas[x][y] == 1) {
			cordinadas[x][y] = 0;
		}
		else{
			cordinadas[x][y] = 1;
		}
	}

}
