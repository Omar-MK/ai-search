import java.util.ArrayList;

/** This is a Node class made for instantiating graph Node Objects for
* searching undirected graphs (in the form of adjacency Matricies) using
* uninformed search techniques.
* @author 170018405
* @version Oct 12, 2018
*/
public class Node
{
	// *** Fields ***

	/** The state of the agent at this Node. */
	private State myState;
	/** The parent Node of this Node Object. Used to track the path of the
	* agent. */
	private Node parentNode;
	/** The depth of this Node in the search problem. This depth field
	* represents the number of parent Nodes this Node keeps track of. */
	private int depth;
	/** A list of the index locations of the vertices that connect to this Node
	* on the graph.*/
	private ArrayList<Integer> edges;

	// *** Constructors ***

	/** Creates an initial Node Object using a State and an adjacency Matrix of
	* the graph.
	* @param map  - the adjacency Matrix of the search space or graph.
	* @param stateIn - the state of the agent to be stored at this Node.
	*/
	public Node(int[][] map, State stateIn)
	{
		myState = stateIn;
		edges = findEdges(map);
	}

	/** Creates a child Node Object using a State, adjacency Matrix of the
	* graph, and a parent Node Object.
	* @param map  - the adjacency Matrix of the search space or graph.
	* @param parentNodeIn - the parent Node of this Node object.
	* @param stateIn - the state of the agent to be stored at this Node.
	*/
	public Node(int[][] map, Node parentNodeIn, State stateIn)
	{
		myState = stateIn;
		parentNode = parentNodeIn;
		depth = parentNodeIn.depth + 1;
		edges = findEdges(map);
	}

	// *** methods ***

	/** Returns the State at this Node Object.
	* @return the State at this Node Object.
	*/
	public State getState()
	{
		return myState;
	}

	/** Returns the direct (next) parent Node of this Node Object.
	* @return the direct (next)parent Node of this Node Object or null in the
	* absence of a parent.
	*/
	public Node getParent()
	{
		return parentNode;
	}

	/** Returns a parent Node of this Node Object that has the same State as
	* stateIn.
	* @param stateIn - the state to be contained in the parent Node returned.
	* @return the parent Node of this Node Object that has the same State as
	* stateIn or null in the absence of a parent with a matching state.
	*/
	public Node getParent(State stateIn)
	{
		Node parent = this;
		while (!parent.getState().equals(stateIn))
		{
			parent = parent.getParent();
			if (parent == null)
			{
				return parent;
			}
		}
		return parent;
	}

	/** Returns an ArrayList containing the edges of this Node Object.
	* @return ArrayList containing the edges of this Node Object.
	*/
	public ArrayList<Integer> getEdges()
	{
		return edges;
	}

	/** Returns a char array containing the labels of this Node Object as well
	* as each of it's parents starting from the first parent.
	* @return  - a char array containing the labels of this Node Object as well
	* as each of it's parents starting from the first parent.
	*/
	public char[] getPath()
	{
		// create a new charArr the size of depth + 1
		char[] pathArr = new char[depth + 1];
		// place the label of this Node at the end of the array
		pathArr[depth] = myState.getLabel();
		if (parentNode == null) return pathArr;
		// get the path array of the Parent Node (repeating the above process)
		char[] parentPathArr = parentNode.getPath();
		// merge pathArr and parentPathArr together
		for (int i = depth - 1; i > -1; i--)
		{
			pathArr[i] = parentPathArr[i];
		}
		return pathArr;
	}

	/** Checks if a Node Object o is equal to this Node Object using their
	* State fields for comparison.
	* @param o - the Node object to be compared with this Object.
	* @return true if both Nodes' State's are equivalent and false otherwise.
	*/
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof Node)) return false;
		Node nodeIn = (Node) o;
		if (myState.equals(nodeIn.myState)) return true;
		return false;
	}

	/** Returns a String of this Object's fields.
	* @return String containing the State of this Node, it's depth, edges, and
	* parent Node(s).
	*/
	@Override
	public String toString()
	{
		String edgesString = "";
		if (edges != null)
		{
			edgesString += edges.get(0);
			for (int i = 1; i < edges.size(); i++)
			{
				edgesString += ", " + edges.get(i);
			}
		}
		if (parentNode == null)
		{
			return "Node: {\n    " + myState + "    Depth: " + depth +
			 "    Edges: [" + edgesString + "]\n}\n";
		}
		else
		{
			return "Node: {\n    " + myState + "    Depth: " + depth +
			 "    Edges: [" + edgesString +
			  "]\n} Parent-" + parentNode;
		}
	}

	private ArrayList<Integer> findEdges(int[][] map)
	{
		// create output array list to store connections
		ArrayList<Integer> output = new ArrayList<Integer>();
		/* iterate over only a single axis (the row) since paths are
		 un-directional */
		for (int i = 0; i < map.length; i++)
		{
			if (map[myState.getIndex()][i] == 5)
			{
				/* add only a single index to represent the node's index on
				 the map since its index will be [i][i] */
				output.add(i);
			}
		}
		return output;
	}

}
