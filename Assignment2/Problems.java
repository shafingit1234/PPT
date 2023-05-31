package Assignment2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Problems {
	public static void main(String[] args) {
	}

	public static class Solution {
		/*
		 * Question 1
		 * Given an integer array nums of 2n integers, group these integers into n pairs
		 * (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i
		 * is maximized. Return the maximized sum.
		 * 
		 */
		public int Question1(int[] nums) {
			Arrays.sort(nums);
			int sum = 0;
			for (int i = nums.length - 1; i >= 0;) {
				sum += Math.min(nums[i], nums[i - 1]);
				i = i - 2;
			}
			return sum;
		}

		/*
		 * Question 2
		 * Given the integer array candyType of length n, return the maximum number of
		 * different types of candies she can eat if she only eats n / 2 of them
		 * 
		 */
		public int Question2(int[] candyType) {
			int valid = candyType.length / 2;
			HashMap<Integer, Integer> hm = new HashMap<>();
			for (int i : candyType) {
				hm.put(i, hm.getOrDefault(i, 0) + 1);
			}
			return Math.min(hm.size(), valid);
		}

		/*
		 * Question 3
		 * We define a harmonious array as an array where the difference between its
		 * maximum value and its minimum value is exactly 1.
		 */
		public int Question3(int[] nums) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			int mx = Integer.MIN_VALUE;
			int mn = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
				if (hm.containsKey(nums[i]) == false) {
					hm.put(nums[i], 0);
				}
				hm.put(nums[i], hm.get(nums[i]) + 1);
				mn = Math.min(mn, nums[i]);
				mx = Math.max(mx, nums[i]);
			}
			int ans = 0;
			for (int i = 0; i < nums.length; i++) {
				int temp = nums[i] - 1;
				if (hm.containsKey(temp)) {
					int sum = hm.get(nums[i]) + hm.get(temp);
					ans = Math.max(sum, ans);
				}
			}
			return ans;
		}

		/*
		 * Question 4
		 * You have a long flowerbed in which some of the plots are planted, and some
		 * are not. However, flowers cannot be planted in adjacent plots. Given an
		 * integer array flowerbed containing 0's and 1's, where 0 means empty and 1
		 * means not empty, and an integer n, return true if n new flowers can be
		 * planted in the flowerbed without violating the no-adjacent-flowers rule and
		 * false otherwise.
		 */
		public boolean Question4(int[] nums, int n) {
			int count = 0;
			if (n == 0) {
				return true;
			}
			if (nums.length == 1) {
				if (nums[0] == 0) {
					if (n <= 1) {
						return true;
					}
				}
				return false;
			}
			if (nums[0] == 0) {
				if (nums[1] != 1) {
					count++;
					nums[0] = 1;
				}
			}
			for (int i = 1; i < nums.length - 1; i++) {
				if (nums[i] == 0) {
					if (nums[i + 1] != 1 && nums[i - 1] != 1) {
						count++;
						nums[i] = 1;
					}
				}
			}
			if (nums[nums.length - 1] == 0) {
				if (nums[nums.length - 2] != 1) {
					count++;
				}
			}
			if (count >= n) {
				return true;
			}
			return false;
		}

		/*
		 * Question 5
		 * Given an integer array nums, find three numbers whose product is maximum and
		 * return the maximum product.
		 */
		public int Question5(int[] nums) {
			Arrays.sort(nums);
			int case1 = nums[0] * nums[1] * nums[nums.length - 1];
			int case2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
			return Math.max(case1, case2);
		}

		/*
		 * Question 6
		 * Given an array of integers nums which is sorted in ascending order, and an
		 * integer target, write a function to search target in nums. If target exists,
		 * then return its index. Otherwise, return -1.
		 * 
		 */
		public int Question6(int[] nums, int target) {
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

		/*
		 * Question 7
		 * An array is monotonic if it is either monotone increasing or monotone
		 * decreasing.
		 * 
		 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
		 * An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
		 */
		public boolean Question7(int[] nums) {
			boolean increasing = false, decreasing = false;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > nums[i - 1]) {
					increasing = true;
				} else if (nums[i] < nums[i - 1]) {
					decreasing = true;
				}
			}
			boolean result = (increasing && decreasing) ? false : true;
			return result;
		}

		/*
		 * Question 8
		 * You are given an integer array nums and an integer k.
		 * 
		 * In one operation, you can choose any index i where 0 <= i < nums.length and
		 * change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
		 * You can apply this operation at most once for each index i.
		 */
		public int Question8(int[] nums, int k) {
			int mn = Integer.MAX_VALUE;
			int mx = Integer.MIN_VALUE;
			for (int i : nums) {
				mn = Math.min(mn, i);
				mx = Math.max(mx, i);
			}
			int ans = (mx - k) - (mn + k);
			return Math.max(0, ans);
		}

	}
}
