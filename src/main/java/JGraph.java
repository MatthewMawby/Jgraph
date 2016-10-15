/**
* @author Matthew Mawby
* @version 1.0
*/

package jgraph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//JGraph is a mutable Graph ADT
//
//@Abstraction:
//This class represents a graph such that V = node_count, E = edge_count and that for all elements of
//adjacency_list there is a set of outgoing edges from the Node whose ID corresponds to that indice
//
//@Specfield: ArrayList< ArrayList< Edge> > adjacency_list | an adjacency list that contains edges to and from the various nodes in the graph
//                                          int node_count | the number of nodes in the graph and int edge_count is the number of edges in the graph
//                                       HashSet node_list | a set of all nodes in the graph
//                                          int edge_count | the number of edges in the graph, only used by the checkrep method
public class JGraph<N,E> implements Graph<N,E> {

    private HashMap<N,Node<N>> node_list;
    private ArrayList< ArrayList<Edge<N,E>> > adjacency_list;
    //private ArrayList<ArrayList<Integer>> adj_matrix; FUTURE IMPLEMENTATION
    private int node_count;
    private int edge_count;     //edge_count is only used for verification in the checkrep method

    //@throws: RuntimeException if the representation invariant is broken
    //@returns: none
    //A private helper function to ensure the representation invariant is held
    //This function will be called upon entering and exiting methods that modify JGraph
    private void checkRep() throws RuntimeException
    {
        int edges=0;

        //makes sure the adjacency list contains no null values
        for (int g=0; g<this.node_count; g+=1)
        {
            if (adjacency_list.get(g)==null)
            {
                throw new RuntimeException("CheckRep() failed, null edgelist in adjacencylist");
            }
            for (int q=0; q<adjacency_list.get(g).size(); q+=1)
            {
                if (adjacency_list.get(g).get(q)==null)
                {
                    throw new RuntimeException ("CheckRep() failed, null edge in an edgelist");
                }
                edges+=1;
            }
        }

        //ensures the edge_count accurately represents the number of edges found in the adjacency list
        if (edges!=edge_count)
        {
            throw new RuntimeException("CheckRep() failed, edge_count is not equal to the correct amount of edges");
        }

        //ensures the node_count represents the number of nodes in the node_list
        if (node_count != node_list.size())
        {
            throw new RuntimeException("CheckRep() failed, node_count is not equal to the size of node_list");
        }
    }

    //@returns: this (a new JGraph)
    public JGraph()
    {
        this.node_list = new HashMap<N,Node<N>>();
        this.adjacency_list= new ArrayList< ArrayList<Edge<N,E>> >();
        this.node_count=0;
        this.edge_count=0;
        checkRep();
    }

    //@param: N name | the node label
    //@returns: true if the node was added, otherwise false
    public boolean addNode(N name)
    {
         checkRep();
         Node<N> n = new Node<N>(name);
         if (node_list.containsKey(name))
         {
             checkRep();
             return false;
         }
         //add the node to node_list and add a new node to the adjacency_list
         else
         {
             n.setID(this.node_count);
             this.node_count+=1;
             ArrayList<Edge<N,E>> edges = new ArrayList<Edge<N,E>>();
             this.adjacency_list.add(edges);
             node_list.put(name, n);
             checkRep();
             return true;
         }
    }

}
