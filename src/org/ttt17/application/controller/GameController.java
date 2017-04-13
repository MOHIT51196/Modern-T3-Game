package org.ttt17.application.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.ttt17.application.modal.ComputerAI;
import org.ttt17.application.modal.GameModal;
import org.ttt17.application.utils.GameMessageFactory;
import org.ttt17.application.utils.ResourceLoader;
import org.ttt17.application.view.GameView;

public class GameController implements ActionListener {

	private GameView mainFrame;
	private GameModal gameModal = GameModal.newInstance();
	private ResourceBundle configResourceBundle = ResourceBundle.getBundle("config");
	private final String CROSS_IMG_PATH = configResourceBundle.getString("game_cross_img");
	private final String CIRCLE_IMG_PATH = configResourceBundle.getString("game_circle_img");
	private ImageIcon circleIcon, crossIcon;
	
	
	private boolean isComputer;
	private int turnTrack, buttonId =1;
	private static ArrayList<Object> player1, player2; 
	private ComputerAI computerPlayer =new ComputerAI();

	public boolean isComputer() {
		return isComputer;
	}

	public void setComputer(boolean isCompputer) {
		this.isComputer = isCompputer;
	}

	public GameController(GameView mainFrame) throws IOException {
		
		this.mainFrame = mainFrame;
		crossIcon = new ImageIcon(ImageIO.read(ResourceLoader.load(CROSS_IMG_PATH)));
		circleIcon = new ImageIcon(ImageIO.read(ResourceLoader.load(CIRCLE_IMG_PATH)));
		
		setGame();
		player1 = new ArrayList<>();
		player2 = new ArrayList<>();
		

		
	}
	
	
	public void setGame(){
		String alias_1 = JOptionPane.showInputDialog(GameMessageFactory.getPlayerAliasMessage());
		String alias_2 = JOptionPane.showInputDialog(GameMessageFactory.getOpponentAliasMessage());
		
		if(gameModal.setPlayersAlias(alias_1,alias_2)){
			mainFrame.playerLabel_1.setText(gameModal.getAliasPlayer_1());
			mainFrame.playerLabel_2.setText(gameModal.getAliasPlayer_2());
		}
		else{
			JOptionPane.showMessageDialog(mainFrame, GameMessageFactory.getAliasErrorMessage());
			setGame();
		}
		
		completeResetGame();
	}
	
	public void completeResetGame(){
		resetGame();
		mainFrame.winLabel_1.setText("0");
		mainFrame.looseLabel_1.setText("0");
		mainFrame.drawLabel_1.setText("0");
		
		mainFrame.winLabel_2.setText("0");
		mainFrame.looseLabel_2.setText("0");
		mainFrame.drawLabel_2.setText("0");
	}
	public void resetGame(){
		for(JButton button : GameView.buttonList){
			button.setIcon(null);
			
		}
		player1 = new ArrayList<>();
		player2 = new ArrayList<>();
		turnTrack = 0;
		
	}
	public void addButton(JButton button){
		
		
		//adding ExtraData
		button.putClientProperty("id", buttonId++);
		
		//REGISTERING Listeners to the buttons
		button.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed( ActionEvent e){
		
		JButton button = (JButton)e.getSource();
		if( button.getIcon() == null ){
			
				
				if(turnTrack%2 == 0){
					
					button.setIcon(circleIcon);
					player1.add(Integer.parseInt(button.getClientProperty("id").toString()));
					
					
					
					if(gameModal.checkList(player1)){
						JOptionPane.showMessageDialog(mainFrame, gameModal.getAliasPlayer_1()+GameMessageFactory.getWinMessage());
						mainFrame.winLabel_1.setText(String.valueOf(Integer.parseInt(mainFrame.winLabel_1.getText())+1));
						mainFrame.looseLabel_2.setText(String.valueOf(Integer.parseInt(mainFrame.looseLabel_2.getText())+1));
						resetGame();
						return;
					}
					
					
				}
				if(turnTrack<8){
				
						if(mainFrame.multiPlayerRB.getModel() == mainFrame.groupRB.getSelection()){
							
							
							
							if(turnTrack%2 ==1){
								button.setIcon(crossIcon);
								player2.add(Integer.parseInt(button.getClientProperty("id").toString()));
								
							}
							else{
								turnTrack++;
								
								return;
							}
			
						}
						
						else{	
							
//						============================ AI LOGIC CALLING ===================================
								int buttonId = computerPlayer.computerMove(player1);
								
								
								for( JButton btn : GameView.buttonList){
									if( Integer.parseInt(btn.getClientProperty("id").toString()) == buttonId){
										btn.setIcon(crossIcon);
										player2.add(Integer.parseInt(btn.getClientProperty("id").toString()));
										
										turnTrack++;
										
										break;
									}
								}
								
//							================================================================================
						}
						
						
					turnTrack++;
					
					
					if(gameModal.checkList(player2)){
						JOptionPane.showMessageDialog(mainFrame, gameModal.getAliasPlayer_2()+GameMessageFactory.getWinMessage());
						mainFrame.winLabel_2.setText(String.valueOf(Integer.parseInt(mainFrame.winLabel_2.getText())+1));
						mainFrame.looseLabel_1.setText(String.valueOf(Integer.parseInt(mainFrame.looseLabel_1.getText())+1));
						resetGame();
						return;
					}
					
						
						
			}
			else{
				
				JOptionPane.showMessageDialog(mainFrame, GameMessageFactory.getDrawMessage());
				mainFrame.drawLabel_1.setText(String.valueOf(Integer.parseInt(mainFrame.drawLabel_1.getText())+1));
				mainFrame.drawLabel_2.setText(String.valueOf(Integer.parseInt(mainFrame.drawLabel_2.getText())+1));
				resetGame();
			}

			
			}
			else{
				JOptionPane.showMessageDialog(mainFrame, GameMessageFactory.getBlockMessage());
			}
	
		}
	
	
}
