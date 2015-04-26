package Agents; // This is not a TODO: rename me to your Cal Poly username! :)

import BotEnvironment.SearchBot.*;

public class MyDumbAgent extends WumpusAgent
{
    public MyDumbAgent()
    {
        super();
        setDeveloperName("Clark");
    }

    public void step()
    {
		// Get Percepts
		Node n = getCurrentNode();
		int x = n.getX();
		int y = n.getY();

		// Carry out actions
		turnRight();
		moveForward();

    }

    public void reset()
    {
        super.reset();
    }
}