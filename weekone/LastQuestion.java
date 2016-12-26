/*
    Last Question:
    
    Find if an array can be divided into two subarrays of equal sum for example: 

    Input: arr = [4, 2, 2, 2, 0]    Output: true because left part of array before 2 on index 1 sums up to 4 and after 2 :  2 + 2 + 0 = 4. 

    Input: arr = [4, 1, 3, 2, 3]    Output: true, the first 3 is the dividing point. 

    Input: arr = [6, -2, 3, 2, 3]   Output: false 

    Input: arr = []                 Output: false; no dividing point 

    Input: arr = [1]                Output: true; consider 1 is the dividing point. 

    (extra: can you do O(1) space O(n) time?)
    
    */

public class Solution {
    public boolean divideArray(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return false;
        }
        
        if (length == 1) {
            return true;
        }
        
        int pivot = length / 2;
        
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < pivot; i++) {
            left = left + arr[i];
        }
        
        for (int i = pivot + 1; i < length - 1; i++) {
            right = right + arr[i];
        }
        
        boolean leftPart = checkSum(arr, true, pivot, left, right);
        boolean rightPart = checkSum(arr, false, pivot, left, right);
        
        if ((leftPart == true) || (rightPart == true)) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkSum(int[] arr, boolean indicator, int pivot, int left, int right) {
        if (left == right) {
            return true;
        }
        
        if ((left == 0) || (right = arr.length - 1)) {
            return false;
        }
        
        int newLeft = left;
        int newRight = right;
        int newPivot = pivot;
        if (indicator == true) { // Left
            newLeft = left - arr[newPivot - 1];
            newRight = right + arr[newPivot];
            newPivot--;
        } else { // Right
            newLeft = left + arr[newPivot];
            newRight = right - arr[newPivot + 1];
            newPivot++;
        }
        
        return checkSum(arr, indicator, newPivot, newLeft, newRight);
    } 
}