package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list to hold the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/**
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/**
	 * Holds the single instance of GameService
	 */
	private static GameService instance = new GameService();

	/**
	 * Private constructor to prevent instantiation
	 */
	private GameService() {
	}

	/**
	 * Returns the singleton instance of the GameService
	 * 
	 * @return instance the single instance of GameService
	 */
	public static GameService getInstance() {
		return instance;
	}

	/**
	 * Construct a new game instance
	 * Add a game with a unique name. If the game exists, we'll use the existing one.
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {
		// First, check if the game already exists
		for (Game existingGame : games) {
			if (existingGame.getName().equalsIgnoreCase(name)) {
				return existingGame; // Return the existing instance
			}
		}
		// If not found, make a new game instance and add to the list of games
		Game game = new Game(nextGameId++, name);
		games.add(game);
		return game; // Return the new game instance
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		for (Game game : games) {
			if (game.getId() == id) {
				return game; // Return the existing game
			}
		}
		return null; // If no game found, return null
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {
		for (Game game : games) {
			if (game.getName().equalsIgnoreCase(name)) {
				return game; // Return the existing game
			}
		}
		return null; // If no game found, return null
	}

	/**
	 * Returns the number of games currently active.
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
