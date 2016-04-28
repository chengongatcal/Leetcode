/** 205. Isomorphic Strings
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.
**/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if(sc.length != tc.length){
            return false;
        }
        int [] si = new int[128];
        int [] ti = new int[128];
        for(int i = 0; i < sc.length; i++){
            int c1 = sc[i];
            int c2 = tc[i];
            if(si[c1] != 0 && si[c1] != c2 || ti[c2] != 0 && ti[c2] != c1){
                return false;
            }
            si[c1] = c2;
            ti[c2] = c1;
        }
        return true;
    }
}