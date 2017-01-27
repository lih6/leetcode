// Basic idea: using two heap: one minHeap, one maxHeap.
// The meanHeap keeps track of the smallest value among larger half of all the values.
// The maxHeap keeps track of the largest value among smaller half of all the values.
// Therefore, addNum will be O(logn) and findMedian will be constant time.
public class MedianFinder {
    // Using PriorityQueue for the heaps.
    public class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new MyComparator());
    }
    
    public void addNum(int num) {
        // Straight forward way:
        // write many if...else... statements for different situations.
        //
        // More advanced way:
        // Since the maxHeap always keep track of the lower half of all numbers, 
        // put the current value into maxHeap first. After the siftdown process, 
        // the maxHeap will put the current largest value at the top. Then, get out 
        // the largest value in the maxHeap and put it into minHeap. If the value
        // is too large, it will get to the bottom of the minHeap, which keeps tack
        // of the larger half of the values. Then, poll value from the minHeap to
        // maxHeap until the maxHeap is larger or equal to the size of the minHeap.
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // If minHeap and maxHeap have the same size, even number of numbers in total.
        // Need to calculate the average of top value of minHeap and top value of maxHeap.
        // Otherwise, return the top value of the heap with larger size.
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */