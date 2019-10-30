import java.util.Arrays;

/** This class contains the main method and its helper methods which provides a
* command-line UI to operate the Informed Search algorithms (excluding
* bidirectional search).
* @author 170018405
* @version Oct 12, 2018
*/
public class InformedSearchUI
{
	public static void main(String[] args)
	{
		System.out.println("\n*** This is an Informed-search path finder program by 170018405 ***");
		int optionChoice;
		boolean algChoice = false;
		boolean heuristicChoice = false;
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
				case 2: heuristicChoice = option2(heuristicChoice);
				break;
				case 3: mapChoice = UninformedSearchUI.option2();
				break;
				case 4: option3(algChoice, heuristicChoice, mapChoice);
				break;
				case 5: option4(algChoice, heuristicChoice, mapChoice);
				break;
				case 6: break;
				default: System.out.println("Invalid choice, retry");
			}
		} while (optionChoice != 6);
		System.out.println("Goodbye! :)");
	}

	static void displayOptions()
	{
		System.out.println();
		System.out.print("1. Toggle search algorithm (BestFS/A*S) ");
		System.out.println(" default is Best-First Search");
		System.out.print("2. Toggle heuristic (Euclidean/Chebyshev) ");
		System.out.println(" default is Euclidean");
		System.out.println("3. Choose/Change map to solve");
		System.out.println("4. Start simulation");
		System.out.println("5. Show current choices");
		System.out.println("6. Exit program");
		System.out.println();
		System.out.print("Enter choice [1-6]: ");
	}

	static boolean option1(boolean algChoice)
	{
		if (algChoice)
		{
			System.out.println("Best-First Search selected!");
			return false;
		}
		System.out.println("A* Search selected!");
		return true;
	}

	static boolean option2(boolean heuristicChoice)
	{
		if (heuristicChoice)
		{
			System.out.println("Euclidean distance selected!");
			return false;
		}
		System.out.println("Chebyshev distance selected!");
		return true;
	}

	static void option3(boolean algChoice, boolean heuristicChoice, int mapNum)
	{
		char[] path; // output path
		int[][] selectedMap = Maps1.mapColl[mapNum - 1];
		int[][] selectedGrid = Maps2.locColl[mapNum - 1];
		int startIndex = UninformedSearchUI.getNumLoc(selectedMap, 2);
		int goalIndex = UninformedSearchUI.getNumLoc(selectedMap, 8);
		// perform search with chosen algorithm
		if (algChoice && !heuristicChoice)
		{
			path = InformedSearch.aStarSearchEuc(selectedMap, selectedGrid,
			 startIndex, goalIndex);
		}
		else if (algChoice && heuristicChoice)
		{
			path = InformedSearch.aStarSearchCheb(selectedMap, selectedGrid,
			 startIndex, goalIndex);
		}
		else if (!algChoice && heuristicChoice)
		{
			path = InformedSearch.BestFSCheb(selectedMap, selectedGrid, startIndex, goalIndex);
		}
		else
		{
			path = InformedSearch.BestFSEuc(selectedMap, selectedGrid, startIndex, goalIndex);
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

	static void option4(boolean algChoice, boolean heuristicChoice, int mapNum)
	{
		if (algChoice)
		{
			System.out.println("A* Search selected.");
		}
		else
		{
			System.out.println("Best-First Search selected.");
		}
		if (heuristicChoice)
		{
			System.out.println("Chebyshev distance selected.");
		}
		else
		{
			System.out.println("Euclidean distance selected.");
		}
		System.out.println("Map " + mapNum + " selected.");
	}
}
