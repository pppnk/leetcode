//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// Note that an empty string is also considered valid. 
//
// Example 1: 
//
// 
//Input: "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: "{[]}"
//Output: true
// 
//

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        char validate;
        char c;
        //Maps each closing character
        HashMap<Character, Character> map = new HashMap();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        for(int i=0; i < s.length(); i++){
            c = s.charAt(i);
            // If it's not a closing character push it to the stack
            if(c == '(' || c == '{' || c == '['){
                stack.push(s.charAt(i));
            } else {
                // check if the stack is empty
                if(stack.size() == 0){
                    return false;
                }
                validate = stack.pop();
                // match the closing character to the map
                if(map.get(c) != validate){
                    return false;
                }
            }
        }
        // if there's stuff left to process in the stack return false
        return stack.size() == 0;
    }
}