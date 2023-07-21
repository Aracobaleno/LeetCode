package com.landon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q535 {
    private Map<Integer, String> dataBase = new HashMap<>();
    private int id;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        id++;
        dataBase.put(id, longUrl);
        return "http://tinyurl.com/" + id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }

    public static void main(String[] args) {
        Q535 codec = new Q535();
        System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(codec.encode("https://leetcode.com/problems/design-tinyurl"));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
