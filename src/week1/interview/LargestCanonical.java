package week1.interview;

/**
 * Created by zouken on 15-08-2017. Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i) returns the
 * largest element in the connected component containing i. The operations,
 * union(), connected(), and find() should all take logarithmic time or better.
 * 
 * For example, if one of the connected components is {1,2,6,9}, then the find()
 * method should return 9 for each of the four elements in the connected
 * components.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * The key point here is For each connected component we maintain largest value
 * .
 * 
 * We maintain that largest value of the connected component at the entry
 * Largest[root(nodex)] We use an extra space of size N .
 * 
 * For each successfull union(p,q) call { ->calculate
 * maxl(largest[root(p)],largest[root(q)]) ->find out what will be the rootx
 * when two connected components are merged to give one connected component.
 * change largest[rootx]=maxl;
 * 
 * }
 */
public class LargestCanonical {
    /*
     * public void union(int p,int q) { int rootp=root(p); int rootq=root(q); int
     * cancroot=0; if(!connected(p,q)) { if (sz[rootp] < sz[rootq]) { cancroot =
     * rootq; id[rootp] = rootq; sz[rootq] += sz[rootp]; } else { cancroot = rootp;
     * id[rootq] = rootp; sz[rootp] += sz[rootq];
     * 
     * } largestcanc[cancroot]=Math.max(largestcanc[rootp],largestcanc[rootq]); }
     * 
     */
}
