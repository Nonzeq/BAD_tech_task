package com.kobylchak;



import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {


    public static char getChar(String text){

        return findChar(text);
    }

    private static char findChar(String text){
        text = text.trim().replaceAll("\n", " ");
        text = text.replaceAll("[^a-zA-Z0-9\\s+]", "");

        String[] data = text.split(" ");


        Set<Character> set = new LinkedHashSet<>();
        Set<Character> setDublicates = new HashSet<>();

        for (String s:data){
            if(!s.isEmpty()){
                int unique = isUnique(s);

                if(unique != -1){

                    if(!set.contains(s.charAt(unique)) && !setDublicates.contains(s.charAt(unique))){
                        set.add(s.charAt(unique));
                    }else{
                        set.remove(s.charAt(unique));
                        setDublicates.add(s.charAt(unique));
                    }
                }

            }
        }


        return set.isEmpty() ? ' ' : set.iterator().next();
    }

    private static int isUnique(String s){

        int[] arr = new int[256];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 0]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = arr[s.charAt(i) - 0];
            if(idx == 1){
                return i;
            }
        }

        return -1;
    }
}
