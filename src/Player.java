
public class Player extends Sprite{

	public Player(int x, int y) {
		super(x, y);
		for(int i = 1; i <= 3; i++)
			loadImage("Player" + i);
	}
	

}
