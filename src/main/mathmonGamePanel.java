package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class mathmonGamePanel  extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int originalTileSize = 16; // 16x16 tile
	public int scale = 3;
	
	public int tileSize = originalTileSize * scale; // 48x48 tile
	public int maxScreenCol = 18;
	public int maxScreenRow = 12;
	public int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public int screenHeight = tileSize * maxScreenRow; // 576 pixels
	
	//World Settings 
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	int FPS = 60; // FPS
	
	TileManager tileM = new TileManager(this);
	
	KeyHandler keyH = new KeyHandler(this);
	Thread gameThread;
	public mathmonCollisionChecker cChecker = new mathmonCollisionChecker(this);
	public mathmonAssetSetter aSetter = new mathmonAssetSetter(this);
	
	// Entity and object
	public Player player = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[10];
	
	// Game state
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	
	public mathmonGamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setUpGame() {
		aSetter.setObject();
		gameState = playState;
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		player.powerSurge = 0;
		player.healingPotion = 0;
		player.timeWarp = 0;
	}
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		
		while (gameThread != null) {
			
			// UPDATE: update information such as character positions
			update();
			// DRAW: draw the screen with the updated information 
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update() {
		if(gameState==playState) {
			player.update();
		}
		if(gameState==pauseState) {
			// nothing
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		tileM.draw(g2);
		for(int i=0;i<obj.length;i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		player.draw(g2);
	}

}














