package com.landon.leetcode;

public class Q676 {
}

class MagicDictionary {
    TrieNode root;
    class TrieNode {
        boolean end;
        TrieNode[] next = new TrieNode[26];
    }
    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildDict(String[] dictionary) {
        TrieNode p = root;
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < dictionary[i].length(); j++) {
                int idx = dictionary[i].charAt(j) - 'a';
                if (p.next[idx] == null)
                    p.next[idx] = new TrieNode();
                p = p.next[idx];
            }
            p.end = true;
        }
    }

    public boolean search(String searchWord) {
        TrieNode p = root;
        int changeFlag = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            int idx = searchWord.charAt(i) - 'a';
            if (p.next[idx] == null) {
                if (changeFlag == 1) return false;
                for (int j = 0; j < 26; j++) {
                    if (p.next[j] != null) {
                        p = p.next[j];
                        changeFlag++;
                        break;
                    }
                }
            } else {
                p = p.next[idx];
            }
        }
        return p.end;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
