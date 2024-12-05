package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class mathmonChoosePlayer extends JFrame {

	private static final long serialVersionUID = 1L;
    private CustomPanel contentPane; // Custom JPanel for background drawing

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mathmonChoosePlayer frame = new mathmonChoosePlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mathmonChoosePlayer() {
		setSize(1080,630);
		setResizable(false);
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		 Image backgroundImage = null;
	        try {
	            backgroundImage = ImageIO.read(getClass().getResource("/picBackgrounds/picAboutBackground.jpg"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Custom panel to draw background
	        contentPane = new CustomPanel(backgroundImage);
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(btnBack)
					.addContainerGap(937, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(520, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(50))
		);
		getContentPane().setLayout(groupLayout);
	}
	private static class CustomPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private final Image backgroundImage;

        public CustomPanel(Image image) {
            this.backgroundImage = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
            }
        }
    }
}
