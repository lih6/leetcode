// 207. Course Schedule
public class Solution {
    // Solution 1: DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        // construct a map:
        // for each course, store all the courses one can take after taking that course
        List<List<Integer>> map = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<Integer>());
        }
        
        // add next courses for all courses
        for (int[] courses : prerequisites) {
            map.get(courses[1]).add(courses[0]);
        }
        
        // construct a visited array for all the courses
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // if a circle is detected, return false
            if (findCircle(map, i, visited)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean findCircle(List<List<Integer>> map, int course, boolean[] visited) {
        // if current course has been visited, there is a circle
        if (visited[course]) {
            return true;
        }
        
        // set the current course to visited
        visited[course] = true;
        // get all the courses one can take after taking "course"
        for (int next : map.get(course)) {
            // find whether there is a circle or not
            if (findCircle(map, next, visited)) {
                return true;
            }
        }
        visited[course] = false;
        return false;
    }
}

public class Solution {
    // Solution 2: BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        // construct a map to store all the relationships between courses
        int[][] map = new int[numCourses][numCourses];
        // construct an indegree array to store the number of prerequisites each course needs
        int[] indegree = new int[numCourses];
        
        // add all the edges into the map
        for (int[] courses : prerequisites) {
            int prereq = courses[0];
            int cur = courses[1];
            indegree[cur]++;
            map[prereq][cur] = 1;
        }
        
        // need a queue for bfs
        Queue<Integer> queue = new ArrayDeque<Integer>();
        // push all the courses with indegree 0 into the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // keep track of the number of courses been processed
        int count = 0;
        
        // using a while loop to process the rest of the courses
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (map[cur][i] == 1) {
                    if (--indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}