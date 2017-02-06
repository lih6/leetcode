public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // corner case
        if (prerequisites == null) {
            return null;
        }
        
        // If there is no rerequisites, just return an array with all the courses
        if (prerequisites.length == 0) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }
        
        // Construct a array to record all the prerequisites
        int[] record = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            record[prerequisites[i][0]]++;
        }
        
        // Use BFS approach: store courses with 0 prerequisites into a queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (record[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Keep track of the number of classes in the queue
        int numClass = queue.size();
        
        // Initialize the return value
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            // Get the current class out of queue and put it into the return array.
            int cur = queue.poll();
            result[index] = cur;
            index++;
            for (int i = 0; i < prerequisites.length; i++) {
                // If there is a class that have cur as prerequisites, reduce the 
                // number of prerequisites of that class. If that class now has 0
                // prerequisites, add it to the queue.
                if (prerequisites[i][1] == cur) {
                    record[prerequisites[i][0]]--;
                    if (record[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        // Increment the number of classes in queue
                        numClass++;
                    }
                }
            }
        }
        
        if (numClass != numCourses) {
            return new int[0];
        } else {
            return result;
        }
    }
}