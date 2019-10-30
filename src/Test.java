import java.util.*;

public class Test
{
	public static void main(String[] args)
	{
		// State tests
		System.out.println("Making states: ");
		CostState one = new CostState(1);
		one.setHCost(0.1);
		one.setPCost(1.1);
		System.out.println(one);

		CostState two = new CostState(3);
		two.setHCost(3);
		two.setPCost(4.5);
		System.out.println(two);

		CostState three = new CostState(5);
		three.setHCost(0.3);
		three.setPCost(0.1);
		System.out.println(three);

		// compare states
		System.out.println("Comparing states: ");
		System.out.println(one.compareTo(one));
		System.out.println(one.compareTo(two));
		System.out.println(one.compareTo(three));
		System.out.println(two.compareTo(one));
		System.out.println(two.compareTo(two));
		System.out.println(two.compareTo(three));
		System.out.println(three.compareTo(one));
		System.out.println(three.compareTo(two));
		System.out.println(three.compareTo(three));

		// Node tests
		System.out.println("Making nodes: ");
		CostNode start = new CostNode(Maps1.map6, two);
		System.out.println(start);

		CostNode another = new CostNode(Maps1.map6, one);
		System.out.println(another);

		CostNode third = new CostNode(Maps1.map6, three);
		System.out.println(third);

		// compare nodes
		System.out.println("Comparing nodes: ");
		System.out.println(start.compareTo(start));
		System.out.println(start.compareTo(another));
		System.out.println(start.compareTo(third));
		System.out.println(another.compareTo(start));
		System.out.println(another.compareTo(another));
		System.out.println(another.compareTo(third));
		System.out.println(third.compareTo(start));
		System.out.println(third.compareTo(another));
		System.out.println(third.compareTo(third));
		//
		// // test getPath method
		// System.out.println("Testing get path method: ");
		// char[] array = start.getPath();
		// System.out.println(Arrays.toString(array));
		//
		// array = third.getPath();
		// System.out.println(Arrays.toString(array));
		//
		// // testing distance calc methods
		// System.out.println("Testing distance calc methods: ");
		// System.out.println(Search.calcEucDist(Maps2.locColl[0], 0, 13));
		// System.out.println(Search.calcChebDist(Maps2.locColl[0], 0, 13));


		// System.out.println("Testing List sorting: ");
		// // testing sort with ArrayList implementing comparable in Node and State
		ArrayList<CostNode> stateList = new ArrayList<CostNode>();
		stateList.add(third); stateList.add(start); stateList.add(another);
		System.out.print("ArrayList unsorted: ");
		printList(stateList);
		Collections.sort(stateList);
		System.out.print("ArrayList sorted: ");
		printList(stateList);

		// // testing sort with LinkedList
		// LinkedList<Node> nodeList = new LinkedList<Node>();
		// nodeList.add(start); nodeList.add(another); nodeList.add(third);
		// System.out.print("LinkedList unsorted: ");
		// Search.printFrontier(nodeList);
		// Collections.sort(nodeList);
		// System.out.print("LinkedList sorted: ");
		// Search.printFrontier(nodeList);

		// testing PriorityQueue
		PriorityQueue<CostNode> pNodeList = new PriorityQueue<CostNode>();
		pNodeList.add(third); pNodeList.add(start); pNodeList.add(another);
		InformedSearch.printFrontier(pNodeList);
		// System.out.println(pNodeList.poll());
		// System.out.println(pNodeList.poll());
		// System.out.println(pNodeList.poll());

		//CostNode wrapperNode = new CostNode(two);
		//System.out.println(wrapperNode);
		//System.out.println(pNodeList.contains(wrapperNode));

	}

	static void printList(ArrayList<CostNode> objList)
	{
		for (int i = 0; i < objList.size(); i++)
		{
			System.out.print(objList.get(i) + " ");
		}
		System.out.println();
	}
}
