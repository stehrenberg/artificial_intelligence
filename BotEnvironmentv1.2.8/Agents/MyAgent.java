package Agents;

/**
 * MyAgent represents an agent who continues forward motion in search
 * of a goal until it finds a wall, in which it then turns right and
 * continues forward motion.
 *
 * @author Matt Colon
 */

import BotEnvironment.SearchBot.*;

public class MyAgent extends Bot
{
    /** Default constructor */
    public MyAgent() {

        super();
    }

    /**
     * Each step, the agent checks if the tile in front of it is a wall.
     * If not, it moves forward, and if so, it turns right and checks again.
     */
    public void step() {

        boolean moved = false; // True if the agent has moved forward.

        /* Loop until a non-wall tile is found. */
        while (!moved) {

            /* Is the agent heading north? */
            if (HEADING == SBConstants.NORTH) {

                Node north = getBotLocation().getNorth();
                /* Is the northern tile not a wall? */
                if (!north.getIsWall()) {

                    log("Moving north...");
                    moveForward();
                    moved = true;
                }
                else {

                    log("Hit a wall, turning right...");
                    turnRight();
                }
            }
            /* Is the agent heading east? */
            else if (HEADING == SBConstants.EAST) {

                Node east = getBotLocation().getEast();
                /* Is the eastern tile not a wall? */
                if (!east.getIsWall()) {

                    log("Moving east...");
                    moveForward();
                    moved = true;
                }
                else {

                    log("Hit a wall, turning right...");
                    turnRight();
                }
            }
            /* Is the agent heading south? */
            else if (HEADING == SBConstants.SOUTH) {

                Node south = getBotLocation().getSouth();
                /* Is the southern tile not a wall? */
                if (!south.getIsWall()) {

                    log("Moving south...");
                    moveForward();
                    moved = true;
                }
                else {

                    log("Hit a wall, turning right...");
                    turnRight();
                }
            }
            /* Is the agent heading west? */
            else if (HEADING == SBConstants.WEST) {

                Node west = getBotLocation().getWest();
                /* Is the western tile not a wall? */
                if (!west.getIsWall()) {

                    log("Moving west...");
                    moveForward();
                    moved = true;
                }
                else {

                    log("Hit a wall, turning right...");
                    turnRight();
                }
            }
        }
    }
}