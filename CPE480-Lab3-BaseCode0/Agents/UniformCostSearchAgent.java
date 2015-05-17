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
*
* @author Stephanie Ehrenberg (sehrenbe@hm.edu)
* @version 2015-05-16
*/
public abstract class UniformCostSearchAgent extends UninformedSearchAgent {

	/** The uniform cost for travelling from one node to another. */
	private static int EDGE_COST = 1;
	/** Indicates what changing direction costs.*/
	private static int TURN_COST = 1;
	/** A map of all visited nodes where each node (key) is stored with their respective PATH costs. */
	Map<Node, Integer> nodeCosts;

	public UniformCostSearchAgent() {
        super();
        nodeCosts = new HashMap<Node, Node>();
	}

	/**
	* Adds a given node to the fringe for later inspection, as long as it is no wall element,
	* has not been evaluated yet by the search and is not already contained by the fringe.
	* @param node The node that is to be added.
	*/
	@Override private void addNodeToFringe(final Node node) {

		if(!(node.getIsEvaluated() || node.getIsWall())) {

			if(!fringeContains(node)) {
				addToFringe(node);
				nodeCosts.put(node, calculateCost(node));
				// remember the node plus its parent node for later path creation!
				super.nodes.put(node, getSearchLocation());
			}
		}
	}

	/** Calculates the overall cost for a given node. */
	private int calculateCost(Node nodeToAdd) {

		int overallCost = EDGE_COST;
		int turningCost = determineTurningCost(nodeToAdd);
		overallCost += currentNode.getCost();
		overallCost += turningCost;
	}

	/**
	* Determines whether additional turning costs (+1) will be added to the path cost.
	* Those occur every time the bot has to turn to follow a certain path to the goal.
	*/
	private int determineTurningCost(Node nodeToAdd) {

		int turningCosts = 0;
		Node currentNode = getSearchLocation();
		Node previousNode = super.nodes.get(currentNode);

		// TODO replace with actual cost calculation!
		return 1;
	}

	/**
	* Resets the map and clears all used variables.
	*/
    @Override public void reset() {
        super.reset();
        nodeCosts = new HashMap<Node, Integer>();
	}

	/**
	* Returns the next node for the bot to move to. Since the path is build from the goal to
	* the bot's position the bot needs to follow it in reverse order.
	* @return The next node from the end of the path data structure.
	*/
	private Node getNextNode() {

		final Node nextNode = super.path.get(path.size() - 1);
		super.path.remove(nextNode);
		return nextNode;
	}
}
