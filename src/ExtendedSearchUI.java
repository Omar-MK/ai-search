import java.util.Arrays;

/** This class contains the main method and its helper methods which provides a
* command-line UI to operate the BiDirectional Search algorithm.
* @author 170018405
* @version Oct 12, 2018
*/
public class ExtendedSearchUI
{
	public static void main(String[] args)
	{
		System.out.println("\n*** This is the Bidirectional search path finder program by 170018405 ***");
		int optionChoice;
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
				case 1: mapChoice = UninformedSearchUI.option2();
				break;
				case 2: option2(mapChoice);
				break;
				case 3: break;
				default: System.out.println("Invalid choice, retry");
			}
		} while (optionChoice != 3);
		System.out.println("Goodbye! :)");
	}

	static void displayOptions()
	{
		System.out.println();
		System.out.println("1. Choose/Change map to solve");
		System.out.println("2. Start simulation");
		System.out.println("3. Exit program");
		System.out.println();
		System.out.print("Enter choice [1-3]: ");
	}

	static void option2(int mapNum)
	{
		char[] path; // output path
		int[][] selectedMap = Maps1.mapColl[mapNum - 1];
		int[][] selectedGrid = Maps2.locColl[mapNum - 1];
		int startIndex = UninformedSearchUI.getNumLoc(selectedMap, 2);
		int goalIndex = UninformedSearchUI.getNumLoc(selectedMap, 8);
		// perform BiDirectional Search
		path = ExtendedSearch.bidirectionalSearch(selectedMap, selectedGrid, startIndex, goalIndex);
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
}
