import java.util.Random;
import java.util.Scanner;

public class ShingShangShong{
	public static void main(String[] args){
		String input;
		String computer;
		String player;
		int value;
		boolean won = false;
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		value = random.nextInt(3)+1;
		
		System.out.println("Please insert \"scissors\" , \"stone\" or \"paper\"\n");
		player = scanner.next();

		switch(value){
			case 1:
				computer = "scissors";
				break;
			case 2:
				computer = "stone";
				break;
			case 3:
				computer = "paper";
				break;
			default:
				throw new IllegalArgumentException();	
		}

		if (!(player.equals("scissors") || player.equals("stone") || player.equals("paper")))
			throw new IllegalArgumentException();

		if(player.equals(computer)){
			System.out.println("Computer -> " + computer + "   " + player + " <- Player");
			System.out.println("no winner");
			System.exit(0);
		}
		if(player.equals("scissors") && computer.equals("paper"))
			won = true;
		if(player.equals("stone") && computer.equals("scissors"))
			won = true;
		if(player.equals("paper") && computer.equals("stone"))
			won = true;
		if(won){
			System.out.println("Computer -> " + computer + "   " + player + " <- Player");
			System.out.println("Player has won.");
		}
		else{
			System.out.println("Computer -> " + computer + "   " + player + " <- Player");
			System.out.println("Computer has won.");
		}
	}
}
