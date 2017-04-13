package org.ttt17.application.utils;

import java.util.ResourceBundle;

public class GameMessageFactory {

	private GameMessageFactory(){}
	private static ResourceBundle resourceBundle =ResourceBundle.getBundle("game_messages");
	private static final  String WELCOME_MESSAGE = resourceBundle.getString("welcome_message");
	private static final String WIN_MESSAGE = resourceBundle.getString("win_message");
	private static final String DRAW_MESSAGE = resourceBundle.getString("draw_message");
	private static final String BLOCK_MESSAGE = resourceBundle.getString("block_message");
	private static final String PLAYER_ALIAS_MESSAGE = resourceBundle.getString("player_name_message");
	private static final String OPPONENT_ALIAS_MESSAGE = resourceBundle.getString("opponent_name_message");
	private static final String ALIAS_ERROR_MESSAGE = resourceBundle.getString("name_error_message");
	
	public static String getWelcomeMessage() {
		return WELCOME_MESSAGE;
	}
	public static String getWinMessage() {
		return WIN_MESSAGE;
	}
	public static String getDrawMessage() {
		return DRAW_MESSAGE;
	}
	public static String getBlockMessage() {
		return BLOCK_MESSAGE;
	}
	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	public static String getPlayerAliasMessage() {
		return PLAYER_ALIAS_MESSAGE;
	}
	public static String getOpponentAliasMessage() {
		return OPPONENT_ALIAS_MESSAGE;
	}
	public static String getAliasErrorMessage() {
		return ALIAS_ERROR_MESSAGE;
	}
	
	
}
