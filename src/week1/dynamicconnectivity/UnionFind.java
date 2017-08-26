/**
 * 
 */
package week1.dynamicconnectivity;

/*
 * Dynamic connectivity problem:
 * Here we have set of objects and there are some connections among them
 * There is equivalence connection in between them 
 * * Transitive a-b and b-c then a-c
 * * symmentric a-b then b-a
 * * idempotent - a is connected to a 
 * 
 * *We say an object p is connected to q if there is a path from p to q
 * 
 * 
 * The main problem here is to check if the path exists between objects 
 * 
 * Lets Model the problem
 * In this problem there are two main Procedures
 * 
 * public
 * 1) Union(p,q) 
 * union is used to connect two objects 
 * 2)Connected(p,q)
 * To check if two objects p and q are connected
 * 
 * private
 * int root(p)
 * To give the unique number representing the connected component(look the defenition online)
 * 
 *int Count()
 *it is going to return total no of connected components
 *
 * 
 * 
 * 
 * 
 * 
 */


 
/**
 * @author bhuvan
 *
 */
public interface UnionFind {
	/*
	 *
	 * union is used to merge two connected components representing p and q
	 * 
	 * 
	 */
    void union(int p, int q);
	
	
	
	
	/*
	 * connected is going to check if two objects p and q are connected
	 * 
	 */
    boolean connected(int p, int q);

	/*
	returns the largest number in that connected component

	 */
	//public int find(int p);
	
	
	
	
	

}
