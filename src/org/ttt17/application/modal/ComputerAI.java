package org.ttt17.application.modal;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;
import org.ttt17.application.utils.StackTraceWriter;

public class ComputerAI {
	
	private Random random = new Random();
	private int idTrack ;
	
	public int computerMove(ArrayList<Object> playList){
		Logger logger = Logger.getLogger(GameModal.class);
		logger.debug("\nCLASS : ColinerCheck\n\n");
		
		int track = 0;
		
		try{
			
				for(int[] idArr : GameModal.signature){
					track = 0;
						for(int id : idArr){
							
							if(playList.contains(id)) {
								track++;
								
							}
							else{
								idTrack = id;
							}
						}
						
						if(track == 2 && !GameModal.isButtonChecked(idTrack)){
							return idTrack;
						}
			
				}
			
			
			//logic for random action
			getRandomComputerMove();
		
	}
		catch(IndexOutOfBoundsException | NullPointerException e){
			StackTraceWriter.write(e, logger);
		}
	
		return idTrack;

}
	
	private void getRandomComputerMove(){
		
		idTrack = 1 + random.nextInt(9);
		
		if(GameModal.isButtonChecked(idTrack)){
			getRandomComputerMove();
		}
		
		
	}
}
