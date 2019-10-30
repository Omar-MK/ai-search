/** This is a CostState class made for storing the state of an agent searching a
* graph (in the form of an adjacency matrix) using informed search techniques.
* @author 170018405
* @version Oct 12, 2018
*/
public class CostState extends State implements Comparable<CostState>
{
	// *** Fields ***

	/** The predicted cost to the goal state. */
	private double heuristicCost;
	/** The path cost so far towards the goal state. */
	private double pathCost;

	// *** Constructor ***

	/** Creates a CostState Object using an index of a location on the diagonal
	* of an adjacency Matrix.
	* @param indexIn  - the index value represting the location state of this
	* object.
	* @throws IllegalArgumentException if indexIn is a negative integer.
	*/
	public CostState(int indexIn) throws IllegalArgumentException
	{
		super(indexIn);
	}

	// *** Methods ***

	/** Sets the heuristicCost field of the CostState Object.
	* @param costIn the heuristic cost to be stored in the CostState object.
	*/
	public void setHCost(double costIn)
	{
		heuristicCost = costIn;
	}

	/** Sets the pathCost field of the CostState Object.
	* @param costIn the path cost to be stored in the CostState object.
	*/
	public void setPCost(double costIn)
	{
		pathCost = costIn;
	}

	/** Returns the path cost of this CostState Object.
	* @return the path cost of this CostState Object.
	*/
	public double getPCost()
	{
		return pathCost;
	}

	/** Compares this CostState Object to stateIn using the cost fields.
	* @return 0 if the total cost is equal, 1 if this CostState's total cost is
 	* heigher, and -1 if this CostState's total cost is lower.
	*/
	@Override
	public int compareTo(CostState stateIn)
	{
		double totCost = pathCost + heuristicCost;
		if (totCost == (stateIn.pathCost + stateIn.heuristicCost) && getIndex() == stateIn.getIndex()) return 0;
		else if (totCost == (stateIn.pathCost + stateIn.heuristicCost) && getIndex() > stateIn.getIndex()) return 1;
		else if (totCost == (stateIn.pathCost + stateIn.heuristicCost) && getIndex() < stateIn.getIndex()) return -1;
		else if (totCost > (stateIn.pathCost + stateIn.heuristicCost)) return 1;
		else return -1;
	}

	/** Returns a String of the data contained in this Object's fields.
	* @return String containing the label and costs of this Object's state in
	* the form "[Label: , Path-cost: , Heuristic-cost: , Total-cost: ]".
	*/
	@Override
	public String toString()
	{
		if (pathCost > 0.0 && heuristicCost > 0.0)
		{
			return "State: [Label: " + getLabel() + ", Path-cost: " + pathCost +
			 ", Heuristic-cost: " + heuristicCost + ", Total-cost: " +
			  (pathCost + heuristicCost) + "]";
		}
		else if (pathCost > 0.0)
		{
			return "State: [Label: " + getLabel() + ", Path-cost: " + pathCost +
			 "]";
		}
		else if (heuristicCost > 0.0)
		{
			return "State: [Label: " + getLabel() + ", Heuristic-cost: " +
		 	 heuristicCost + "]";
		}
		else return super.toString();
	}

}
