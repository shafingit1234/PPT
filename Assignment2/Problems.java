package Assignment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problems {
	public static void main(String[] args) {
	}

	public static class Solution {
		public int Question1(int[] nums) {
	        Arrays.sort(nums);
	        int sum = 0;
	        for(int i=nums.length - 1 ; i >= 0 ;){
	            sum += Math.min(nums[i] , nums[i-1]);
	            i = i - 2;
	        }
	        return sum;
		}

		public int Question2(int[] candyType) {
	        int valid = candyType.length/2;
	        HashMap<Integer , Integer> hm = new HashMap<>();
	        for(int i : candyType){
	            hm.put(i , hm.getOrDefault(i,0) + 1);
	        }
	        return Math.min(hm.size(),valid);
		}

		public int Question3(int[] nums) {
	        HashMap<Integer, Integer> hm = new HashMap<>();
	        int mx = Integer.MIN_VALUE;
	        int mn = Integer.MAX_VALUE;
	        for(int i=0; i<nums.length ; i++){
	            if(hm.containsKey(nums[i]) == false){
	                hm.put(nums[i] , 0);
	            }
	            hm.put(nums[i] , hm.get(nums[i]) + 1);
	            mn = Math.min(mn , nums[i]);
	            mx = Math.max(mx , nums[i]);
	        }
	        int ans= 0;
	        for(int i = 0; i<nums.length ; i++){
	           int temp = nums[i] - 1;
	           if(hm.containsKey(temp)){
	               int sum = hm.get(nums[i]) + hm.get(temp);
	               ans = Math.max(sum , ans);
	           }
	        }
	        return ans;
		}
		public boolean Question4(int[] nums, int n) {
			int count= 0;
	        if(n == 0){
	            return true;
	        }
	        if(nums.length == 1){
	            if(nums[0] == 0){
	                if(n <= 1){
	                    return true;
	                }
	            }
	            return false;
	        }
	        if(nums[0] == 0){
	            if(nums[1] != 1){
	                count++;
	                nums[0]  = 1;
	            }
	        }
	        for(int i=1; i < nums.length-1 ; i++){
	            if(nums[i] == 0){
	                if(nums[i+1] != 1 && nums[i-1] != 1){
	                    count++;
	                    nums[i] = 1;
	                }
	            }
	        }
	        if(nums[nums.length-1] == 0){
	            if(nums[nums.length-2] != 1){
	                count++;
	            }
	        }
	        if(count >= n){
	            return true;
	        }
	        return false;
		}
		public int Question5(int[] nums, int target) {
	        int left = 0; 
	        int right = nums.length - 1; 
	        
	        while (left <= right) { 
	            int mid = left + (right - left) / 2; 
	            
	            if (nums[mid] == target) { 
	                return mid; 
	            } else if (nums[mid] < target) { 
	                left = mid + 1; 
	            } else {
	                right = mid - 1; 
	            }
	        }
	        
	        return -1; 
		}

		public int Question6(int[] nums) {
	        Arrays.sort(nums);
	        int case1 = nums[0]*nums[1]*nums[nums.length-1];
	        int case2 = nums[nums.length - 1]*nums[nums.length-2]*nums[nums.length-3];
	        return Math.max(case1, case2);
		}

		public boolean Question7(int[] nums) {
	        boolean increasing = false, decreasing = false;
	        for (int i=1; i< nums.length; i++){
	            if (nums[i]>nums[i-1]){
	                increasing=true;
	            } else if (nums[i]<nums[i-1]) {
	                decreasing=true;
	            }
	        }
	        boolean result = (increasing && decreasing) ? false:true;
	        return result;
		}

		public int Question8(int[] nums, int k) {
	        int mn = Integer.MAX_VALUE;
	        int mx = Integer.MIN_VALUE;
	        for(int i : nums){
	            mn = Math.min(mn , i);
	            mx = Math.max(mx , i);
	        }
	        int ans = (mx - k) - (mn + k);
	        return Math.max(0 , ans); 
		}

		
	}
}
