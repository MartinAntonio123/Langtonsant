import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;


public class Hcanvas extends Canvas implements Runnable{

	private Image offScreenImage = null;
	private Graphics offScreenGraphics = null;
	private Image offScreenImageDrawed = null;
	private Graphics offScreenGraphicsDrawed = null;
	private Thread thread;
	boolean running;
	private int FPS = 60;
	private long optimalTime = 1000 / FPS;
	private Hormiga mihormiga;
	private Cuadricula micuadricula;
	private int iterations, speed, cont;


	public Hcanvas(){
		super();
		this.setBackground(Color.white);
		mihormiga = new Hormiga(0, 0);
		micuadricula = new Cuadricula();
		iterations = 1000;
		speed = 10;
		cont = 0;
	}
	public void update(Graphics g){
		paint(g);
	}
	public void paint(Graphics g){
		if (offScreenImageDrawed == null) {
        offScreenImageDrawed = createImage(2000, 1800);
    }
    offScreenGraphicsDrawed = offScreenImageDrawed.getGraphics();
    offScreenGraphicsDrawed.setColor(Color.LIGHT_GRAY);
		offScreenGraphicsDrawed.fillRect(0,0,2000,1800);
		micuadricula.paint(offScreenGraphicsDrawed);
		mihormiga.paint(offScreenGraphicsDrawed);
    g.drawImage(offScreenImageDrawed, 0, 0, null);
	}

	public void start(){
		if(!running || (thread == null)){
			running = true;
        thread = new Thread(this);
        thread.start();
		}
	}
	@Override
	public void run() {
      long startTime;
      long elapsedTime;
      long waitTime;
      while (running){
          startTime = System.nanoTime();
          gameUpdate();
          repaint();
          elapsedTime = System.nanoTime() - startTime;
          waitTime = optimalTime - elapsedTime / 1000000;
          try {
              if (waitTime <= 0){
                  waitTime = 2;
              }
              Thread.sleep(waitTime);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
	}
	public void gameUpdate(){
		if (iterations>0) {
			cont ++;
			if (cont == speed) {
				int auxx = mihormiga.getX();
				int auxy = mihormiga.getY();
				mihormiga.move(micuadricula.getColor(mihormiga.getX(), mihormiga.getY()));
				micuadricula.setColor(auxx, auxy);
				cont = 0;
				iterations --;
			}
		}
	}

}
