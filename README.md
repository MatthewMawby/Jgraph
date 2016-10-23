# JGraph
##A directed graph implementation in Java

###Getting Started
JGraph is a graph implementation that allows users to solve graph problems by adding nodes and edges to the class then solving the problems using JGraph's built in methods. JGraph supports custom data types so long as they are hashable, and it (will) support(s) weighted path finding if the data types used as edge labels can be converted to doubles.

JGraph is a mutable Abstract Data Type (ADT). It currently represents graphs in adjacency list format, but in the future an adjacency matrix representation will be added to increase efficiency of certain algorithms. JGraph aims to avoid representation exposure and to maintain it's representation invariant upon entry and exit of all methods. To learn more about ADTs click [HERE](https://en.wikipedia.org/wiki/Abstract_data_type) and to learn more about representation invariants and abstraction functions click [HERE](https://courses.cs.washington.edu/courses/cse331/11wi/lectures/lect05-af-ri.pdf).

Full documentation for JGraph will be specified at a later time - for now it is specified via comments in the code. For an easy look at the current state of JGraph look at the Graph.java interface. 

If you have any questions, comments, contributions, or concerns feel free to make an issue, submit a pull request, or send me a message!

Thanks,
Matt

