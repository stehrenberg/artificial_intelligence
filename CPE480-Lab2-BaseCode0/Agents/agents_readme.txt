 #####################
 # A G E N T S - READ ME! #
 #####################

Name: Stephanie Ehrenberg
Email: stephanie.ehrenberg@hm.edu
Class/Section: Munich University for Applied Science, Fakulty 07 for Mathematics and Computer Science, Course "Artificial Intelligence" (Summer term 2015)

PC Environment:
Windows 7 Professional SP 1
Intel Core2Duo @ 2.0 GHz, 4GB RAM
Java Version 1.8.0_40
Descriptions how to compile and run the program are provided and were tested for this environment.

##########################
Lab Assignment 2: Agents
In this lab I created three separate agents using java code. These agents run in the Wumpus Environment.

Compe the agent files [where %AGENTFILE equals the respective agent's source code file ("agent.java")]:
javac -classpath WumpusEnvironment.jar;.; .\Agents\%AGENTFILE

Run the program:
java -cp .;WumpusEnvironment.jar BotEnvironment.WumpusEnvironment
Then "File" -> "New Wumpus Environment Session..." -> choose and open agent-classfile -> "Map" -> "Open Map..." -> choose and open map file
Now clicking "Step" will make the selected agent take one step on your selected map.

##########################

Description of the three agents (DumbAgent description omitted since the code was already provided):
-----------------------------------------
TABLE AGENT
*************
Uses a two-dimensional array as a lookup table to determine its next step, based on the agent's current field. For each field directions are provided, so the starting position of the agent does not matter.
This agent uses the most memory compared to the other agents since it needs to store the lookup table.

REFLEX AGENT
**************
This one moves forward until it hits a wall, then chooses a random direction by generating a random integer (directions are essentially aliases for integers 0,1,3,4). It will then move forward towards its new direction until it again hits a wall. This process is repeated until the agent reaches the goal.

MODEL-BASED AGENT
********************
The Model-Based Agent has a certain strategy to find the goal - it moves forward until it hits a wall and then follows the wall until it reaches the goal.
To achieve this behavior it was neccessary to introduce two new variables (in the source code there is still the relict of the intGenerator which I just forgot to delete, it is not needed for this agent). One is used to remember if the agent's last step resulted in hitting a wall, another one is used to activate a "wall-follow mode". Without the latter it would not be possible to start from just any field on the map, the agent would be required to be placed south or west of a wall element.
The actual step() function carries the agent forward in the default direction until a wall is first hit. Then the "wall-following mode" is activated, which results in the agent turning right until it does not hit a wall element with its next step. Then it takes one step forward and turns left again with its next step. This makes it possible for the agent to follow the wall around the map in a clockwise fashion until the goal is reached.