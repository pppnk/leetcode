//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements. 
//
// Example: 
//
// 
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0] 
//
// Note: 
//
// 
// You must do this in-place without making a copy of the array. 
// Minimize the total number of operations. 
//

class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = nums.length - 1;
        int i = pointer;
        int temp, k;
        while(pointer >= 0){
            while(pointer >= 0 && nums[pointer] != 0){
                pointer--;
            }
            if(pointer >= 0 && pointer != i){
                k = pointer;
                while(i != k){
                    temp = nums[k + 1];
                    nums[k + 1] = nums[k];
                    nums[k] = temp;
                    k++;
                }
            }
            i--;
            pointer--;
        }
    }
}