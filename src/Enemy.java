import java.awt.Graphics;


public class Enemy extends Sprite{
	boolean state; // the animation frame
	boolean movingRight;
	
	public Enemy(int x, int y, String type) {
		super(x, y);
		loadImage(type+"1");
		loadImage(type+"2");
		state = true;
		movingRight = true;
	}
	
	public void move(boolean changeDir){
		if(changeDir)
			movingRight = !movingRight;
		if(movingRight)
			x += 12;
		else
			x -= 12;
		state = !state;
	}
	
	public void draw(Graphics g){
		if(state)
			g.drawImage(sprites.get(0), x, y, null);
		else
			g.drawImage(sprites.get(1), x, y, null);
	}

}
