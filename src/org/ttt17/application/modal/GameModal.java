package org.ttt17.application.modal;
import java.util.ArrayList;

import javax.swing.JButton;

import org.apache.log4j.Logger;
import org.ttt17.application.utils.StackTraceWriter;
import org.ttt17.application.view.GameView;

public class GameModal  {


	private String aliasPlayer_1 ="";
	private String aliasPlayer_2 ="";
	
	private static GameModal instance;
	
	private GameModal(){}
	
	
	public static GameModal newInstance(){
		if(instance == null){
			instance = new GameModal();
		}
		
		return instance;
	}
	
	public String getAliasPlayer_1() {
		return aliasPlayer_1;
	}


	public String getAliasPlayer_2() {
		return aliasPlayer_2;
	}


	public boolean setPlayersAlias(String aliasPlayer_1, String aliasPlayer_2){
		boolean isSet = false;
		
		if(isAliasValid(aliasPlayer_1, aliasPlayer_2)){
			this.aliasPlayer_1 = aliasPlayer_1.substring(0, 1).toUpperCase()+aliasPlayer_1.substring(1)+" ";
			this.aliasPlayer_2 = aliasPlayer_2.substring(0, 1).toUpperCase()+aliasPlayer_2.substring(1)+" ";
			isSet = true;
		}
	
		return isSet;
	}
	
	
	public static int[][] signature = new int[][]{
	
		//for boundary relations
		{1,2,3},
		{3,6,9},
		{7,8,9},
		{1,4,7},
		//for diagonal relations
		{1,5,9},
		{3,5,7},
		//for vertical or horizontal axis relations 
		{2,5,8},
		{4,5,6},
	};
	
	public boolean checkList(ArrayList<Object> playList){
		Logger logger = Logger.getLogger(GameModal.class);
		logger.debug("\nCLASS : ColinerCheck\n\n");
		
		int track = 0;
		try{
			if(playList.size() >= 3){
				
				for(int[] idArr : signature){
					track = 0;
						for(int id : idArr){
							
							if(playList.contains(id)) {
								track++;
								
							}
						}
						
						if(track >= 3){
							return true;
						}
			
				}
				
			}
		
	}
		catch(IndexOutOfBoundsException | NullPointerException e){
			StackTraceWriter.write(e, logger);
		}
		return false;
	}
	


	private static boolean isAliasValid(String alias_1, String alias_2){
		boolean isValid = false;
		
		if(alias_1 != null && alias_2 != null){
			if((alias_1.trim().length() != 0) && (alias_2.trim().length() != 0)){
					return (!alias_1.equals(alias_2));
				
			}
		}
		return isValid;
	}
	
	public static boolean isButtonChecked(int buttonId){
		
		boolean isChecked = false;
		
		for( JButton button : GameView.buttonList ){
			if( Integer.parseInt( button.getClientProperty("id").toString() ) == buttonId){
				isChecked = button.getIcon() == null ? false : true;
			}
		}
		
		return isChecked;
	}
}
