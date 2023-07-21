package com.landon.leetcode;

import java.util.*;

public class Q648 {
    //HashSet
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> rootSet = new HashSet<>();
        for (String s : dictionary) {
            rootSet.add(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (rootSet.contains(word.substring(0,j + 1))){
                    words[i] = word.substring(0,j + 1);
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
    //按字符串长短排序，从短到长 starstWith()判断是否为前缀，然后替换
    public String replaceWords2(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return -1;
                else if (o1.length() == o2.length()) {
                    return 0;
                }
                return 1;
            }
        });
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (String s : dictionary) {
                if (word.startsWith(s)) {
                    words[i] = s;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }
    //不停的将字符串替换为更短的前缀
    public String replaceWords3(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        for (String s : dictionary) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(s))
                    words[i] = s;
            }
        }
        return String.join(" ", words);
    }

    /**
     * 字典树（前缀树）来前缀匹配并替换
     */
    public String replaceWords4(List<String> dictionary, String sentence) {
        Trie1 trie = new Trie1();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (trie.search(word.substring(0, j + 1))) {
                    words[i] = word.substring(0, j + 1);
                    break;
                }
            }
        }
        return String.join(" ",words);
    }
}
class Trie1 {
    class TireNode {
        boolean end;
        TireNode[] next = new TireNode[26];
    }
    TireNode root;
    public Trie1() {
        root = new TireNode();
    }
    public void  insert(String word) {
        TireNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null)
                p.next[idx] = new TireNode();
            p = p.next[idx];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TireNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (p.next[idx] == null)
                return false;
            p = p.next[idx];
        }
        return p.end;
    }
}
