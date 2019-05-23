import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {
		Character juku = new Character("Juku", CharType.PLAYER);
		Character kati = new Character("Kati", CharType.PLAYER);
		List<Character> players = new ArrayList<>();
		players.add(juku);
		players.add(kati);

		Boolean breakWhile = false;
		Scanner reader = new Scanner(System.in);

		while(!breakWhile) {

			for (Iterator<Character> i = players.iterator(); i.hasNext();) {
				Character player = i.next();
				Map.showForPlayer(player, players);
				Scanner scan = new Scanner(System.in);
				System.out.println("["+player.name+"] Sisesta suund (WASD): ");
				String input = scan.next().charAt(0)+"";
				input = input.toLowerCase();

				if(input.equals("a")) { player.setDirection(Direction.LEFT); player.move(); }
				else if(input.equals("d")) { player.setDirection(Direction.RIGHT); player.move(); }
				else if(input.equals("w")) { player.setDirection(Direction.UP); player.move(); }
				else if(input.equals("s")) { player.setDirection(Direction.DOWN); player.move(); }
				else if(input.length() <= 0) { player.move(); }

				for (Iterator<Character> x = players.iterator(); x.hasNext();) {
					Character otherPlayer = x.next();
					if(otherPlayer.name == player.name) continue;

					if(otherPlayer.x == player.x && otherPlayer.y == player.y) {
						System.out.println(player.name+" asub samas kohas kus "+ otherPlayer.name);
						System.out.println("Ja nad elasid koos õnnelikult elu lõpuni.");
						breakWhile = true;
					}
				}

				if(breakWhile) break;
			}
		}

		reader.close();
	}
}