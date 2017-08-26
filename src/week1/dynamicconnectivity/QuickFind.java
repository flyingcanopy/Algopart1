package week1.dynamicconnectivity;


/*                      Fundementals of QuickFind
 * 
 * In  QuickFind  All objects in same connected component have same ids.i.e
 * same entries
 * 
 * Union involves changing entries of a objects belonging to one connected component
 * to another 
 * 
 * Check the implementation for more details
 * 
 * 
 */


/*                     Complexity
 * 
 *                  Union operation
 *                     O(N)
 *                  Here we need to iterate through whole  array  . Too many array acesses is the down side
 *                  Connected Operation
 *                     O(1)
 *                  root
 *                     O(1)
 * 
 */

/*
 *                       defect
 *                       Union operation too expensive
 *                       
 *                       IF there are N union calls on N objects then the complexity is O(N^2)
 */


public class QuickFind implements UnionFind {
	
	private int id[];
	private int cc;
	private int N;
	QuickFind(int N)
	{
		cc=N;
		id=new int[N];
		this.N=N;
		for(int i=0;i<N;i++)
			id[i]=i;
		
	}
	
	
	/*
	 * change all entries of id[p] to id[q]
	 * the below operation will merege two connected components
	 */
	public void union(int p,int q)
	{
		if(!connected(p,q))
		{
		int pid=id[p];
		int qid=id[q];
		cc--;
		
		for(int i=0;i<N;i++)
		{
			if(id[i]==pid)
				id[i]=qid;
		}
		}
		
		
	}
	
	/*
	 * check if two are in the same connected components . check if entries are the same
	 */
	
	public boolean connected(int p,int q)
	{
		return root(p)==root(q);
	}
	
	/*
	 * root is goin to return unique id representing the connected component ..
	 */
	private int root(int p)
	{
		return id[p];
	}
	
	
	/*
	 * count is going to return the number of connected components 
	 */
	public int count()
	{return cc;		
	}
	
	
	
	

}
