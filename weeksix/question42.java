// Solution 1:
public class Solution {
    public int trap(int[] height) {
        // Corner case:
        // If the height array is null or the size of the array is smaller than 2, return 0.
        if (height == null || height.length < 2) {
            return 0;
        }
        
        // Core logic:
        // Use two scanners to scan from the left and the right.
        // At the same time, keep track of the largest left bar and largest right bar.
        // If the left bar is smaller than the right bar, move left to the right
        // and compare.
        // If current left value is larger than the left bar, update the left bar.
        // Otherwise, calculte the rain water that can be trapped and move left.
        // If the right bar is smaller than the left bar, move right to the left
        // and compare.
        // If current right value is larger than teh right bar, update the right bar.
        // Otherwise, calculate the rain watet that can be trapped and move right.
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        
        int left = 1;
        int right = height.length - 2;
        
        int total = 0;
        
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] < maxLeft) {
                    total += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    total += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }
        
        return total;
    }
}

// Solution 2:
public class Solution {
    public int trap(int[] height) {
        // Corner case:
        // If the height array is null or the size of the array is smaller than 2, return 0.
        if (height == null || height.length < 2) {
            return 0;
        }
        
        // Core logic:
        // Use two scanners to scan from the left and the right.
        // At the same time, keep track of the largest left bar and largest right bar.
        // If current left is smaller than current right, update the left bar and total.
        // Otherwise, update right bar and total.
        int left = 0;
        int right = height.length - 1;
        
        int maxLeft = height[left];
        int maxRight = height[right];
        
        int total = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                total += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                total += maxRight - height[right];
            }
        }
        
        return total;
    }
}