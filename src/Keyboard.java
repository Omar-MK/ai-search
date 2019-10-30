import java.util.*;

/** This class contains mathods used to get user inputs from the command line.
* @author 170018405
* @version Oct 12, 2018
*/
public class Keyboard
{
	public static int getInt()
	{
		while (true)
		{
			Scanner input = new Scanner(System.in);
			if (input.hasNextInt()) return input.nextInt();
			else System.out.println("Please enter an integer");
		}
	}

	public static char getChar()
	{
		Scanner input = new Scanner(System.in);
		return input.next().charAt(0);
	}

	public static String getString()
	{
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
}
