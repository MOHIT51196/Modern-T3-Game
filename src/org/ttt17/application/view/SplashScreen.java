package org.ttt17.application.view;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

import org.apache.log4j.Logger;
import org.ttt17.application.utils.ResourceLoader;
import org.ttt17.application.utils.StackTraceWriter;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	
	private JLabel splashLabel, authorLabel;
	
	private final String IMG_PATH = ResourceBundle.getBundle("config").getString("game_splash_img");
	private ImageIcon splashIcon ;
	private final String authoredBy = "created by MOHIT MALHOTRA";
	private static SplashScreen instance;
	
	private SplashScreen(){}
	
	public static SplashScreen newInstance(){
		
		if(instance == null){
			instance = new SplashScreen();
		}
		
		return instance;
	}
	
	public void showSplashScreen(){
		Logger logger = Logger.getLogger(SplashScreen.class);
		logger.debug("\nCLASS : SplashScreenl\n\n");
		
		setSize(600,400);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		
		
		try {
			splashIcon = new ImageIcon(ImageIO.read(ResourceLoader.load(IMG_PATH)));
			splashLabel = new JLabel(splashIcon);
			
			
		} 
		catch (IOException exception) {
			splashLabel = new JLabel();
			
			StackTraceWriter.write(exception, logger);
		}
		
		
		splashLabel.setBounds(20, 0, splashIcon.getIconWidth(), splashIcon.getIconHeight());
		
		authorLabel = new JLabel(authoredBy);
		authorLabel.setBounds(275, 350, 300, 25);
		authorLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		authorLabel.setForeground(Color.WHITE);
		
		add(authorLabel);
		add(splashLabel);
		setVisible(true);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			JOptionPane.showMessageDialog(this, "Application stopped unexpectedly");
			StackTraceWriter.write(e, logger);
		}
		
		dispose();
	}
	
	
}
