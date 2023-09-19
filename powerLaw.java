import java.util.HashMap;
import java.util.ArrayList;

public class powerLaw {

	public static void PAmodel(int numStartingNodes, int numIterations, int numNewEdges) {

		int totalEdges = 0;
		int totalNodes = numStartingNodes;  

		//two Hash Maps, one that keeps track of which nodes link to each other, 
		//one that keeps track of how many connections each node has
		new HashMap edgeNumMap = HashMap();
		new HashMap connectionMap = HashMap();

//this is bad, find something else
		//ArrayList to put in every new nodes connectionMap value
		new ArrayList connections = ArrayList(numIterations * numNewEdges);

		//add numStartingNodes into our HashMaps
		for(i = 0; i < numStartingNodes; i++){

			edgeNumMap.put(i, 0);
			connectionMap.put(i, );
		}


		//for loop here
		for(i = 0; i < numIterations; i++) {


		}


	};

	

	public static void main() {

	};



}



















