/** 26. Remove Duplicates from Sorted Array My Submissions QuestionEditorial Solution
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(nums == null || len== 0){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < len; i++){
            if (nums[i] != nums[count]){
                nums[++count] = nums[i];
            }
        }
        return count+1;
    }
}