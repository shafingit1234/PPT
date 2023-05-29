package Assignment1;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
	public static void main(String[] args) {
		Solution sol  = new Solution();
		int[] arr = {1,2,3,4,5,6,7,8};
		int [] ans = sol.twoSum(arr , 3);
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
	public static class Solution {
	    public int[] twoSum(int[] nums, int target) {
	        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	        for(int i = 0 ; i<nums.length ;i++)
	        {
	            if(mp.containsKey(target - nums[i])){
	                return new int []{mp.get(target - nums[i]) , i};
	            }
	            mp.put(nums[i] , i);
	        }
	        return new int []{0,0};
	    }
	}
}
