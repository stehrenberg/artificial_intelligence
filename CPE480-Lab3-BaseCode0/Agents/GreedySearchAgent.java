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
* Implements the BestFirst Search Algorithm.
* @author Stephanie Ehrenberg (sehrenbe@hm.edu / Moodle: "sehrenbe")
* @version 2015-05-26
*/
public class GreedySearchAgent extends InformedSearchAgent {

	/** Calculates the cost for a given node. With GreedySearch, those are only calculated from the
	* distance to the goal.
	* @param inspectedNode The node that is currently inspected and is to be added to the fringe
	* @param searchPosition The current searchPosition that serves as parent to all newly inspected nodes.
	*/
	protected int calculateCost(Node inspectedNode, Node searchPosition) {
		return SBFunctions.getDistanceToGoal(getSearchLocation());
	}
}
