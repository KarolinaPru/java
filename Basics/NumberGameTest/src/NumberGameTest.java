
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;


public class NumberGameTest {	

	public static void main(String[] args) {

		Game numberGame = new Game();
		numberGame.start();
		numberGame.play();
	}
}

 class Game {
		
		private boolean deadline = true;
		private int howMany = 0;

		public void start() {

			ActionListener listener = new TimePrinter();

			Timer timer = new Timer(20000, listener);
			timer.start();
		}

		public void play(){

			System.out.println("Type the numbers you see on the screen as fast as you can. You've got 20 seconds. Go!");
			System.out.println();

			Random r = new Random(); 
			
			int[] randomNumbers = new int[30];
			
			for (int i = 0; i < randomNumbers.length; i++) {
				randomNumbers[i] = r.nextInt(1000);
				int randomNumber = randomNumbers[i];
				
				if (i < randomNumbers.length/2)
					System.out.print(randomNumber + " ");
				else if (i == randomNumbers.length/2)	{
					System.out.println();
					System.out.print(randomNumber + " ");
				} 
				else
					System.out.print(randomNumber + " ");	
			}
			
			System.out.println();

			while(deadline) {

				Scanner scn = new Scanner(System.in);
				int usersNumber = scn.nextInt();
				
				for (int j = 0; j < randomNumbers.length; j++) {
					if (usersNumber == randomNumbers[j]) 
						howMany++;
				}
			}
		}


		public class TimePrinter implements ActionListener {

			public void actionPerformed(ActionEvent event){

				deadline = false;
				System.out.println();
				System.out.println("You typed " + howMany + " numbers correctly.");
				System.exit(0);
			}		
		}
	}	




