package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_PowerSurge extends SuperObject{
	
	public OBJ_PowerSurge() {
		name = "Power Surge";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/ruby.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
