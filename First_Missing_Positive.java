/** 41. First Missing Positive
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.
*/

//version 1
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int missing = 1;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if (nums[i] > 0 && nums[i] >= missing){
                if(nums[i] != missing){
                    return missing;
                } else {
                    missing++;
                }
            }
        }
        return missing;
    }
}

//version 2
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (nums == null) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != (i+1)) {
                int tmp = nums[nums[i]-1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < len; i ++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
        }
        return len + 1;
    }
}