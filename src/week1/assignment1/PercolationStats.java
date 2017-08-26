package week1.assignment1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    double res[];
    private int T;
    private int cm,cd,cl,ch;
    double  mean,std,confl,confh;
    public PercolationStats(int n, int trials)
    {
        if(n<=0 || trials <=0)
            throw new java.lang.IllegalArgumentException();
        T=trials;
        res=new double[trials];
        for(int i=0;i<trials;i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }

            }
           res[i]= (double)p.numberOfOpenSites() / (n*n);
           
        }
    }
    public double mean()
    {
       if(cm++==0)
       {
           mean=StdStats.mean(res);
           return mean;
       }
        return mean;
    }
    public double stddev()
    {
        if(cd++==0)
        {
            std=StdStats.stddev(res);
            return std;
        }
        return std;

    }
    public double confidenceLo()
    {
        if(cl++==0)
        {
            confl=mean-((1.96 * stddev()) / Math.sqrt(T));
        }
        return confl;

    }
    public double confidenceHi()
    {
        if(ch++==0)
        {
            confh=mean+((1.96 * stddev()) / Math.sqrt(T));
        }
        return confh;


    }
    public static void main(String[] args)
    {
        PercolationStats ps=new PercolationStats(200,100);
        System.out.println(ps.mean());
        System.out.println(ps.stddev());
        System.out.println(ps.confidenceLo());
        System.out.println(ps.confidenceHi());

    }

}
