// 218. The Skyline Problem
public class Solution {
    // construct a keyPoint class to store all the key points of the skyline
    class KeyPoint {
        int index;
        int height;
        boolean isStart;
        
        public KeyPoint(int index, int height, boolean isStart) {
            this.index = index;
            this.height = height;
            this.isStart = isStart;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        // construct return value
        List<int[]> result = new ArrayList<int[]>();
        
        // corner case
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }
        
        // construct all the key points, and use a list to keep track of them
        List<KeyPoint> keylist = new ArrayList<KeyPoint>();
        
        for (int[] building : buildings) {
            KeyPoint start = new KeyPoint(building[0], building[2], true);
            KeyPoint end = new KeyPoint(building[1], building[2], false);
            keylist.add(start);
            keylist.add(end);
        }
        
        // sort the list according to index and height
        Collections.sort(keylist, new Comparator<KeyPoint>() {
            public int compare(KeyPoint a, KeyPoint b) {
                if (a.index != b.index) {
                    return Integer.compare(a.index, b.index);
                }
                
                // higher, smaller
                if (a.isStart && b.isStart) {
                    return Integer.compare(b.height, a.height);
                }
                
                // lower, smaller
                if (!a.isStart && !b.isStart) {
                    return Integer.compare(a.height, b.height);
                }
                
                return a.isStart ? -1 : 1;
            }
        });
        
        // create a max heap to store the current largest height
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        
        // go through all the key points to find the skyline
        for (KeyPoint key : keylist) {
            if (key.isStart) {
                if (heap.isEmpty() || key.height > heap.peek()) {
                    result.add(new int[] { key.index, key.height });
                }
                heap.add(key.height);
            } else {
                heap.remove(key.height);
                if (heap.isEmpty()) {
                    result.add(new int[] { key.index , 0 });
                } else if (heap.peek() < key.height) {
                    result.add(new int[] { key.index, heap.peek() });
                }
            }
        }
        
        return result;
    }
}