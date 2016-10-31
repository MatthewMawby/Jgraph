/**
* @author Matthew Mawby
* @version 1.0
*/
package Jgraph;

class Pair implements Comparable<Pair>
{
    protected Double distance;
    protected int id;

    //@param: Double dist | the tentative distance of the node given by the id number
    //@param: int idnum   |
    //@returns: this (a new pair)
    protected Pair(Double dist, int idnum)
    {
        this.distance = dist;
        this.id = idnum;
    }

    @Override
    public int compareTo(Pair other)
    {
        return (this.distance).compareTo(other.distance);
    }
}
