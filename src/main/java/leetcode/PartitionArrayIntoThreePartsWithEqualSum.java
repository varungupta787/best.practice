package leetcode;

/*  1013. Partition Array Into Three Parts With Equal Sum   */

/*  https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/description/  */

/*
*
* Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])



Example 1:

Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
*
* */

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length, sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
        }
        if(sum%3 != 0) {
            return false;
        }
        int value = sum/3, count = 0, temp = 0;
        for(int i=0; i<n; i++) {
            temp += arr[i];
            if(temp == value) {
                count++;
                temp = 0;
            }
            if(count == 3) {
                return true;
            }
        }
        return false;
    }
}
