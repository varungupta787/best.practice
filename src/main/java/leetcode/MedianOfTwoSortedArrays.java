package leetcode;

/*  4. Median of Two Sorted Arrays  */

/*  https://leetcode.com/problems/median-of-two-sorted-arrays/  */

/*
*
* Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

Follow up: The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*
* */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        int n= nums1.length, m = nums2.length;
        int begin1 = 0 ; int end1 = n;
        while(begin1<=end1){
            int i1 = (begin1+end1)/2;
            int i2 = (n+m+1)/2 - i1;

            int min1 = (i1==n) ? Integer.MAX_VALUE : nums1[i1];
            int max1 = (i1==0) ? Integer.MIN_VALUE : nums1[i1-1];

            int min2 = (i2==m) ? Integer.MAX_VALUE : nums2[i2];
            int max2 = (i2==0) ? Integer.MIN_VALUE : nums2[i2-1];

            if((max1<=min2) && (max2<=min1) ){
                if((n+m)%2==0){
                    return ((double) (Math.max(max1,max2)
                            + Math.min(min1, min2)) / 2) ;
                }else{
                    return ((double) Math.max(max1, max2));
                }
            }
            else if(max1>min2){
                end1 = i1-1;
            }else{
                begin1 = i1+1;
            }
        }
        return 0;
    }
}
