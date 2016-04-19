/** Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
*/



public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;
        int curr = 0;
        List<Integer> ret = new ArrayList<Integer>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++){
            if(curr != nums[i]){
                curr = nums[i];
                count = 1;
            } else {
                count++;
            }
            if (count > len/3 && !ret.contains(curr)){
                ret.add(curr);
            }
        }
        return ret;
    }
}