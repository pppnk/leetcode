//Given a string, find the length of the longest substring without repeating characters. 
//
// 
// Example 1: 
//
// 
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", with the length of 3. 
// 
//
// 
// Example 2: 
//
// 
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// 
// Example 3: 
//
// 
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
// 
// 
// 
// 
//

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int maximum = 0;
        int count = 0;
        int left = 0;
        int currentChar;
        int[] mem = new int[256];
        for(int right = 0; right < s.length(); right++){
            currentChar = (int) s.charAt(right);
            mem[currentChar]++;
            count++;
            if(mem[currentChar] != 1){
                maximum = Math.max(maximum, count - 1);
                while(mem[currentChar] != 1){
                    mem[(int) s.charAt(left)]--;
                    left++;
                    count--;
                }
            }
        }
        return maximum == 0? s.length(): Math.max(maximum, count);
    }
}