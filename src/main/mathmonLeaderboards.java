package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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

public class mathmonLeaderboards extends JFrame {

	private static final long serialVersionUID = 1L;
    private CustomPanel contentPane; // Custom JPanel for background drawing

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mathmonLeaderboards frame = new mathmonLeaderboards();
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
	public mathmonLeaderboards() {
		setSize(1080,630);
		setResizable(false);
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		 Image backgroundImage = null;
	        try {
	            backgroundImage = ImageIO.read(getClass().getResource("/picBackgrounds/picLeaderboardsBackground.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Custom panel to draw background
	        contentPane = new CustomPanel(backgroundImage);
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
		
		JButton btnBackLeaderboars = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnBack.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    140, 30, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnBackLeaderboars.setIcon(new ImageIcon(scaledImage));
            btnBackLeaderboars.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnBackLeaderboars.setVerticalTextPosition(SwingConstants.CENTER);
            btnBackLeaderboars.setContentAreaFilled(false); // Make the background transparent
            btnBackLeaderboars.setBorderPainted(false);    // Remove the border
            btnBackLeaderboars.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }
        
		btnBackLeaderboars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the About frame
                MainMenuFrame mainMenu = new MainMenuFrame();
                mainMenu.setVisible(true); // Show the main menu
            }
        });
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(btnBackLeaderboars, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(957, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(538, Short.MAX_VALUE)
					.addComponent(btnBackLeaderboars, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(108))
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
