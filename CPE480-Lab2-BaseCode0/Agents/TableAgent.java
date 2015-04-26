/**
 * Munich University for Applied Science, Department of Mathematics and Computer Science
 * Course "Artificial Intelligence"
 * OS: Windows 7 Professional SP1, Java Version 1.8.0_05
 * System: Intel Core2Duo @ 2.0 GHz, 4GB RAM
 */

package Agents;

import BotEnvironment.SearchBot.*;
import BotEnvironment.*;

/**
* A table agent that uses a lookup table to determine the direction of his next move.
* @author Stephanie Ehrenberg (ifw12025)
* @email stephanie.ehrenberg@hm.edu
*/
public class TableAgent extends WumpusAgent {

    private final int[][] directionTable = new int[4][4];

    public TableAgent() {
        super();
        setDeveloperName("ifw12025");
        initializeDirectionTable();
    }

    private void initializeDirectionTable() {

        directionTable[0] = new int[] {EAST, EAST, EAST, EAST};
        directionTable[1] = new int[] {EAST, EAST, EAST, EAST};
        directionTable[2] = new int[] {SOUTH, SOUTH, SOUTH, EAST};
        directionTable[3] = new int[] {SOUTH, WEST, WEST, EAST};
    }

    public void step() {
		// Get Percepts
		Node n = getCurrentNode();
		int x = n.getX();
		int y = n.getY();

		// Carry out actions - p.e. by turnRight();
        turnTo(directionTable[x-1][y-1]);
		moveForward();
    }

    public void reset() {
        super.reset();
    }
}
