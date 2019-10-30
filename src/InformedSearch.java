import java.util.*;

/** This class contains the informed search functions (Best-first and
* A* search) with both variants that use Euclidean and Chebyshev distance
* measures (4 in total). The class also contains helper functions such as the
* general search algorithm, functions to return CostStates based on which
* distance measure and search algorithm is being used, as well as the functions
* to calculate the distance itself.
* @author 170018405
* @version Oct 12, 2018
*/
public class InformedSearch
{
	/** This function returns a path between a start point and an end point in
	* an adjacency Matrix using the Best-first search algorithm combined with
	* the Euclidean distance measure.
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] BestFSEuc(int[][] map, int[][] gridMap, int initIndex,
	 int goalIndex)
	{
		return informedSearchHelper(1, map, gridMap, initIndex, goalIndex);
	}

	/** This function returns a path between a start point and an end point in
	* an adjacency Matrix using the Best-first search algorithm combined with
	* the Chebyshev distance measure.
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] BestFSCheb(int[][] map, int[][] gridMap, int initIndex,
	 int goalIndex)
	{
		return informedSearchHelper(2, map, gridMap, initIndex, goalIndex);
	}

	/** This function returns a path between a start point and an end point in
	* an adjacency Matrix using the A* search algorithm combined with
	* the Euclidean distance measure.
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] aStarSearchEuc(int[][] map, int[][] gridMap, int initIndex,
	 int goalIndex)
	{
		return informedSearchHelper(3, map, gridMap, initIndex, goalIndex);
	}

	/** This function returns a path between a start point and an end point in
	* an adjacency Matrix using the A* search algorithm combined with
	* the Chebyshev distance measure.
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] aStarSearchCheb(int[][] map, int[][] gridMap, int initIndex,
	 int goalIndex)
	{
		return informedSearchHelper(4, map, gridMap, initIndex, goalIndex);
	}

	/** This function contains the general search algorithm used by the above
	* functions. The function contains a switch statement which allows it to
	* adapt the way it creates its child states based on the search-algorithm
	* and the distance measure required.
	* @param algChoice - the number used by the switch statement to adapt the
	* solution to the algorithm and distance measures required
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	private static char[] informedSearchHelper(int algChoice, int[][] map,
	 int[][] gridMap, int initIndex, int goalIndex)
	{
		// create initial and goal states
		CostState initState = new CostState(initIndex);
		CostState goalState = new CostState(goalIndex);
		// create the frontier and visited list/array
		PriorityQueue<CostNode> frontier = new PriorityQueue<CostNode>();
		boolean[] visitedArr = new boolean[map.length];
		// create add the initial node to the frontier and visitedArr
		frontier.add(new CostNode(map, initState));
		visitedArr[initState.getIndex()] = true;
		// begin searching
		while(!frontier.isEmpty())
		{
			printFrontier(frontier);
			UninformedSearch.printExplored(visitedArr);
			// remove the first node in the queue
			CostNode currentNode = frontier.poll();
			// print the node removed from the queue
			System.out.println(currentNode);
			// check if the currentNode contains the goal state
			if (currentNode.getState().equals(goalState))
			return currentNode.getPath();
			// loop over each of currentNode's edges
			for (int i = 0; i < currentNode.getEdges().size(); i++)
			{
				/* check if edge at i is explored or in frontier */
				if (visitedArr[currentNode.getEdges().get(i)])
				{
					continue;
				}
				// if edge has not been visited, mark it as visited
				visitedArr[currentNode.getEdges().get(i)] = true;
				// create child node then add it to frontier.
				// initialise childState to any State object.
				CostState childState = initState;
				switch (algChoice)
				{
					case 1: childState = getChildStateBestFSEuc(gridMap,
					 currentNode, goalState, i);
					break;
					case 2: childState = getChildStateBestFSCheb(gridMap,
					 currentNode, goalState, i);
					break;
					case 3: childState = getChildStateAStarEuc(gridMap,
					 currentNode, goalState, i);
					break;
					case 4: childState = getChildStateAStarCheb(gridMap,
					 currentNode, goalState, i);
					break;
				}
				CostNode childNode = new CostNode(map, currentNode, childState);
				frontier.add(childNode);
			}
		}
		// while loop exited b/c frontier empty :- no result is found.
		return null;
	}

	static CostState getChildStateBestFSEuc(int[][] gridMap,
	 CostNode currentNode, CostState goalState, int i)
	{
		// create a CostState Object
		CostState childState = new CostState(currentNode.getEdges().get(i));
		// Set the heuristicCost field of the CostState Object
		childState.setHCost(calcEucDist(gridMap, childState.getIndex(),
		 goalState.getIndex()));
		return childState;
	}

	static CostState getChildStateBestFSCheb(int[][] gridMap,
	 CostNode currentNode, CostState goalState, int i)
	{
		// create a CostState Object
		CostState childState = new CostState(currentNode.getEdges().get(i));
		// Set the heuristicCost field of the CostState Object
		childState.setHCost(calcChebDist(gridMap, childState.getIndex(),
		 goalState.getIndex()));
		return childState;
	}

	static CostState getChildStateAStarEuc(int[][] gridMap,
	 CostNode currentNode, CostState goalState, int i)
	{
		/* create a CostState Object with the heuristic cost already calculated
		 using the getChildStateBestFSEuc method. */
		CostState childState = getChildStateBestFSEuc(gridMap, currentNode,
		 goalState, i);
		/* Set the path cost. The path cost is path cost of previous node
		 state + path cost to next node */
		double pathCost = currentNode.getState().getPCost() +
		  calcEucDist(gridMap, currentNode.getState().getIndex(),
		   childState.getIndex());
		childState.setPCost(pathCost);
		return childState;
	}

	static CostState getChildStateAStarCheb(int[][] gridMap,
	 CostNode currentNode, CostState goalState, int i)
	{
		/* create a CostState Object with the heuristic cost already calculated
		 using the getChildStateBestFSCheb method. */
		CostState childState = getChildStateBestFSCheb(gridMap, currentNode,
		 goalState, i);
		/* Set the path cost. The path cost is still calculated using Euclidean
		 distance */
		double pathCost = currentNode.getState().getPCost() +
		  calcEucDist(gridMap, currentNode.getState().getIndex(),
		   childState.getIndex());
		childState.setPCost(pathCost);
		return childState;
	}

	// This function calculates the Euclidean distance between two points
	static double calcEucDist(int[][] gridMap, int point1Index,
	 int point2Index)
	{
		int p1X = gridMap[point1Index][0];
		int p1Y = gridMap[point1Index][1];
		int p2X = gridMap[point2Index][0];
		int p2Y = gridMap[point2Index][1];
		return Math.sqrt(Math.pow((p2X - p1X), 2) +
		 Math.pow((p2Y - p1Y), 2));
	}

	// This function calculates the Chebyshev distance between two points
	static double calcChebDist(int[][] gridMap, int point1Index,
	 int point2Index)
	{
		int p1X = gridMap[point1Index][0];
		int p1Y = gridMap[point1Index][1];
		int p2X = gridMap[point2Index][0];
		int p2Y = gridMap[point2Index][1];
		return Math.max(Math.abs(p2X - p1X), Math.abs(p2Y - p1Y));
	}

	static void printFrontier(PriorityQueue<CostNode> frontier)
	{
		Object[] frontierArr = frontier.toArray();
		if (frontierArr.length > 0)
		{
			System.out.print("Frontier: [" +
			((CostNode) frontierArr[0]).getState().getLabel());
			for (int i = 1; i < frontierArr.length; i++)
			{
				System.out.print(", " +
				((CostNode) frontierArr[i]).getState().getLabel());
			}
			System.out.println("]");
		}
	}
}
