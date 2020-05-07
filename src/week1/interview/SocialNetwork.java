package week1.interview;

import week1.dynamicconnectivity.WeightedQuickUnionPathCompression;

import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
/*
Social network connectivity.
 Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed
 friendships
 , design an algorithm to determine the earliest time at which all members are connected
 (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted
 by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlogn or
  better and use extra space proportional to n.



Abstract overview -

Lets consider Facebook  got launched recently and People began to use it ,Initially When an individual creates an account there are no friends .
Total no of connected components = Total no of people
->Lets Say a person adds another person , this implies No of connected components has been reduced by 1 [ total no of people - 1 ]

We use the above concept to determine the earliest time at which whole world is connected

i.e

When Total no of connected components == 1
{
Everyone are connected
}

 */

/**
 * Created by zouken on 14-08-2017.
 */
public class SocialNetwork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Date> st = new Stack<Date>();
        int N;
        N = scan.nextInt();
        WeightedQuickUnionPathCompression wqu = new WeightedQuickUnionPathCompression(N);
        while (N > 1) {
            int p = scan.nextInt();
            int q = scan.nextInt();
            scan.nextLine();
            String s = scan.nextLine();
            String dd[] = s.split("/");
            Date dt = new Date(Integer.parseInt(dd[0]), Integer.parseInt(dd[1]), Integer.parseInt(dd[2]));
            st.push(dt);

            if (!wqu.connected(p, q)) {
                N--;
                wqu.union(p, q);

            }
            if (N >= 2)
                st.pop();
        }
        System.out.println(st.pop().getMonth());

    }
}
