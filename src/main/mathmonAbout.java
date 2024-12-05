package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tile.Tile;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;

public class mathmonAbout extends JFrame {

	private static final long serialVersionUID = 1L;
    private CustomPanel contentPane; // Custom JPanel for background drawing
	public Tile tile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mathmonAbout frame = new mathmonAbout();
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
	public mathmonAbout() {
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
		
		JButton btnBackAbout = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnBack.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    162, 40, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnBackAbout.setIcon(new ImageIcon(scaledImage));
            btnBackAbout.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnBackAbout.setVerticalTextPosition(SwingConstants.CENTER);
            btnBackAbout.setContentAreaFilled(false); // Make the background transparent
            btnBackAbout.setBorderPainted(false);    // Remove the border
            btnBackAbout.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }
		
		btnBackAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the About frame
                MainMenuFrame mainMenu = new MainMenuFrame();
                mainMenu.setVisible(true); // Show the main menu
            }
        });
		
		JButton btnDevelopers = new JButton("");
		try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnDevelopers.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    162, 40, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnDevelopers.setIcon(new ImageIcon(scaledImage));
            btnDevelopers.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnDevelopers.setVerticalTextPosition(SwingConstants.CENTER);
            btnDevelopers.setContentAreaFilled(false); // Make the background transparent
            btnDevelopers.setBorderPainted(false);    // Remove the border
            btnDevelopers.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }
		
		btnDevelopers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the About frame
                mathmonDevelopers developersFrame = new mathmonDevelopers();
                developersFrame.setVisible(true); // Show the main menu
            }
        });
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnBackAbout, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 559, Short.MAX_VALUE)
					.addComponent(btnDevelopers, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(455, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBackAbout)
							.addGap(93))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnDevelopers, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(105))))
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
