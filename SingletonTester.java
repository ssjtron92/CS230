package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author coce@snhu.edu
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		// Obtain local reference to the singleton instance
		GameService service = GameService.getInstance();
		
		// a simple for loop to iterate through the game IDs
		for (long id = 1; id <= service.getGameCount(); id++) {
			Game game = service.getGame(id);
			if (game != null) {
				System.out.println(game);
			} else {
				System.out.println("Game with ID " + id + " not found.");
			}
		}
}
	
}
