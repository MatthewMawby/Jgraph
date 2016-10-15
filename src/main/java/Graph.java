/**
* @author Matthew Mawby
* @version 1.0
*/

package jgraph;

public interface Graph<N,E> {

        //@param: N name | the node label
        //@throws: none
        //@returns:  true if the node was added, false if otherwise
        public boolean add_node(N name);

        //@param: N from  | the label of the node the edge is coming from
        //@param: N to    | the label of the node the edge is going to
        //@param: E label | the label of the edge
        //@throws: none
        //@returns:  true if the edge was added, false if otherwise
        public boolean add_edge(N from, N to, E label);

        //other functions such as search/contains
}
