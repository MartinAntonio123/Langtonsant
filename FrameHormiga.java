import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.*;

public class FrameHormiga extends JFrame{

	private static final long serialVersionUID = 1L;
	private Hcanvas micanvas;

	FrameHormiga(){
		setLayout(new BorderLayout());
		micanvas=new Hcanvas();
		add(micanvas, BorderLayout.CENTER);
		micanvas.start();
	}
}
