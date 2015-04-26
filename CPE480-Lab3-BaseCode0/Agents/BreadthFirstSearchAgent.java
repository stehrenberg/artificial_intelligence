/**
 * Munich University for Applied Science, Department of Mathematics and Computer Science
 * Course "Artificial Intelligence"
 * OS: Windows 7 Professional SP1, Java Version 1.8.0_05
 * System: Intel Core2Duo @ 2.0 GHz, 4GB RAM
 */

package Agents;

import BotEnvironment.SearchBot.*;

/**
* This class represents the concrete implementation of a search agent
* that performs breadth-first search.
* @author Stephanie Ehrenberg (sehrenbe@hm.edu)
* @version 2015-04-20
*/
public class BreadthFirstSearchAgent extends UninformedSearchAgent {

	/**
	* Ctor.
	*/
	public BreadthFirstSearchAgent() {
		super();
	}

	/**
	* For breadth-first search, the finge datastructure is handled like a queue -
	* the newest discovered nodes must be added to the end of the fringe.
	* @return The position where the node is to be added to the fringe.
	*/
	@Override protected int getAdditionPosition() {
		return Math.max(0, getFringe().size() - 1);
	}

}
