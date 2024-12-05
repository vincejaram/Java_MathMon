package main;

import object.OBJ_HealingPotion;
import object.OBJ_PowerSurge;
import object.OBJ_TimeWarp;

public class mathmonAssetSetter {
	
	mathmonGamePanel gp;
	
	public mathmonAssetSetter(mathmonGamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		gp.obj[0] = new OBJ_PowerSurge();
		gp.obj[0].worldX = 5 * gp.tileSize;
		gp.obj[0].worldY = 45 * gp.tileSize;
		
		gp.obj[1] = new OBJ_PowerSurge();
		gp.obj[1].worldX = 10 * gp.tileSize;
		gp.obj[1].worldY = 40 * gp.tileSize;
		
		gp.obj[2] = new OBJ_HealingPotion();
		gp.obj[2].worldX = 15 * gp.tileSize;
		gp.obj[2].worldY = 22 * gp.tileSize;
		
		gp.obj[3] = new OBJ_HealingPotion();
		gp.obj[3].worldX = 7 * gp.tileSize;
		gp.obj[3].worldY = 30 * gp.tileSize;
		
		gp.obj[4] = new OBJ_TimeWarp();
		gp.obj[4].worldX = 3 * gp.tileSize;
		gp.obj[4].worldY = 48 * gp.tileSize;
		
		gp.obj[5] = new OBJ_TimeWarp();
		gp.obj[5].worldX = 19 * gp.tileSize;
		gp.obj[5].worldY = 24 * gp.tileSize;
	}
}
