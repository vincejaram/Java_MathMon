package main;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class mathmonDevelopers extends JFrame {

	private static final long serialVersionUID = 1L;
	private CustomPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mathmonDevelopers frame = new mathmonDevelopers();
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
	public mathmonDevelopers() {
		setSize(1080,630);
		setResizable(false);
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Image backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/picBackgrounds/picDevelopersBackground.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Custom panel to draw background
        contentPane = new CustomPanel(backgroundImage);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
		
        JButton btnBack = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnBack.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    162, 40, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnBack.setIcon(new ImageIcon(scaledImage));
            btnBack.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnBack.setVerticalTextPosition(SwingConstants.CENTER);
            btnBack.setContentAreaFilled(false); // Make the background transparent
            btnBack.setBorderPainted(false);    // Remove the border
            btnBack.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }
		
		btnBack.addActionListener(e -> {
            dispose(); // Close the Main Menu
            EventQueue.invokeLater(() -> {
                mathmonAbout aboutFrame = new mathmonAbout();
                aboutFrame.setVisible(true);
                aboutFrame.toFront(); // Bring About Frame to front
                aboutFrame.requestFocus(); // Ensure About Frame receives focus
            });
        });
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(130)
					.addComponent(btnBack)
					.addContainerGap(732, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(446, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(89))
		);
		contentPane.setLayout(gl_contentPane);
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
