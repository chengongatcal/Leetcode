/** 11. Container With Most Water 
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
*/



public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int area = 0;
        if (height.length == 0){
            return max;
        }
        int start = 0;
        int end = height.length -1;
        while(start < end){
            int h = Math.min(height[end], height[start]);
            int w = end - start;
            area = h * w;
            max = Math.max(max, area);
            
            if(height[start] < height[end]){
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}