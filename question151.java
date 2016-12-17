public class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }
        
        if (s.indexOf(" ") < 0) {
            return s;
        }
        
        String[] separate = s.split(" ");
        
        if (separate.length == 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        if (separate.length == 1)  {
            if (separate[0].equals(" ")) {
                return "";
            } else {
                result.append(separate[0]);
                return result.toString();
            }
        }
        
        for (int i = separate.length - 1; i >= 0; i--) {
            separate[i] = separate[i].replaceAll(" ", "");
            if (!separate[i].equals("")) {
                if (i != separate.length - 1) {
                    result.append(" ");
                }
                result.append(separate[i]);
            }
        }
        
        return result.toString();
    }
}