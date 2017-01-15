public class Solution {
    public void rotate(int[][] matrix) {
        // corner case
        if(matrix == null || matrix.length == 0){
            return;
        }
        int length = matrix.length;

        if (length <= 1) {
            return;
        }

        int numOfLayers = length / 2; // Smaller half
        int numOfPairs = length - 1;

        for (int layer = 0; layer < numOfLayers; layer++) {
            for (int pair = layer; pair < numOfPairs; pair++) {
                int first = matrix[layer][pair];
                int second = matrix[pair][numOfPairs];
                int third = matrix[numOfPairs][length - 1 - pair];
                int fourth = matrix[length - 1 - pair][layer];

                matrix[layer][pair] = fourth;
                matrix[pair][numOfPairs] = first;
                matrix[numOfPairs][length - 1 - pair] = second;
                matrix[length - 1 - pair][layer] = third;

            }
            numOfPairs--;
        }
    }
}
