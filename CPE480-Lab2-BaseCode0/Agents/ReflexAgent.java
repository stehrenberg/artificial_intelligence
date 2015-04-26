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
* A reflex agent that moves forward as long as it does not hit a wall and turns into
* a random direction otherwise, using it as its new heading.
* @author Stephanie Ehrenberg (ifw12025)
* @email stephanie.ehrenberg@hm.edu
*/
public class ReflexAgent extends WumpusAgent {

    private final Random intGenerator;

    public ReflexAgent() {
        super();
        setDeveloperName("ifw12025");
        intGenerator = new Random();
    }

    public void step() {
		// Get Percepts
		Node n = getCurrentNode();
		int x = n.getX();
		int y = n.getY();

        int lastMove = moveForward();

        // getting new heading if previous move wasn't a success
        if(lastMove > 0) {
            int newDirection = intGenerator.nextInt(4);     // Directions are ints 0 - 3!
            turnTo(newDirection);
        }
    }

    public void reset() {
        super.reset();
    }
}
