/** This is a State class made for storing the state of an agent searching a
* graph (in the form of an adjacency matrix) using uninformed search techniques.
* @author 170018405
* @version Oct 12, 2018
*/
public class State
{
	// *** Field ***

	/**
	* This is the index of the location on the diagonal of the adjacency Matrix.
	* @param index - the index value represting the state of this object.
	*/
	private int index;

	// *** Constructor ***

	/** Creates a State Object using an index of a location on the diagonal of
 	* an adjacency Matrix.
	* @param indexIn  - the index value represting the state of this object.
	* @throws IllegalArgumentException if indexIn is a negative integer.
	*/
	public State(int indexIn) throws IllegalArgumentException
	{
		if (indexIn < 0)
		{
			throw new IllegalArgumentException ("indexIn cannot be negative");
		}
		index = indexIn;
	}

	// *** Methods ***

	/** Returns the index filed of the State Object.
	* @return the index value represting the state of this object.
	*/
	public int getIndex()
	{
		return index;
	}

	/** Returns the equivalent label of the State object where an index value.
	* of 0 corresponds to the label 'a' and 1 to 'b' etc.
	* @return character 'a' + index.
	*/
	public char getLabel()
	{
		return (char) ('a' + index);
	}

	/** Checks if a State Object o is equal to this State Object.
	* @param o - the State object to be compared with this Object.
	* @return true if both States' index values are equal and false otherwise.
	*/
	@Override
	public boolean equals(Object o)
	{
		if (!(o instanceof State)) return false;
		State stateIn = (State) o;
		if (index == stateIn.index) return true;
		return false;
	}

	/** Compares this State Objects to stateIn.
	* @param stateIn - the State object to be compared with this Object.
	* @return 0 if the index fields are equal, 1 if this State's index is
	* heigher, and -1 if this State's index is lower.
	*/
	public int compareTo(State stateIn)
	{
		if (index == stateIn.index) return 0;
		else if (index > stateIn.index) return 1;
		else return -1;
	}

	/** Returns a String of this Object's field.
	* @return String containing the label of the state of this Object in the
	* form "[Label: ]".
	*/
	@Override
	public String toString()
	{
		return "State: [Label: " + getLabel() + "]";
	}
}
