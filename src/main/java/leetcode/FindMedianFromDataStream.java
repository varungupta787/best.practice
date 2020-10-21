package leetcode;

import java.util.PriorityQueue;


/*  295. Find Median from Data Stream   */

/*  https://leetcode.com/problems/find-median-from-data-stream/ */

/*
*
* Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
*
* */

public class FindMedianFromDataStream {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    double median = 0;

    public FindMedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (min.isEmpty()) {
            min.add(num);
            median = num;
        } else {
            if (num > median) {
                if (min.size() > max.size()) {
                    int val = min.remove();
                    max.add(val);
                    min.add(num);
                } else {
                    min.add(num);
                }
            } else {
                if (max.size() > min.size()) {
                    int val = max.remove();
                    min.add(val);
                    max.add(num);
                } else {
                    max.add(num);
                }
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            median = ((double) min.peek() + (double) max.peek()) / 2D;
        } else {
            if (min.size() > max.size()) {
                median = (double) min.peek();
            } else {
                median = (double) max.peek();
            }
        }
        return median;
    }
}
