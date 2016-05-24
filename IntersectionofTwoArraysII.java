/** 350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> intersect = new ArrayList<>();
        for (Integer i : nums1) {
            list.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
          if (list.contains(nums2[i])) {
              intersect.add(nums2[i]);
              list.remove(list.indexOf(nums2[i]));
          }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }
}