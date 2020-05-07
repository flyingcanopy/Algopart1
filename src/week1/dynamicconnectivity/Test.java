package week1.dynamicconnectivity;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Scanner scan=new Scanner(System.in); UnionFind qf=new QuickFind(10);
		 * UnionFind qu=new QuickUnion(10); WeightedQuickUnion wq=new
		 * WeightedQuickUnion(10); UnionFind wqp=new
		 * WeightedQuickUnionPathCompression(10);
		 * 
		 * while(true) { System.out.print("Enter object"); int p=scan.nextInt(); int
		 * q=scan.nextInt();
		 * if(qf.connected(p,q)&&qu.connected(p,q)&&wq.connected(p,q)&&wqp.connected(p,q
		 * )) { System.out.println("yes connected"+p+""+q); }else {
		 * System.out.println("not connected"+p+" "+q); qf.union(p,q); qu.union(p,q);
		 * wq.union(p,q); wqp.union(p,q);
		 * 
		 * System.out.println("Largest"+" "+wq.find(p)); } }
		 * 
		 */
		WeightedQuickUnionPathCompression wq = new WeightedQuickUnionPathCompression(4);
		wq.union(0, 1);
		wq.union(1, 2);
		System.out.println(wq.find(0));
		wq.union(2, 3);
		System.out.println(wq.find(2));
		wq.union(2, 1);
		System.out.println(wq.find(0));
	}

}
