package org.ttt17.application.utils;


import org.apache.log4j.Logger;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class GUILookAndFeel {


	private GUILookAndFeel(){}
	
	public static void setGUILookAndFeel(){
		
		Logger logger = Logger.getLogger(GUILookAndFeel.class);
		logger.debug("\nCLASS : GUILookAndFeel\n\n");
		try {
			
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			LookAndFeelInfo[] lafArray = UIManager.getInstalledLookAndFeels();
			
			for( LookAndFeelInfo laf : lafArray){
				if("Nimbus".equalsIgnoreCase(laf.getName())){

					UIManager.setLookAndFeel(laf.getClassName());
				}
			}
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException err) {
			
			StackTraceWriter.write( err, logger);
		}
		
	}
}
