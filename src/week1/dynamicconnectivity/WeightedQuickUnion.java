package week1.dynamicconnectivity;

public class WeightedQuickUnion implements UnionFind {
	/*                      Fundementals of WeightedQuickUnion
	 * 
	 *   Quick Union we represent connected Components as Set of Forests
	 *   Each Connected Component is represented by a unique object called root 
	 *   
	 *   Union Operation involves Pointing the root of one connected component to another. We add a constraint
	 *   --> We calculate size of the the first connected component and calculate size of the second connected component 
	 *   --> Least Size connected component root points to Greater size connected component , by doing this we might make the tree flat
	 *  
	 *   Connected operations invloves checking if both the objects have same root
	 * 
	 *   root operation returns the root of that connected component
	 * 
	 */

	/*                             Intution
	 *        As in previous datastructure QuickUnion the problem is in tree becomes too tall and hence root operation touches all the array entries ,
	 *        here in WeightedQuickUnion we try to overcome that by making the tree flat.
	 * 
	 * 
	 * 
	 * 
	 */
	/*                     Complexity
	 * 
	 *                  Union operation
	 *                    it depends on root 
	 *                     O(logn)	
	 *                  
	 *                  Connected Operation
	 *               
	 *                     connected is dependent on root hence O(logn)
	 *                  root
	 *                     O(logn)
	 *                     the depth of any node x is <=logn
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

/*

                                                          Find Operation
    We maintain an Integer array largest[] of size N which keeps track of largest element in a connected Component.
    Initialize all elements in   Largest[] to itself as there are N connected components and each of N elements in its own component.
            for i 0->n-1
    largest[i]=i

    When union is called between two objects p , q we find root(p) and root(q),
            if previous largest  value in that connected component is lesser than other connected component then we reassign the new largest  value
    we check
      int l1=largest[rootp];
        int l2=largest[rootq];
    if(l1>l2)
              largest[root(p)]=l1;
        else
            largest[root(p)]=l2;

    Given an object k we identify which connected component it belongs i.e a root of that tree represents the connected component of that tree .
            we return largest[root(k)];
            */


	/**
	 * @author bhuvan
	 *
	 */
	
	
private int id[];
private int sz[];
private int N;
private int largest[];

	WeightedQuickUnion(int N)
	{
        largest=new int[N];
        this.N=N;
		id=new int[N];
		sz=new int[N];
		for(int i=0;i<N;i++)
		{
            largest[i]=i;
			sz[i]=1;
			id[i]=i;
		}
	}
	
	/*
	 * 
	 * root returns the root of that connected component representin it
	 * root of a tree doesnt have any parent its entry is itself hence we stop when id[p]==p
	 * 
	 */
	private int root(int p)
	{
	if(id[p]==p)
		return p;
	return root(id[p]);
	}
	
	/*
	 * connected operation checks if two objects have the same root 
	 */
	public boolean connected(int p,int q)
	{
		return root(p)==root(q);
	}
	
	/*
	 Union Operation involves Pointing the root of one connected component to another. We add a constraint
	 *   --> We calculate size of the the first connected component and calculate size of the second connected component 
	 *   --> Least Size connected component root points to Greater size connected component , by doing this we might make the tree flat.
	*/
	public void union(int p,int q)
	{
		int rootp=root(p);
		int rootq=root(q);
        int l1=largest[rootp];
        int l2=largest[rootq];
		
		if(sz[rootp]<sz[rootq])
		{
			id[rootp]=rootq;
			sz[rootq]+=sz[rootp];
		}else
		{
			id[rootq]=rootp;
			sz[rootp]+=sz[rootq];
		}

        if(l1>l2)
              largest[root(p)]=l1;
        else
            largest[root(p)]=l2;
		
	}
    public int find(int p)
    {
        return largest[root(p)];


    }

}
