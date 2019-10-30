import java.util.ArrayList;

/** This is a Node class made for instantiating graph Node Objects for
* searching undirected graphs (in the form of adjacency Matricies) using
* uninformed search techniques. This class extends Node and is made to work
* with CostState Objects.
* @author 170018405
* @version Oct 12, 2018
*/
public class CostNode extends Node implements Comparable<CostNode>
{
	// *** Constructors ***

	public CostNode(int[][] map, CostState stateIn)
	{
		super(map, stateIn);
	}

	public CostNode(int[][] map, CostNode parentNodeIn, CostState stateIn)
	{
		super(map, parentNodeIn, stateIn);
	}

	// *** methods ***

	@Override
	public CostState getState()
	{
		return (CostState) super.getState();
	}

	/** Compares 2 CostNode objects using their CostState's compareTo method.
	* @return 0 if the CostNodes' CostStates are equivalent, 1 if
	* this Object's CostNode's CostState is more than nodeIn's CostState, and
	* -1 otherwise
	*/
	public int compareTo(CostNode nodeIn)
	{
		return getState().compareTo(nodeIn.getState());
	}
}
