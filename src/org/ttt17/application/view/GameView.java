package org.ttt17.application.view;

import static java.util.ResourceBundle.getBundle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.ttt17.application.controller.GameController;
import org.ttt17.application.utils.GUILookAndFeel;

public class GameView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel gamePanel ;
	private JLabel scoreCardLabel;
	
	
	private static final String GAME_TITLE = getBundle("config").getString("game_title");
	private final String GAME_FONT = getBundle("config").getString("game_font_style");
//	private final ImageIcon DEFAULT_BGIMAGE = new ImageIcon(getBundle("config").getString("game_default_background"));
//	private final ImageIcon DARK_BGIMAGE = new ImageIcon(getBundle("config").getString("game_dark_background"));
	private GameController gameController ;
	
	public static JButton[] buttonList = new JButton[9];
	public ButtonGroup groupRB = new ButtonGroup();
	public JRadioButton singlePlayerRB,multiPlayerRB;
	public JLabel playerLabel_1,playerLabel_2 ;
	public JLabel winLabel_1,looseLabel_1,drawLabel_1;
	public JLabel winLabel_2,looseLabel_2,drawLabel_2;

	
	
	
	public GameView() {
		
		super(GAME_TITLE);
		SplashScreen.newInstance().showSplashScreen();
		GUILookAndFeel.setGUILookAndFeel();
		setSize(900,650);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event){
			
				Icon icon = new ImageIcon(GameView.class.getResource("splash.png"));
				int choice = JOptionPane.showConfirmDialog(GameView.this, "Do you really want to exit from the game",GAME_TITLE,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icon);
				
				if(choice == JOptionPane.YES_OPTION){
					GameView.this.setVisible(false);
					GameView.this.dispose();
				}
			}
			
		});
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		singlePlayerRB = new JRadioButton("Single Player",true);
		singlePlayerRB.setFont(new Font(GAME_FONT, Font.PLAIN, 16));
		singlePlayerRB.setBounds(607, 99, 129, 36);
		groupRB.add(singlePlayerRB);
		contentPane.add(singlePlayerRB);
		
		multiPlayerRB = new JRadioButton("Multi Player",false);
		multiPlayerRB.setFont(new Font(GAME_FONT, Font.PLAIN, 16));
		multiPlayerRB.setBounds(753, 99, 115, 36);
		groupRB.add(multiPlayerRB);
		contentPane.add(multiPlayerRB);
	
		
		JPanel scorePanel = new JPanel();
		scorePanel.setBounds(607, 182, 256, 353);
		scorePanel.setLayout(null);
		contentPane.add(scorePanel);
		
		
		scoreCardLabel = new JLabel("SCORE CARD");
		scoreCardLabel.setFont(new Font(GAME_FONT, Font.PLAIN, 20));
		scoreCardLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		scoreCardLabel.setBounds(68, 21, 145, 36);
		scorePanel.add(scoreCardLabel);
		
		JPanel playerPanel_1 = new JPanel();
		playerPanel_1.setBounds(10, 95, 111, 230);
		scorePanel.add(playerPanel_1);
		playerPanel_1.setLayout(null);
		
		playerLabel_1  = new JLabel();
		playerLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 16));
		playerLabel_1.setBounds(10, 11, 91, 27);
		playerPanel_1.add(playerLabel_1);
		
		JLabel playerWinLabel_1 = new JLabel("Wins");
		playerWinLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerWinLabel_1.setBounds(10, 72, 46, 14);
		playerPanel_1.add(playerWinLabel_1);
		
		JLabel playerLooseLabel_1 = new JLabel("Looses");
		playerLooseLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerLooseLabel_1.setBounds(10, 106, 46, 14);
		playerPanel_1.add(playerLooseLabel_1);
		
		JLabel playerDrawLabel_1 = new JLabel("Draws");
		playerDrawLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerDrawLabel_1.setBounds(10, 149, 46, 14);
		playerPanel_1.add(playerDrawLabel_1);
		
		winLabel_1 = new JLabel("0");
		winLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		winLabel_1.setBounds(69, 72, 32, 14);
		playerPanel_1.add(winLabel_1);
		
		looseLabel_1 = new JLabel("0");
		looseLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		looseLabel_1.setBounds(69, 106, 32, 14);
		playerPanel_1.add(looseLabel_1);
		
		drawLabel_1 = new JLabel("0");
		drawLabel_1.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		drawLabel_1.setBounds(69, 149, 32, 14);
		playerPanel_1.add(drawLabel_1);
		
		JPanel playerPanel_2 = new JPanel();
		playerPanel_2.setBounds(135, 95, 111, 230);
		scorePanel.add(playerPanel_2);
		playerPanel_2.setLayout(null);
		
		playerLabel_2 = new JLabel();
		playerLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 16));
		playerLabel_2.setBounds(10, 11, 91, 29);
		playerPanel_2.add(playerLabel_2);
		
		JLabel playerWinLabel_2 = new JLabel("Wins");
		playerWinLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerWinLabel_2.setBounds(10, 70, 46, 14);
		playerPanel_2.add(playerWinLabel_2);
		
		JLabel playerLooseLabel_2 = new JLabel("Looses");
		playerLooseLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerLooseLabel_2.setBounds(10, 107, 46, 14);
		playerPanel_2.add(playerLooseLabel_2);
		
		JLabel playerDrawLabel_2 = new JLabel("Draws");
		playerDrawLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		playerDrawLabel_2.setBounds(10, 149, 46, 14);
		playerPanel_2.add(playerDrawLabel_2);
		
		looseLabel_2 = new JLabel("0");
		looseLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		looseLabel_2.setBounds(69, 107, 32, 14);
		playerPanel_2.add(looseLabel_2);
		
		drawLabel_2 = new JLabel("0");
		drawLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		drawLabel_2.setBounds(69, 149, 32, 14);
		playerPanel_2.add(drawLabel_2);
		
		winLabel_2 = new JLabel("0");
		winLabel_2.setFont(new Font(GAME_FONT, Font.PLAIN, 14));
		winLabel_2.setBounds(69, 70, 32, 14);
		playerPanel_2.add(winLabel_2);
		
		
		JToggleButton themeBtn = new JToggleButton("Change Theme");
		themeBtn.setForeground(Color.WHITE);
		themeBtn.setBackground(Color.GRAY);
		themeBtn.setContentAreaFilled(true);
		themeBtn.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		themeBtn.setBounds(644, 11, 121, 31);
		
		themeBtn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(((JToggleButton)e.getSource()).isSelected()){
					setDarkTheme();
				}
				else{
					setDefaultTheme();
				}
			}
		});
		contentPane.add(themeBtn);
		
		JButton restartBtn = new JButton("Restart");
		restartBtn.setForeground(Color.WHITE);
		restartBtn.setBackground(Color.GRAY);
		themeBtn.setContentAreaFilled(true);
		restartBtn.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		restartBtn.setBounds(779, 12, 89, 30);
		restartBtn.addActionListener((event)->{
			gameController.setGame();
		});
		contentPane.add(restartBtn);

		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setForeground(Color.WHITE);
		resetBtn.setBackground(Color.GRAY);
		themeBtn.setContentAreaFilled(true);
		resetBtn.setFont(new Font(GAME_FONT, Font.PLAIN, 12));
		resetBtn.setBounds(779, 53, 89, 30);
		resetBtn.addActionListener((event)->{
			gameController.completeResetGame();
			});
		contentPane.add(resetBtn);
		
		//prepare GamePanel
		gamePanel = new JPanel();
		gamePanel.setLocation(40, 40);
		gamePanel.setSize(540,540);
		gamePanel.setLayout(new GridLayout(3, 3, 2, 2));
		contentPane.add(gamePanel);
		
		
		for(int i=0; i<buttonList.length; i++){
			buttonList[i] = new JButton();
			gamePanel.add(buttonList[i]);
			
		}
		try {
			gameController = new GameController(this);
		} 
		catch (IOException exception) {
			JOptionPane.showMessageDialog(this, getBundle("config").getString("imgrender_error_message"));
			gamePanel.removeAll();
			
			gamePanel.add(new JLabel("RENDERING ISSUE"));
		}
		
		for(int i=0; i<buttonList.length; i++){
			gameController.addButton(buttonList[i]);
		}
	}

	
	private void setDarkTheme(){
		
	
		contentPane.setBackground(Color.BLACK);
		gamePanel.setBackground(Color.BLACK);
		
		singlePlayerRB.setForeground(Color.WHITE);
		multiPlayerRB.setForeground(Color.WHITE);
		
		
		
		
	}

	private void setDefaultTheme(){
		contentPane.setBackground(Color.WHITE);
		gamePanel.setBackground(Color.WHITE);
		
		
		singlePlayerRB.setForeground(Color.BLACK);
		multiPlayerRB.setForeground(Color.BLACK);
		
	}
}
