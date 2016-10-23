package jgraph;

class Pair implements Comparable<Pair>
{
    protected Double distance;
    protected int id;

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
