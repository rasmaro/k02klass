import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Map {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void showForPlayer(Character character, List<Character> characters) {
		clearScreen();
		
		for(int y = character.y+10; y >= character.y-10; y--) {
			for(int x = character.x-10; x < character.x+10; x++) {
				String mapBlip = " . ";
				if(x == character.x && y == character.y) {
					mapBlip = ANSI_GREEN+" "+character.name.charAt(0)+" "+ANSI_RESET;
				} else {
					for (Iterator<Character> i = characters.iterator(); i.hasNext();) {
						Character player = i.next();
						if(x == player.x && y == player.y) mapBlip =  ANSI_YELLOW+" "+player.name.charAt(0)+" "+ANSI_RESET;
					}
				}
				System.out.print(mapBlip);
			}
			System.out.println("");
		}
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}