/*
* @author Matthew Mawby
* @version 1.0
*/

package Jgraph;

class Node<N> {

    //Member variables are protected so only JGraph can modify them
    protected N name;
    protected int id;

    //@param: N name | the label of the node
    //@returns: this (a new node)
    protected Node(N name)
    {
        this.name = name;
    }

    //@returns: int representing the id of the node
    protected int getID()
    {
        int copy = new Integer(this.id);
        return copy;
    }

    //@param: int idnum | the integer the Node will use as an ID
    //@returns: none
    protected void setID(int idnum)
    {
        this.id=idnum;
    }
}
