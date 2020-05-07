package week1.assignment1;

import edu.princeton.cs.algs4.*;

public class Percolation {
    private int noofelements;
    private WeightedQuickUnionUF wu;

    private WeightedQuickUnionUF wu1;
    boolean opensites[];
    private int nrc;

    int copen;

    private int xyTo1D(int i, int j) {

        return nrc * (i - 1) + j - 1;

    }

    private boolean isValidIndice(int i, int j) {
        if (i < 1 || i > nrc || j < 1 || j > nrc)
            return false;
        return true;
    }

    public Percolation(int n) // create n-by-n grid, with all sites blocked
    {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException();

        copen = 0;
        nrc = n;
        int size = n * n;
        this.noofelements = size;
        opensites = new boolean[size];
        wu = new WeightedQuickUnionUF(size + 2);
        wu1 = new WeightedQuickUnionUF(size + 1);
        for (int i = 0; i < size; i++) {
            opensites[i] = false;
        }
    }

    public void open(int row, int col) // open site (row, col) if it is not open already
    {
        if (!isValidIndice(row, col))
            throw new java.lang.IllegalArgumentException();

        int curropen = xyTo1D(row, col);
        opensites[curropen] = true;
        copen++;
        if (row == 1) {
            wu.union(curropen, this.noofelements);
            wu1.union(curropen, this.noofelements);
        }

        if (row == nrc)
            wu.union(curropen, this.noofelements + 1);

        if (isValidIndice(row, col - 1) && isOpen(row, col - 1)) {
            wu.union(curropen, xyTo1D(row, col - 1));
            wu1.union(curropen, xyTo1D(row, col - 1));
        }

        if (isValidIndice(row, col + 1) && isOpen(row, col + 1)) {
            wu.union(curropen, xyTo1D(row, col + 1));
            wu1.union(curropen, xyTo1D(row, col + 1));
        }
        if (isValidIndice(row - 1, col) && isOpen(row - 1, col)) {
            wu.union(curropen, xyTo1D(row - 1, col));
            wu1.union(curropen, xyTo1D(row - 1, col));
        }

        if (isValidIndice(row + 1, col) && isOpen(row + 1, col)) {
            wu.union(curropen, xyTo1D(row + 1, col));
            wu1.union(curropen, xyTo1D(row + 1, col));

        }

    }

    public boolean isOpen(int row, int col) // is site (row, col) open?
    {
        if (!isValidIndice(row, col))
            throw new java.lang.IllegalArgumentException();

        return opensites[xyTo1D(row, col)];
    }

    public boolean isFull(int row, int col) // is site (row, col) full?
    {
        if (!isValidIndice(row, col))
            throw new java.lang.IllegalArgumentException();
        return wu1.connected(xyTo1D(row, col), noofelements);

    }

    public int numberOfOpenSites() // number of open sites
    {
        return copen;
    }

    public boolean percolates() // does the system percolate?
    {
        return wu.connected(noofelements, noofelements + 1);
    }

    public static void main(String[] args) // test client (optional)
    {

        Percolation p = new Percolation(3);
        while (!p.percolates()) {
            int row = StdRandom.uniform(1, 4);
            int col = StdRandom.uniform(1, 4);
            System.out.println(row + " " + col);
            p.open(row, col);

        }

    }
}
