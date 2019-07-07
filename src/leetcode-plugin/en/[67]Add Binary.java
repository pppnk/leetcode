//Given two binary strings, return their sum (also a binary string). 
//
// The input strings are both non-empty and contains only characters 1 or 0. 
//
// Example 1: 
//
// 
//Input: a = "11", b = "1"
//Output: "100" 
//
// Example 2: 
//
// 
//Input: a = "1010", b = "1011"
//Output: "10101" 
//

class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int x,y,z;
        StringBuilder answer = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            x = i >= 0? a.charAt(i--) - '0': 0;
            y = j >= 0? b.charAt(j--) - '0': 0;
            z = x + y + carry;
            carry = z > 1? 1: 0;
            answer.insert(0, z % 2 == 0? "0": "1");
        }
        return answer.toString();
    }
}