package week1.interview;

import java.util.Arrays;
/*
Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array.

Standard version: Use ∼3lgn compares in the worst case.
Signing bonus: Use ∼2lgn compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ∼2lgn compares in the worst case).
 */

public class BitoncSearch {
    int descendingBinarySearch(int arr[], int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int bitoncSearch(int a[], int key) {
        // the key might me either in icreasing or decreasing sequence
        // if key is in increasing sequqnce its not in decreasing
        // bitonic point is a point sperating increasing and decreasing values sharply
        // [1,2,3,4,-1,-2,3]
        // |
        // bitonic point
        int bitonicindex = bitoincIndex(a, 0, a.length - 1);
        if (bitonicindex < 0) // if -1 we know the output is [-1,-2,-3..] decreasing sequence
        {
            return descendingBinarySearch(a, 0, a.length - 1, key); //
        } else {
            if (Arrays.binarySearch(a, 0, bitonicindex, key) > 0) // if found in increasing sequence then return it
            {
                return Arrays.binarySearch(a, 0, bitonicindex, key);
            } else if (descendingBinarySearch(a, bitonicindex + 1, a.length - 1, key) > 0)// if found in decreasing
                                                                                          // sequence then return it
            {
                return descendingBinarySearch(a, bitonicindex + 1, a.length - 1, key);
            } else {
                return -1;
            }

        }

    }

    public int bitoincIndex(int a[], int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        // (mid-1<0 && a[mid]<a[mid+1] && a.length == 2) will handle only icreasing
        // sequence arrays like [1,2] with size 2
        // mid+1== a.length will handle a case where there are [1,2,3,4,5,6..] and [1]
        // and [-1]

        // mid -1 < 0 handles decreasing sequence [-1,-2,-3,-4,-5,-6]
        if ((mid - 1 < 0 && a[mid] < a[mid + 1] && a.length == 2) || (mid + 1 == a.length))
            return a.length - 1;
        if (mid - 1 < 0)
            return mid - 1;

        if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) // found the bitonic point
            return mid;
        else if (a[mid] > a[mid - 1]) // falling in increasing sequence move right
            return bitoincIndex(a, mid + 1, hi);
        else // falling in decreasing sequence move left
            return bitoincIndex(a, lo, mid - 1);

    }

    public static void main(String[] args) {
        int a[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        BitoncSearch bt = new BitoncSearch();
        System.out.println(bt.bitoncSearch(a, 20));

    }
}
