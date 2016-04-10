/** Trapping Rain Water. */

Public class Solution {
	public int trap(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int count = 0;
		int start = 0;
		int end = height.length;
		int rightMax = 0;
		int leftMax = 0;
		while (start < end){
			if(leftMax < rightMax){
				count += Math.max(leftMax - height[start], 0);
				leftMax = Math.max(leftMax, height[start++]);
			} else {
				count += Math.max(rightMax - height[--end], 0);
				rightMax = Math.max(rightMax, height[end]);
			}
		}
		return count;
	}
}