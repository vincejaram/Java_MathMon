package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_TimeWarp extends SuperObject{
	
	public OBJ_TimeWarp() {
		name = "Time Warp";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/diamond.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
