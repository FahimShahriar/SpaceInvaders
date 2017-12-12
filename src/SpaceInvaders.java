import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.MouseInfo;

@SuppressWarnings("unused")
public class SpaceInvaders extends JFrame implements ActionListener{
	Timer myTimer;   
	GamePanel game;
	int counter;
		
    public SpaceInvaders() {
		super("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1158,894);

		myTimer = new Timer(10, this);	 // trigger every 0 MS
		counter = 1;

		game = new GamePanel(this);
		add(game);

 		setResizable(false);
		setVisible(true);
    }
	
	public void start(){
		myTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent evt){
		counter ++;
		if (counter > 1000)
			counter = 1;
		
		game.repaint();
		game.update(counter);
	}

    public static void main(String[] arguments) {
    	SpaceInvaders frame = new SpaceInvaders();		
    }
}
