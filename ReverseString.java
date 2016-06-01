/** 344. Reverse String
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/


public class Solution {
    public String reverseString(String s) {
        char[] string = s.toCharArray();
        int len = string.length;
        for(int i = 0; i < len/2; i++){
            char temp = string[i];
            string[i] = string[len-1-i];
            string[len-1-i] = temp;
        }
        return new String(string);
    }
}