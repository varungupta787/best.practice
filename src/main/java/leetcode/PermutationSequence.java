package leetcode;


/*  60. Permutation Sequence    */

/*  https://leetcode.com/problems/permutation-sequence/ */

/*
*
*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*
* */


public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        int[] fact = new int[n+1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i=1; i<=n; i++) {
            arr[i-1] = i;
            fact[i] = fact[i-1]*i;
        }


        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            if(n == 1) {
                sb.append(arr[0]);
                return sb.toString();
            }
            int index = k/(fact[n-1]);
            if(k%fact[n-1] == 0) {
                index--;
            }
            sb.append(arr[index]);
            k -= fact[n-1]*index;
            arrange(index, arr);
            n--;
        }
        return "";
    }

    public void arrange(int j, int[] arr) {
        for(int i=j; i<arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
    }
}
