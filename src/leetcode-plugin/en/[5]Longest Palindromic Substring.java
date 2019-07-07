//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000. 
//
// Example 1: 
//
// 
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: "cbbd"
//Output: "bb"
// 
//

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] mem=new boolean[n][n];
        String answer = null;
        for(int i = n - 1; i >= 0; i--){
            for(int j=i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    mem[i][j] = j - i < 3 || mem[i+1][j-1];
                }
                if(mem[i][j] && (answer == null || j - i + 1 >= answer.length())){
                    answer = s.substring(i, j + 1);
                }
            }
        }
        return answer == null? "": answer;
    }
}