package com.landon.leetcode;

public class Q208 {
}
//哈希表版
class Trie {
    TrieNode root;
    class TrieNode {
        boolean end;
        TrieNode[] next = new TrieNode[26];
    }
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null)
                p.next[idx] = new TrieNode(); //边代表有无字符，点记录是否为【结尾】和【下一个字符】
            p = p.next[idx];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null)
                return false;
            p = p.next[idx];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (p.next[idx] == null)
                return false;
            p = p.next[idx];
        }
        return true;
    }
}
//数组版
class Trie2 {
    int N = 100050;
    int[][] trie;
    int[] count;
    int index;
    public Trie2() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (trie[p][idx] == 0)
                trie[p][idx] = ++index;
            p = trie[p][idx];
        }
        count[p]++;
    }

    public boolean search(String word) {
        int p = 0;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (trie[p][idx] == 0)
                return false;
            p = trie[p][idx];
        }
        return count[p] != 0;
    }

    public boolean startsWith(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (trie[p][idx] == 0)
                return false;
            p = trie[p][idx];
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
