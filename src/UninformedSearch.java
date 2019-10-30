import java.util.*;

/** This class contains the uninformed search functions (Breadth-first and
* Depth-first search), as well as functions to print the frontier and explored
* lists.
* @author 170018405
* @version Oct 12, 2018
*/
public class UninformedSearch
{
	/** This function implements the Breadth-first search algorithm which uses
	* objects of the State and Node classes to compute a path between an
	* initial state and a goal state.
	* @param map - the adjacency Matrix of the environment to search.
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] BFS(int[][] map, int initIndex, int goalIndex)
	{
		// create initial and goal states
		State initState = new State(initIndex);
		State goalState = new State(goalIndex);
		// create the frontier and visited list/array
		LinkedList<Node> frontier = new LinkedList<Node>();
		boolean[] visitedArr = new boolean[map.length];
		/* create and add the initial node to the frontier and mark its
		 location as visited in the visitedArr */
		frontier.add(new Node(map, initState));
		visitedArr[initState.getIndex()] = true;
		// begin searching
		while(!frontier.isEmpty())
		{
			printFrontier(frontier);
			printExplored(visitedArr);
			// remove the first node in the queue
			Node currentNode = frontier.remove();
			// print the node removed from the queue
			System.out.println(currentNode);
			// check if the currentNode contains the goal state
			if (currentNode.getState().equals(goalState))
			return currentNode.getPath();
			// loop over each of currentNode's edges
			for (int i = 0; i < currentNode.getEdges().size(); i++)
			{
				/* check if edge at i is explored or in frontier, if
				 it is, skip to next iteration. Note that the visitedArr acts
				  as a tracker for both the nodes explored and the nodes
				   currently in the frontier. This way only the visitedArr
				    needs to be checked in the if statement below recuing the
					 complexity of needing to iterate over the queue to see if a
					 Node is present withinit*/
				if (visitedArr[currentNode.getEdges().get(i)])
				{
					continue;
				}
				/* if edge has not been visited, mark it in the visitedArr and
				 create child node then add it to frontier. */
				visitedArr[currentNode.getEdges().get(i)] = true;
				State childState = new State(currentNode.getEdges().get(i));
				Node childNode = new Node(map, currentNode, childState);
				frontier.add(childNode);
			}
		}
		// while loop exited b/c frontier empty :- no result is found.
		return null;
	}

	/** This function implements the Depth-first search algorithm which uses
	* objects of the State and Node classes to compute a path between an
	* initial state and a goal state.
	* @param map - the adjacency Matrix of the environment to search.
	* @param initIndex - the index of the initial State along the diagonal of
	* the Matrix.
	* @param goalIndex - the index of the goal State along the diagonal of the
	* Matrix.
	* @return a char array containing the path obtained by the function.
	*/
	static char[] DFS(int[][] map, int initIndex, int goalIndex)
	{
		// create initial and goal states
		State initState = new State(initIndex);
		State goalState = new State(goalIndex);
		// create the frontier and visited stack/array
		Stack<Node> frontier = new Stack<Node>();
		boolean[] visitedArr = new boolean[map.length];
		/* create add the initial node to the frontier and mark its location as
		 visited in the visitedArr */
		frontier.add(new Node(map, initState));
		visitedArr[initState.getIndex()] = true;
		// begin searching
		while(!frontier.isEmpty())
		{
			printFrontier(frontier);
			printExplored(visitedArr);
			// peek the last node in the stack
			Node currentNode = frontier.peek();
			// print the node peeked from the queue
			System.out.println(currentNode);
			// check if the currentNode contains the goal state
			if (currentNode.getState().equals(goalState))
			return currentNode.getPath();
			/* initialise foundUnvisited to false, when foundUnvisited becomes
			 true, the last node is not poped from the stack (frontier) */
			boolean foundUnvisited = false;
			// loop over currentNode's edges
			for (int i = 0; i < currentNode.getEdges().size(); i++)
			{
				/* check if edge at i is explored or in frontier, if
				 it is, skip to next iteration. */
				if (visitedArr[currentNode.getEdges().get(i)])
				{
					continue;
				}
				/* if edge has not been visited, mark it as visited and
				 create child node then add it to frontier. */
				visitedArr[currentNode.getEdges().get(i)] = true;
				State childState = new State(currentNode.getEdges().get(i));
				Node childNode = new Node(map, currentNode, childState);
				frontier.add(childNode);
				/* since an unvisited is found, we don't pop the last item in
				 the stack :- update foundUnvisited to true */
				foundUnvisited = true;
				break;
			}
			if (!foundUnvisited) frontier.pop();
		}
		// empty frontier :- no result is found.
		return null;
	}

	static void printFrontier(Queue<Node> frontier)
	{
		Object[] frontierArr = frontier.toArray();
		printFrontierHelper(frontierArr);
	}

	static void printFrontier(Stack<Node> frontier)
	{
		Object[] frontierArr = frontier.toArray();
		printFrontierHelper(frontierArr);
	}

	static void printFrontierHelper(Object[] frontierArr)
	{
		if (frontierArr.length > 0)
		{
			System.out.print("Frontier: [" +
			((Node) frontierArr[0]).getState().getLabel());
			for (int i = 1; i < frontierArr.length; i++)
			{
				System.out.print(", " +
				((Node) frontierArr[i]).getState().getLabel());
			}
			System.out.println("]");
		}
	}

	static void printExplored(boolean[] visitedArr)
	{
		System.out.print("Explored and in Frontier: [");
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
