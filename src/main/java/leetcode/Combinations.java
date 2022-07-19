package leetcode;

/*  77. Combinations    */

/*  https://leetcode.com/problems/combinations/ */

/*
*
* Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Example 2:

Input: n = 1, k = 1
Output: [[1]]

*
* */


import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combineUtil(res,temp, n, k, 1);
        return res;
    }

    public void combineUtil(List<List<Integer>> res,
                            List<Integer> temp,
                            int n, int k,
                            int index) {

        for(int i=index; i<=n; i++) {
            if(temp.size()+1 == k) {
                List<Integer> data = new ArrayList<>();
                data.addAll(temp);
                data.add(i);
                res.add(data);
            } else if(i+1 <= n){
                temp.add(i);
                combineUtil(res, temp, n, k, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
