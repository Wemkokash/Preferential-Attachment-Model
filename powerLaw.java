import java.util.HashMap;
import java.util.LinkedList<E>;
import java.util.Random;

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

		connectionMap.put(0, new LinkedList<Integer>(1));
		connectionMap.put(1, new LinkedList<Integer>(0));



		//variable to keep track of what # node to add to model
		//(since we already added some, the numStartingNodes)
		int nodeNum = 2;

		//IMPORTANT FOR LOOP here
		//This is where we do the big boy work.
		for(i = 0; i < numIterations; i++) {

			//new hashTable to store probability values
			new HashMap probVals = HashMap();

			//for each old node, calculate probability that the new node connects to it
				//for loop for calculating probabilities
			for(int i = 0; i < nodeNum - 1; i++){

				//calculate probVal for node i
				curProb = edgeNumMap.get(i) + 1;

				probVals.put(i, curProb);
			}

			//add all probVals values
			probValsTotal = 0

			for(int i = 0; probVals.size(); i++){
				probValsTotal += probVals.get(i);
			} 

			//random int for range probValsTotal
			Random rand = new Random();

			int randNum = rand.nextInt(probValsTotal);

			//start at -1 becasue
			int curTotal = -1;

			int curNode = 0;


			while(false){

				curTotal += probVals.get(curNode)

				if(curTotal > randNum){
					//if the curNode is selected to link to nodeNum, 
					//put new values in both HashMaps

					//for nodeNum
					connectionMap.put(nodeNum, new LinkedList<Integer>(curNode));

					//for curNode
					connectionMap.get(curNode).add(nodeNum);

					//replace number at curNode, becuase it now links to one more node
					edgeNumReplace = edgeNumMap.get(curNode) + 1;
					edgeNumMap.replace(curNode, edgeNumReplace);

					//new key value pair in edgeNumMap for nodeNum
					edgeNumMap.put(nodeNum, 1);

					break;
				}

				//iterate node
				curNode += 1;
			}


			//add edge between nodeNum and node calculated above

			//iterate nodeNum

		}


	};

	

	public static void main() {

	};



}
