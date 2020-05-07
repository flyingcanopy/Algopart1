/**
 * 
 */
package week1.dynamicconnectivity;

/*                      Fundementals of QuickUnion
 * 
 *   Quick Union we represent connected Components as Set of Forests
 *   Each Connected Component is represented by a unique object called root 
 *   
 *   Union Operation involves Pointing the root of one connected component to another
 *  
 *   Connected operations invloves checking if both the objects have same root
 * 
 *   root operation returns the root of that connected component
 * 
 */

/*                             Intution
 *        As in previous datastructure QuickFind the problem is in uNion we touch all the array acess for each union call . here in QuickUnion we try to overcome that .
 * 
 * 
 * 
 * 
 */
/*                     Complexity
 * 
 *                  Union operation
 *                    it depends on root 
 *                     O(N)	
 *                  
 *                  Connected Operation
 *                     O(N)
 *                     connected is dependent on root hence O(N)
 *                  root
 *                     O(N)
 *                     If tree is skinny we need to traverse the whole height of the tree to find the root of that tree
 *                     
 * 
 */

/*
 *                       defect
 *                      Trees get too tall
 *                      root operation involves touchin all the array acesses 
 *                       
 *                       IF there are N union calls on N objects then the complexity is O(N^2)
 */

/**
 * @author bhuvan
 *
 */
public class QuickUnion implements UnionFind {
	private int id[];
	private int N;

	QuickUnion(int N) {
		id = new int[N];
		this.N = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	/*
	 * 
	 * root returns the root of that connected component representin it root of a
	 * tree doesnt have any parent its entry is itself hence we stop when id[p]==p
	 * 
	 */
	private int root(int p) {
		if (id[p] == p)
			return p;
		return root(id[p]);
	}

	/*
	 * connected operation checks if two objects have the same root
	 */
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	/*
	 * union operation merges two connected componenets by making the root of the
	 * first object point to root of the second object
	 * 
	 * 
	 */
	public void union(int p, int q) {
		if (!connected(p, q)) {

			int rootp = root(p);
			int rootq = root(q);
			id[rootp] = rootq;
		}

	}

}
