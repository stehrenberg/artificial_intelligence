/**
 * Munich University for Applied Science, Department of Mathematics and Computer Science
 * Course "Artificial Intelligence"
 * OS: Windows 7 Professional SP1, Java Version 1.8.0_05
 * System: Intel Core2Duo @ 2.0 GHz, 4GB RAM
 */

package Agents;

import BotEnvironment.SearchBot.*;
import BotEnvironment.*;
import java.util.Random;

/**
* This agent heads forward until it hits a wall, then following it until it finds the goal.
* @author Stephanie Ehrenberg (ifw12025)
* @email stephanie.ehrenberg@hm.edu
*/
public class ModelBasedAgent extends WumpusAgent {

    /** Generates ints from 0 to 3 which represent directions NORTH, EAST, SOUTH and WEST. */
    private final Random intGenerator;
    /** Indicates whether the last move has lead to hitting the wall. */
    private boolean hitWall;
    private boolean followWall;

    public ModelBasedAgent() {
        super();
        setDeveloperName("ifw12025");
        intGenerator = new Random();
        hitWall = false;
        followWall = false;
    }

    public void step() {
		// Get Percepts
		Node n = getCurrentNode();
		int x = n.getX();
		int y = n.getY();

        if(followWall) {
            if(hitWall)
                turnRight();
            else
                turnLeft();
        }

        hitWall = moveForward() > 0? true : false;

        if(hitWall && !followWall)
            followWall = true;
    }

    public void reset() {
        hitWall = false;
        followWall = false;
        super.reset();
    }
}
