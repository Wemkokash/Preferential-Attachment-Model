import java.util.HashMap;
import java.util.LinkedList<E>;

public class powerLaw {

	public static void PAmodel(int numIterations) {

		int totalEdges = 1;
		int totalNodes = 2;

		//two Hash Maps, one that keeps track of which nodes link to each other, 
		//one that keeps track of how many connections each node has
		new HashMap edgeNumMap = HashMap();
		new HashMap connectionMap = HashMap();

/*
//is this necessary?

		//LinkedList to put in every new node's connectionMap value
		LinkedList<Integer> connections = new LinkedList<Integer>();

*/
		//both start with one connection (nodes 0 and 1)
		edgeNumMap.put(0, 1);
		edgeNumMap.put(1, 1);

		//(x, y)
		//in the connection map, for the node x link to 
		//linked list with argument y in it 

//not sure about this
		connectionMap.put(0, new LinkedList<Integer>(1));
		connectionMap.put(1, new LinkedList<Integer>(0));



		//variable to keep track of what # node to add to model
		//(since we already added some, the numStartingNodes)
		int newNodeNum = numStartingNodes;

		//IMPORTANT FOR LOOP here
		//This is where we do the big boy work.
		for(i = 0; i < numIterations; i++) {

			//for each old node, calculate probability that the new node connects to it
				//for loop for calculating probabilities

			//random int for number of sum of numerators of probabilites

			//add edges using newNodeNum and node calculated above

			//iterate newNodeNum

		}


	};

	

	public static void main() {

	};



}
