public class MovingAverage {
    
    private Deque<Integer> window;
    private double sum;
    private int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        window = new ArrayDeque<Integer>();
    }
    
    public double next(int val) {
        if (this.size == window.size()) {
            double oldVal = window.removeFirst();
            window.addLast(val);
            sum = sum - oldVal + val;
            return sum / size;
        }
        
        window.addLast(val);
        sum += val;
        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */