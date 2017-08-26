package week1.interview;

/**
 * Created by zouken on 15-08-2017.
 *
 * Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following form:

 Remove x from S
 Find the successor of x: the smallest y in S such that y≥x.
 design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class SuccessorWithDelete {
    /*
    We use QuickUnion with path compression[logn] to serve our purpose of implementing
-Remove
-Successor
Note: WE can only use quickUnion as Union(p,q) p->q , in other algorithms we cant tell which will be the root as it might change based on size of tree
Here root(x) represents the successor of x and root(x) is smallest y in S such that y>=x

We need to closely look into detail for relating the above problem with quick union .
1 2 3 4 5 6 7
delete 2
1 3 4 5 6 7
   |
   2
delete 4
1 3 5 6 7
   | |
   2 4
delete 6
1 3 5  7
   | |  |
   2 4  6

Remove(x)
{
Union(x,x+1) will implement remove operation under some constrains where
x<N-1
and X>=0
}

Sucessor(x)
{
Root of the given node in tree will give the sucessor .
}




     */
}
