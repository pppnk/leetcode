//Given a string s , find the length of the longest substring t that contains at most 2 distinct characters. 
//
// Example 1: 
//
// 
//Input: "eceba"
//Output: 3
//Explanation: t is "ece" which its length is 3.
// 
//
// Example 2: 
//
// 
//Input: "ccaabbb"
//Output: 5
//Explanation: t is "aabbb" which its length is 5.
//

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right;
        int maximum = Integer.MIN_VALUE;
        int counter = 0;
        int[] mem = new int[256];
        int currentChar;
        boolean hasRestriction = false;
        for(right = 0; right < s.length(); right++){
            currentChar = (int) s.charAt(right);
            if(mem[currentChar] == 0){
                counter++;
            }
            mem[currentChar]++;
            if(counter == 3){
                hasRestriction = true;
                maximum = Math.max(right - left, maximum);
                while(counter == 3){
                    currentChar = (int)s.charAt(left);
                    mem[currentChar]--;
                    left++;
                    if(mem[currentChar] == 0){
                        counter--;
                    }
                }
            }
        }
        return hasRestriction? Math.max(maximum, right - left): s.length();
    }
}