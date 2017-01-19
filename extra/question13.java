public class Solution {
    // Symbol	I	V	X	L	C	D	M
    // Value	1	5	10	50	100	500	1,000
    // put left means less (starting from 4), put right means more (ending at 3)
    
    public int romanToInt(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // core logic
        Map<Character, Integer> number = new HashMap<Character, Integer>();
        number.put('I', 1);
        number.put('V', 5);
        number.put('X', 10);
        number.put('L', 50);
        number.put('C', 100);
        number.put('D', 500);
        number.put('M', 1000);
        
        int length = s.length();
        int result = number.get(s.charAt(length - 1));
        int previous = result;
        for (int i = length - 2; i >= 0; i--) {
            int current = number.get(s.charAt(i));
            if (previous <= current) {
                result += current;
            } else {
                result -= current;
            }
            previous = current;
        }
        
        return result;
    }
}