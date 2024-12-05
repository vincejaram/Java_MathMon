package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_HealingPotion extends SuperObject{
	
	public OBJ_HealingPotion() {
		name = "Healing Potion";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/sapphire.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
