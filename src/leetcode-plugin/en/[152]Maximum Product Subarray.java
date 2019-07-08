//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product. 
//
// Example 1: 
//
// 
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray. 
//

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int answer = nums[0];
        int maximum = nums[0];
        int minimum = nums[0];
        int aux;
        for(int i = 1; i < nums.length; i++){
            aux = maximum;
            maximum = Math.max(Math.max(maximum * nums[i], minimum * nums[i]), nums[i]);
            minimum = Math.min(Math.min(aux * nums[i], minimum * nums[i]), nums[i]);
            answer = Math.max(maximum, answer);
        }
        return answer;
    }
}