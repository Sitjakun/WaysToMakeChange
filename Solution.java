import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // amount to fill
        int N = in.nextInt();

        // number of types of coins
        int S = in.nextInt();

        int[] vis = new int[S];
        for (int i = 0; i < S; i++) {
            // values of coins
            int vi = in.nextInt();
            vis[i] = vi;
        }
        System.out.println(change(N, vis));
    }

    // https://hailegia.medium.com/dynamic-programming-number-of-ways-to-make-change-in-5-minutes-fbaf17b8f6f8
    // I really dont understand this recurrence, the exercise looks pretty  tough to me
    public static int change(int amount, int[] coins) {
        if (coins == null) {
            return 0;
        }
        int[] F = new int[amount + 1];
        F[0] = 1; // This is the base case
        for (int coin : coins) {
            for (int value = 1; value <= amount; ++value) {
                if (coin <= value) {
                    F[value] += F[value - coin];
                }
            }
        }
        return F[amount];
    }
}
