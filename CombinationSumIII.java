/**216. Combination Sum III  
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

soln: backtracking 
*/

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	    int[] num = {1,2,3,4,5,6,7,8,9};
	    dfs(result, new ArrayList<Integer>(), num, k, n, 0);
	    return result;
	}

	public void dfs(List<List<Integer>> result, List<Integer> list, int[] num, int k, int target, int start){
	    if (k == 0 && target == 0){
	        result.add(new ArrayList<Integer>(list));
	    }
	    for (int i = start; i < num.length && target > 0 && k >0; i++){
	        list.add(num[i]);
	        dfs(result, list, num, k-1,target-num[i],i+1);
	        //The list.remove(list.size() - 1) need to change the element here.
	        //When k=3, n=9,[1]->[1,2]->[1,2,3].sum is not 9. no more backtracking
	        //After list.remove(list.size() - 1), it becomes [1,2].
	        // Then next follows [1,2,4], sum is not 9, 
	        //repeat untill [1,2,6].
	        list.remove(list.size()-1);
	    }
	}
}