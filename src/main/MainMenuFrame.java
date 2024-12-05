package main;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainMenuFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    public CustomPanel contentPane; // Custom JPanel for background drawing

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainMenuFrame frame = new MainMenuFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainMenuFrame() {
        setSize(1080, 630);
        setResizable(false);
        setTitle("Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load the background image
        Image backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/picBackgrounds/picMenuBackground.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Custom panel to draw background
        contentPane = new CustomPanel(backgroundImage);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JButton btnStart = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnStart.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    362, 150, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnStart.setIcon(new ImageIcon(scaledImage));
            btnStart.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnStart.setVerticalTextPosition(SwingConstants.CENTER);
            btnStart.setContentAreaFilled(false); // Make the background transparent
            btnStart.setBorderPainted(false);    // Remove the border
            btnStart.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }

        JButton btnInstructions = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnInstructions.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    362, 150, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnInstructions.setIcon(new ImageIcon(scaledImage));
            btnInstructions.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnInstructions.setVerticalTextPosition(SwingConstants.CENTER);
            btnInstructions.setContentAreaFilled(false); // Make the background transparent
            btnInstructions.setBorderPainted(false);    // Remove the border
            btnInstructions.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }

        JButton btnLeaderboards = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnLeaderboards.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    362, 150, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnLeaderboards.setIcon(new ImageIcon(scaledImage));
            btnLeaderboards.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnLeaderboards.setVerticalTextPosition(SwingConstants.CENTER);
            btnLeaderboards.setContentAreaFilled(false); // Make the background transparent
            btnLeaderboards.setBorderPainted(false);    // Remove the border
            btnLeaderboards.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }

        JButton btnAbout = new JButton("");
        try {
            Image originalImage = ImageIO.read(getClass().getResource("/picBackgrounds/picBtnAbout.png"));
            Image scaledImage = originalImage.getScaledInstance(
                    300, 150, Image.SCALE_SMOOTH // Adjust size as needed
                );
            btnAbout.setIcon(new ImageIcon(scaledImage));
            btnAbout.setHorizontalTextPosition(SwingConstants.CENTER); // Center the text over the icon
            btnAbout.setVerticalTextPosition(SwingConstants.CENTER);
            btnAbout.setContentAreaFilled(false); // Make the background transparent
            btnAbout.setBorderPainted(false);    // Remove the border
            btnAbout.setFocusPainted(false);     // Remove focus rectangle
        } catch (IOException e) {
            e.printStackTrace(); // Log the error if image loading fails
        }

        btnStart.addActionListener(e -> {
            dispose(); // Close the Main Menu
            mathmonMain gameFrame = new mathmonMain();
            gameFrame.setVisible(true); // Show the Game Frame
        });

        btnInstructions.addActionListener(e -> {
            dispose(); // Close the Main Menu
            mathmonInstructions instructionsFrame = new mathmonInstructions();
            instructionsFrame.setVisible(true); // Show the Leaderboards Frame
        });
        
        btnLeaderboards.addActionListener(e -> {
            dispose(); // Close the Main Menu
            mathmonLeaderboards leaderboardsFrame = new mathmonLeaderboards();
            leaderboardsFrame.setVisible(true); // Show the Leaderboards Frame
        });

        btnAbout.addActionListener(e -> {
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
        			.addGap(244)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(165)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addGap(16)
        							.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(btnLeaderboards, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        							.addComponent(btnInstructions, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED, 165, GroupLayout.PREFERRED_SIZE))
        				.addComponent(btnStart, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
        			.addGap(301))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(275, Short.MAX_VALUE)
        			.addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnInstructions, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnLeaderboards, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnAbout, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(202))
        );
        contentPane.setLayout(gl_contentPane);
    }

    // Custom JPanel for drawing the background
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
