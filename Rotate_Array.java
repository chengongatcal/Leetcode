/** 189. Rotate Array My Submissions QuestionEditorial Solution

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

*/

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int r = k%n;
        int[] result = new int[nums.length];
        for(int i = 0; i < r; i++){
            result[i] = nums[n-r+i];
        }
        int j=0;
        for(int i=r; i<n; i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy( result, 0, nums, 0, n );
    }
}
