import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon; 

public class Sprite {
	protected int x;
	protected int y;
	protected ArrayList<Image> sprites;
	
	public Sprite (int x, int y){
		this.x = x;
		this.y = y;
		sprites = new ArrayList<Image>();
	}
	
	protected void loadImage(String imageName){
		try {
			sprites.add(ImageIO.read(new File("bin/"+ imageName +".png")));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	    
	}
	
	public Image getSprite(int n){
		return sprites.get(n);
	}
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Rectangle getBounds(){
    	return new Rectangle(x, y, 
    			sprites.get(0).getWidth(null), sprites.get(0).getHeight(null));
    }
	
}
