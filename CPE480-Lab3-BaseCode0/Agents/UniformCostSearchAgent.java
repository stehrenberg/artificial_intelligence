/**
 * Munich University for Applied Science, Department of Mathematics and Computer Science
 * Course "Artificial Intelligence"
 * OS: Windows 7 Professional SP1, Java Version 1.8.0_05
 * System: Intel Core2Duo @ 2.0 GHz, 4GB RAM
 */

package Agents;

import BotEnvironment.SearchBot.*;
import java.util.*;
import java.lang.Math;

/**
* Implements the Uniform Cost search approach.
* @author Stephanie Ehrenberg (sehrenbe@hm.edu / Moodle: "sehrenbe")
* @version 2015-05-26
*/
public class UniformCostSearchAgent extends InformedSearchAgent {

	/** Penalty that is added to the path cost if the node does not lie in the goal's direction. */
	private static final int DIRECTION_PENALTY = 30;

	/** Calculates the overall cost for a given node.
	* @param inspectedNode The node that is currently inspected and is to be added to the fringe
	* @param currentNode The current searchPosition that serves as parent to all newly inspected nodes.
	*/
	@Override protected int calculateCost(Node inspectedNode, Node currentNode) {

		int overallCost = EDGE_COST;
		int turningCost = determineTurningCost(inspectedNode);
		int nodeCost = inspectedNode.getCost();
		int pathCost = super.nodeCosts.containsKey(currentNode)? super.nodeCosts.get(currentNode) : 0;

		int nodeDirection = determineDirection(currentNode, inspectedNode);
		if(nodeDirection != SBFunctions.getDirectionOfGoal(currentNode))
			pathCost += DIRECTION_PENALTY;

		overallCost = overallCost + turningCost + nodeCost + pathCost;
		return overallCost;
	}

	/**
	* Determines whether additional turning costs (+1) will be added to the path cost.
	* Those occur every time the bot has to turn to follow a certain path to the goal.
	*/
	private int determineTurningCost(Node nodeToAdd) {

		int turningCosts = 0;

		if(getSearchLocation() != getStartingLocation()) {
			Node currentNode = getSearchLocation();
			Node previousNode = nodes.get(currentNode);

			boolean directionChange = determineDirection(previousNode, currentNode) != determineDirection(currentNode, nodeToAdd);

			if(directionChange)
				turningCosts = 1;
		}

		return turningCosts;
	}
}
