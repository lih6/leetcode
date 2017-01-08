public class Solution {
    public String simplifyPath(String path) {
        // corner case
        if (path == null || path.length() == 0) {
            return new String();
        }
        
        Deque<String> tracker = new ArrayDeque<String>();
        
        String[] separatedPath = path.split("/");
        
        for (int i = 0; i < separatedPath.length; i++) {
            if (separatedPath[i].equals("..")) {
                if (!tracker.isEmpty()) {
                    tracker.removeFirst();
                }
            } else if (!separatedPath[i].equals("") && !separatedPath[i].equals(".")) {
                tracker.addFirst(separatedPath[i]);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!tracker.isEmpty()) {
            result.append("/");
            result.append(tracker.removeLast());
        }
        
        if (result.length() == 0) {
            return new String("/");
        }
        
        return result.toString();
    }
}