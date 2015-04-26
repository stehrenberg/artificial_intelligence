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
* that performs depth-first search.
* @author Stephanie Ehrenberg (sehrenbe@hm.edu)
* @version 2015-04-20
*/
public class DepthFirstSearchAgent extends UninformedSearchAgent {

	/**
	* Ctor.
	*/
	public DepthFirstSearchAgent() {
        super();
	}

	/**
	* For depth-first search, the finge datastructure is handled like a stack -
	* the newest discovered nodes must be added to the beginning of the fringe.
	* @return The position where the node is to be added to the fringe.
	*/
	@Override protected int getAdditionPosition() {
		return 0;
	}
}
