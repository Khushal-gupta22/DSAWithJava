package com.company;

import java.util.HashMap;
import java.util.Set;

public class hashmaps {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India" , 135);
        hm.put("China", 200);
        hm.put("Pak", 30);
        hm.put("US", 20);
        hm.put("UK", 10);

        System.out.println(hm);

        hm.put("nigeria", 5); // main thing is that you can't control where the new vale ts added ie in this case
        hm.put("US", 25);     // nigeria got added randomly you can't control
        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("utopia"));

        System.out.println(hm.containsKey("India'"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String key : hm.keySet()) {
                Integer val = hm.get(key);
            System.out.println(key + " " + val);
            //you won't get the same order with which you inputed in
            }
    } // all of these function run in O(1)
}
