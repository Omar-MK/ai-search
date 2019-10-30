import java.util.Arrays;

/** This class contains the main method and its helper methods which provides a
* command-line UI to operate the Uninformed Search algorithms.
* @author 170018405
* @version Oct 12, 2018
*/
public class UninformedSearchUI
{
	public static void main(String[] args)
	{
		System.out.println("\n*** This is an uninformed-search path finder program by 170018405 ***");
		int optionChoice;
		boolean algChoice = false;
		int mapChoice = 1;
		// offer menu
		do
		{
			displayOptions();
			// get choice
			optionChoice = Keyboard.getInt();
			System.out.println();

			// process menu options
			switch (optionChoice)
			{
				case 1: algChoice = option1(algChoice);
				break;
				case 2: mapChoice = option2();
				break;
				case 3: option3(algChoice, mapChoice);
				break;
				case 4: option4(algChoice, mapChoice);
				break;
				case 5: break;
				default: System.out.println("Invalid choice, retry");
			}
		} while (optionChoice != 5);
		System.out.println("Goodbye! :)");
	}

	static void displayOptions()
	{
		System.out.println();
		System.out.print("1. Toggle search algorithm (BFS/DFS) ");
		System.out.println("(default is Breadth-First Search)");
		System.out.println("2. Choose/Change map to solve");
		System.out.println("3. Start simulation");
		System.out.println("4. Show current choices");
		System.out.println("5. Exit program");
		System.out.println();
		System.out.print("Enter choice [1-5]: ");
	}

	static boolean option1(boolean algChoice)
	{
		if (algChoice)
		{
			System.out.println("Breadth-First Search selected!");
			return false;
		}
		System.out.println("Depth-First Search selected!");
		return true;
	}

	static int option2()
	{
		int choice = 0;
		do
		{
			System.out.println("Enter a map number between 1-9");
			choice = Keyboard.getInt();
		} while (choice < 1 || choice > 9); // between chars '1' and '9'
		System.out.println("map " + choice + " successfully selected!");
		return choice;
	}

	static void option3(boolean algChoice, int mapNum)
	{
		char[] path;
		int[][] selectedMap = Maps1.mapColl[mapNum - 1];
		int startIndex = getNumLoc(selectedMap, 2);
		int goalIndex = getNumLoc(selectedMap, 8);
		// perform search with chosen algorithm
		if (algChoice)
		{
			path = UninformedSearch.DFS(selectedMap, startIndex, goalIndex);
		}
		else
		{
			path = UninformedSearch.BFS(selectedMap, startIndex, goalIndex);
		}
		// print the path if it is found
		if (path != null)
		{
			System.out.println("Path: " + Arrays.toString(path));
		}
		else
		{
			System.out.println("No path found!");
		}
	}

	static void option4(boolean algChoice, int mapNum)
	{
		if (algChoice)
		{
			System.out.println("Depth-First Search selected.");
		}
		else
		{
			System.out.println("Breadth-First Search selected.");
		}
		System.out.println("Map " + mapNum + " selected.");
	}

	/* searches for a given number (num) on the diagonal of a square matrix and
	 returns its index value if it is found or -1 otherwise. */
	static int getNumLoc(int[][] matrix, int num)
	{
		if (matrix.length != matrix[0].length) return -1;
		int result = -1;
		for (int i = 0; i < matrix.length; i ++)
		{
			if (matrix[i][i] == num) return i;
		}
		return result;
	}
}
