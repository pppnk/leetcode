//Implement strStr(). 
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// Example 1: 
//
// 
//Input: haystack = "hello", needle = "ll"
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: haystack = "aaaaa", needle = "bba"
//Output: -1
// 
//
// Clarification: 
//
// What should we return when needle is an empty string? This is a great question to ask during an interview. 
//
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf(). 
//

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];
        kmp(next, needle);

        for(int i = 0; i < next.length; i++){
            System.out.println(next[i]);
        }
        int j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if(j == needle.length()) {
                    return i - j + 1;
                }
            } else if(j > 0){
                j = next[j - 1];
                i--;
            }
        }
        return -1;
    }

    public void kmp(int[] next, String needle){
        int length = 0;
        next[0] = 0;
        for(int i = 1; i < needle.length();){
            if(needle.charAt(i) == needle.charAt(length)){
                length++;
                next[i] = length;
                i++;
            } else if(length > 0) {
                length = next[length - 1];
            } else {
                next[i] = 0;
                i++;
            }
        }
    }
}
