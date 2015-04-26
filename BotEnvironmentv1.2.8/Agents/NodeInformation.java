package Agents.RENAME_ME;

import BotEnvironment.SearchBot.*;

public class NodeInformation
{
    private Node node;
    private NodeInformation parent;
    private NodeInformation child;
    private int directionOfChild;
    private int searchHeading;
    private int pathCost;

    public NodeInformation(Node node)
    {
        this.node = node;
        parent = null;
        child = null;
        directionOfChild = SBConstants.NULL;
        searchHeading = SBConstants.NULL;
        pathCost = 0;
    }

    public Node getNode()
    {
        return node;
    }

    public NodeInformation getParent()
    {
        return parent;
    }

    public NodeInformation getChild()
    {
        return child;
    }

    public int getDirectionOfChild()
    {
        return directionOfChild;
    }

    public int getSearchHeading()
    {
        return searchHeading;
    }

    public int getPathCost()
    {
		return pathCost;
	}

    public void setNode(Node node)
    {
        this.node = node;
    }

    public void setParent(NodeInformation parent)
    {
        this.parent = parent;
    }

    public void setChild (NodeInformation child, int directionOfChild)
    {
        this.child = child;
        this.directionOfChild = directionOfChild;
    }

    public void setSearchHeading (int searchHeading)
    {
        this.searchHeading = searchHeading;
    }

    public void setPathCost(int pathCost)
    {
		this.pathCost = pathCost;
	}

    public String toString()
    {
        return "(" + node.getX() + "," + node.getY() + ")";
    }
}