/**
* @author Matthew Mawby
* @version 1.0
*/

package jgraph;

class Node<N> {

    //Member variables are protected so only JGraph can modify them
    protected N name;
    protected int id;

    //@param: N name | the label of the node
    //@throws: none
    //@returns: this (a new node)
    protected Node(N name)
    {
        this.name = name;
    }

    //@throws: none
    //@returns: int representing the id of the node
    protected int getID()
    {
        int copy = new Integer(this.id);
        return copy;
    }

    //@param: int idnum | the integer the Node will use as an ID
    //@throws: none
    //@returns: none
    protected void setID(int idnum)
    {
        this.id=idnum;
    }


    //@throws: none
    //@returns: the hashCode of this.name
    //This function is an override to make nodes easily hashable so long as the type of the label is hashable
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }



    //@param: Object o | the object this is being compared to
    //@throws: none
    //@returns: true if this == Object o, false otherwise
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Node<?>)
        {
            if (((Node<?>)o ).name.equals(this.name))
            {
                return true;
            }
        }
        return false;
    }
}
