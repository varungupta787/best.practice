package leetcode;

/*  852. Peak Index in a Mountain Array */

/*  https://leetcode.com/problems/peak-index-in-a-mountain-array/description/   */

/*
*
* An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.



Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
*
*/

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int s = 0, e = arr.length-1, mid = 0;
        while(s<=e) {
            mid = s + (e-s)/2;
            if(arr[mid]<arr[mid+1]) {
                s = mid+1;
            } else if(arr[mid]<arr[mid-1]) {
                e = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
