 ##########################
 # A G E N T S - READ ME! #
 ##########################

Name: Stephanie Ehrenberg
Email: stephanie.ehrenberg@hm.edu
Class/Section:
Munich University for Applied Science, Fakulty 07 for Mathematics and Computer Science
Course: "Artificial Intelligence" (Summer term 2015)

PC Environment:
Windows 7 Professional SP 1
Intel Core2Duo @ 2.0 GHz, 4GB RAM
Java Version 1.8.0_40
Descriptions how to compile and run the program are provided and were tested for this environment.

##########################
Lab Assignment 4: Informed Search Agents
In this lab I created an abstract base class, representing a basic agent performing informed search,
and three concrete agent implementations using java code. These agents run in the Wumpus Environment.

Compile the agent files [where %AGENTFILE equals the respective agent's source code file ("agent.java")]:
javac -classpath WumpusEnvironment.jar;.; .\Agents\%AGENTFILE

Run the program:
java -cp .;WumpusEnvironment.jar BotEnvironment.WumpusEnvironment
Then "File" -> "New Wumpus Environment Session..." -> choose and open agent-classfile -> "Map" -> "Open Map..." -> choose and open map file
Clicking "Step" will first make a search avatar (a little fairy) perform one search step on your selected map.
Once a goal has been found, clicking "Step" will make the bot itself take one step along the solution path towards the goal.


#########################################

Description of the "three" agents:
-----------------------------------------

ABC "InformedSearchAgent"
****************************
"InformedSearchAgent" is an abstract base class that implements almost every logic needed for UniformCost, BestFirst and A*.
The only abstract method that needs to be implemented by the concrete agent implementations is the function calculateCost(Node inspectedNode, Node searchPosition) that returns the costs for a given "inspectedNode" based on the current searchPosition.

InformedSearchAgent differs from the ABC UninformedSearchAgent in the data structure for the overall costs. For this purpose I added a HashMap "nodeCosts" where each node is stored with its corresponding costs as calculated by the evaluator function "calculateCost".


Concrete class UniformCostSearchAgent
**************************************
This class implements the UC search algorithm. The key functionality is the implementation of calculateCost(...) that takes into account the node's cost (also referred to as "dirt" or visualized with a monster icon on the map), whether additional turning costs occur and if the inspected node lies in the general direction of the goal - otherwise a "DIRECTION_PENALTY" will be added to the costs.
Since all edges between nodes are of equal distance, EDGE_COSTs of 1 are added every time the search takes one step towards another node. 
This is all added to the parent node's costs and forms the particular node's cost.


Concrete class GreedySearchAgent
**************************************
The class GreedySearchAgent is an implementation of the "Best-First-Search".
The calculation of the node cost is quite plain, the only thing taken into account is a node's distance to the goal, so the search always evaluates the node closest to the goal first.


Concrete class AStarSearchAgent
**************************************
A* is a combination of BFS and UCS, so I decided to derive it from UCS, thus making use of the UCS's implementation of calculateCost(...), and simply adding the distance to the goal to a node's overall costs.