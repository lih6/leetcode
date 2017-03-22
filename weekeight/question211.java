// 211. Add and Search Word - Data structure design
public class WordDictionary {
    // using a Trie Tree to solve the problem
    class TrieNode {
        public char val;
        public TrieNode[] children = new TrieNode[26];
        public boolean isLeaf;
        
        public TrieNode() {
            
        }
        
        public TrieNode(char val) {
            this.val = val;
        }
    }
    
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        // corner case
        if (word == null || word.length() == 0) {
            return;
        }
        
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
        return;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    // to solve the "." problem, recursion is considered
    public boolean search(String word) {
        // corner case
        if (word == null || word.length() == 0) {
            return true;
        }
        
        return helper(word, root);
    }
    
    private boolean helper(String word, TrieNode root) {
        // base case
        if (root == null) {
            return false;
        }
        
        if (word == null || word.length() == 0) {
            return root.isLeaf;
        }
        
        // current level
        if (word.charAt(0) == '.') {
            for (int i = 0; i < 26; i++) {
                if (helper(word.substring(1), root.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            if (root.children[word.charAt(0) - 'a'] == null) {
                return false;
            }
            return helper(word.substring(1), root.children[word.charAt(0) - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */