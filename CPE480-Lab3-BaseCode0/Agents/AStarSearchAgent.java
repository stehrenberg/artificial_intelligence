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
* Implements the A* Search Algorithm, a derivation of UCS and BFS and thus derived from UFS.
* @author Stephanie Ehrenberg (sehrenbe@hm.edu / Moodle: "sehrenbe")
* @version 2015-05-26
*/
public class AStarSearchAgent extends UniformCostSearchAgent {

	/** Calculates the cost for a given node. With A* Search, those are calculated from the
	* distance to the goal as well as the path taken up to the current search location.
	* @param inspectedNode The node that is currently inspected and is to be added to the fringe
	* @param searchPosition The current searchPosition that serves as parent to all newly inspected nodes.
	*/
	protected int calculateCost(Node inspectedNode, Node searchPosition) {

		int totalCosts = SBFunctions.getDistanceToGoal(getSearchLocation());

		if(searchPosition != getStartingLocation())
			totalCosts += super.calculateCost(inspectedNode, searchPosition);

		return totalCosts;
	}
}
