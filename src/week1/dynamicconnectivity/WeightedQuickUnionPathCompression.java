package week1.dynamicconnectivity;

public class WeightedQuickUnionPathCompression implements UnionFind {
	/*
	 * Fundementals of WeightedQuickUnion
	 * 
	 * Quick Union we represent connected Components as Set of Forests Each
	 * Connected Component is represented by a unique object called root
	 * 
	 * Union Operation involves Pointing the root of one connected component to
	 * another. We add a constraint --> We calculate size of the the first connected
	 * component and calculate size of the second connected component --> Least Size
	 * connected component root points to Greater size connected component , by
	 * doing this we might make the tree flat
	 * 
	 * Connected operations invloves checking if both the objects have same root
	 * 
	 * root operation returns the root of that connected component
	 * 
	 */

	/*
	 * Intution As in previous datastructure QuickUnion the problem is in tree
	 * becomes too tall and hence root operation touches all the array entries ,
	 * here in WeightedQuickUnion we try to overcome that by making the tree flat.
	 * 
	 * 
	 * 
	 * 
	 */
	/*
	 * Complexity
	 * 
	 * Union operation it depends on root O(logn)
	 * 
	 * Connected Operation
	 * 
	 * connected is dependent on root hence O(logn) root O(logn) the depth of any
	 * node x is <=logn
	 * 
	 * 
	 */

	/*
	 * defect Trees get too tall root operation involves touchin all the array
	 * acesses
	 * 
	 * IF there are N union calls on N objects then the complexity is O(N^2)
	 */

	/**
	 * @author bhuvan
	 *
	 */

	private int id[];
	private int sz[];
	private int N;
	private int largestcanc[];

	public WeightedQuickUnionPathCompression(int N) {
		id = new int[N];
		sz = new int[N];
		largestcanc = new int[N];
		this.N = N;
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
			id[i] = i;
			largestcanc[i] = i;

		}
	}

	/*
	 * 
	 * root returns the root of that connected component representin it root of a
	 * tree doesnt have any parent its entry is itself hence we stop when id[p]==p
	 * 
	 */

	/*
	 * we point each and every path from p to root point to the root in
	 * PathCompression
	 * 
	 */
	private int root(int p) {
		if (id[p] == p)
			return p;
		id[p] = root(id[p]);
		return id[p];
	}

	/*
	 * connected operation checks if two objects have the same root
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/*
	 * Union Operation involves Pointing the root of one connected component to
	 * another. We add a constraint --> We calculate size of the the first connected
	 * component and calculate size of the second connected component --> Least Size
	 * connected component root points to Greater size connected component , by
	 * doing this we might make the tree flat.
	 */
	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		int cancroot = 0;
		if (!connected(p, q)) {
			if (sz[rootp] < sz[rootq]) {
				cancroot = rootq;
				id[rootp] = rootq;
				sz[rootq] += sz[rootp];
			} else {
				cancroot = rootp;
				id[rootq] = rootp;
				sz[rootp] += sz[rootq];

			}
			largestcanc[cancroot] = Math.max(largestcanc[rootp], largestcanc[rootq]);

		}

	}

	public int find(int i) {
		return largestcanc[root(i)];
	}

}
