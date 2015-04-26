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
Lab Assignment 3: Uninformed Search Agents
In this lab I created an abstract base class, representing a basic agent performing uninformed search,
and two concrete agent implementations using java code. These agents run in the Wumpus Environment.

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

ABC "UninformedSearchAgent"
****************************
This is an abstract base class for both search variations that implements almost every logic needed for breadth-first and depth-search.
The only abstract method that needs to be implemented by the concrete agent implementations is the function getAdditionPosition() that returns the index at which a node is to be added to the fringe data structure.

The overall logic for the search phase consists of the following steps:
1) Of the search's initial position, inspect all horizontally and vertically adjacent nodes successively.
2) If the respective node a) is no wall element, b) is not contained in the fringe and c) has not been evaluated yet and is thus a "newly discovered" node, it is added to the fringe at the position determined by the getAdditionPosition() function.
The node is stored within a HashMap "nodes" that contains all visited nodes as keys with their respective parent node as value.
3) The search now moves to the next node that is taken from the beginning of the fringe data structure and continues the previous steps until it finds the goal.

The steps for the movement phase are as follows:
1) First, a solution path must be created. This is done by making use of the "nodes" HashMap. Outgoing from the goal position, the path is created recursively by appending the current location to the path and continuing the process with its respective parent node. This is done in the createPath() function that is executed recursively until the bot's position is reached (that's where the search started).
The underlying principle to this process can be described like this: since every node can only have one parent node, every path that is thus created leads unmistakeably to the root - and the root represents the position from which the search has initially started.
2) After the path has been created, the bot retrieves the next node that it has to move to.
3) Based on the relative position of the next node to the bot's current position, the turning direction for the bot is calculated.
4) Now the bot moves to the next node and repeats the previous steps until the path data structure is empty - which means the bot has reached the goal.


Concrete class "BreadthFirstSearchAgent"
**************************************
This one performs the breadth-first search algorithm which differs from depth-first only by the position a new node is inserted into the fringe.
The BreadthFirstSearchAgent class implements getAdditionPosition() by returning the index at the end of the fringe, realizing a "queue behavior" for the fringe data structure.


Concrete class "DepthFirstSearchAgent"
**************************************
This one performs the depth-first search algorithm which differs from breadth-first only by the position a new node is inserted into the fringe.
The DepthFirstSearchAgent class implements getAdditionPosition() by returning the index at the beginning of the fringe, realizing a "stack behavior" for the fringe data structure.
