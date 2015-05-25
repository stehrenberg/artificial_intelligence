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
public abstract class InformedSearchAgent extends BotSearch {

	/** The uniform cost for travelling from one node to another. */
	public static int EDGE_COST = 1;
	/** Indicates what changing direction costs.*/
	public static int TURN_COST = 1;

	/** A map of all visited nodes where each node (key) is stored with their respective PATH costs. */
	Map<Node, Integer> nodeCosts;
	Map<Node, Node> nodes;
	/** The path to the goal as calculated by the search algorithm. */
	List<Node> path;
	/** Indicates wether a path to the goal, i.e. a solution, has already been found. */
	boolean pathNotCreatedYet;
	int searchSteps;
	int movementSteps;

	public InformedSearchAgent() {
        super();
        nodeCosts = new HashMap<Node, Integer>();
        nodes = new HashMap<Node, Node>();
        path = new ArrayList<Node>();
        pathNotCreatedYet = true;
        searchSteps = 0;
        movementSteps = 0;
	}

	@Override public void searchStep() {

		inspectNeighborNodes();

		if(getFringe().size() > 1) {
			sortFringe(new Comparator<Node>() {
				@Override public int compare(Node node, Node anotherNode) {
					int costDiff = nodeCosts.get(node) - nodeCosts.get(anotherNode);
					int result = costDiff > 0? 1 : -1;
					return costDiff == 0? 0: result;
				}
			});
		}

		List fringe = getFringe();
		for(Object thing : fringe) {
			Node node = (Node)thing;
			log("node " + node.getX() + "/" + node.getY() + " with costs " + nodeCosts.get(node));
		}
		moveSearchLocation(getNextFringeNode());
	}

	/**
	* Inspects all nodes horizontally or vertically adjacent to the search's current location.
	*/
	private void inspectNeighborNodes() {
		addNodeToFringe(getNorthOfSearchLocation());
		addNodeToFringe(getEastOfSearchLocation());
		addNodeToFringe(getWestOfSearchLocation());
		addNodeToFringe(getSouthOfSearchLocation());
	}

	/**
	* Adds a given node to the fringe for later inspection, as long as it is no wall element,
	* has not been evaluated yet by the search and is not already contained by the fringe.
	* @param node The node that is to be added.
	*/
	private void addNodeToFringe(final Node node) {

		if(!(node.getIsEvaluated() || node.getIsWall())) {

			if(!fringeContains(node)) {
				addToFringe(node);
				log("Cost Information for node " + node.getX() + "/" + node.getY() + " : " + node.getCost());
				// remember the node plus its parent node for later path creation!
				nodes.put(node, getSearchLocation());
				nodeCosts.put(node, calculateCost(node, getSearchLocation()));
			}
		}
	}

	/** Derived Agents must specify how a node's costs are defined - so this serves evaluation function
	* @param inspectedNode The node that is currently inspected and is to be added to the fringe
	* @param currentNode The current searchPosition that serves as parent to all newly inspected nodes.
	*/
	protected abstract int calculateCost(Node inspectedNode, Node currentNode);

	/**
	* Called when the goal has been found. Moves the bot itself.
	*/
	@Override public void movementStep() {

		// before the bot can move, it needs a path to follow - right?
		if (pathNotCreatedYet) {
			createPath(getSearchLocation());
			pathNotCreatedYet = false;
		}

		Node nextNode = getNextNode();
		Node botPosition = getBotLocation();
		int direction = determineDirection(botPosition, nextNode);

		turnTo(direction);
		moveForward();
		movementSteps++;

		// prints the evaluation as soon as the goal is reached.
		if(nextNode.getIsGoal())
			printEvaluation();
	}

	/**
	* Reconstructs the direct path to the bot's position recursively, starting from the goal
	* after the search has found the goal's location.
	* @param node 	The current node that is to be added to the solution path, unless
	*				it is the node the bot is currently standing on.
	*/
	protected void createPath(final Node node) {

		if(node != getBotLocation()) {
			path.add(node);
			final Node parentNode = nodes.get(node);
			// continue with current node's parent node
			createPath(parentNode);
		}
	}

	/**
	* Returns the next node for the bot to move to. Since the path is build from the goal to
	* the bot's position the bot needs to follow it in reverse order.
	* @return The next node from the end of the path data structure.
	*/
	private Node getNextNode() {

		final Node nextNode = path.get(path.size() - 1);
		path.remove(nextNode);
		return nextNode;
	}

	/**
	* Determines in which direction the bot needs to turn in order to move to the next node.
	* @param botPosition The bot's current position.
	* @param nextNode The next node from the solution path.
	* @return The turning direction - NORTH, EAST, SOUTH or WEST.
	*/
	protected int determineDirection(final Node botPosition, final Node nextNode) {
		final int direction;

		if(botPosition.getY() == nextNode.getY())
			direction = botPosition.getX() < nextNode.getX()? SBConstants.EAST : SBConstants.WEST;
		else
			direction = botPosition.getY() < nextNode.getY()? SBConstants.SOUTH : SBConstants.NORTH;

		return direction;
	}

	/**
	* Resets the map and clears all used variables.
	*/
    @Override public void reset() {
        super.reset();
        nodeCosts.clear();
		nodes.clear();
		path.clear();
		pathNotCreatedYet = true;
		searchSteps = 0;
		movementSteps = 0;
	}

	/**
	* Prints some statistical information as soon as the bot has reached the goal,
	* such as movement/search costs and the overall search/movement steps neccessary.
	*/
	protected void printEvaluation() {

		log("Overall Search Cost: " + getSearchCost());
		log("Total Search Steps required: " + searchSteps);
		log("Overall Movement Cost: " + getMovementCost());
		log("Total Movement Steps required: " + movementSteps);
	}
}
