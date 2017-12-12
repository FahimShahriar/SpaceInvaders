import java.awt.*;
import java.awt.event.*;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GamePanel extends JPanel implements KeyListener{
	private boolean[] keys;
	SpaceInvaders mainFrame;
	ArrayList<Enemy> enemies;
	Image back;
	
	public GamePanel(SpaceInvaders m){
		keys = new boolean[KeyEvent.KEY_LAST+1];
		mainFrame = m;
		enemies = new ArrayList<Enemy>();
		for(int x = 100; x <= 800; x += 70){
			enemies.add(new Enemy(x+8, 185, "King"));
			for(int y = 250; y <= 350; y += 70){
				enemies.add(new Enemy(x, y, "Knight"));
			}
			for(int y = 390; y <= 500; y += 70){
				enemies.add(new Enemy(x, y, "Pawn"));
			}
		}

//		setFocusable(true);
//		setSize(800,600);
//        setBackground(Color.BLACK);
        addKeyListener(this);
        
        
        
	}
	
    public void addNotify() {
        super.addNotify();
        requestFocus();
        
        mainFrame.start();
    }
    
    public void update(int counter){
    	
    	if(counter % 50 == 0){
    		boolean changeDir = false;
    		for(Enemy e:enemies){
    			if(e.getX() > 1100 || e.getX() < 10)
    				changeDir = true;
    		}
    		for(Enemy e:enemies){
    			e.move(changeDir);
            }
    	}
    }
    
    public void paintComponent(Graphics g){ 
    	 g.setColor(new Color(0,0,0));  
         g.fillRect(0,0,getWidth(),getHeight());  
         
         for(Enemy e:enemies){
        	 e.draw(g);
         }
         

    }
	
	//KeyListener
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

 
}
