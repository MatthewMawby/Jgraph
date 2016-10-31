/**
* @author Matthew Mawby
* @version 1.0
*/

package Jgraph;

class Edge<N,E> {

    //member variables are for JGraph use only
    protected N from;
    protected N to;
    protected E label;

    //@param: N from  | the label of the node the edge is coming from
    //@param: N to    | the label of the node the edge is going to
    //@param: E label | the label of the edge
    //@returns: this (a new edge)
    protected Edge(N to, N from, E label)
    {
        this.to = to;
        this.from = from;
        this.label = label;
    }
}
