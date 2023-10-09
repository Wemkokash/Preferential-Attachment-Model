import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import com.opencsv.CSVWriter;

public class WerLaw {
	public static void writeDataLineByLine (String filePath, HashMap<Integer, Integer> map) throws IOException {
		File file = new File(filePath);
		FileWriter outputFile = new FileWriter(file);
		CSVWriter writer = new CSVWriter(outputFile);
		
		String[] header = {"Node" , "Number Of Connections"};
		writer.writeNext(header);
		HashMap<Integer,Integer> freq = new HashMap<Integer, Integer>();
		for (int i = 0; i < map.size(); i++) {
			if(!(freq.containsKey(map.get(i)))) {
				freq.put(map.get(i), 1);
			} else {
				int val = freq.get(map.get(i));
				freq.replace(map.get(i), val+1);
			}
		}
		for(int i = 1; i < map.size()+1; i++) {
			if(freq.containsKey(i)) {
				System.out.println(Integer.toString(i) + "," + Integer.toString(freq.get(i)));
			}
		}
		/*
		for(int i = 0; i < map.size(); i++) {
			String node = Integer.toString(i);
			String numConnections = Integer.toString(map.get(i)) + "\n";
			String[] row = {node, numConnections};
			writer.writeNext(row);
		}
		for(int i = 0; i < map.size(); i++) {
			String node = Integer.toString(i);
			String numConnections = Integer.toString(map.get(i));
			System.out.println(node + "," + numConnections);
		}*/
		writer.close();
	}
	public static void PAmodel(int numIterations) throws IOException {
		//these were unused
		//int totalEdges = 1;
		//int totalNodes = 2;

		//two Hash Maps, one that keeps track of which nodes link to each other, 
		//one that keeps track of how many connections each node has
		HashMap<Integer, Integer> edgeNumMap = new HashMap<Integer, Integer>();
		HashMap<Integer, LinkedList<Integer>> connectionMap = new HashMap<Integer, LinkedList<Integer>>();

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

		connectionMap.put(0, new LinkedList<Integer>());
		connectionMap.put(1, new LinkedList<Integer>());
		connectionMap.get(0).add(1);
		connectionMap.get(1).add(0);



		//variable to keep track of what # node to add to model
		//(since we already added two)
		int nodeNum = 2;

//I think we need to define probVals here
		//IMPORTANT FOR LOOP here
		//This is where we do the big boy work.
		for(int i = 0; i < numIterations; i++) {

			//new hashTable to store probability values
			//Possible glitch point. making probvals over probvals?
			HashMap<Integer, Integer> probVals = new HashMap<Integer, Integer>();

			//for each old node, calculate probability that the new node connects to it
				//for loop for calculating probabilities

//I think we need to define curProb here 
			for(int j = 0; j < nodeNum; j++){

				//calculate probVal for node j (which is the "current node")
				int curProb = edgeNumMap.get(j) + 1;
				probVals.put(j, curProb);

//are we printing here just to test? yes
				//System.out.println(probVals.get(j));
			}

			//add all probVals values
			int probValsTotal = 0;

			for(int j = 0; j < probVals.size(); j++){
				probValsTotal += probVals.get(j);
			} 

			//random int for range probValsTotal
			Random rand = new Random();

			int randNum = rand.nextInt(probValsTotal);

			//start at -1 because.
			int curTotal = -1;

			//this curNode is the node which will be connected to by nodeNum
			int curNode = 0;

			while(true){

				curTotal += probVals.get(curNode);

				//check to see if curNode is the node which nodeNum will attach to
				if(curTotal >= randNum){
					//if the curNode is selected to link to nodeNum, 
					//put new values in both HashMaps

					//for nodeNum (the node being added)
					connectionMap.put(nodeNum, new LinkedList<Integer>());
					connectionMap.get(nodeNum).add(curNode);

					//for curNode (the node connected to)
					connectionMap.get(curNode).add(nodeNum);

					//replace number at curNode, becuase it now links to one more node
					int edgeNumReplace = edgeNumMap.get(curNode) + 1;
					edgeNumMap.replace(curNode, edgeNumReplace);

					//new key value pair in edgeNumMap for nodeNum
					edgeNumMap.put(nodeNum, 1);

					break;
				}

				//iterate node
				curNode += 1;
			}

			//iterate nodeNum
			nodeNum += 1;
			

//is this also just for testing? yes
			//System.out.println("nodeNum =" + nodeNum);
		}
		writeDataLineByLine("PAModel.csv", edgeNumMap);
		//System.out.println(edgeNumMap.values());
	}
	public static void main(String[] args) throws IOException{
		PAmodel(10000);
	}
}
