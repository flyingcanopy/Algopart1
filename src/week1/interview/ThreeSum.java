package week1.interview;

public class ThreeSum {
    /*
     * 3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes
     * time proportional to n2 in the worst case. You may assume that you can sort
     * the n integers in time proportional to n2 or better.
     * 
     * Note: these interview questions are ungraded and purely for your own
     * enrichment. To get a hint, submit a solution
     * 
     * Assuming we have distinct N integers .
     * 
     * We use 2sum problem as subroutine to solve this problem . lets say we have
     * [1,2,3,-1,0,-3,-4] possible outputs (2,1,-3) (3,0,-3) (3,1,-4) (1,-1,0)
     * 
     * from above -3 we have (2,1) (3,0) for -4 (3,1) for 0 we have (1,-1)
     * 
     * here target=0
     * 
     * for each x in a[] { List<Integer> ls=2sum(a,-(target-x));
     * System.out.print(ls); }
     */

    // implement 2sum() below
}
