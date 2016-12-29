/*
* @author Matthew Mawby
* @version 1.0
*/

package Jgraph;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

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

        //@returns: A HashSet of the node labels of all nodes in the graph
        public HashSet<N> getNodes();

        //@returns: A HashMap where keys are a string in the format "NODE-from:edge_label:NODE-to" by
        //utilizing the object.toString() method and values are the number of times that edge occurs
        public HashMap<String,Integer> getEdges();

        //@returns: A HashSet containing the labels of nodes you can get to from the given node. Returns an empty set if the
        //given node has no neighbors or is not in the graph.
        public HashSet<N> getNeighborsTo(N node_label);

        //@returns: A HashSet containing the labels of nodes you can get to the given node from. Returns an empty set if the
        //given node has no neighbors or is not in the graph.
        public HashSet<N> getNeighborsFrom(N node_label);

        // @param:     source | the node label of the starting node
        // @param: destination| the node label of the destination node
        // @returns: an ArrayList of node labels in order from the source to the destination,
        // empty ArrayList if the source node or destination node are not in the graph.
        public ArrayList<N> shortestPath(N source, N destination);
}
