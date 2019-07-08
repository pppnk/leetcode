//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n). 
//
// Example: 
//
// 
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
// 
//
// Note: 
//
// 
// If there is no such window in S that covers all characters in T, return the empty string "". 
// If there is such window, you are guaranteed that there will always be only one unique minimum window in S. 
// 
//

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || t.length() > s.length()){
            return "";
        }
        int[] mem = new int[256];
        for(int i = 0; i < t.length(); i++){
            mem[(int) t.charAt(i)]++;
        }
        int right;
        int left = 0;
        int minimum = Integer.MAX_VALUE;
        int localMinimum;
        int count = 0;
        int currentChar;
        int start = 0, end = 0;
        boolean found = false;
        for(right = 0; right < s.length(); right++){
            currentChar = (int)s.charAt(right);
            if(mem[currentChar] > 0){
                count++;
            }
            //value used
            mem[currentChar]--;
            if(count == t.length()){
                found = true;
                while(count == t.length()){
                    //return to mem
                    currentChar = (int) s.charAt(left);
                    mem[currentChar]++;
                    if(mem[currentChar] > 0){
                        count--;
                    }
                    left++;
                }
                localMinimum = right - (left - 1);
                if(minimum > localMinimum){
                    minimum = localMinimum;
                    start = left - 1;
                    end = right;
                }
            }
        }
        return found? s.substring(start, end + 1): "";
    }
}