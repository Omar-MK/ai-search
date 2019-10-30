import java.util.*;

/** This class contains the bidirectional informed search function (A* search
* using Euclidean) requested for part 3. The class also contains the helper
* functions such as the successor and goal check functions.
* @author 170018405
* @version Oct 12, 2018
*/
public class ExtendedSearch
{
	/** This function returns a path between a start point and an end point in
	* an adjacency Matrix using a bidirectional A* search algorithm combined
	* with the Euclidean distance measure.
	* @param map - the adjacency Matrix of the environment to search.
	* @param gridMap - an adjacency list of the x and y coordinates of the
	* points in map
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] bidirectionalSearch(int[][] map, int[][] gridMap, int initIndex, int goalIndex)
	{
		// create initial and goal states + nodes
		CostState initState = new CostState(initIndex);
		CostState goalState = new CostState(goalIndex);
		CostNode initNode = new CostNode(map, initState);
		CostNode goalNode = new CostNode(map, goalState);
		// create 2 frontiers and 2 visited arrays
		PriorityQueue<CostNode> frontier1 = new PriorityQueue<CostNode>();
		PriorityQueue<CostNode> frontier2 = new PriorityQueue<CostNode>();
		boolean[] visitedArr1 = new boolean[map.length];
		boolean[] visitedArr2 = new boolean[map.length];
		// add the initial node to frontier1 and goal node to frontier2
		frontier1.add(initNode);
		frontier2.add(goalNode);
		/* initialise currentNode1 and currentNode2 so the goal state can be
		 tested on the first iteration */
		CostNode currentNode1 = initNode;
		CostNode currentNode2 = goalNode;
		char[] path = null;
		// begin searching
		while(!frontier1.isEmpty() && !frontier2.isEmpty())
		{
			// print both frontiers and explored lists
			System.out.print("Start path ");
			InformedSearch.printFrontier(frontier1);
			printExplored(visitedArr1);
			System.out.print("End path ");
			InformedSearch.printFrontier(frontier2);
			printExplored(visitedArr2);
			// remove the first node in frontier1 and record as explored
			currentNode1 = frontier1.poll();
			visitedArr1[currentNode1.getState().getIndex()] = true;
			// check if the visited lists overlap (goal met)
			path = checkGoal(visitedArr1, visitedArr2, currentNode1,
			 currentNode2);
			if (path != null) return path;
			// print the node removed from the queue
			System.out.println("Start path " + currentNode1);
			// remove the first node in frontier2 and record as explored
			currentNode2 = frontier2.poll();
			visitedArr2[currentNode2.getState().getIndex()] = true;
			// print the node removed from the queue
			System.out.println("End path " + currentNode2);
			// call successor-fns for both currentNode1 and currentNode2
			successor(frontier1, visitedArr1, map, gridMap, currentNode1,
			 goalNode);
			successor(frontier2, visitedArr2, map, gridMap, currentNode2,
			 initNode);
		}
		// while loop exited b/c frontier empty :- no result is found.
		return null;
	}

	static void successor(PriorityQueue<CostNode> frontier, boolean[] visitedArr, int[][] map, int[][] gridMap, CostNode currentNode, CostNode goalNode)
	{
		// loop over currentNode's edges
		for (int i = 0; i < currentNode.getEdges().size(); i++)
		{
			/* check if edge at i is explored, if it is, skip to next
			 iteration. */
			if (visitedArr[currentNode.getEdges().get(i)])
			{
				continue;
			}
			// create a new Node and add it to the frontier
			CostState childState =
			 InformedSearch.getChildStateAStarEuc(gridMap, currentNode,
			  goalNode.getState(), i);
			CostNode childNode = new CostNode(map, currentNode, childState);
			frontier.add(childNode);
		}
	}

	static char[] checkGoal(boolean[] visitedArr1, boolean[] visitedArr2,
	 CostNode currentNode1, CostNode currentNode2)
	{
		// iterate over the elements in the explored arrays
		for (int i = 0; i < visitedArr1.length; i++)
		{
			/* if there is an element where both arrays show true, then there
			 is a meeting of paths */
			if (visitedArr1[i] == true && visitedArr2[i] == true)
			{
				/* check which of currentNode1 and currentNode2 has a state
				 with an index value of i */
				if (currentNode2.getState().getIndex() == i)
				{
					/* Agent 1 must have moved to the next node, so needs to be
					 reversed to the node at i */
					Node oldNode1 =
					 currentNode1.getParent(currentNode2.getState());
					// merge the paths of both Agent 1 and 2 and return
					return mergePaths(oldNode1.getPath(), currentNode2.getPath());
				}
				else if (currentNode1.getState().getIndex() == i)
				{
					/* Agent 2 must have moved to the next node, so needs to be
					 reversed to the node at i */
					Node oldNode2 = currentNode2.getParent(currentNode1.getState());
					// merge the paths of both Agent 1 and 2 and return
					return mergePaths(currentNode1.getPath(), oldNode2.getPath());
				}
			}
		}
		return null;
	}

	/* This function merges two char arrays that overlap 1 element in the
	 middle. */
	static char[] mergePaths(char[] path1, char[] path2)
	{
		char[] combinedPath = new char[path1.length + path2.length - 1];
		// add path1 to combinedPath
		for (int i = 0; i < path1.length; i++)
		{
			combinedPath[i] = path1[i];
		}
		// add path2 to combinedPath
		for (int i = 1, j = path2.length - 2; i < path2.length; i++, j--)
		{
			combinedPath[i + path1.length - 1] = path2[j];
		}
		return combinedPath;
	}

	static void printExplored(boolean[] visitedArr)
	{
		System.out.print("Explored: [");
		for (int i = 0; i < visitedArr.length - 1; i++)
		{
			if (visitedArr[i])
			{
				System.out.print((char) ('a' + i) + ", ");
			}
			else
			{
				System.out.print(", ");
			}
		}
		if (visitedArr[visitedArr.length - 1])
		{
			System.out.print((char) ('a' + visitedArr.length - 1));
		}
		System.out.println("]");
	}
}
