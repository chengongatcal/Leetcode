/** Given an array of integers, return indices of the two numbers 
such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] index = new int[2];
		if(nums == null || nums.length < 2){
			return index;
		}
		int len = nums.length;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<len; i++){
			int val = target - nums[i];
			if(!map.containsKey(val)){
				map.put(nums[i],i);
			}else{
				index[0] = map.get(val);
				index[1] = i;
				return index;
			}
		}
		return index;
	}
}