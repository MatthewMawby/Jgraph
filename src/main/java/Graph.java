/**
* @author Matthew Mawby
* @version 1.0
*/

package jgraph;

public interface Graph<N,E> {

        //@param: N name | the node label
        //@returns:  true if the node was added, otherwise false
        public boolean addNode(N name);

        //@param: N to    | the label of the node the edge is going to
        //@param: N from  | the label of the node the edge is coming from
        //@param: E label | the label of the edge
        //@returns: true if the edge was added, otherwise false
        public boolean addEdge(N to, N from, E label);

        //@returns: an int representing the number of nodes in the graph
        public int size();

        //@returns: an int representing the number of edges in the graph
        public int edgeCount();

        //@param: N node_label | label of the node to check for in the graph
        //@returns: true if a node with the given label is in the graph, otherwise false
        public boolean contains(N node_label);

}
