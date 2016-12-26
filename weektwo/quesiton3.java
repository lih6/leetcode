class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        string keep_track;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int found = keep_track.find(s[i]);
            if (found != string::npos) {
                if (keep_track.length() > len) {
                    len = keep_track.length();
                }
                keep_track.erase(keep_track.begin(), keep_track.begin() + found + 1);
            }
            keep_track += s[i];
        }
        
        if (len < keep_track.length()) {
            len = keep_track.length();
        }
        
        return len;
    }
};