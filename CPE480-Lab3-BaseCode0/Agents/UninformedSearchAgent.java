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
* This class represents the abstract basic agent for uninformed search.
* Concrete agent implementations must specify where node that is explored by the search is to be added
* to the fringe, thus differentiating between breadth-first search (addition position = end of fringe)
* adnd depth-first search (addition position = beginning of fringe).
* @author Stephanie Ehrenberg (sehrenbe@hm.edu)
* @version 2015-04-21
*/
public abstract class UninformedSearchAgent extends BotSearch {

	/** The path to the goal as calculated by the search algorithm. */
	List<Node> path;
	/** A map of all visited nodes where each node (key) is stored with their respective parent node (value).
	* This is used to calculate the path to the bot's position, starting at the goal. */
	Map<Node, Node> nodes;
	/** Indicates wether a path to the goal, i.e. a solution, has already been found. */
	boolean pathNotCreatedYet;

	int searchSteps;
	int movementSteps;

	/**
	* Ctor.
	*/
	public UninformedSearchAgent() {

        super();
        setDeveloperName("Stephanie");
        path = new ArrayList<Node>();
        nodes = new HashMap<Node, Node>();
        pathNotCreatedYet = true;
        int searchSteps = 0;
		int movementSteps = 0;
	}

	/**
	* Called while no goal has been found yet. The bot itself does not move.
	* If the goal has not been found, but the fringe does not contain any more nodes, the search
	* logs that a goal cannot be reached.
	*/
    public void searchStep() {

    	if(!getGoalFound()) {
    		inspectNeighborNodes();

    		if(getFringe().size() == 0) {
    			log("Goal cannot be reached!");
    			printEvaluation();
			}
    		else {
    			searchSteps++;
    			moveSearchLocation(getNextFringeNode());
    		}
    	}
	}

	/**
	* Called when the goal has been found. Moves the bot itself.
	*/
	public void movementStep() {

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
	* Resets the map and clears all used variables.
	*/
    public void reset() {
        super.reset();
        path = new ArrayList<Node>();
        nodes = new HashMap<Node, Node>();
        pathNotCreatedYet = true;
        int searchSteps = 0;
		int movementSteps = 0;
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

				addToFringe(node, getAdditionPosition());
				// remember the node plus its parent node for later path creation!
				nodes.put(node, getSearchLocation());
			}
		}
	}

	/**
	* Derived classes must specify where a newly discovered node is to be added to the fringe.
	* The next node for inspection by the search is always taken from the head of the fringe data
	* structure. With this function it is possible to distinct between breadth-first search,
	* where a node is added to the END of the fringe, and depth-first search, where a node
	* is added to the BEGINNING of the fringe.
	* @return The position (aka index) of the fringe where a node is to be added.
	*/
	protected abstract int getAdditionPosition();

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
	private int determineDirection(final Node botPosition, final Node nextNode) {
		final int direction;

		if(botPosition.getY() == nextNode.getY())
			direction = botPosition.getX() < nextNode.getX()? SBConstants.EAST : SBConstants.WEST;
		else
			direction = botPosition.getY() < nextNode.getY()? SBConstants.SOUTH : SBConstants.NORTH;

		return direction;
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
