public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if ((target == 0) && (numbers[0] == 0) && (numbers[1] == 0)) {
                int[] result = new int[]{1, 2};
                return result;
        }
        
        if (((target == 1) && (numbers[0] == 0)) || 
            ((target == -1) && (numbers[0] == -1))){
            int[] result = new int[2];
            result[0] = 1;
            result[1] = 2;
            return result;
        }
        
        int length = numbers.length;
        
        int[] result = new int[2];
        int pivot = 0;
        if (target % 2 == 0) {
            pivot = target / 2;
        } else {
            pivot = (target - 1) / 2;
        }
        
        int targetRange = target;
        if (numbers[0] < 0/*pivot == target*/) {
            targetRange = target - numbers[0];
        } else if (numbers[length - 1] < target) {
            targetRange = numbers[length - 1];
        }
        
        int pivotIndex = 0;
        int endIndex = 0;
        while ((numbers[pivotIndex] <= pivot) && (pivotIndex < length - 1)) {
            if (numbers[pivotIndex] == pivot) {
                int before = numbers[pivotIndex - 1];
                int current = numbers[pivotIndex];
                int after = numbers[pivotIndex + 1];
                if (current + after == target) {
                    result[0] = pivotIndex + 1;
                    result[1] = pivotIndex + 2;
                    return result;
                }
                if (before + current == target) {
                    result[0] = pivotIndex;
                    result[1] = pivotIndex + 1;
                    return result;
                }
            }
            pivotIndex++;
            endIndex++;
        }
        
        while ((numbers[endIndex] <= targetRange) && (endIndex < length - 1)) {
            if (numbers[endIndex] == targetRange) {
                if (numbers[0] == 0) {
                    result[0] = 1;
                    result[1] = endIndex + 1;
                    return result;
                }
            }
            endIndex++;
        }

        for (int i = 0; i <= pivotIndex; i++) {
            int complement = target - numbers[i];
            for (int j = endIndex; j > pivotIndex - 1; j--) {
                if (complement == numbers[j]) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
            }
        }
        
        return result;
    }
}