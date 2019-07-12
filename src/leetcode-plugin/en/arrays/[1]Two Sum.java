//Given an array of integers, return indices of the two numbers such that they add up to a specific target. 
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice. 
//
// Example: 
//
// 
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
// 
//

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=0,lookup;
        int[] answer;
        cycle: for(i=0;i<nums.length;i++){
            lookup = target - nums[i];
            for(j=0;j<nums.length;j++){
                if(i!=j && nums[j] == lookup){
                    break cycle;
                }
            }
        }
        answer = new int[]{i,j};
        return answer;
    }
}