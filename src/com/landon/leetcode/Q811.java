package com.landon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hash = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String cpdomain : cpdomains) {
            String[] temp = cpdomain.split(" ");
            int num = Integer.parseInt(temp[0]);
            String[] domains = temp[1].split("\\.");
            int n = domains.length;
            String domain = domains[n - 1];
            hash.put(domain, hash.getOrDefault(domain, 0) + num);
            for (int i = n - 2; i >= 0; i--) {
                    domain = domains[i] + "." + domain;
                    hash.put(domain, hash.getOrDefault(domain, 0) + num);
            }
        }
        hash.forEach((key, value) -> {
            ans.add(value + " " + key);
        });
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Q811().subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}
