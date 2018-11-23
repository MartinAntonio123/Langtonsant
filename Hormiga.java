import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Canvas;

public class Hormiga extends Canvas{

	private int x, y, dir;
	private BufferedImage[] imagenes;

	public Hormiga(int x, int y){
		this.x=x;
		this.y=y;
		dir = 4;
		String nombimagen;
		imagenes = new BufferedImage[4];
		for (int i=0;i<4;i++) {
			nombimagen = "media/hormiga"+i+".png";
			File archImagen = new File(nombimagen);
	    try {
	        imagenes[i] = ImageIO.read(archImagen);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		}
	}
	public void paint(Graphics g)
	{
		g.drawImage(imagenes[dir-1], x*30, y*30, 30, 30, null);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void move(int color){
		/*
		Si esta sobre un cuadrado blanco, cambia el color del cuadrado, gira noventa grados a
		la derecha y avanza un cuadrado.
		2. Si esta sobre un cuadrado negro, cambia el color del cuadrado, gira noventa grados a
		la izquierda y avanza un cuadrado.
*/
		if (color == 1) {
			dir--;
			if (dir<1) {
				dir = 4;
			}
		}
		else{
			dir++;
			if (dir>4) {
				dir = 1;
			}
		}
		avanza();
	}
	public void avanza(){
		if (dir == 1) {
			this.y = this.y - 1 ;
		}
		else if (dir == 2) {
			this.x = this.x + 1 ;
		}
		if (dir == 3) {
			this.y = this.y + 1 ;
		}
		else if (dir == 4) {
			this.x = this.x - 1 ;
		}
	}
}
