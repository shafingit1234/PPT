package Assignment1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problem {
	public static void main(String[] args) {
		Solution sol  = new Solution();
		int[] arr = {1,2,3,4,5,6,7,8};
		int [] ans = sol.Question1(arr , 3);
		for(int i : ans) {
			System.out.print(i + " ");
		}
	}
	public static class Solution {
	    public int[] Question1(int[] nums, int target) {
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
	    public int Question2(int[] nums, int val) {
	        int t = -1;
	        for(int i = 0 ; i<=(nums.length-1) ; i++)
	        {
	            if(nums[i] == val)
	            {
	                nums[i] = t;
	            }
	        }
	        int p = 0;
	        int count = 0;
	        for(int i = 0 ; i<nums.length ; i++)
	        {
	            if(nums[i] >= 0)
	            {
	                int temp = nums[i];
	                nums[i] = nums[p];
	                nums[p] = temp;
	                p++;
	                count++;
	            }
	        }
	        return count;
	    }
	    public int Question3(int[] arr, int target) {
	        int low = 0;
	        int high = arr.length-1;
	        int mid = -1;
	        while(low <= high)
	        {
	            mid = low + (high - low)/2;
	            if(arr[mid] == target)
	            {
	                return mid;
	            }
	            else if(arr[mid]>target) high = mid-1;
	            else low = mid+1;
	        }
	        int i = mid;
	        for(; i<arr.length; i++)
	        {
	            if(arr[i] > target) break; 
	        }
	        return i;
	    }
	    public int[] Question4(int[] digits) {
	        //count continuous 9's from behind
	        int cnt = 0;
	        for(int i=digits.length-1 ; i>=0 ; i--){
	            if(digits[i] == 9){
	                cnt++;
	            }
	            else{
	                break;
	            }
	        }
	        if(cnt == digits.length){
	            int ans[] = new int[digits.length + 1];
	            ans[0] = 1;
	            for(int i=1 ; i<=digits.length ; i++){
	                ans[i] = 0;
	            }
	            return ans;
	        }
	        if(cnt == 0){
	            digits[digits.length - 1]++;
	            return digits;
	        }
	        int p = 0;
	        while(cnt > 0){
	            digits[digits.length - p - 1] = 0;
	            cnt--;
	            p++;
	        }
	        digits[digits.length-p-1]++;
	        return digits;
	    }
	    public void Question5(int[] nums1, int m, int[] nums2, int n) {
	        int i = m-1;
	        int j = n-1;
	        int p = nums1.length - 1;
	        while(p>=0){
	            if(i>=0 && j >=0 && nums1[i] >= nums2[j]){
	                nums1[p] = nums1[i];
	                i--;
	            }
	            else if(j >= 0){
	                nums1[p] = nums2[j];
	                j--;
	            }
	            p--;
	        }
	    
	    }
	    public boolean Question6(int[] nums) {
	        HashSet<Integer> hs = new HashSet<Integer>();
	        for(int i=0 ; i<nums.length ; i++){
	            hs.add(nums[i]);
	        }
	        if(hs.size() == nums.length){
	            return false;
	        }
	        return true;
	    }
	    public void Question7(int[] nums) {
	        int i=0;
	        int j=0;
	        while(i < nums.length){
	            if(nums[i] != 0){
	                nums[j] = nums[i];
	                j++;
	            }
	            i++;
	        }
	        while(j < nums.length){
	            nums[j] = 0;
	            j++;
	        }
	    }
	    public int[] Question8(int[] nums) {
	        //using bitmasking
	        int xor = 0;
	        for(int i : nums)
	        {
	            xor ^= i;
	        }
	        for(int i=1 ; i<=nums.length ; i++)
	        {
	            xor ^= i;
	        }
	        int ans1 = 0;
	        int ans2 = 0;
	        int firstBitOne = xor & ~(xor - 1);
	        for(int i : nums){
	            if((i & firstBitOne) != 0){
	                ans1 ^= i;
	            }
	            else{
	                ans2 ^= i;
	            }
	        }
	        for(int i= 1 ; i<=nums.length ; i++){
	            if((i & firstBitOne) != 0){
	                ans1 ^= i;
	            }
	            else{
	                ans2 ^= i;
	            }
	        }
	        for(int i : nums){
	            if(i == ans2){
	                return new int[]{ans2, ans1};
	            }
	        }
	        return new int[]{ans1 , ans2};
	    }
	}
}
