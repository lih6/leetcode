public class Solution {
    public int largestRectangleArea(int[] heights) {
        // Corner case:
        // If the heights array is null or heights' size is 0, then return 0.
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        // Core logic:
        // Use a stack to solve the question.
        // The stack stores the index of the value rather than the real value.
        // First, if the stack is empty and the top value (indicated by
        // the index) of the stack is smaller than the current value, 
        // push the current index onto the stack. If the current value 
        // (indicated by the index) is smaller than the top value of
        // the stack, then pop the stack top indices until the value
        // (indicated by the index) of the top of the stack is smaller
        // than the current value. Calculate the max value every time
        // and update it if necessary.
        Stack<Integer> stack = new Stack<Integer>();
        // Keep track of the max value.
        int max = 0;
        
        for (int i = 0; i <= heights.length; i++) {
            int cur = 0;
            if (i != heights.length) {
                cur = heights[i];
            }
            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                // Get the height of the previous value
                int height = heights[stack.pop()];
                // If the stack is empty, the width is the sum of index 
                // from 0 to i. Therefore, width = i.
                // If the stack is not empty, the width starts from the 
                // current top of the stack, till the (i-1)th index.
                // Be careful that it is calculating the previous max, not
                // including the current i.
                int width = stack.isEmpty() ? i : (i - 1) - stack.peek();
                // Update max value is needed.
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        
        return max;
    }
}