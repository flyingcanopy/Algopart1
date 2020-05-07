package week1.interview;

public class eggdrop {
    /*
     * For Version 0 : Suppose the egg breaks from Tth floor and there is 1 egg and
     * there are T tosses Ans Experiment throwing eggs from 1 to Tth floor
     * incrementing 1 For Version 1: There are logn tosses and log n eggs
     * 
     * Ans
     * 
     * Use a binary search on the floors. First, try floor T/2. If the egg breaks, T
     * must be equal to T/2 or smaller. If the egg does not break, T must be greater
     * than T/2. Continue testing the mid-point of the subset of floors until T is
     * determined.
     * 
     * version 2: Start test at floor 0 and exponentially grow (2^t) floor number
     * until first egg breaks. The value of T must be between 2^t and 2^(t-1). This
     * range can then be searched in ~lgT tosses using the technique from version 1.
     * 
     * 
     * 
     * 
     * 
     * version 3: take 1 egg drop is at root(n) floor and then 2*root(n) th floor
     * 
     * version 4
     * 
     * dropp the egg at( c/2)*root(t) drop the egg at c * root(t)
     */
}
