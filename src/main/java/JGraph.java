/*
* @author Matthew Mawby
* @version 1.0
*/

package Jgraph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//JGraph is a mutable Graph Abstract Data Type
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
    private int edge_count;

    /*
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
    */

    //@returns: this (a new JGraph)
    public JGraph()
    {
        this.node_list = new HashMap<N,Node<N>>();
        this.adjacency_list= new ArrayList< ArrayList<Edge<N,E>> >();
        this.node_count=0;
        this.edge_count=0;
        //checkRep();
    }

    //@param: N name | the node label
    //@returns: true if the node was added, otherwise false
    public boolean addNode(N name)
    {
         //checkRep();
         Node<N> n = new Node<N>(name);
         if (node_list.containsKey(name))
         {
             //checkRep();
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
             //checkRep();
             return true;
         }
    }

    //@param: N to    | the label of the node the edge is going to
    //@param: N from  | the label of the node the edge is coming from
    //@param: E label | the label of the edge//@returns: A HashSet of the edge labels of all edges in the graph
    //@returns: true if the edge was added, otherwise false
    public boolean addEdge(N from, N to, E label)
    {
        //checkRep();
        Node<N> n1= new Node<N>(from);

        //if either one of the nodes the edge is between are not in the graph
        //then the edge can't be added
        if(!node_list.containsKey(from) || !node_list.containsKey(to))
        {
            //checkRep();
            return false;
        }

        else
        {
            Edge<N,E> e = new Edge<N,E>(to, from, label);
            n1=node_list.get(from);

            //add the edge to the adjacency list
            int nodeID=n1.getID();
            this.adjacency_list.get(nodeID).add(e);
            this.edge_count+=1;
            //checkRep();
            return true;
        }
    }

    //@returns: an int representing the number of nodes in the graph
    public int size()
    {
        return this.node_count;
    }

    //@returns: an int representing the number of edges in the graph
    public int edgeCount()
    {
        return this.edge_count;
    }

    //@param: N node_label | label of the node to check for in the graph
    //@returns: true if a node with the given label is in the graph, otherwise false
    public boolean contains(N node_label)
    {
        return node_list.containsKey(node_label);
    }

    //@returns: A HashSet of the node labels of all nodes in the graph
    public HashSet<N> getNodes()
    {
        HashSet<N> nodes = new HashSet<N>(node_list.keySet());
        return nodes;
    }

    //@returns: A HashMap of the edge labels of all edges in the graph and the number of times that entry appears
    public HashMap<E,Integer> getEdges()
    {
        HashMap<E,Integer> edges = new HashMap<E,Integer>();
        for (int c=0; c<adjacency_list.size(); c++)
        {
            ArrayList<Edge<N,E> > current = adjacency_list.get(c);
            for (int g=0; g<current.size(); g++)
            {
                //if the current edge is in the HashMap increment the value by 1
                if (edges.containsKey(current.get(g).label))
                {
                    edges.put(current.get(g).label, edges.get(current.get(g).label)+1);
                }
                //else add the edge to the HashMap and give it the value of 1
                else
                {
                    edges.put(current.get(g).label, 1);
                }
            }
        }
        return edges;
    }

    //@returns: A HashSet containing the labels of nodes you can get to from the given node. Returns an empty set if the
    //given node has no neighbors or is not in the graph.
    public HashSet<N> getNeighborsTo(N node_label)
    {
        HashSet<N> nodes = new HashSet<N>();

        if (node_list.containsKey(node_label))
        {
            Node<N> n = node_list.get(node_label);
            int id = n.getID();
            ArrayList<Edge<N,E>> edges = adjacency_list.get(id);
            for (int i=0; i<edges.size(); i++)
            {
                nodes.add(edges.get(i).to);
            }
        }
        return nodes;
    }

    //@returns: A HashSet containing the labels of nodes you can get to the given node from. Returns an empty set if the
    //given node has no neighbors or is not in the graph.
    public HashSet<N> getNeighborsFrom(N node_label)
    {
        HashSet<N> nodes = new HashSet<N>();
        if (node_list.containsKey(node_label))
        {
            for (int g=0; g<adjacency_list.size(); g++)
            {
                ArrayList<Edge<N,E>> e = new ArrayList<Edge<N,E>>();
                e = adjacency_list.get(g);
                for (int c=0; c<e.size(); c++)
                {
                    if (e.get(c).to.equals(node_label))
                    {
                        nodes.add(e.get(c).from);
                    }
                }
            }
        }
        return nodes;
    }

    // PATHFINDING NEEDS TO BE REWORKED

    public double etodouble(E edgelabel)
    {
        if (!(edgelabel instanceof Number))
        {
            return new Double(1);
        }

        else if (edgelabel instanceof Double)
        {
            return (Double) edgelabel;
        }

        else if (edgelabel instanceof Number)
        {
            return  ((Number) edgelabel).doubleValue();
        }

        return 1;
    }

    //@param:     source | the node label of the starting node
    //@param: destination| the node label of the destination node
    //@returns: a HashMap<N, Double> where the key is the name of the node
    //and the value is the distance to that node as per Dijkstra's algorithm
    //(Edge labels are all weighted 1 if they are non-numeric)
    public HashMap<N,Double> shortestPathTree(N source, N destination)
    {
        //arraylist used as a sort of map <nodeID(index), distance>
        ArrayList<Double> nodeVals = new ArrayList<Double>();
        //HashMap used to store shortest path tree
        HashMap<N,Double> dist = new HashMap<N,Double>();
        PriorityQueue<Pair> pQ = new PriorityQueue<Pair>();

        //if there are no edges
        if (edge_count == 0)
        {
            return dist;
        }

        //if either source or destination aren't in the graph
        else if (!node_list.containsKey(source) || !node_list.containsKey(destination))
        {
            return dist;
        }

        //set all node distances to max value, except the distance of the source
        Set<N> n = node_list.keySet();
        int sourceID = node_list.get(source).id;
        for (N nlabel : n)
        {
            nodeVals.add(Double.MAX_VALUE);
            if (nlabel.equals(source))
            {
                dist.put(nlabel, new Double(0));
                pQ.add(new Pair(new Double(0), sourceID));
                continue;
            }
            dist.put(nlabel, Double.MAX_VALUE);
        }
        nodeVals.set(sourceID, new Double(0));

        while (pQ.size()>0)
        {
            //retrieve the node from the top of the priority queue & get its edge list
            Pair current = pQ.poll();
            int curr_node_id = current.id;
            Double curr_dist = current.distance;
            ArrayList<Edge<N,E>> edges = adjacency_list.get(curr_node_id);

            //for all the edges extending from the current node
            for (int g=0; g<edges.size(); g++)
            {
                int toID = node_list.get(edges.get(g).to).id;
                N tolabel = edges.get(g).to;
                Double edge_len = etodouble(edges.get(g).label);
                //if the calculated distance to the neighbor is less than the stored distance to the neighbor
                if (edge_len+curr_dist < nodeVals.get(toID))
                {
                    //update the distance value of the neighbor node (in the pq, in the nodeVals list, and in the dist hashmap)
                    pQ.remove(new Pair(new Double(nodeVals.get(toID)), toID));
                    nodeVals.set(toID,edge_len+curr_dist);
                    dist.remove(tolabel);
                    dist.put(tolabel, edge_len+curr_dist);
                    pQ.add(new Pair(new Double(edge_len+curr_dist), toID));
                }
            }
        }
        return dist;
    }
}
