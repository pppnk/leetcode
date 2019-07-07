//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
//

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList();
        HashMap<Integer, List<Integer>> mem = new HashMap();
        List<Integer> indexes;
        for(int i = 0; i < nums.length; i++){
            indexes = mem.containsKey(nums[i])? mem.get(nums[i]): new ArrayList();
            if(indexes.size() < 3){
                indexes.add(i);
                mem.put(nums[i], indexes);
            }
        }
        HashSet<String> uniqueAns = new HashSet();
        String currentAns;
        ArrayList<Integer> triplet;
        int target, currIndex;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                target = nums[i] + nums[j];
                target *= -1;
                if(mem.containsKey(target)){
                    indexes = mem.get(target);
                    for(int k = 0; k < indexes.size(); k++){
                        currIndex = indexes.get(k);
                        if(currIndex > j && i != currIndex && j != currIndex){
                            triplet = new ArrayList(Arrays.asList(nums[i], nums[j], nums[currIndex]));
                            Collections.sort(triplet);
                            currentAns = triplet.get(0) + ":" + triplet.get(1) + ":" + triplet.get(2);
                            if(!uniqueAns.contains(currentAns)){
                                uniqueAns.add(currentAns);
                                answer.add(triplet);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}